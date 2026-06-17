# 05. Minimum Size Subarray Sum

## Question
Given an array of positive integers and a target, find the minimum length of a contiguous subarray whose sum is greater than or equal to the target. If no such subarray exists, return 0.

### Example
- **Input**: `arr = [2, 3, 1, 2, 4, 3]`, `target = 7`
- **Output**: `2` (subarray `[4, 3]`)

---

## Pattern Description
- **Pattern**: Sliding Window
- **Type**: Variable Size (find minimum valid window)
- **Recognition Clue**: "Minimum length subarray" + "Sum >= target" → expand until valid, then shrink to find minimum.

---

## Approach
1. Use a variable `windowSum` to track the sum of the current window.
2. Move `right` pointer forward and add `arr[right]` to `windowSum`.
3. While `windowSum >= target` (window is valid):
   - Update the minimum length.
   - Shrink from `left`: subtract `arr[left]` from `windowSum` and move `left` forward.
4. Return the minimum length found (or 0 if no valid window exists).

### Key Difference:
This is the first variable window problem. Unlike fixed window, here we **shrink when valid** (to find minimum), not when invalid.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the number of elements in the array.
- **Space Complexity**: $O(1)$
