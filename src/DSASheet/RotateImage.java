package DSASheet;

import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] box) {
        int row = 0;
        int n = box.length;
        int[][] rotated = new int[n][n];
        while (row < box.length) {
            for (int c = 0; c < n; c++) {
                rotated[c][box.length - row - 1] = box[row][c];
            }
            row++;
        }
        for(int i = 0; i < rotated.length; i++) {
            for(int j = 0; j < rotated[i].length; j++) {
                box[i][j] = rotated[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] box = {{1,2,3}, {4,5,6}, {7,8,9}};
        rotate(box);
        for(int[] b : box) {
            for(int i : b)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
