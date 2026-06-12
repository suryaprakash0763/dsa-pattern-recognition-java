public class KeepEvenNumbers {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arr[k++] = arr[i];
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
