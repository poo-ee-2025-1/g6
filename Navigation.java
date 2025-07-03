import javafx.event.ActionEvent;
import javafx.event.Event; // Importa a classe Event
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent; // Importa a classe MouseEvent

import java.io.IOException;
import java.util.Objects;

public class Navigation {

    /**
     * Método de navegação genérico que funciona com qualquer tipo de evento.
     * @param event O evento que disparou a navegação (pode ser ActionEvent, MouseEvent, etc.).
     * @param fxmlFile O nome do arquivo FXML para o qual navegar.
     * @param title O título da nova janela.
     */
    public static void navigateTo(Event event, String fxmlFile, String title) {
        try {
            // Valida que o recurso não é nulo antes de carregar
            Parent root = FXMLLoader.load(Objects.requireNonNull(Navigation.class.getResource(fxmlFile)));
            
            // Pega a janela (Stage) a partir da origem do evento
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();

        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo FXML: " + fxmlFile);
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Erro: Não foi possível encontrar o arquivo FXML: " + fxmlFile);
            e.printStackTrace();
        }
    }
}