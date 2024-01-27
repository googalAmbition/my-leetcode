//编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。 
// 示例： 
// 输入： a = 1, b = 2
//输出： 2
// 
// Related Topics 位运算 脑筋急转弯 数学 
// 👍 88 👎 0

// 最大数值
package leetcode.editor.cn;

public class MaximumLcci {

    public static void main(String[] args) {
        Solution solution = new MaximumLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximum(int a, int b) {

            int signA = a >>> 31;
            int signB = b >>> 31;
            int posAnegB = ~(~signA + 1) & (~signB + 1);
            int negAposB = (~signA + 1) & ~(~signB + 1);
            int negAnegB = (~signA + 1) & (~signB + 1);
            int posAposB = ~(~signA + 1) & ~(~signB + 1);
            int signDiff = (a - b) >>> 31;
            int lessThan = ~signDiff + 1;
            return (posAnegB & a) | (negAposB & b) | ((negAnegB | posAposB) & ((lessThan & b) | (~lessThan & a)));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}