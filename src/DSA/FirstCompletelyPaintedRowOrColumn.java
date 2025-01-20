package DSA;

import java.util.*;

public class FirstCompletelyPaintedRowOrColumn {
    public class Pair {
        int r;
        int c;
        public Pair (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        HashMap<Integer, Pair> map = new HashMap<>();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                map.put(mat[i][j], new Pair(i,j));
            }
        }
        int[] rows = new int[c];
        int[] cols = new int[r];
        for(int i = 0; i < arr.length; i++) {
            Pair p = map.get(arr[i]);
            rows[p.c]++;
            cols[p.r]++;
            if(rows[p.c] >= r || cols[p.r] >= c) return i;
        }
//        for(int i : rows) System.out.print(i + " ");
//        for(int i : cols) System.out.print(i + " ");

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,5,2,6,3};
        int[][] mat = {{4,3,5},{1,2,6}};
        FirstCompletelyPaintedRowOrColumn FCP = new FirstCompletelyPaintedRowOrColumn();
        System.out.println(FCP.firstCompleteIndex(arr, mat));
    }
}