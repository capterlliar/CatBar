import javafx.geometry.Pos;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;

public class ClipContent extends StackPane {
    private int side = 50;
    private int num = 0;
    private ContextMenu menu;
    private Label label;

    public ClipContent() {
        getPane();
        getMenu();
    }

    public void selectClipContent() {
        this.getStyleClass().clear();
        this.getStyleClass().add("clipContent2");
    }

    private void deleteClipContent() {
        this.setText("");
    }

    private String getText(int num) {
        return ClipManager.getText(num);
    }

    private void setText(String text) {
        this.label.setText(text);
    }

    private void setText(int num){
        this.label.setText(this.getText(num));
    }

    private void getPane() {
        this.label = new Label();
        label.setPrefHeight(side);
        label.setPrefWidth(side);
        label.setAlignment(Pos.CENTER);

        this.getChildren().add(label);
        this.getStyleClass().add("clipContent");
        this.getStylesheets().add("ClipBar.css");
        this.setOnMouseClicked(e -> {
            ClipManager.putText(this.num);
        });
    }

    private void getMenu() {
        MenuItem menuItem0 = new MenuItem("fix");
        MenuItem menuItem1 = new MenuItem("delete");
        menuItem0.setOnAction(e -> this.selectClipContent());
        menuItem1.setOnAction(e -> this.deleteClipContent());

        this.menu = new ContextMenu();
        this.menu.getItems().add(menuItem0);
        this.menu.getItems().add(menuItem1);
        this.setOnContextMenuRequested(e -> this.menu.show(this, e.getScreenX(), e.getScreenY()));
    }
}
