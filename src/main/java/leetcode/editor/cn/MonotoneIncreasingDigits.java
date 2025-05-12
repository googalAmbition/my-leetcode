//当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。 
//
// 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 10
//输出: 9
// 
//
// 示例 2: 
//
// 
//输入: n = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 
//输入: n = 332
//输出: 299
// 
//
// 
//
// 提示: 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// 👍 461 👎 0

package leetcode.editor.cn;

public class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        Solution solution = new MonotoneIncreasingDigits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int monotoneIncreasingDigits(int n) {
            char[] arr = (n + "").toCharArray();
            // max:截止i位最大值; idx:max下标
            int max = -1, idx = -1;
            for (int i = 0; i < arr.length - 1; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                    idx = i;
                }
                //高位 大于低位
                if (arr[i] > arr[i + 1]) {
                    arr[idx] --;
                    for(int j = idx + 1;j < arr.length;j++) {
                        arr[j] = '9';
                    }
                    break;
                }
            }
            return Integer.parseInt(new String(arr));

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

} 
