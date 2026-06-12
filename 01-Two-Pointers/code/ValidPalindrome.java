public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "tenet";

        if (s.length() == 0) {
            System.out.print("False");
            return;
        }

        int left = 0;
        int right = s.length() - 1;
        boolean found = true;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                found = false;
                break;
            }
        }

        if (found) {
            System.out.print("True");
        } else {
            System.out.print("False");
        }
    }
}
