package DSA;

import java.util.*;

public class LetterTilePossibilities {
    static int len;
    public static int numTilePossibilities(String tiles) {
        len = tiles.length();
        boolean[] used = new boolean[len];
        HashSet<String> set = new HashSet<>();
        backTrack(set, used, tiles, "");
        System.out.println(set);
        return set.size();
    }
    public static void backTrack(HashSet<String> set, boolean[] used, String tiles, String curr) {
        if(set.contains(curr)) return;
        set.add(curr);
        for(int i = 0; i < len; i++) {
            if(used[i]) continue;
            used[i] = true;
            backTrack(set, used, tiles, curr + tiles.charAt(i));
            used[i] = false;
        }
    }

    public static int numTilePossibilities2(String tiles) {
        List<String> list = new ArrayList<>();
        permutateWord("", tiles, list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(list);
        return list.size();
    }
    public static void permutateWord(String unProcessed, String processed, List<String> list) {
        if(processed.isEmpty()) {
            return;
        }
        for(int j = 0; j < processed.length(); j++) {
            char ch = processed.charAt(j);
            for (int i = 0; i <= unProcessed.length(); i++) {
                String first = unProcessed.substring(0, i);
                String second = unProcessed.substring(i);
                if (!list.contains(first + ch + second)) {
                    list.add(first + ch + second);
                }
                permutateWord(first + ch + second, processed.substring(0,j) + processed.substring(j+1), list);
            }
        }
    }

    public static void main(String[] args) {
        String tiles = "MOTWMI";
        System.out.println(numTilePossibilities(tiles));
    }
}
