# 06. Longest Repeating Character Replacement

## Question
Given a string `s` and an integer `k`, find the length of the longest substring where you can replace at most `k` characters to make all characters in the substring the same.

### Example
- **Input**: `s = "AABABBA"`, `k = 1`
- **Output**: `4`

---

## Pattern Description
- **Pattern**: Sliding Window
- **Type**: Dynamic Size + HashMap + maxFrequency
- **Recognition Clue**: "Replace at most K characters" + "Longest substring with all same characters" → dynamic window tracking the most frequent character.

---

## Approach
1. Use a `HashMap` to track the frequency of each character in the current window.
2. Track `maxFrequency` — the count of the most frequent character in the window.
3. Move `right` pointer forward:
   - Add `s.charAt(right)` to the map (increase frequency).
   - Update `maxFrequency` if the current character's count exceeds it.
4. Check validity: `(windowLength - maxFrequency) <= k`
   - `windowLength - maxFrequency` tells us how many characters need to be replaced.
   - If replacements needed `> k`, shrink from `left`: reduce frequency of `s.charAt(left)` and move `left` forward.
5. After each step, track the maximum valid window length.
6. Return the maximum length.

### Why `map.remove()` is NOT needed here:
Because the condition checks `windowLength - maxFrequency`, not `map.size()`. A key with count `0` does not affect the answer.

### Core Idea:
Keep the character that appears the most. Replace all other characters. If the number of replacements needed is more than `k`, shrink the window.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of the string.
- **Space Complexity**: $O(1)$ (at most 26 entries for uppercase English letters).
