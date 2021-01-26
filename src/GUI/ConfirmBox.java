package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message){
        Stage window = new Stage();
        window.setTitle(title);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);

        Button yesButton = new Button("YES");
        Button noButton = new Button("NO");
        Label label = new Label(message);

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        HBox leftSideBox = new HBox();
        HBox rightSideBox = new HBox();
        HBox topBox = new HBox();

        leftSideBox.getChildren().add(noButton);
        rightSideBox.getChildren().add(yesButton);
        topBox.getChildren().add(label);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topBox);
        borderPane.setLeft(leftSideBox);
        borderPane.setRight(rightSideBox);

        Scene scene = new Scene(borderPane);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
