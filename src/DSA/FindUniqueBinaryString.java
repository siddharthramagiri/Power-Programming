package DSA;
import java.util.HashSet;

public class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        return backTrack("", set, nums[0].length());
    }
    public String backTrack(String ans, HashSet<String> set, int n) {
        if(ans.length() == n) {
            if(!set.contains(ans)) {
                return ans;
            }
            return null;
        }
        for(int i = 0; i <= 1; i++) {
            String result = backTrack(ans+i, set, n);
            if(result != null) {
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        FindUniqueBinaryString FUBS = new FindUniqueBinaryString();

        System.out.println(
                FUBS.findDifferentBinaryString(
                        new String[]
                                {"00","01","10"}
                )
        );
    }
}
