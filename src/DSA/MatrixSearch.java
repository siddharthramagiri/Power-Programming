package DSA;

public class MatrixSearch {
    public static boolean Search(int[][] arr, int k) {
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0; i < n; i++) {
            int left = 0;
            int right = m - 1;
            if(arr[i][right] < k) continue;
            while(left <= right) {
                int mid = (left + right)/2;
                if(arr[i][mid] > k)
                    right = mid - 1;
                else if(arr[i][mid] < k)
                    left = mid + 1;
                else
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,4,5,8},
                {4,6,8,9,11},
                {7,10,12,14},
        };
        int k = 8;
        System.out.println(Search(arr, k));
    }
}
