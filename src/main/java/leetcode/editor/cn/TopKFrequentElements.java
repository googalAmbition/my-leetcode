//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
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
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 2000 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> topKFrequent(int[] nums, int k) {
            List<Integer> res = new ArrayList();
            // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
            HashMap<Integer, Integer> map = new HashMap();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }

            //桶排序
            //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
            List<Integer>[] list = new List[nums.length + 1];
            for (int key : map.keySet()) {
                // 获取出现的次数作为下标
                int i = map.get(key);
                if (list[i] == null) {
                    list[i] = new ArrayList();
                }
                list[i].add(key);
            }

            // 倒序遍历数组获取出现顺序从大到小的排列
            for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
                if (list[i] == null) {
                    continue;
                }
                res.addAll(list[i]);
            }
            return res;
        }

    }

    //leetcode submit region end(Prohibit modification and deletion)

} 
