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
        solution.checkInclusion("adc", "dadc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s2, String s1) {
            if (s2.length() > s1.length()) return false;
            char[] c1 = s1.toCharArray();
            int[] map = new int[26];
            int[] window = new int[26];

            for (char c : s2.toCharArray()) map[c - 'a']++;

            int r = 0, l = 0;
            while (r < s2.length()) window[c1[r++] - 'a']++;

            while (r < s1.length()) {
                if (Arrays.equals(window, map)) return true;
                window[c1[r++] - 'a']++;
                window[c1[l++] - 'a']--;
            }

            return Arrays.equals(window, map);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}