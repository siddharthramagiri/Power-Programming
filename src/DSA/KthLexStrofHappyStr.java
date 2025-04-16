package DSA;

import java.util.ArrayList;
import java.util.List;

public class KthLexStrofHappyStr {
    List<String> LexStrings;
    public String getHappyString(int n, int k) {
        LexStrings = new ArrayList<>();
        backTrack("", ' ', n);
        return LexStrings.size() < k? "" : LexStrings.get(k-1);
    }
    public void backTrack(String ans, char prev, int n) {
        if(ans.length() == n) {
            LexStrings.add(ans);
            return;
        }
        for(int i = 0; i < 3; i++) {
            char ch = (char)(i + 'a');
            if(prev != ch) {
                backTrack(ans + ch, ch, n);
            }
        }
    }
    public static void main(String[] args) {
        int n = 5, k = 9;
        KthLexStrofHappyStr KSH = new KthLexStrofHappyStr();
        System.out.println(KSH.getHappyString(n,k));
    }
}
