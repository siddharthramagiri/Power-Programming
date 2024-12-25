package RecursionsKunal;

public class BinarySearchRecursion {
    static int search(int[] arr, int k, int l, int r) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (arr[mid] == k) {
            return mid;
        }
        if (arr[mid] < k) {
            return search(arr, k, mid + 1, r);
        } else {
            return search(arr, k, l, mid - 1);
        }
    }

    public static void ZtoN(int n) {
        if(n > 6)
            return;
        System.out.println(n);
        ZtoN(n+1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7,11,13,16,20,24};
        int target = 1;
        int left = 0;
        int right = arr.length;
        int idx = search(arr, target, left, right);
        System.out.println(idx);

        ZtoN(0);
    }
}
