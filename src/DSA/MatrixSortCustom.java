package DSA;

import java.util.Arrays;
import java.util.Comparator;

public class MatrixSortCustom {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {3,5,4,1},
                {0,4,2,7}
        };
//        Arrays.sort(matrix, (a,b) -> a[1] - b[1]);
        Arrays.sort(matrix, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });

        for(int[] arr : matrix) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
