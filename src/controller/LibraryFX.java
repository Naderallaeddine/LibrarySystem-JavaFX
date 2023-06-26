package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class LibraryFX extends Application {
    
    private Stage primaryStage;
    private double xOffset = 0;
    private double yOffset = 0;

   

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage; 
        
        mainWindow();
    }

    public void mainWindow() {
        try {
            
            FXMLLoader loader = new FXMLLoader(LibraryFX.class.getResource("/view/FXMLDocument.fxml"));
            AnchorPane pane = loader.load();
            pane.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });
    
            pane.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            });

            
            FXMLDocumentController mainWindowController = loader.getController();
            mainWindowController.setMain(this);

            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
