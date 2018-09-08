package StringsAndArrays;

// Checks if two strings are one (or zero) edits away. An edit is a letter removal, letter insertion, or a letter replacement

public class OneAway {
    public static void main(String[] args) {
        testIsOneAway("pale", "ple");
        testIsOneAway("pales", "pale");
        testIsOneAway("pale", "bale");
        testIsOneAway("pale", "bae");
    }

    public static void testIsOneAway(String str1, String str2) {
        System.out.printf("\"%s\", \"%s\" -> %b\n",str1,str2,isOneAway(str1,str2));
    }

    public static boolean isOneAway(String str1, String str2) {
        int lengthDif = str1.length() - str2.length();

        if (Math.abs(lengthDif) > 1) {
            return false;
        }

        // Makes sure that the str1 is the longest string if they're different
        if (lengthDif < 0) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        int numDifferences = 0;

        if (lengthDif != 0) {
            for (int i = 0, j = 0; i < str1.length() && j < str2.length(); i++, j++) {
                if (str1.charAt(i) != str2.charAt(j)) {
                    numDifferences++;
                    i++;
                    if (numDifferences > 1) {
                        return false;
                    }
                }
            }
        }
        else {
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    numDifferences++;

                    if (numDifferences > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
