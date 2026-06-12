import java.util.Arrays;

public class MoveNegativeNumbers {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -4, 5};
        int[] result = new int[arr.length];
        int k = 0;

        // positives first
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                result[k++] = arr[i];
            }
        }

        // negatives next
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                result[k++] = arr[i];
            }
        }

        System.out.println(Arrays.toString(result));
    }
}
