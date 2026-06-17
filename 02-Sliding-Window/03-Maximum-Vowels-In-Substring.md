# 03. Maximum Vowels in a Substring of Length K

## Question
Given a string `s` and an integer `k`, return the maximum number of vowel letters in any substring of `s` with length `k`. Vowels are `a`, `e`, `i`, `o`, `u`.

### Example
- **Input**: `s = "abciiidef"`, `k = 3`
- **Output**: `3` (substring `"iii"`)

---

## Pattern Description
- **Pattern**: Sliding Window
- **Type**: Fixed Size
- **Recognition Clue**: "Substring of given length" + "Count vowels" → fixed window counting specific characters.

---

## Approach
1. Count the number of vowels in the first `k` characters (initial window).
2. Set this count as the current maximum.
3. Slide the window one position to the right:
   - If the new character entering from the right is a vowel, increment the count.
   - If the character leaving from the left is a vowel, decrement the count.
4. After each slide, compare the current count with the maximum.
5. Return the maximum vowel count.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of the string.
- **Space Complexity**: $O(1)$
