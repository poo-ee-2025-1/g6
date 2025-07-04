import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class DashboardFuncionarioController {

    @FXML private Label welcomeLabel;
    @FXML private TableView<Instalacao> instalacoesTable;
    @FXML private TableColumn<Instalacao, String> clienteColumn;
    @FXML private TableColumn<Instalacao, String> enderecoColumn;
    @FXML private TableColumn<Instalacao, LocalDate> dataInicioColumn;
    @FXML private TableColumn<Instalacao, StatusInstalacao> statusColumn;

    private Funcionario funcionarioLogado;
    private InstalacaoDAO instalacaoDAO = InstalacaoDAO.getInstance();

    @FXML
    public void initialize() {
        clienteColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCliente().getNome()));
        enderecoColumn.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        dataInicioColumn.setCellValueFactory(new PropertyValueFactory<>("dataInicio"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    public void initData(Funcionario funcionario) {
        this.funcionarioLogado = funcionario;
        welcomeLabel.setText("Bem-vindo(a), " + funcionario.getNome() + "!");
        carregarInstalacoes();
    }

    private void carregarInstalacoes() {
        if (funcionarioLogado == null) return;
        List<Instalacao> lista = instalacaoDAO.buscarPorResponsavel(funcionarioLogado);
        instalacoesTable.setItems(FXCollections.observableArrayList(lista));
    }

    /**
     * MÉTODO NOVO: Navega para a tela de manutenções do funcionário.
     */
    @FXML
    void handleMinhasManutencoes(ActionEvent event) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("MinhasManutencoes.fxml"));
            javafx.scene.Parent root = loader.load();
            MinhasManutencoesController controller = loader.getController();
            controller.initData(funcionarioLogado);
            
            javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            javafx.scene.Scene scene = new javafx.scene.Scene(root);
            stage.setScene(scene);
            stage.setTitle("Minhas Manutenções");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleLogout(ActionEvent event) {
        Navigation.navigateTo(event, "TelaLogin.fxml", "Login - Sistema de Energia Solar");
    }
}