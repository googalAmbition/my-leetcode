<p>给你二叉树的根节点 <code>root</code> ，返回其节点值 <strong>自底向上的层序遍历</strong> 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg" style="width: 277px; height: 302px;" />
<pre>
<strong>输入：</strong>root = [3,9,20,null,null,15,7]
<strong>输出：</strong>[[15,7],[9,20],[3]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = [1]
<strong>输出：</strong>[[1]]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = []
<strong>输出：</strong>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点数目在范围 <code>[0, 2000]</code> 内</li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
</ul>
<div><div>Related Topics</div><div><li>树</li><li>广度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 594</li><li>👎 0</li></div>