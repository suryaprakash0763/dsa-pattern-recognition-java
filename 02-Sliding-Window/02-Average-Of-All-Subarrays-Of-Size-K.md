# 02. Average of All Subarrays of Size K

## Question
Given an array, find the average of all contiguous subarrays of size K.

### Example
- **Input**: `arr = [1, 3, 2, 6, -1, 4, 1, 8, 2]`, `k = 5`
- **Output**: `[2.2, 2.8, 2.4, 3.6, 2.8]`

---

## Pattern Description
- **Pattern**: Sliding Window
- **Type**: Fixed Size
- **Recognition Clue**: "All subarrays of size K" + "Average" → slide a fixed window and compute average at each position.

---

## Approach
1. Compute the sum of the first `k` elements (initial window).
2. Store the average (`windowSum / k`) in the result.
3. Slide the window one position to the right:
   - Add `arr[i]` (entering element).
   - Remove `arr[i - k]` (leaving element).
4. Store the new average after each slide.
5. Return the result array containing all averages.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the number of elements in the array.
- **Space Complexity**: $O(n - k + 1)$ for storing the result averages.
