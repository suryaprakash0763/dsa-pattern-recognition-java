# 09. Max Consecutive Ones III

## Question
Given a binary array `nums` and an integer `k`, return the maximum number of consecutive `1`s in the array if you can flip at most `k` `0`s.

### Example
- **Input**: `nums = [1, 1, 0, 0, 1, 1, 1, 0, 1, 1]`, `k = 2`
- **Output**: `6` (flip two zeros → `[1, 1, 1, 1, 1, 1, 1, 0, 1, 1]`)

---

## Pattern Description
- **Pattern**: Sliding Window
- **Type**: Variable Size (counter-based)
- **Recognition Clue**: "At most K flips" + "Maximum consecutive ones" → dynamic window tracking zero count.

---

## Approach
1. Use a variable `zeroCount` to track the number of `0`s in the current window.
2. Move `right` pointer forward:
   - If `nums[right]` is `0`, increment `zeroCount`.
3. If `zeroCount > k` (too many zeros to flip):
   - Shrink from `left`: if `nums[left]` is `0`, decrement `zeroCount`.
   - Move `left` forward. Repeat until `zeroCount <= k`.
4. After each step, calculate the current window length (`right - left + 1`).
5. Track and return the maximum length.

### Key Insight:
We never actually flip the zeros. We only ask: **"Can this window become all 1s if I flip at most k zeros?"** If the number of zeros in the window exceeds `k`, the answer is no — so we shrink.

---

## Connection to Problem 7 and Problem 11
| Problem | What we keep | What we count | Valid when |
| :--- | :--- | :--- | :--- |
| Longest Subarray of 1s After Delete | 1s | zeros in window | `zeroCount <= 1` |
| Max Consecutive Ones III | 1s | zeros in window | `zeroCount <= k` |
| Longest Repeating Char Replacement | Most frequent char | different characters | `windowLength - maxFrequency <= k` |

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of the array.
- **Space Complexity**: $O(1)$
