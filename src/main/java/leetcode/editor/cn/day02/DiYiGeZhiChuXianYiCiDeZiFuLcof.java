//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 81 👎 0

// 第一个只出现一次的字符
package leetcode.editor.cn.day02;

public class DiYiGeZhiChuXianYiCiDeZiFuLcof {

    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public char firstUniqChar(String s) {
            if (s.length() == 0) {
                return ' ';
            }
            char[] nums = new char[26];
            char[] chars = s.toCharArray();
            for (char aChar: chars) {
                nums[aChar - 'a']++;
            }
            for (char aChar: chars) {
                if (nums[aChar - 'a'] == 1) {
                    return aChar;
                }
            } return ' ';
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}