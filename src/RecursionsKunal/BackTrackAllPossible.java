package RecursionsKunal;

import java.util.ArrayList;
import java.util.List;

public class BackTrackAllPossible {
    List<String> permutations;
    public List<String> getAllPossibilities(String str) {
        int n = str.length();
        permutations = new ArrayList<>();
        boolean[] used = new boolean[n];
        permuteAll("", str, used);
        return permutations;
    }
    public void permuteAll(String ans, String str, boolean[] used) {
        if(ans.length() == str.length()) {
            permutations.add(ans);
            return;
        }
        for(int j = 0; j < str.length(); j++) {
            if(!used[j]) {
                used[j] = true;
                permuteAll(ans+str.charAt(j), str, used);
                used[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        String str = "MOTWMI";
        BackTrackAllPossible BAP = new BackTrackAllPossible();
        System.out.println(BAP.getAllPossibilities(str));
    }
}
