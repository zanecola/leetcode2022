package questions.leetcode.editor.en;

//Given a string containing just the characters '(' and ')', return the length 
//of the longest valid (well-formed) parentheses substring. 
//
// 
// Example 1: 
//
// 
//Input: s = "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()".
// 
//
// Example 2: 
//
// 
//Input: s = ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()".
// 
//
// Example 3: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] is '(', or ')'. 
// 
//
// Related Topics String Dynamic Programming Stack 👍 10243 👎 325


//Given a string containing just the characters '(' and ')', return the length 
//of the longest valid (well-formed) parentheses substring. 
//
// 
// Example 1: 
//
// 
//Input: s = "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()".
// 
//
// Example 2: 
//
// 
//Input: s = ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()".
// 
//
// Example 3: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] is '(', or ')'. 
// 
//
// Related Topics String Dynamic Programming Stack 👍 10243 👎 325

  
public class Q32LongestValidParentheses{
  public static void main(String[] args) {
       Solution solution = new Q32LongestValidParentheses().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();

        int l = 0, r = 0, res = 0;

        for (int i = 0; i < chars.length; i ++){
            if (chars[i] == '('){
                l ++;
            } else {
                r ++;
                if (r == l){
                    res = Math.max(2 * r, res);
                } else if (r < l){
                } else {
                    r = 0;
                    l = 0;
                }
            }
        }

        l = 0;
        r = 0;

        for (int i = chars.length - 1; i>= 0; i --){
            if (chars[i] == ')'){
                l ++;
            } else {
                r ++;
                if (r == l){
                    res = Math.max(2 * r, res);
                } else if (r < l){
                } else {
                    r = 0;
                    l = 0;
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}