package questions.leetcode.editor.en;

//Given a string containing digits from 2-9 inclusive, return all possible 
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digits to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
// 
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
//
// Related Topics Hash Table String Backtracking 👍 13376 👎 780


//Given a string containing digits from 2-9 inclusive, return all possible 
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digits to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
// 
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
//
// Related Topics Hash Table String Backtracking 👍 13376 👎 780


import java.util.*;

public class Q17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new Q17LetterCombinationsOfAPhoneNumber().new Solution();
        char[] c = new char[]{'1'};
        System.out.println(String.copyValueOf(c));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Character, char[]> pad = new HashMap<>();

        private void inner(List<String> list, char[] digits, int index, char[] buffer) {
            if(index == digits.length){
                list.add(String.copyValueOf(buffer));
                return;
            }
            char[] chars = pad.get(digits[index]);
            for (char aChar : chars) {
                buffer[index] = aChar;

                inner(list, digits, index + 1, buffer);
            }
        }

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits.isEmpty()) return res;
            char[] buffer = new char[digits.length()];

            pad.put('2', new char[]{'a', 'b', 'c'});
            pad.put('3', new char[]{'d', 'e', 'f'});
            pad.put('4', new char[]{'g', 'h', 'i'});
            pad.put('5', new char[]{'j', 'k', 'l'});
            pad.put('6', new char[]{'m', 'n', 'o'});
            pad.put('7', new char[]{'p', 'q', 'r', 's'});
            pad.put('8', new char[]{'t', 'u', 'v'});
            pad.put('9', new char[]{'x', 'y', 'z', 'w'});

            inner(res, digits.toCharArray(), 0, buffer);

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}