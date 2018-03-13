package CodeBase.CTCI.Ch01_Arrays_and_Strings;

import java.util.Arrays;

/**
 * <h1>Is Unique</h1>
 * <b>Problem:</b> Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 *
 * @author Atul Banwar
 * @version 1.0
 */
public class S01_IsUnique {
    /**
     * <b>Approach 01:</b> Using Data Structure & ASCII input string.
     * Description: This method check for the uniqueness of the characters present in the input string.
     * Assumption: ASCII input string.
     * For extended ASCII character-set, an array of size 256 can be used.
     * For UNICODE character-set, an array size needs to be increased further.
     * Logic: A boolean array of size 128 is used to maintain the uniqueness of each character.
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param str Input string
     * @return TRUE if all characters are unique otherwise FALSE.
     */
    private static boolean hasUniqueChars01(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] isCharEncountered = new boolean[128];
        int charASCIIValue;

        for (int i = 0; i < str.length(); i++) {
            charASCIIValue = str.charAt(i);
            if (isCharEncountered[charASCIIValue]) {
                return false;
            }

            isCharEncountered[charASCIIValue] = true;
        }

        return true;
    }

    /**
     * <b>Approach 02:</b> Using Data Structure & input string with only lowercase alphabets.
     * Description: This method check for the uniqueness of the characters present in the input string.
     * Assumption: Input string will have only lowercase alphabets.
     * Logic: Individual bits of an int variable are updated to maintain uniqueness of each character.
     * Time complexity: O(n)
     * Space complexity: Using single int to store unique character info as bits.
     *
     * @param str Input string
     * @return TRUE if all characters are unique otherwise FALSE.
     */
    private static boolean hasUniqueChars02(String str) {
        if (str.length() > 26) {
            return false;
        }

        int checker = 0;
        int charIndex;

        for (int i = 0; i < str.length(); i++) {
            charIndex = str.charAt(i) - 'a';
            if ((checker & (1 << charIndex)) > 0) {
                return false;
            }

            checker |= (1 << charIndex);
        }

        return true;
    }

    /**
     * <b>Approach 03:</b> Not using Data Structure, brute-force approach & ASCII input string.
     * Description: This method check for the uniqueness of the characters present in the input string.
     * Assumption: ASCII input string.
     * Logic: Each character is compared with all other characters in the string to check for it's uniqueness.
     * Time complexity: O(n^2)
     * Space complexity: O(c)
     *
     * @param str Input string
     * @return TRUE if all characters are unique otherwise FALSE.
     */
    private static boolean hasUniqueChars03(String str) {
        if (str.length() > 128) {
            return false;
        }

        char charVal;

        for (int i = 0; i < str.length() - 1; i++) {
            charVal = str.charAt(i);

            for (int j = i + 1; j < str.length(); j++) {
                if (charVal == str.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * <b>Approach 04:</b> Not using Data Structure, sorting characters then checking for uniqueness & ASCII input string.
     * Description: This method check for the uniqueness of the characters present in the input string.
     * Assumption: ASCII input string.
     * Logic: First all characters in the string are sorted, then in one iteration uniqueness of characters is checked.
     * Time complexity: O(nlogn) for sorting, O(n) for checking for uniqueness
     * Space complexity: O(n) - A character array is created from input string.
     * Also, different sorting algorithms may take different space in memory.
     *
     * @param str Input string
     * @return TRUE if all characters are unique otherwise FALSE.
     */
    private static boolean hasUniqueChars04(String str) {
        int strLen = str.length();
        if (strLen > 128) {
            return false;
        }

        if (strLen < 2) {
            return true;
        }

        char[] charStr = str.toCharArray();
        Arrays.sort(charStr);

        char lastChar = charStr[0];
        int i;

        for (i = 1; i < strLen; i++) {
            if (lastChar == charStr[i]) {
                return false;
            }

            lastChar = charStr[i];
        }

        return true;
    }

    public static void main(String args[]) {
        String[] wordsToTest = {"abc", "abb", "ab12", "abab", "cab"};
        boolean isUnique;

        System.out.println("Approach 01: Using Data Structure & ASCII input string.");
        for (String word: wordsToTest) {
            isUnique = hasUniqueChars01(word);
            System.out.printf("Word: %s \t| Is Unique: %b\n", word, isUnique);
        }

        System.out.println("\nApproach 02: Using Data Structure & input string with only lowercase alphabets.");
        for (String word: wordsToTest) {
            isUnique = hasUniqueChars02(word);
            System.out.printf("Word: %s \t| Is Unique: %b\n", word, isUnique);
        }

        System.out.println("\nApproach 03: Not using Data Structure, brute-force approach & ASCII input string.");
        for (String word: wordsToTest) {
            isUnique = hasUniqueChars03(word);
            System.out.printf("Word: %s \t| Is Unique: %b\n", word, isUnique);
        }

        System.out.println("\nApproach 04: Not using Data Structure, sorting characters then checking for uniqueness & ASCII input string.");
        for (String word: wordsToTest) {
            isUnique = hasUniqueChars04(word);
            System.out.printf("Word: %s \t| Is Unique: %b\n", word, isUnique);
        }
    }
}