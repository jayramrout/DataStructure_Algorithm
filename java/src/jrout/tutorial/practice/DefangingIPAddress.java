package jrout.tutorial.practice;

/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 *
 * A defanged IP address replaces every period "." with "[.]".
 *
 * Example 1:
 *
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 */
public class DefangingIPAddress {
    public static void main(String[] args) {
        String ip4V = "10.3.44.55";
        String replace = ip4V.replace(".", "[.]");
        System.out.println(replace);
    }
}
