package GUI;

import api.ResourceManager;
import api.Student;
import api.Subject;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.awt.*;
import java.time.LocalDate;

public class AddTeacherBox {
    static String name;
    static String lastName;
    static int age;
    static Subject mainSubject;
    static int salary;

    public static void display(ResourceManager resourceManager){
        Stage window = new Stage();
        window.setTitle("Add Student");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(8);
        grid.setVgap(10);

        // User login LABEL
        Label nameLabel = new Label("Name: ");
        GridPane.setConstraints(nameLabel,0,0);

        // User login TEXT FIELD
        TextField nameTextField = new TextField();
        GridPane.setConstraints(nameTextField,1,0);

        // Password LABEL
        Label lastNameLabel = new Label("Last name: ");
        GridPane.setConstraints(lastNameLabel,0,1);

        //Password TEXT FIELD
        TextField lastNameTextField = new TextField();
        GridPane.setConstraints(lastNameTextField,1,1);

        //ChoiceBox LABEL
        Label ageLabel = new Label("Age: ");
        GridPane.setConstraints(ageLabel,0,2);

        //ChoiceBox
        ChoiceBox<Integer> ageBox = new ChoiceBox<>();
        for(int i = 18; i < 70; i++){
            ageBox.getItems().add(i);
        }
        ageBox.setValue(18);
        GridPane.setConstraints(ageBox,1,2);

        Label subjectLabel = new Label("Main subject: ");
        GridPane.setConstraints(subjectLabel,0,3);

       ComboBox<Subject> subjectComboBox = new ComboBox<>();
       subjectComboBox.getItems().addAll(Subject.BIOLOGY , Subject.CHEMISTRY,Subject.ENGLISH,Subject.MATHS,Subject.HISTORY,Subject.POLISH);
       GridPane.setConstraints(subjectComboBox,1,3);

       Label salaryLabel = new Label("Salary: ");
       GridPane.setConstraints(salaryLabel,0,4);

       TextField salaryTextField = new TextField();
       GridPane.setConstraints(salaryTextField,1,4);


        Button confirmButton = new Button("Add");
        Button cancelButton = new Button("Close");
        cancelButton.setPrefWidth(100);
        confirmButton.setPrefWidth(100);


        cancelButton.setOnAction(e -> window.close());
        confirmButton.setOnAction(e -> {
            name = nameTextField.getText();
            lastName = lastNameTextField.getText();
            age = ageBox.getValue();
            mainSubject = subjectComboBox.getValue();
            try {
                salary = Integer.parseInt(salaryTextField.getText());
                resourceManager.addTeacher(name,lastName,age,mainSubject,salary);
                InformationBox.display("Teacher added","Teacher has been added !");
                window.close();
            }
            catch (Exception exception){
                InformationBox.display("Error","Salary must be a value");
            }

        });

        GridPane.setConstraints(confirmButton,0,5);
        GridPane.setConstraints(cancelButton,2,5);
        grid.getChildren().addAll(nameLabel,nameTextField,lastNameLabel,lastNameTextField,ageLabel,ageBox,salaryLabel,salaryTextField,subjectLabel,subjectComboBox,confirmButton,cancelButton);

        Scene scene = new Scene(grid);

        window.setScene(scene);
        window.showAndWait();
    }


}
