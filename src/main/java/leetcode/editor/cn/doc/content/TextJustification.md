<p>给定一个单词数组&nbsp;<code>words</code> 和一个长度&nbsp;<code>maxWidth</code>&nbsp;，重新排版单词，使其成为每行恰好有&nbsp;<code>maxWidth</code>&nbsp;个字符，且左右两端对齐的文本。</p>

<p>你应该使用 “<strong>贪心算法</strong>” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格&nbsp;<code>' '</code>&nbsp;填充，使得每行恰好有 <em>maxWidth</em>&nbsp;个字符。</p>

<p>要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。</p>

<p>文本的最后一行应为左对齐，且单词之间不插入<strong>额外的</strong>空格。</p>

<p><strong>注意:</strong></p>

<ul> 
 <li>单词是指由非空格字符组成的字符序列。</li> 
 <li>每个单词的长度大于 0，小于等于&nbsp;<em>maxWidth</em>。</li> 
 <li>输入单词数组 <code>words</code>&nbsp;至少包含一个单词。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入: </strong>words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
<strong>输出:</strong>
[
&nbsp; &nbsp;"This &nbsp; &nbsp;is &nbsp; &nbsp;an",
&nbsp; &nbsp;"example &nbsp;of text",
&nbsp; &nbsp;"justification. &nbsp;"
]
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong>words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
<strong>输出:</strong>
[
&nbsp; "What &nbsp; must &nbsp; be",
&nbsp; "acknowledgment &nbsp;",
&nbsp; "shall be &nbsp; &nbsp; &nbsp; &nbsp;"
]
<strong>解释: </strong>注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
&nbsp;    因为最后一行应为左对齐，而不是左右两端对齐。       
     第二行同样为左对齐，这是因为这行只包含一个单词。
</pre>

<p><strong>示例&nbsp;3:</strong></p>

<pre>
<strong>输入:</strong>words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 20
<strong>输出:</strong>
[
&nbsp; "Science &nbsp;is &nbsp;what we",
  "understand &nbsp; &nbsp; &nbsp;well",
&nbsp; "enough to explain to",
&nbsp; "a &nbsp;computer. &nbsp;Art is",
&nbsp; "everything &nbsp;else &nbsp;we",
&nbsp; "do &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"
]
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul> 
 <li><code>1 &lt;= words.length &lt;= 300</code></li> 
 <li><code>1 &lt;= words[i].length &lt;= 20</code></li> 
 <li><code>words[i]</code>&nbsp;由小写英文字母和符号组成</li> 
 <li><code>1 &lt;= maxWidth &lt;= 100</code></li> 
 <li><code>words[i].length &lt;= maxWidth</code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>字符串</li><li>模拟</li></div></div><br><div><li>👍 470</li><li>👎 0</li></div>