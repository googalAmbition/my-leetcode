//数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1
//) 的解决方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,5,9,5,9,5,5,5]
//输出：5 
//
// 示例 2： 
//
// 
//输入：[3,2]
//输出：-1 
//
// 示例 3： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2 
// Related Topics 数组 计数 
// 👍 184 👎 0

// 主要元素
package leetcode.editor.cn.day06;

public class FindMajorityElementLcci {

    public static void main(String[] args) {
        Solution solution = new FindMajorityElementLcci().new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(solution.majorityElement(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int majorityElement(int[] nums) {
            int candidate = -1;
            int count = 0;
            for (int num: nums) {
                if (count == 0) {
                    candidate = num;
                }
                if (num == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
            count = 0;
            int length = nums.length;
            for (int num: nums) {
                if (num == candidate) {
                    count++;
                }
            }
            return count * 2 > length ? candidate : -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}