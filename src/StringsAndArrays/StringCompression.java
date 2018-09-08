package StringsAndArrays;

// Compress a string by adding counts of repeated characters after the character. For example, aaaaabbccaabbb becomes a5b2c2a2b3


public class StringCompression {
    public static void main(String[] args) {
        testCompressString("aabcccccaaa");
        testCompressString("aabbbbbcccaab");
    }

    public static void testCompressString(String str) {
        System.out.println(str + " -> " + compressString(str));
    }

    public static String compressString(String str) {
        StringBuilder sb = new StringBuilder();

        int inARow = 1;
        char letter;

        for (int i = 0; i < str.length() - 1; i++) {
            letter = str.charAt(i);

            if (i == str.length() - 2) {
                if (letter == str.charAt(i + 1)) {
                    inARow++;
                    sb.append(letter + Integer.toString(inARow));
                }
                else {
                    sb.append(letter + Integer.toString(inARow));
                    sb.append(str.charAt(i + 1) + "1");
                }

                break;
            }

            if (letter == str.charAt(i + 1)) {
                inARow++;
            }
            else {
                sb.append(letter + Integer.toString(inARow));
                inARow = 1;
            }
        }

        String newString = sb.toString();

        return newString.length() < str.length() ? newString : str;
    }
}
