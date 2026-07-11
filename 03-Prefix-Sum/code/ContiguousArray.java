import java.util.HashMap;

public class ContiguousArray {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0};

        System.out.println("Brute Force Output: " + findMaxLengthBruteForce(nums));
        System.out.println("Optimized Output: " + findMaxLengthOptimized(nums));
    }

    // Brute Force: O(n^2) Time, O(1) Space
    public static int findMaxLengthBruteForce(int[] nums) {
        int maxLength = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int zeros = 0;
            int ones = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    zeros++;
                } else {
                    ones++;
                }
                if (zeros == ones) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    // Optimized: O(n) Time, O(n) Space (Prefix Sum + HashMap)
    public static int findMaxLengthOptimized(int[] nums) {
        int maxLength = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: prefix sum 0 occurs at index -1
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += (nums[i] == 1) ? 1 : -1;

            if (map.containsKey(prefixSum)) {
                int length = i - map.get(prefixSum);
                if (length > maxLength) {
                    maxLength = length;
                }
            } else {
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}
