# 08. Longest Substring Without Repeating Characters

## Question
Given a string, find the length of the longest substring without repeating characters.

### Example
- **Input**: `s = "abcabcbb"`
- **Output**: `3` (substring `"abc"`)

---

## Pattern Description
- **Pattern**: Sliding Window
- **Type**: Variable Size + HashSet
- **Recognition Clue**: "Longest substring" + "No duplicate characters" → expand window until duplicate found, then shrink.

---

## Approach
1. Use a `HashSet` to track characters in the current window.
2. Move `right` pointer forward:
   - If `s.charAt(right)` is not in the set, add it and expand the window.
   - If `s.charAt(right)` is already in the set, remove `s.charAt(left)` from the set and move `left` forward. Repeat until the duplicate is removed.
3. After each step, calculate the current window length (`right - left + 1`).
4. Track and return the maximum length.

### New Concept: HashSet
This is the first problem that uses a **data structure** (HashSet) instead of a simple counter to track the window state. The HashSet ensures no character appears twice in the window.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of the string (each character is visited at most twice).
- **Space Complexity**: $O(min(n, m))$ where $m$ is the size of the character set.
