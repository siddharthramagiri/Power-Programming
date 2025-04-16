package DSA;

import java.util.Arrays;

public class CountDaysWithoutMeeting {
    public static int countDays(int days, int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0]-b[0]);
        for(int[] a : arr) {
            for(int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        int count = arr[0][0] - 1;
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            if(arr[i][0] <= arr[i-1][1]) {
                if(arr[i][1] <= arr[i-1][1]) {
                    arr[i][1] = arr[i-1][1];
                }
            } else {
                count += arr[i][0] - arr[i-1][1] - 1;
            }
        }
        count += days - arr[n-1][1];
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDays(57,new int[][]{
                {3,49},{23,44},{21,56},{26,55},{23,52},{2,9},{1,48},{3,31}
        }));
    }
}
