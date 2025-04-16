package DSA;

public class DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] arr = new int[n*m];
        int i = 0, r = 0, c = 0;
        while(i < (n*m)) {
            // Up Traverse
            while(r >= 0 && c < m) {
                arr[i++] = mat[r--][c++];
            }
            if(c >= m) {
                r++;c--;
            }
            r++;
            // down Traverse
            while(r < n && c >= 0) {
                arr[i++] = mat[r++][c--];
            }
            if(r >= n) {
                c++;r--;
            }
            c++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1,2},{3,4}
        };
        int[] res = findDiagonalOrder(mat);
        for(int i : res) System.out.print(i + " ");
    }
}
