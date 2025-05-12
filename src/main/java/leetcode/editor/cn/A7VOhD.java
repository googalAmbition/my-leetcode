//给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// 
//
// 
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/palindromic-substrings/ 
//
// 👍 108 👎 0

package leetcode.editor.cn;

public class A7VOhD {
    public static void main(String[] args) {
        Solution solution = new A7VOhD().new Solution();
        solution.countSubstrings("12345");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int len = s.length();
            int ans = 0;
            for (int i = 0; i < 2 * len - 1; i++) {
                int l = i / 2, r = i / 2 + i % 2;
                System.out.printf("left:%-5d,right:%-5d%n", l, r);
                while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                    ans++;
                }

            }
            return ans;

        }


    }
    //leetcode submit region end(Prohibit modification and deletion)


    public int countSubstrings(String s) {
        int n = s.length();
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');

        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            // 初始化 f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            // 中心拓展
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            // 动态维护 iMax 和 rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
            ans += f[i] / 2;
        }

        return ans;
    }

} 
