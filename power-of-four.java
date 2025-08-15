class Solution {
    public boolean isPowerOfFour(int n) {
        // Check if n is positive
        // Check if n is a power of two: only one bit set
        // Check if that one bit is in the correct position for a power of four
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
