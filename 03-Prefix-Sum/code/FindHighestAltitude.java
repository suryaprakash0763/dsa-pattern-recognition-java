public class FindHighestAltitude {
    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};

        System.out.println("Brute Force Output: " + largestAltitudeBruteForce(gain));
        System.out.println("Optimized Output: " + largestAltitudeOptimized(gain));
    }

    // Brute Force: O(n) or O(n log n) Time, O(n) Space
    public static int largestAltitudeBruteForce(int[] gain) {
        int n = gain.length;
        int[] altitudes = new int[n + 1];
        altitudes[0] = 0;

        for (int i = 1; i <= n; i++) {
            altitudes[i] = altitudes[i - 1] + gain[i - 1];
        }

        int maxAltitude = altitudes[0];
        for (int alt : altitudes) {
            maxAltitude = Math.max(maxAltitude, alt);
        }

        return maxAltitude;
    }

    // Optimized: O(n) Time, O(1) Space
    public static int largestAltitudeOptimized(int[] gain) {
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
