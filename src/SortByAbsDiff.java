public class SortByAbsDiff {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 6, 2 };
        int target = 5;
        int n = arr.length;
        int[] Diff = new int[n];
        for (int i = 0; i < n; i++) {
            Diff[i] = arr[i] - target;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(Diff[i]) > Math.abs(Diff[j])) {
                    int temp = Diff[i];
                    Diff[i] = Diff[j];
                    Diff[j] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            Diff[i] += target;
            System.out.print(Diff[i] + " ");
        }
    }
}
