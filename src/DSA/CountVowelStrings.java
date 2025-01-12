package DSA;

public class CountVowelStrings {
    public static boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
        return false;
    }
    public static int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length;
        int w = words.length;
        int[] ans = new int[n];
        int[] arr = new int[w];
        int i = 0;
        for(String word : words) {
            if(isVowel(word.charAt(0)) && isVowel(word.charAt(word.length()-1)))
                arr[i] = 1;
            else arr[i] = 0;
            i++;
        }
        int k = 0;
        for(int[] querey : queries) {
            int sum = 0;
            for(i = querey[0]; i <= querey[1]; i++) {
                sum += arr[i];
            }
            ans[k] = sum;
            k++;
        }
        return ans;
    }
    public static void main(String[] args) {
        String[] words = {"a","e","i"};
        int[][] queries = {{0,2},{0,1},{2,2}};
        int[] ans = vowelStrings(words, queries);
        for(int i : ans)
            System.out.print(i + " ");
    }
}