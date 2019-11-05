import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 * 
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * Example:
 * 
 * Input: "25525511135" Output: ["255.255.11.135", "255.255.111.35"]
 */

public class Q0093 {

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }

    static LinkedList<String> sList = new LinkedList<>();

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return null;
        if (s.length() == 1 && testNext(s)) {
            sList.push(s);
            return sList;
        }
        for (int i=1; i < s.length(); i++) {
            s.substring(0, i);
        }
    }

    static boolean testNext(String s) {
        if (sList.size() > 3) return false;
        if (s.length() > 3) return false;
        try {

        } catch (Exception e) {

        }
        if (Integer.parseInt(s) > 255) return false;
        return true;
    }
}