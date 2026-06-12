# 04. Move Zeroes

## Question
Move all zeroes to the end of the array while maintaining the relative order of the non-zero elements.

### Example
- **Input**: `[1,0,3,12,0,0,77,0,0]`
- **Output**: `[1,3,12,77,0,0,0,0,0]`

---

## Pattern Description
- **Pattern**: Two Pointers
- **Type**: Read + Write
- **Recognition Clue**: "Move elements" or "filter elements" in-place.

---

## Approach
1. Keep a `write` pointer (`k`) initialized to `0` that keeps track of where the next non-zero element should go.
2. Iterate through the array with a `read` pointer (`i`):
   - If the element at `i` is non-zero, write it to index `k` and increment `k`.
3. After scanning the array, fill the rest of the array (from index `k` to the end) with `0`.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the number of elements in the array.
- **Space Complexity**: $O(1)$ auxiliary space.

---

## Java Implementation
The complete code can be found in [MoveZeroes.java](file:///C:/Users/DELL/.gemini/antigravity-ide/scratch/DSA-Java/01-Two-Pointers/code/MoveZeroes.java).

```java
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] arr = {1, 0, 3, 12, 0, 0, 77, 0, 0};

        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[k++] = arr[i];
            }
        }

        for (int i = k; i < arr.length; i++) {
            arr[i] = 0;
        }

        System.out.println(Arrays.toString(arr));
    }
}
```
