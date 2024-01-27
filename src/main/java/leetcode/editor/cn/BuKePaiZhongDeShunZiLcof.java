//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// 👍 111 👎 0

// 扑克牌中的顺子
package leetcode.editor.cn;

public class BuKePaiZhongDeShunZiLcof {

    public static void main(String[] args) {
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
        int[] nums = {0, 0, 1, 2, 5};
        System.out.println(solution.isStraight(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isStraight(int[] nums) {
            int[] serialNmu = new int[14];
            for (int num: nums) {
                if (num > 0 && serialNmu[num] > 0) {
                    return false;
                }
                serialNmu[num]++;
            }
            int start = 1;
            int end = 13;
            while (start < end && (serialNmu[start] < 1 || serialNmu[end] < 1)) {

                if (serialNmu[start] < 1) {
                    start++;
                }
                if (serialNmu[end] < 1) {
                    end--;
                }
            }

            return end - start < 5;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}