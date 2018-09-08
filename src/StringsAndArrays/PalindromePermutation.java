package StringsAndArrays;

// Checks to see if a string is a permutation of a palindrome

import java.util.BitSet;
import java.util.HashMap;

public class PalindromePermutation {
    public static void main(String[] args) {
        testPalindromePermutation("tact coa");
        testPalindromePermutation("racecar");
        testPalindromePermutation("Tam Nguyen");
        testPalindromePermutation("bactybtca");
    }

    public static void testPalindromePermutation(String str) {
        System.out.printf("\"%s\" is a palindrome permutation: %b\n", str, isPalindromePermutationBits(str));
    }

    // Checks in O(n) space and time
    public static boolean isPalindromePermutation(String str) {
        HashMap<Character, Integer> map = new HashMap<>();  // Key is the letter, value is number of occurrences
        char letter;
        int numOfOddLetters = 0;    // Counts how many times there is an odd number of occurrences of a letter

        for (int i = 0; i < str.length(); i++) {
            letter = Character.toLowerCase(str.charAt(i));
            if (letter != ' ') {
                if (!map.containsKey(letter)) {
                    map.put(letter, 1);
                    numOfOddLetters++;
                }
                else {
                    if (map.get(letter) == 1) {
                        map.put(letter, 2);
                        numOfOddLetters--;
                    }
                    else if (map.get(letter) % 2 == 0) {
                        map.put(letter, map.get(letter) + 1);
                        numOfOddLetters++;
                    }
                    else {
                        map.put(letter, map.get(letter) + 1);
                        numOfOddLetters--;
                    }
                }
            }
        }

       return numOfOddLetters <= 1;
    }

    // Checks if string is palindrome permutation using a bit vector. Assumes only lowercase letters
    public static boolean isPalindromePermutationBits(String str) {
        int bitVector = createBitVector(str);

        return (bitVector == 0 || containsSingleOne(bitVector));
    }

    public static int createBitVector(String str) {
        int bitVector = 0;
        int letter;

        for (int i = 0; i < str.length(); i++) {
            letter = str.charAt(i);
            if (letter != ' ') {
                bitVector = flipBit(bitVector, letter);
            }
        }

        return bitVector;
    }

    public static int flipBit(int bitVector, int letter) {
        int index = 'a' - letter;
        int mask = 1 << index;

        if ((mask & bitVector) == 0) {
            return bitVector | mask;
        }

        return bitVector ^ mask;
    }

    public static boolean containsSingleOne(int bitVector) {
        return (bitVector - 1 & bitVector) == 0;
    }
}
