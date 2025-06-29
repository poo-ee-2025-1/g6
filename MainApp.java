import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Mude o arquivo FXML a ser carregado para a tela de login
            Parent root = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
            
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Login - Sistema de Energia Solar");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}