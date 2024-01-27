//给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？ 
//
// 以任意顺序返回这两个数字均可。 
//
// 示例 1: 
//
// 输入: [1]
//输出: [2,3] 
//
// 示例 2: 
//
// 输入: [2,3]
//输出: [1,4] 
//
// 提示： 
//
// 
// nums.length <= 30000 
// 
// Related Topics 位运算 数组 哈希表 
// 👍 43 👎 0

// 消失的两个数字
package leetcode.editor.cn;

import java.util.Arrays;

public class MissingTwoLcci {

    public static void main(String[] args) {
        Solution solution = new MissingTwoLcci().new Solution();

        int[] nums = {2, 4};
        System.out.println(Arrays.toString(solution.missingTwo(nums)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] missingTwo(int[] nums) {
            // 首先明确一共需要多少个数字（范围）
            int n = nums.length + 2;
            // 对当前已有的序列求和
            int sum = Arrays.stream(nums).sum();
            // 根据等差数列求和方法，求出目标和与当前和的差值，差值即为两个缺失数字的和
            int diff = n * (n + 1) / 2 - sum;
            // 找到两个数字的分界线，一定是分界线两边各有一个，因为两个数字不会重复嘛
            int divide = diff / 2;
            // 接着求出其中一边应有的和为多少，还是等差数列求和方法
            sum = divide * (divide + 1) / 2;
            // 然后在分界线一边逐渐找到这个值
            for (int num: nums) {
                if (num <= divide) {
                    sum -= num;
                }
            }
            // 相减得到另一个值
            return new int[] {sum, diff - sum};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}