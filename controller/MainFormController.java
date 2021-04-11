package lk.royalIstitute.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class MainFormController {
    public AnchorPane root;
    public JFXButton btnStudent;
    public JFXButton btnCourse;
    public JFXButton btnRegistration;
    public AnchorPane abc;


    public void studentBtnOnAction(ActionEvent actionEvent) throws IOException {
        initUI("StudentDetailsForm.fxml");
    }

    public void initUI(String location) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/lk/royalIstitute/view/" + location)));
    }

    public void courseBtnOnAction(ActionEvent actionEvent) throws IOException {
        initUI("CourseForm.fxml");
    }

    public void registrationBtnOnAction(ActionEvent actionEvent) throws IOException {
        initUI("StudentRegistrationForm.fxml");
    }
}
