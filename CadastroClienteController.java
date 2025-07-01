import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CadastroClienteController {

    @FXML private TextField nomeField;
    @FXML private TextField cpfField;
    @FXML private TextField emailField;
    @FXML private TextField telefoneField;
    @FXML private TextField enderecoField;
    @FXML private TextField loginField;
    @FXML private PasswordField senhaField;
    @FXML private TextField energiaField;

    private ClienteController businessController = new ClienteController();

    @FXML
    protected void cadastrarAction(ActionEvent event) {
        System.out.println("Botão CADASTRAR clicado."); // Mensagem de teste
        try {
            if (nomeField.getText().isEmpty() || cpfField.getText().isEmpty()) {
               showAlert(AlertType.WARNING, "Campos Obrigatórios", "Por favor, preencha pelo menos Nome e CPF.");
               return;
            }
            
            double energia = 0.0;
            if (!energiaField.getText().isEmpty()) {
                energia = Double.parseDouble(energiaField.getText());
            }

            Cliente novoCliente = new Cliente(
                nomeField.getText(), 
                cpfField.getText(), 
                emailField.getText(), 
                telefoneField.getText(), 
                enderecoField.getText(), 
                loginField.getText(), 
                senhaField.getText(), 
                energia
            );
            businessController.cadastrarCliente(novoCliente);

            showAlert(AlertType.INFORMATION, "Sucesso", "Cliente cadastrado com sucesso!");
            
            Navigation.navigateTo(event, "TelaLogin.fxml", "Login");

        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Erro de Formato", "Energia Desejada precisa ser um número.");
        } catch (Exception e) {
            showAlert(AlertType.ERROR, "Erro Inesperado", "Ocorreu um erro ao cadastrar.");
            e.printStackTrace();
        }
    }

    @FXML
    protected void voltarAction(ActionEvent event) {
        System.out.println("Botão VOLTAR clicado."); // Mensagem de teste
        Navigation.navigateTo(event, "TelaLogin.fxml", "Login");
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}