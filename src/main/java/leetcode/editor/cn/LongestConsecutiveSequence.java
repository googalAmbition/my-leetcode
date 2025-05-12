//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,0,1,2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 2471 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int longestConsecutive(int[] nums) {
            int ans = 0;
            Set<Integer> st = new HashSet<>();
            for (int num : nums) {
                st.add(num); // 把 nums 转成哈希集合
            }
            for (int x : st) { // 遍历哈希集合
                if (st.contains(x - 1)) {
                    continue;
                }
                // x 是序列的起点
                int y = x + 1;
                while (st.contains(y)) { // 不断查找下一个数是否在哈希集合中
                    y++;
                }
                // 循环结束后，y-1 是最后一个在哈希集合中的数
                ans = Math.max(ans, y - x); // 从 x 到 y-1 一共 y-x 个数
            }
            return ans;
        }


    }

    //leetcode submit region end(Prohibit modification and deletion)

    public int longestConsecutive(int[] nums) {
        // 去重
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }


}
