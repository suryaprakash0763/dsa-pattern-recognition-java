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

---

## 📋 Problem List

- ✅ 01. Running Sum of 1D Array
- ✅ 02. Find Pivot Index

---

## Tracking Techniques Learned

| Pattern | Variable / Data Structure |
| :--- | :--- |
| Rolling Sum | `prefixSum`, `leftSum` |
| Cumulative Array | `prefix[]` |

---

## Complexity
- **Time Complexity**: $O(n)$ (since we build the sum array in a single pass of the input).
- **Space Complexity**:
  - $O(1)$ auxiliary space if done in-place or if using rolling sum variables.
  - $O(n)$ auxiliary space if creating a separate prefix sum array.
