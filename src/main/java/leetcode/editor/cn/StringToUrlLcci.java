//URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，
//请使用字符数组实现，以便直接在数组上操作。） 
//
// 
//
// 示例 1： 
//
// 
//输入："Mr John Smith    ", 13
//输出："Mr%20John%20Smith"
// 
//
// 示例 2： 
//
// 
//输入："               ", 5
//输出："%20%20%20%20%20"
// 
//
// 
//
// 提示： 
//
// 
// 字符串长度在 [0, 500000] 范围内。 
// 
// Related Topics 字符串 
// 👍 38 👎 0

// URL化
package leetcode.editor.cn;

import java.util.Arrays;

public class StringToUrlLcci {

    public static void main(String[] args) {
        Solution solution = new StringToUrlLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String replaceSpaces(String S, int length) {
            char[] re = new char[length * 3];
            int index = 0;
            char[] chars = S.toCharArray();
            for (int i = 0; i < length; i++) {
                char c = chars[i];
                if (c == ' ') {
                    re[index++] = '%';
                    re[index++] = '2';
                    re[index++] = '0';
                } else {
                    re[index++] = c;
                }
            }
            return new String(Arrays.copyOf(re, index));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}