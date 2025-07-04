import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.util.List;

public class VisualizarManutencoesController {

    @FXML private TableView<Manutencao> manutencoesTable;
    @FXML private TableColumn<Manutencao, String> clienteColumn;
    @FXML private TableColumn<Manutencao, LocalDate> dataColumn;
    @FXML private TableColumn<Manutencao, String> descricaoColumn;
    @FXML private TableColumn<Manutencao, Boolean> statusColumn;
    @FXML private TableColumn<Manutencao, Funcionario> responsavelColumn;
    @FXML private TableColumn<Manutencao, Void> acaoColumn;

    private ManutencaoDAO manutencaoDAO = ManutencaoDAO.getInstance();
    private FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstance();

    @FXML
    public void initialize() {
        clienteColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCliente().getNome()));
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("dataSolicitacao"));
        descricaoColumn.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        
        responsavelColumn.setCellValueFactory(new PropertyValueFactory<>("responsavel"));
        responsavelColumn.setCellFactory(column -> new TableCell<Manutencao, Funcionario>() {
            @Override
            protected void updateItem(Funcionario item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "N/A" : item.getNome());
            }
        });

        statusColumn.setCellValueFactory(new PropertyValueFactory<>("resolvido"));
        statusColumn.setCellFactory(column -> new TableCell<Manutencao, Boolean>() {
            @Override
            protected void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : (item ? "Resolvido" : "Pendente"));
            }
        });

        Callback<TableColumn<Manutencao, Void>, TableCell<Manutencao, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Manutencao, Void> call(final TableColumn<Manutencao, Void> param) {
                return new TableCell<>() {
                    private final ChoiceBox<Object> choiceBox = new ChoiceBox<>();
                    {
                        choiceBox.getItems().add("--- Ações ---");
                        choiceBox.getItems().add("Marcar como Resolvido");
                        choiceBox.getItems().add("--- Atribuir Funcionário ---");
                        choiceBox.getItems().addAll(funcionarioDAO.listarFuncionarios());

                        choiceBox.setConverter(new StringConverter<Object>() {
                            @Override public String toString(Object object) {
                                if (object instanceof Funcionario) return ((Funcionario) object).getNome();
                                if (object == null) return "";
                                return object.toString();
                            }
                            @Override public Object fromString(String string) { return null; }
                        });

                        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
                            if (newVal != null && getTableRow() != null && getTableRow().getItem() != null) {
                                Manutencao manutencao = getTableRow().getItem();
                                if (newVal instanceof Funcionario) {
                                    manutencao.setResponsavel((Funcionario) newVal);
                                } else if ("Marcar como Resolvido".equals(newVal)) {
                                    manutencao.setResolvido(true);
                                }
                                manutencoesTable.refresh();
                            }
                        });
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || getTableView().getItems().get(getIndex()).isResolvido()) {
                            setGraphic(null);
                        } else {
                            choiceBox.getSelectionModel().clearSelection();
                            setGraphic(choiceBox);
                        }
                    }
                };
            }
        };
        acaoColumn.setCellFactory(cellFactory);
        
        carregarManutencoes();
    }

    private void carregarManutencoes() {
        manutencoesTable.setItems(FXCollections.observableArrayList(manutencaoDAO.listarManutencoes()));
    }

    @FXML
    void handleVoltar(ActionEvent event) {
        Navigation.navigateTo(event, "DashboardGerente.fxml", "Painel Administrativo");
    }
}