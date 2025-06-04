package DSA;

public class PushDominoes {
    public static String pushDominoes(String dominoes) {
        dominoes = 'L' + dominoes + 'R';
        int n = dominoes.length();
        char[] d = dominoes.toCharArray();
        for(int i = 1; i < n; i++) {
            int start = i;
            while(start < n && d[start] != '.') {
                start++;
            }
            int end = start;
            while(end < n && d[end] == '.') {
                end++;
            }
            i = end;
            while(start < end) {
                if(d[start-1] != d[end]) {
                    if(d[start-1] == 'R' && start != end - 1) {
                        //d[end] will be 'L'
                        d[start] = d[start-1];
                        d[end-1] = d[end];
                        start++;
                        end--;
                    } else {
                        start++;
                    }
                } else {
                    if(d[start-1] == 'L') {
                        d[start] = 'L';
                        d[end-1] = 'L';
                        start++;
                        end--;
                    } else {
                        d[start] = 'R';
                        d[end-1] = 'R';
                        start++;
                        end--;
                    }
                }
            }
        }
//        System.out.println(new String(d).substring(1,n-1));
        return new String(d).substring(1,n-1);
    }

    public static void main(String[] args) {
        String dominoes = "..R..";
        System.out.println(pushDominoes(dominoes));
    }
}
