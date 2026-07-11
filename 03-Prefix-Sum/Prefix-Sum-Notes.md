# Prefix Sum - Revision Notes

Prefix Sum is a technique used to perform fast range sum queries or partition-based search. It transforms an input array into a cumulative sum structure.

---

## Complexity Summary

| Problem | Brute Force Time/Space | Optimized Time/Space | Key Technique |
| :--- | :--- | :--- | :--- |
| **01. Running Sum of 1D Array** | $O(N^2)$ / $O(1)$ | $O(N)$ / $O(1)$ | Cumulative Sum in-place |
| **02. Range Sum Query - Immutable** | $O(N)$ query / $O(1)$ | $O(1)$ query / $O(N)$ | Precomputed 1-indexed Prefix Array |
| **03. Find Pivot Index** | $O(N^2)$ / $O(1)$ | $O(N)$ / $O(1)$ | `totalSum - leftSum - nums[i]` |
| **04. Subarray Sum Equals K** | $O(N^2)$ / $O(1)$ | $O(N)$ / $O(N)$ | Prefix Sum + HashMap frequency |
| **05. Longest Subarray Sum Equals K** | $O(N^2)$ / $O(1)$ | $O(N)$ / $O(N)$ | Prefix Sum + HashMap first index |
| **06. Contiguous Array** | $O(N^2)$ / $O(1)$ | $O(N)$ / $O(N)$ | Map `0` to `-1` + HashMap first index |
| **07. Count Number of Nice Subarrays** | $O(N^2)$ / $O(1)$ | $O(N)$ / $O(N)$ | Map odd to 1, even to 0 + Prefix frequency array |
| **08. Number of Subarrays With Odd Sum** | $O(N^2)$ / $O(1)$ | $O(N)$ / $O(1)$ | Track counts of odd & even prefixes |
| **09. Product of Array Except Self** | $O(N^2)$ / $O(1)$ | $O(N)$ / $O(1)$ auxiliary | Prefix & Suffix product passes |

---

## Conceptual Overview

If we have an array `arr` of size $n$, the prefix sum array `prefix` is defined as:
- `prefix[0] = arr[0]`
- `prefix[i] = prefix[i-1] + arr[i]` (for $i \ge 1$)

### Range Sum Queries in $O(1)$ Time
Normally, to find the sum of elements from index `L` to `R`, we would need a loop running from `L` to `R`, taking $O(n)$ time.
Using the prefix sum array, we can compute it instantly:
$$\text{Sum}(L, R) = \text{prefix}[R] - \text{prefix}[L - 1]$$
*(Note: If $L = 0$, the sum is simply $\text{prefix}[R]$).*

---

## Problem 1: Running Sum of 1D Array

### Question
Given an array `nums`. We define a running sum of an array as `runningSum[i] = sum(nums[0]…nums[i])`. Return the running sum of `nums`.

### Solution Idea
We can modify the array in-place to achieve $O(1)$ auxiliary space.
For each element from index `1` to `nums.length - 1`, we update `nums[i] = nums[i - 1] + nums[i]`.

### Complexity
- **Time Complexity**: $O(n)$ — Single pass traversal.
- **Space Complexity**: $O(1)$ — If done in-place, or $O(n)$ to allocate a new output array.

---

## Problem 2: Range Sum Query - Immutable

### Question
Implement the `NumArray` class which precalculates cumulative sums to return the sum of the elements of `nums` between indices `left` and `right` inclusive in $O(1)$ time.

### Solution Idea
Use 1-indexed prefix sums where `prefix[i]` stores the sum of the first `i` elements (`nums[0]` through `nums[i-1]`).
- `prefix[i + 1] = prefix[i] + nums[i]`
- `sumRange(left, right) = prefix[right + 1] - prefix[left]`
This avoids the edge case of checking if `left == 0`.

### Complexity
- **Time Complexity**: $O(n)$ for initialization, $O(1)$ per query.
- **Space Complexity**: $O(n)$ to store prefix array.

---

## Problem 3: Find Pivot Index

### Question
Given an array of integers `nums`, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the right of the index. If no such index exists, return `-1`.

### Mathematical Equation (Single Pass)
Instead of calculating the left sum and right sum from scratch at each index:
1. Precalculate `totalSum` of the array.
2. Maintain a running `leftSum` starting at `0`.
3. At any index `i`, the sum of elements to the right of `i` is:
   $$\text{rightSum} = \text{totalSum} - \text{leftSum} - \text{nums}[i]$$
