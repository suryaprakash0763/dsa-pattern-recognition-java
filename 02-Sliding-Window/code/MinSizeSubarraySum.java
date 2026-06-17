public class MinSizeSubarraySum {
    public static void main(String[] args) {

        int[] arr = {2, 3, 1, 2, 4, 3};
        int target = 7;

        int left = 0;
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {

            // Add current element to window sum
            windowSum += arr[right];

            // While window is valid (sum >= target), shrink to find minimum
            while (windowSum >= target) {

                // Update minimum length
                int currentLength = right - left + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                }

                // Remove left element and shrink
                windowSum -= arr[left];
                left++;
            }
        }

        // If no valid window found, return 0
        if (minLength == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(minLength);
        }
    }
}
