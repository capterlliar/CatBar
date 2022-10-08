import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class ClipManager {
    public static int contentNum = 12;
    public static Clipboard clipboard = Clipboard.getSystemClipboard();
    public static ClipSortTree tree = new ClipSortTree(contentNum);
    public static String path = System.getProperty("user.dir")+"\\src\\main"+"\\resources"+"\\libuntitled.dll";

    public static void putText(String text) {
        ClipboardContent content = new ClipboardContent();
        content.putString(text);
        clipboard.setContent(content);
        System.load(path);
        NativePutText.putText();
    }

    public static int addText() throws InterruptedException {
        Thread.sleep(100);
        if(clipboard.hasString()){
            int res = tree.query();
            if(res != -1){
                tree.modify(1,1,contentNum,res,Priority.FILLED);
            }
            return res;
        }
        return -1;
    }

    public static String getText(){
        return clipboard.getString();
    }

    public static void deleteText(int id){
        tree.modify(1,1,contentNum, id, Priority.EMPTY);
    }

    public static void fixText(int id){
        tree.modify(1,1,contentNum, id, Priority.FIXED);
    }
}
