import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.util.List;

public class GerenciarInstalacoesController {

    @FXML private TableView<Instalacao> instalacoesTable;
    @FXML private TableColumn<Instalacao, String> clienteColumn;
    @FXML private TableColumn<Instalacao, String> enderecoColumn;
    @FXML private TableColumn<Instalacao, LocalDate> dataInicioColumn;
    @FXML private TableColumn<Instalacao, StatusInstalacao> statusAtualColumn;
    @FXML private TableColumn<Instalacao, Funcionario> responsavelColumn;
    @FXML private TableColumn<Instalacao, Void> mudarStatusColumn;

    private InstalacaoDAO instalacaoDAO = InstalacaoDAO.getInstance();
    private FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstance();

    @FXML
    public void initialize() {
        configurarColunas();
        carregarInstalacoes();
    }

    private void configurarColunas() {
        clienteColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCliente().getNome()));
        enderecoColumn.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        dataInicioColumn.setCellValueFactory(new PropertyValueFactory<>("dataInicio"));
        statusAtualColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        responsavelColumn.setCellValueFactory(new PropertyValueFactory<>("responsavel"));
        responsavelColumn.setCellFactory(column -> new TableCell<Instalacao, Funcionario>() {
            @Override
            protected void updateItem(Funcionario item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getNome());
            }
        });

        Callback<TableColumn<Instalacao, Void>, TableCell<Instalacao, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Instalacao, Void> call(final TableColumn<Instalacao, Void> param) {
                return new TableCell<>() {
                    private final ChoiceBox<Object> choiceBox = new ChoiceBox<>();
                    {
                        choiceBox.getItems().add("--- Mudar Status ---");
                        choiceBox.getItems().addAll(StatusInstalacao.values());
                        choiceBox.getItems().add("--- Atribuir Funcionário ---");
                        choiceBox.getItems().addAll(funcionarioDAO.listarFuncionarios());

                        choiceBox.setConverter(new StringConverter<Object>() {
                            @Override
                            public String toString(Object object) {
                                if (object instanceof Funcionario) {
                                    return ((Funcionario) object).getNome();
                                }
                                return object != null ? object.toString() : "";
                            }
                            @Override
                            public Object fromString(String string) { return null; }
                        });

                        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
                            if (newVal != null && getTableRow() != null && getTableRow().getItem() != null) {
                                Instalacao instalacao = getTableRow().getItem();
                                if (newVal instanceof StatusInstalacao) {
                                    instalacao.setStatus((StatusInstalacao) newVal);
                                } else if (newVal instanceof Funcionario) {
                                    instalacao.setFuncionarioResponsavel((Funcionario) newVal);
                                }
                                instalacoesTable.refresh();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            choiceBox.getSelectionModel().clearSelection();
                            setGraphic(choiceBox);
                        }
                    }
                };
            }
        };
        mudarStatusColumn.setCellFactory(cellFactory);
    }

    private void carregarInstalacoes() {
        List<Instalacao> lista = instalacaoDAO.listarInstalacoes();
        ObservableList<Instalacao> instalacoes = FXCollections.observableArrayList(lista);
        instalacoesTable.setItems(instalacoes);
    }

    @FXML
    void handleVoltar(ActionEvent event) {
        Navigation.navigateTo(event, "DashboardGerente.fxml", "Painel Administrativo");
    }
}