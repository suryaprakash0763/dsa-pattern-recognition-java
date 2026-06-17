import java.util.HashSet;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {

        String s = "abcabcbb";

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char currentChar = s.charAt(right);

            // If duplicate found, shrink from left
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character to the window
            set.add(currentChar);

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
