import java.util.ArrayList;
import java.util.HashSet;

public class MagicPrime {

    public static boolean isPrime(int n) {
        if(n <= 1) {
            return false;
        } else {
            for(int i = 2; i <= Math.sqrt(n); i++) {
                if(n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    public static ArrayList<Integer> getMagic(int num) {

        HashSet<Integer> primes = new HashSet<>();
        for(int i = 0; i < num; i++) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }
        ArrayList<Integer> magic = new ArrayList<>();
        int sum = 0;
        for(int i = 2; i < num; i++) {
            if(primes.contains(i)) {
                sum += i;
                if(sum != 2 && primes.contains(sum)) {
                    magic.add(sum);
                }
            }
        }
        return magic;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = getMagic(1000);
        System.out.println(list);

    }
}
