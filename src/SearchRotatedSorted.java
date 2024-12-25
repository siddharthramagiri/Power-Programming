public class SearchRotatedSorted {
    public static int recursiveSearch(int[] arr, int target) {
        return helper(arr, target, 0, arr.length - 1);
    }
    // Recursive Approach
    public static int helper(int[] arr, int target, int left, int right) {
        if (left > right)
            return -1;

        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;

        if (arr[left] < arr[mid]) {
            // Sorted Part
            if(arr[left] <= target && target <= arr[mid])
                return helper(arr, target, left, mid -1);
            else
                return helper(arr, target,  mid + 1, right);
        }
        if (arr[mid] <= target && target <= arr[right]) {
            return helper(arr, target, left, mid -1);
        } else {
            return helper(arr, target,  mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println("Iteration : " + search(nums, target));

        // With Recursion Approach Binary Search
        System.out.println("Reursion : " + recursiveSearch(nums, 0));
    }
    // Iterative Approach
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] >= nums[l]) {
                // Sorted part
                if (nums[l] <= target && target <= nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;

            } else {
                // rotated part
                if (nums[mid] <= target && target <= nums[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }
}
