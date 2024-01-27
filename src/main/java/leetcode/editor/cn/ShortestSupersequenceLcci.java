//假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。 
//
// 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。 
//
// 示例 1: 
//
// 输入:
//big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
//small = [1,5,9]
//输出: [7,10] 
//
// 示例 2: 
//
// 输入:
//big = [1,2,3]
//small = [4]
//输出: [] 
//
// 提示： 
//
// 
// big.length <= 100000 
// 1 <= small.length <= 100000 
// 
// Related Topics 数组 哈希表 滑动窗口 
// 👍 36 👎 0

// 最短超串
package leetcode.editor.cn;

import java.util.HashMap;

public class ShortestSupersequenceLcci {

    public static void main(String[] args) {
        Solution solution = new ShortestSupersequenceLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] shortestSeq(int[] big, int[] small) {
            // 最短窗口大小
            int minWindow = big.length + 1;
            // 数组记录对应左边已经出现的次数
            int[] count = new int[small.length];
            // 哈希表记录small数组的数字及其坐标
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < small.length; i++) {
                map.put(small[i], i);
            }
            // 左右边界指针、已经找到的数字个数
            int left = 0, right = 0, find = 0;
            int[] res = new int[2];

            while (right < big.length) {
                int rightNum = big[right];
                // 如果右指针数字是small中的
                if (map.containsKey(rightNum)) {
                    // 仅当第一次出现的时候才对find加1
                    if (count[map.get(rightNum)] == 0) {
                        find++;
                    }
                    // 不管怎样对应坐标计数加1
                    count[map.get(rightNum)]++;
                }
                // 右移左指针，即尝试缩小窗口大小
                while (find == small.length) {
                    // 如果当前窗口比之前更小，则保存
                    if (right - left + 1 < minWindow) {
                        res[0] = left;
                        res[1] = right;
                        minWindow = right - left + 1;
                    }
                    int leftNum = big[left];
                    // 如果当前数字是small中的
                    if (map.containsKey(leftNum)) {
                        // 不管怎样对应坐标计数先减1
                        count[map.get(leftNum)]--;
                        // 如果减完发现等于0，表示当前窗口已经不存在该数，find减1
                        if (count[map.get(leftNum)] == 0) {
                            find--;
                        }
                    }
                    left++;
                }
                right++;
            }

            return minWindow <= big.length ? res : new int[0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}