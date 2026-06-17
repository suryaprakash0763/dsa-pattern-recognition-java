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
- ✅ 02. Maximum Average Subarray of Size K
- ✅ 03. Maximum Vowels in a Substring of Length K
- ✅ 04. Maximum Even Numbers in a Window of Size K

### Variable Size Window
- ✅ 05. Minimum Size Subarray Sum
- ✅ 06. Longest Subarray with Sum ≤ K
- ✅ 07. Longest Subarray of 1's After Deleting One Element
- ✅ 08. Longest Substring Without Repeating Characters
- ✅ 09. Max Consecutive Ones III
- ✅ 10. Fruit Into Baskets
- ✅ 11. Longest Repeating Character Replacement

---

## Tracking Techniques Learned

| Pattern | Variable / Data Structure |
| :--- | :--- |
| Sum tracking | `windowSum` |
| Count tracking | `zeroCount`, `vowelCount`, `evenCount` |
| Uniqueness checking | `HashSet` |
| Frequency counting | `HashMap` |
| Majority element in window | `HashMap` + `maxFrequency` |

---

## The Universal Variable Sliding Window Template

```java
for (right = 0; right < n; right++) {

    // 1. Add the right element

    // 2. If window becomes invalid
    while (invalid) {
        // Remove left element
        left++;
    }

    // 3. Window is valid → Update answer
}
```

---

## Complexity
- **Time Complexity**: $O(n)$ (since each element is visited at most twice — once by `right`, once by `left`).
- **Space Complexity**: $O(1)$ for fixed window, $O(k)$ for dynamic window (where `k` is the number of distinct elements tracked).
