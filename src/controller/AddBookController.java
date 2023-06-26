package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.observer;
import utils.subject;


public class AddBookController implements Initializable,subject {
    private List<observer> observers = new ArrayList<>();
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private Button backBtn;

    @FXML
    private TextField btitleTxt;

    @FXML
    private TextField bcodeTxt;

    @FXML
    private TextField bpriceTxt;

    @FXML
    private TextField bcategoryTxt;

    @FXML
    private TextField bpublisherTxt;

    @FXML
    private TextField beditionTxt;

    @FXML
    private Button addbookBtn;

    @FXML
    private Label msgLabel;


    @FXML
    void addBook(ActionEvent event) throws IOException {
        ResultSet rs;
        PreparedStatement ps;
        Connectivity connect = new Connectivity();
        try {

            Connection con = connect.ConnectDb();

            String title = btitleTxt.getText().trim();
            String bcode = bcodeTxt.getText().trim();
            String price = bpriceTxt.getText().trim();
            String category = bcategoryTxt.getText().trim();
            String publisher = bpublisherTxt.getText().trim();
            String edition = beditionTxt.getText().trim();

            if (category.isEmpty() || publisher.isEmpty() || title.isEmpty() || bcode.isEmpty() || price.isEmpty() || edition.isEmpty()) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Library Error");
                alert.setHeaderText("Add Book Error!");
                alert.setContentText("Complete all the fields to insert a book to the system.");

                alert.showAndWait();
            } else {

                String sql2 = "insert into books (booktitle,bookid,price,categ,publishers,edition) value (?,?,?,?,?,?)";
                ps = con.prepareStatement(sql2);

                ps.setString(1, btitleTxt.getText().trim());
                ps.setString(2, bcodeTxt.getText().trim());
                ps.setString(3, bpriceTxt.getText().trim());
                ps.setString(4, bcategoryTxt.getText().trim());
                ps.setString(5, bpublisherTxt.getText().trim());
                ps.setString(6, beditionTxt.getText().trim());

                ps.execute();
                showPopup();
                notifyObservers("New book added to database:");
                

            }

        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

     @FXML
    public void backtoDashboard(ActionEvent event) throws IOException {
        Parent view3 = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
        Scene scene3 = new Scene(view3);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene3);
        window.show();
    }
   
    
       
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void attach(observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (observer observer : observers) {
            observer.update(message);
        };
    }
    public void showPopup() {
        observer popup = new observer() {
            @Override
            public void update(String message) {
                Platform.runLater(() -> {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("New Book Added");
                    alert.setHeaderText(null);
                    alert.setContentText(message);
                    alert.showAndWait();
                });
            }
        };
        attach(popup);
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

}
