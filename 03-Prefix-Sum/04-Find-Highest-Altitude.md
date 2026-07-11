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
1. Initialize `maxAltitude = 0` and `currentAltitude = 0`.
2. Iterate through each gain in the `gain` array:
   - Update `currentAltitude += gain`.
   - Update `maxAltitude = Math.max(maxAltitude, currentAltitude)`.
3. Return `maxAltitude`.

---

## Complexity
- **Time Complexity**: $O(n)$ where $n$ is the length of `gain` array. We iterate through it once.
- **Space Complexity**: $O(1)$ auxiliary space as we only store `currentAltitude` and `maxAltitude`.

---

## Java Implementation

```java
public class FindHighestAltitude {
    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};

        int highest = largestAltitude(gain);

        System.out.println(highest); // Output: 1
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
