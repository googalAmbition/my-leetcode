//在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8
//, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。 
//
// 示例: 
//
// 输入: [5, 3, 1, 2, 3]
//输出: [5, 1, 3, 2, 3]
// 
//
// 提示： 
//
// 
// nums.length <= 10000 
// 
// Related Topics 贪心 数组 排序 
// 👍 32 👎 0

// 峰与谷
package leetcode.editor.cn.day05;

import java.util.Arrays;

public class PeaksAndValleysLcci {

    public static void main(String[] args) {
        Solution solution = new PeaksAndValleysLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void wiggleSort(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 1; i += 2) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}