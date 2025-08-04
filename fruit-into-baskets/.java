import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        // HashMap to store fruit type and its count in the current window
        Map<Integer, Integer> basket = new HashMap<>();
        
        int left = 0;               // Left pointer of the sliding window
        int maxFruits = 0;         // To store the maximum number of fruits collected

        // Traverse the array with the right pointer
        for (int right = 0; right < fruits.length; right++) {
            int currentFruit = fruits[right];

            // Add current fruit to the map or increment its count
            basket.put(currentFruit, basket.getOrDefault(currentFruit, 0) + 1);

            // If we have more than 2 types of fruits in the basket, shrink the window
            while (basket.size() > 2) {
                int leftFruit = fruits[left];
                basket.put(leftFruit, basket.get(leftFruit) - 1); // Decrease count

                // If count becomes 0, remove the fruit type from map
                if (basket.get(leftFruit) == 0) {
                    basket.remove(leftFruit);
                }

                // Move the left pointer forward
                left++;
            }

            // Update the max fruits collected
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}
