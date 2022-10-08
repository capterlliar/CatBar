import Utils.DragUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUI extends Application {
    Stage stage;

    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }

    public void start(Stage stage) {
        this.stage = stage;
        HBox background = new HBox();

        ClipBar clipBar = new ClipBar();
        background.getChildren().add(clipBar);

        Pane menuBar = getMenuBar();
        DragUtil.addDragListener(stage, menuBar);
        background.getChildren().add(menuBar);

        Scene scene = new Scene(background);

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("/cat.png")));
        stage.setAlwaysOnTop(true);
        stage.show();

        new com.sun.glass.ui.ClipboardAssistance(com.sun.glass.ui.Clipboard.SYSTEM) {
            @Override
            public void contentChanged() {
                int res = 0;
                try {
                    res = ClipManager.addText();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(res != -1){
                    clipBar.setTextToContent(res - 1, ClipManager.getText());
                }
            }
        };
    }

    public Pane getMenuBar(){
        Label label = new Label("x");
        label.setLayoutX(10);
        label.setLayoutY(3);

        Pane button = new Pane();
        button.setPrefHeight(20);
        button.setPrefWidth(50);
        button.getStyleClass().add("button");
        button.getStylesheets().add("ClipBar.css");
        button.getChildren().add(label);
        button.setOnMouseClicked(e -> {
            this.stage.close();
            e.consume();
        });

        Pane pane = new Pane();
        pane.setPrefWidth(25);
        pane.setPrefHeight(50);
        pane.setStyle("-fx-background-color:rgba(244,244,244,1)");
        pane.getChildren().add(button);
        return pane;
    }
}
