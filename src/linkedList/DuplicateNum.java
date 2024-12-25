package linkedList;

public class DuplicateNum {
    public static int getduplicate(int[] arr) {
        int n = arr.length;
        int fast = 0;
        for(int slow = 0; slow < n; slow = (slow + 1) % n) {
            if(arr[fast] == arr[slow] && fast != slow) {
                return arr[fast];
            }
            fast = (fast + 2) % n;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(getduplicate(arr));
    }
}
