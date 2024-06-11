class Solution {
    public int divide(int dividend, int divisor) {
        // Edge case: Overflow when dividing Integer.MIN_VALUE by -1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign of quotient using XOR
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert both dividend and divisor to positive values using long to prevent overflow
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);
        int quotient = 0;

        // Keep subtracting the largest multiple of divisor
        while (longDividend >= longDivisor) {
            long tempDivisor = longDivisor, multiple = 1;

            // Double the divisor using bitwise shift until it exceeds the remaining dividend
            while ((tempDivisor << 1) <= longDividend) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Subtract the largest found divisor multiple
            longDividend -= tempDivisor;
            quotient += multiple;
        }

        return negative ? -quotient : quotient;
    }
}
