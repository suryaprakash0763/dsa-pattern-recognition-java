# 04. Maximum Even Numbers in a Window of Size K

## Question
Given an integer array and an integer K, find the maximum number of even numbers in any contiguous subarray of size K.

### Example
- **Input**: `arr = [2, 3, 4, 6, 1, 8, 2]`, `k = 3`
- **Output**: `3` (subarray `[6, 8, 2]` or `[4, 6, 8]`)

---

## Pattern Description
- **Pattern**: Sliding Window
- **Type**: Fixed Size
- **Recognition Clue**: "Window of size K" + "Count even numbers" → fixed window counting elements with a condition.

---

## Approach
1. Count the number of even numbers in the first `k` elements (initial window).
2. Set this count as the current maximum.
3. Slide the window one position to the right:
   - If the new element entering is even, increment the count.
   - If the element leaving is even, decrement the count.
4. After each slide, compare the current count with the maximum.
5. Return the maximum even count.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the number of elements in the array.
- **Space Complexity**: $O(1)$
