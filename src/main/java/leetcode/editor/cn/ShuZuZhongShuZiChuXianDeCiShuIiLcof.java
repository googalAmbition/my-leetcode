//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// 👍 164 👎 0

// 数组中数字出现的次数 II
package leetcode.editor.cn;

public class ShuZuZhongShuZiChuXianDeCiShuIiLcof {

    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int singleNumber(int[] nums) {
            int[] counts = new int[32];
            for (int num: nums) {
                for (int j = 0; j < 32; j++) {
                    counts[j] += num & 1;
                    num >>>= 1;
                }
            }
            int res = 0, m = 3;
            for (int i = 0; i < 32; i++) {
                res <<= 1;
                res |= counts[31 - i] % m;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num: nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}