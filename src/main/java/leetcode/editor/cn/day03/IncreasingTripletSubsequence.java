//给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。 
//
// 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true
// ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4,5]
//输出：true
//解释：任何 i < j < k 的三元组都满足题意
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,4,3,2,1]
//输出：false
//解释：不存在满足题意的三元组 
//
// 示例 3： 
//
// 
//输入：nums = [2,1,5,0,4,6]
//输出：true
//解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -231 <= nums[i] <= 231 - 1 
// 
//
// 
//
// 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？ 
// 👍 299 👎 0

// 递增的三元子序列
package leetcode.editor.cn.day03;

public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
        Solution solution = new IncreasingTripletSubsequence().new Solution();
        int[] nums = {2, 1, 5, 10, 4, 6};
        solution.increasingTriplet(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean increasingTriplet(int[] nums) {
            if (nums.length < 3) {
                return false;
            }
            int first = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;
            for (int i = nums.length - 1; i >= 0; i--) {
                //tips  =号是防止相等的情况
                if (nums[i] >= first) {
                    first = nums[i];
                } else if (nums[i] >= second) {
                    second = nums[i];
                } else {
                    return true;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}