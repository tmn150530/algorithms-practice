package StringsAndArrays;

// Given two strings, determine if one is a permutation of the other

import java.util.HashMap;

public class IsPermutation {
    public static void main(String[] args) {
        testPermutation("comet", "temoc");
        testPermutation("Tam", "Nguyen");
        testPermutation("devil", "lived");
        testPermutation("bottle", "telboo");
    }

    public static void testPermutation(String string1, String string2) {
        System.out.println("\"" + string1 + "\"" + " is a permutation of \"" +
                string2 + "\": " + isPermutation(string1, string2));
    }

    // Solution is O(n) time complexity
    public static boolean isPermutation(String string1, String string2) {
        // Micro-optimization
        if (string1.length() != string2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();  // Key is letter, value is number of occurrences
        int lettersUnmatched = 0;
        char letter;

        // Add all letters to a hashmap and count the number of unique letters in lettersUnmatched
        for (int i = 0; i < string1.length(); i++) {
            letter = string1.charAt(i);

            if (!map.containsKey(letter)) {
                map.put(letter, 1);
                lettersUnmatched++;
            }
            else {
                map.put(letter, map.get(letter) + 1);
            }

        }

        // Decrements value when letter is encountered. If 0, remove from hashmap and decrease lettersUnmatched
        for (int i = 0; i < string2.length(); i++) {
            letter = string2.charAt(i);

            if (!map.containsKey(letter)) {
                return false;   // Micro-optimization again. If the map doesn't contain this letter, it can't be a permutation
            }
            else {
                if (map.get(letter) == 1) {
                    map.remove(letter);
                    lettersUnmatched--;
                }
                else {
                    map.put(letter, map.get(letter) - 1);
                }
            }
        }

        if (lettersUnmatched == 0) {
            return true;
        }

        return false;
    }
}
