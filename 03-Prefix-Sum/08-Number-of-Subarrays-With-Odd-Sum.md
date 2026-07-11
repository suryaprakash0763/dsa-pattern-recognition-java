# 08. Number of Subarrays With Odd Sum

## Question
Given an array of integers `arr`, return the number of subarrays with an **odd** sum.

### Example
- **Input**: `arr = [1, 3, 5]`
- **Output**: `4`
- **Explanation**: All subarrays are:
  - `[1]` sum is `1` (odd)
  - `[1, 3]` sum is `4` (even)
  - `[1, 3, 5]` sum is `9` (odd)
  - `[3]` sum is `3` (odd)
  - `[3, 5]` sum is `8` (even)
  - `[5]` sum is `5` (odd)
  Subarrays with odd sum are `[1]`, `[1, 3, 5]`, `[3]`, `[5]`. The total number is `4`.

---

## Pattern Description
- **Pattern**: Prefix Sum (Even/Odd Tracking)
- **Type**: Parity Congruence Counting
- **Recognition Clue**: "Count of subarrays" + "odd sum".
  A subarray sum `arr[i...j] = prefixSum[j] - prefixSum[i - 1]` is **odd** if and only if one of the prefix sums is **odd** and the other is **even** (since $\text{Odd} - \text{Even} = \text{Odd}$ and $\text{Even} - \text{Odd} = \text{Odd}$).

---

## Approach

### 1. Brute Force (Nested Loops)
- Examine all possible subarrays. Use an outer loop `i` for start index and inner loop `j` for end index.
- Keep a running sum of the subarray. If `sum % 2 != 0`, increment the count.
- **Time Complexity**: $O(n^2)$
- **Space Complexity**: $O(1)$

### 2. Optimized (Even/Odd Prefix Count Tracking)
- A subarray sum `arr[i...j] = prefixSum[j] - prefixSum[i - 1]` is **odd** if and only if one prefix sum is **even** and the other is **odd** (since $\text{Odd} - \text{Even} = \text{Odd}$ and $\text{Even} - \text{Odd} = \text{Odd}$).
- Maintain a running `prefixSum`.
- Keep track of:
   - `oddPrefCount`: the count of odd prefix sums seen so far.
   - `evenPrefCount`: the count of even prefix sums seen so far (initialized to `1` because the empty prefix sum of `0` at index `-1` is even).
- For each element:
   - Update the running `prefixSum`.
   - If the current `prefixSum` is **even**, it forms an odd subarray when paired with any previous **odd** prefix sum. Add `oddPrefCount` to our total count, and increment `evenPrefCount`.
   - If the current `prefixSum` is **odd**, it forms an odd subarray when paired with any previous **even** prefix sum. Add `evenPrefCount` to our total count, and increment `oddPrefCount`.
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$ auxiliary space.

---

## Complexity
- **Time Complexity**:
  - Brute Force: $O(n^2)$
  - Optimized: $O(n)$
- **Space Complexity**:
  - Brute Force: $O(1)$
  - Optimized: $O(1)$ auxiliary space.

---

## Java Implementation

### Brute Force Solution
```java
public class NumberOfSubarraysWithOddSumBrute {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        System.out.println(numOfSubarrays(arr)); // Output: 4
    }

    public static int numOfSubarrays(int[] arr) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum % 2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
```

### Optimized Solution (Even/Odd Prefix Tracking)
```java
public class NumberOfSubarraysWithOddSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        System.out.println(numOfSubarrays(arr)); // Output: 4
    }

    public static int numOfSubarrays(int[] arr) {
        int count = 0;
        int prefixSum = 0;

        // Even prefix count starts at 1 to handle the empty prefix sum (0)
        int evenPrefCount = 1;
        int oddPrefCount = 0;

        for (int num : arr) {
            prefixSum += num;

            if (prefixSum % 2 == 0) {
                // Even prefix sum needs an odd prefix sum to yield an odd subarray sum
                count = count + oddPrefCount;
                evenPrefCount++;
            } else {
                // Odd prefix sum needs an even prefix sum to yield an odd subarray sum
                count = count + evenPrefCount;
                oddPrefCount++;
            }
        }

        return count;
    }
}
```
