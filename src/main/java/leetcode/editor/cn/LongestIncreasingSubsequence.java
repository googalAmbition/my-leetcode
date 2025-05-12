//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
//
// 👍 3579 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        int[] nums = {7, 7, 7, 7, 7};
        System.out.println(solution.lengthOfLIS(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int lengthOfLIS(int[] nums) {
            List<Integer> list = new ArrayList<>();
            if (nums.length == 0) {
                return 0;
            }

            list.add(nums[0]);

            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                if (num > list.get(list.size() - 1)) {
                    list.add(num);
                } else {
                    int j = lowerBound(list, num);
                    list.set(j, num);
                }
            }
            return list.size();
        }

        private int lowerBound(List<Integer> p, int target) {
            int left = 0, right = p.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (p.get(mid) < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }


        public int lengthOfLIS1(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 3000);
            dp[0] = nums[0];
            int ans = 1;
            for (int i = 1; i < nums.length; i++) {
                int j = i - 1;
                while (j >= 0 && dp[j] >= nums[i]) {
                    j--;
                }
                dp[j + 1] = nums[i];
                ans = Math.max(ans, j + 2);
            }
            return ans;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

} 
