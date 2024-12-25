package RecursionsKunal;

import java.util.ArrayList;

public class GenerateNumbs {

    public static void main(String[] args) {
        System.out.println(generateAll(10, new String[] {"1","3","5","7"}));
    }

    public static ArrayList<String> generateAll(int n, String[] arr) {
        ArrayList<String> list = new ArrayList<>();
        int i = 1;
        int prev = 0;
        for(String el : arr)
            list.add(el);

        while(i < n) {
            int size = list.size();
            for(int j = 0; j < arr.length; j++) {
                for(int k = prev; k < size; k++) {
                    String str = arr[j] + list.get(k);
                    if(list.size() >= n) {
//                         System.out.println(list);
                        return list;
                    }
                    list.add(str);
                    i++;
                }
            }
            prev = size;
        }
        return list;
    }
}
