class Solution {
    public static void main(String[] args) {
        Solution.leftshift();
        Solution.rightshift();
    }

    /**
     * Multiplying the value by 2^n
     */
    public static void leftshift() {
        // Number to be shifted
        int x = 5;
        // Number of positions
        int n = 1;
        // Shifting x by n positions towards left using left shift operator
        int result = x << n;
        System.out.println("[LEFT-SHIFT] " + x + " by " + n + " positions: " + result);
        System.out.println("[LEFT-SHIFT] " + result + " by " + 1 + " positions: " + (result << 1));
        System.out.println("[LEFT-SHIFT] " + result + " by " + 2 + " positions: " + (result << 2));
        System.out.println("[LEFT-SHIFT] " + result + " by " + 3 + " positions: " + (result << 3));
    }

    /**
     * Diving the value by 2^n
     */
    public static void rightshift() {
        // Number to be shifted
        int x = 80;
        // Number of positions
        int n = 1;
        // Shifting x by n positions towards left using left shift operator
        int result = x >> n;
        System.out.println("[RIGHT-SHIFT] " + x + " by " + n + " positions: " + result);
        System.out.println("[RIGHT-SHIFT] " + result + " by " + 1 + " positions: " + (result >> 1));
        System.out.println("[RIGHT-SHIFT] " + result + " by " + 2 + " positions: " + (result >> 2));
        System.out.println("[RIGHT-SHIFT] " + result + " by " + 3 + " positions: " + (result >> 3));
    }
}