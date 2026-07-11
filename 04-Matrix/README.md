# 04. Matrix Pattern

Matrix (or 2D Array) patterns involve grid-based operations. These are highly popular in interviews because they require indexing mastery, boundary tracking, and coordinate transformations (such as rotation or transposing) in-place without using extra space.

---

## 💡 Types of Matrix Patterns

### 1. Coordinate Transformation
- **Concept**: Swapping or shifting cell coordinates based on mathematical formulas.
- **Used when**:
  - Transposing a matrix (swapping rows and columns: `matrix[i][j] -> transpose[j][i]`).
  - Rotating an image/matrix 90° clockwise in-place (Transpose + Reverse each row).
- **Visualization (Transpose)**:
  ```text
  1  2  3         1  4  7
  4  5  6   -->   2  5  8
  7  8  9         3  6  9
  ```

---

## 📋 Problem List

- ✅ 01. Transpose Matrix
- ✅ 02. Rotate Image (Brute Force & In-Place Optimized Solutions)

---

## The 90° Clockwise Rotation Formula

```text
Rotate 90° Clockwise = Transpose + Reverse Each Row
```

This trick allows rotating a square matrix in-place with $O(1)$ extra space!

---

## Complexity
- **Time Complexity**: $O(r \times c)$ where $r$ is the number of rows and $c$ is the number of columns (since we must visit every element at least once).
- **Space Complexity**: 
  - Brute Force: $O(r \times c)$ using an extra matrix.
  - Optimized: $O(1)$ auxiliary space by transposing and reversing rows in-place.
