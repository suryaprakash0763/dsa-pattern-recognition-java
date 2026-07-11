import java.util.Arrays;

public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        System.out.println("Brute Force Output: " + Arrays.toString(productExceptSelfBruteForce(nums)));
        System.out.println("Optimized Output: " + Arrays.toString(productExceptSelfOptimized(nums)));
    }

    // Brute Force: O(n^2) Time, O(1) auxiliary Space
    public static int[] productExceptSelfBruteForce(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            ans[i] = product;
        }
        return ans;
    }

    // Optimized: O(n) Time, O(1) auxiliary Space
    public static int[] productExceptSelfOptimized(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // Step 1: Calculate prefix products (store in ans)
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate suffix products on the fly and multiply with prefix
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * suffix;
            suffix *= nums[i];
        }

        return ans;
    }
}
