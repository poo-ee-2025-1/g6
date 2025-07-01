import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class SolicitarManutencaoController {

    @FXML
    private TextArea descricaoArea;

    private Cliente clienteLogado;
    private ClienteController businessController = new ClienteController();

    // Método para receber os dados do cliente do Dashboard
    public void initData(Cliente cliente) {
        this.clienteLogado = cliente;
    }

    @FXML
    void handleEnviarPedido(ActionEvent event) {
        String descricao = descricaoArea.getText();

        if (descricao == null || descricao.trim().isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Campo Obrigatório", "Por favor, descreva o problema.");
            return;
        }

        // Usa o controller de negócio para criar a solicitação de manutenção
        businessController.solicitarManutencao(clienteLogado, descricao);

        showAlert(Alert.AlertType.INFORMATION, "Sucesso", "Seu pedido de manutenção foi enviado com sucesso!");

        // Volta para o dashboard após a solicitação
        voltarParaDashboard(event);
    }

    @FXML
    void handleVoltar(ActionEvent event) {
        voltarParaDashboard(event);
    }

    private void voltarParaDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DashboardCliente.fxml"));
            Parent root = loader.load();
            DashboardClienteController controller = loader.getController();
            controller.initData(clienteLogado);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Painel do Cliente");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}