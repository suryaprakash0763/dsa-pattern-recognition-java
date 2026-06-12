# 07. Two Sum II - Input Array Is Sorted

## Question
Given a sorted integer array and a target value, return the indices of the two numbers that add up to the target.

### Example
- **Input**: `arr = [2,7,11,15]`, `target = 13`
- **Output**: `[0,1]` (indices of 2 and 11)

---

## Pattern Description
- **Pattern**: Two Pointers
- **Type**: Left + Right
- **Recognition Clue**: Sorted Array + Finding a pair.

---

## Approach
1. Since the array is sorted, we can place `left` at the start (`0`) and `right` at the end (`arr.length - 1`).
2. Calculate the `sum` at the two pointers:
   - If `sum == target`, we found our pair! Return `[left, right]`.
   - If `sum < target`, we need a larger sum. Move the `left` pointer forward to increase the sum.
   - If `sum > target`, we need a smaller sum. Move the `right` pointer backward to decrease the sum.
3. If pointers meet without finding a pair, return `[-1, -1]`.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the number of elements in the array.
- **Space Complexity**: $O(1)$ auxiliary space.

---

## Java Implementation
The complete code can be found in [TwoSumII.java](file:///C:/Users/DELL/.gemini/antigravity-ide/scratch/DSA-Java/01-Two-Pointers/code/TwoSumII.java).

```java
import java.util.Arrays;

class Main {
    public static int[] twoSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                return new int[] {left, right};
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 13;

        int[] result = twoSum(arr, target);
        System.out.print(Arrays.toString(result));
    }
}
```
