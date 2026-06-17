# 01. Maximum Sum Subarray of Size K

## Question
Given an integer array and a number K, find the maximum sum of any contiguous subarray of size K.

### Example
- **Input**: `arr = [2, 1, 5, 1, 3, 2]`, `k = 3`
- **Output**: `9` (subarray `[5, 1, 3]`)

---

## Pattern Description
- **Pattern**: Sliding Window
- **Type**: Fixed Size
- **Recognition Clue**: "Subarray of size K" + "Maximum sum" → fixed window that slides across the array.

---

## Approach
1. Compute the sum of the first `k` elements (initial window).
2. Slide the window one position to the right:
   - Add the new element entering from the right (`arr[i]`).
   - Remove the element leaving from the left (`arr[i - k]`).
3. After each slide, compare the current window sum with the maximum sum.
4. Return the maximum sum after scanning the entire array.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the number of elements in the array.
- **Space Complexity**: $O(1)$
