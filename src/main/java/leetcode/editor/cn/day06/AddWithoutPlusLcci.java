//设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// Related Topics 位运算 数学 
// 👍 51 👎 0

// 不用加号的加法
package leetcode.editor.cn.day06;

public class AddWithoutPlusLcci {

    public static void main(String[] args) {
        Solution solution = new AddWithoutPlusLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int add(int a, int b) {

            int in = (a & b) << 1;
            int res = a ^ b;
            while (in != 0) {
                a = in;
                b = res;
                in = (a & b) << 1;
                res = a ^ b;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}