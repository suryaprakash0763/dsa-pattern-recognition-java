class RangeSumQueryBrute {
    private int[] nums;

    public RangeSumQueryBrute(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

public class RangeSumQueryImmutable {
    private int[] prefix;

    public RangeSumQueryImmutable(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};

        // Brute Force Demonstration
        RangeSumQueryBrute brute = new RangeSumQueryBrute(nums);
        System.out.println("Brute Force Query (0, 2): " + brute.sumRange(0, 2));
        System.out.println("Brute Force Query (2, 5): " + brute.sumRange(2, 5));

        // Optimized Demonstration
        RangeSumQueryImmutable optimized = new RangeSumQueryImmutable(nums);
        System.out.println("Optimized Query (0, 2): " + optimized.sumRange(0, 2));
        System.out.println("Optimized Query (2, 5): " + optimized.sumRange(2, 5));
    }
}
