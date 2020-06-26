import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 451. Sort Characters By Frequency
 * 
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 */
public class Q0451 {

    public static void main(String[] args) {
    }
}
class Solution451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] buckets = new LinkedList[s.length() + 1];
        for (Character c : map.keySet()) {
            if (buckets[map.get(c)] == null) {
                buckets[map.get(c)] = new LinkedList<Character>();
            }
            buckets[map.get(c)].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
            for (Character c : buckets[i]) {
                for (int j = i; j > 0; j--) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
