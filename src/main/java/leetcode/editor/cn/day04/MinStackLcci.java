//请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(
//1)。 示例： MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
// minStack.push(-3); minStack.getMin();   --> 返回 -3. minStack.pop(); minStack.top
//();      --> 返回 0. minStack.getMin();   --> 返回 -2. Related Topics 栈 设计 
// 👍 53 👎 0

// 栈的最小值
package leetcode.editor.cn.day04;

import java.util.Deque;
import java.util.LinkedList;

public class MinStackLcci {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        private Deque<Integer> data;
        private Deque<Integer> min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new LinkedList<>();
            min = new LinkedList<>();
        }

        public void push(int x) {
            data.push(x);
            if (min.peek() != null) {
                min.push(Math.min(x, min.peek()));
            } else {
                min.push(x);
            }
        }

        public void pop() {
            data.pop();
            min.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    //leetcode submit region end(Prohibit modification and deletion)
}