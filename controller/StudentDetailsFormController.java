package lk.royalIstitute.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentDetailsFormController {


    public TableView tblStudent;
    public TableColumn coladdress;
    public TableColumn colcontact;
    public TableColumn colstudentid;
    public TableColumn colregno;
    public TableColumn colsname;
    public TableColumn colpname;
    public TableColumn colgender;
    public JFXComboBox cmbCourse;
    public JFXButton btnhome;
    public AnchorPane root;
    public Button btngetAll;
    public void initialize() throws Exception{

    }


    public void saveOnAction(ActionEvent actionEvent) throws Exception {

    }


    public void homeOnAction(ActionEvent actionEvent) throws IOException {
       Stage stage= (Stage) root.getScene().getWindow();
       stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/MainForm.fxml"))));
    }

    public void btngetAllOnAction(ActionEvent actionEvent) {
    }

    public void cmbCourseOnAction(ActionEvent actionEvent) {
    }
}
