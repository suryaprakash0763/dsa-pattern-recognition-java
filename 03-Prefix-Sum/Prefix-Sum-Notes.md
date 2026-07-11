# Prefix Sum - Revision Notes

Prefix Sum is a technique used to perform fast range sum queries or partition-based search. It transforms an input array into a cumulative sum structure.

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

### Example
- **Input**: `nums = [1, 2, 3, 4]`
- **Output**: `[1, 3, 6, 10]`

### Solution Idea
We can modify the array in-place to achieve $O(1)$ auxiliary space.
For each element from index `1` to `nums.length - 1`, we update `nums[i] = nums[i - 1] + nums[i]`.

### Complexity
- **Time Complexity**: $O(n)$ — Single pass traversal.
- **Space Complexity**: $O(1)$ — If done in-place, or $O(n)$ to allocate a new output array.

---

## Problem 2: Find Pivot Index

### Question
Given an array of integers `nums`, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the right of the index. If no such index exists, return `-1`.

### Example
- **Input**: `nums = [1, 7, 3, 6, 5, 6]`
- **Output**: `3`
  - Left sum = `1 + 7 + 3 = 11`
  - Right sum = `5 + 6 = 11`

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

## Problem 3: Range Sum Query - Immutable

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

## Problem 4: Find the Highest Altitude

### Question
Given a sequence of altitude gains, find the maximum altitude reached starting at altitude 0.

### Solution Idea
Keep a running total of the current altitude and update a maximum tracking variable.
- `currentAltitude += gain[i]`
- `maxAltitude = Math.max(maxAltitude, currentAltitude)`

### Complexity
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 5: Minimum Value to Get Positive Step by Step Sum

### Question
Find the minimum starting value such that the running prefix sum never drops below 1.

### Solution Idea
1. Trace the prefix sum and keep track of the minimum value `minSum` it ever reaches.
2. Since we need $\text{startValue} + \text{minSum} \ge 1$, the minimum starting value is $1 - \text{minSum}$.
3. Return `1 - minSum` (since `minSum` starts at `0` and can only decrease, $1 - \text{minSum} \ge 1$ is guaranteed if `minSum <= 0`).

### Complexity
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 6: Subarray Sum Equals K

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

## Problem 7: Subarray Sums Divisible by K

### Question
Find the number of subarrays whose sum is divisible by `k`.

### Solution Idea
A subarray sum is divisible by `k` if the remainders of their prefix sums modulo `k` are identical:
$$\text{prefixSum}[j] \pmod k == \text{prefixSum}[i-1] \pmod k$$
We track remainder frequencies. For Java, we must normalize negative remainders:
- `rem = (prefixSum % k + k) % k`
- Keep a frequency array `remCounts` of size `k`.
- Add `remCounts[rem]` to our answer, then increment `remCounts[rem]`.

### Complexity
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(k)$

---

## Problem 8: Contiguous Array

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
