package questions.leetcode.editor.en;

//Given two strings s and t of lengths m and n respectively, return the minimum 
//window substring of s such that every character in t (including duplicates) is 
//included in the window. If there is no such substring, return the empty string 
//"". 
//
// The testcases will be generated such that the answer is unique. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' 
//from string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
// Follow up: Could you find an algorithm that runs in O(m + n) time? 
//
// Related Topics Hash Table String Sliding Window 👍 14041 👎 609


//Given two strings s and t of lengths m and n respectively, return the minimum 
//window substring of s such that every character in t (including duplicates) is 
//included in the window. If there is no such substring, return the empty string 
//"". 
//
// The testcases will be generated such that the answer is unique. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' 
//from string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
// Follow up: Could you find an algorithm that runs in O(m + n) time? 
//
// Related Topics Hash Table String Sliding Window 👍 14041 👎 609


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Q76MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new Q76MinimumWindowSubstring().new Solution();
        solution.minWindow("aa", "aa");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int[] tChars = new int[97]; // 记载t中每个字母的数量
            int[] windowChars = new int[97]; // 记载滑动窗口中有效字母的个数

            for (char c : t.toCharArray()) {
                tChars[c - 'A']++;
            }

            int counter = t.length(); // 记载是否当前窗口已达成覆盖，为0时满足覆盖

            char[] chars = s.toCharArray();

            int minL = 0, minR = 0, l = 0, r = 0;

            int min = Integer.MAX_VALUE;

            while (r < s.length()) {
                if (tChars[chars[r] - 'A'] > 0) { // 如果当前字母是t中出现的
                    windowChars[chars[r] - 'A']++; // 记下来

                    if (counter != 0) { // 如果还没达成覆盖
                        if (windowChars[chars[r] - 'A'] <= tChars[chars[r] - 'A']) counter--; // 如果当前字母不是多余的，说吗我们多覆盖了一个
                    }

                    // 开始调整左边，如果最左边的字母是多余的或者没在t中的，缩左边，并且从windowChars减去多余的
                    while (windowChars[chars[l] - 'A'] > tChars[chars[l] - 'A'] || tChars[chars[l] - 'A'] == 0) {
                        if (windowChars[chars[l] - 'A'] > tChars[chars[l] - 'A']) windowChars[chars[l] - 'A']--;
                        l++;
                    }
                }

                // 判定是否最小
                if (counter == 0 && r - l + 1 < min) {
                    min = r - l + 1;
                    minL = l;
                    minR = r;
                }

                r++; // 右边窗口扩大一次
            }

            if (counter == 0) return s.substring(minL, minR + 1);
            else return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}