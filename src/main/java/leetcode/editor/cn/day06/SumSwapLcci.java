//给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。 
//
// 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
// 
//
// 示例: 
//
// 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
//输出: [1, 3]
// 
//
// 示例: 
//
// 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
//输出: [] 
//
// 提示： 
//
// 
// 1 <= array1.length, array2.length <= 100000 
// 
// Related Topics 数组 哈希表 二分查找 排序 
// 👍 26 👎 0

// 交换和
package leetcode.editor.cn.day06;

import java.util.HashSet;
import java.util.Set;

public class SumSwapLcci {

    public static void main(String[] args) {
        Solution solution = new SumSwapLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] findSwapValues(int[] array1, int[] array2) {

            // 记录两个数组的和
            int sum1 = 0, sum2 = 0;
            // 记录 array2 中的数都出现过哪些
            Set<Integer> container = new HashSet<>();
            for (int num: array1) {
                sum1 += num;
            }
            for (int num: array2) {
                container.add(num);
                sum2 += num;
            }
            // 求两个数组之差
            int diff = sum1 - sum2;
            // 如果不是偶数差值，那么直接返回空数组
            if (diff % 2 != 0) {
                return new int[] {};
            }
            diff /= 2;
            // 从 array2 中找到能和 array1 中 num 配对的数，如果找到了就直接返回，没找到就返回空数组。
            for (int num: array1) {
                if (container.contains(num - diff)) {
                    return new int[] {num, num - diff};
                }
            }
            return new int[] {};

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}