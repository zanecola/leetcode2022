package questions.leetcode.editor.en;

//Given an array of characters chars, compress it using the following algorithm:
// 
//
// Begin with an empty string s. For each group of consecutive repeating 
//characters in chars: 
//
// 
// If the group's length is 1, append the character to s. 
// Otherwise, append the character followed by the group's length. 
// 
//
// The compressed string s should not be returned separately, but instead, be 
//stored in the input character array chars. Note that group lengths that are 10 or 
//longer will be split into multiple characters in chars. 
//
// After you are done modifying the input array, return the new length of the 
//array. 
//
// You must write an algorithm that uses only constant extra space. 
//
// 
// Example 1: 
//
// 
//Input: chars = ["a","a","b","b","c","c","c"]
//Output: Return 6, and the first 6 characters of the input array should be: [
//"a","2","b","2","c","3"]
//Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3
//".
// 
//
// Example 2: 
//
// 
//Input: chars = ["a"]
//Output: Return 1, and the first character of the input array should be: ["a"]
//Explanation: The only group is "a", which remains uncompressed since it's a 
//single character.
// 
//
// Example 3: 
//
// 
//Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
//Output: Return 4, and the first 4 characters of the input array should be: [
//"a","b","1","2"].
//Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
// 
//
// 
// Constraints: 
//
// 
// 1 <= chars.length <= 2000 
// chars[i] is a lowercase English letter, uppercase English letter, digit, or 
//symbol. 
// 
//
// Related Topics Two Pointers String 👍 3721 👎 5849


//Given an array of characters chars, compress it using the following algorithm:
// 
//
// Begin with an empty string s. For each group of consecutive repeating 
//characters in chars: 
//
// 
// If the group's length is 1, append the character to s. 
// Otherwise, append the character followed by the group's length. 
// 
//
// The compressed string s should not be returned separately, but instead, be 
//stored in the input character array chars. Note that group lengths that are 10 or 
//longer will be split into multiple characters in chars. 
//
// After you are done modifying the input array, return the new length of the 
//array. 
//
// You must write an algorithm that uses only constant extra space. 
//
// 
// Example 1: 
//
// 
//Input: chars = ["a","a","b","b","c","c","c"]
//Output: Return 6, and the first 6 characters of the input array should be: [
//"a","2","b","2","c","3"]
//Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3
//".
// 
//
// Example 2: 
//
// 
//Input: chars = ["a"]
//Output: Return 1, and the first character of the input array should be: ["a"]
//Explanation: The only group is "a", which remains uncompressed since it's a 
//single character.
// 
//
// Example 3: 
//
// 
//Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
//Output: Return 4, and the first 4 characters of the input array should be: [
//"a","b","1","2"].
//Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
// 
//
// 
// Constraints: 
//
// 
// 1 <= chars.length <= 2000 
// chars[i] is a lowercase English letter, uppercase English letter, digit, or 
//symbol. 
// 
//
// Related Topics Two Pointers String 👍 3721 👎 5849


public class Q443StringCompression {
    public static void main(String[] args) {
        Solution solution = new Q443StringCompression().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int compress(char[] chars) {
            if (chars.length < 2) return chars.length;
            int l = 0, write = 0;

            for (int i = 0; i < chars.length; i++) {
                if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
                    int count = i - l + 1;
                    chars[write] = chars[i];
                    write++;
                    if (count > 1) {
                        int start = write;
                        while (count > 0) {
                            chars[write++] = (char) (count % 10 + '0');
                            count /= 10;
                        }
                        reverse(chars, start, write - 1);
                    }
                    l = i + 1;
                }
            }

            return write;
        }

        void reverse(char[] chars, int l, int r) {
            while (l < r) {
                char t = chars[l];
                chars[l] = chars[r];
                chars[r] = t;
                r--;
                l++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}