<p>设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。</p>

<p>实现 <code>WordFilter</code> 类：</p>

<ul>
	<li><code>WordFilter(string[] words)</code> 使用词典中的单词 <code>words</code> 初始化对象。</li>
	<li><code>f(string prefix, string suffix)</code> 返回词典中具有前缀 <code>prefix</code> 和后缀<code>suffix</code> 的单词的下标。如果存在不止一个满足要求的下标，返回其中 <strong>最大的下标</strong> 。如果不存在这样的单词，返回 <code>-1</code> 。</li>
</ul>

<p> </p>

<p><strong>示例</strong></p>

<pre>
<strong>输入：</strong>
["WordFilter", "f"]
[[["apple"]], ["a", "e"]]
<strong>输出：</strong>
[null, 0]

<strong>解释：</strong>
WordFilter wordFilter = new WordFilter(["apple"]);
wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词的 prefix = "a" 且 suffix = 'e" 。
</pre>
 

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= words.length <= 15000</code></li>
	<li><code>1 <= words[i].length <= 10</code></li>
	<li><code>1 <= prefix.length, suffix.length <= 10</code></li>
	<li><code>words[i]</code>、<code>prefix</code> 和 <code>suffix</code> 仅由小写英文字母组成</li>
	<li>最多对函数 <code>f</code> 进行 <code>15000</code> 次调用</li>
</ul>
<div><div>Related Topics</div><div><li>设计</li><li>字典树</li><li>字符串</li></div></div><br><div><li>👍 88</li><li>👎 0</li></div>