import java.util.HashMap;

public class ContiguousArray {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        System.out.println(findMaxLength(nums)); // Output: 2
    }

    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: prefix sum 0 occurs at index -1
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += (nums[i] == 1) ? 1 : -1;

            if (map.containsKey(prefixSum)) {
                int length = i - map.get(prefixSum);
                if (length > maxLength) {
                    maxLength = length;
                }
            } else {
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}
