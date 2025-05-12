//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2910 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int largestRectangleArea(int[] heights) {
            List<Integer> heightsList = new ArrayList<>();
            for (int h : heights) {
                heightsList.add(h);
            }
            //添加哨兵节点确保最终栈被清空
            heightsList.add(0);
            //定义单调递增栈
            Deque<Integer> stack = new ArrayDeque<>();
            int maxArea = 0;

            for (int r = 0; r < heightsList.size(); r++) {
                // 栈不为空, 第r个高度 小于等于栈顶
                while (!stack.isEmpty() && heightsList.get(r) <= heightsList.get(stack.peek())) {
                    int curHeight = heightsList.get(stack.pop());
                    //左边界
                    int l = stack.isEmpty() ? -1 : stack.peek();
                    int width = r - l - 1;
                    maxArea = Math.max(maxArea, width * curHeight);
                }
                stack.push(r);
            }
            return maxArea;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> mono_stack = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }


} 
