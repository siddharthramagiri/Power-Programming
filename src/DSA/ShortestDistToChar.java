package DSA;

public class ShortestDistToChar {
    public static int[] shortestToChar(String s, char c) {
        int l = 0, r = 0;
        int n = s.length();
        int[] arr = new int[n];
        int shortest = Integer.MAX_VALUE - 1;
        while(l < n && r < n) {
                if(s.charAt(r) == c)
                    while(l <= r) {
                        shortest = Math.min(shortest + 1, (r - l));
                        arr[l] = shortest;
                        l++;
                    }
            r++;
        }
        while(l < n) {
            shortest++;
            arr[l] = shortest;
            l++;
        }
        return arr;
    }
    public static void main(String[] args) {
        String s = "aaba";
        char c = 'b';
        int[] res = shortestToChar(s,c);
        for(int i : res) System.out.print(i + " ");
    }
}
