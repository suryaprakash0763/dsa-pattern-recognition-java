# 02. Rotate Image (Rotate Matrix)

## Question
You are given an $n \times n$ 2D matrix representing an image, rotate the image by **90 degrees (clockwise)**.

You have to rotate the image **in-place**, which means you have to modify the input 2D matrix directly. **DO NOT** allocate another 2D matrix and do the rotation.

### Example
- **Input**:
  ```text
  1 2 3
  4 5 6
  7 8 9
  ```
- **Output**:
  ```text
  7 4 1
  8 5 2
  9 6 3
  ```

---

## Pattern Description
- **Pattern**: Coordinate Transformation
- **Recognition Clue**: Rotating a grid by 90 degrees. Can be split into standard sub-transformations: transpose and reverse.

---

## Approach

### 1. Brute Force (Extra Space)
- Create a new $n \times n$ matrix `rotated`.
- Move elements using the coordinate mapping:
  `rotated[j][n - 1 - i] = matrix[i][j]`
- **Space Complexity**: $O(n^2)$

### 2. Optimized (In-place)
We can rotate the matrix in-place using two simple steps:
1. **Transpose the matrix**: Swap elements along the main diagonal (`matrix[i][j]` and `matrix[j][i]` for $j > i$).
2. **Reverse each row**: Swap elements from left to right using a two-pointer approach within each row.

```text
Original Matrix:    Transpose:         Reverse Rows:
1 2 3               1 4 7              7 4 1
4 5 6        --->   2 5 8       --->   8 5 2
7 8 9               3 6 9              9 6 3
```

---

## Complexity
- **Time Complexity**: $O(n^2)$ where $n \times n$ is the size of the matrix. We visit elements during transpose ($O(n^2)$) and during row reversal ($O(n^2)$).
- **Space Complexity**:
  - Brute Force: $O(n^2)$
  - Optimized: $O(1)$ auxiliary space as the rotation is done in-place.

---

## Java Implementation

### Brute Force Solution
```java
public class RotateMatrixBrute {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }

        // Print result
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

### Optimized In-place Solution
```java
public class RotateMatrixOptimal {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        rotate(matrix);

        // Print result
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // 1. Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
```
