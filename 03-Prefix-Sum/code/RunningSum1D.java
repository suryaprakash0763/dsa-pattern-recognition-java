import java.util.Arrays;

public class RunningSum1D {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println("Brute Force Output: " + Arrays.toString(runningSumBruteForce(nums1)));
        System.out.println("Optimized Output: " + Arrays.toString(runningSumOptimized(nums2)));
    }

    // Brute Force: O(n^2) Time, O(n) Space
    public static int[] runningSumBruteForce(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += nums[j];
            }
            result[i] = sum;
        }
        return result;
    }

    // Optimized: O(n) Time, O(1) Space (In-place)
    public static int[] runningSumOptimized(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
