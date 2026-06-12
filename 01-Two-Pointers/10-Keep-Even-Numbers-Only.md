# 10. Keep Even Numbers Only

## Question
Given an integer array, filter the array in-place so that it only retains even numbers.

### Example
- **Input**: `[1, 2, 3, 4, 5, 6]`
- **Output**: `[2, 4, 6]` (first three elements)

---

## Pattern Description
- **Pattern**: Two Pointers
- **Type**: Read + Write
- **Recognition Clue**: In-place filtering of elements.

---

## Approach
1. Set a `write` pointer `k` to `0`.
2. Iterate through the array using a `read` pointer `i` from `0` to `arr.length - 1`.
3. If `arr[i] % 2 == 0` (even number):
   - Write `arr[i]` to `arr[k]`.
   - Increment `k`.
4. The prefix of the array from `0` to `k - 1` contains the filtered even numbers.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the number of elements in the array.
- **Space Complexity**: $O(1)$ auxiliary space.

---

## Java Implementation
The complete code can be found in [KeepEvenNumbers.java](file:///C:/Users/DELL/.gemini/antigravity-ide/scratch/DSA-Java/01-Two-Pointers/code/KeepEvenNumbers.java).

```java
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arr[k++] = arr[i];
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```
