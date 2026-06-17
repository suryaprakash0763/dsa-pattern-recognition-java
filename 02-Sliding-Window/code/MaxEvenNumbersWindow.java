public class MaxEvenNumbersWindow {
    public static void main(String[] args) {

        int[] arr = {2, 3, 4, 6, 1, 8, 2};
        int k = 3;

        // Count even numbers in the first window
        int evenCount = 0;
        for (int i = 0; i < k; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            }
        }

        int maxEven = evenCount;

        // Slide the window
        for (int i = k; i < arr.length; i++) {

            // If the new element entering is even, add 1
            if (arr[i] % 2 == 0) {
                evenCount++;
            }

            // If the element leaving is even, subtract 1
            if (arr[i - k] % 2 == 0) {
                evenCount--;
            }

            // Update the maximum
            if (evenCount > maxEven) {
                maxEven = evenCount;
            }
        }

        System.out.println(maxEven);
    }
}
