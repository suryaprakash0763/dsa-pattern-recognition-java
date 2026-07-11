# 06. Contiguous Array

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
1. Transform the input: treat `0` as `-1` and `1` as `+1`. Finding a contiguous subarray with an equal number of zeros and ones is now equivalent to finding a subarray whose sum is `0`.
2. A subarray sum from `i` to `j` is `0` if `prefixSum[j] == prefixSum[i-1]`.
3. Traverse the array and maintain the running `prefixSum` (adding `1` for a `1`, subtracting `1` for a `0`).
4. Store the *first index* at which each `prefixSum` is encountered in a HashMap.
5. If the current `prefixSum` is already in the HashMap, a subarray of sum 0 exists. Its length is `current_index - map.get(prefixSum)`. Update `maxLength`.
6. If the current `prefixSum` is not in the HashMap, store it. Do not overwrite if it exists (since we want the leftmost index to maximize length).
7. **Base Case**: Store `(0, -1)` in the map initially to handle subarrays starting at index `0`.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of `nums`. We scan the array once.
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
```
