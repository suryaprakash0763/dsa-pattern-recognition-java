# Sliding Window - Revision Notes

## What is Sliding Window?
Sliding Window means maintaining a contiguous subarray or substring and sliding it across the data to compute results efficiently.

### Common Forms:
1. **Fixed Size Window**
2. **Variable Size Window**

---

## Pattern 1: Fixed Size Window
Window size is given. Slide the window one step at a time.

### Used when:
- Maximum/Minimum sum of subarray of size K
- Maximum average of subarray of size K
- Count something in a fixed-length substring/window

### Visualization:
- Build the first window of size `k`
- Slide: add the new element entering from right, remove the element leaving from left

---

## Pattern 2: Variable Size Window
Window size is not fixed. Expand by moving `right`, shrink by moving `left` based on a condition.

### Used when:
- Longest/shortest substring with a condition
- At most K distinct elements
- Maximum window where replacements ≤ k

### Visualization:
- `right` → expands the window
- `left` → shrinks the window when condition is violated

---

## Problem 1: Maximum Sum Subarray of Size K
### Question:
Given an integer array and a number K, find the maximum sum of any contiguous subarray of size K.
### Example:
- **Input**: `arr = [2,1,5,1,3,2]`, `k = 3`
- **Output**: `9` (subarray `[5,1,3]`)
### Pattern:
Sliding Window (Fixed Size)
### Pattern Recognition:
"Subarray of size K" + "Maximum sum"
### Approach:
Build first window sum. Then slide: add `arr[i]`, remove `arr[i - k]`. Track maximum.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 2: Maximum Average Subarray of Size K
### Question:
Given an integer array and an integer K, find the maximum average of any contiguous subarray of size K.
### Example:
- **Input**: `arr = [1,12,-5,-6,50,3]`, `k = 4`
- **Output**: `12.75`
### Pattern:
Sliding Window (Fixed Size)
### Pattern Recognition:
Same as Maximum Sum, just divide by K at the end.
### Approach:
Build first window sum. Slide: add new, remove old. Track max sum. Return maxSum / k.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 3: Maximum Vowels in a Substring of Length K
### Question:
Given a string and an integer K, return the maximum number of vowels in any substring of length K.
### Example:
- **Input**: `s = "abciiidef"`, `k = 3`
- **Output**: `3` (substring `"iii"`)
### Pattern:
Sliding Window (Fixed Size)
### Pattern Recognition:
"Substring of given length" + "Count vowels"
### Approach:
Count vowels in first window. Slide: if entering is vowel, add 1. If leaving is vowel, subtract 1. Track maximum.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 4: Maximum Even Numbers in a Window of Size K
### Question:
Given an integer array and an integer K, find the maximum number of even numbers in any contiguous subarray of size K.
### Example:
- **Input**: `arr = [2,3,4,6,1,8,2]`, `k = 3`
- **Output**: `3`
### Pattern:
Sliding Window (Fixed Size)
### Pattern Recognition:
"Window of size K" + "Count even numbers"
### Approach:
Count evens in first window. Slide: if entering is even, add 1. If leaving is even, subtract 1. Track maximum.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 5: Minimum Size Subarray Sum
### Question:
Given an array of positive integers and a target, find the minimum length of a contiguous subarray whose sum >= target.
### Example:
- **Input**: `arr = [2,3,1,2,4,3]`, `target = 7`
- **Output**: `2` (subarray `[4,3]`)
### Pattern:
Sliding Window (Variable Size) — Find minimum valid window
### Pattern Recognition:
"Minimum length" + "Sum >= target"
### Approach:
Expand right, add to windowSum. While windowSum >= target (valid): update min length, then shrink left.
### Key Insight:
Shrink when **valid** (to find minimum), not when invalid.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 6: Longest Subarray with Sum ≤ K
### Question:
Given an array of positive integers and K, find the length of the longest subarray whose sum ≤ K.
### Example:
- **Input**: `arr = [1,2,3,4,5]`, `k = 7`
- **Output**: `3` (subarray `[1,2,3]`)
### Pattern:
Sliding Window (Variable Size) — Find maximum valid window
### Pattern Recognition:
"Longest subarray" + "Sum ≤ K"
### Approach:
Expand right, add to windowSum. While windowSum > k (invalid): shrink left. Track maximum length.
### Key Insight:
Shrink when **invalid** (to find maximum), opposite of Problem 5.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 7: Longest Subarray of 1's After Deleting One Element
### Question:
Given a binary array, return the length of the longest subarray of 1s after deleting exactly one element.
### Example:
- **Input**: `nums = [1,1,0,1,1,1]`
- **Output**: `5`
### Pattern:
Sliding Window (Variable Size) + Counter
### Pattern Recognition:
"Delete one element" + "Longest subarray of 1s"
### Approach:
Track zeroCount. While zeroCount > 1, shrink left. Answer is `right - left` (not +1, because we must delete one).
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 8: Longest Substring Without Repeating Characters
### Question:
Given a string, find the length of the longest substring without repeating characters.
### Example:
- **Input**: `s = "abcabcbb"`
- **Output**: `3` (substring `"abc"`)
### Pattern:
Sliding Window (Variable Size) + HashSet
### Pattern Recognition:
"Longest substring" + "No duplicates"
### Approach:
Use HashSet. Expand right. If duplicate found, shrink left and remove from set until duplicate gone. Track maximum length.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(min(n, m))$

