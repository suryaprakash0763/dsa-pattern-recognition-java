# Sliding Window - Revision Notes

## What is Sliding Window?
Sliding Window means maintaining a contiguous subarray or substring and sliding it across the data to compute results efficiently.

### Common Forms:
1. **Fixed Size Window**
2. **Dynamic Size Window**

---

## Pattern 1: Fixed Size Window
Window size is given. Slide the window one step at a time.

### Used when:
- Maximum/Minimum sum of subarray of size K
- Average of subarrays of size K
- Count something in a fixed-length substring

### Visualization:
- Build the first window of size `k`
- Slide: add the new element entering from right, remove the element leaving from left

---

## Pattern 2: Dynamic Size Window
Window size is not fixed. Expand by moving `right`, shrink by moving `left` based on a condition.

### Used when:
- Longest substring with a condition
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

## Problem 2: Average of All Subarrays of Size K
### Question:
Given an array, find the average of all contiguous subarrays of size K.
### Example:
- **Input**: `arr = [1,3,2,6,-1,4,1,8,2]`, `k = 5`
- **Output**: `[2.2, 2.8, 2.4, 3.6, 2.8]`
### Pattern:
Sliding Window (Fixed Size)
### Pattern Recognition:
"All subarrays of size K" + "Average"
### Approach:
Build first window sum. Slide: add new element, remove old element. Divide by K for average.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(n - k + 1)$ for storing results

---

## Problem 3: Maximum Number of Vowels in a Substring of Given Length
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
Count vowels in first window. Slide: if entering character is vowel, add 1. If leaving character is vowel, subtract 1. Track maximum.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Problem 4: Longest Substring Without Repeating Characters
### Question:
Given a string, find the length of the longest substring without repeating characters.
### Example:
- **Input**: `s = "abcabcbb"`
- **Output**: `3` (substring `"abc"`)
### Pattern:
Sliding Window (Dynamic Size) + HashSet
### Pattern Recognition:
"Longest substring" + "No duplicates"
### Approach:
Use HashSet to track characters in window. Expand `right`. If duplicate found, shrink from `left` until duplicate is removed. Track maximum length.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(min(n, m))$ where m is the character set size

---

## Problem 5: Fruit Into Baskets
### Question:
Given an integer array representing fruit types, find the maximum number of fruits you can collect with at most 2 baskets (at most 2 distinct types).
### Example:
- **Input**: `fruits = [1,2,1,2,3]`
- **Output**: `4` (subarray `[1,2,1,2]`)
### Pattern:
Sliding Window (Dynamic Size) + HashMap
### Pattern Recognition:
"At most 2 distinct" + "Longest subarray"
### Approach:
Use HashMap to track frequency. Expand `right`. When `map.size() > 2`, shrink from `left` and reduce frequency. When count becomes 0, `map.remove()`. Track maximum length.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$ (at most 3 entries in map)

---

## Problem 6: Longest Repeating Character Replacement
### Question:
Given a string and an integer K, find the length of the longest substring where you can replace at most K characters to make all characters the same.
### Example:
- **Input**: `s = "AABABBA"`, `k = 1`
- **Output**: `4`
### Pattern:
Sliding Window (Dynamic Size) + HashMap + maxFrequency
### Pattern Recognition:
"Replace at most K characters" + "Longest substring"
### Approach:
Use HashMap for frequency. Track `maxFrequency`. If `windowLength - maxFrequency > k`, shrink from `left`. Track maximum length.
### Time & Space Complexity:
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$ (at most 26 entries for uppercase letters)

---

## Key Differences Between Dynamic Window Problems

| Problem | Tracking | Valid Condition | Need `map.remove()`? |
| :--- | :--- | :--- | :--- |
| Longest Substring Without Repeating | HashSet | No duplicate characters | Use `set.remove()` |
| Fruit Into Baskets | HashMap frequency | `map.size() <= 2` | Yes, when count becomes 0 |
| Longest Repeating Character Replacement | HashMap + maxFrequency | `windowLength - maxFrequency <= k` | No, we don't check `map.size()` |

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
