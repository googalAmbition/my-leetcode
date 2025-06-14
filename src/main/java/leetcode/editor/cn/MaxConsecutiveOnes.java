//给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,0,1,1,1]
//输出：3
//解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
// 
//
// 示例 2: 
//
// 
//输入：nums = [1,0,1,1,0,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1. 
// 
//
// Related Topics 数组 👍 327 👎 0

// 最大连续 1 的个数
package leetcode.editor.cn;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findMaxConsecutiveOnes(int[] nums) {
            int ans = 0, n = 0;
            for (int i = 0; i < nums.length; i++) {
                while (i < nums.length && nums[i] == 1) {
                    n++;
                    i++;
                }
                ans = Math.max(n,ans);
                n = 0;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}