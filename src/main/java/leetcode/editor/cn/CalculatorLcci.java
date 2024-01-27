//给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。 
//
// 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 栈 数学 字符串 
// 👍 51 👎 0

// 计算器
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class CalculatorLcci {

    public static void main(String[] args) {
        Solution solution = new CalculatorLcci().new Solution();
        System.out.println(solution.calculate("111+1*2/1"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int calculate(String s) {

            char[] cs = s.trim().toCharArray();
            Deque<Integer> st = new ArrayDeque<>();
            int ans = 0, i = 0;
            while (i < cs.length) {
                if (cs[i] == ' ') {
                    i++;
                    continue;
                }
                char tmp = cs[i];
                if (tmp == '*' || tmp == '/' || tmp == '+' || tmp == '-') {
                    i++;
                    while (i < cs.length && cs[i] == ' ') {
                        i++;
                    }
                }
                int num = 0;
                while (i < cs.length && Character.isDigit(cs[i])) {
                    num = num * 10 + cs[i] - '0';
                    i++;
                }
                switch (tmp) {
                    case '-':
                        num = -num;
                        break;
                    case '*':
                        num = st.pop() * num;
                        break;
                    case '/':
                        num = st.pop() / num;
                        break;
                    default:
                        break;
                }
                st.push(num);
            }
            while (!st.isEmpty()) {
                ans += st.pop();
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}