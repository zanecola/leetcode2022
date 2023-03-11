package questions.leetcode.editor.en;

//Given a string s and a dictionary of strings wordDict, add spaces in s to 
//construct a sentence where each word is a valid dictionary word. Return all such 
//possible sentences in any order. 
//
// Note that the same word in the dictionary may be reused multiple times in 
//the segmentation. 
//
// 
// Example 1: 
//
// 
//Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
//Output: ["cats and dog","cat sand dog"]
// 
//
// Example 2: 
//
// 
//Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine",
//"pineapple"]
//Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
//Explanation: Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 20 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 10 
// s and wordDict[i] consist of only lowercase English letters. 
// All the strings of wordDict are unique. 
// 
//
// Related Topics Array Hash Table String Dynamic Programming Backtracking Trie 
//Memoization 👍 5888 👎 500


//Given a string s and a dictionary of strings wordDict, add spaces in s to 
//construct a sentence where each word is a valid dictionary word. Return all such 
//possible sentences in any order. 
//
// Note that the same word in the dictionary may be reused multiple times in 
//the segmentation. 
//
// 
// Example 1: 
//
// 
//Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
//Output: ["cats and dog","cat sand dog"]
// 
//
// Example 2: 
//
// 
//Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine",
//"pineapple"]
//Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
//Explanation: Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 20 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 10 
// s and wordDict[i] consist of only lowercase English letters. 
// All the strings of wordDict are unique. 
// 
//
// Related Topics Array Hash Table String Dynamic Programming Backtracking Trie 
//Memoization 👍 5888 👎 500


import java.util.*;
import java.util.stream.Collectors;

public class Q140WordBreakIi {
    public static void main(String[] args) {
        Solution solution = new Q140WordBreakIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<Integer> lens = new HashSet<>();
            Set<String> dics = new HashSet<>();
            for (String w : wordDict) {
                lens.add(w.length());
                dics.add(w);
            }

            Map<Integer, List<List<String>>> map = new HashMap<>();

            for (int i = 0; i <= s.length(); i++) {
                for (int len : lens) {
                    if (len <= i) {
                        String sub = s.substring(i - len, i);
                        if (dics.contains(sub)) {
                            if (i - len == 0) {
                                map.computeIfAbsent(i - 1, (a) -> new LinkedList<>()).add(new LinkedList<>(List.of(sub)));
                            } else {
                                if (map.containsKey(i - len - 1)) {
                                    List<List<String>> pres = map.get(i - len - 1);
                                    for (List<String> p : pres) {
                                        var cur = new LinkedList<>(p);
                                        cur.add(sub);
                                        map.computeIfAbsent(i - 1, (a) -> new LinkedList<>()).add(cur);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (map.containsKey(s.length() - 1)) {
                return map.get(s.length() - 1).stream().map(list -> String.join(" ", list)).collect(Collectors.toList());
            }

            return new LinkedList<>();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}