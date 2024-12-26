public class TrappingRainWater {
    public static int[] getLeftMax(int[] height, int n) {
        int[] arr = new int[n];
        arr[0] = height[0];
        for(int i = 1; i < n; i++) {
            arr[i] = Math.max(height[i], arr[i-1]);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return arr;
    }
    public static int[] getRightMax(int[] height, int n) {
        int[] arr = new int[n];
        arr[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            arr[i] = Math.max(height[i], arr[i + 1]);
            System.out.print(arr[i] + " ");
        }
        return arr;
    }
    public static int trap(int[] height) {
        int n = height.length;
        int[] leftMax = getLeftMax(height,n);
        int[] rightMax = getRightMax(height, n);
        int trap = 0;
        for(int i = 0; i < n; i++) {
            trap += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return trap;
    }
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }
}
