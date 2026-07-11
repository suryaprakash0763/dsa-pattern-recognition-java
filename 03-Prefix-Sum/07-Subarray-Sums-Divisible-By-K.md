# 07. Subarray Sums Divisible by K

## Question
Given an integer array `nums` and an integer `k`, return the number of non-empty subarrays that have a sum divisible by `k`.

A subarray is a contiguous part of an array.

### Example
- **Input**: `nums = [4, 5, 0, -2, -3, 1]`, `k = 5`
- **Output**: `7`
- **Explanation**: The subarrays are:
  - `[4, 5, 0, -2, -3, 1]` sum is `5` (divisible by 5)
  - `[5]` sum is `5`
  - `[5, 0]` sum is `5`
  - `[5, 0, -2, -3]` sum is `0`
  - `[0]` sum is `0`
  - `[0, -2, -3]` sum is `-5`
  - `[-2, -3]` sum is `-5`

---

## Pattern Description
- **Pattern**: Prefix Sum + HashMap (or Remainder Array)
- **Type**: Modulo Arithmetic Subarray Sum
- **Recognition Clue**: "Subarrays with sum divisible by K" → remainder congruence property: if two prefix sums have the same remainder when divided by `k`, the sum of the elements between them is divisible by `k`.

---

## Approach

### 1. Brute Force (Nested Loops)
- Check all possible subarrays. Use an outer loop for the start index `i` and an inner loop for the end index `j`.
- Accumulate the running sum of the subarray.
- If the sum modulo `k` is 0 (i.e. `sum % k == 0`), increment the count.
- **Time Complexity**: $O(n^2)$
- **Space Complexity**: $O(1)$

### 2. Optimized (Prefix Modulo Remainder)
- The sum of subarray `i..j` is divisible by `k` if the prefix sums have the same remainder modulo `k`:
  `prefixSum[j] % k == prefixSum[i-1] % k`
- Keep a frequency array `remCounts` of size `k` to count occurrences of each remainder.
- For each number in the array, update `prefixSum`, calculate the remainder `rem = prefixSum % k`.
- In Java, handle negative remainders: `rem = (rem + k) % k`.
- Add `remCounts[rem]` to the total count, then increment `remCounts[rem]`.
- **Base Case**: Set `remCounts[0] = 1` initially.
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(k)$

---

## Complexity
- **Time Complexity**:
  - Brute Force: $O(n^2)$
  - Optimized: $O(n)$
- **Space Complexity**:
  - Brute Force: $O(1)$
  - Optimized: $O(k)$

---

## Java Implementation

### Brute Force Solution
```java
public class SubarraySumsDivisibleByKBrute {
    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subarraysDivByK(nums, k)); // Output: 7
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
```

### Optimized Solution (Prefix Remainder Array)
```java
public class SubarraySumsDivisibleByK {
    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subarraysDivByK(nums, k)); // Output: 7
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        int[] remCounts = new int[k];
        remCounts[0] = 1; // Base case

        for (int num : nums) {
            prefixSum += num;
            int rem = prefixSum % k;
            if (rem < 0) {
                rem += k;
            }
            count += remCounts[rem];
            remCounts[rem]++;
        }

        return count;
    }
}
```
