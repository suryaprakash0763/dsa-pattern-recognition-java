# 01. Two Pointers Pattern

Two Pointers is a technique where two indices (pointers) are used to traverse a data structure (usually an array, string, or linked list) simultaneously to solve problems efficiently. It is a powerful tool to reduce time complexity from $O(n^2)$ (from nested loops) to $O(n)$ with $O(1)$ auxiliary space.

---

## 💡 Types of Two Pointers Patterns

### 1. Left + Right (Opposite Ends)
- **Concept**: Pointers start from opposite ends of the data structure and move toward each other.
- **Used when**:
  - Reversing structures.
  - Palindrome verification.
  - Comparing start/end elements.
  - Pair searching in sorted arrays (e.g., Two Sum II).
- **Visualization**:
  ```text
  left → [ 1,  2,  3,  4,  5 ] ← right
  left++                         right--
  ```

### 2. Read + Write (Fast & Slow Runners)
- **Concept**: Both pointers start at the beginning (or same side) and move in the same direction, but at different conditions/speeds. One pointer ("Read") scans all elements, while the other ("Write") only advances when it places a valid element.
- **Used when**:
  - Modifying arrays in-place (filtering elements).
  - Removing duplicate values.
  - Moving elements (e.g., Move Zeroes, Move Negatives).
- **Visualization**:
  ```text
  write, read → [ 1,  0,  3,  12 ]
  (read scans each element, write only updates on non-zero)
  ```

---

## 🔍 Two Pointer Recognition Cheat Sheet

| Action | Pattern |
| :--- | :--- |
| **Reverse** / **Palindrome** / **Compare Ends** / **Sorted Pair** | **Left + Right** |
| **Move** / **Remove** / **Filter** / **Compress** / **In-place Cleanup** | **Read + Write** |

---

## 🎯 Typical Complexity
- **Time Complexity**: $O(n)$ (since we traverse the array at most once or twice).
- **Space Complexity**: $O(1)$ (using a few integer pointer variables).
