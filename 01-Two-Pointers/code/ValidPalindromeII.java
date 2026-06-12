public class ValidPalindromeII {
    static boolean isPalindrome(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcbda";

        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;
        boolean result = true;

        while (left < right) {
            if (arr[left] == arr[right]) {
                left++;
                right--;
            } else {
                result = isPalindrome(arr, left + 1, right) ||
                         isPalindrome(arr, left, right - 1);
                break;
            }
        }

        System.out.println(result);
    }
}
