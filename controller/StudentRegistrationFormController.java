package lk.royalIstitute.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentRegistrationFormController {
    public AnchorPane root;
    public JFXTextField txtStudentID;
    public JFXDatePicker dtAddedDate;
    public JFXTextField txtName;
    public JFXDatePicker dtDOB;
    public RadioButton rabMale;
    public RadioButton rabFemale;
    public JFXTextField txtAddress;
    public JFXTextField txtMobileNumber;
    public JFXComboBox cmbTrainingProgram;
    public JFXTextField txtProgramID;
    public JFXTextField txtDuration;
    public JFXTextField txtFee;
    public JFXButton btnAddProgram;
    public JFXTextField txtTotalFee;
    public JFXButton btnRemoveProgram;
    public JFXButton btnRegister;
    public TableView tblProgram;
    public TableColumn colProgramID;
    public TableColumn colProgram;
    public TableColumn colDuration;
    public TableColumn colFee;
    public JFXButton btnhome;

    public void cmdSelectProgram(ActionEvent actionEvent) {
    }

    public void btnAddProgram(ActionEvent actionEvent) {
    }

    public void btnRemoveProgram(ActionEvent actionEvent) {
    }

    public void btnRegister(ActionEvent actionEvent) {
    }

    public void btnhomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/MainForm.fxml"))));
    }
}
