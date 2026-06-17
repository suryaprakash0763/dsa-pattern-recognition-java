# 07. Longest Subarray of 1's After Deleting One Element

## Question
Given a binary array, return the length of the longest subarray containing only `1`s after deleting exactly one element.

### Example
- **Input**: `nums = [1, 1, 0, 1, 1, 1]`
- **Output**: `5` (delete the `0` → `[1, 1, 1, 1, 1]`)

---

## Pattern Description
- **Pattern**: Sliding Window
- **Type**: Variable Size (counter-based)
- **Recognition Clue**: "Delete one element" + "Longest subarray of 1s" → dynamic window allowing at most 1 zero.

---

## Approach
1. Use a variable `zeroCount` to track the number of `0`s in the current window.
2. Move `right` pointer forward:
   - If `nums[right]` is `0`, increment `zeroCount`.
3. While `zeroCount > 1` (more than one zero — invalid):
   - Shrink from `left`: if `nums[left]` is `0`, decrement `zeroCount`.
   - Move `left` forward.
4. Track the maximum window length (`right - left`).
   - Note: we use `right - left` instead of `right - left + 1` because we must delete one element.
5. Return the maximum length.

### Connection to Max Consecutive Ones III:
This is the same pattern with `k = 1`, but we **must** delete one element (even if all are 1s), so the answer is `windowLength - 1`.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of the array.
- **Space Complexity**: $O(1)$
