//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
//外其余各元素的乘积。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6] 
//
// 
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。 
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 进阶： 
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
// Related Topics 数组 前缀和 
// 👍 906 👎 0

// 除自身以外数组的乘积
package leetcode.editor.cn;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] productExceptSelf(int[] nums) {
            int length = nums.length;
            int[] answer = new int[length];

            // answer[i] 表示索引 i 左侧所有元素的乘积
            // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
            answer[0] = 1;
            for (int i = 1; i < length; i++) {
                answer[i] = nums[i - 1] * answer[i - 1];
            }

            // R 为右侧所有元素的乘积
            // 刚开始右边没有元素，所以 R = 1
            int R = 1;
            for (int i = length - 1; i >= 0; i--) {
                // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
                answer[i] = answer[i] * R;
                // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
                R *= nums[i];
            }
            return answer;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    // 由这个解法推断上面的  左侧*右侧
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        // L 和 R 分别表示左右两侧的乘积列表
        int[] L = new int[length];
        int[] R = new int[length];

        int[] answer = new int[length];

        // L[i] 为索引 i 左侧所有元素的乘积
        // 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }

        // R[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }

        return answer;
    }


}