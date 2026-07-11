# 05. Minimum Value to Get Positive Step by Step Sum

## Question
Given an array of integers `nums`, you start with an initial positive value `startValue`.

In each iteration, you calculate the step by step sum of `startValue` plus elements in `nums` (from left to right).

Return the minimum positive value of `startValue` such that the step by step sum is never less than 1.

### Example
- **Input**: `nums = [-3, 2, -3, 4, 2]`
- **Output**: `5`
- **Explanation**: If we choose `startValue = 5`:
  - `5 + (-3) = 2`
  - `2 + 2 = 4`
  - `4 + (-3) = 1`
  - `1 + 4 = 5`
  - `5 + 2 = 7`
  All step-by-step sums are $\ge 1$. If we chose `4`, the third step would yield `0`, which is $< 1$.

---

## Pattern Description
- **Pattern**: Prefix Sum
- **Type**: Tracking Minimum Cumulative Sum
- **Recognition Clue**: We need to keep a running total above a threshold. The bottleneck is the lowest point the cumulative sum reaches.

---

## Approach
1. Let `sum` be the running prefix sum starting at `0`, and `minSum` be the minimum value `sum` ever reaches.
2. Traverse through `nums`:
   - `sum += num`
   - `minSum = Math.min(minSum, sum)`
3. Since we want `startValue + minSum >= 1`, we need:
   `startValue >= 1 - minSum`
4. Since `startValue` must be positive ($\ge 1$), we return `Math.max(1, 1 - minSum)`.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of `nums`.
- **Space Complexity**: $O(1)$ auxiliary space.

---

## Java Implementation

```java
public class MinValuePositiveStepSum {
    public static void main(String[] args) {
        int[] nums = {-3, 2, -3, 4, 2};

        int minStartVal = minStartValue(nums);

        System.out.println(minStartVal); // Output: 5
    }

    public static int minStartValue(int[] nums) {
        int sum = 0;
        int minSum = 0;

        for (int num : nums) {
            sum += num;
            if (sum < minSum) {
                minSum = sum;
            }
        }

        return 1 - minSum;
    }
}
```
