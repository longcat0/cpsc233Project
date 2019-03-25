import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class Confirmation {

  static boolean answer;

  public static void display(String title) {
    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);


    Label windowMessage = new Label("This amount exceeds your budget.\nWould you like to remove from your available funds?");

    Button yes = new Button("Yes");
    Button no = new Button("No");

    VBox yolo = new VBox();
    yolo.setSpacing(10);
    yolo.setAlignment(Pos.CENTER);

    HBox buttons = new HBox();
    buttons.setAlignment(Pos.CENTER);
    buttons.setSpacing(5);

    buttons.getChildren().addAll(yes, no);
    yolo.getChildren().addAll(windowMessage, buttons);

    Scene scene = new Scene(yolo, 300, 200);
    window.setScene(scene);
    window.showAndWait();


  }
}
