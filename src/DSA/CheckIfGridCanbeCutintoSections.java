package DSA;

import java.util.Arrays;

public class CheckIfGridCanbeCutintoSections {
    public static boolean checkValidCuts(int n, int[][] rectangles) {
        int size = rectangles.length;
        int[][] X = new int[size][2];
        int[][] Y = new int[size][2];
        for(int i = 0; i < size; i++) {
            X[i][0] = rectangles[i][0];
            X[i][1] = rectangles[i][2];
            Y[i][0] = rectangles[i][1];
            Y[i][1] = rectangles[i][3];
        }
        Arrays.sort(X, (a, b) -> a[0]-b[0]);
        Arrays.sort(Y, (a, b) -> a[0]-b[0]);
        int hh = 0;
        int vv = 0;
        for(int i = 1; i < size; i++) {
            if(X[i][0] < X[i-1][1]) {
                if(X[i][1] <= X[i-1][1]) {
                    X[i][1] = X[i-1][1];
                }
            } else {
                hh++;
            }
            if(Y[i][0] < Y[i-1][1]) {
                if(Y[i][1] <= Y[i-1][1]) {
                    Y[i][1] = Y[i-1][1];
                }
            } else {
                vv++;
            }
        }
        return (hh >= 2 || vv >= 2);
    }

    public static void main(String[] args) {
            int n = 5;
            int[][] rectangles = {{0,2,2,4},{1,0,3,2},{2,2,3,4},{3,0,4,2},{3,2,4,4}};
            System.out.println(checkValidCuts(n, rectangles));
    }
}
