package questions.leetcode.editor.en;

//You are given a string s. We want to partition the string into as many parts 
//as possible so that each letter appears in at most one part. 
//
// Note that the partition is done so that after concatenating all the parts in 
//order, the resultant string should be s. 
//
// Return a list of integers representing the size of these parts. 
//
// 
// Example 1: 
//
// 
//Input: s = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it 
//splits s into less parts.
// 
//
// Example 2: 
//
// 
//Input: s = "eccbbbbdec"
//Output: [10]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 500 
// s consists of lowercase English letters. 
// 
//
// Related Topics Hash Table Two Pointers String Greedy 👍 9134 👎 342


//You are given a string s. We want to partition the string into as many parts 
//as possible so that each letter appears in at most one part. 
//
// Note that the partition is done so that after concatenating all the parts in 
//order, the resultant string should be s. 
//
// Return a list of integers representing the size of these parts. 
//
// 
// Example 1: 
//
// 
//Input: s = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it 
//splits s into less parts.
// 
//
// Example 2: 
//
// 
//Input: s = "eccbbbbdec"
//Output: [10]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 500 
// s consists of lowercase English letters. 
// 
//
// Related Topics Hash Table Two Pointers String Greedy 👍 9134 👎 342


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Q763PartitionLabels {
    public static void main(String[] args) {
        Solution solution = new Q763PartitionLabels().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> partitionLabels(String s) {
            List<Integer> res = new ArrayList<>();
            char[] chars = s.toCharArray();

            int[] map = new int[26];

            for (int i = 0; i < chars.length; i++) {
                map[chars[i] - 'a'] = i;
            }

            int count = 0;
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < chars.length; i++) {
                set.add(chars[i]);
                count++;
                if (map[chars[i] - 'a'] == i) set.remove(chars[i]);
                if (set.size() == 0) {
                    res.add(count);
                    count = 0;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}