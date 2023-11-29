public class Staircase {
    /**
    Staircase. Given a staircase of N steps.
     Write an algorithm that returns how many combinations can be made to climb this stair
     if you are allowed to take only 1 or 2 steps at once. As an “exception”,
     a staircase of N = 0 would return 1 (there is one way to climb a staircase with no steps, which is stay where you are).

    Some examples:
     N=1:
        _
     N=2
        _ _
        __

     N=3
        _ _ _
        _ __
        __ _

     N=4
        - - - -
        -- --
        -- - -
        - -- -
        - - --

     */

    public static int Stairs(int n){
        if (n == 0) {
            return 1;
        }

        if (n == 2){
            return 2;
        }

        if (n == 1){
            return 1;
        }

        if (n < 2){
            return Stairs(n);
        }
        return n;
    }

        public static int ClimbStairsDynamic(int n) {
            // Base case: There is one way to climb a staircase with no steps
            if (n == 0) {
                return 1;
            }

            // Initialize an array to store the number of ways for each step
            int[] ways = new int[n + 1];

            // There is one way to climb a staircase with 1 step
            ways[1] = 1;

            // There are two ways to climb a staircase with 2 steps: 1+1 or 2
            ways[2] = 2;

            // Calculate the number of ways for each step from 3 to n
            for (int i = 3; i <= n; i++) {
                ways[i] = ways[i - 1] + ways[i - 2];
            }

            // The final result is stored in ways[n]
            return ways[n];
        }

    public static int ClimbStairsRecursive(int n) {
        // Base case: There is one way to climb a staircase with no steps
        if (n == 0) {
            return 1;
        }

        // Base case: There is one way to climb a staircase with 1 step
        if (n == 1) {
            return 1;
        }

        // Recursive case: Number of ways is the sum of ways for (n-1) and (n-2) steps
        return ClimbStairsRecursive(n - 1) + ClimbStairsRecursive(n - 2);
    }


    public static void main(String[] args) {

        System.out.println(ClimbStairsRecursive(3));

    }
}
