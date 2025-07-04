import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;

public class MinhasManutencoesController {

    @FXML private TableView<Manutencao> manutencoesTable;
    @FXML private TableColumn<Manutencao, String> clienteColumn;
    @FXML private TableColumn<Manutencao, LocalDate> dataColumn;
    @FXML private TableColumn<Manutencao, String> descricaoColumn;
    @FXML private TableColumn<Manutencao, Boolean> statusColumn;

    private Funcionario funcionarioLogado;
    private ManutencaoDAO manutencaoDAO = ManutencaoDAO.getInstance();

    @FXML
    public void initialize() {
        clienteColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCliente().getNome()));
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("dataSolicitacao"));
        descricaoColumn.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("resolvido"));
        statusColumn.setCellFactory(c -> new TableCell<Manutencao, Boolean>() {
            @Override
            protected void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : (item ? "Resolvido" : "Pendente"));
            }
        });
    }

    public void initData(Funcionario funcionario) {
        this.funcionarioLogado = funcionario;
        manutencoesTable.setItems(FXCollections.observableArrayList(manutencaoDAO.buscarPorResponsavel(funcionarioLogado)));
    }
    
    @FXML
    void handleVoltar(ActionEvent event) {
        // A navegação de volta para o Dashboard do funcionário precisa passar os dados de volta
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("DashboardFuncionario.fxml"));
            javafx.scene.Parent root = loader.load();
            DashboardFuncionarioController controller = loader.getController();
            controller.initData(funcionarioLogado);
            
            javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            javafx.scene.Scene scene = new javafx.scene.Scene(root);
            stage.setScene(scene);
            stage.setTitle("Painel do Funcionário");
            stage.show();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}