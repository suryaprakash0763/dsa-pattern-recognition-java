# 02. Valid Palindrome

## Question
Given a string, return `true` if it reads the same forward and backward.

### Example
- **Input**: `"tenet"` -> **Output**: `true`
- **Input**: `"hello"` -> **Output**: `false`

---

## Pattern Description
- **Pattern**: Two Pointers
- **Type**: Left + Right
- **Recognition Clue**: Checking symmetry from ends inward.

---

## Approach
1. Place `left` pointer at index `0` and `right` pointer at `s.length() - 1`.
2. Compare character at `left` and `right`.
3. If they are equal, increment `left` and decrement `right`.
4. If they mismatch, set `found = false` and terminate the search early.
5. If pointers meet without mismatch, return `true`.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of the string.
- **Space Complexity**: $O(1)$ auxiliary space.

---

## Java Implementation
The complete code can be found in [ValidPalindrome.java](file:///C:/Users/DELL/.gemini/antigravity-ide/scratch/DSA-Java/01-Two-Pointers/code/ValidPalindrome.java).

```java
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        String s = "tenet";

        if (s.length() == 0) {
            System.out.print("False");
            return;
        }

        int left = 0;
        int right = s.length() - 1;
        boolean found = true;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                found = false;
                break;
            }
        }

        if (found) {
            System.out.print("True");
        } else {
            System.out.print("False");
        }
    }
}
```
