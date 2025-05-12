//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为 无重复元素 的 升序 排列数组 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 二分查找 👍 1582 👎 0

// 搜索插入位置
package leetcode.editor.cn;

public class SearchInsertPosition {

    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int searchInsert(int[] nums, int target) {
            if (nums.length == 1) {
                if (nums[0] >= target) {
                    return 0;
                } else {
                    return 1;
                }
            }
            if (nums[0] >= target) {
                return 0;
            }
            if (nums[nums.length - 1] < target) {
                return nums.length;
            }
            int left = 0, right = nums.length - 1;
            while (left < right) {
                if (right - left == 1) {
                    return left + 1;
                }
                int mid = (left + right) >>> 1;

                if (nums[mid] == target) {
                    return mid;
                }else if (nums[mid] > target){
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}