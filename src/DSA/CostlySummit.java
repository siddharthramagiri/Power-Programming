package DSA;

public class CostlySummit {
    static int withLearning = 0;
    static int withoutLearn = 0;
    public static void getMinCost(String Languages, int len, int cost) {
        backTrackWithoutLearning(Languages, len, 0, 1);
        int[] freq = new int[26];
        int minFrq = 0;
        char Learned = Languages.charAt(0);
        for(char ch : Languages.toCharArray()) {
            freq[ch-'A']++;
            if(freq[ch-'A'] > minFrq) {
                Learned = ch;
                minFrq = freq[ch - 'A'];
            }
        }
        backTrackWithLearning(Languages, len, 0, 1, Learned);
        System.out.println(withoutLearn + " : " + (withLearning + cost));
    }
    public static void backTrackWithoutLearning(String Language, int len, int i, int n) {
        if(i >= len) {
            return;
        }
        withoutLearn += n;
        backTrackWithoutLearning(Language.substring(1), len, i+1, n + 1);
    }
    public static void backTrackWithLearning(String Language, int len, int i, int n, char Learned) {
        if(i >= len) {
            return;
        } else if (Language.charAt(0) == Learned) {
            backTrackWithLearning(Language.substring(1), len, i+1, n, Learned);
            return;
        }
        withLearning += n;
        backTrackWithLearning(Language.substring(1), len, i+1, n+1, Learned);
    }

    public static void getCost(String Languages, int len, int cost) {
        int withoutLearn = 0;
        int[] freq = new int[26];
        int max = 0;
        int i = 1;
        char learned = Languages.charAt(0);
        for(char ch : Languages.toCharArray()) {
            freq[ch - 'A']++;
            if(freq[ch - 'A'] > max) {
                max = freq[ch - 'A'];
                learned = ch;
            }
            withoutLearn += i;
            i++;
        }
        int withLearning = cost;
        i = 1;
        for(char ch : Languages.toCharArray()) {
            if(learned == ch) {
                continue;
            }
            withLearning += i;
            i++;
        }
        System.out.println(withoutLearn + " : " + withLearning);
    }

    public static void main(String[] args) {
        getMinCost("DCBAE", 5, 4);
        getCost("DCBAE", 5, 4);
    }
}
