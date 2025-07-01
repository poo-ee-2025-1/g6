import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class DashboardGerenteController {

    @FXML
    void handleGerenciarOrcamentos(ActionEvent event) {
        Navigation.navigateTo(event, "GerenciarOrcamentos.fxml", "Gerenciar Orçamentos");
    }

    @FXML
    void handleGerenciarInstalacoes(ActionEvent event) {
        Navigation.navigateTo(event, "GerenciarInstalacoes.fxml", "Gerenciar Instalações");
    }

    @FXML
    void handleGerenciarFuncionarios(ActionEvent event) {
        Navigation.navigateTo(event, "GerenciarFuncionarios.fxml", "Gerenciar Funcionários");
    }

    @FXML
    void handleVisualizarManutencoes(ActionEvent event) {
        
        Navigation.navigateTo(event, "VisualizarManutencoes.fxml", "Visualizar Manutenções");
    }
    
    @FXML
    void handleLogout(ActionEvent event) {
        Navigation.navigateTo(event, "TelaLogin.fxml", "Login - Sistema de Energia Solar");
    }
}