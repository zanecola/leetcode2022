package questions.leetcode.editor.en;

//A tree is an undirected graph in which any two vertices are connected by 
//exactly one path. In other words, any connected graph without simple cycles is a 
//tree. 
//
// Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 
//edges where edges[i] = [ai, bi] indicates that there is an undirected edge between 
//the two nodes ai and bi in the tree, you can choose any node of the tree as the 
//root. When you select a node x as the root, the result tree has height h. Among 
//all possible rooted trees, those with minimum height (i.e. min(h)) are called 
//minimum height trees (MHTs). 
//
// Return a list of all MHTs' root labels. You can return the answer in any 
//order. 
//
// The height of a rooted tree is the number of edges on the longest downward 
//path between the root and a leaf. 
//
// 
// Example 1: 
// 
// 
//Input: n = 4, edges = [[1,0],[1,2],[1,3]]
//Output: [1]
//Explanation: As shown, the height of the tree is 1 when the root is the node 
//with label 1 which is the only MHT.
// 
//
// Example 2: 
// 
// 
//Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
//Output: [3,4]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2 * 10⁴ 
// edges.length == n - 1 
// 0 <= ai, bi < n 
// ai != bi 
// All the pairs (ai, bi) are distinct. 
// The given input is guaranteed to be a tree and there will be no repeated 
//edges. 
// 
//
// Related Topics Depth-First Search Breadth-First Search Graph Topological 
//Sort 👍 6518 👎 280


//A tree is an undirected graph in which any two vertices are connected by 
//exactly one path. In other words, any connected graph without simple cycles is a 
//tree. 
//
// Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 
//edges where edges[i] = [ai, bi] indicates that there is an undirected edge between 
//the two nodes ai and bi in the tree, you can choose any node of the tree as the 
//root. When you select a node x as the root, the result tree has height h. Among 
//all possible rooted trees, those with minimum height (i.e. min(h)) are called 
//minimum height trees (MHTs). 
//
// Return a list of all MHTs' root labels. You can return the answer in any 
//order. 
//
// The height of a rooted tree is the number of edges on the longest downward 
//path between the root and a leaf. 
//
// 
// Example 1: 
// 
// 
//Input: n = 4, edges = [[1,0],[1,2],[1,3]]
//Output: [1]
//Explanation: As shown, the height of the tree is 1 when the root is the node 
//with label 1 which is the only MHT.
// 
//
// Example 2: 
// 
// 
//Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
//Output: [3,4]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2 * 10⁴ 
// edges.length == n - 1 
// 0 <= ai, bi < n 
// ai != bi 
// All the pairs (ai, bi) are distinct. 
// The given input is guaranteed to be a tree and there will be no repeated 
//edges. 
// 
//
// Related Topics Depth-First Search Breadth-First Search Graph Topological 
//Sort 👍 6518 👎 280


import java.util.*;

public class Q310MinimumHeightTrees {
    public static void main(String[] args) {
        Solution solution = new Q310MinimumHeightTrees().new Solution();
        solution.findMinHeightTrees(6, new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{0, 3},
                new int[]{3, 4},
                new int[]{4, 5},
        });
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> res = new ArrayList<>();
            if (n == 1) return List.of(0);

            int[] degree = new int[n];
            Set<Integer>[] adj = new Set[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new HashSet<>();
            }


            for (int[] e : edges) {
                adj[e[0]].add(e[1]);
                adj[e[1]].add(e[0]);

                degree[e[1]]++;
                degree[e[0]]++;
            }

            Deque<Integer> queue = new ArrayDeque<>();
            int count = n;
            for (int i = 0; i < n; i++) {
                if (degree[i] == 1) {
                    queue.offer(i);
                }
            }

            while (count > 2) {
                int size = queue.size();
                while (size-- > 0) {
                    int cur = queue.poll();
                    count--;
                    for (int next : adj[cur]) {
                        degree[next]--;
                        if (degree[next] == 1) {
                            queue.offer(next);
                        }
                    }
                }
            }

            while (!queue.isEmpty()) {
                res.add(queue.poll());
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}