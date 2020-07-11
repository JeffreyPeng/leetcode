import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters. Example:
 * 
 * Input: "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 */
public class Q0017v1 {

    public static void main(String[] args) {
        List<String> strings = new Solution17().letterCombinations("23");
        strings.forEach(System.out::println);
    }
}

class Solution17v1 {
    String[][] store = new String[][]{
        new String[] {"0"},
        new String[] {"0"},
        new String[] {"a", "b", "c"},
        new String[] {"d", "e", "f"},
        new String[] {"g", "h", "i"},
        new String[] {"j", "k", "l"},
        new String[] {"m", "n", "o"},
        new String[] {"p", "q", "r", "s"},
        new String[] {"t", "u", "v"},
        new String[] {"w", "x", "y", "z"}
    };
    public List<String> letterCombinations(String digits) {
        List<String> pre = new ArrayList<>();
        for (int d=0; d<digits.length(); d++) {
            String[] letters = store[digits.charAt(d) - '0'];
            if (pre.size() == 0) {
                pre.addAll(Arrays.asList(letters));
                continue;
            }
            List<String> current = new ArrayList<>();
            for (String s : letters) {
                for (String pres : pre) {
                    current.add(pres + s);
                }
            }
            pre = current;
        }
        return pre;
    }
}