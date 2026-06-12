public class ReverseOnlyVowels {
    public static void main(String[] args) {
        String word = "hello";
        char[] arr = word.toCharArray();
        String vowels = "aeiou";

        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (vowels.indexOf(arr[left]) != -1 && vowels.indexOf(arr[right]) != -1) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            } else if (vowels.indexOf(arr[left]) == -1) {
                left++;
            } else if (vowels.indexOf(arr[right]) == -1) {
                right--;
            }
        }

        String result = new String(arr);
        System.out.println(result);
    }
}
