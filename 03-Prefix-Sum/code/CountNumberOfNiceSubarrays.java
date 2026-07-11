public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(numberOfNiceSubarrays(nums, k)); // Output: 2
    }

    public static int numberOfNiceSubarrays(int[] nums, int k) {
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
