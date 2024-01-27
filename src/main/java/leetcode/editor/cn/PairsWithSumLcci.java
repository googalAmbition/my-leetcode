//设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。 
//
// 示例 1: 
//
// 输入: nums = [5,6,5], target = 11
//输出: [[5,6]] 
//
// 示例 2: 
//
// 输入: nums = [5,6,5,6], target = 11
//输出: [[5,6],[5,6]] 
//
// 提示： 
//
// 
// nums.length <= 100000 
// 
// Related Topics 数组 哈希表 双指针 计数 排序 
// 👍 29 👎 0

// 数对和
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsWithSumLcci {

    public static void main(String[] args) {
        Solution solution = new PairsWithSumLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> pairSums(int[] nums, int target) {
            List<List<Integer>> re = new ArrayList<>();

            Map<Integer, Integer> map = new HashMap<>();
            for (int num: nums) {

                Integer c = map.getOrDefault(target - num, 0);
                if (c != 0) {
                    re.add(Arrays.asList(num, target - num));
                    map.put(target - num, c - 1);
                    continue;
                }

                Integer count = map.getOrDefault(num, 0);
                map.put(num, count + 1);
            }

            return re;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}