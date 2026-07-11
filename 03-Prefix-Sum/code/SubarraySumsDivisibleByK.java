public class SubarraySumsDivisibleByK {
    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;

        int result = subarraysDivByK(nums, k);

        System.out.println(result); // Output: 7
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        
        // Remainder frequency array of size k
        int[] remCounts = new int[k];
        remCounts[0] = 1; // Base case

        for (int num : nums) {
            prefixSum += num;
            
            // Normalize remainder to handle negative prefix sums
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
