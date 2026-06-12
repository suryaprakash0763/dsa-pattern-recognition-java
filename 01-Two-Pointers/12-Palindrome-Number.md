# 12. Palindrome Number

## Question
Check if an integer is a palindrome (without converting it to a string).

### Example
- **Input**: `23432` -> **Output**: `true`
- **Input**: `123` -> **Output**: `false`

---

## Pattern Description
- **Pattern**: Reverse Number Mathematically
- **Recognition Clue**: Compare a number with its mathematical reverse.

---

## Approach
1. Store the original number in a temporary variable `temp`.
2. Initialize `rev = 0`.
3. Loop while `temp > 0`:
   - Extract the last digit: `lastDigit = temp % 10`.
   - Update `temp`: `temp = temp / 10`.
   - Shift `rev` left and add `lastDigit`: `rev = rev * 10 + lastDigit`.
4. If `num == rev`, print `true`; else print `false`.

---

## Complexity
- **Time Complexity**: $O(\log n)$ where $n$ is the value of the number (since we divide by 10 in each iteration).
- **Space Complexity**: $O(1)$ auxiliary space.

---

## Java Implementation
The complete code can be found in [PalindromeNumber.java](file:///C:/Users/DELL/.gemini/antigravity-ide/scratch/DSA-Java/01-Two-Pointers/code/PalindromeNumber.java).

```java
class Main {
    public static void main(String[] args) {
        int num = 23432;
        int rev = 0;
        int temp = num;

        while (temp > 0) {
            int lastDigit = temp % 10;
            temp = temp / 10;
            rev = rev * 10 + lastDigit;
        }

        if (num == rev) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
    }
}
```
