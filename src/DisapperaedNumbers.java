
public class DisapperaedNumbers {

    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]) - 1;
            arr[val] = Math.abs(arr[val]) * -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                System.out.println(i + 1);
        }
    }

}
