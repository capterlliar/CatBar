import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUI extends Application {
    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }

    public void start(Stage stage) {
        Pane background = getBackGround();

        Scene scene = new Scene(background);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/cat.png")));
        stage.show();
    }

    public Pane getBackGround() {
        Pane pane = new Pane();
        return pane;
    }
}
