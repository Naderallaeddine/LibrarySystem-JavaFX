package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.IssuedBooks;
import model.ReturnedBooks;
import utils.LibraryElement;
import utils.LibraryVisitor;

public class StatisticsController implements Initializable,LibraryElement {
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private TableView<IssuedBooks> issuedBooksTable;

    @FXML
    private TableColumn<IssuedBooks, String> booktitle;

    @FXML
    private TableColumn<IssuedBooks, Integer> bookId;

    @FXML
    private TableColumn<IssuedBooks, Integer> price;

    @FXML
    private TableColumn<IssuedBooks, String> category;

    @FXML
    private TableColumn<IssuedBooks, String> publishers;

    @FXML
    private TableColumn<IssuedBooks, String> edition;

    @FXML
    private TableView<ReturnedBooks> returnedBooksTable;

    @FXML
    private TableColumn<ReturnedBooks, String> studentName;

    @FXML
    private TableColumn<ReturnedBooks, Integer> studentID;

    @FXML
    private TableColumn<ReturnedBooks, Integer> studentyYear;

    @FXML
    private TableColumn<ReturnedBooks, String> studentMajor;

    @FXML
    private TableColumn<ReturnedBooks, String> studentDepartment;

    @FXML
    private TableColumn<ReturnedBooks, String> bookTitle;

    @FXML
    private TableColumn<ReturnedBooks, Integer> bookCode;

    @FXML
    private TableColumn<ReturnedBooks, Date> dateReturned;

    @FXML
    private Button goBackbtn;

    @FXML
    private Button checkReturnedBook;

    ObservableList<IssuedBooks> issued = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Connection conn = Connectivity.ConnectDb();
        try {
            ResultSet rs = conn.createStatement().executeQuery("select booktitle,bookId,price,category,publishers,edition from issued");

            while (rs.next()) {
                issued.add(new IssuedBooks(rs.getString("booktitle"), rs.getString("category"), rs.getString("publishers"), rs.getString("edition"), rs.getInt("bookId"), rs.getInt("price")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(StatisticsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        booktitle.setCellValueFactory(new PropertyValueFactory<>("booktitle"));
        bookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        publishers.setCellValueFactory(new PropertyValueFactory<>("publishers"));
        edition.setCellValueFactory(new PropertyValueFactory<>("edition"));

        issuedBooksTable.setItems(issued);

    }

    @FXML
    public void backto(ActionEvent event) throws IOException {
        Parent view3 = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
        Scene scene3 = new Scene(view3);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene3);
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
    public void accept(LibraryVisitor visitor) {
      visitor.visit(this);
    }

}
