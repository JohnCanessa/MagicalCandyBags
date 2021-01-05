import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * Magical Candy Bags
 * https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=513590792640579
 */
public class MagicalCandyBags {


    /**
     * You have k minutes to eat as much candy as possible. 
     * How many pieces of candy can you eat?
     * O(n)
     */
    static int maxCandies(int[] arr, int k) {

        // **** initialization ****
        int candies = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare (Integer i0, Integer i1) {
                if (i1 > i0)
                    return 1;
                else if (i0 == i1)
                    return 0;
                else
                    return -1;
            }
        });

        // **** populate priority queue O(n)****
        for (int a : arr)
            pq.add(a);
        
        // **** loop eating candies O(k) ****
        for (int m = 0; m < k; m++) {

            // **** eat all candies from head bag ****
            int pieces = pq.remove();

            // **** count number of candies eaten ****
            candies += pieces;

            // **** compute pieces for next minute ****
            pieces = Math.floorDiv(pieces, 2);

            // **** add pieces for next minute ****
            pq.add(pieces);
        }

        // **** max number of candies ****
        return candies;
    }


    /**
     * Test scaffolding
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // **** read array of integers ****
        String[] strArr = br.readLine().trim().split(",");

        // **** read number of minutes ****
        int K = Integer.parseInt(br.readLine().trim());

        // **** close buffered reader ****
        br.close();

        // **** generate array of int ****
        int[] arr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();

        // ???? ????
        System.out.println("main <<< arr: " + Arrays.toString(arr));
        System.out.println("main <<<   K: " + K);

        // **** max number of candies one can eat in the specified time ****
        System.out.println("main <<< output: " + maxCandies(arr, K));
    }
}