# 01. Reverse Array

## Question
Given an integer array, reverse the array in-place.

### Example
- **Input**: `[1, 2, 3, 4, 5]`
- **Output**: `[5, 4, 3, 2, 1]`

---

## Pattern Description
- **Pattern**: Two Pointers
- **Type**: Left + Right
- **Recognition Clue**: We need to access/swap the first and last elements simultaneously, moving inward.

---

## Approach
1. Place a pointer `left` at index `0` and `right` at `array.length - 1`.
2. Swap the elements at `left` and `right`.
3. Increment `left` and decrement `right`.
4. Repeat this process as long as `left < right`.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the number of elements in the array (since we traverse half the array).
- **Space Complexity**: $O(1)$ auxiliary space as we do the reversal in-place.

---

## Java Implementation
The complete code can be found in [ReverseArray.java](file:///C:/Users/DELL/.gemini/antigravity-ide/scratch/DSA-Java/01-Two-Pointers/code/ReverseArray.java).

```java
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        System.out.print(Arrays.toString(arr));
    }
}
```
