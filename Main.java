package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main extends Application {

    private static long timeout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("СпэйсЧат");
        primaryStage.setScene(new Scene(root, 450, 350));
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception {
        launch(args);}
}
