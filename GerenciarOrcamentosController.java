import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.time.LocalDate;
import java.util.List;

public class GerenciarOrcamentosController {

    @FXML private TableView<Orcamento> orcamentosTable;
    @FXML private TableColumn<Orcamento, String> clienteColumn;
    @FXML private TableColumn<Orcamento, LocalDate> dataColumn;
    @FXML private TableColumn<Orcamento, Double> valorColumn;
    @FXML private TableColumn<Orcamento, String> statusColumn;
    @FXML private TableColumn<Orcamento, Void> acaoAprovarColumn;
    @FXML private TableColumn<Orcamento, Void> acaoRecusarColumn;
    
    // Pega as instâncias únicas dos DAOs necessários
    private OrcamentoDAO orcamentoDAO = OrcamentoDAO.getInstance();
    private InstalacaoDAO instalacaoDAO = InstalacaoDAO.getInstance();
    
    private Gerente gerente = new Gerente(null, null, null, null, 0, null, 0, "admin", "admin");

    @FXML
    public void initialize() {
        clienteColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCliente().getNome()));
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("dataCriacao"));
        valorColumn.setCellValueFactory(new PropertyValueFactory<>("valorEstimado"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        Callback<TableColumn<Orcamento, Void>, TableCell<Orcamento, Void>> cellFactoryAcoes = new Callback<>() {
            @Override
            public TableCell<Orcamento, Void> call(final TableColumn<Orcamento, Void> param) {
                return new TableCell<>() {
                    private final Button btnAprovar = new Button("Aprovar");
                    private final Button btnRecusar = new Button("Recusar");

                    {
                        btnAprovar.setOnAction((ActionEvent event) -> {
                            Orcamento orcamento = getTableView().getItems().get(getIndex());
                            
                            // **** CORREÇÃO PRINCIPAL AQUI ****
                            // Chama o método atualizado, passando o InstalacaoDAO
                            gerente.aprovarOrcamento(orcamento, instalacaoDAO);
                            
                            orcamentosTable.refresh();
                        });
                        btnRecusar.setOnAction((ActionEvent event) -> {
                            Orcamento orcamento = getTableView().getItems().get(getIndex());
                            gerente.recusarOrcamento(orcamento);
                            orcamentosTable.refresh();
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            Orcamento orcamento = getTableView().getItems().get(getIndex());
                            if ("Pendente".equals(orcamento.getStatus())) {
                                if (param == acaoAprovarColumn) setGraphic(btnAprovar);
                                else if (param == acaoRecusarColumn) setGraphic(btnRecusar);
                            } else {
                                setGraphic(null);
                            }
                        }
                    }
                };
            }
        };

        acaoAprovarColumn.setCellFactory(cellFactoryAcoes);
        acaoRecusarColumn.setCellFactory(cellFactoryAcoes);
        
        carregarOrcamentos();
    }

    private void carregarOrcamentos() {
        List<Orcamento> lista = orcamentoDAO.listarOrcamentos();
        ObservableList<Orcamento> orcamentos = FXCollections.observableArrayList(lista);
        orcamentosTable.setItems(orcamentos);
    }

    @FXML
    void handleVoltar(ActionEvent event) {
        Navigation.navigateTo(event, "DashboardGerente.fxml", "Painel Administrativo");
    }
}