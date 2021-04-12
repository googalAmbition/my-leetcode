//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数学 
// 👍 99 👎 0

// 打印从1到最大的n位数
package leetcode.editor.cn.day01;

import java.util.Arrays;

public class DaYinCong1daoZuiDaDeNweiShuLcof {

    public static void main(String[] args) {
        Solution solution = new DaYinCong1daoZuiDaDeNweiShuLcof().new Solution();
        System.out.println(Arrays.toString(Arrays.stream(solution.printNumbers(1)).toArray()));
        SolutionV2 solutionv2 = new DaYinCong1daoZuiDaDeNweiShuLcof().new SolutionV2();
        System.out.println(solutionv2.printNumbers(2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] printNumbers(int n) {
            int end = (int) Math.pow(10, n);
            int i = 1;
            int[] result = new int[end - 1];
            while (i < end) {
                result[i - 1] = i;
                i++;
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    // 如果超出越界，使用string表示
    class SolutionV2 {

        StringBuilder res;
        int  n;
        char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        public String printNumbers(int n) {
            this.n = n;
            res = new StringBuilder(); // 数字字符串集
            num = new char[n]; // 定义长度为 n 的字符列表
            dfs(0); // 开启全排列递归
            res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
            return res.toString(); // 转化为字符串并返回
        }

        void dfs(int x) {
            if (x == n) { // 终止条件：已固定完所有位
                res.append(String.valueOf(num)).append(","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
                return;
            }
            for (char i: loop) { // 遍历 ‘0‘ - ’9‘
                num[x] = i; // 固定第 x 位为 i
                dfs(x + 1); // 开启固定第 x + 1 位
            }
        }
    }
}