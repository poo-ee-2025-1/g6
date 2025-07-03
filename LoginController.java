import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class LoginController {

    @FXML private TextField loginField;
    @FXML private PasswordField senhaField;
    @FXML private Button entrarButton;
    @FXML private Label statusLabel;

    private ClienteDAO clienteDAO = ClienteDAO.getInstance();
    private FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstance();

    @FXML
    protected void loginAction(ActionEvent event) {
        String login = loginField.getText();
        String senha = senhaField.getText();

        if (login.isEmpty() || senha.isEmpty()) {
            statusLabel.setText("Por favor, preencha todos os campos.");
            return;
        }

        Funcionario funcionario = funcionarioDAO.buscarPorLogin(login);
        if (funcionario != null && funcionario.getSenha().equals(senha)) {
            statusLabel.setText("Login de funcionário bem-sucedido!");
            
            if (funcionario instanceof Gerente) {
                Navigation.navigateTo(event, "DashboardGerente.fxml", "Painel Administrativo");
            } else {
                navegarParaDashboardFuncionario(event, funcionario);
            }
            return; 
        }

        Cliente cliente = clienteDAO.buscarPorLogin(login);
        if (cliente != null && cliente.getSenha().equals(senha)) {
            statusLabel.setText("Login de cliente bem-sucedido!");
            navegarParaDashboardCliente(event, cliente);
        } else {
            statusLabel.setText("Login ou senha inválidos.");
        }
    }

    private void navegarParaDashboardCliente(ActionEvent event, Cliente cliente) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DashboardCliente.fxml"));
            Parent root = loader.load();
            DashboardClienteController controller = loader.getController();
            controller.initData(cliente);

            Stage stage = (Stage) entrarButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Painel do Cliente");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText("Erro ao carregar o painel do cliente.");
        }
    }
    
    private void navegarParaDashboardFuncionario(ActionEvent event, Funcionario funcionario) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DashboardFuncionario.fxml"));
            Parent root = loader.load();
            DashboardFuncionarioController controller = loader.getController();
            controller.initData(funcionario);

            Stage stage = (Stage) entrarButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Painel do Funcionário");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText("Erro ao carregar o painel do funcionário.");
        }
    }

    /**
     * MÉTODO CORRIGIDO
     */
    @FXML
    protected void abrirTelaCadastro(ActionEvent event) {
        // CORREÇÃO: O nome do arquivo foi ajustado para "TelaCadastroCliente.fxml"
        Navigation.navigateTo(event, "TelaCadastroCliente.fxml", "Cadastro de Cliente");
    }
}