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

### 1. Brute Force (Nested Loops)
- For each element `i`, calculate the product of all other elements in the array by looping through the array from `j = 0` to `n - 1`. Skip when `i == j`.
- **Time Complexity**: $O(n^2)$
- **Space Complexity**: $O(n)$ for the result array, $O(1)$ auxiliary space.

### 2. Optimized (Prefix and Suffix Products)
- For any index `i`, the product except `nums[i]` is the product of all elements to its left multiplied by the product of all elements to its right.
- In the first pass (left to right), store prefix products in the result array:
  `ans[i] = ans[i - 1] * nums[i - 1]`
- In the second pass (right to left), maintain a running `suffix` product and multiply it with the prefix product:
  `ans[i] = ans[i] * suffix`, then update `suffix = suffix * nums[i]`.
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$ auxiliary space (as the output array is not counted towards auxiliary space).

---

## Complexity
- **Time Complexity**:
  - Brute Force: $O(n^2)$
  - Optimized: $O(n)$
- **Space Complexity**:
  - Brute Force: $O(1)$ auxiliary space.
  - Optimized: $O(1)$ auxiliary space.

---

## Java Implementation

### Brute Force Solution
```java
import java.util.Arrays;

public class ProductArrayExceptSelfBrute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums))); // Output: [24, 12, 8, 6]
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            ans[i] = product;
        }
        return ans;
    }
}
```

### Optimized Solution (Prefix & Suffix Products)
```java
import java.util.Arrays;

public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums))); // Output: [24, 12, 8, 6]
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
