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

### 1. Brute Force (Nested Loops)
- Check all possible subarrays. Use an outer loop for the start index `i` and an inner loop for the end index `j`.
- In the inner loop, keep a count of zeros and ones.
- If the count of zeros is equal to the count of ones, update `maxLength = Math.max(maxLength, j - i + 1)`.
- **Time Complexity**: $O(n^2)$
- **Space Complexity**: $O(1)$

### 2. Optimized (Prefix Sum + HashMap)
- Convert the problem: treat every `0` as `-1` and every `1` as `+1`. Finding a contiguous subarray with equal zeros and ones is equivalent to finding a subarray whose sum is `0`.
- A subarray sum from `i` to `j` is `0` if `prefixSum[j] == prefixSum[i-1]`.
- Traverse the array and maintain the running `prefixSum`.
- Store the *first index* we see each `prefixSum` in a HashMap. If we see a prefix sum again, the subarray length is `current_index - first_index`.
- Track the maximum length. Do not overwrite existing values in the map (to keep the first index as far left as possible).
- **Base Case**: Store `(0, -1)` in the map initially.
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

- **Java Source File**: [ContiguousArray.java](code/ContiguousArray.java)

```java
import java.util.HashMap;

public class ContiguousArray {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0};

        System.out.println("Brute Force Output: " + findMaxLengthBruteForce(nums));
        System.out.println("Optimized Output: " + findMaxLengthOptimized(nums));
    }

    // Brute Force: O(n^2) Time, O(1) Space
    public static int findMaxLengthBruteForce(int[] nums) {
        int maxLength = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int zeros = 0;
            int ones = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    zeros++;
                } else {
                    ones++;
                }
                if (zeros == ones) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    // Optimized: O(n) Time, O(n) Space (Prefix Sum + HashMap)
    public static int findMaxLengthOptimized(int[] nums) {
        int maxLength = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: prefix sum 0 occurs at index -1
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                prefixSum += 1;
            } else {
                prefixSum -= 1;
            }

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
