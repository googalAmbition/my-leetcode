//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 
//输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 30 
// 
// s 由小写英文字母、数字和方括号
// '[]' 组成 
// s 保证是一个 有效 的输入。 
// s 中所有整数的取值范围为
// [1, 300] 
// 
//
// Related Topics 栈 递归 字符串 👍 1965 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String decodeString(String s) {
            Deque<Integer> countStack = new ArrayDeque<>(); // 存储数字
            Deque<String> stringStack = new ArrayDeque<>(); // 存储字符串
            String currentString = ""; // 当前解码字符串
            int k = 0; // 当前的倍数

            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch)) {
                    k = k * 10 + (ch - '0'); // 处理多位数
                } else if (ch == '[') {
                    // 遇到 '['，将当前的字符串和数字推入各自的栈
                    countStack.push(k);
                    stringStack.push(currentString);
                    currentString = ""; // 重置当前字符串
                    k = 0; // 重置倍数
                } else if (ch == ']') {
                    // 遇到 ']'，解码
                    StringBuilder temp = new StringBuilder(stringStack.pop());
                    int repeatTimes = countStack.pop();
                    for (int i = 0; i < repeatTimes; i++) {
                        temp.append(currentString); // 重复当前字符串
                    }
                    currentString = temp.toString(); // 更新当前字符串
                } else {
                    // 如果是字母，直接加到当前字符串
                    currentString += ch;
                }
            }

            return currentString;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
