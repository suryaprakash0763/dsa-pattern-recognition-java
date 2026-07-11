import java.util.HashMap;

public class LongestSubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;

        System.out.println("Brute Force Output: " + longestSubarraySumBruteForce(nums, k));
        System.out.println("Optimized Output: " + longestSubarraySumOptimized(nums, k));
    }

    // Brute Force: O(n^2) Time, O(1) Space
    public static int longestSubarraySumBruteForce(int[] nums, int k) {
        int maxLength = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    // Optimized: O(n) Time, O(n) Space (Prefix Sum + HashMap)
    public static int longestSubarraySumOptimized(int[] nums, int k) {
        int maxLength = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        // Base case: prefix sum 0 occurs at index -1
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // If (prefixSum - k) has occurred before, calculate length
            if (map.containsKey(prefixSum - k)) {
                int length = i - map.get(prefixSum - k);
                maxLength = Math.max(maxLength, length);
            }

            // Store prefixSum only if it is not already present
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}
