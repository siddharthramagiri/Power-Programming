package Queues;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    class Pair {
        char key;
        int freq;
        public Pair(char key, int freq) {
            this.key = key;
            this.freq = freq;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        int ans = 0;
        int len = tasks.length;
        int inserts = 0;
        char[] freq = new char[26];
        for(char ch : tasks) freq[ch - 'A']++;
        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                pq.offer(new Pair((char)('A' + i), freq[i]));
            }
        }
        while(!pq.isEmpty()) {
            List<Pair> list = new ArrayList<>();
            Pair p = pq.poll();
            p.freq--;
            inserts++;
            ans++;
            if(inserts == len) return ans;
            if(p.freq > 0)
                list.add(p);
            int t = 0;
            while(t < n) {
                if(!pq.isEmpty()) {
                    p = pq.poll();
                    p.freq--;
                    inserts++;
                    if(p.freq > 0)
                        list.add(p);
                    ans++;
                    t++;
                    if(inserts == len) return ans;
                } else {
                    ans++;
                    t++;
                }
            }
            pq.addAll(list);
        }
        return ans;
    }
    public static void main(String[] args) {
        char[] tasks = {'A','A'};
        int n = 2;
        System.out.println(new TaskScheduler().leastInterval(tasks, n));
    }
}
