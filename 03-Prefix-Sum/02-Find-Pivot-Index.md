# 02. Find Pivot Index

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
1. Compute the `totalSum` of all elements in the array.
2. Maintain a running `leftSum` initialized to `0`.
3. Iterate through the array. At each index `i`:
   - Calculate the sum of elements to the right of `i` as:
     `rightSum = totalSum - leftSum - nums[i]`
   - If `leftSum == rightSum`, return `i` as the pivot index.
   - Otherwise, add `nums[i]` to `leftSum` and proceed.
4. If the loop completes without finding a pivot index, return `-1`.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of `nums`. We traverse the array to find the total sum, and then traverse it again to find the pivot.
- **Space Complexity**: $O(1)$ auxiliary space since we only use a few integer variables.

---

## Java Implementation

```java
public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};

        int pivot = pivotIndex(nums);

        System.out.println(pivot); // Output: 3
    }

    public static int pivotIndex(int[] nums) {
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
