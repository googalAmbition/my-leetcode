//给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// 
//
// 
// 注意：本题与主站 347 题相同：https://leetcode-cn.com/problems/top-k-frequent-elements/ 
//
// 👍 70 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class G5c51o {
    public static void main(String[] args) {
        Solution solution = new G5c51o().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
            map.forEach((key, val) -> {
                queue.offer(new int[] {key, val});
                if (queue.size() > k) {
                    queue.poll();
                }
            });
            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = queue.poll()[0];

            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

} 
