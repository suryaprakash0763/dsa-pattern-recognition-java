# Two Pointers - Revision Notes

## What is Two Pointers?
Two Pointers means using two indices to solve a problem efficiently.

### Common Forms:
1. **Left + Right**
2. **Read + Write**

---

## Pattern 1: Left + Right
Pointers start from opposite ends.

### Used when:
- Reverse
- Palindrome
- Compare first and last element
- Sorted array pair problems

### Visualization:
- `left` → start
- `right` → end
- Move inward until they meet.

---

## Pattern 2: Read + Write
One pointer reads, one pointer writes valid elements.

### Used when:
- Move elements
- Remove elements
- Filter elements
- Compress data

### Visualization:
- `read` → scans array
- `write` → stores valid values

---

## Problem 1: Reverse Array
### Question:
Given an integer array, reverse the array in-place.
### Example:
- **Input**: `[1, 2, 3, 4, 5]`
- **Output**: `[5, 4, 3, 2, 1]`
### Pattern:
Two Pointers (Left + Right)
### Pattern Recognition:
Need first and last element simultaneously.
### Approach:
Put `left` at beginning, `right` at end. Swap, move inward, and continue until `left >= right`.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 2: Valid Palindrome
### Question:
Given a string, return true if it reads the same forward and backward.
### Example:
- **Input**: `"tenet"` -> **Output**: `true`
- **Input**: `"hello"` -> **Output**: `false`
### Pattern:
Two Pointers (Left + Right)
### Pattern Recognition:
Need to compare first and last characters.
### Approach:
Compare `left` and `right` characters. If mismatch found, return `false`. Otherwise move inward. Continue until pointers meet.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 3: Reverse String
### Question:
Given a character array, reverse it in-place.
### Example:
- **Input**: `['h','e','l','l','o']`
- **Output**: `['o','l','l','e','h']`
### Pattern:
Two Pointers (Left + Right)
### Pattern Recognition:
Same pattern as Reverse Array (first and last character needed).
### Approach:
Swap first and last characters, move inward, and continue until pointers meet.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 4: Move Zeroes
### Question:
Move all zeroes to the end while maintaining the order of non-zero elements.
### Example:
- **Input**: `[1,0,3,12,0,0,77,0,0]`
- **Output**: `[1,3,12,77,0,0,0,0,0]`
### Pattern:
Two Pointers (Read + Write)
### Pattern Recognition:
Move valid values forward, filter unwanted values.
### Approach:
Read entire array. Write non-zero values. Fill remaining positions with zero.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 5: Remove Duplicates From Sorted Array
### Question:
Given a sorted array, remove duplicates in-place and keep only unique values.
### Example:
- **Input**: `[1,1,2,2,3,3,4]`
- **Output**: `[1,2,3,4]`
### Pattern:
Two Pointers (Read + Write)
### Pattern Recognition:
Sorted Array; duplicates are adjacent. Keep only unique values.
### Approach:
First element is always unique. Compare current element with previous element. If different, write it. Continue until end.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 6: Valid Palindrome II
### Question:
Given a string `s`, return true if the string can become a palindrome after deleting at most one character.
### Example:
- **Input**: `"abca"` -> **Output**: `true` (delete 'c' to get `"aba"`)
- **Input**: `"racecar"` -> **Output**: `true` (already a palindrome)
### Pattern:
Two Pointers (Left + Right)
### Pattern Recognition:
Palindrome check with one allowed mistake.
### Approach:
Compare characters from ends. On first mismatch, check if skipping left character or right character makes the remaining substring a palindrome.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 7: Two Sum II
### Question:
Given a sorted array and a target, return the indices of two numbers that add up to the target.
### Example:
- **Input**: `[2,7,11,15]`, `target = 9` -> **Output**: `[0,1]`
### Pattern:
Two Pointers (Left + Right)
### Pattern Recognition:
Sorted Array + Need a pair.
### Approach:
Evaluate sum of elements at `left` and `right`. If sum equals target, return indices. If less, move `left` inward (increase sum). If greater, move `right` inward (decrease sum).
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 8: Reverse Only Vowels
### Question:
Given a string, reverse only the vowels inside it.
### Example:
- **Input**: `"hello"` -> **Output**: `"holle"`
### Pattern:
Two Pointers (Left + Right)
### Pattern Recognition:
Reverse only specific characters.
### Approach:
Use `left` and `right` pointers. If both point to vowels, swap and move both inward. Otherwise, advance the pointer(s) not pointing to a vowel.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 9: Remove Element
### Question:
Given an array and a value, remove all instances of that value in-place and return the new length.
### Example:
- **Input**: `nums = [3,2,2,3]`, `val = 3` -> **Output**: `[2,2]` (first two elements)
### Pattern:
Two Pointers (Read + Write)
### Pattern Recognition:
Remove values, keep valid values.
### Approach:
Loop through array using `read` pointer. If the element is not equal to target value, copy it to `write` pointer and advance `write`.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 10: Keep Even Numbers Only
### Question:
Filter an array in-place keeping only even numbers.
### Example:
- **Input**: `[1, 2, 3, 4, 5, 6]` -> **Output**: `[2, 4, 6]`
### Pattern:
Two Pointers (Read + Write)
### Pattern Recognition:
Filter values.
### Approach:
Traverse array. Write element only if it is even.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 11: Move Negative Numbers to End
### Question:
Move negative numbers to the end of the array while keeping positive numbers first.
### Example:
- **Input**: `[1, -2, 3, -4, 5]` -> **Output**: `[1, 3, 5, -2, -4]`
### Pattern:
Filtering / Rearrangement
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(n)$ (Uses an extra array in your implementation)

---

## Problem 12: Palindrome Number
### Question:
Check if an integer is a palindrome without converting it to a string.
### Example:
- **Input**: `23432` -> **Output**: `true`
### Pattern:
Reverse Number Mathematically
### Time & Space Complexity:
- **Time Complexity**: $O(\log n)$
- **Space Complexity**: $O(1)$

---

## 💡 Two Pointer Recognition Cheat Sheet

### If you see:
- Reverse
- Palindrome
- Compare Ends
- Sorted Array + Pair
- **Think: LEFT + RIGHT**

### If you see:
- Move
- Remove
- Filter
- Compress
- Keep Valid Values
- **Think: READ + WRITE**
