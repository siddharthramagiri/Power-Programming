import java.util.Arrays;
public class ZigZagConversion {

    public static String zigzag(String str, int rows) {
        String[] strArr = new String[rows];
        Arrays.fill(strArr,"");
        int i = 0;
        boolean down = true;
        for(char ch : str.toCharArray()) {
            if(down) {
                strArr[i] += ch;
                i++;
                if(i == rows) {
                    down = false;
                    i = rows - 2;
                }
            } else {
                strArr[i] += ch;
                i--;
                if(i == 0) {
                    down = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s : strArr) {
            sb.append(s);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        int rows = 3;
        String s = zigzag(str,rows);


        System.out.println(s);
    }
}
