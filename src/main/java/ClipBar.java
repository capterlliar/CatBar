import javafx.scene.layout.HBox;

public class ClipBar extends HBox {
    private int height = 50;
    private int width = 800;

    public ClipBar(){
        this.getHBox();
        this.addClipContent();
        this.addClipContent();
        this.addClipContent();
        this.addClipContent();
    }

    public void getHBox(){
        this.setPrefHeight(height);
        this.setPrefWidth(width);
        this.setStyle("-fx-background-color:rgba(255,255,255,1)");
    }

    private void addClipContent() {
        this.getChildren().add(new ClipContent());
    }
}
