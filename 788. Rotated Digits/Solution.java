class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isGood(n)) {
                count++;
            }
        }
        return count;
    }

    boolean isGood(int n) {
        int cur = n;
        boolean isValid = false;
        while (n > 0) {
            int rem = n % 10;
            if (rem == 3 || rem == 4 || rem == 7) {
                return false;
            }
            if (rem == 2 || rem == 5 || rem == 6 || rem == 9) {
                isValid = true;
            }
            n = n / 10;
        }
        return isValid;
    }
}