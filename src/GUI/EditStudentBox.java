package GUI;

import api.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;

public class EditStudentBox {

    static Scene scene, gradeScene;
    public static void display(SchoolParticipant schoolParticipant, ResourceManager resourceManager){
        Stage window = new Stage();
        window.setTitle("Edit Student");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);

        HBox layout = new HBox();
        layout.setPadding(new Insets(10,10,10,10));

        Button deleteStudentButton = new Button("Delete");
        deleteStudentButton.setOnAction(e -> {
            resourceManager.deletePersonByType(schoolParticipant);
            window.close();
                }
        );

        Button addGrade = new Button("Add grade");
        addGrade.setAlignment(Pos.BASELINE_RIGHT);
        addGrade.setOnAction(e -> {
            if(schoolParticipant instanceof Student) {
                HBox hBox = new HBox();
                hBox.setPadding(new Insets(10,10,10,10));
                ComboBox<Subject> subjectComboBox = new ComboBox<>();
                subjectComboBox.getItems().addAll(Subject.BIOLOGY, Subject.CHEMISTRY, Subject.ENGLISH, Subject.MATHS, Subject.HISTORY, Subject.POLISH);
                subjectComboBox.setPromptText("Choose subject");
                ComboBox<Integer> ratingComboBox = new ComboBox<>();
                ratingComboBox.getItems().addAll(1, 2, 3, 4, 5);
                ratingComboBox.setPromptText("Choose grade");

                Button button = new Button("Add");
                button.setOnAction(event -> {
                    ((Student) schoolParticipant).addGrade(subjectComboBox.getValue(), ratingComboBox.getValue());
                    StringBuilder information = new StringBuilder();
                    information.append("Student ").append(schoolParticipant.getName() + " " + schoolParticipant.getLastName()).append(" get ").append(ratingComboBox.getValue()).append(" from subject ").append(subjectComboBox.getValue());
                    InformationBox.display("Grade added", information.toString());
                    window.close();
                });

                hBox.getChildren().addAll(subjectComboBox,ratingComboBox,button);
                gradeScene = new Scene(hBox);
                window.setScene(gradeScene);
            }
            else{
                InformationBox.display("Error","Teacher cant get grade");
            }
        });



        layout.getChildren().addAll(deleteStudentButton,addGrade);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();;
    }
}
