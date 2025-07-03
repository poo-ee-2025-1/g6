import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML private TextField loginField;
    @FXML private PasswordField senhaField;
    @FXML private Button entrarButton;
    @FXML private Label statusLabel;
    private ClienteDAO clienteDAO = ClienteDAO.getInstance();
    @FXML
    protected void loginAction(ActionEvent event) {
        String login = loginField.getText();
        String senha = senhaField.getText();
        if (login.isEmpty() || senha.isEmpty()) {
            statusLabel.setText("Por favor, preencha todos os campos.");
            return;
        }
        Cliente cliente = clienteDAO.buscarPorLogin(login);
        if (cliente != null && cliente.getSenha().equals(senha)) {
            statusLabel.setText("Login realizado com sucesso!");
        } else {
            statusLabel.setText("Login ou senha inválidos.");
        }
    }
    @FXML
    protected void abrirTelaCadastro(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("TelaCadastroCliente.fxml"));
            Stage stage = (Stage) entrarButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Cadastro de Cliente");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText("Erro ao abrir a tela de cadastro.");
        }
    }

}