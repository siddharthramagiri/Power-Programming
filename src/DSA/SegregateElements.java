package DSA;

import java.util.Arrays;

public class SegregateElements {
    public void segregateElements(int[] arr) {
        // Your code goes here
        int n = arr.length;
        int[] newArr = new int[n];
        int i = 0, j = n - 1;
        int l = 0, r = n - 1;
        while(l < n || r >= 0) {
            if(arr[l] >= 0) {
                newArr[i] = arr[l];
                i++;
            }
            if(arr[r] < 0) {
                newArr[j] = arr[r];
                j--;
            }
            l++;r--;
        }
        System.arraycopy(newArr, 0, arr, 0, n);
    }
    public static void main(String[] args) {
        int[] arr = {1,-1, 3, 2, -7, -5, 11, 6};
        SegregateElements SE = new SegregateElements();
        SE.segregateElements(arr);
        for(int i : arr) System.out.print(i + " ");
    }
}