---

## Problem 9: Max Consecutive Ones III
### Question:
Given a binary array and integer K, return the maximum number of consecutive 1s if you can flip at most K zeros.
### Example:
- **Input**: `nums = [1,1,0,0,1,1,1,0,1,1]`, `k = 2`
- **Output**: `6`
### Pattern:
Sliding Window (Variable Size) + Counter
### Pattern Recognition:
"At most K flips" + "Maximum consecutive ones"
### Approach:
Track zeroCount. While zeroCount > k, shrink left. Track maximum length.
### Key Insight:
We never actually flip the zeros. We only ask: "Can this window become all 1s with at most k flips?"
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 10: Fruit Into Baskets
### Question:
Given an array of fruit types, find the maximum number of fruits you can collect with at most 2 baskets (at most 2 distinct types).
### Example:
- **Input**: `fruits = [1,2,1,2,3]`
- **Output**: `4`
### Pattern:
Sliding Window (Variable Size) + HashMap
### Pattern Recognition:
"At most 2 distinct" + "Longest subarray"
### Approach:
Use HashMap for frequency. While map.size() > 2, shrink left and reduce frequency. When count = 0, map.remove(). Track maximum length.
### Key Insight:
Must use `map.remove()` because condition checks `map.size()`.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 11: Longest Repeating Character Replacement
### Question:
Given a string and integer K, find the length of the longest substring where you can replace at most K characters to make all characters the same.
### Example:
- **Input**: `s = "AABABBA"`, `k = 1`
- **Output**: `4`
### Pattern:
Sliding Window (Variable Size) + HashMap + maxFrequency
### Pattern Recognition:
"Replace at most K" + "Longest substring"
### Approach:
Use HashMap for frequency. Track maxFrequency. If windowLength - maxFrequency > k, shrink left. Track maximum length.
### Core Idea:
Keep the majority character. Replace all others. If replacements > k, shrink.
### Key Insight:
No `map.remove()` needed — condition doesn't check `map.size()`.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Key Differences Between All Variable Window Problems

| # | Problem | Tracking | Valid Condition | Shrink when |
| :--- | :--- | :--- | :--- | :--- |
| 05 | Min Size Subarray Sum | windowSum | `windowSum >= target` | Valid (find min) |
| 06 | Longest Subarray Sum ≤ K | windowSum | `windowSum <= k` | Invalid (find max) |
| 07 | Longest 1s After Delete | zeroCount | `zeroCount <= 1` | Invalid |
| 08 | Longest Substring No Repeat | HashSet | No duplicate | Invalid (duplicate) |
| 09 | Max Consecutive Ones III | zeroCount | `zeroCount <= k` | Invalid |
| 10 | Fruit Into Baskets | HashMap freq | `map.size() <= 2` | Invalid |
| 11 | Char Replacement | HashMap + maxFreq | `winLen - maxFreq <= k` | Invalid |

---

## The Biggest Connection (Problems 9 and 11)

| Problem | What we keep | What we count | Valid when |
| :--- | :--- | :--- | :--- |
| Max Consecutive Ones III | 1s | zeros in window | `zeroCount <= k` |
| Longest Repeating Char Replacement | Most frequent char | different characters | `windowLength - maxFrequency <= k` |

**One sentence to remember:** Sliding window never performs the operation. It only checks whether the current window could become valid after doing the allowed operation.

---

## Core Sliding Window Flow

```text
right enters
      ↓
Add its effect (add to sum / add to set / increase frequency)
      ↓
Check validity of window
      ↓
If invalid:
  Move left → Remove its effect
      ↓
Store maximum/minimum valid result
```

### One important idea from all sliding windows:
- `right` enters → **add** its effect
- `left` leaves → **remove** its effect
- **How you remove the effect depends on what your window condition needs.**
