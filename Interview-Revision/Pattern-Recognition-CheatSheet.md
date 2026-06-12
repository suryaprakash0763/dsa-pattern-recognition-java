# Pattern Recognition Cheat Sheet

This cheat sheet helps you instantly identify which algorithmic pattern to apply based on clues in the problem description or examples.

| Key Clues / Visual Patterns | Recommended Pattern | Common Types / Variations |
| :--- | :--- | :--- |
| Reverse, Palindrome, Compare Ends, Sorted Array + Pair | **Two Pointers (Left + Right)** | Shrinking window, searching from both ends |
| Move elements, Remove/Filter values, Compress in-place | **Two Pointers (Read + Write)** | Fast/Slow runner indices for partition/filtering |
| Subarray, Substring, Size $K$, Contiguous elements | **Sliding Window** | Fixed size window, Dynamically resized window |
| Seen before, Duplicate check, Unique elements lookup | **HashSet** | $O(1)$ contains lookup |
| Frequency counts, occurrence counting, most frequent | **HashMap** | Key-Value mappings, memoization |
| Left Sum = Right Sum, Subarray Sum queries, Running Sum | **Prefix Sum** | Accumulating sum array or rolling sum variable |
| Need Left Product + Right Product, prefix/suffix values | **Prefix / Suffix** | Running product/statistics from left and right |
| Buy Low Sell High, Maximum Profit, Local Optimizations | **Greedy** | Finding locally optimal choice at each step |

---

## Pattern-Specific Clues

### 1. Two Pointers
- **Left + Right**: Used when you need to process elements from both ends toward the middle (e.g., palindrome validation, reversing an array/string, Two Sum II on a sorted array).
- **Read + Write**: Used when you want to modify an array in-place, keeping only valid elements (e.g., Move Zeroes, Remove Duplicates, Remove Element).

### 2. Sliding Window
- Used to track a contiguous block of elements in an array or string. Look for keywords like "longest/shortest substring", "subarray of size K", or "subarray with sum equal to X".

### 3. Hash Map / HashSet
- Great for checking existence in $O(1)$ time, tracking frequencies, or storing mappings from a value to its original index.

### 4. Prefix Sum
- Helpful when you need to calculate sums of sub-arrays repeatedly, or when you are comparing elements based on cumulative values (e.g., pivot index, subarray sum equals K).

### 5. Greedy
- Optimal choice at each step leads to a globally optimal solution. Look for problems asking for the minimum/maximum of something where a localized decision works (e.g., buying and selling stock).
