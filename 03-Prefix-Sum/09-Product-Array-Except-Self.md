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
1. For any index `i`, the product except `nums[i]` is the product of all elements to its left multiplied by the product of all elements to its right.
2. In the first pass (left to right), store the prefix products in the result array `ans`:
   - `ans[0] = 1`
   - `ans[i] = ans[i - 1] * nums[i - 1]`
3. In the second pass (right to left), maintain a running `suffix` product initialized to `1`. Multiply the current `ans[i]` (which holds the prefix product) by `suffix`, then update `suffix = suffix * nums[i]`.
4. This calculates the correct product for every position without division and using only $O(1)$ auxiliary space (excluding the output array).

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of `nums`. We do exactly two linear passes over the array.
- **Space Complexity**: $O(1)$ auxiliary space (the output array is not counted towards auxiliary space complexity).

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
