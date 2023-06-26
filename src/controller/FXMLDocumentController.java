package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import utils.login;


public class FXMLDocumentController implements login {

    private LibraryFX main;

    
    public void setMain(LibraryFX main) {
        this.main = main;

    }

    @FXML
    private Label label;

    @FXML
    private TextField usernametxt;

    @FXML
    private PasswordField passtxt;

    @FXML
    private Button loginBtn;

    @FXML
    private Button signupBtn;

    @FXML
    private Label errorLabel;

    @FXML
    private Button closeBtn;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    public void exit(ActionEvent event) throws IOException {
        closeBtn.setOnAction(e -> Platform.exit());
    }

    
@FXML
public void signupScene(ActionEvent event)throws IOException{
Parent view3=FXMLLoader.load(getClass().getResource("/view/SignUp.fxml"));
                Scene scene3=new Scene(view3);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene3);
                window.show();
}   

    @FXML
    public void signin(ActionEvent event) throws IOException {
         String[] unauthorizedUsers = {"user1", "user2", "user3"};
         String username = usernametxt.getText().trim();
            String password = passtxt.getText().trim();
         if (Arrays.asList(unauthorizedUsers).contains(username)) {
            Platform.runLater(() -> {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Unauthorized Access");
                alert.setHeaderText(null);
                alert.setContentText("The following user is not authorized to login");
                alert.showAndWait();
            });
        } else {
            Connectivity connect = new Connectivity();
            try {
                Connection con = connect.ConnectDb();
    
                if (username.isEmpty() || password.isEmpty()) {
                    errorLabel.setText("Please enter your username and password");
                } else {
    
                    PreparedStatement ps = con.prepareStatement("select * from admins where username=?"
                            + " and password=?");
    
                    ps.setString(1, usernametxt.getText().trim());
                    ps.setString(2, passtxt.getText().trim());
    
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                         Parent view3=FXMLLoader.load(this.getClass().getResource("/view/Dashboard.fxml"));
                    Scene scene3=new Scene(view3);
                    Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(scene3);
                   window.show();
                    } else {
                        errorLabel.setText("Invalid credentials. Please try again");
                    }
                }
            } catch (Exception ex) {
                System.out.println("error" + ex.toString());
            }
        }

       

    }



}
