import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SolicitarOrcamentoController {

    @FXML private TextField localField;
    @FXML private TextField energiaField;

    private Cliente clienteLogado;
    // Controller de negócio que sabe como salvar os dados corretamente
    private ClienteController businessController = new ClienteController();

    public void initData(Cliente cliente) {
        this.clienteLogado = cliente;
        if (cliente != null) {
            localField.setText(cliente.getEndereco());
            energiaField.setText(String.valueOf(cliente.getEnergiaDesejada()));
        }
    }

    @FXML
    void handleEnviarSolicitacao(ActionEvent event) {
        try {
            String local = localField.getText();
            double energia = Double.parseDouble(energiaField.getText());

            if (local.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Campo Obrigatório", "Por favor, informe o local da instalação.");
                return;
            }

            // **** CORREÇÃO AQUI ****
            // Usamos o businessController para criar o orçamento.
            // Ele irá adicionar o orçamento ao OrcamentoDAO central.
            // Passamos 'null' para funcionário e 0 para valor, pois isso será definido pelo gerente.
            businessController.solicitarOrcamento(clienteLogado, null, 0, energia, local);

            showAlert(Alert.AlertType.INFORMATION, "Sucesso", "Sua solicitação de orçamento foi enviada!");

            voltarParaDashboard(event);

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Erro de Formato", "O campo 'Energia Desejada' deve ser um número.");
        }
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