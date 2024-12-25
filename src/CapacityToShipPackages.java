
public class CapacityToShipPackages {
    public static boolean isPossible(int[] arr, int capacity, int days) {
        int sum = 0;
        int count = 1;
        for (int value : arr) {
            if (value + sum > capacity) {
                count++;
                sum = 0;
            }
            sum += value;
        }
        return count <= days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int maxCapacity = 0, minCapacity = 0;

        for (int value : weights) {
            if (value > minCapacity) {
                minCapacity = value;
            }
            maxCapacity += value;
        }

        while (minCapacity <= maxCapacity) {
            int mid = (minCapacity + maxCapacity) / 2;
            if (isPossible(weights, mid, days)) {
                maxCapacity = mid - 1;
            } else {
                minCapacity = mid + 1;
            }
        }
        return minCapacity;
    }

    public static void main(String[] args) {
        int[] container = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;
        int answer = shipWithinDays(container, days);
        System.out.println(answer);
    }
}