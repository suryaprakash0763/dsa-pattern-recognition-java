# 01. Running Sum of 1D Array

## Question
Given an array `nums`. We define a running sum of an array as `runningSum[i] = sum(nums[0]…nums[i])`. Return the running sum of `nums`.

### Example
- **Input**: `nums = [1, 2, 3, 4]`
- **Output**: `[1, 3, 6, 10]`
- **Explanation**: Running sum is obtained as follows: `[1, 1+2, 1+2+3, 1+2+3+4]`.

---

## Pattern Description
- **Pattern**: Prefix Sum
- **Type**: Cumulative Sum Array
- **Recognition Clue**: Requiring cumulative sums at each step where the value at `i` depends on the accumulated sums of previous indices.

---

## Approach
1. We can perform this in-place to avoid extra space.
2. Initialize a loop starting from index `1` up to the end of the array.
3. For each element, update its value by adding the element immediately to its left:
   `nums[i] = nums[i] + nums[i - 1]`
4. Return the modified `nums` array.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the number of elements in the array. We scan the array exactly once.
- **Space Complexity**: $O(1)$ auxiliary space if we modify the array in-place, or $O(n)$ if allocating a new array.

---

## Java Implementation

```java
import java.util.Arrays;

public class RunningSum1D {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        int[] result = runningSum(nums);

        System.out.println(Arrays.toString(result));
    }

    public static int[] runningSum(int[] nums) {
        // In-place calculation starting from the second element
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
```
