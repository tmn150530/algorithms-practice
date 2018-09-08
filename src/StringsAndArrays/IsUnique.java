package StringsAndArrays;

// Check to see if a string has all unique characters

import java.util.BitSet;
import java.util.HashMap;

public class IsUnique {
    public static void main(String[] args) {
        testString("Nguyen");
        testString("Tam Nguyen");
        testString("Python would make these problems much easier");
    }

    // Checks using a hashmap. O(n) time complexity
    public static boolean isUnique(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        char letter;

        for (int i = 0; i < s.length(); i++) {
            letter = s.charAt(i);

            if (map.containsValue(letter)) {
                return false;
            }

            map.put(letter, letter);
        }

        return true;
    }

    // Checks using BitSet. O(n) time complexity and constant space complexity (32 bytes)
    public static boolean isUniqueBitSet(String s) {
        final int MAX_CHARS = 256;

        if (s.length() > MAX_CHARS) {   // Pigeonhole principle - if more characters than max, then there are repeats
            return false;
        }

        BitSet checker = new BitSet(MAX_CHARS);
        char charVal;

        for (int i = 0; i < s.length(); i++) {
            charVal = s.charAt(i);

            if (checker.get(charVal)) {
                return false;
            }

            checker.set(charVal);
        }

        return true;
    }

    public static void testString(String s) {
        System.out.println("\"" + s + "\"" + " has all unique characters: " + isUniqueBitSet(s));

    }
}
