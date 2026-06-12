public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 4};
        int val = 4;
        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[k++] = arr[i];
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
