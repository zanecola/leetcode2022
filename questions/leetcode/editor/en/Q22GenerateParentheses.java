package questions.leetcode.editor.en;

//Given n pairs of parentheses, write a function to generate all combinations 
//of well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// 
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics String Dynamic Programming Backtracking 👍 16341 👎 634


//Given n pairs of parentheses, write a function to generate all combinations 
//of well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// 
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics String Dynamic Programming Backtracking 👍 16341 👎 634


import java.util.LinkedList;
import java.util.List;

public class Q22GenerateParentheses{
  public static void main(String[] args) {
       Solution solution = new Q22GenerateParentheses().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      List<String> res = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        inner(n, n, "");

        return res;
    }

    private void inner(int l, int r, String buf){
        if (l == 0 && r == 0){
            res.add(buf);
            return;
        }
        if (l == r){
            inner(l - 1, r, buf + "(");
            return;
        }
        if (l < r && l > 0){
            inner(l - 1, r, buf + "(");
            inner(l, r - 1, buf+")");
            return;
        }
        if(l == 0){
            inner(0, r - 1, buf+")");
            return;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}