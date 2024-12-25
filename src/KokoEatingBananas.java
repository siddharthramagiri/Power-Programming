import java.util.*;
public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int res = high;
        while(low < high) {
            int mid = low + (high - low) / 2;
            int totalTime = 0;
            for(int i : piles) {
                totalTime += (int) Math.ceil((double)i/mid);
            }
            if(totalTime <= h) {
                high = mid;
                res = low;
            } else if(totalTime > h) {
                low = mid + 1;
                res = low;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {30,11,23,4,20};
        System.out.println(minEatingSpeed(arr, 5));
    }
}
