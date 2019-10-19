import java.util.HashMap;
import java.util.Map;

/**
3. Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */
public class Q0003 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    // TODO need improve
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                max = map.size() > max ? map.size() : max;
                i = map.get(s.charAt(i)) + 1;
                map.clear();
            }
            map.put(s.charAt(i), i);
        }
        max = map.size() > max ? map.size() : max;
        return max;
    }
}
