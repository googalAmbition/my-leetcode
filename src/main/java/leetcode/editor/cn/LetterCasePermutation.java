//给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。 
//
// 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
// 
//
// 示例 2: 
//
// 
//输入: s = "3z4"
//输出: ["3z4","3Z4"]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 12 
// s 由小写英文字母、大写英文字母和数字组成 
// 
//
// Related Topics 位运算 字符串 回溯 👍 600 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        Solution solution = new LetterCasePermutation().new Solution();

        System.out.println(solution.letterCasePermutation("a1b2"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCasePermutation(String s) {
            List<String> ans = new ArrayList<String>();
            dfs(s.toCharArray(), 0, ans);
            return ans;
        }

        public void dfs(char[] arr, int pos, List<String> res) {
            while (pos < arr.length && Character.isDigit(arr[pos])) {
                pos++;
            }
            if (pos == arr.length) {
                res.add(new String(arr));
                return;
            }
            arr[pos] ^= 32;
            dfs(arr, pos + 1, res);
            arr[pos] ^= 32;
            dfs(arr, pos + 1, res);
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

} 
