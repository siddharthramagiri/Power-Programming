package DSA;

import java.util.HashMap;

public class SplitMessageBasedonLimit {
    static class Pair {
        int[] arr;
        int sum;
        public Pair(int[] arr, int sum) {
            this.arr = arr;
            this.sum = sum;
        }
    }
    public static String[] splitMessage(String message, int limit) {
        int strLen = message.length();
        String[] strArr = new String[0];
        int[] arr = new int[0];
        int left = 1, right = strLen;
        HashMap<Integer, Pair> map = new HashMap<>();
        int mid = 0;
        while(left <= right) {
            mid = left + (right - left) / 2;
            int sum = check(mid, limit, strLen, map);
            System.out.println(sum + " : " + strLen);
            if(sum < strLen) {
                left = mid + 1;
            } else if (sum > strLen) {
                right = mid - 1;
            } else {
                strArr = new String[mid];
                arr = map.get(mid).arr;
                System.out.println(mid);
                right = mid - 1;
                if(right <= 2) break;
            }
        }
        int k = 0;
        for(int i = 0; i < strArr.length; i++) {
            if(k + arr[i] <= strLen) {
                String s = message.substring(k, (k + arr[i]));
                if(s.length() > limit - 3) return new String[0];
                strArr[i] = s + "<" + (i + 1) + "/" + strArr.length + ">";
                k += arr[i];
            }
        }
        return strArr;
    }
    public static int check(int n, int limit, int TotalSum, HashMap<Integer, Pair> map) {
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if (i == n - 1 && sum < TotalSum) {
                if(i > 0) {
                    if ((TotalSum - sum) <= arr[i-1]){
                        arr[i] = (TotalSum - sum);
                        sum += arr[i];
                        map.put(n, new Pair(arr, sum));
                        return sum;
                    }
                } else {
                    int len = (limit - ((n + "").length() + ((i + 1) + "").length() + 3));
                    if(len < limit) {
                        arr[i] = TotalSum;
                        sum += arr[i];
                        map.put(n, new Pair(arr, sum));
                        return sum;
                    }
                    return sum;
                }
            }
            arr[i] = (limit - ((n + "").length() + ((i + 1) + "").length() + 3));
            sum += arr[i];
            if(sum > TotalSum) return sum;
        }
        map.put(n, new Pair(arr,sum));
        return sum;
    }
    public static void main(String[] args) {
        String message = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        int limit = 10;
        String[] strArr = splitMessage(message, limit);
        for(String str : strArr) System.out.print(str + " ");
    }
}
