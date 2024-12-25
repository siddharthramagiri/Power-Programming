package RecursionsKunal;
import java.util.*;

public class BasicRec {
    public static int fact(int n) {
        if(n == 1) {
            System.out.println(n);
            return 1;
        }
        System.out.print(n + " * ");
        return n * fact(n - 1);
    }
    static int sum(int n) {
        if(n == 0) return 0;
        System.out.print(n + " + ");
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        int fact = fact(5);
        System.out.println("Factorial = " + fact);

        int sum = sum(4);
        System.out.println("Sum = " + sum);

        int rev = reverse(123455);
        System.out.println("Reveresed number = " + rev);

        System.out.println("Palindrome : " + isPalindrome(1234321));

        String numStr = "abcdcba";
        System.out.println("Palindrome String : " + isPalStr(numStr, 0, numStr.length() - 1));

        int n = 1020400;
        System.out.println("No. of Zeros : " + countZeros(n));
        System.out.println("No. of Steps to Reduce : " + steps(123));

        int[] arr = {1,2,3,9,5,6,7,8,5,5,5};
        System.out.println(isSorted(arr,0));
        System.out.println(LinearSearch(arr, 0, 4));
        System.out.println(FindIndices(arr, 5));
    }
    public static ArrayList<Integer> FindIndices(int[] arr, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        list = helpFindIndexes(arr, target, 0, list);
        return list;
    }
    static ArrayList<Integer> helpFindIndexes(int[] arr, int target, int index, ArrayList<Integer> list) {
        if(index >= arr.length) {
            return list;
        }
        if (arr[index] == target) list.add(index);
        return helpFindIndexes(arr, target,index + 1, list);
    }

    public static int helper(int n, int len) {
        if(n%10 == n) {
            return n;
        }
        return helper(n/10, len - 1) + (n%10) * (int) Math.pow(10, len - 1);
    }
    public static int reverse(int n) {
        int digits = (int) Math.log10(n) + 1;
        return helper(n, digits);
    }
    public static boolean isPalindrome(int n) {
        if (n == reverse(n))  return true;
        return false;
    }

    public static boolean isPalStr(String str, int l, int r) {
        if (l >= r) {
            return str.charAt(l) == str.charAt(r);
        }
        if(str.charAt(l) != str.charAt(r)) return false;
        return isPalStr(str, l+1, r-1);
    }
    public static int countZeros(int n) {
        return counthelper(n,0);
    }
    public static int counthelper(int num, int count) {
        if(num%10 == num) {
            return count;
        }
        return counthelper(num/10, (num%10 == 0) ? count + 1 : count);
    }
    static int steps(int n) {
        return helperSteps(n,0);
    }
    public static int helperSteps(int n, int count) {
        if(n == 0) {
            return count;
        }
        if(n % 2 == 0) {
            return helperSteps(n/2, count + 1);
        }
        return helperSteps(n - 1, count + 1);
    }
    public static boolean isSorted(int[] arr, int index) { // {1,2,3}  len = 3
        if(index == arr.length - 1) {
            return true;
        }
        return (arr[index] < arr[index + 1]) && isSorted(arr,index+1);
    }
    public static int LinearSearch(int[] arr, int index, int target) {
        if(index >= arr.length) {
            return -1;
        }
        return (arr[index] == target) ? index : LinearSearch(arr,index+1, target);
    }

}
