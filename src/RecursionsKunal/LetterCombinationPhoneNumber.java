package RecursionsKunal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// Leetcode 17.

public class LetterCombinationPhoneNumber {
    Map<Character, String> charMap = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(digits.equals(""))
            return new ArrayList<String>(0);
        charMap.put('2',"abc");charMap.put('3',"def");
        charMap.put('4',"ghi");charMap.put('5',"jkl");
        charMap.put('6',"mno");charMap.put('7',"pqrs");
        charMap.put('8',"tuv");charMap.put('9',"wxyz");
        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> ans = helpCombine("",digits, digits.length(), map);
        return ans;
    }
    public  ArrayList<String> helpCombine(String p, String up, int length, String[] map) {
        if(up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < up.length(); i++) {
            String keys = map[Integer.parseInt(up.charAt(i) + "")];
        //  String keys = charMap.get(up.charAt(i));    Using HashMap ExtraSpace
            for(int j = 0; j < keys.length(); j++) {
                list.addAll(helpCombine(p + keys.charAt(j), up.substring(i + 1),length, map));
            }
            break;
        }
        return list;
    }
    public static void main(String[] args) {
        String digits = "45";
        LetterCombinationPhoneNumber LCP = new LetterCombinationPhoneNumber();
        System.out.println(LCP.letterCombinations(digits));
    }
}
