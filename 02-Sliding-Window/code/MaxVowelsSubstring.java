public class MaxVowelsSubstring {
    public static void main(String[] args) {

        String s = "abciiidef";
        int k = 3;

        // Count vowels in the first window
        int vowelCount = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                vowelCount++;
            }
        }

        int maxVowels = vowelCount;

        // Slide the window
        for (int i = k; i < s.length(); i++) {

            // If the new character entering is a vowel, add 1
            if (isVowel(s.charAt(i))) {
                vowelCount++;
            }

            // If the character leaving is a vowel, subtract 1
            if (isVowel(s.charAt(i - k))) {
                vowelCount--;
            }

            // Update the maximum
            if (vowelCount > maxVowels) {
                maxVowels = vowelCount;
            }
        }

        System.out.println(maxVowels);
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
