# 06. Longest Subarray with Sum ≤ K

## Question
Given an array of positive integers and a value K, find the length of the longest contiguous subarray whose sum is less than or equal to K.

### Example
- **Input**: `arr = [1, 2, 3, 4, 5]`, `k = 7`
- **Output**: `3` (subarray `[1, 2, 3]`, sum = 6)

---

## Pattern Description
- **Pattern**: Sliding Window
- **Type**: Variable Size (find maximum valid window)
- **Recognition Clue**: "Longest subarray" + "Sum ≤ K" → expand to grow window, shrink when sum exceeds K.

---

## Approach
1. Use a variable `windowSum` to track the sum of the current window.
2. Move `right` pointer forward and add `arr[right]` to `windowSum`.
3. While `windowSum > k` (window is invalid):
   - Shrink from `left`: subtract `arr[left]` from `windowSum` and move `left` forward.
4. After each step, the window is valid. Track the maximum window length (`right - left + 1`).
5. Return the maximum length.

### Comparison with Problem 5:
| Problem | Goal | Shrink when |
| :--- | :--- | :--- |
| Minimum Size Subarray Sum | Find **minimum** valid window | `windowSum >= target` (valid) |
| Longest Subarray Sum ≤ K | Find **maximum** valid window | `windowSum > k` (invalid) |

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the number of elements in the array.
- **Space Complexity**: $O(1)$
