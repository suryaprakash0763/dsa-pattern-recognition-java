# 06. Valid Palindrome II

## Question
Given a string `s`, return `true` if the string can become a palindrome after deleting at most one character.

### Example 1
- **Input**: `"abca"`
- **Output**: `true` (Delete `'c'` to get `"aba"`, which is a palindrome)

### Example 2
- **Input**: `"racecar"`
- **Output**: `true` (Already a palindrome)

---

## Pattern Description
- **Pattern**: Two Pointers
- **Type**: Left + Right + One Allowed Mistake
- **Recognition Clue**: Checking palindrome with a tolerance of at most one deletion.

---

## Approach
1. Place a pointer `left` at the beginning and `right` at the end of the string.
2. Compare characters. While they match, move `left` forward and `right` backward.
3. If they mismatch:
   - Try removing the character at `left` (check if substring from `left + 1` to `right` is a palindrome).
   - Or, try removing the character at `right` (check if substring from `left` to `right - 1` is a palindrome).
   - If either check is a palindrome, return `true`; else return `false`.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of the string. (We do at most two helper scans of size at most $n$).
- **Space Complexity**: $O(1)$ auxiliary space.

---

## Java Implementation
The complete code can be found in [ValidPalindromeII.java](file:///C:/Users/DELL/.gemini/antigravity-ide/scratch/DSA-Java/01-Two-Pointers/code/ValidPalindromeII.java).

```java
class Main {
    static boolean isPalindrome(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcbda";

        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;
        boolean result = true;

        while (left < right) {
            if (arr[left] == arr[right]) {
                left++;
                right--;
            } else {
                result = isPalindrome(arr, left + 1, right) ||
                         isPalindrome(arr, left, right - 1);
                break;
            }
        }

        System.out.println(result);
    }
}
```
