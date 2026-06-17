public class AverageSubarrayK {
    public static void main(String[] args) {

        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;

        double[] result = new double[arr.length - k + 1];

        // Build the first window
        double windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        result[0] = windowSum / k;

        // Slide the window
        for (int i = k; i < arr.length; i++) {

            // Add the new element entering the window
            windowSum += arr[i];

            // Remove the element leaving the window
            windowSum -= arr[i - k];

            // Store the average
            result[i - k + 1] = windowSum / k;
        }

        // Print the result
        for (double avg : result) {
            System.out.print(avg + " ");
        }
        System.out.println();
    }
}
