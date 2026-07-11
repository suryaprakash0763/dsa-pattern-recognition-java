# 01. Transpose Matrix

## Question
Given a 2D integer array `matrix`, return the transpose of `matrix`.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.

### Example
- **Input**:
  ```text
  1 2 3
  4 5 6
  ```
- **Output**:
  ```text
  1 4
  2 5
  3 6
  ```
- **Explanation**: Rows become columns:
  - `matrix[i][j]` goes to `transpose[j][i]`.

---

## Pattern Description
- **Pattern**: Coordinate Transformation
- **Recognition Clue**: We swap the row and column coordinates.

---

## Approach
1. Find the dimensions of the original matrix: `rows = matrix.length` and `cols = matrix[0].length`.
2. Initialize a new 2D array `transpose` of size `cols x rows`.
3. Loop through each cell `(i, j)` of the original matrix:
   - Assign `transpose[j][i] = matrix[i][j]`.
4. Return the `transpose` matrix.

---

## Complexity
- **Time Complexity**: $O(\text{rows} \times \text{cols})$ as every element in the matrix is visited exactly once.
- **Space Complexity**: $O(\text{rows} \times \text{cols})$ to store the transposed matrix.

---

## Java Implementation

```java
public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] transpose = transpose(matrix);

        // Print result
        for (int i = 0; i < transpose.length; i++) {
            for (int j = 0; j < transpose[i].length; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transpose = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }
}
```
