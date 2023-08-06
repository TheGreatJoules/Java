import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    private static int scaleCount = 0;
    public static void main(String[] args) {
        int[] coins = new int[] {3, 3, 3, 3, 4, 3, 3, 3, 3, 3};
        findCounterfeit(coins);
    }

    public static int findCounterfeit(int[] coins) {
        int n = coins.length;
        // If length is lower than 1, no coins left to compare
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            printStats(coins);
            return 0;
        }
        int[] left = Arrays.copyOfRange(coins, 0, n/2);
        int[] right = Arrays.copyOfRange(coins, n/2, 2*(n/2));
        int[] offset = Arrays.copyOfRange(coins, 2*(n/2), n);
        int biased = checkScale(left, right);
        // Not Balanced
        if (biased != 0) {
            System.out.println("NOT balanced");
            int[] lower = IntStream.concat(Arrays.stream(Arrays.copyOfRange(left, 0, left.length/2)), Arrays.stream(offset)).toArray();
            int[] upper = IntStream.concat(Arrays.stream(Arrays.copyOfRange(right, 0, right.length/2)), Arrays.stream(offset)).toArray();
            int result = checkScale(lower, upper);
            int[] pivot = result != 0 ? Arrays.copyOfRange(left, left.length-1, left.length) : Arrays.copyOfRange(left, 0, 1);
            int[] next = result != 0 ? IntStream.concat(Arrays.stream(Arrays.copyOfRange(left, 0, left.length/2)), Arrays.stream(Arrays.copyOfRange(right, 0, right.length/2))).toArray()
                                    : IntStream.concat(Arrays.stream(Arrays.copyOfRange(left, left.length/2, left.length)), Arrays.stream(Arrays.copyOfRange(right, right.length/2, right.length))).toArray();
            if (next.length <= 4) {
                next = Arrays.stream(next).filter(f -> f != pivot[0]).toArray();
            }
            return findCounterfeit(next);
        }
        // Both is Balanced
        System.out.println("YES balanced");
        return findCounterfeit(offset);
    }

    private static int checkScale(int[] left, int[] right) {
        scaleCount += 1;
        int leftSum = Arrays.stream(left).sum();
        int rightSum = Arrays.stream(right).sum();
        if (leftSum < rightSum) {
            return -1;
        } else if (leftSum > rightSum) {
            return 1;
        }
        return 0;
    }

    public static void printStats(int[] coins) {
        System.out.println("Defect Coin: " + Arrays.toString(coins));
        System.out.println("Weight Usage: " + scaleCount);
    }
}