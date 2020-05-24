public class Solution {
    public int RomanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.Length; i++) {
            switch (s[i]) {
                case 'I':
                    if (i < s.Length - 1){
                        if (s[i+1] == 'X') {
                            i++;
                            sum += 9;
                        }
                        else if (s[i+1] == 'V') {
                            i++;
                            sum += 4;
                        }
                        else sum += 1;
                    }
                    else sum += 1;
                    break;
                case 'X':
                    if (i < s.Length -1){
                        if (s[i+1] == 'L') {
                            i++;
                            sum += 40;
                        }
                        else if (s[i+1] == 'C') {
                            i++;
                            sum += 90;
                        }
                        else sum += 10;
                    }
                    else sum += 10;
                    break;
                case 'C':
                    if (i < s.Length - 1) {
                        if (s[i+1] == 'D') {
                            i++;
                            sum += 400;
                        }
                        else if (s[i+1] == 'M') {
                            i++;
                            sum += 900;
                        }
                        else sum += 100;
                    }
                    else sum += 100;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
            }
        }

        return sum;
    }
}