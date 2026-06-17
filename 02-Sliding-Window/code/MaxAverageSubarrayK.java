public class MaxAverageSubarrayK {
    public static void main(String[] args) {

        int[] arr = {1, 12, -5, -6, 50, 3};
        int k = 4;

        // Build the first window
        double windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        double maxSum = windowSum;

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

        // Maximum average = maximum sum / k
        System.out.println(maxSum / k);
    }
}
