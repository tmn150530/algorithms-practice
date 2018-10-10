package DynamicProgramming;

import java.util.*;

// applepenapple
// app,apple,pen

public class WordBreak {

        public static void main(String[] args) {
            System.out.println(wordBreak("aaaaaaa", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa")));
        }

        public static boolean wordBreak(String s, List<String> wordDict) {
            return word_Break(s, new HashSet(wordDict), 0);
        }

        public static boolean word_Break(String s, Set<String> wordDict, int start) {
            if (start == s.length()) {
                return true;
            }
            for (int end = start + 1; end <= s.length(); end++) {
                String substring = s.substring(start,end);
                if (wordDict.contains(substring) && word_Break(s, wordDict, end)) {
                    return true;
                }
            }
            return false;
        }
    }

