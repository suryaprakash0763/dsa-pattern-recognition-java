# 11. Move Negative Numbers to End

## Question
Move all negative numbers to the end of the array while keeping the relative order of positive numbers.

### Example
- **Input**: `[1, -2, 3, -4, 5]`
- **Output**: `[1, 3, 5, -2, -4]`

---

## Pattern Description
- **Pattern**: Filtering / Rearrangement
- **Recognition Clue**: Separating/filtering positive and negative values.

---

## Approach
1. Create a secondary array `result` of the same size.
2. Maintain a write index `k = 0`.
3. First pass: Scan the original array and copy all non-negative numbers ($\ge 0$) to `result`.
4. Second pass: Scan the original array and copy all negative numbers ($< 0$) to `result`.
5. Print or use the `result` array.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the number of elements in the array (two linear scans).
- **Space Complexity**: $O(n)$ auxiliary space to store the results.

---

## Java Implementation
The complete code can be found in [MoveNegativeNumbers.java](file:///C:/Users/DELL/.gemini/antigravity-ide/scratch/DSA-Java/01-Two-Pointers/code/MoveNegativeNumbers.java).

```java
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -4, 5};
        int[] result = new int[arr.length];
        int k = 0;

        // positives first
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                result[k++] = arr[i];
            }
        }

        // negatives next
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                result[k++] = arr[i];
            }
        }

        System.out.println(Arrays.toString(result));
    }
}
```
