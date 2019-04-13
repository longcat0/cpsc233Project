import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class Confirmation3 {

  static boolean answer;

  public static boolean display(String title) {
    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);


    Label windowMessage = new Label("You do not have any previously saved accounts. Please create a new account.");

    Button yes = new Button("Okay");
    yes.setOnAction(y -> {
      answer = true;
      window.close();
    });


    VBox yolo = new VBox();
    yolo.setSpacing(10);
    yolo.setAlignment(Pos.CENTER);

    HBox buttons = new HBox();
    buttons.setAlignment(Pos.CENTER);
    buttons.setSpacing(5);

    buttons.getChildren().addAll(yes);
    yolo.getChildren().addAll(windowMessage, buttons);

    Scene scene = new Scene(yolo, 500, 200);
    window.setScene(scene);
    window.showAndWait();

    return answer;

  }
}
