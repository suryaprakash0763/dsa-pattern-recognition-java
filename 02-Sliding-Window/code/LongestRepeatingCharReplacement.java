import java.util.HashMap;

public class LongestRepeatingCharReplacement {
    public static void main(String[] args) {

        String s = "AABABBA";
        int k = 1;

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;
        int maxFrequency = 0;

        for (int right = 0; right < s.length(); right++) {

            // Current character enters the window
            char currentChar = s.charAt(right);

            // Increase its frequency
            map.put(
                currentChar,
                map.getOrDefault(currentChar, 0) + 1
            );

            // Update the maximum frequency character count
            if (map.get(currentChar) > maxFrequency) {
                maxFrequency = map.get(currentChar);
            }

            // Check if replacements needed are greater than k
            while ((right - left + 1) - maxFrequency > k) {

                char leftChar = s.charAt(left);

                // Remove the left character from the window
                map.put(
                    leftChar,
                    map.get(leftChar) - 1
                );

                left++;
            }

            // Current valid window length
            int currentLength = right - left + 1;

            // Store the maximum answer
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        System.out.println(maxLength);
    }
}
