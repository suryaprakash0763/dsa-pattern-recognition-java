public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;

        System.out.println("Brute Force Output: " + numberOfNiceSubarraysBruteForce(nums, k));
        System.out.println("Optimized Output: " + numberOfNiceSubarraysOptimized(nums, k));
    }

    // Brute Force: O(n^2) Time, O(1) Space
    public static int numberOfNiceSubarraysBruteForce(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int oddCount = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 != 0) {
                    oddCount++;
                }
                if (oddCount == k) {
                    count++;
                } else if (oddCount > k) {
                    break;
                }
            }
        }
        return count;
    }

    // Optimized: O(n) Time, O(n) Space (Prefix Odd Count Frequency Array)
    public static int numberOfNiceSubarraysOptimized(int[] nums, int k) {
        int niceSubarrays = 0;
        int oddCount = 0;
        int n = nums.length;

        int[] counts = new int[n + 1];
        counts[0] = 1; // Base case: 0 odd numbers has occurred once

        for (int num : nums) {
            oddCount += Math.abs(num % 2); // math.abs to handle negative numbers if present

            if (oddCount >= k) {
                niceSubarrays += counts[oddCount - k];
            }

            counts[oddCount]++;
        }

        return niceSubarrays;
    }
}
