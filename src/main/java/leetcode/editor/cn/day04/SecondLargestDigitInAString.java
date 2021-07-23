//给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。 
//
// 混合字符串 由小写英文字母和数字组成。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "dfa12321afd"
//输出：2
//解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
// 
//
// 示例 2： 
//
// 
//输入：s = "abc1111"
//输出：-1
//解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 只包含小写英文字母和（或）数字。 
// 
// Related Topics 字符串 
// 👍 2 👎 0

// 字符串中第二大的数字
package leetcode.editor.cn.day04;

public class SecondLargestDigitInAString {

    public static void main(String[] args) {
        Solution solution = new SecondLargestDigitInAString().new Solution();
        System.out.println(solution.secondHighest("dfa12321afd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int secondHighest(String s) {
            if (s.length() < 2) {
                return -1;
            }
            int[] num = new int[10];
            char[] chars = s.toCharArray();
            for (char c: chars) {
                if (c - '0' >= 0 && c - '0' <= 9) {
                    num[c - '0'] = 1;
                }
            }
            boolean flag = false;
            for (int i = num.length - 1; i >= 0; i--) {
                if (flag && num[i] == 1) {
                    return i;
                }
                if (num[i] == 1) {
                    flag = true;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}