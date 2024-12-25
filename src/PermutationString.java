public class PermutationString {

    public static void permutation(String rem, String str) {
        if(str.length() == 0) {
            return;
        }
        for(int i = 0; i < str.length(); i++) {
            char rembStr = str.charAt(i);
            String leftStr = str.substring(0,i) + str.substring(i + 1);
            if ((rem + rembStr).length() == rem.length() + str.length())
                System.out.println(rem + rembStr);
            permutation(rem + rembStr, leftStr);
        }
    }
    public static void main(String[] args) {
        String str = "ABCD";
        permutation("",str);
    }
}
