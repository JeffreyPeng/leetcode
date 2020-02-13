
/**
 * 14. Longest Common Prefix Write a function to find the longest common prefix
 * string amongst an array of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * Input: ["flower","flow","flight"] Output: "fl" Example 2:
 * 
 * Input: ["dog","racecar","car"] Output: "" Explanation: There is no common
 * prefix among the input strings. Note:
 * 
 * All given inputs are in lowercase letters a-z.
 */
public class Q0014 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
        System.out.println(longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
        System.out.println(longestCommonPrefix(new String[] { "dog" }));
        System.out.println(longestCommonPrefix(new String[] {}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}