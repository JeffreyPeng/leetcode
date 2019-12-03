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
public class Q0017 {

    public static void main(String[] args) {
        List<String> strings = new Solution17().letterCombinations("23");
        strings.forEach(System.out::println);
    }
}

class Solution17 {

    private Map<String, String> map = new HashMap<>();
    private List<String> list = new ArrayList<>();

    // TODO need improve
    public List<String> letterCombinations(String digits) {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        recur(digits);
        return list;
    }

    void recur(String d) {
        if (d.length() == 1) {
            if (list.size() == 0) {
                map.get(d).chars().forEach(c -> list.add((char) c + ""));
            } else {
                List<String> resultList = new ArrayList<>();
                map.get(d).chars().forEach(c -> list.forEach(s -> resultList.add(s + (char) c)));
                list = resultList;
            }
            return;
        }
        if (d.length() > 1) {
            recur(d.substring(0, 1));
            recur(d.substring(1));
        }
    }
}