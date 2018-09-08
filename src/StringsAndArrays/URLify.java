package StringsAndArrays;

// Replace spaces in a character array with '%20'. Constant space complexity.

public class URLify {
    public static void main(String[] args) {
        System.out.println(urilify("Mr John Smith          ".toCharArray(), 13));
        System.out.println(urilify("The quick brown fox jumped over the lazy dog                   ".toCharArray(), 44));
    }

    public static char[] urilify(char[] str, int trueSize) {
        int shiftSize = countSpaces(str, trueSize) * 2; // Must shift each char by twice the number of spaces

        for (int i = trueSize - 1; i > 0; i--) {
            if (str[i] != ' ') {
                // Shift letter down by shiftSize
                str[i + shiftSize] = str[i];
            }
            else {
                // Replace space with %20
                str[i + shiftSize] = '0';
                str[i + shiftSize - 1] = '2';
                str[i + shiftSize - 2] = '%';

                shiftSize = shiftSize - 2;
            }
        }

        return str;
    }

    public static int countSpaces(char[] str, int trueSize) {
        int spaceCount = 0;

        for (int i = 0; i < trueSize; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        return spaceCount;
    }
}
