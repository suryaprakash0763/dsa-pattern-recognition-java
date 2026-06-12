# 08. Reverse Only Vowels

## Question
Given a string, reverse only the vowels inside the string, keeping other characters in their original positions.

### Example
- **Input**: `"hello"`
- **Output**: `"holle"`

---

## Pattern Description
- **Pattern**: Two Pointers
- **Type**: Left + Right
- **Recognition Clue**: Reverse only a subset of elements matching specific criteria.

---

## Approach
1. Convert the string to a character array.
2. Initialize `left = 0` and `right = arr.length - 1`.
3. Check if elements at `left` and `right` are vowels (e.g., using a reference string `"aeiou"`):
   - If both are vowels: Swap them, increment `left`, and decrement `right`.
   - If `left` is not a vowel: Increment `left`.
   - If `right` is not a vowel: Decrement `right`.
4. Stop when `left >= right`.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of the string.
- **Space Complexity**: $O(1)$ auxiliary space if we do not count the character array converted from the input string.

---

## Java Implementation
The complete code can be found in [ReverseOnlyVowels.java](file:///C:/Users/DELL/.gemini/antigravity-ide/scratch/DSA-Java/01-Two-Pointers/code/ReverseOnlyVowels.java).

```java
class Main {
    public static void main(String[] args) {
        String word = "hello";
        char[] arr = word.toCharArray();
        String vowels = "aeiou";

        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (vowels.indexOf(arr[left]) != -1 && vowels.indexOf(arr[right]) != -1) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            } else if (vowels.indexOf(arr[left]) == -1) {
                left++;
            } else if (vowels.indexOf(arr[right]) == -1) {
                right--;
            }
        }

        String result = new String(arr);
        System.out.println(result);
    }
}
```
