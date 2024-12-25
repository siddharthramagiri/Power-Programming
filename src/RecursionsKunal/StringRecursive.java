package RecursionsKunal;
import java.util.ArrayList;

public class StringRecursive {
    public static void SubSequence(String p, String up) {
        if(up.length() == 0) {
            System.out.println(p);
            return;
        }
        SubSequence(p + up.charAt(0), up.substring(1));
        SubSequence(p,up.substring(1));
    }
    public static ArrayList<String> SubSeqReturn(String p, String up) {
        if(up.length() == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> left = SubSeqReturn(p + up.charAt(0), up.substring(1));
        ArrayList<String> right = SubSeqReturn(p, up.substring(1));
        left.addAll(right);
        return left;
    }
    public static void main(String[] args) {
        String str = "abaaccdadb";
//        System.out.println(str);
//        str = RemoveAs(str);
//        str = RemoveWords("HelloappleThere", "apple");
//        System.out.println(str);
        SubSequence("","ABC");
        System.out.println(SubSeqReturn("","ABC"));
    }
    
    public static String RemoveWords(String str, String unwanted) {
        if(str.length() == 0) {
            return "";
        }
        if(str.startsWith(unwanted)) {
            int len = unwanted.length();
            return RemoveWords(str.substring(len),unwanted);
        } else {
            char ch = str.charAt(0);
            return ch + RemoveWords(str.substring(1), unwanted);
        }
    }

    public static String RemoveAs(String str) {
        if(str.isEmpty()) {
            return "";
        }
        char ch = str.charAt(0);
        if(ch == 'a') {
            return RemoveAs(str.substring(1));
        } else {
            return ch + RemoveAs(str.substring(1));
        }
    }
}
