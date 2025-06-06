package DSA;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for(int i = 1; i < n; i++) {
            if(ratings[i-1] < ratings[i]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        int sum = candies[n-1];
        for(int i = n - 2; i >= 0; i--) {
            if(ratings[i + 1] < ratings[i]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
            sum += candies[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = {1,3,2,2,1};
        System.out.println(new Candy().candy(ratings));
    }
}
