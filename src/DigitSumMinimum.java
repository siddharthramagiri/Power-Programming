public class DigitSumMinimum {
    public static int getMinimumSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            // String str = arr[i] + "";
            // int num = str.charAt(0) - '0';
            // for (int j = 0; j < str.length(); j++) {
            // if (num > str.charAt(j) - '0') {
            // num = str.charAt(j) - '0';
            // }
            // }
            int num = arr[i];
            int min = 10;
            while (num > 0) {
                int rem = num % 10;
                num = num / 10;
                if (rem < min) {
                    min = rem;
                }
            }
            System.out.println(min);
            sum = sum + min;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 23, 56, 45, 342 };
        System.out.println(getMinimumSum(arr));
    }
}
