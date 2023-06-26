package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class DashboardController implements Initializable {
   private double xOffset = 0;
    private double yOffset = 0;

     @FXML
    private Button logoutBtn;

    @FXML
    private Button addBookBtn;

    @FXML
    private Button addStudentBtn;

    @FXML
    private Button issueBookBtn;

    @FXML
    private Button returnBookBtn;

    @FXML
    private Button statisticsBtn;

    
     @FXML
    void backLogin(ActionEvent event) throws IOException {
       Parent view6=FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));
                Scene scene6=new Scene(view6);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene6);
                window.show();
     
    }
    
    @FXML
    void addBook(ActionEvent event) throws IOException {
       Parent view6=FXMLLoader.load(getClass().getResource("/view/AddBook.fxml"));
                Scene scene6=new Scene(view6);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene6);
                window.show();
     
    }
    
     @FXML
    void addStudent(ActionEvent event) throws IOException {
       Parent view6=FXMLLoader.load(getClass().getResource("/view/AddStudent.fxml"));
                Scene scene6=new Scene(view6);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene6);
                window.show();
     
    }
    
     @FXML
    void issueBook(ActionEvent event) throws IOException {
       Parent view6=FXMLLoader.load(getClass().getResource("/view/IssueBook.fxml"));
                Scene scene6=new Scene(view6);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene6);
                window.show();
     
    }
    
     @FXML
    void returnBook(ActionEvent event) throws IOException {
       Parent view6=FXMLLoader.load(getClass().getResource("/view/ReturnBook.fxml"));
                Scene scene6=new Scene(view6);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene6);
                window.show();
     
    }
    
     @FXML
    void checkStatistics(ActionEvent event) throws IOException {
       Parent view6=FXMLLoader.load(getClass().getResource("/view/BookStatistics.fxml"));
                Scene scene6=new Scene(view6);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene6);
                window.show();
     
    }
    @FXML
    void checkCredits(ActionEvent event) throws IOException {
       Parent view6=FXMLLoader.load(getClass().getResource("/view/Credits.fxml"));
                Scene scene6=new Scene(view6);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene6);
                window.show();
     
    }
    @FXML
private void onMousePressed(MouseEvent event) {
    xOffset = event.getSceneX();
    yOffset = event.getSceneY();
}

@FXML
private void onMouseDragged(MouseEvent event) {
    Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    stage.setX(event.getScreenX() - xOffset);
    stage.setY(event.getScreenY() - yOffset);
}

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
