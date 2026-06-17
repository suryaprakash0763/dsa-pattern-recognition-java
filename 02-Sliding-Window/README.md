# 02. Sliding Window Pattern

Sliding Window is a technique where a window (a contiguous subarray or substring) moves across the data structure to efficiently compute results without re-processing all elements. It is a powerful tool to reduce time complexity from $O(n^2)$ (from nested loops) to $O(n)$.

---

## 💡 Types of Sliding Window Patterns

### 1. Fixed Size Window
- **Concept**: The window size is given (e.g., size `k`). We slide the window one element at a time and compute the result.
- **Used when**:
  - Maximum/minimum sum of subarray of size K.
  - Average of subarrays of size K.
  - Counting elements in a fixed-length substring.
- **Visualization**:
  ```text
  [ 1,  3,  2,  6,  -1,  4,  1,  8,  2 ]
  |_____|                                   → window of size 3
       |_____|                               → slide right by 1
  ```

### 2. Dynamic Size Window (Variable Window)
- **Concept**: The window size is not fixed. We expand the window by moving `right`, and shrink it by moving `left` based on a condition.
- **Used when**:
  - Longest/shortest substring with a condition.
  - Subarray with at most K distinct elements.
  - Maximum window where replacements are within a limit.
- **Visualization**:
  ```text
  left         right
    ↓            ↓
  [ A,  B,  C,  B,  A,  D ]
  |______________|
       valid window → expand right
  ```

---

## 📋 Problem List

### Fixed Size Window
- ✅ 01. Maximum Sum Subarray of Size K
- ✅ 02. Average of All Subarrays of Size K
- ✅ 03. Maximum Number of Vowels in a Substring of Given Length

### Dynamic Size Window
- ✅ 04. Longest Substring Without Repeating Characters
- ✅ 05. Fruit Into Baskets
- ✅ 06. Longest Repeating Character Replacement

---

## Complexity
- **Time Complexity**: $O(n)$ (since each element is visited at most twice — once by `right`, once by `left`).
- **Space Complexity**: $O(1)$ for fixed window, $O(k)$ for dynamic window (where `k` is the number of distinct elements tracked).
