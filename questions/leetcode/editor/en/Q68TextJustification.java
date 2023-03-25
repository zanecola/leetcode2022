package questions.leetcode.editor.en;

//Given an array of strings words and a width maxWidth, format the text such 
//that each line has exactly maxWidth characters and is fully (left and right) 
//justified. 
//
// You should pack your words in a greedy approach; that is, pack as many words 
//as you can in each line. Pad extra spaces ' ' when necessary so that each line 
//has exactly maxWidth characters. 
//
// Extra spaces between words should be distributed as evenly as possible. If 
//the number of spaces on a line does not divide evenly between words, the empty 
//slots on the left will be assigned more spaces than the slots on the right. 
//
// For the last line of text, it should be left-justified, and no extra space 
//is inserted between words. 
//
// Note: 
//
// 
// A word is defined as a character sequence consisting of non-space characters 
//only. 
// Each word's length is guaranteed to be greater than 0 and not exceed 
//maxWidth. 
// The input array words contains at least one word. 
// 
//
// 
// Example 1: 
//
// 
//Input: words = ["This", "is", "an", "example", "of", "text", "justification."]
//, maxWidth = 16
//Output:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//] 
//
// Example 2: 
//
// 
//Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 
//16
//Output:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//Explanation: Note that the last line is "shall be    " instead of "shall     
//be", because the last line must be left-justified instead of fully-justified.
//Note that the second line is also left-justified because it contains only one 
//word. 
//
// Example 3: 
//
// 
//Input: words = ["Science","is","what","we","understand","well","enough","to",
//"explain","to","a","computer.","Art","is","everything","else","we","do"], 
//maxWidth = 20
//Output:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//] 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 300 
// 1 <= words[i].length <= 20 
// words[i] consists of only English letters and symbols. 
// 1 <= maxWidth <= 100 
// words[i].length <= maxWidth 
// 
//
// Related Topics Array String Simulation 👍 2244 👎 3418


//Given an array of strings words and a width maxWidth, format the text such 
//that each line has exactly maxWidth characters and is fully (left and right) 
//justified. 
//
// You should pack your words in a greedy approach; that is, pack as many words 
//as you can in each line. Pad extra spaces ' ' when necessary so that each line 
//has exactly maxWidth characters. 
//
// Extra spaces between words should be distributed as evenly as possible. If 
//the number of spaces on a line does not divide evenly between words, the empty 
//slots on the left will be assigned more spaces than the slots on the right. 
//
// For the last line of text, it should be left-justified, and no extra space 
//is inserted between words. 
//
// Note: 
//
// 
// A word is defined as a character sequence consisting of non-space characters 
//only. 
// Each word's length is guaranteed to be greater than 0 and not exceed 
//maxWidth. 
// The input array words contains at least one word. 
// 
//
// 
// Example 1: 
//
// 
//Input: words = ["This", "is", "an", "example", "of", "text", "justification."]
//, maxWidth = 16
//Output:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//] 
//
// Example 2: 
//
// 
//Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 
//16
//Output:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//Explanation: Note that the last line is "shall be    " instead of "shall     
//be", because the last line must be left-justified instead of fully-justified.
//Note that the second line is also left-justified because it contains only one 
//word. 
//
// Example 3: 
//
// 
//Input: words = ["Science","is","what","we","understand","well","enough","to",
//"explain","to","a","computer.","Art","is","everything","else","we","do"], 
//maxWidth = 20
//Output:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//] 
//
// 
// Constraints: 
//
// 
// 1 <= words.length <= 300 
// 1 <= words[i].length <= 20 
// words[i] consists of only English letters and symbols. 
// 1 <= maxWidth <= 100 
// words[i].length <= maxWidth 
// 
//
// Related Topics Array String Simulation 👍 2244 👎 3418


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q68TextJustification {
    public static void main(String[] args) {
        Solution solution = new Q68TextJustification().new Solution();
        solution.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<List<String>> lines = new ArrayList<>();

            int curLen = 0;
            List<String> line = new ArrayList<>();
            for (String word : words) {
                if (word.length() + curLen > maxWidth) {
                    lines.add(line);
                    line = new ArrayList<>();
                    curLen = 0;
                }

                line.add(word);
                curLen += word.length() + 1;
            }

            List<String> res = lines.stream().map(s -> pad(s, maxWidth)).collect(Collectors.toList());
            String lastLine = String.join(" ", line);
            lastLine = lastLine + " ".repeat(maxWidth - lastLine.length());
            res.add(lastLine);
            return res;
        }

        private String pad(List<String> line, int maxWidth) {
            int total = line.stream().map(String::length).reduce(0, Integer::sum);
            int gap = line.size() - 1;
            if (gap == 0) {
                return line.get(0) + " ".repeat(maxWidth - total);
            }

            int sepSize = (maxWidth - total) / gap;
            int res = (maxWidth - total) % gap;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < gap; i++) {
                sb.append(line.get(i));
                sb.append(" ".repeat(sepSize));
                if (res-- > 0) {
                    sb.append(" ");
                }
            }
            sb.append(line.get(line.size() - 1));
            return sb.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}