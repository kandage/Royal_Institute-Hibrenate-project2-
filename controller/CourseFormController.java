package lk.royalIstitute.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.royalIstitute.bo.BOFactory;
import lk.royalIstitute.bo.custom.CourseBO;
import lk.royalIstitute.dto.CourseDTO;
import lk.royalIstitute.view.tm.Coursetm;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class CourseFormController implements Initializable {
    public JFXTextField txtcode;
    public JFXTextField txtcoursename;
    public JFXTextField txtduration;
    public JFXTextField txtsearch;
    public TableView <Coursetm> tblcourse;
    public TableColumn <Coursetm, String> colcode;
    public TableColumn <Coursetm, String> colcoursename;
    public TableColumn <Coursetm, String> colduration;
    public TableColumn <Coursetm, Double>colcoursefee;
    public JFXButton btnsave;
    public JFXButton btnhome;
    public AnchorPane root;
    public JFXTextField txtcoursefee;
    public JFXButton btnRemoveProgram;
    ObservableList<Coursetm> coursetms = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        makeTable();
       /* loadAllPrograms();*/

    }
    private void makeTable() {
        colcode.setCellValueFactory(new PropertyValueFactory<>("Code"));
        colcoursename.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        colduration.setCellValueFactory(new PropertyValueFactory<>("Duration"));
        colcoursefee.setCellValueFactory(new PropertyValueFactory<>("CourseFee"));
        tblcourse.setItems(coursetms);
    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws Exception {
        CourseDTO courseDTO = makeCourseDTO();
        Coursetm coursetm = makeCoursetm(courseDTO);
        CourseBO courseBO = (CourseBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOType.Course);
        try {
            boolean saved = courseBO.addCourse(courseDTO);
            if (saved) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Course");
                alert.setHeaderText(null);
                alert.setContentText("Course Saved successfully !");
                alert.showAndWait();
                coursetms.add(coursetm);
                tblcourse.refresh();
                clearFields();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Course Save Failed");
                alert.setHeaderText(null);
                alert.setContentText("Please Check the Values !");
                alert.showAndWait();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    private void clearFields() {
        txtcode.clear();
        txtcoursename.clear();
        txtduration.clear();
        txtcoursefee.clear();
    }

    private CourseDTO makeCourseDTO() {
        return new CourseDTO(
                txtcode.getText(),
                txtcoursename.getText(),
                txtduration.getText(),
                Double.parseDouble(txtcoursefee.getText()));
    }
    private Coursetm makeCoursetm(CourseDTO courseDTO) {
        return new Coursetm(
                courseDTO.getCode(),
                courseDTO.getCourseName(),
                courseDTO.getDuration(),
                courseDTO.getCourseFee());
    }
    private void loadAllPrograms() {
        CourseBO courseBO = (CourseBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOType.Course);
        try {
            List<CourseDTO> allCoursesDTOs = courseBO.getAll();
            for (CourseDTO courseDTO :
                    allCoursesDTOs) {
                coursetms.add(makeCoursetm(courseDTO));
            }
            tblcourse.refresh();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public void btnhomeOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/MainForm.fxml"))));
    }

    public void removeProgram(ActionEvent actionEvent) {
        if (tblcourse.getSelectionModel().getSelectedItem() != null) {
            Coursetm selectedProgram = tblcourse.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Program");
            alert.setHeaderText("Are you sure ?");
            ButtonType btnYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType btnCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(btnYes, btnCancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == btnYes) {
                CourseBO courseBO = (CourseBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOType.Course);
                try {
                    boolean deleteCourse = courseBO.deleteCourse(makeCourseDTO(selectedProgram));
                    if (deleteCourse){
                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                        alert1.setTitle("Course");
                        alert1.setHeaderText(null);
                        alert1.setContentText("Course is removed !");
                        alert1.showAndWait();
                        coursetms.remove(selectedProgram);
                        tblcourse.refresh();
                    }else {
                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                        alert1.setTitle("Error");
                        alert1.setHeaderText(null);
                        alert1.setContentText("Course remove Failed !");
                        alert1.showAndWait();
                        coursetms.remove(selectedProgram);
                       tblcourse.refresh();
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a program !");
            alert.showAndWait();
        }
    }
    private CourseDTO makeCourseDTO(Coursetm selectedProgram) {
        return new CourseDTO(selectedProgram.getProgramID(),
                selectedProgram.getProgram(),
                selectedProgram.getDuration(),
                selectedProgram.getFee());
    }

}
