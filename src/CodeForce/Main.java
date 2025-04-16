package CodeForce;
import java.util.*;
public class Main {
    public static int skibidi(String word) {
        int n = word.length();
        for(int i = 0; i < n - 1; i++) {
            if(word.charAt(i) == word.charAt(i+1)) {
                return 1;
            }
        }
        return word.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            String word = sc.next();
            System.out.println(skibidi(word));
        }
    }
}
