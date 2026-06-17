public class LongestSubarraySumLeqK {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int k = 7;

        int left = 0;
        int windowSum = 0;
        int maxLength = 0;

        for (int right = 0; right < arr.length; right++) {

            // Add current element to window sum
            windowSum += arr[right];

            // While window is invalid (sum > k), shrink
            while (windowSum > k) {

                // Remove left element and shrink
                windowSum -= arr[left];
                left++;
            }

            // Window is valid, track maximum length
            int currentLength = right - left + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        System.out.println(maxLength);
    }
}
