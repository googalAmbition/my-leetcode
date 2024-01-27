//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 953 👎 0

// 在排序数组中查找元素的第一个和最后一个位置
package leetcode.editor.cn;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = {1, 2};
        System.out.println(solution.searchRange(nums, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] searchRange(int[] nums, int target) {
            int[] not = {-1, -1};
            if (nums.length == 0) {
                return not;
            }
            if (nums.length == 1) {
                if (nums[0] == target) {
                    return new int[] {0, 0};
                } else {
                    return not;
                }
            }
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    if (nums[left] == nums[right]) {
                        break;
                    }
                    if (nums[left] != target) {
                        left++;
                    }
                    if (nums[right] != target) {
                        right--;
                    }
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (left > right) {
                return not;
            }

            return new int[] {left, right};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}