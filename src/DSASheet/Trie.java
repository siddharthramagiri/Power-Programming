package DSASheet;

import java.util.HashSet;

public class Trie {
    HashSet<String> set;
    public Trie() {
        set = new HashSet<>();
        System.out.println("NULL");
    }

    public void insert(String word) {
        set.add(word);
        System.out.println("NULL");
    }

    public boolean search(String word) {
        return set.contains(word);
    }

    public boolean startsWith(String prefix) {
        for(String str : set) {
            if(str.startsWith(prefix)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
