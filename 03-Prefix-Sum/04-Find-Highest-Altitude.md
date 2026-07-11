# 04. Find the Highest Altitude

## Question
There is a biker on a road trip. The road trip consists of `n + 1` points at different altitudes. The biker starts his trip on point `0` with altitude `0`.

You are given an integer array `gain` of length `n` where `gain[i]` is the net gain in altitude between points `i` and `i + 1` for all `0 <= i < n`. Return the highest altitude of a point.

### Example
- **Input**: `gain = [-5, 1, 5, 0, -7]`
- **Output**: `1`
- **Explanation**: The altitudes are `[0, -5, -4, 1, 1, -6]`. The highest is `1`.

---

## Pattern Description
- **Pattern**: Prefix Sum
- **Type**: Rolling Sum Tracking
- **Recognition Clue**: Elements represent changes (gains), and we need the maximum altitude which is the maximum cumulative sum of gains starting from `0`.

---

## Approach

### 1. Brute Force
- Create a new array `altitudes` of size `n + 1` to explicitly store the altitude at each point.
- Set `altitudes[0] = 0`.
- Fill the array: `altitudes[i] = altitudes[i - 1] + gain[i - 1]`.
- Sort the `altitudes` array or run a separate pass to find the maximum element.
- **Time Complexity**: $O(n \log n)$ if sorted, or $O(n)$ if finding the max linearly.
- **Space Complexity**: $O(n)$ to store the altitudes array.

### 2. Optimized (Rolling Sum Tracking)
- Instead of keeping all altitudes in an array, track the current altitude and the maximum altitude reached so far using two variables.
- Update the variables during a single pass over the `gain` array.
- **Time Complexity**: $O(n)$
- **Space Complexity**: $O(1)$ auxiliary space.

---

## Complexity
- **Time Complexity**:
  - Brute Force: $O(n)$ or $O(n \log n)$
  - Optimized: $O(n)$
- **Space Complexity**:
  - Brute Force: $O(n)$
  - Optimized: $O(1)$ auxiliary space.

---

## Java Implementation

### Brute Force Solution
```java
import java.util.Arrays;

public class FindHighestAltitudeBrute {
    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};
        System.out.println(largestAltitude(gain)); // Output: 1
    }

    public static int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] altitudes = new int[n + 1];
        altitudes[0] = 0;

        for (int i = 1; i <= n; i++) {
            altitudes[i] = altitudes[i - 1] + gain[i - 1];
        }

        // Find the maximum value in altitudes array
        int maxAltitude = altitudes[0];
        for (int alt : altitudes) {
            maxAltitude = Math.max(maxAltitude, alt);
        }

        return maxAltitude;
    }
}
```

### Optimized Solution (Rolling Sum)
```java
public class FindHighestAltitude {
    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};
        System.out.println(largestAltitude(gain)); // Output: 1
    }

    public static int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int currentAltitude = 0;

        for (int g : gain) {
            currentAltitude += g;
            if (currentAltitude > maxAltitude) {
                maxAltitude = currentAltitude;
            }
        }

        return maxAltitude;
    }
}
```
