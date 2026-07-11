# 04. Subarray Sum Equals K

## Question
Given an array of integers `nums` and an integer `k`, return the total number of subarrays whose sum equals to `k`.

A subarray is a contiguous non-empty sequence of elements within an array.

### Example
- **Input**: `nums = [1, 1, 1]`, `k = 2`
- **Output**: `2`
- **Explanation**: Subarrays are `[1, 1]` at index `0..1` and `[1, 1]` at index `1..2`.

---

## Pattern Description
- **Pattern**: Prefix Sum + HashMap
- **Type**: Subarray Sum Tracking
- **Recognition Clue**: Finding contiguous subarrays summing to `k` with elements that can be negative (meaning two pointers / sliding window sum cannot be used since the sum does not grow monotonically).

---

## Approach

### 1. Brute Force (Nested Loops)
- Check all possible subarrays. Use a outer loop for the start index `i` and an inner loop for the end index `j`.
- Maintain a running sum of the subarray from `i` to `j`.
- If the sum equals `k`, increment the count.
- **Time Complexity**: $O(n^2)$
- **Space Complexity**: $O(1)$

### 2. Optimized (Prefix Sum + HashMap)
- The sum of subarray `i..j` is `prefixSum[j] - prefixSum[i-1]`.
- If we want `prefixSum[j] - prefixSum[i-1] == k`, it is equivalent to `prefixSum[i-1] == prefixSum[j] - k`.
- Iterate through `nums`, maintaining a running `prefixSum`.
- Check if `prefixSum - k` exists in a HashMap that stores the frequency of previously seen prefix sums.
- If it does, add its frequency to `count`.
- Record the current `prefixSum` in the map.
- **Base Case**: Put `(0, 1)` in the map to handle subarrays starting at index `0`.
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

### Brute Force Solution
```java
public class SubarraySumEqualsKBrute {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k)); // Output: 2
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
```

### Optimized Solution (Prefix Sum + HashMap)
```java
import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k)); // Output: 2
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: prefix sum of 0 has occurred 1 time
        map.put(0, 1);

        for (int num : nums) {
            prefixSum += num;

            // Check if (prefixSum - k) exists in map
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // Record current prefixSum in map
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
```
