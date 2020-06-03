class Solution {
    public int myAtoi(String str) {
        int solution = 0;
        int pop = 0;
        boolean isNegative = false, seenPlusMinus = false, numberStarted = false;
        
        for (char c : str.toCharArray()) {
            // in case of + or - characters
            if (c == '-') {
                if (seenPlusMinus || numberStarted) break;
                else {
                    isNegative = true;
                    numberStarted = true;
                    seenPlusMinus = true;
                }
            }
            else if (c == '+') {
                if (seenPlusMinus || numberStarted) break;
                else{
                    isNegative = false;
                    numberStarted = true;
                    seenPlusMinus = true;
                }
                
            }
            // If its a number digit
            else if ((int) c >= 48 && (int) c <= 57) {
                pop = (int) c - 48;
                numberStarted = true;
                // negative overflow
                if (isNegative && ((solution * -1 < Integer.MIN_VALUE / 10) || solution * -1 == Integer.MIN_VALUE / 10 && pop > 8)) {
                    solution = Integer.MIN_VALUE;
                    break;
                }
                // positive overflow
                if (!isNegative && ((solution > Integer.MAX_VALUE / 10) || solution == Integer.MAX_VALUE / 10 && pop > 7)) {
                    solution = Integer.MAX_VALUE;
                    break;
                }

                solution = solution * 10 + pop;
            }
            // if no digit and no whitespace character then break
            else if (!((int) c >= 48 && (int) c <= 57) && (int) c != 32) break;
            // if digits are followed by whitespace characters break
            else if (c == ' ' && numberStarted) break;
        }
        // if the solution is supposed to be negative and its value is not multiply it by -1
        if (isNegative && solution > 0) solution *= -1;
        
        return solution;
    }
}