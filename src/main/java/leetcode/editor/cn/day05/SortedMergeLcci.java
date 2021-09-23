//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。 
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。 
//
// 示例: 
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
//
// 说明: 
//
// 
// A.length == n + m 
// 
// Related Topics 数组 双指针 排序 
// 👍 111 👎 0

// 合并排序的数组
package leetcode.editor.cn.day05;

import java.util.Arrays;

public class SortedMergeLcci {

    public static void main(String[] args) {
        Solution solution = new SortedMergeLcci().new Solution();
        int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {3, 5, 6};

        System.arraycopy(B, 0, A, 3, 2);
        for (int i: A) {
            System.out.println(i);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void merge(int[] A, int m, int[] B, int n) {
            System.arraycopy(B, 0, A, m, n);
            Arrays.sort(A);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}