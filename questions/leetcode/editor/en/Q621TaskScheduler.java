package questions.leetcode.editor.en;

//Given a characters array tasks, representing the tasks a CPU needs to do, 
//where each letter represents a different task. Tasks could be done in any order. 
//Each task is done in one unit of time. For each unit of time, the CPU could 
//complete either one task or just be idle. 
//
// However, there is a non-negative integer n that represents the cooldown 
//period between two same tasks (the same letter in the array), that is that there 
//must be at least n units of time between any two same tasks. 
//
// Return the least number of units of times that the CPU will take to finish 
//all the given tasks. 
//
// 
// Example 1: 
//
// 
//Input: tasks = ["A","A","A","B","B","B"], n = 2
//Output: 8
//Explanation: 
//A -> B -> idle -> A -> B -> idle -> A -> B
//There is at least 2 units of time between any two same tasks.
// 
//
// Example 2: 
//
// 
//Input: tasks = ["A","A","A","B","B","B"], n = 0
//Output: 6
//Explanation: On this case any permutation of size 6 would work since n = 0.
//["A","A","A","B","B","B"]
//["A","B","A","B","A","B"]
//["B","B","B","A","A","A"]
//...
//And so on.
// 
//
// Example 3: 
//
// 
//Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
//Output: 16
//Explanation: 
//One possible solution is
//A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle ->
// idle -> A
// 
//
// 
// Constraints: 
//
// 
// 1 <= task.length <= 10⁴ 
// tasks[i] is upper-case English letter. 
// The integer n is in the range [0, 100]. 
// 
//
// Related Topics Array Hash Table Greedy Sorting Heap (Priority Queue) 
//Counting 👍 8069 👎 1612


//Given a characters array tasks, representing the tasks a CPU needs to do, 
//where each letter represents a different task. Tasks could be done in any order. 
//Each task is done in one unit of time. For each unit of time, the CPU could 
//complete either one task or just be idle. 
//
// However, there is a non-negative integer n that represents the cooldown 
//period between two same tasks (the same letter in the array), that is that there 
//must be at least n units of time between any two same tasks. 
//
// Return the least number of units of times that the CPU will take to finish 
//all the given tasks. 
//
// 
// Example 1: 
//
// 
//Input: tasks = ["A","A","A","B","B","B"], n = 2
//Output: 8
//Explanation: 
//A -> B -> idle -> A -> B -> idle -> A -> B
//There is at least 2 units of time between any two same tasks.
// 
//
// Example 2: 
//
// 
//Input: tasks = ["A","A","A","B","B","B"], n = 0
//Output: 6
//Explanation: On this case any permutation of size 6 would work since n = 0.
//["A","A","A","B","B","B"]
//["A","B","A","B","A","B"]
//["B","B","B","A","A","A"]
//...
//And so on.
// 
//
// Example 3: 
//
// 
//Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
//Output: 16
//Explanation: 
//One possible solution is
//A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle ->
// idle -> A
// 
//
// 
// Constraints: 
//
// 
// 1 <= task.length <= 10⁴ 
// tasks[i] is upper-case English letter. 
// The integer n is in the range [0, 100]. 
// 
//
// Related Topics Array Hash Table Greedy Sorting Heap (Priority Queue) 
//Counting 👍 8069 👎 1612


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q621TaskScheduler {
    public static void main(String[] args) {
        Solution solution = new Q621TaskScheduler().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            if (n == 0) return tasks.length;
            int[] map = new int[26];
            for (char c : tasks) {
                map[c - 'A']++;
            }

            int max = 0, count = 0;
            for (int c : map) {
                if (c > max) {
                    max = c;
                    count = 1;
                } else if (c == max) {
                    count++;
                }
            }

            return Math.max(tasks.length, (max - 1) * (n + 1) + count);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}