# Complexity Cheat Sheet

This cheat sheet summarizes typical time and space complexities for Two Pointers and related patterns, along with explanations.

## Two Pointers Complexities

| Problem | Type | Time Complexity | Space Complexity | Notes / In-Place |
| :--- | :--- | :--- | :--- | :--- |
| **Reverse Array** | Left + Right | $O(n)$ | $O(1)$ | Swaps elements in-place |
| **Reverse String** | Left + Right | $O(n)$ | $O(1)$ | Swaps characters in-place |
| **Valid Palindrome** | Left + Right | $O(n)$ | $O(1)$ | Compares opposite elements |
| **Valid Palindrome II** | Left + Right | $O(n)$ | $O(1)$ | At most one character deletion |
| **Two Sum II (Sorted)** | Left + Right | $O(n)$ | $O(1)$ | Leverages sorted property |
| **Reverse Only Vowels** | Left + Right | $O(n)$ | $O(1)$ | Swaps only vowel elements |
| **Move Zeroes** | Read + Write | $O(n)$ | $O(1)$ | Shifts non-zeroes forward |
| **Remove Duplicates** | Read + Write | $O(n)$ | $O(1)$ | Keeps unique elements at start |
| **Remove Element** | Read + Write | $O(n)$ | $O(1)$ | Overwrites specified target element |
| **Keep Even Numbers Only** | Read + Write | $O(n)$ | $O(1)$ | Overwrites and returns count |
| **Move Negatives to End** | Filtering | $O(n)$ | $O(n)$ / $O(1)$ | In the user's implementation, $O(n)$ space is used for temporary array |
| **Palindrome Number** | Reverse Math | $O(\log n)$ | $O(1)$ | Digits reversed mathematically |

---

## Pattern Comparison

| Pattern | Typical Time Complexity | Typical Space Complexity | Main Advantage |
| :--- | :--- | :--- | :--- |
| **Two Pointers** | $O(n)$ | $O(1)$ | Avoids nested loops ($O(n^2)$) and reduces extra memory allocations. |
| **Sliding Window** | $O(n)$ | $O(1)$ or $O(k)$ | Avoids re-computing overlapping elements in subarrays. |
| **HashMap / HashSet** | $O(n)$ | $O(n)$ | Provides $O(1)$ lookup time at the cost of extra space. |
| **Prefix Sum** | $O(n)$ | $O(n)$ or $O(1)$ | Allows $O(1)$ range sum queries after $O(n)$ preprocessing. |
| **Greedy** | $O(n)$ | $O(1)$ | Simple and extremely fast when localized choices are guaranteed to be globally optimal. |
