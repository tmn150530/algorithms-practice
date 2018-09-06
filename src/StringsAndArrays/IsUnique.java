package StringsAndArrays;

// Check to see if a string has all unique characters

import java.util.HashMap;

public class IsUnique {
    public static void main(String[] args) {
        testString("Nguyen");
        testString("Tam Nguyen");
        testString("Python would make these problems much easier");
    }

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

    public static void testString(String s) {
        System.out.println("\"" + s + "\"" + " has all unique characters: " + isUnique(s));

    }
}
