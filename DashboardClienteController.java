import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;

public class DashboardClienteController {

    @FXML
    private Label welcomeLabel;
    
    private Cliente clienteLogado;

    public void initData(Cliente cliente) {
        this.clienteLogado = cliente;
        welcomeLabel.setText("Bem-vindo(a), " + clienteLogado.getNome() + "!");
    }

    @FXML
    void handleSolicitarOrcamento(ActionEvent event) {
        navegarPara(event, "SolicitarOrcamento.fxml", "Solicitar Orçamento");
    }

    @FXML
    void handleMeusOrcamentos(ActionEvent event) {
        navegarPara(event, "MeusOrcamentos.fxml", "Meus Orçamentos");
    }

    @FXML
    void handleAcompanharInstalacao(ActionEvent event) {
        navegarPara(event, "AcompanharInstalacao.fxml", "Acompanhar Instalação");
    }

    
    @FXML
    void handleSolicitarManutencao(ActionEvent event) {
        navegarPara(event, "SolicitarManutencao.fxml", "Solicitar Manutenção");
    }

    @FXML
    void handleLogout(ActionEvent event) {
        Navigation.navigateTo(event, "TelaLogin.fxml", "Login - Sistema de Energia Solar");
    }

    
    private void navegarPara(ActionEvent event, String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            
            if (loader.getController() instanceof SolicitarOrcamentoController) {
                ((SolicitarOrcamentoController) loader.getController()).initData(clienteLogado);
            } else if (loader.getController() instanceof MeusOrcamentosController) {
                ((MeusOrcamentosController) loader.getController()).initData(clienteLogado);
            } else if (loader.getController() instanceof AcompanharInstalacaoController) {
                ((AcompanharInstalacaoController) loader.getController()).initData(clienteLogado);
            } else if (loader.getController() instanceof SolicitarManutencaoController) {
                ((SolicitarManutencaoController) loader.getController()).initData(clienteLogado);
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