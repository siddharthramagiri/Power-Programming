package DSA;

import java.util.Arrays;

public class ClothingStore {
    static class Peoples {
        int val;
        int key;
        public Peoples(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    public static void getHappyPeoples(int[] size, int[] peoples) {
        Peoples[] people = new Peoples[3];
        int total_peoples = 0;
        for(int i = 0; i < 3; i++) {
            total_peoples += peoples[i];
            people[i] = new Peoples(i,peoples[i]);
        }
        Arrays.sort(people, (Peoples a, Peoples b) -> b.val - a.val);
        int remaining = 0;
        for(int i = 0; i < 3; i++) {
            int j = people[i].key;
            System.out.println(people[i].key + " => " + people[i].val);
            while(people[i].val > 0 && j < 3) {
                if(size[j] <= people[i].val) {
                    people[i].val = people[i].val - size[j];
                    size[j] = 0;
                } else {
                    size[j] = size[j] - people[i].val;
                    people[i].val = 0;
                }
                j++;
            }
            remaining += people[i].val;
            System.out.println(people[i].key + " => " + people[i].val);
        }
        System.out.println(total_peoples - remaining);
    }

    public static void main(String[] args) {
        int[] sizes = {1,2,3};
        int[] peoples = {5,0,0};
        getHappyPeoples(sizes, peoples);
    }
}
