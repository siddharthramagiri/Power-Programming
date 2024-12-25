package RecursionsKunal;

public class PlusCount {
    public static void countPlus(int n, int target) {
        String num = "" + n;
        permute("11+22",num,num.length() - 1,target);
    }
    public static void permute(String p, String up, int n, int target) {
        if(Calculate(p,target)) {
            System.out.println(p);
            return;
        }
        permute("",up,n - 1, target);
    }
    public static boolean Calculate(String p, int target) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if(Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                sum += Integer.parseInt(sb.toString());
                sb = new StringBuilder();
            }
        }
        return (sum == target);
    }
    public static void main(String[] args) {
        int n = 1111;
        int target = 22;
        countPlus(n,target);
    }
}
