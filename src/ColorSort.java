public class ColorSort {
    public static int[] sort(int[] arr) {
        int r = 0, g = 0, b = arr.length - 1;
        while (r <= b) {
            if (arr[r] == 0) {
                swap(arr, g, r);
                g++;
                r++;
            } else if (arr[r] == 1) {
                r++;
            } else {
                swap(arr, b, r);
                b--;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] colors = { 2, 0, 2, 1, 1, 0 };
        // 0 -> green
        // 1 -> red
        // 2 -> blue
        int[] sortedColors = sort(colors);
        for (int i : sortedColors)
            System.out.print(i + " ");

    }
}
