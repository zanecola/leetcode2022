package questions.leetcode.editor.en;

//Given two strings s and p, return an array of all the start indices of p's 
//anagrams in s. You may return the answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
//
// 
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
//
// Example 2: 
//
// 
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s and p consist of lowercase English letters. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 9576 👎 295


//Given two strings s and p, return an array of all the start indices of p's 
//anagrams in s. You may return the answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
//
// 
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
//
// Example 2: 
//
// 
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s and p consist of lowercase English letters. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 9576 👎 295


import java.util.ArrayList;
import java.util.List;

public class Q438FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new Q438FindAllAnagramsInAString().new Solution();
        solution.findAnagrams("cbaebabac", "abc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            char [] ss = s.toCharArray();
            int[] key = new int[26];
            for (char c : p.toCharArray()) {
                key[c - 'a']++;
            }

            int[] cur = new int[26];
            int size = 0;
            for (int i = 0; i < s.length(); i++) {
                cur[ss[i] - 'a']++;
                if (size < p.length()) {
                    size++;
                }

                if (size == p.length()) {
                    boolean same = true;
                    for (int j = 0; j < 26; j++) {
                        if (cur[j] != key[j]) same = false;
                    }

                    if (same) {
                        res.add(i - p.length() + 1);
                    }

                    cur[ss[i - p.length() + 1] - 'a']--;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}