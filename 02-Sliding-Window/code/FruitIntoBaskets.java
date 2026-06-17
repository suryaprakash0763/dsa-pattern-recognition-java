import java.util.HashMap;

public class FruitIntoBaskets {
    public static void main(String[] args) {

        int[] fruits = {1, 2, 1, 2, 3};

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < fruits.length; right++) {

            // Add current fruit to the window
            int currentFruit = fruits[right];

            map.put(
                currentFruit,
                map.getOrDefault(currentFruit, 0) + 1
            );

            // If more than 2 distinct types, shrink from left
            while (map.size() > 2) {

                int leftFruit = fruits[left];

                // Reduce frequency of the leaving fruit
                map.put(
                    leftFruit,
                    map.get(leftFruit) - 1
                );

                // If frequency becomes 0, remove from map
                if (map.get(leftFruit) == 0) {
                    map.remove(leftFruit);
                }

                left++;
            }

            // Current valid window length
            int currentLength = right - left + 1;

            // Store maximum length
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        System.out.println(maxLength);
    }
}
