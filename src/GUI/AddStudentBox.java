package GUI;

import api.ResourceManager;
import api.Student;
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

public class AddStudentBox {
    static String name;
    static String lastName;
    static int age;
    static LocalDate date;

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
        ageBox.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18,19);
        ageBox.setValue(7);
        GridPane.setConstraints(ageBox,1,2);

        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Date of graduation");
        GridPane.setConstraints(datePicker,0,3);



        Button confirmButton = new Button("Add");
        Button cancelButton = new Button("Close");
        cancelButton.setPrefWidth(100);
        confirmButton.setPrefWidth(100);


        cancelButton.setOnAction(e -> window.close());
        confirmButton.setOnAction(e -> {
            name = nameTextField.getText();
            lastName = lastNameTextField.getText();
            age = ageBox.getValue();
            date = datePicker.getValue();
            resourceManager.addStudent(name,lastName,age,date);
            InformationBox.display("Student added","Student has been added !");
            window.close();
        });

        GridPane.setConstraints(confirmButton,0,4);
        GridPane.setConstraints(cancelButton,2,4);
        grid.getChildren().addAll(nameLabel,nameTextField,lastNameLabel,lastNameTextField,ageLabel,ageBox,datePicker,confirmButton,cancelButton);

        Scene scene = new Scene(grid);

        window.setScene(scene);
        window.showAndWait();
    }


}
