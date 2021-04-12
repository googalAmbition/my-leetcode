//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 86 👎 0

package leetcode.editor.cn.day01;

import java.util.Arrays;

public class TiHuanKongGeLcof {

    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String replaceSpace(String s) {
            char[] array = new char[s.length() * 3];
            int index = 0;
            for (char c: s.toCharArray()) {
                if (c == ' ') {
                    array[index] = '%';
                    array[++index] = '2';
                    array[++index] = '0';
                    index++;
                } else {
                    array[index] = c;
                    index++;
                }
            }
            char[] resultChar = Arrays.copyOfRange(array, 0, index);
            return new String(resultChar);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}