package questions.leetcode.editor.en;

//Given an encoded string, return its decoded string. 
//
// The encoding rule is: k[encoded_string], where the encoded_string inside the 
//square brackets is being repeated exactly k times. Note that k is guaranteed to 
//be a positive integer. 
//
// You may assume that the input string is always valid; there are no extra 
//white spaces, square brackets are well-formed, etc. Furthermore, you may assume 
//that the original data does not contain any digits and that digits are only for 
//those repeat numbers, k. For example, there will not be input like 3a or 2[4]. 
//
// The test cases are generated so that the length of the output will never 
//exceed 10⁵. 
//
// 
// Example 1: 
//
// 
//Input: s = "3[a]2[bc]"
//Output: "aaabcbc"
// 
//
// Example 2: 
//
// 
//Input: s = "3[a2[c]]"
//Output: "accaccacc"
// 
//
// Example 3: 
//
// 
//Input: s = "2[abc]3[cd]ef"
//Output: "abcabccdcdcdef"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 30 
// s consists of lowercase English letters, digits, and square brackets '[]'. 
// s is guaranteed to be a valid input. 
// All the integers in s are in the range [1, 300]. 
// 
//
// Related Topics String Stack Recursion 👍 10240 👎 456


//Given an encoded string, return its decoded string. 
//
// The encoding rule is: k[encoded_string], where the encoded_string inside the 
//square brackets is being repeated exactly k times. Note that k is guaranteed to 
//be a positive integer. 
//
// You may assume that the input string is always valid; there are no extra 
//white spaces, square brackets are well-formed, etc. Furthermore, you may assume 
//that the original data does not contain any digits and that digits are only for 
//those repeat numbers, k. For example, there will not be input like 3a or 2[4]. 
//
// The test cases are generated so that the length of the output will never 
//exceed 10⁵. 
//
// 
// Example 1: 
//
// 
//Input: s = "3[a]2[bc]"
//Output: "aaabcbc"
// 
//
// Example 2: 
//
// 
//Input: s = "3[a2[c]]"
//Output: "accaccacc"
// 
//
// Example 3: 
//
// 
//Input: s = "2[abc]3[cd]ef"
//Output: "abcabccdcdcdef"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 30 
// s consists of lowercase English letters, digits, and square brackets '[]'. 
// s is guaranteed to be a valid input. 
// All the integers in s are in the range [1, 300]. 
// 
//
// Related Topics String Stack Recursion 👍 10240 👎 456


import java.util.ArrayDeque;
import java.util.Deque;

public class Q394DecodeString {
    public static void main(String[] args) {
        Solution solution = new Q394DecodeString().new Solution();
        solution.decodeString("3[a2[c]]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            Deque<Integer> nums = new ArrayDeque<>();
            Deque<StringBuilder> strs = new ArrayDeque<>();

            StringBuilder numBuf = new StringBuilder();
            StringBuilder strBuf = new StringBuilder();

            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    numBuf.append(c);
                } else if (c == '[') {
                    nums.push(Integer.parseInt(numBuf.toString()));
                    numBuf = new StringBuilder();

                    strs.push(strBuf);
                    strBuf = new StringBuilder();
                } else if (c == ']') {
                    int num = nums.pop();

                    String ss = strBuf.toString().repeat(num);
                    
                    strBuf = strs.pop().append(ss);
                } else {
                    strBuf.append(c);
                }
            }

            return strBuf.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}