# 10. Fruit Into Baskets

## Question
You have a row of trees, each tree produces a fruit represented by an integer. You have 2 baskets, and each basket can only hold one type of fruit. Starting from any tree, collect the maximum number of fruits using at most 2 baskets (at most 2 distinct fruit types in a contiguous subarray).

### Example
- **Input**: `fruits = [1, 2, 1, 2, 3]`
- **Output**: `4` (subarray `[1, 2, 1, 2]`)

---

## Pattern Description
- **Pattern**: Sliding Window
- **Type**: Variable Size + HashMap (frequency count)
- **Recognition Clue**: "At most 2 distinct types" + "Longest contiguous subarray" → dynamic window with HashMap size constraint.

---

## Approach
1. Use a `HashMap` to track the frequency of each fruit type in the current window.
2. Move `right` pointer forward and add the fruit to the map (increase frequency).
3. If `map.size() > 2` (more than 2 distinct types):
   - Shrink from `left`: reduce the frequency of `fruits[left]`.
   - If the frequency becomes `0`, call `map.remove()` to delete that key.
   - Move `left` forward. Repeat until `map.size() <= 2`.
4. After each step, track the maximum window length (`right - left + 1`).
5. Return the maximum length.

### Why `map.remove()` is needed here:
Because the condition checks `map.size()`. Even if a fruit's count is `0`, it still counts as a key in the map. So we must remove it when count becomes `0`.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the number of trees.
- **Space Complexity**: $O(1)$ (at most 3 entries in the map at any time).
