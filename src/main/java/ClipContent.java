import javafx.geometry.Pos;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;

public class ClipContent extends StackPane {
    private final int id;
    private ContextMenu menu;
    private Label label;

    public ClipContent(int id) {
        getPane();
        getMenu();
        this.id = id;
        this.setDisable(true);
    }

    public void setText(String text){
        this.label.setText(text);
        this.setDisable(false);
    }

    private void fixClipContent() {
        ClipManager.fixText(this.id);
        this.getStyleClass().clear();
        this.getStyleClass().add("clipContent2");
    }

    private void deleteClipContent() {
        this.label.setText("");
        ClipManager.deleteText(this.id);
        this.setDisable(true);
    }

    private void getPane() {
        this.label = new Label();
        label.setAlignment(Pos.CENTER);

        this.getChildren().add(label);
        this.getStyleClass().add("clipContent");
        this.getStylesheets().add("ClipBar.css");
        this.setOnMouseClicked(e -> {
            if(e.getButton() == MouseButton.PRIMARY) {
                ClipManager.putText(this.label.getText());
            }
        });
    }

    private void getMenu() {
        MenuItem menuItem0 = new MenuItem("fix");
        MenuItem menuItem1 = new MenuItem("delete");
        menuItem0.setOnAction(e -> this.fixClipContent());
        menuItem1.setOnAction(e -> this.deleteClipContent());

        this.menu = new ContextMenu();
        this.menu.getItems().add(menuItem0);
        this.menu.getItems().add(menuItem1);
        this.setOnContextMenuRequested(e -> this.menu.show(this, e.getScreenX(), e.getScreenY()));
    }
}
