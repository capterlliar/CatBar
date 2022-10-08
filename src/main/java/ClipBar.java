import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class ClipBar extends HBox {
    int clipContentNum = 12;
    ArrayList<ClipContent> clipContents = new ArrayList<>();

    public ClipBar(){
        this.getHBox();
        this.getClipContents();
    }

    public void getHBox(){
        this.getStyleClass().add("clipBar");
        this.getStylesheets().add("ClipBar.css");
    }

    public void setTextToContent(int id, String text){
        clipContents.get(id).setText(text);
    }

    public void getClipContents(){
        for(int i=0;i<clipContentNum;i++){
            clipContents.add(new ClipContent(i+1));
        }
        clipContents.forEach(res -> {
            this.getChildren().add(res);
        });
    }
}
