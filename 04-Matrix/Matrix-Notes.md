# Matrix (2D Array) Pattern - Revision Notes

Matrix (2D Array) questions are essentially grid traversal or coordinate transformation problems. These problems test your ability to manage row and column indices accurately without going out of bounds.

---

## Pattern 1: Coordinate Transformation
Transforming a matrix requires mappings from one coordinate set `(i, j)` to another `(new_i, new_j)`.

### 1. Matrix Transposition
- **Definition**: Swapping rows with columns.
- **Rule**: `matrix[i][j]` goes to `transpose[j][i]`. We simply swap row and column indices.
- **Dry Run**:
  `matrix[0][1]` (2) goes to `transpose[1][0]`.
  `matrix[1][2]` (6) goes to `transpose[2][1]`.
- **Complexity**: $O(\text{rows} \times \text{columns})$ because every element is visited exactly once.

### 2. Rotate Image 90° Clockwise
- **Problem**: Rotate a 2D square matrix by 90 degrees clockwise.
- **Brute Force Solution**:
  - Create a new matrix `rotated` of size $N \times N$.
  - Place elements based on formula: `rotated[j][n - 1 - i] = matrix[i][j]`.
  - **Space Complexity**: $O(n^2)$ extra space.
- **Optimized Solution (In-place)**:
  We can rotate the matrix in-place in two steps using $O(1)$ extra space:
  - **Step 1: Transpose** the matrix (swap elements across the diagonal `matrix[i][j] <-> matrix[j][i]`).
  - **Step 2: Reverse each row** (swap left and right columns).
  - **Memory Trick**: `90° Clockwise Rotation = Transpose + Reverse Each Row`.

---

## Conceptual Revision: Spiral Matrix Boundary Traversal Order

### Why do we check boundaries only for Bottom Row and Left Column?
When traversing a matrix spirally, we maintain four boundary pointers: `top`, `bottom`, `left`, and `right`.
The loop runs while `top <= bottom && left <= right`. Inside, we traverse in four directions:
1. **Top Row**: Traverse from `left` to `right` along `top`. Increment `top`.
2. **Right Column**: Traverse from `top` to `bottom` along `right`. Decrement `right`.
3. **Bottom Row**: Traverse from `right` to `left` along `bottom`. Decrement `bottom`.
4. **Left Column**: Traverse from `bottom` to `top` along `left`. Increment `left`.

### Analysis of the Execution Order
- **Top Row**: Before this executes, the outer `while` condition has verified `top <= bottom && left <= right`. Thus, it is guaranteed to exist. No check needed.
- **Right Column**: Executes immediately after the Top Row. At this point, only `top` changed; column boundaries (`left`/`right`) have not changed. Thus, it is guaranteed to exist. No check needed.
- **Bottom Row**: Executes after `top++`. This update could have caused `top > bottom`. If it did, the bottom row no longer exists. Thus, we **must** check `if (top <= bottom)`.
- **Left Column**: Executes after `right--`. This update could have caused `left > right`. If it did, the left column no longer exists. Thus, we **must** check `if (left <= right)`.

### Memory Trick
- **Top & Right**: Execute *before* boundary limits of their respective dimensions change. (Always safe!)
- **Bottom & Left**: Execute *after* boundary limits of their respective dimensions have changed. (Need explicit `if` guards!)
