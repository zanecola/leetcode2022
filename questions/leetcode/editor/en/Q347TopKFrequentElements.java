package questions.leetcode.editor.en;

//Given an integer array nums and an integer k, return the k most frequent 
//elements. You may return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// 
// Example 2: 
// Input: nums = [1], k = 1
//Output: [1]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// k is in the range [1, the number of unique elements in the array]. 
// It is guaranteed that the answer is unique. 
// 
//
// 
// Follow up: Your algorithm's time complexity must be better than O(n log n), 
//where n is the array's size. 
//
// Related Topics Array Hash Table Divide and Conquer Sorting Heap (Priority 
//Queue) Bucket Sort Counting Quickselect 👍 12545 👎 462


//Given an integer array nums and an integer k, return the k most frequent 
//elements. You may return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// 
// Example 2: 
// Input: nums = [1], k = 1
//Output: [1]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// k is in the range [1, the number of unique elements in the array]. 
// It is guaranteed that the answer is unique. 
// 
//
// 
// Follow up: Your algorithm's time complexity must be better than O(n log n), 
//where n is the array's size. 
//
// Related Topics Array Hash Table Divide and Conquer Sorting Heap (Priority 
//Queue) Bucket Sort Counting Quickselect 👍 12545 👎 462


import java.util.*;

public class Q347TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new Q347TopKFrequentElements().new Solution();
        solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int n : nums) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }

            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

            qs(list, 0, list.size() - 1);

            int[] res = new int[k];

            for (int i = 0; i < k; i++) {
                res[i] = list.get(list.size() - 1 - i).getKey();
            }

            return res;
        }

        void qs(List<Map.Entry<Integer, Integer>> list, int l, int r) {
            if (l >= r) return;

            int ll = l, rr = r;
            while (ll < rr) {
                while (ll < rr && list.get(rr).getValue() > list.get(ll).getValue()) {
                    rr--;
                }

                if (ll >= rr) break;
                swap(list, ll, rr);
                ll++;

                while (ll < rr && list.get(ll).getValue() < list.get(rr).getValue()) {
                    ll++;
                }

                if (ll >= rr) break;
                swap(list, ll, rr);
                rr--;
            }

            qs(list, l, ll - 1);
            qs(list, ll + 1, r);
        }

        void swap(List<Map.Entry<Integer, Integer>> list, int l, int r) {
            var t = list.get(l);
            list.set(l, list.get(r));
            list.set(r, t);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}