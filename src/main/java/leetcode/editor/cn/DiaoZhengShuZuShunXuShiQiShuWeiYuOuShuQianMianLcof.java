//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 100 👎 0

// 调整数组顺序使奇数位于偶数前面
package leetcode.editor.cn;

public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {

    public static void main(String[] args) {
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] exchange(int[] nums) {
            if (nums.length < 2) {
                return nums;
            }
            int pre = 0;
            int last = nums.length - 1;
            while (pre < last) {
                if ((nums[pre] & 1) == 0 && (nums[last] & 1) == 1) {
                    int temp = nums[pre];
                    nums[pre] = nums[last];
                    nums[last] = temp;
                } else if ((nums[last] & 1) == 0) {
                    last--;
                } else {
                    pre++;
                }
            }
            return nums;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}