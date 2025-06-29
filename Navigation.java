import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Navigation {

    /**
     * Método reutilizável para trocar a cena atual em uma janela.
     *
     * @param event    O evento de ação (de um botão ou link) que disparou a mudança.
     * @param fxmlFile O nome do arquivo FXML para o qual se quer navegar.
     */
    public static void navigateTo(ActionEvent event, String fxmlFile) {
        try {
            // Carrega o FXML da nova tela
            Parent root = FXMLLoader.load(Objects.requireNonNull(Navigation.class.getResource(fxmlFile)));

            // Pega a janela (Stage) atual a partir do componente que gerou o evento
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cria a nova cena
            Scene scene = new Scene(root);

            // Define a nova cena na janela
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo FXML: " + fxmlFile);
            e.printStackTrace();
        }
    }
}