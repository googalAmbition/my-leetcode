//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。 
//
// 示例 1： 
//
// 输入: s = "leetcode"
//输出: false 
// 
//
// 示例 2： 
//
// 输入: s = "abc"
//输出: true
// 
//
// 限制： 
// 
// 0 <= len(s) <= 100 
// 如果你不使用额外的数据结构，会很加分。 
// 
// Related Topics 数组 
// 👍 105 👎 0

// 判定字符是否唯一
package leetcode.editor.cn;

public class IsUniqueLcci {

    public static void main(String[] args) {
        Solution solution = new IsUniqueLcci().new Solution();
        solution.isUnique("abc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isUnique(String astr) {
            int aa = 0;
            int cc = 1;
            for (int i = 0; i < astr.length(); i++) {
                char t = astr.charAt(i);
                int offset = t - 'a';

                int bb = cc << offset;
                if ((aa & bb) != 0) {
                    return false;
                }
                aa |= bb;
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}