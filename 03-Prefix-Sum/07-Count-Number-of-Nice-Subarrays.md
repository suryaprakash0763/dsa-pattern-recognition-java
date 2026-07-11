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
1. Convert the problem: treat Odd numbers as `1` and Even numbers as `0`. We want to find contiguous subarrays with sum `k`.
2. Keep a running `oddCount` (analogous to `prefixSum`).
3. Since `oddCount` can never exceed the array length `n`, we can use a frequency array `counts` of size `n + 1` instead of a HashMap. `counts[i]` stores the number of times we have seen a prefix with exactly `i` odd numbers so far.
4. At each step, update `oddCount` (incrementing by `num % 2`).
5. If `oddCount >= k`, add `counts[oddCount - k]` to the total nice subarrays count.
6. Increment `counts[oddCount]`.
7. **Base Case**: Set `counts[0] = 1` initially to handle subarrays starting at index `0`.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of `nums`. We scan the array once.
- **Space Complexity**: $O(n)$ to store prefix counts in the frequency array.

---

## Java Implementation

```java
public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;

        int result = numberOfNiceSubarrays(nums, k);

        System.out.println(result); // Output: 2
    }

    public static int numberOfNiceSubarrays(int[] nums, int k) {
        int niceSubarrays = 0;
        int oddCount = 0;
        int n = nums.length;

        // counts[i] will store the number of times we've seen a prefix with 'i' odd numbers
        int[] counts = new int[n + 1];
        counts[0] = 1; // Base case: 0 odd numbers has occurred once

        for (int num : nums) {
            // Update running oddCount (add 1 if odd, 0 if even)
            oddCount += Math.abs(num % 2); // Use Math.abs to handle negative numbers if present

            if (oddCount >= k) {
                niceSubarrays += counts[oddCount - k];
            }

            counts[oddCount]++;
        }

        return niceSubarrays;
    }
}
```
