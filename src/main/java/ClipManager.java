public class ClipManager {
    public static String path = System.getProperty("user.dir")+"\\src\\main"+"\\resources"+"\\ConsoleApplication4.dll";
    public String getClipBoard(){
        String res = "";
        return res;
    }

    public static String getText(int num){
        return "";
    }

    public static void putText(int num) {

    }

    public static void main(String[] args){
        System.load(path);
        NativePutText hello = new NativePutText();
        String res =  hello.putText("wuhu");
        System.out.println(res);
    }
}