import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] arr = {'h', 'e', 'l', 'l', 'o'};

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        System.out.print(Arrays.toString(arr));
    }
}
