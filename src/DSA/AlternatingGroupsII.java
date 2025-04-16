package DSA;

public class AlternatingGroupsII {
    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        int l = 0;
        for(int r = 1; r < (n + k - 1); r++) {
            if(colors[r%n] == colors[(r-1)%n]) {
                l = r;
            }
            if(r - l + 1 == k) {
                count++;
                l++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] colors = {0,1,0,0,1,0,1};
        int k = 6;
        System.out.println(numberOfAlternatingGroups(colors, k));
    }
}