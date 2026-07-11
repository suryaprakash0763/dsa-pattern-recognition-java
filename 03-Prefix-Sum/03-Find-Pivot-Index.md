# 03. Find Pivot Index

## Question
Given an array of integers `nums`, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the right of the index.

If the index is on the left edge of the array, then the left sum is `0` because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return `-1`.

### Example
- **Input**: `nums = [1, 7, 3, 6, 5, 6]`
- **Output**: `3`
- **Explanation**: 
  - Left sum = `nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11`
  - Right sum = `nums[4] + nums[5] = 5 + 6 = 11`
  - Since `Left sum == Right sum`, index `3` is the pivot index.

---

## Pattern Description
- **Pattern**: Prefix Sum
- **Type**: Left vs Right Sum
- **Recognition Clue**: Checking partition points where the cumulative sum on the left equals the cumulative sum on the right.

---

## Approach

### 1. Brute Force
- For each index `i`, calculate the sum of elements to its left (from `0` to `i - 1`) and the sum of elements to its right (from `i + 1` to `n - 1`).
- Check if `leftSum == rightSum`. Return `i` if true.
- **Time Complexity**: $O(n^2)$
- **Space Complexity**: $O(1)$

### 2. Optimized (Prefix Sum / Left vs Right Sum)
- Calculate the `totalSum` of all elements in the array.
- Maintain a running `leftSum` initialized to `0`.
- Iterate through the array. For each index `i`:
  - Calculate `rightSum = totalSum - leftSum - nums[i]`.
  - If `leftSum == rightSum`, return `i`.
  - Add `nums[i]` to `leftSum`.
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Complexity
- **Time Complexity**:
  - Brute Force: $O(n^2)$
  - Optimized: $O(n)$
- **Space Complexity**:
  - Brute Force: $O(1)$
  - Optimized: $O(1)$

---

## Java Implementation

- **Java Source File**: [FindPivotIndex.java](code/FindPivotIndex.java)

```java
public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};

        System.out.println("Brute Force Output: " + pivotIndexBruteForce(nums));
        System.out.println("Optimized Output: " + pivotIndexOptimized(nums));
    }

    // Brute Force: O(n^2) Time, O(1) Space
    public static int pivotIndexBruteForce(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }

            int rightSum = 0;
            for (int j = i + 1; j < n; j++) {
                rightSum += nums[j];
            }

            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    // Optimized: O(n) Time, O(1) Space
    public static int pivotIndexOptimized(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}
```
