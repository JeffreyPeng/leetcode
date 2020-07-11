import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class Q0017v2 {

    public static void main(String[] args) {
        List<String> strings = new Solution17v2().letterCombinations("");
        strings.forEach(System.out::println);
    }
}

class Solution17v2 {

    static Map<String, String> map = new HashMap<>();
    static {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
    }
    private List<String> outList = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return outList;
        }
        recur("", digits);
        return outList;
    }
    private void recur(String pre, String next) {
        if (next == null) {
            outList.add(pre);
            return;
        }
        String first = next.substring(0, 1);
        String rest = next.length() > 1 ? next.substring(1): null;
        char[] letters = map.get(first).toCharArray();
        for (char c : letters) {
            recur(pre + c, rest);
        }
    }
}