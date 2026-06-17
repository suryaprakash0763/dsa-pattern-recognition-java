# 02. Maximum Average Subarray of Size K

## Question
Given an integer array and an integer K, find the maximum average of any contiguous subarray of size K.

### Example
- **Input**: `arr = [1, 12, -5, -6, 50, 3]`, `k = 4`
- **Output**: `12.75` (subarray `[12, -5, -6, 50]`, sum = 51, avg = 51/4)

---

## Pattern Description
- **Pattern**: Sliding Window
- **Type**: Fixed Size
- **Recognition Clue**: Same as Maximum Sum — "Subarray of size K" + "Maximum average". Calculate average from window sum.

---

## Approach
1. Compute the sum of the first `k` elements (initial window).
2. Slide the window one position to the right:
   - Add `arr[i]` (entering element).
   - Remove `arr[i - k]` (leaving element).
3. After each slide, compare the current window sum with the maximum sum.
4. Return `maxSum / k` as the maximum average.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the number of elements in the array.
- **Space Complexity**: $O(1)$
