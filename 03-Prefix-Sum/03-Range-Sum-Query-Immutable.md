# 03. Range Sum Query - Immutable

## Question
Given an integer array `nums`, handle multiple queries of the following type:
- Calculate the sum of the elements of `nums` between indices `left` and `right` inclusive where `left <= right`.

Implement the `NumArray` class:
- `NumArray(int[] nums)` Initializes the object with the integer array `nums`.
- `int sumRange(int left, int right)` Returns the sum of the elements of `nums` between indices `left` and `right` inclusive (i.e., `nums[left] + nums[left + 1] + ... + nums[right]`).

### Example
- **Input**:
  - `nums = [-2, 0, 3, -5, 2, -1]`
  - Queries: `sumRange(0, 2)`, `sumRange(2, 5)`, `sumRange(0, 5)`
- **Output**:
  - `1` (from `-2 + 0 + 3`)
  - `-1` (from `3 + (-5) + 2 + (-1)`)
  - `-3` (from `-2 + 0 + 3 + (-5) + 2 + (-1)`)

---

## Pattern Description
- **Pattern**: Prefix Sum
- **Type**: Cumulative Sum Array (1-indexed prefix sum)
- **Recognition Clue**: "Multiple queries" + "Sum of elements between indices left and right" → precalculate cumulative sum to avoid $O(n)$ work per query.

---

## Approach
1. Build a prefix sum array `prefix` of size `nums.length + 1`.
2. Define `prefix[0] = 0`.
3. Fill the prefix array: `prefix[i] = prefix[i - 1] + nums[i - 1]`.
4. To answer a query for `left` to `right`, compute:
   `prefix[right + 1] - prefix[left]` in $O(1)$ time.

---

## Complexity
- **Time Complexity**:
  - Initialization: $O(n)$ to build prefix array.
  - Query (`sumRange`): $O(1)$ constant time lookup.
- **Space Complexity**: $O(n)$ to store the prefix sum array.

---

## Java Implementation

```java
public class RangeSumQueryImmutable {
    private int[] prefix;

    public RangeSumQueryImmutable(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQueryImmutable numArray = new RangeSumQueryImmutable(nums);

        System.out.println(numArray.sumRange(0, 2)); // Output: 1
        System.out.println(numArray.sumRange(2, 5)); // Output: -1
        System.out.println(numArray.sumRange(0, 5)); // Output: -3
    }
}
```
