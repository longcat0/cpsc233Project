import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class Confirmation2 {

  static boolean answer;

  public static boolean display(String title) {
    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);


    Label windowMessage = new Label("By clicking \"Yes\", you will remove all previously saved accounts. Would you like to proceed?");

    Button yes = new Button("Yes");
    yes.setOnAction(y -> {
      answer = true;
      window.close();
    });
    Button no = new Button("No");
    no.setOnAction(n -> {
      answer = false;
      window.close();
    });

    VBox yolo = new VBox();
    yolo.setSpacing(10);
    yolo.setAlignment(Pos.CENTER);

    HBox buttons = new HBox();
    buttons.setAlignment(Pos.CENTER);
    buttons.setSpacing(5);

    buttons.getChildren().addAll(yes, no);
    yolo.getChildren().addAll(windowMessage, buttons);

    Scene scene = new Scene(yolo, 500, 200);
    window.setScene(scene);
    window.showAndWait();

    return answer;

  }
}
