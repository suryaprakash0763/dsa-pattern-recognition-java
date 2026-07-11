public class MinValuePositiveStepSum {
    public static void main(String[] args) {
        int[] nums = {-3, 2, -3, 4, 2};

        System.out.println("Brute Force Output: " + minStartValueBruteForce(nums));
        System.out.println("Optimized Output: " + minStartValueOptimized(nums));
    }

    // Brute Force: O(n * ans) Time, O(1) Space
    public static int minStartValueBruteForce(int[] nums) {
        int startValue = 1;
        while (true) {
            int currentSum = startValue;
            boolean isValid = true;
            for (int num : nums) {
                currentSum += num;
                if (currentSum < 1) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                return startValue;
            }
            startValue++;
        }
    }

    // Optimized: O(n) Time, O(1) Space
    public static int minStartValueOptimized(int[] nums) {
        int sum = 0;
        int minSum = 0;

        for (int num : nums) {
            sum += num;
            if (sum < minSum) {
                minSum = sum;
            }
        }

        return 1 - minSum;
    }
}
