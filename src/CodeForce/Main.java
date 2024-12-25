package CodeForce;
import java.util.*;
public class Main {
    public static void Game(String num) {
        boolean alice = true;
        boolean found = false;
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        for(int i = 0; i <= sb.length() - 2; i++) {
            if(sb.charAt(i) != sb.charAt(i + 1)) {
                found = true;
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                i=-1;
                alice = !alice;
//                System.out.println(num + " : " + alice);
            }
        }
        if (!alice && found) System.out.println("DA");
        else System.out.println("NET");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            String num = sc.next();
            Game(num);
        }
    }
}
