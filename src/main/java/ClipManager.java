import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.util.Set;
import java.util.TreeSet;

public class ClipManager {
    public static int contentNum = 12;
    public static Clipboard clipboard = Clipboard.getSystemClipboard();
    public static Set<String> set = new TreeSet<>();
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
        Thread.sleep(100);  //wait the dll to be called.
        if(clipboard.hasString()){
            int res = tree.query();
            String text = ClipManager.getText();
            if(res != -1 && !set.contains(text)){
                tree.modify(1,1,contentNum,res,Priority.FILLED);
                set.add(text);
                return res;
            }
        }
        return -1;
    }

    public static String getText(){
        return clipboard.getString();
    }

    public static void deleteText(int id, String text){
        tree.modify(1,1,contentNum, id, Priority.EMPTY);
        set.remove(text);
    }

    public static void fixText(int id){
        tree.modify(1,1,contentNum, id, Priority.FIXED);
    }
}