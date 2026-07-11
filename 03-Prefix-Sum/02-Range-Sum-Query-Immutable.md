# 02. Range Sum Query - Immutable

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

### 1. Brute Force
- In the constructor, store the original array `nums` directly.
- In `sumRange(left, right)`, use a loop to iterate from `left` to `right` and sum the elements.
- **Time Complexity**:
  - Initialization: $O(1)$
  - Query (`sumRange`): $O(n)$ per query, where $n$ is the range length.
- **Space Complexity**: $O(1)$ auxiliary space.

### 2. Optimized (Prefix Sum Array)
- In the constructor, build a prefix sum array `prefix` of size `nums.length + 1` where `prefix[i]` stores the sum of the first `i` elements.
- In `sumRange(left, right)`, return `prefix[right + 1] - prefix[left]`. This handles the edge case where `left = 0` automatically.
- **Time Complexity**:
  - Initialization: $O(n)$ to precompute prefix sums.
  - Query (`sumRange`): $O(1)$ constant time lookup.
- **Space Complexity**: $O(n)$ to store the prefix sum array.

---

## Complexity
- **Time Complexity**:
  - Brute Force: $O(1)$ init, $O(n)$ per query.
  - Optimized: $O(n)$ init, $O(1)$ per query.
- **Space Complexity**:
  - Brute Force: $O(1)$ auxiliary space.
  - Optimized: $O(n)$ auxiliary space to store prefix sums.

---

## Java Implementation

### Brute Force Solution
```java
public class RangeSumQueryBrute {
    private int[] nums;

    public RangeSumQueryBrute(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQueryBrute numArray = new RangeSumQueryBrute(nums);
        System.out.println(numArray.sumRange(0, 2)); // Output: 1
        System.out.println(numArray.sumRange(2, 5)); // Output: -1
    }
}
```

### Optimized Solution (Prefix Sum)
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
