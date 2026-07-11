# 09. Product of Array Except Self

## Question
Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

The product of any prefix or suffix of `nums` is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in $O(n)$ time and without using the division operator.

### Example
- **Input**: `nums = [1, 2, 3, 4]`
- **Output**: `[24, 12, 8, 6]`
- **Explanation**:
  - `answer[0] = 2 * 3 * 4 = 24`
  - `answer[1] = 1 * 3 * 4 = 12`
  - `answer[2] = 1 * 2 * 4 = 8`
  - `answer[3] = 1 * 2 * 3 = 6`

---

## Pattern Description
- **Pattern**: Prefix / Suffix Product
- **Type**: Two-Pass Running Accumulation
- **Recognition Clue**: "Product of array except self" + "without division" → we need left-side products and right-side products for each element, which are computed using prefix and suffix structures.

---

## Approach
1. Initialize an output array `ans` of the same length as `nums`.
2. **First Pass (Prefix Products)**:
   - Let `ans[i]` store the product of all elements to the left of `i`.
   - Set `ans[0] = 1`.
   - For `i` from `1` to `nums.length - 1`:
     `ans[i] = ans[i - 1] * nums[i - 1]`.
3. **Second Pass (Suffix Products)**:
   - Use a rolling variable `suffixProduct` initialized to `1` to represent the product of all elements to the right of `i`.
   - Traverse backwards from `nums.length - 1` down to `0`:
     - Update the output: `ans[i] = ans[i] * suffixProduct`.
     - Update the rolling suffix: `suffixProduct = suffixProduct * nums[i]`.
4. Return the `ans` array.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of `nums`. We perform two linear passes.
- **Space Complexity**: $O(1)$ auxiliary space (excluding the output array, as specified in LeetCode rules).

---

## Java Implementation

```java
import java.util.Arrays;

public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        System.out.println(Arrays.toString(result)); // Output: [24, 12, 8, 6]
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // Step 1: Calculate prefix products (store in ans)
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate suffix products on the fly and multiply with prefix
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * suffix;
            suffix *= nums[i];
        }

        return ans;
    }
}
```
