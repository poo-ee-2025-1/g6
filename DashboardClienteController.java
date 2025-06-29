import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DashboardClienteController {

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button logoutButton;
    
    private Cliente clienteLogado;

    /**
     * Este método é usado para passar os dados do cliente logado
     * da tela de login para este controller.
     */
    public void initData(Cliente cliente) {
        clienteLogado = cliente;
        welcomeLabel.setText("Bem-vindo(a), " + clienteLogado.getNome() + "!");
    }

    @FXML
    void handleSolicitarOrcamento(ActionEvent event) {
        System.out.println("Navegando para a tela de solicitar orçamento...");
        // Navigation.navigateTo(event, "SolicitarOrcamento.fxml"); // Futura implementação
    }

    @FXML
    void handleMeusOrcamentos(ActionEvent event) {
        System.out.println("Navegando para a tela de meus orçamentos...");
        // Navigation.navigateTo(event, "MeusOrcamentos.fxml"); // Futura implementação
    }

    @FXML
    void handleAcompanharInstalacao(ActionEvent event) {
        System.out.println("Navegando para a tela de acompanhar instalação...");
        // Navigation.navigateTo(event, "AcompanharInstalacao.fxml"); // Futura implementação
    }

    @FXML
    void handleSolicitarManutencao(ActionEvent event) {
        System.out.println("Navegando para a tela de solicitar manutenção...");
        // Navigation.navigateTo(event, "SolicitarManutencao.fxml"); // Futura implementação
    }

    @FXML
    void handleLogout(ActionEvent event) {
        System.out.println("Usuário " + clienteLogado.getNome() + " deslogado.");
        Navigation.navigateTo(event, "TelaLogin.fxml");
    }
}