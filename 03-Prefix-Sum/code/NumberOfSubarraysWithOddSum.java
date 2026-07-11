public class NumberOfSubarraysWithOddSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};

        System.out.println("Brute Force Output: " + numOfSubarraysBruteForce(arr));
        System.out.println("Optimized Output: " + numOfSubarraysOptimized(arr));
    }

    // Brute Force: O(n^2) Time, O(1) Space
    public static int numOfSubarraysBruteForce(int[] arr) {
        int count = 0;
        int MOD = 1000000007;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum % 2 != 0) {
                    count = (count + 1) % MOD;
                }
            }
        }
        return count;
    }

    // Optimized: O(n) Time, O(1) Space
    public static int numOfSubarraysOptimized(int[] arr) {
        int MOD = 1000000007;
        int count = 0;
        int prefixSum = 0;

        int evenPrefCount = 1; // Base case: prefix sum of 0 at index -1
        int oddPrefCount = 0;

        for (int num : arr) {
            prefixSum += num;

            // In Java, % on negative values can be negative, but since we are working with
            // sums of array elements, we check if remainder is non-zero
            if (prefixSum % 2 == 0) {
                count = (count + oddPrefCount) % MOD;
                evenPrefCount++;
            } else {
                count = (count + evenPrefCount) % MOD;
                oddPrefCount++;
            }
        }

        return count;
    }
}
