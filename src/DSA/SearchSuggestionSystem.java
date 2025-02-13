package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionSystem {
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> list = new ArrayList<>();
        Arrays.sort(products);
        List<String> shortlist = new ArrayList<>(Arrays.asList(products));
        StringBuilder str = new StringBuilder();
        for(char ch : searchWord.toCharArray()) {
            str.append(ch);
            List<String> suggested = new ArrayList<>();
            for(int i = 0; i < shortlist.size(); i++) {
                String product = shortlist.get(i);
                if(product.startsWith(str.toString())) {
                    suggested.add(product);
                    System.out.println(str + " : " + product);
                    if(suggested.size() >= 3) break;
                } else {
                    shortlist.remove(i);
                    i--;
                }
            }
            list.add(suggested);
        }

        return list;
    }
    public static void main(String[] args) {
        String[] products = {"havana", "have", "hello", "haaaiii"};
        String searchWord = "havana";

        System.out.println(suggestedProducts(products, searchWord));
    }
}
