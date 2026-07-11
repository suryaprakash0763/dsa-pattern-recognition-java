import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;

        System.out.println("Brute Force Output: " + subarraySumBruteForce(nums, k));
        System.out.println("Optimized Output: " + subarraySumOptimized(nums, k));
    }

    // Brute Force: O(n^2) Time, O(1) Space
    public static int subarraySumBruteForce(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // Optimized: O(n) Time, O(n) Space (Prefix Sum + HashMap)
    public static int subarraySumOptimized(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: prefix sum of 0 has occurred 1 time
        map.put(0, 1);

        for (int num : nums) {
            prefixSum += num;

            // Check if (prefixSum - k) exists in map
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // Record current prefixSum in map
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
