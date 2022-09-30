import javafx.scene.layout.HBox;

public class ClipBar {
    private int height = 50;
    private int width = 800;
    private HBox clipBar;

    public ClipBar(){
        this.clipBar = getHBox();
    }

    public HBox getClipBar(){
        return clipBar;
    }

    public HBox getHBox(){
        HBox hBox = new HBox();
        hBox.setPrefHeight(height);
        hBox.setPrefWidth(width);
        hBox.setStyle("-fx-background-color:rgba(255,255,255,1)");
        return hBox;
    }
}
