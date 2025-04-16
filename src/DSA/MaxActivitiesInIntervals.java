package DSA;

import java.util.Arrays;
import java.util.Comparator;

public class MaxActivitiesInIntervals {

    public static void main(String[] args) {
        int act[][] = {
                {1,3},{2,5},{4,7},{1,8},{5,9},{8,10}
        };
        System.out.println(MaxActivities(act));
    }
    public static int MaxActivities(int[][] act) {
        Arrays.sort(act, Comparator.comparingInt((int[] a) -> a[1]));
//        Arrays.sort(act, Comparator.comparingInt(a-> a[1]));
        int count = 0;
        int lastEnd = 0;
        for(int[] interval : act) {
            int start = interval[0];
            int end = interval[1];
            if(lastEnd <= start) {
                count++;
                lastEnd = end;
            }
        }
        return count;
    }
}
