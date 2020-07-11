import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz Write a program that outputs the string representation of
 * numbers from 1 to n.
 * 
 * But for multiples of three it should output “Fizz” instead of the number and
 * for the multiples of five output “Buzz”. For numbers which are multiples of
 * both three and five output “FizzBuzz”.
 */
public class Q0412 {

    public static void main(String[] args) {
    }
}

class Solution412 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean d3 = i % 3 == 0;
            boolean d5 = i % 5 == 0;
            if (d3 && d5) {
                result.add("FizzBuzz");
            } else if (d3) {
                result.add("Fizz");
            } else if (d5) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}