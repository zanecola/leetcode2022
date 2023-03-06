package questions.leetcode.editor.en;

//The count-and-say sequence is a sequence of digit strings defined by the 
//recursive formula: 
//
// 
// countAndSay(1) = "1" 
// countAndSay(n) is the way you would "say" the digit string from countAndSay(
//n-1), which is then converted into a different digit string. 
// 
//
// To determine how you "say" a digit string, split it into the minimal number 
//of substrings such that each substring contains exactly one unique digit. Then 
//for each substring, say the number of digits, then say the digit. Finally, 
//concatenate every said digit. 
//
// For example, the saying and conversion for digit string "3322251": 
// 
// Given a positive integer n, return the nᵗʰ term of the count-and-say 
//sequence. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: "1"
//Explanation: This is the base case.
// 
//
// Example 2: 
//
// 
//Input: n = 4
//Output: "1211"
//Explanation:
//countAndSay(1) = "1"
//countAndSay(2) = say "1" = one 1 = "11"
//countAndSay(3) = say "11" = two 1's = "21"
//countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 30 
// 
//
// Related Topics String 👍 2991 👎 6300


//The count-and-say sequence is a sequence of digit strings defined by the 
//recursive formula: 
//
// 
// countAndSay(1) = "1" 
// countAndSay(n) is the way you would "say" the digit string from countAndSay(
//n-1), which is then converted into a different digit string. 
// 
//
// To determine how you "say" a digit string, split it into the minimal number 
//of substrings such that each substring contains exactly one unique digit. Then 
//for each substring, say the number of digits, then say the digit. Finally, 
//concatenate every said digit. 
//
// For example, the saying and conversion for digit string "3322251": 
// 
// Given a positive integer n, return the nᵗʰ term of the count-and-say 
//sequence. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: "1"
//Explanation: This is the base case.
// 
//
// Example 2: 
//
// 
//Input: n = 4
//Output: "1211"
//Explanation:
//countAndSay(1) = "1"
//countAndSay(2) = say "1" = one 1 = "11"
//countAndSay(3) = say "11" = two 1's = "21"
//countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 30 
// 
//
// Related Topics String 👍 2991 👎 6300


public class Q38CountAndSay {
    public static void main(String[] args) {
        Solution solution = new Q38CountAndSay().new Solution();
        solution.countAndSay(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String countAndSay(int n) {
            if (n == 1) return "1";

            String prev = countAndSay(n - 1);
            char[] chars = prev.toCharArray();

            int i = 0;
            StringBuilder sb = new StringBuilder();
            while (i < chars.length) {
                int count = 1;
                while (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                    count++;
                    i++;
                }
                sb.append(count);
                sb.append(chars[i]);

                i++;
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}