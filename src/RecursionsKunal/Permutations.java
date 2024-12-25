package RecursionsKunal;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Permutations {
    public static ArrayList<String> permuteReturn(String p, String up) {
        if(up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0; i < up.length(); i++) {
            ArrayList<String> left = permuteReturn(p + up.charAt(i),up.substring(0,i) + up.substring(i + 1));
            ans.addAll(left);
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "ABCD";
//        System.out.println(permuteReturn("",str));
        System.out.println(permuteReturnKunals("", str));
    }
    public static ArrayList<String> permuteReturnKunals(String p, String up) {
        if(!up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            char ch = up.charAt(0);
            for(int i = 0; i <= p.length(); i++) {
                String l = p.substring(0,i);
                String r = p.substring(i);
                ArrayList<String> left = permuteReturnKunals(l + ch + r, up.substring(1));
                list.addAll(left);
            }
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        list.add(p);
        return list;
    }
    public static void permuteKunal(String p, String up) {
        if(up.length() == 0) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for(int i = 0; i <= p.length(); i++) {
            String l = p.substring(0,i);
            String r = p.substring(i);
            permuteKunal(l + ch + r, up.substring(1));
        }
    }
    public static void permute(String p, String up) {
        if(up.length() == 0) {
            System.out.println(p);
            return;
        }
        for(int i = 0; i < up.length(); i++) {
            permute(p + up.charAt(i),
            up.substring(0,i) + up.substring(i + 1));
        }
    }
}
