//给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。 
//
// 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。 
//
// 
//
// 示例 1: 
//
// 输入: [[1,1],2,[1,1]]
//输出: [1,1,2,1,1]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。 
//
// 示例 2: 
//
// 输入: [1,[4,[6]]]
//输出: [1,4,6]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
// 
// Related Topics 栈 设计 
// 👍 321 👎 0

// 扁平化嵌套列表迭代器
package leetcode.editor.cn;

import leetcode.editor.cn.struct.NestedInteger;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FlattenNestedListIterator implements Iterator<Integer> {

    public static void main(String[] args) {
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return empty list if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */
    public class NestedIterator implements Iterator<Integer> {

        // 存储列表的当前遍历位置
        private final Deque<Iterator<NestedInteger>> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new LinkedList<Iterator<NestedInteger>>();
            stack.push(nestedList.iterator());
        }

        @Override
        public Integer next() {
            // 由于保证调用 next 之前会调用 hasNext，直接返回栈顶列表的当前元素
            return stack.peek().next().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                Iterator<NestedInteger> it = stack.peek();
                if (!it.hasNext()) { // 遍历到当前列表末尾，出栈
                    stack.pop();
                    continue;
                }
                // 若取出的元素是整数，则通过创建一个额外的列表将其重新放入栈中
                NestedInteger nest = it.next();
                if (nest.isInteger()) {
                    List<NestedInteger> list = new ArrayList<NestedInteger>();
                    list.add(nest);
                    stack.push(list.iterator());
                    return true;
                }
                stack.push(nest.getList().iterator());
            }
            return false;
        }
    }

    /**
     * Your NestedIterator object will be instantiated and called as such:
     * NestedIterator i = new NestedIterator(nestedList);
     * while (i.hasNext()) v[f()] = i.next();
     */
    //leetcode submit region end(Prohibit modification and deletion)

    private final List<Integer> vals;
    private final Iterator<Integer> cur;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        vals = new ArrayList<Integer>();
        dfs(nestedList);
        cur = vals.iterator();
    }

    @Override
    public Integer next() {
        return cur.next();
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nest: nestedList) {
            if (nest.isInteger()) {
                vals.add(nest.getInteger());
            } else {
                dfs(nest.getList());
            }
        }
    }
}