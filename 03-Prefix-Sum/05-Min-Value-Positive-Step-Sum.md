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

### 1. Brute Force (Simulation)
- Try candidate starting values sequentially starting from `1` (i.e., `startValue = 1, 2, 3, ...`).
- For each starting value, simulate the step-by-step running sum.
- If at any step the sum drops below `1`, discard this starting value, increment it, and restart the simulation from the beginning.
- **Time Complexity**: $O(n \times \text{ans})$ where $n$ is the length of `nums` and $\text{ans}$ is the correct starting value.
- **Space Complexity**: $O(1)$

### 2. Optimized (Prefix Sum Min-Tracking)
- Compute the running prefix sum `sum` starting at `0`, and track the minimum value `minSum` it ever reaches.
- The constraint is: `startValue + minSum >= 1`.
- Therefore, the minimum starting value is `1 - minSum`. If `minSum` is non-negative, the start value is `1`.
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$

---

## Complexity
- **Time Complexity**:
  - Brute Force: $O(n \times \text{ans})$
  - Optimized: $O(n)$
- **Space Complexity**:
  - Brute Force: $O(1)$
  - Optimized: $O(1)$

---

## Java Implementation

### Brute Force Solution
```java
public class MinValuePositiveStepSumBrute {
    public static void main(String[] args) {
        int[] nums = {-3, 2, -3, 4, 2};
        System.out.println(minStartValue(nums)); // Output: 5
    }

    public static int minStartValue(int[] nums) {
        int startValue = 1;
        while (true) {
            int currentSum = startValue;
            boolean isValid = true;
            for (int num : nums) {
                currentSum += num;
                if (currentSum < 1) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                return startValue;
            }
            startValue++;
        }
    }
}
```

### Optimized Solution (Prefix Sum Min-Tracking)
```java
public class MinValuePositiveStepSum {
    public static void main(String[] args) {
        int[] nums = {-3, 2, -3, 4, 2};
        System.out.println(minStartValue(nums)); // Output: 5
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
