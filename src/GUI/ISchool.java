package GUI;

import api.ResourceManager;
import api.SchoolParticipant;
import api.Student;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Locale;

public class ISchool extends Application {
    Stage window;
    Scene scene;
    int HEIGHT = 200;
    int WIDTH = 250;

    @Override
    public void start(Stage primaryStage) throws Exception {
        ResourceManager resourceManager = new ResourceManager(Locale.US);

        window = primaryStage;
        window.setTitle("School Management");
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        VBox mainMenu = new VBox();
        mainMenu.setPadding(new Insets(10,10,10,10));
        mainMenu.setSpacing(10);

        Label homeLabel = new Label("School Management");


        Button addStudent = new Button("Add Student");
        addStudent.setPrefWidth(125);
        addStudent.setOnAction(e-> AddStudentBox.display(resourceManager));



        Button addTeacher = new Button("Add Teacher");
        addTeacher.setOnAction(e-> AddTeacherBox.display(resourceManager));
        addTeacher.setPrefWidth(125);

        Button showPeopleButton = new Button("Refresh people list");
        showPeopleButton.setPrefWidth(125);

        ListView<String> listView = new ListView<>();
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        showPeopleButton.setOnAction(e-> {
            listView.getItems().clear();
            for(SchoolParticipant schoolParticipant: resourceManager.peopleList){
                listView.getItems().add(resourceManager.printPersonInfo(schoolParticipant));
            }
            HEIGHT = 200 + resourceManager.peopleList.size()*100;
            window.setHeight(HEIGHT);
        });

        listView.setOnMouseClicked(e -> {
            if(e.getClickCount() == 2){
                int index = listView.getSelectionModel().getSelectedIndex();
                    EditStudentBox.display(resourceManager.peopleList.get(index), resourceManager);

            }
        });

        mainMenu.getChildren().addAll(homeLabel,addStudent,addTeacher,showPeopleButton,listView);
        mainMenu.setAlignment(Pos.CENTER);

        scene = new Scene(mainMenu,WIDTH,HEIGHT);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram(){
        boolean decision = ConfirmBox.display("Exit ?","Are u sure u want to exit ?");
        if(decision) {
            window.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
