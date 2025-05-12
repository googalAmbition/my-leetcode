//给你一个由小写字母组成的字符串 s ，和一个整数 k 。如果满足下述条件，则可以将字符串 t 视作是 理想字符串 ： 
//
// 
// t 是字符串 s 的一个子序列。 
// t 中每两个 相邻 字母在字母表中位次的绝对差值小于或等于 k 。 
// 
//
// 返回 最长 理想字符串的长度。 
//
// 字符串的子序列同样是一个字符串，并且子序列还满足：可以经由其他字符串删除某些字符（也可以不删除）但不改变剩余字符的顺序得到。 
//
// 注意：字母表顺序不会循环。例如，'a' 和 'z' 在字母表中位次的绝对差值是 25 ，而不是 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "acfgbd", k = 2
//输出：4
//解释：最长理想字符串是 "acbd" 。该字符串长度为 4 ，所以返回 4 。
//注意 "acfgbd" 不是理想字符串，因为 'c' 和 'f' 的字母表位次差值为 3 。 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 3
//输出：4
//解释：最长理想字符串是 "abcd" ，该字符串长度为 4 ，所以返回 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// 0 <= k <= 25 
// s 由小写英文字母组成 
// 
//
// 👍 45 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class LongestIdealSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIdealSubsequence().new Solution();
        System.out.println(solution.longestIdealString("acfgbdefg", 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int longestIdealString(String s, int k) {
            int[] f = new int[26];
            for (char c : s.toCharArray()) {
                c -= 'a';
                for (int j = Math.max(c - k, 0); j <= Math.min(c + k, 25); j++) {
                    f[c] = Math.max(f[c], f[j]);
                }
                f[c]++;
            }
            return Arrays.stream(f).max().getAsInt();
        }


        public int longestIdealString1(String s, int k) {
            int length = s.length();
            char[] dp = new char[length];
            dp[0] = s.charAt(0);
            int ans = 1;
            for (int i = 1; i < length; i++) {
                int j = i - 1;
                while (j >= 0 && Math.abs(s.charAt(i) - dp[j]) > k) {
                    j--;
                }

                dp[j + 1] = s.charAt(i);
                ans = Math.max(ans, j + 2);
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        int size = 1;                   // 表示arr数组实际的大小
        int[] arr = new int[len];
        arr[0] = nums[0];               // 初始化第0个元素

        // 遍历nums中所有元素
        for (int i = 1; i < len; i++) {
            // 如果比arr最后一个元素大，直接在后面累加
            if (nums[i] > arr[size - 1]) {
                arr[size++] = nums[i];
            } else {
                // 否则的话，在arr中寻找它应该在的位置
                // 即在arr中寻找大于等于它的元素的位置
                int right = size - 1;
                // 从后向前遍历找到这个位置
                while (right >= 0 && arr[right] >= nums[i]) {
                    right--;
                }

                // 上面多减了一次，要补回来,使用更小的替换
                arr[right + 1] = nums[i];
            }
        }

        return size;
    }

    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int v = 0;
            int index = s.charAt(i) - 'a';
            for (int start = Math.max(index - k, 0); start <= Math.min(index + k, 25); start++) {
                v = Math.max(dp[start], v);
            }
            dp[index] = v + 1;
            ans = Math.max(v + 1, ans);
        }

        return ans;
    }
}
