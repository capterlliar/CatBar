public class ClipManager {
    public static String path = System.getProperty("user.dir")+"\\src\\main"+"\\resources"+"\\libuntitled.dll";
    public String getClipBoard(){
        String res = "";
        return res;
    }

    public static String getText(int num){
        return "";
    }

    public static void putText(int num) {
        System.load(path);
        NativePutText.putText();
    }
}
