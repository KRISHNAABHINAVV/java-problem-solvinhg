class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            long spell = spells[i];

            // Minimum potion required to make product >= success
            long minPotion = (success + spell - 1) / spell;  // ceiling division

            // Find first potion >= minPotion
            int idx = lowerBound(potions, minPotion);

            // Number of successful pairs
            res[i] = m - idx;
        }

        return res;
    }

    // Custom binary search (similar to bisect_left in Python)
    private int lowerBound(int[] arr, long target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
