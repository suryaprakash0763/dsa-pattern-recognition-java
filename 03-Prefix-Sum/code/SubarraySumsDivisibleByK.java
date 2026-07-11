public class SubarraySumsDivisibleByK {
    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;

        System.out.println("Brute Force Output: " + subarraysDivByKBruteForce(nums, k));
        System.out.println("Optimized Output: " + subarraysDivByKOptimized(nums, k));
    }

    // Brute Force: O(n^2) Time, O(1) Space
    public static int subarraysDivByKBruteForce(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                // Handle negative remainder correctly in Java
                int rem = sum % k;
                if (rem < 0) {
                    rem += k;
                }
                if (rem == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    // Optimized: O(n) Time, O(k) Space
    public static int subarraysDivByKOptimized(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        int[] remCounts = new int[k];
        remCounts[0] = 1; // Base case

        for (int num : nums) {
            prefixSum += num;
            int rem = prefixSum % k;
            if (rem < 0) {
                rem += k;
            }
            count += remCounts[rem];
            remCounts[rem]++;
        }

        return count;
    }
}
