/**
 * 1094. Car Pooling
 *
 * You are driving a vehicle that has capacity empty seats initially available
 * for passengers. The vehicle only drives east (ie. it cannot turn around and
 * drive west.)
 *
 * Given a list of trips, trip[i] = [num_passengers, start_location,
 * end_location] contains information about the i-th trip: the number of
 * passengers that must be picked up, and the locations to pick them up and drop
 * them off. The locations are given as the number of kilometers due east from
 * your vehicle's initial location.
 *
 * Return true if and only if it is possible to pick up and drop off all
 * passengers for all the given trips.
 *
 * Example 1:
 *
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4 Output: false Example 2:
 *
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5 Output: true Example 3:
 *
 * Input: trips = [[2,1,5],[3,5,7]], capacity = 3 Output: true Example 4:
 *
 * Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11 Output: true
 *
 *
 *
 * Constraints:
 *
 * trips.length <= 1000 trips[i].length == 3 1 <= trips[i][0] <= 100 0 <=
 * trips[i][1] < trips[i][2] <= 1000 1 <= capacity <= 100000
 *
 */
public class Q1094 {

    public static void main(String[] args) {
        int[][] trips1 = { { 2, 1, 5 }, { 3, 3, 7 } };
        System.out.println(carPooling(trips1, 4));
        int[][] trips2 = { { 2, 1, 5 }, { 3, 3, 7 } };
        System.out.println(carPooling(trips2, 5));
        int[][] trips3 = { { 2, 1, 5 }, { 3, 5, 7 } };
        System.out.println(carPooling(trips3, 3));
        int[][] trips4 = { { 3, 2, 7 }, { 3, 7, 9 }, { 8, 3, 9 } };
        System.out.println(carPooling(trips4, 11));
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int[] sumInLoc = new int[1000];
        for (int i = 0; i < sumInLoc.length; i++) {
            sumInLoc[i] = 0;
        }
        for (int i = 0; i < trips.length; i++) {
            int num = trips[i][0];
            int start = trips[i][1];
            int end = trips[i][2];
            for (; start < end; start++) {
                sumInLoc[start] += num;
                if (sumInLoc[start] > capacity) {
                    return false;
                }
            }
        }
        return true;
    }
}
