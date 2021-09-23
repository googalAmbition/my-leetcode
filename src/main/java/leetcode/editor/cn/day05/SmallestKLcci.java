//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 66 👎 0

// 最小K个数
package leetcode.editor.cn.day05;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestKLcci {

    public static void main(String[] args) {
        Solution solution = new SmallestKLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] smallestK(int[] arr, int k) {
            int[] res = new int[k];
            if (k == 0) {
                return res;
            }
            Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < k; i++) {
                queue.offer(arr[i]);
            }
            for (int i = k; i < arr.length; i++) {
                if (queue.peek() > arr[i]) {
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
            for (int i = 0; i < k; i++) {
                res[i] = queue.poll();
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}