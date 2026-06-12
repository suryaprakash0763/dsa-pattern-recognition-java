# 05. Remove Duplicates From Sorted Array

## Question
Given a sorted array, remove duplicates in-place such that each unique element appears only once. Return the length of the unique elements.

### Example
- **Input**: `[1, 1, 2, 2, 3, 3, 4]`
- **Output**: `[1, 2, 3, 4]` (printed unique values)

---

## Pattern Description
- **Pattern**: Two Pointers
- **Type**: Read + Write
- **Recognition Clue**: Sorted array + Duplicates are adjacent + Needs in-place clean up.

---

## Approach
1. The first element (`arr[0]`) is always unique. So, we initialize our `write` pointer `k` to `1`.
2. Start iterating with a `read` pointer `i` from index `1` to `arr.length - 1`.
3. If the current element `arr[i]` is not equal to the previous element `arr[i - 1]`, it is unique. Write it at `arr[k]` and increment `k`.
4. The unique elements are located in `arr[0]` to `arr[k - 1]`.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the array length.
- **Space Complexity**: $O(1)$ auxiliary space.

---

## Java Implementation
The complete code can be found in [RemoveDuplicatesSortedArray.java](file:///C:/Users/DELL/.gemini/antigravity-ide/scratch/DSA-Java/01-Two-Pointers/code/RemoveDuplicatesSortedArray.java).

```java
class Main {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4};

        int k = 1; // next position for unique element

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[k++] = arr[i];
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```
