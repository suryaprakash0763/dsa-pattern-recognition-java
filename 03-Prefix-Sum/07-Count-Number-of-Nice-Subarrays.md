# 07. Count Number of Nice Subarrays

## Question
Given an array of integers `nums` and an integer `k`. A continuous subarray is called **nice** if there are `k` odd numbers on it. Return the number of nice subarrays.

### Example
- **Input**: `nums = [1, 1, 2, 1, 1]`, `k = 3`
- **Output**: `2`
- **Explanation**: The only sub-arrays with 3 odd numbers are `[1, 1, 2, 1]` (index `0..3`) and `[1, 2, 1, 1]` (index `1..4`).

---

## Pattern Description
- **Pattern**: Prefix Sum + Frequency Array (HashMap equivalent)
- **Type**: Odd/Even Subarray Sum
- **Recognition Clue**: "Exactly k odd numbers" + "continuous subarray" + "count of subarrays". By converting all Odd numbers to `1` and Even numbers to `0`, this is equivalent to finding subarrays with a sum of `k`.

---

## Approach

### 1. Brute Force (Nested Loops)
- Run nested loops to explore all subarrays.
- In the inner loop, keep a count of odd numbers seen so far.
- If the count of odd numbers equals `k`, increment the nice subarrays count.
- **Time Complexity**: $O(n^2)$
- **Space Complexity**: $O(1)$

### 2. Optimized (Prefix Odd Count Frequency Array)
- Transform the problem: Treat Odd numbers as `1` and Even numbers as `0`. We want to find contiguous subarrays with sum `k`.
- Keep a running `oddCount` (analogous to `prefixSum`).
- Instead of a HashMap, since `oddCount` can never exceed the array length `n`, we can use an integer array `counts` of size `n + 1` where `counts[i]` stores the number of times we have seen `i` odd numbers so far.
- At each step, if `oddCount >= k`, add `counts[oddCount - k]` to the total nice subarrays count.
- Increment `counts[oddCount]`.
- **Base Case**: Set `counts[0] = 1` initially to handle subarrays starting at index `0`.
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
public class CountNumberOfNiceSubarraysBrute {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(numberOfNiceSubarrays(nums, k)); // Output: 2
    }

    public static int numberOfNiceSubarrays(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int oddCount = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 != 0) {
                    oddCount++;
                }
                if (oddCount == k) {
                    count++;
                } else if (oddCount > k) {
                    break;
                }
            }
        }
        return count;
    }
}
```

### Optimized Solution (Prefix Odd Counts Array)
```java
public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(numberOfNiceSubarrays(nums, k)); // Output: 2
    }

    public static int numberOfNiceSubarrays(int[] nums, int k) {
        int niceSubarrays = 0;
        int oddCount = 0;
        int n = nums.length;

        // counts[i] will store the number of times we've seen a prefix with 'i' odd numbers
        int[] counts = new int[n + 1];
        counts[0] = 1; // Base case: 0 odd numbers has occurred once

            // Update running oddCount (add 1 if odd, 0 if even)
            oddCount += num % 2;

            if (oddCount >= k) {
                niceSubarrays += counts[oddCount - k];
            }

            counts[oddCount]++;
        }

        return niceSubarrays;
    }
}
```
