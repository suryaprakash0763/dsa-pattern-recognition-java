# 03. Reverse String

## Question
Given a character array, reverse it in-place.

### Example
- **Input**: `['h','e','l','l','o']`
- **Output**: `['o','l','l','e','h']`

---

## Pattern Description
- **Pattern**: Two Pointers
- **Type**: Left + Right
- **Recognition Clue**: Need first and last character together to swap.

---

## Approach
1. Place a pointer `left` at the beginning (`0`) and `right` at the end (`arr.length - 1`).
2. Swap elements at `left` and `right`.
3. Shift `left` forward (`left++`) and `right` backward (`right--`).
4. Repeat while `left < right`.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of the character array.
- **Space Complexity**: $O(1)$ auxiliary space.

---

## Java Implementation
The complete code can be found in [ReverseString.java](file:///C:/Users/DELL/.gemini/antigravity-ide/scratch/DSA-Java/01-Two-Pointers/code/ReverseString.java).

```java
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        char[] arr = {'h', 'e', 'l', 'l', 'o'};

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        System.out.print(Arrays.toString(arr));
    }
}
```
