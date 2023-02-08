package questions.leetcode.editor.en;

//Given two strings s1 and s2, return true if s2 contains a permutation of s1, 
//or false otherwise. 
//
// In other words, return true if one of s1's permutations is the substring of 
//s2. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "ab", s2 = "eidbaooo"
//Output: true
//Explanation: s2 contains one permutation of s1 ("ba").
// 
//
// Example 2: 
//
// 
//Input: s1 = "ab", s2 = "eidboaoo"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 and s2 consist of lowercase English letters. 
// 
//
// Related Topics Hash Table Two Pointers String Sliding Window 👍 9230 👎 286


//Given two strings s1 and s2, return true if s2 contains a permutation of s1, 
//or false otherwise. 
//
// In other words, return true if one of s1's permutations is the substring of 
//s2. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "ab", s2 = "eidbaooo"
//Output: true
//Explanation: s2 contains one permutation of s1 ("ba").
// 
//
// Example 2: 
//
// 
//Input: s1 = "ab", s2 = "eidboaoo"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 and s2 consist of lowercase English letters. 
// 
//
// Related Topics Hash Table Two Pointers String Sliding Window 👍 9230 👎 286


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q567PermutationInString {
    public static void main(String[] args) {
        Solution solution = new Q567PermutationInString().new Solution();
        solution.checkInclusion("eidbaooo", "ab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s2, String s1) {
            if (s2.length() > s1.length()) return false;
            char[] c1 = s1.toCharArray();
            int[] map = new int[26];

            for (char c : s2.toCharArray()) {
                map[c - 'a']++;
            }

            for (int i = 0; i < s1.length() - s2.length() + 1; i++) {
                if (map[c1[i] - 'a'] > 0) {
                    int j = i;
                    int[] map1 = new int[26];
                    while (j < c1.length && map[c1[j] - 'a'] > 0) {
                        map1[c1[j] - 'a']++;
                        if (map1[c1[j] - 'a'] > map[c1[j] - 'a']) break;
                        if (j - i + 1 == s2.length()) return true;

                        j++;
                    }
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}