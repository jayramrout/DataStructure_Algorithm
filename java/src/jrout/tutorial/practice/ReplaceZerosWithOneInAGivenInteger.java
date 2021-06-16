package jrout.tutorial.practice;

/**
 *
 */
public class ReplaceZerosWithOneInAGivenInteger {
    public static void main(String[] args) {
        int value = 80150;
        int replaceValue = replace(value);
        System.out.println("Replaced value "+ replaceValue);
    }

    public static int replace(int value) {
        if (value == 0) {
            return 1;
        }
        int digit = value % 10;
        if (digit == 0) {
            digit = 1;
        }
        if (String.valueOf(value).trim().length() == 1) {
            return value;
        }
        return replace(value / 10) * 10 + digit;
    }
}
