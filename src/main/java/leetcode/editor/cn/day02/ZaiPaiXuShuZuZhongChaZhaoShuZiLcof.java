//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 107 👎 0

// 在排序数组中查找数字 I
package leetcode.editor.cn.day02;

public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {

    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int search(int[] nums, int target) {
            // 搜索右边界 right
            int pre = 0, last = nums.length - 1;
            while (pre <= last) {
                int mid = (pre + last) / 2;
                if (nums[mid] <= target) {
                    pre = mid + 1;
                } else {
                    last = mid - 1;
                }
            }
            int right = pre;
            // 若数组中无 target ，则提前返回
            if (last >= 0 && nums[last] != target) {
                return 0;
            }
            // 搜索左边界 right
            pre = 0;
            last = nums.length - 1;
            while (pre <= last) {
                int m = (pre + last) / 2;
                if (nums[m] < target) {
                    pre = m + 1;
                } else {
                    last = m - 1;
                }
            }
            int left = last;
            return right - left - 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}