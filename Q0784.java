import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 784. Letter Case Permutation
 *
 * Given a string S, we can transform every letter individually to be lowercase
 * or uppercase to create another string.  Return a list of all possible strings
 * we could create.
 * 
 * Examples:
 * 
 * Input: S = "a1b2" Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * 
 * Input: S = "3z4" Output: ["3z4", "3Z4"]
 * 
 * Input: S = "12345" Output: ["12345"]
 * 
 * Note: S will be a string with length between 1 and 12. S will consist only of
 * letters or digits.
 *
 * 
 */
public class Q0784 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(letterCasePermutation("a1b2").toArray()));
    }

    public static List<String> resultList = new ArrayList<>();

    public static List<String> letterCasePermutation(String s) {
        resultList.clear();
        s = s.toLowerCase();
        f(s, 0);
        return resultList;
    }

    public static void f(String s, int idx) {
        if (idx >= s.length()) {
            resultList.add(s);
            return;
        }
        Character c = s.charAt(idx);
        if (c >= 'a' && c <= 'z') {
            char[] arr = s.toCharArray();
            arr[idx] = Character.toUpperCase(c);
            String su = String.valueOf(arr);
            idx++;
            f(s, idx);
            f(su, idx);
        } else {
            idx++;
            f(s, idx);
        }
    }
}
