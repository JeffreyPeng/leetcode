import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 451. Sort Characters By Frequency
 * 
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 */
public class Q0451V1 {

    public static void main(String[] args) {
    }
}
class Solution451V1 {
    public String frequencySort(String s) {
        int[] letters = new int[256];
        for (Character c : s.toCharArray()) {
            letters[c]++;
        }
        List<CharCount> list = new ArrayList<>();
        for (int i=0; i < letters.length; i++) {
            if (letters[i] == 0) continue;
            char c = (char)i;
            list.add(new CharCount(c, letters[i]));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            CharCount cc = list.get(i);
            for (int j = cc.count; j > 0; j--) {
                sb.append(cc.c);
            }
        }
        return sb.toString();
    }
    private static class CharCount implements Comparable<CharCount>{
        char c;
        int count;
        public CharCount(char c, int count) {
            this.c = c;
            this.count = count;
        }
        @Override
        public int compareTo(CharCount cc) {
            return count - cc.count;
        }
    }
}