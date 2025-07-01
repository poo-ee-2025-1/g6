import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Navigation {

    public static void navigateTo(ActionEvent event, String fxmlFile, String title) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(Navigation.class.getResource(fxmlFile)));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title); // Define o novo título da janela
            stage.show();

        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo FXML: " + fxmlFile);
            e.printStackTrace();
        }
    }
}