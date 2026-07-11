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
1. Let the prefix sum at index `j` be $P_j$ and at index `i-1` be $P_{i-1}$. The sum of subarray `nums[i...j]` is $P_j - P_{i-1}$.
2. If this sum is divisible by `k`, then:
   $(P_j - P_{i-1}) \pmod k = 0 \implies P_j \pmod k = P_{i-1} \pmod k$.
3. We traverse the array and maintain the running `prefixSum`.
4. Calculate the remainder `rem = prefixSum % k`.
5. **Handling Negatives in Java**: `prefixSum % k` can return a negative value. We normalize it using:
   `rem = (prefixSum % k + k) % k`.
6. Use an integer array `map` of size `k` (since remainders will always be between `0` and `k-1`) to store the count of remainders seen so far.
7. Add `map[rem]` to our total count, and then increment `map[rem]`.
8. Initialize `map[0] = 1` to account for prefix sums that are themselves divisible by `k`.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of `nums`. We traverse the array once.
- **Space Complexity**: $O(k)$ to store the frequencies of the $k$ possible remainders.

---

## Java Implementation

```java
public class SubarraySumsDivisibleByK {
    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;

        int result = subarraysDivByK(nums, k);

        System.out.println(result); // Output: 7
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        
        // Remainder frequency array of size k
        int[] remCounts = new int[k];
        remCounts[0] = 1; // Base case

        for (int num : nums) {
            prefixSum += num;
            
            // Normalize remainder to handle negative prefix sums
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
