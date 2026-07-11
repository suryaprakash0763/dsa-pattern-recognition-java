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

### 1. Brute Force
- Create a new array `result` of the same length.
- For each index `i`, compute the sum of elements from index `0` to `i` using a nested loop.
- **Time Complexity**: $O(n^2)$
- **Space Complexity**: $O(n)$ to store the result array.

### 2. Optimized (In-place Prefix Sum)
- Modify the input array in-place to save space.
- Start a loop from index `1`. For each index `i`, set `nums[i] = nums[i] + nums[i - 1]`.
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$ auxiliary space.

---

## Complexity
- **Time Complexity**:
  - Brute Force: $O(n^2)$
  - Optimized: $O(n)$
- **Space Complexity**:
  - Brute Force: $O(n)$
  - Optimized: $O(1)$ auxiliary space (in-place).

---

## Java Implementation

### Brute Force Solution
```java
import java.util.Arrays;

public class RunningSum1DBrute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = runningSum(nums);
        System.out.println(Arrays.toString(result)); // Output: [1, 3, 6, 10]
    }

    public static int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += nums[j];
            }
            result[i] = sum;
        }
        return result;
    }
}
```

### Optimized In-place Solution
```java
import java.util.Arrays;

public class RunningSum1D {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = runningSum(nums);
        System.out.println(Arrays.toString(result)); // Output: [1, 3, 6, 10]
    }

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
```
