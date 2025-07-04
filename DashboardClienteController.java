import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent; // Importa a classe MouseEvent
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class DashboardClienteController {

    @FXML
    private Label welcomeLabel;
    
    private Cliente clienteLogado;

    public void initData(Cliente cliente) {
        this.clienteLogado = cliente;
        if (cliente != null) {
            welcomeLabel.setText("Bem-vindo(a), " + clienteLogado.getNome() + "!");
        }
    }

    @FXML
    void handleSolicitarOrcamento(MouseEvent event) {
        navegarParaComDados(event, "SolicitarOrcamento.fxml", "Solicitar Orçamento");
    }

    @FXML
    void handleMeusOrcamentos(MouseEvent event) {
        navegarParaComDados(event, "MeusOrcamentos.fxml", "Meus Orçamentos");
    }

    // --- CORREÇÃO AQUI ---
    @FXML
    void handleAcompanharInstalacao(MouseEvent event) {
        navegarParaComDados(event, "AcompanharInstalacao.fxml", "Acompanhar Instalação");
    }
    
    @FXML
    void handleSolicitarManutencao(MouseEvent event) {
        navegarParaComDados(event, "SolicitarManutencao.fxml", "Solicitar Manutenção");
    }

    // O Logout vem de um botão, então ActionEvent está correto e usa a classe Navigation.
    @FXML
    void handleLogout(ActionEvent event) {
        Navigation.navigateTo(event, "TelaLogin.fxml", "Login - Sistema de Energia Solar");
    }
    
    /**
     * Método ATUALIZADO para navegar e passar os dados do cliente para a próxima tela.
     * Funciona com MouseEvent vindo dos cards.
     */
    private void navegarParaComDados(MouseEvent event, String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            // Lógica para injetar os dados do cliente no controller da próxima tela
            Object controller = loader.getController();
            if (controller instanceof SolicitarOrcamentoController) {
                ((SolicitarOrcamentoController) controller).initData(clienteLogado);
            } else if (controller instanceof MeusOrcamentosController) {
                ((MeusOrcamentosController) controller).initData(clienteLogado);
            } else if (controller instanceof AcompanharInstalacaoController) {
                ((AcompanharInstalacaoController) controller).initData(clienteLogado);
            } else if (controller instanceof SolicitarManutencaoController) {
                ((SolicitarManutencaoController) controller).initData(clienteLogado);
            }

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            System.err.println("FALHA AO CARREGAR: " + fxmlFile);
            e.printStackTrace();
        }
    }
}