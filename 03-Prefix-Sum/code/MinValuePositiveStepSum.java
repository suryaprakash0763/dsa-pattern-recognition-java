public class MinValuePositiveStepSum {
    public static void main(String[] args) {
        int[] nums = {-3, 2, -3, 4, 2};

        int minStartVal = minStartValue(nums);

        System.out.println(minStartVal); // Output: 5
    }

    public static int minStartValue(int[] nums) {
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
