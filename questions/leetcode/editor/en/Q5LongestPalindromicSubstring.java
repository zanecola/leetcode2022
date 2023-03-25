package questions.leetcode.editor.en;

//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
//
// Related Topics String Dynamic Programming 👍 24422 👎 1429


//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
//
// Related Topics String Dynamic Programming 👍 24422 👎 1429


public class Q5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new Q5LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String res = "";

            for (int i = 0; i < s.length(); i++) {
                String s1 = find(s, i, i);
                if (s1.length() > res.length()) {
                    res = s1;
                }

                String s2 = find(s, i-1, i);
                if (s2.length() > res.length()) {
                    res = s2;
                }
            }

            return res;
        }

        String find(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            return s.substring(l + 1, r);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}