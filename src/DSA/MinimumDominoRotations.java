package DSA;

public class MinimumDominoRotations {
    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length, minSwaps = n + 1;
        // Make All Tops equal
        minSwaps = getMinSwaps(bottoms, tops, minSwaps, n);
        // Make All Bottoms equal
        minSwaps = getMinSwaps(tops, bottoms, minSwaps, n);
        return minSwaps == (n+1)? -1 : minSwaps;
    }

    private static int getMinSwaps(int[] tops, int[] bottoms, int minSwaps, int n) {
        for(int i = 1; i <= 6; i++) {
            int swaps = 0;
            int j = 0;
            for(j = 0; j < n; j++) {
                if(bottoms[j] != i) {
                    if(tops[j] == i) {
                        swaps++;
                    } else {
                        break;
                    }
                }
            }
            if(j >= n) minSwaps = Math.min(minSwaps, swaps);
        }
        return minSwaps;
    }

    public static void main(String[] args) {
        int[] tops = {3,5,1,2,3}, bottoms = {3,6,3,3,4};
        System.out.println(minDominoRotations(tops, bottoms));
    }
}
