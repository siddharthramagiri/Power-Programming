package online;

import java.util.ArrayList;
import java.util.List;

class CustomFunction {
    //   Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    public int f(int x, int y) { return (x * y); }
}

public class FindPositiveIntegerSolutionforEquation extends CustomFunction {
    public static List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> list = new ArrayList<>();
        for(int x = 1; x < 1000; x++) {
            int left = 1, right = 1000;
            while(left <= right) {
                int y = left + (right - left) / 2;
                int ret = customfunction.f(x,y);
                if (ret < z) {
                    left = y + 1;
                } else if (ret > z) {
                    right = y - 1;
                } else {
                    list.add(List.of(x,y));
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        CustomFunction customFn = new CustomFunction();
        System.out.println(findSolution(customFn, 5));
    }
}
