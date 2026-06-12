# 09. Remove Element

## Question
Given an integer array and a value `val`, remove all instances of that value in-place and return the count of remaining elements.

### Example
- **Input**: `arr = [4, 2, 2, 4]`, `val = 4`
- **Output**: `[2, 2]` (first two elements are non-target values)

---

## Pattern Description
- **Pattern**: Two Pointers
- **Type**: Read + Write
- **Recognition Clue**: "Remove element" or "filter values" in-place.

---

## Approach
1. Initialize the `write` pointer `k` to `0`.
2. Iterate through the array using a `read` pointer `i` from `0` to `arr.length - 1`.
3. If `arr[i] != val` (i.e., it is a valid element we want to keep):
   - Write `arr[i]` to `arr[k]`.
   - Increment `k`.
4. The remaining array up to index `k` represents the filtered array.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the number of elements in the array.
- **Space Complexity**: $O(1)$ auxiliary space.

---

## Java Implementation
The complete code can be found in [RemoveElement.java](file:///C:/Users/DELL/.gemini/antigravity-ide/scratch/DSA-Java/01-Two-Pointers/code/RemoveElement.java).

```java
class Main {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 4};
        int val = 4;
        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[k++] = arr[i];
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```
