//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// 👍 2015 👎 0

package leetcode.editor.cn;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartitionv2(int[] nums) {
            int len = nums.length;
            // 题目已经说非空数组，可以不做非空判断
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            // 特判：如果是奇数，就不符合要求
            if ((sum & 1) == 1) {
                return false;
            }

            int target = sum / 2;
            // 创建二维状态数组，行：物品索引，列：容量（包括 0）
            boolean[][] dp = new boolean[len][target + 1];

            // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
            if (nums[0] <= target) {
                dp[0][nums[0]] = true;
            }
            // 再填表格后面几行
            for (int i = 1; i < len; i++) {
                for (int j = 0; j <= target; j++) {
                    // 直接从上一行先把结果抄下来，然后再修正
                    dp[i][j] = dp[i - 1][j];

                    if (nums[i] == j) {
                        dp[i][j] = true;
                        continue;
                    }
                    if (nums[i] < j) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                    }
                }
            }
            return dp[len - 1][target];

        }

        public boolean canPartition(int[] nums) {
            if (nums.length < 2) {
                return false;
            }
            int sum = 0, max = 0;
            for (int num : nums) {
                sum += num;
                max = Math.max(max, num);
            }
            if ((sum & 1) == 1 || max > sum / 2) {
                return false;
            }

            // 可能的和
            boolean[][] dp = new boolean[nums.length][sum / 2 + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = true;
            }
            dp[0][nums[0]] = true;
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < sum / 2 + 1; j++) {
                    //copy
                    dp[i][j] = dp[i - 1][j];
                    if (j == nums[i]) {
                        dp[i][j] = true;
                        continue;
                    }

                    if (nums[i] < j) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                    }

                }

            }
            return dp[dp.length - 1][sum / 2];

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

} 
