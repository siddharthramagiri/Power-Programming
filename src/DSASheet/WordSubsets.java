package DSASheet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets {
    public static List<String> wordSubsetsMap(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();
        HashMap<Character,Integer> freq = new HashMap<>();
        HashMap<Character,Integer> tempFreq;
        for(String word : words2) {
            tempFreq = new HashMap<>();
            for(char ch : word.toCharArray()) {
                tempFreq.put(ch, tempFreq.getOrDefault(ch,0)+1);
            }
            for(Map.Entry<Character,Integer> map : tempFreq.entrySet()) {
                freq.put(map.getKey(), Math.max(freq.getOrDefault(map.getKey(),0),map.getValue()));
            }
        }
        System.out.println(freq);
        for(String word : words1) {
            tempFreq = new HashMap<>();
            for(char ch : word.toCharArray()) {
                tempFreq.put(ch, tempFreq.getOrDefault(ch,0)+1);
            }
            boolean found = true;
            for(Map.Entry<Character,Integer> map : freq.entrySet()) {
                if (tempFreq.getOrDefault(map.getKey(),0) < map.getValue()) {
                    found = false;
                    break;
                }
            }
            if(found) list.add(word);
        }
        return list;
    }
    public static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();
        int[] freq = new int[26];
        int[] tempFreq;
        for(String word : words2) {
            tempFreq = new int[26];
            for(char ch : word.toCharArray()) {
                tempFreq[ch - 'a']++;
            }
            for(int i = 0; i < 26; i++) {
                freq[i] = Math.max(freq[i],tempFreq[i]);
            }
        }
        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                System.out.println((char) (i + 'a') + " -> " + freq[i]);
            }
        }
        for(String word : words1) {
            tempFreq = new int[26];
            for(char ch : word.toCharArray()) {
                tempFreq[ch - 'a']++;
            }
            boolean found = true;
            for(int i = 0; i < 26; i++) {
                if(freq[i] > tempFreq[i]) {
                    found = false;
                    break;
                }
            }
            if(found) list.add(word);
        }
        return list;
    }
    public static void main(String[] args) {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"}, words2 = {"oc","ec","ceo"};
        System.out.println(wordSubsets(words1,words2));
    }
}