4. Check if $\text{leftSum} == \text{rightSum}$. That is:
   $$\text{leftSum} == \text{totalSum} - \text{leftSum} - \text{nums}[i]$$
5. If true, `i` is the pivot index. Otherwise, add `nums[i]` to `leftSum` and proceed.

### Complexity
- **Time Complexity**: $O(n)$ — We pass through the array twice (once to sum, once to find the pivot).
- **Space Complexity**: $O(1)$ — Only a few variables (`totalSum`, `leftSum`) are tracked.

---

## Problem 4: Subarray Sum Equals K

### Question
Find the number of contiguous subarrays that sum to `k` (elements can be negative).

### Solution Idea
A contiguous subarray sum equals `k` if:
$$\text{prefixSum}[j] - \text{prefixSum}[i - 1] = k \implies \text{prefixSum}[i - 1] = \text{prefixSum}[j] - k$$
As we compute the running `prefixSum`, we check if `prefixSum - k` exists in a HashMap of previously seen prefix sum frequencies. If it does, we add its frequency to our result.
- **Base Case**: Put `(0, 1)` in the map to handle subarrays starting at index `0`.

### Complexity
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(n)$

---

## Problem 5: Longest Subarray Sum Equals K

### Question
Find the maximum length of a contiguous subarray whose sum equals `k`.

### Solution Idea
Similar to "Subarray Sum Equals K", but instead of frequency, we track the **first occurrence index** of each prefix sum in a HashMap.
If `prefixSum - k` exists in the HashMap, the length is `current_index - first_occurrence_index`. Update `maxLength`.
Do not overwrite the index for a prefix sum if it is already present, in order to maximize the distance.
- **Base Case**: Put `(0, -1)` in the map.

### Complexity
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(n)$

---

## Problem 6: Contiguous Array

### Question
Find the maximum length of a binary subarray (0s and 1s) with an equal number of 0s and 1s.

### Solution Idea
1. Convert the problem: Treat `0` as `-1`. Now the goal is finding the longest subarray with a sum of `0`.
2. A sum of `0` means two prefix sums are equal.
3. Use a HashMap to store the *first index* we see each prefix sum.
4. If we see a prefix sum again, the subarray length is `current_index - first_index`. Track the maximum.
5. Initialize the map with `(0, -1)` to cover the base case.

### Complexity
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(n)$

---

## Problem 7: Count Number of Nice Subarrays

### Question
Given an array of integers `nums` and an integer `k`, return the number of nice subarrays (a continuous subarray with exactly `k` odd numbers).

### Solution Idea
1. Convert the problem: Transform odd numbers to `1` and even numbers to `0`. The problem reduces to finding subarrays with a sum equal to `k`.
2. Keep a running count of odd numbers (`oddCount`).
3. Since `oddCount` can never exceed the array length `n`, we can use a frequency array `counts` of size `n + 1` instead of a HashMap for $O(1)$ lookups.
4. If `oddCount >= k`, add `counts[oddCount - k]` to the total nice subarrays count.
5. Initialize `counts[0] = 1`.

### Complexity
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(n)$

---

## Problem 8: Number of Subarrays With Odd Sum

### Question
Given an array of integers `arr`, return the number of subarrays with an **odd** sum, modulo $10^9 + 7$.

### Solution Idea
1. A subarray sum is odd if it is formed by pairing an odd prefix sum with an even prefix sum ($\text{Odd} - \text{Even} = \text{Odd}$).
2. Track the counts of even and odd prefix sums seen so far (`evenPrefCount` and `oddPrefCount`).
3. If the current prefix sum is odd, it can pair with all previous even prefix sums to yield an odd subarray sum. Thus, add `evenPrefCount` to count.
4. If the current prefix sum is even, it can pair with all previous odd prefix sums to yield an odd subarray sum. Thus, add `oddPrefCount` to count.
5. Initialize `evenPrefCount = 1` (for prefix sum 0).

### Complexity
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 9: Product of Array Except Self

### Question
Return an array where `ans[i]` is the product of all elements except `nums[i]`, without using division.

### Solution Idea
This is a prefix/suffix product variation of Prefix Sum:
1. Perform a forward pass: `ans[i]` stores the product of elements to the left of `i`.
2. Perform a backward pass: Keep a rolling `suffix` product variable. Multiply `ans[i]` by `suffix`, then update `suffix = suffix * nums[i]`.

### Complexity
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$ auxiliary space.
