class Solution {
    public boolean isPowerOfTwo(int n) {
        // A number must be positive to be a power of two
        if (n <= 0) {
            return false;
        }

        // Bit manipulation check:
        // For a power of two, only one bit is set in binary representation
        // Example: 4 (100) & (3) (011) = 0
        return (n & (n - 1)) == 0;
    }
}
