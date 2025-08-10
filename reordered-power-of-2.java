import java.util.*;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        // Convert n's digits to a sorted string representation
        String sortedN = sortDigits(n);
        
        // Precompute all powers of two up to 10^9
        for (int i = 0; i < 31; i++) { // 2^30 is just above 1e9
            int power = 1 << i; // compute 2^i
            // Compare sorted digits of power of two with sortedN
            if (sortedN.equals(sortDigits(power))) {
                return true;
            }
        }
        return false; // No match found
    }
    
    // Helper method to sort digits of a number and return as string
    private String sortDigits(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        Arrays.sort(chars); // sort digits lexicographically
        return new String(chars);
    }
}
