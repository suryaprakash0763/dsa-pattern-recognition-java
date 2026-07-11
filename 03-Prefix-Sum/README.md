# 03. Prefix Sum Pattern

Prefix Sum is a technique where we precompute cumulative sums of elements in a sequence. By computing the running totals upfront, we can answer range sum queries in $O(1)$ time, or solve partitioning and subarray sum problems efficiently in $O(n)$ time rather than $O(n^2)$.

---

## 💡 Types of Prefix Sum Patterns

### 1. Cumulative Sum Array (1D Running Sum)
- **Concept**: Transforming an array where each index `i` stores the sum of all elements from index `0` to `i`.
- **Formula**: `prefix[i] = prefix[i - 1] + arr[i]` (for $i > 0$).
- **Used when**:
  - Precomputing cumulative progress.
  - Querying the sum of any subarray between indices `i` and `j` in $O(1)$ time: `sum(i, j) = prefix[j] - prefix[i - 1]`.
- **Visualization**:
  ```text
  Original:   [ 1,  2,  3,  4 ]
  Prefix:     [ 1,  3,  6, 10 ]
  ```

### 2. Left vs. Right Sum (Pivot Point Partitioning)
- **Concept**: Finding a partition index where the sum of elements to the left equals the sum of elements to the right.
- **Formula**: `leftSum == totalSum - leftSum - arr[i]`.
- **Used when**:
  - Finding pivot indices or equilibrium points in an array.

### 3. Prefix Sum + HashMap (Subarray Sums with Negative Numbers)
- **Concept**: If the subarray sum from `i` to `j` is `k`, then `prefixSum[j] - prefixSum[i - 1] = k`. We can check if `prefixSum[j] - k` has been seen before using a HashMap.
- **Used when**:
  - Finding the count or maximum length of contiguous subarrays summing to `k`.

---

## 📋 Problem List

- ✅ 01. Running Sum of 1D Array
- ✅ 02. Find Pivot Index
- ✅ 03. Range Sum Query - Immutable
- ✅ 04. Find the Highest Altitude
- ✅ 05. Minimum Value to Get Positive Step by Step Sum
- ✅ 06. Subarray Sum Equals K
- ✅ 07. Subarray Sums Divisible by K
- ✅ 08. Contiguous Array
- ✅ 09. Product of Array Except Self

---

## Tracking Techniques Learned

| Pattern | Variable / Data Structure |
| :--- | :--- |
| Rolling Sum | `prefixSum`, `leftSum`, `currentAltitude`, `sum` |
| Cumulative Array | `prefix[]`, `ans[]` |
| Prefix modulo remainders | `remCounts[]` array of size `k` |
| Prefix Sum state tracking | `HashMap<Integer, Integer>` (prefixSum -> frequency/firstIndex) |

---

## Complexity
- **Time Complexity**: $O(n)$ (since we build and process the prefix sums in a single pass).
- **Space Complexity**:
  - $O(1)$ auxiliary space if done in-place or if using rolling sum variables.
  - $O(n)$ auxiliary space if creating a separate prefix sum array or HashMap.
