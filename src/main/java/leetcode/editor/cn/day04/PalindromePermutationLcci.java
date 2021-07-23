//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。 
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。 
//
// 回文串不一定是字典当中的单词。 
//
// 
//
// 示例1： 
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
// 
//
// 
// Related Topics 位运算 哈希表 字符串 
// 👍 54 👎 0

// 回文排列
package leetcode.editor.cn.day04;

public class PalindromePermutationLcci {

    public static void main(String[] args) {
        Solution solution = new PalindromePermutationLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canPermutePalindrome(String s) {
            int[] flag = new int[256];
            for (int i = 0; i < s.length(); i++) {
                flag[s.charAt(i)]++;
            }
            boolean one = false;
            for (int j: flag) {
                if ((j & 1) == 1) {
                    if (one) {
                        return false;
                    }
                    one = true;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}