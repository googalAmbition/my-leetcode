//给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。 
//
// 示例 1： 
//
// 输入: num = 1775(110111011112)
//输出: 8
// 
//
// 示例 2： 
//
// 输入: num = 7(01112)
//输出: 4
// 
// Related Topics 位运算 动态规划 
// 👍 44 👎 0

// 翻转数位
package leetcode.editor.cn.day05;

public class ReverseBitsLcci {

    public static void main(String[] args) {
        Solution solution = new ReverseBitsLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int reverseBits(int num) {
            int max = 0;
            int count = 0;
            boolean flag = false;
            int start = 0;
            for (int i = 31; i >= 0; i--) {
                int i1 = (num >> i) & 1;
                if (i1 == 1) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    if (flag) {
                        count = 0;
                        i = start;
                        flag = false;
                    } else {
                        count++;
                        flag = true;
                        start = i;
                        max = Math.max(max, count);
                    }
                }
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}