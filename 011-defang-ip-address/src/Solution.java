import jdk.nashorn.api.tree.RegExpLiteralTree;
/*
Given a valid (IPv4) IP address, return a defanged version of that IP address.
A defanged IP address replaces every period "." with "[.]".

Example 1:
Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"

Example 2:
Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"
 */

class Solution {
    /** StringBuilder solution
     * (fastest because using String concatenation is translated into StringBuilder operations by the compiler)*/
    public String defangIPaddr(String address) {
        StringBuilder defangIpAddress = new StringBuilder();

        for (int i = 0; i < address.length(); i++) {
            char current = address.charAt(i);

            if (current == '.') {
                defangIpAddress.append("[.]");
            } else {
                defangIpAddress.append(current);
            }
        }

        return defangIpAddress.toString();
    }

    /** Iterative solution (medium speed)  */
    public String defangIPaddrIterative(String address) {
        String result = "";
        for (int i = 0; i < address.length(); i++) {
            result += (address.charAt(i) == '.') ? "[.]" : address.charAt(i);
        }
        return result;
    }

    /** Regex solution (slowest) */
    public String defangIPaddrRegex(String address) {
        return address.replaceAll(".", "[.]");
    }
}

/*
String concatenation:
Original class:

public void method1() {
    System.out.println("The answer is: " + 42);
}

public void method2(int value) {
    System.out.println("The answer is: " + value);
}

public void method3(int value) {
    String a = "The answer is: " + value;
    System.out.println(a + " what is the question ?");
}
____________________________________________
The decompiled class with jad:
public void method1()
{
    System.out.println("The answer is: 42");
}

public void method2(int value)
{
    System.out.println((new StringBuilder("The answer is: ")).append(value).toString());
}

public void method3(int value)
{
    String a = (new StringBuilder("The answer is: ")).append(value).toString();
    System.out.println((new StringBuilder(String.valueOf(a))).append(" what is the question ?").toString());
}
 */