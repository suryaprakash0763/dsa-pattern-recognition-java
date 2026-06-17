public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {

        int[] nums = {1, 1, 0, 0, 1, 1, 1, 0, 1, 1};
        int k = 2;

        int left = 0;
        int maxLength = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {

            // If current element is 0, increase zero count
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If too many zeros to flip, shrink from left
            while (zeroCount > k) {

                // If the leaving element is 0, decrease zero count
                if (nums[left] == 0) {
                    zeroCount--;
                }

                left++;
            }

            // Current valid window length
            int currentLength = right - left + 1;

            // Store maximum length
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        System.out.println(maxLength);
    }
}
