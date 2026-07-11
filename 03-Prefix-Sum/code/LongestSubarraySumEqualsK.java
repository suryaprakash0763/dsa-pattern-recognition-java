import java.util.HashMap;

public class LongestSubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        System.out.println(longestSubarraySum(nums, k)); // Output: 4
    }

    public static int longestSubarraySum(int[] nums, int k) {
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
