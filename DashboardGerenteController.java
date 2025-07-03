import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent; // Importa a classe MouseEvent

public class DashboardGerenteController {

    // CORREÇÃO: O parâmetro agora é MouseEvent
    @FXML
    void handleGerenciarOrcamentos(MouseEvent event) {
        Navigation.navigateTo(event, "GerenciarOrcamentos.fxml", "Gerenciar Orçamentos");
    }

    @FXML
    void handleGerenciarInstalacoes(MouseEvent event) {
        Navigation.navigateTo(event, "GerenciarInstalacoes.fxml", "Gerenciar Instalações");
    }

    @FXML
    void handleGerenciarFuncionarios(MouseEvent event) {
        Navigation.navigateTo(event, "GerenciarFuncionarios.fxml", "Gerenciar Funcionários");
    }

    @FXML
    void handleVisualizarManutencoes(MouseEvent event) {
        Navigation.navigateTo(event, "VisualizarManutencoes.fxml", "Visualizar Manutenções");
    }
    
    // O Logout continua usando ActionEvent, o que está correto
    @FXML
    void handleLogout(ActionEvent event) {
        Navigation.navigateTo(event, "TelaLogin.fxml", "Login - Sistema de Energia Solar");
    }
}