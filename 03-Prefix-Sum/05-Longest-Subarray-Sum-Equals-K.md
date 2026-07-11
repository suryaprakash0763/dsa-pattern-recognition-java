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

### 1. Brute Force (Nested Loops)
- Examine all possible subarrays. Use an outer loop `i` for start index and inner loop `j` for end index.
- Keep a running sum of the subarray. If `sum == k`, update `maxLength = Math.max(maxLength, j - i + 1)`.
- **Time Complexity**: $O(n^2)$
- **Space Complexity**: $O(1)$

### 2. Optimized (Prefix Sum + HashMap)
- A subarray sum from `i` to `j` is `prefixSum[j] - prefixSum[i - 1]`.
- If we want `prefixSum[j] - prefixSum[i - 1] == k`, then `prefixSum[i - 1] == prefixSum[j] - k`.
- Maintain a running `prefixSum`. Use a HashMap to store the **first index** at which each prefix sum occurs.
- If `prefixSum - k` exists in the HashMap, the subarray length is `current_index - map.get(prefixSum - k)`. Update `maxLength`.
- If the current `prefixSum` is not already in the HashMap, store it. Do not overwrite if it exists, as we want to keep the earliest index to maximize the subarray length.
- **Base Case**: Initialize with `map.put(0, -1)` to handle subarrays starting at index `0`.
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(n)$

---

## Complexity
- **Time Complexity**:
  - Brute Force: $O(n^2)$
  - Optimized: $O(n)$
- **Space Complexity**:
  - Brute Force: $O(1)$
  - Optimized: $O(n)$

---

## Java Implementation

- **Java Source File**: [LongestSubarraySumEqualsK.java](code/LongestSubarraySumEqualsK.java)

```java
import java.util.HashMap;

public class LongestSubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;

        System.out.println("Brute Force Output: " + longestSubarraySumBruteForce(nums, k));
        System.out.println("Optimized Output: " + longestSubarraySumOptimized(nums, k));
    }

    // Brute Force: O(n^2) Time, O(1) Space
    public static int longestSubarraySumBruteForce(int[] nums, int k) {
        int maxLength = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    // Optimized: O(n) Time, O(n) Space (Prefix Sum + HashMap)
    public static int longestSubarraySumOptimized(int[] nums, int k) {
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
