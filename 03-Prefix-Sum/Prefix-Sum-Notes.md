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
