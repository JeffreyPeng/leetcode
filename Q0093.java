import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
        System.out.println(new Q0093().restoreIpAddresses("25525511135"));
        System.out.println(new Q0093().restoreIpAddresses("010010"));
    }

    private LinkedList<String> sList = new LinkedList<>();
    private Set<String> result = new HashSet<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12 || s.length() < 4)
            return new ArrayList<>(result);
        recr(s);
        return new ArrayList<>(result);
    }

    private void recr(String s) {
        if (sList.size() == 4 || s.length() == 0) {
            if (sList.size() == 4 && s.length() == 0) {
                result.add(join(sList));
            }
            if (sList.size() > 0) {
                sList.removeLast();
                return;
            }
        }
        for (int i = 0; i < 3 && i < s.length(); i++) {
            String pre = s.substring(0, i + 1);
            int sti = Integer.parseInt(pre);
            if (sti > 255 || (pre.length() > 1 && pre.indexOf('0') == 0))
                continue;
            sList.add(pre);
            recr(s.substring(i + 1, s.length()));
        }
        if (sList.size() > 0) {
            sList.removeLast();
            return;
        }
    }

    private String join(List<String> list) {
        StringBuilder sb = new StringBuilder();
        list.stream().forEach(s -> sb.append(s).append("."));
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}