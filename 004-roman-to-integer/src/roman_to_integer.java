public class roman_to_integer {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
    }

    public static int romanToInt(String s) {
        int sum = 0;
        char currentChar, nextChar;
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            nextChar = (i < s.length() - 1) ? s.charAt(i+1) : ' ';
            switch (currentChar) {
                case 'I':
                    if (nextChar == 'X') {
                        i++;
                        sum += 9;
                    }
                    else if (nextChar == 'V') {
                        i++;
                        sum += 4;
                    }
                    else {
                        sum += 1;
                    }
                    break;
                case 'X':
                    if (nextChar == 'L') {
                        i++;
                        sum += 40;
                    }
                    else if (nextChar == 'C') {
                        i++;
                        sum += 90;
                    }
                    else {
                        sum += 10;
                    }
                    break;
                case 'C':
                    if (nextChar == 'D') {
                        i++;
                        sum += 400;
                    }
                    else if (nextChar == 'M') {
                        i++;
                        sum += 900;
                    }
                    else {
                        sum += 100;
                    }
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
