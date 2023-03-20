package questions.leetcode.editor.en;

//A transformation sequence from word beginWord to word endWord using a 
//dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
// 
//
// 
// Every adjacent pair of words differs by a single letter. 
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need 
//to be in wordList. 
// sk == endWord 
// 
//
// Given two words, beginWord and endWord, and a dictionary wordList, return 
//the number of words in the shortest transformation sequence from beginWord to 
//endWord, or 0 if no such sequence exists. 
//
// 
// Example 1: 
//
// 
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
//"lot","log","cog"]
//Output: 5
//Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -
//> "dog" -> cog", which is 5 words long.
// 
//
// Example 2: 
//
// 
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
//"lot","log"]
//Output: 0
//Explanation: The endWord "cog" is not in wordList, therefore there is no 
//valid transformation sequence.
// 
//
// 
// Constraints: 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord, endWord, and wordList[i] consist of lowercase English letters. 
// beginWord != endWord 
// All the words in wordList are unique. 
// 
//
// Related Topics Hash Table String Breadth-First Search 👍 10044 👎 1777


//A transformation sequence from word beginWord to word endWord using a 
//dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
// 
//
// 
// Every adjacent pair of words differs by a single letter. 
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need 
//to be in wordList. 
// sk == endWord 
// 
//
// Given two words, beginWord and endWord, and a dictionary wordList, return 
//the number of words in the shortest transformation sequence from beginWord to 
//endWord, or 0 if no such sequence exists. 
//
// 
// Example 1: 
//
// 
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
//"lot","log","cog"]
//Output: 5
//Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -
//> "dog" -> cog", which is 5 words long.
// 
//
// Example 2: 
//
// 
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
//"lot","log"]
//Output: 0
//Explanation: The endWord "cog" is not in wordList, therefore there is no 
//valid transformation sequence.
// 
//
// 
// Constraints: 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord, endWord, and wordList[i] consist of lowercase English letters. 
// beginWord != endWord 
// All the words in wordList are unique. 
// 
//
// Related Topics Hash Table String Breadth-First Search 👍 10044 👎 1777


import java.util.*;

public class Q127WordLadder {
    public static void main(String[] args) {
        Solution solution = new Q127WordLadder().new Solution();
        solution.ladderLength("a", "c", List.of("a", "b", "c"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            Set<String> wordSet = new HashSet<>(wordList);
            Set<String> visited = new HashSet<>();
            if (!wordSet.contains(endWord)) return 0;
            wordSet.remove(beginWord);
            LinkedList<String> queue = new LinkedList<>();
            queue.add(beginWord);
            int layer = 1;
            boolean found = false;
            while (!queue.isEmpty()) {
                int size = queue.size();
                Set<String> visitedThisRound = new HashSet<>();
                while (size-- > 0) {
                    String cur = queue.poll();
                    List<String> next = findNext(wordSet, cur, visited);
                    visitedThisRound.addAll(next);
                }
                layer++;
                if (visitedThisRound.contains(endWord)) {
                    found = true;
                    break;
                }
                queue.addAll(visitedThisRound);
                visited.addAll(visitedThisRound);
            }

            if (!found) return 0;
            return layer;
        }

        private List<String> findNext(Set<String> wordSet, String word, Set<String> visited) {
            List<String> res = new ArrayList<>();
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char old = chars[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    if (j == old) continue;
                    chars[i] = j;
                    String str = String.valueOf(chars);
                    if (wordSet.contains(str) && !visited.contains(str)) {
                        res.add(str);
                    }
                }
                chars[i] = old;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}