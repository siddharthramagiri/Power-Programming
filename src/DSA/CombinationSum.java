package DSA;
import java.util.*;

public class CombinationSum {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        int n = candidates.length;
        backtrack(candidates, 0, n, new ArrayList<>(), target);
        return ans;
    }
    public void backtrack(int[] arr, int index, int n, List<Integer> list, int target) {
        if(target < 0) return;
        else if (target == 0) ans.add(new ArrayList<>(list));
        else {
            for(int i = index; i < n; i++) {
                list.add(arr[i]);
                backtrack(arr, i, n, list, target - arr[i]);
                list.removeLast();
            }
        }
//        backtrack(arr, index + 1, n, list, target);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;
        System.out.println(new CombinationSum().combinationSum(arr, target));
    }
}
