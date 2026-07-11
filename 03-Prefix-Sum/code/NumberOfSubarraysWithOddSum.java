public class NumberOfSubarraysWithOddSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        System.out.println(numOfSubarrays(arr)); // Output: 4
    }

    public static int numOfSubarrays(int[] arr) {
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
