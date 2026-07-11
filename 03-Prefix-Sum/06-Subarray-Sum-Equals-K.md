# 06. Subarray Sum Equals K

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
1. We know that the sum of a subarray from index `i` to `j` is computed as:
   `sum(i, j) = prefixSum[j] - prefixSum[i - 1]`
2. If we want `sum(i, j) == k`, then:
   `prefixSum[j] - prefixSum[i - 1] = k`
   Which can be rewritten as:
   `prefixSum[i - 1] = prefixSum[j] - k`
3. We can iterate through the array, maintaining the running `prefixSum`.
4. At each step, check if `prefixSum - k` exists in a HashMap that stores the frequencies of previously seen prefix sums.
5. If it exists, add the frequency of `prefixSum - k` to the total count.
6. Store/update the frequency of the current `prefixSum` in the map.
7. **Important**: Initialize the map with `map.put(0, 1)` because a prefix sum of `0` is conceptually seen once before we start (to handle subarrays starting at index `0`).

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of `nums`. We traverse the array once and perform $O(1)$ HashMap operations.
- **Space Complexity**: $O(n)$ to store up to $n$ distinct prefix sums in the HashMap.

---

## Java Implementation

```java
import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;

        int result = subarraySum(nums, k);

        System.out.println(result); // Output: 2
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
