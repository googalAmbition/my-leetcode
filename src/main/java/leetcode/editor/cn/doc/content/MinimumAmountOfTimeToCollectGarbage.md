<p>给你一个下标从 <strong>0</strong>&nbsp;开始的字符串数组&nbsp;<code>garbage</code>&nbsp;，其中&nbsp;<code>garbage[i]</code>&nbsp;表示第 <code>i</code>&nbsp;个房子的垃圾集合。<code>garbage[i]</code>&nbsp;只包含字符&nbsp;<code>'M'</code>&nbsp;，<code>'P'</code> 和&nbsp;<code>'G'</code>&nbsp;，但可能包含多个相同字符，每个字符分别表示一单位的金属、纸和玻璃。垃圾车收拾 <strong>一</strong>&nbsp;单位的任何一种垃圾都需要花费&nbsp;<code>1</code>&nbsp;分钟。</p>

<p>同时给你一个下标从 <strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>travel</code>&nbsp;，其中&nbsp;<code>travel[i]</code>&nbsp;是垃圾车从房子 <code>i</code>&nbsp;行驶到房子 <code>i + 1</code>&nbsp;需要的分钟数。</p>

<p>城市里总共有三辆垃圾车，分别收拾三种垃圾。每辆垃圾车都从房子 <code>0</code>&nbsp;出发，<strong>按顺序</strong>&nbsp;到达每一栋房子。但它们 <strong>不是必须</strong>&nbsp;到达所有的房子。</p>

<p>任何时刻只有 <strong>一辆</strong>&nbsp;垃圾车处在使用状态。当一辆垃圾车在行驶或者收拾垃圾的时候，另外两辆车 <strong>不能</strong>&nbsp;做任何事情。</p>

<p>请你返回收拾完所有垃圾需要花费的 <strong>最少</strong>&nbsp;总分钟数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>garbage = ["G","P","GP","GG"], travel = [2,4,3]
<b>输出：</b>21
<strong>解释：</strong>
收拾纸的垃圾车：
1. 从房子 0 行驶到房子 1
2. 收拾房子 1 的纸垃圾
3. 从房子 1 行驶到房子 2
4. 收拾房子 2 的纸垃圾
收拾纸的垃圾车总共花费 8 分钟收拾完所有的纸垃圾。
收拾玻璃的垃圾车：
1. 收拾房子 0 的玻璃垃圾
2. 从房子 0 行驶到房子 1
3. 从房子 1 行驶到房子 2
4. 收拾房子 2 的玻璃垃圾
5. 从房子 2 行驶到房子 3
6. 收拾房子 3 的玻璃垃圾
收拾玻璃的垃圾车总共花费 13 分钟收拾完所有的玻璃垃圾。
由于没有金属垃圾，收拾金属的垃圾车不需要花费任何时间。
所以总共花费 8 + 13 = 21 分钟收拾完所有垃圾。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>garbage = ["MMM","PGM","GP"], travel = [3,10]
<b>输出：</b>37
<strong>解释：</strong>
收拾金属的垃圾车花费 7 分钟收拾完所有的金属垃圾。
收拾纸的垃圾车花费 15 分钟收拾完所有的纸垃圾。
收拾玻璃的垃圾车花费 15 分钟收拾完所有的玻璃垃圾。
总共花费 7 + 15 + 15 = 37 分钟收拾完所有的垃圾。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>2 &lt;= garbage.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>garbage[i]</code> 只包含字母&nbsp;<code>'M'</code>&nbsp;，<code>'P'</code>&nbsp;和&nbsp;<code>'G'</code>&nbsp;。</li> 
 <li><code>1 &lt;= garbage[i].length &lt;= 10</code></li> 
 <li><code>travel.length == garbage.length - 1</code></li> 
 <li><code>1 &lt;= travel[i] &lt;= 100</code></li> 
</ul>

<div><li>👍 24</li><li>👎 0</li></div>