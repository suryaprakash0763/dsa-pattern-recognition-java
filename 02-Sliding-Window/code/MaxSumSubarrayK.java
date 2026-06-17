public class MaxSumSubarrayK {
    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        // Build the first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Slide the window
        for (int i = k; i < arr.length; i++) {

            // Add the new element entering the window
            windowSum += arr[i];

            // Remove the element leaving the window
            windowSum -= arr[i - k];

            // Update the maximum sum
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }

        System.out.println(maxSum);
    }
}
