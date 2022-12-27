package questions.leetcode.editor.en;

//Write a function to find the longest common prefix string amongst an array of 
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// 
// Example 1: 
//
// 
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] consists of only lowercase English letters. 
// 
//
// Related Topics String 👍 11192 👎 3512


//Write a function to find the longest common prefix string amongst an array of 
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// 
// Example 1: 
//
// 
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] consists of only lowercase English letters. 
// 
//
// Related Topics String 👍 11192 👎 3512

  
public class Q14LongestCommonPrefix{
  public static void main(String[] args) {
       Solution solution = new Q14LongestCommonPrefix().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        int max = res.length();

        for (int i = 1; i < strs.length; i ++){
            String cur = strs[i];
            max = Math.min(max, cur.length());

            for (int j = 0; j < max; j ++){
                if(cur.charAt(j) != res.charAt(j)) {
                    max = j;
                }
            }
        }

        return res.substring(0, max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}