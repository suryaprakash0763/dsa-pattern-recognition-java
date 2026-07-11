# 05. Longest Subarray Sum Equals K

## Question
Given an array of integers `nums` and an integer `k`, return the maximum length of a contiguous subarray whose sum equals to `k`. If no such subarray exists, return `0`.

### Example
- **Input**: `nums = [1, -1, 5, -2, 3]`, `k = 3`
- **Output**: `4`
- **Explanation**: The subarray `[1, -1, 5, -2]` sums to `3` and has a length of `4` (from index `0` to `3`).

---

## Pattern Description
- **Pattern**: Prefix Sum + HashMap
- **Type**: Index Tracking for Maximum Subarray Length
- **Recognition Clue**: "Contiguous subarray" + "equals k" + "maximum length" with possible negative numbers.

---

## Approach
1. The sum of subarray `i..j` is `prefixSum[j] - prefixSum[i - 1]`.
2. If we want `prefixSum[j] - prefixSum[i - 1] == k`, then `prefixSum[i - 1] == prefixSum[j] - k`.
3. Traverse the array and maintain the running `prefixSum`.
4. Use a HashMap to store the **first index** at which each prefix sum occurs.
5. If `prefixSum - k` exists in the HashMap, the subarray length is `current_index - map.get(prefixSum - k)`. Update `maxLength`.
6. Only store the index of `prefixSum` if it is not already present in the HashMap (to keep the index as small/leftmost as possible, maximizing the subarray length).
7. **Base Case**: Initialize with `map.put(0, -1)` to handle subarrays starting at index `0`.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of `nums`. We scan the array once.
- **Space Complexity**: $O(n)$ to store prefix sums in the HashMap.

---

## Java Implementation

```java
import java.util.HashMap;

public class LongestSubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;

        int result = longestSubarraySum(nums, k);

        System.out.println(result); // Output: 4
    }

    public static int longestSubarraySum(int[] nums, int k) {
        int maxLength = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        // Base case: prefix sum 0 occurs at index -1
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // If (prefixSum - k) has occurred before, calculate length
            if (map.containsKey(prefixSum - k)) {
                int length = i - map.get(prefixSum - k);
                maxLength = Math.max(maxLength, length);
            }

            // Store prefixSum only if it is not already present
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}
```
