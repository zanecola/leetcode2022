package questions.leetcode.editor.en;

//Given a string s representing a valid expression, implement a basic 
//calculator to evaluate it, and return the result of the evaluation. 
//
// Note: You are not allowed to use any built-in function which evaluates 
//strings as mathematical expressions, such as eval(). 
//
// 
// Example 1: 
//
// 
//Input: s = "1 + 1"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: s = " 2-1 + 2 "
//Output: 3
// 
//
// Example 3: 
//
// 
//Input: s = "(1+(4+5+2)-3)+(6+8)"
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s consists of digits, '+', '-', '(', ')', and ' '. 
// s represents a valid expression. 
// '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid). 
//
// '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid). 
//
// There will be no two consecutive operators in the input. 
// Every number and running calculation will fit in a signed 32-bit integer. 
// 
//
// Related Topics Math String Stack Recursion 👍 5260 👎 395


//Given a string s representing a valid expression, implement a basic 
//calculator to evaluate it, and return the result of the evaluation. 
//
// Note: You are not allowed to use any built-in function which evaluates 
//strings as mathematical expressions, such as eval(). 
//
// 
// Example 1: 
//
// 
//Input: s = "1 + 1"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: s = " 2-1 + 2 "
//Output: 3
// 
//
// Example 3: 
//
// 
//Input: s = "(1+(4+5+2)-3)+(6+8)"
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s consists of digits, '+', '-', '(', ')', and ' '. 
// s represents a valid expression. 
// '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid). 
//
// '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid). 
//
// There will be no two consecutive operators in the input. 
// Every number and running calculation will fit in a signed 32-bit integer. 
// 
//
// Related Topics Math String Stack Recursion 👍 5260 👎 395


import java.util.ArrayDeque;
import java.util.Deque;

public class Q224BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new Q224BasicCalculator().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(0);
            int sign = 1;
            int cur = 0;
            int sum = 0;
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    cur = cur * 10 + (c - '0');
                } else if (c == '-') {
//                    stack.push(cur * sign);
                    sum += cur * sign;
                    sign = -1;
                    cur = 0;
                } else if (c == '+') {
//                    stack.push(cur * sign);
                    sum += cur * sign;
                    sign = 1;
                    cur = 0;
                } else if (c == '(' || c == ')' || c == ' ') {
//                    stack.push(cur * sign);
                    sum += cur * sign;
                    sign = 1;
                    cur = 0;
                }
            }
            sum += cur * sign;

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}