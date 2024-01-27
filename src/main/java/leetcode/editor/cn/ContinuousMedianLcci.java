//随机产生数字并传递给一个方法。你能否完成这个方法，在每次产生新值时，寻找当前所有值的中间值（中位数）并保存。 
//
// 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2
// 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 
// 👍 21 👎 0

// 连续中值
package leetcode.editor.cn;

import java.util.PriorityQueue;

public class ContinuousMedianLcci {

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

        private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> (b - a));
        private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        public MedianFinder() {
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty()) {
                maxHeap.add(num);
                return;
            }
            if (minHeap.isEmpty()) {
                if (num >= maxHeap.peek()) {
                    minHeap.add(num);
                } else {
                    int value = maxHeap.poll();
                    maxHeap.add(num);
                    minHeap.add(value);
                }
                return;
            }
            int low = maxHeap.peek();
            int high = minHeap.peek();
            if (num <= low) {
                if (maxHeap.size() != minHeap.size()) {
                    minHeap.add(maxHeap.poll());
                }
                maxHeap.add(num);
            } else if (num <= high) {
                if (maxHeap.size() == minHeap.size()) {
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
            } else if (num > high) {
                if (maxHeap.size() == minHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
                minHeap.add(num);
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                return maxHeap.peek();
            }
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    //leetcode submit region end(Prohibit modification and deletion)
}