//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 字符串 动态规划 
// 👍 66 👎 0

// 一次编辑
package leetcode.editor.cn;

public class OneAwayLcci {

    public static void main(String[] args) {
        Solution solution = new OneAwayLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean oneEditAway(String first, String second) {
            int f = first.length();
            int s = second.length();
            if (Math.abs(f - s) > 1) {
                return false;
            }
            if (first.equals(second)) {
                return true;
            }

            int count = 0;    // 记录不匹配的次数。
            int i = 0, j = 0; // 用来指向两字符串的指针
            while (i < f && j < s) {

                // 两个字符串从前往后开始遍历，如果当前两字符串字符相同就继续比较下一个。
                if (first.charAt(i++) == second.charAt(j++)) {

                    continue;
                }
                count++;
                if (count > 1) {
                    return false;
                }

                if (f != s) { // 若不相等，则将短字符串指针前移一位

                    if (f > s) {
                        j--;
                    } else {
                        i--;
                    }
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}