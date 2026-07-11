# 08. Contiguous Array

## Question
Given a binary array `nums`, return the maximum length of a contiguous subarray with an equal number of `0` and `1`.

### Example
- **Input**: `nums = [0, 1, 0]`
- **Output**: `2`
- **Explanation**: `[0, 1]` (or `[1, 0]`) is the longest contiguous subarray with an equal number of 0 and 1.

---

## Pattern Description
- **Pattern**: Prefix Sum + HashMap
- **Type**: Index Tracking for Maximum Subarray Length
- **Recognition Clue**: "Equal number of 0 and 1" + "contiguous subarray" + "maximum length". By transforming 0 into -1, the problem becomes: "Find the longest subarray with a sum of 0".

---

## Approach
1. Transform the input problem: Treat every `0` as `-1` and every `1` as `+1`. The target is now finding a contiguous subarray whose sum is `0`.
2. A subarray from index `i` to `j` has a sum of `0` if `prefixSum[j] == prefixSum[i - 1]`.
3. We traverse the array and maintain the running `prefixSum` (adding `1` for a `1`, subtracting `1` for a `0`).
4. Keep a HashMap to store the *first index* at which each `prefixSum` is encountered. The key is `prefixSum`, and the value is the index `i`.
5. If the current `prefixSum` is already in the HashMap:
   - Calculate the length of the subarray: `current_index - map.get(prefixSum)`.
   - Update the `maxLength` if this length is larger.
6. If the current `prefixSum` is not in the HashMap, store it with the current index. (Do not overwrite if it exists, because we want the *earliest* index to maximize length!).
7. Initialize the map with `map.put(0, -1)` to handle subarrays starting at index `0`.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of `nums`. We traverse the array once.
- **Space Complexity**: $O(n)$ to store prefix sums in the HashMap.

---

## Java Implementation

```java
import java.util.HashMap;

public class ContiguousArray {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0};

        int maxLen = findMaxLength(nums);

        System.out.println(maxLen); // Output: 2
    }

    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: prefix sum 0 occurs at index -1
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            // Treat 0 as -1, and 1 as +1
            prefixSum += (nums[i] == 1) ? 1 : -1;

            if (map.containsKey(prefixSum)) {
                // Current index - first occurrence index of this prefixSum
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
```
