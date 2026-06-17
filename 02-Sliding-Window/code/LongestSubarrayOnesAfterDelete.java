public class LongestSubarrayOnesAfterDelete {
    public static void main(String[] args) {

        int[] nums = {1, 1, 0, 1, 1, 1};

        int left = 0;
        int maxLength = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {

            // If current element is 0, increase zero count
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If more than 1 zero, shrink from left
            while (zeroCount > 1) {

                // If the leaving element is 0, decrease zero count
                if (nums[left] == 0) {
                    zeroCount--;
                }

                left++;
            }

            // Window length - 1 (because we must delete one element)
            int currentLength = right - left;

            // Store maximum length
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        System.out.println(maxLength);
    }
}
