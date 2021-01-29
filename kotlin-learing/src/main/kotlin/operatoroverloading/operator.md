<!--
 * @Author: your name
 * @Date: 2021-01-29 13:42:23
 * @LastEditTime: 2021-01-29 13:57:16
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \android-diyihangdaima\kotlin-learing\src\main\kotlin\operatoroverloading\operator.md
-->
# kotlin运算符重载
- 语法糖表达式以及实际调用表达式对应表

<article role="main" class="page-content g-9">
<a href="https://github.com/hltj/kotlin-web-site-cn/edit/master/pages/docs/reference/operator-overloading.md" class="page-link-to-github" target="_blank" title="在 GitHub 上编辑本页">
        <i class="github-icon"></i>
        <span class="text">改进翻译</span>
</a>
                
<h1 class="typo-header typo-h1" id="操作符重载">操作符重载<a class="anchor" href="#操作符重载"></a></h1>
<p class="typo-para">Kotlin 允许我们为自己的类型提供预定义的一组操作符的实现。这些操作符具有固定的符号表示
（如 <code>+</code> 或 <code>*</code>）和固定的<a class="typo-link" href="grammar.html#expressions">优先级</a>。为实现这样的操作符，我们为相应的类型（即二元操作符左侧的类型和一元操作符的参数类型）提供了一个固定名字的<a class="typo-link" href="functions.html#成员函数">成员函数</a><!--
-->或<a class="typo-link" href="extensions.html">扩展函数</a>。
重载操作符的函数需要用 <code>operator</code> 修饰符标记。</p>
<p class="typo-para">另外，我们描述为不同操作符规范操作符重载的约定。</p>
<h2 class="typo-header typo-h2" id="一元操作">一元操作<a class="anchor" href="#一元操作"></a></h2>
<h3 class="typo-header typo-h3" id="一元前缀操作符">一元前缀操作符<a class="anchor" href="#一元前缀操作符"></a></h3>
<table class="typo-table">
<thead>
<tr class="typo-table__row">
<th>表达式</th>
<th>翻译为</th>
</tr>
</thead>
<tbody>
<tr class="typo-table__row">
<td class="typo-table__column"><code>+a</code></td>
<td class="typo-table__column"><code>a.unaryPlus()</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>-a</code></td>
<td class="typo-table__column"><code>a.unaryMinus()</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>!a</code></td>
<td class="typo-table__column"><code>a.not()</code></td>
</tr>
</tbody>
</table>
<p class="typo-para">这个表是说，当编译器处理例如表达式 <code>+a</code> 时，它执行以下步骤：</p>
<ul class="typo-list typo-list_type_simple">
<li class="typo-list__item">确定 <code>a</code> 的类型，令其为 <code>T</code>；</li>
<li class="typo-list__item">为接收者 <code>T</code> 查找一个带有 <code>operator</code> 修饰符的无参函数 <code>unaryPlus（）</code>，即成员函数或扩展函数；</li>
<li class="typo-list__item">如果函数不存在或不明确，则导致编译错误；</li>
<li class="typo-list__item">如果函数存在且其返回类型为 <code>R</code>，那就表达式 <code>+a</code> 具有类型 <code>R</code>；</li>
</ul>
<p class="typo-para"><em>注意</em> 这些操作以及所有其他操作都针对<a class="typo-link" href="basic-types.html">基本类型</a>做了优化，不会为它们引入函数调用的开销。</p>
<p class="typo-para">以下是如何重载一元减运算符的示例：</p>
<div class="sample" theme="idea" data-kotlin-playground-initialized="true" style="display: none;">
<pre><code class="language-kotlin">data class Point(val x: Int, val y: Int)

operator fun Point.unaryMinus() = Point(-x, -y)

val point = Point(10, 20)

fun main() {
   println(-point)  // 输出“Point(x=-10, y=-20)”
}

</code></pre>
</div><div><div class="executable-fragment-wrapper"><div class="executable-fragment idea"><div class="run-button "></div><!--if--><div class="code-area _folded"><!--if--><textarea style="display: none;"></textarea><div class="CodeMirror cm-s-idea CodeMirror-overlayscroll"><div style="overflow: hidden; position: relative; width: 3px; height: 0px; top: 12px; left: 21px;"><textarea autocorrect="off" autocapitalize="off" spellcheck="false" tabindex="0" style="position: absolute; bottom: -1em; padding: 0px; width: 1000px; height: 1em; outline: none;"></textarea></div><div class="CodeMirror-overlayscroll-horizontal" cm-not-content="true" style="display: none;"><div></div></div><div class="CodeMirror-overlayscroll-vertical" cm-not-content="true" style="display: none;"><div></div></div><div class="CodeMirror-scrollbar-filler" cm-not-content="true"></div><div class="CodeMirror-gutter-filler" cm-not-content="true"></div><div class="CodeMirror-scroll" tabindex="-1"><div class="CodeMirror-sizer" style="margin-left: 17px; margin-bottom: -17px; border-right-width: 13px; min-height: 151px; min-width: 349.4px; padding-right: 0px; padding-bottom: 0px;"><div style="position: relative; top: 0px;"><div class="CodeMirror-lines" role="presentation"><div role="presentation" style="position: relative; outline: none;"><div class="CodeMirror-measure"><pre class="CodeMirror-line-like"><span>xxxxxxxxxx</span></pre></div><div class="CodeMirror-measure"></div><div style="position: relative; z-index: 1;"></div><div class="CodeMirror-cursors"><div class="CodeMirror-cursor" style="left: 4px; top: 0px; height: 16.8px;">&nbsp;</div></div><div class="CodeMirror-code" role="presentation" style=""><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"><span class="cm-keyword">data</span> <span class="cm-keyword">class</span> <span class="cm-def">Point</span>(<span class="cm-keyword">val</span> <span class="cm-def">x</span>: <span class="cm-type">Int</span>, <span class="cm-keyword">val</span> <span class="cm-def">y</span>: <span class="cm-type">Int</span>)</span></pre><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"><span cm-text="">​</span></span></pre><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"><span class="cm-keyword">operator</span> <span class="cm-keyword">fun</span> <span class="cm-def">Point</span>.<span class="cm-variable">unaryMinus</span>() <span class="cm-operator">=</span> <span class="cm-variable">Point</span>(<span class="cm-operator">-</span><span class="cm-variable">x</span>, <span class="cm-operator">-</span><span class="cm-variable">y</span>)</span></pre><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"><span cm-text="">​</span></span></pre><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"><span class="cm-keyword">val</span> <span class="cm-def">point</span> <span class="cm-operator">=</span> <span class="cm-variable">Point</span>(<span class="cm-number">10</span>, <span class="cm-number">20</span>)</span></pre><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"><span cm-text="">​</span></span></pre><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"><span class="cm-keyword">fun</span> <span class="cm-def">main</span>() {</span></pre><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;">   <span class="cm-variable">println</span>(<span class="cm-operator">-</span><span class="cm-variable">point</span>)  <span class="cm-comment">// 输出“Point(x=-10, y=-20)”</span></span></pre><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;">}</span></pre></div></div></div></div></div><div style="position: absolute; height: 13px; width: 1px; border-bottom: 0px solid transparent; top: 151px;"></div><div class="CodeMirror-gutters" style="height: 164px; left: 0px;"><div class="CodeMirror-gutter errors-and-warnings-gutter"></div><div class="CodeMirror-gutter CodeMirror-foldgutter"></div></div></div></div></div><div class="js-code-output-executor idea"><!--if--><!--if--></div></div><div class="compiler-info" data-nosnippet=""><span>Target platform: JVM</span><span>Running on kotlin v. 1.4.20</span></div><!--if--></div></div>
<h3 class="typo-header typo-h3" id="递增与递减">递增与递减<a class="anchor" href="#递增与递减"></a></h3>
<table class="typo-table">
<thead>
<tr class="typo-table__row">
<th>表达式</th>
<th>翻译为</th>
</tr>
</thead>
<tbody>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a++</code></td>
<td class="typo-table__column"><code>a.inc()</code> + 见下文</td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a--</code></td>
<td class="typo-table__column"><code>a.dec()</code> + 见下文</td>
</tr>
</tbody>
</table>
<p class="typo-para"><code>inc()</code> 和 <code>dec()</code> 函数必须返回一个值，它用于赋值给使用
<code>++</code> 或 <code>--</code> 操作的变量。它们不应该改变在其上调用 <code>inc()</code> 或 <code>dec()</code> 的对象。</p>
<p class="typo-para">编译器执行以下步骤来解析<em>后缀</em>形式的操作符，例如 <code>a++</code>：</p>
<ul class="typo-list typo-list_type_simple">
<li class="typo-list__item">确定 <code>a</code> 的类型，令其为 <code>T</code>；</li>
<li class="typo-list__item">查找一个适用于类型为 <code>T</code> 的接收者的、带有 <code>operator</code> 修饰符的无参数函数 <code>inc()</code>；</li>
<li class="typo-list__item">检测函数的返回类型是 <code>T</code> 的子类型。</li>
</ul>
<p class="typo-para">计算表达式的步骤是：</p>
<ul class="typo-list typo-list_type_simple">
<li class="typo-list__item">把 <code>a</code> 的初始值存储到临时存储 <code>a0</code> 中；</li>
<li class="typo-list__item">把 <code>a0.inc()</code> 结果赋值给 <code>a</code>；</li>
<li class="typo-list__item">把 <code>a0</code> 作为表达式的结果返回。</li>
</ul>
<p class="typo-para">对于 <code>a--</code>，步骤是完全类似的。</p>
<p class="typo-para">对于<em>前缀</em>形式 <code>++a</code> 和 <code>--a</code> 以相同方式解析，其步骤是：</p>
<ul class="typo-list typo-list_type_simple">
<li class="typo-list__item">把 <code>a.inc()</code> 结果赋值给 <code>a</code>；</li>
<li class="typo-list__item">把 <code>a</code> 的新值作为表达式结果返回。</li>
</ul>
<h2 class="typo-header typo-h2" id="二元操作">二元操作<a class="anchor" href="#二元操作"></a></h2>
<h3 class="typo-header typo-h3" id="arithmetic">算术运算符<a class="anchor" href="#arithmetic"></a></h3>
<table class="typo-table">
<thead>
<tr class="typo-table__row">
<th>表达式</th>
<th>翻译为</th>
</tr>
</thead>
<tbody>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a + b</code></td>
<td class="typo-table__column"><code>a.plus(b)</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a - b</code></td>
<td class="typo-table__column"><code>a.minus(b)</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a * b</code></td>
<td class="typo-table__column"><code>a.times(b)</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a / b</code></td>
<td class="typo-table__column"><code>a.div(b)</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a % b</code></td>
<td class="typo-table__column"><code>a.rem(b)</code>、 <code>a.mod(b)</code> （已弃用）</td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a..b </code></td>
<td class="typo-table__column"><code>a.rangeTo(b)</code></td>
</tr>
</tbody>
</table>
<p class="typo-para">对于此表中的操作，编译器只是解析成<em>翻译为</em>列中的表达式。</p>
<p class="typo-para">请注意，自 Kotlin 1.1 起支持 <code>rem</code> 运算符。Kotlin 1.0 使用 <code>mod</code> 运算符，它在
Kotlin 1.1 中被弃用。</p>
<h4 class="typo-header typo-h4" id="示例">示例</h4>
<p class="typo-para">下面是一个从给定值起始的 Counter 类的示例，它可以使用重载的 <code>+</code> 运算符来增加计数：</p>
<pre><code class="code _highlighted cm-s-default" data-lang="text/x-kotlin"><span class="cm-keyword">data</span> <span class="cm-keyword">class</span> <span class="cm-def">Counter</span>(<span class="cm-keyword">val</span> <span class="cm-def">dayIndex</span>: <span class="cm-type">Int</span>) {
    <span class="cm-keyword">operator</span> <span class="cm-keyword">fun</span> <span class="cm-def">plus</span>(<span class="cm-variable">increment</span>: <span class="cm-type">Int</span>): <span class="cm-variable">Counter</span> {
        <span class="cm-keyword">return</span> <span class="cm-variable">Counter</span>(<span class="cm-variable">dayIndex</span> <span class="cm-operator">+</span> <span class="cm-variable">increment</span>)
    }
}
</code></pre>
<h3 class="typo-header typo-h3" id="in">“In”操作符<a class="anchor" href="#in"></a></h3>
<table class="typo-table">
<thead>
<tr class="typo-table__row">
<th>表达式</th>
<th>翻译为</th>
</tr>
</thead>
<tbody>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a in b</code></td>
<td class="typo-table__column"><code>b.contains(a)</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a !in b</code></td>
<td class="typo-table__column"><code>!b.contains(a)</code></td>
</tr>
</tbody>
</table>
<p class="typo-para">对于 <code>in</code> 和 <code>!in</code>，过程是相同的，但是参数的顺序是相反的。</p>
<h3 class="typo-header typo-h3" id="indexed">索引访问操作符<a class="anchor" href="#indexed"></a></h3>
<table class="typo-table">
<thead>
<tr class="typo-table__row">
<th>表达式</th>
<th>翻译为</th>
</tr>
</thead>
<tbody>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a[i]</code></td>
<td class="typo-table__column"><code>a.get(i)</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a[i, j]</code></td>
<td class="typo-table__column"><code>a.get(i, j)</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a[i_1, ……,  i_n]</code></td>
<td class="typo-table__column"><code>a.get(i_1, ……,  i_n)</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a[i] = b</code></td>
<td class="typo-table__column"><code>a.set(i, b)</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a[i, j] = b</code></td>
<td class="typo-table__column"><code>a.set(i, j, b)</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a[i_1, ……,  i_n] = b</code></td>
<td class="typo-table__column"><code>a.set(i_1, ……, i_n, b)</code></td>
</tr>
</tbody>
</table>
<p class="typo-para">方括号转换为调用带有适当数量参数的 <code>get</code> 和 <code>set</code>。</p>
<h3 class="typo-header typo-h3" id="invoke">调用操作符<a class="anchor" href="#invoke"></a></h3>
<table class="typo-table">
<thead>
<tr class="typo-table__row">
<th>表达式</th>
<th>翻译为</th>
</tr>
</thead>
<tbody>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a()</code></td>
<td class="typo-table__column"><code>a.invoke()</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a(i)</code></td>
<td class="typo-table__column"><code>a.invoke(i)</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a(i, j)</code></td>
<td class="typo-table__column"><code>a.invoke(i, j)</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a(i_1, ……,  i_n)</code></td>
<td class="typo-table__column"><code>a.invoke(i_1, ……,  i_n)</code></td>
</tr>
</tbody>
</table>
<p class="typo-para">圆括号转换为调用带有适当数量参数的 <code>invoke</code>。</p>
<h3 class="typo-header typo-h3" id="assignments">广义赋值<a class="anchor" href="#assignments"></a></h3>
<table class="typo-table">
<thead>
<tr class="typo-table__row">
<th>表达式</th>
<th>翻译为</th>
</tr>
</thead>
<tbody>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a += b</code></td>
<td class="typo-table__column"><code>a.plusAssign(b)</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a -= b</code></td>
<td class="typo-table__column"><code>a.minusAssign(b)</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a *= b</code></td>
<td class="typo-table__column"><code>a.timesAssign(b)</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a /= b</code></td>
<td class="typo-table__column"><code>a.divAssign(b)</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a %= b</code></td>
<td class="typo-table__column"><code>a.remAssign(b)</code>, <code>a.modAssign(b)</code>（已弃用）</td>
</tr>
</tbody>
</table>
<p class="typo-para">对于赋值操作，例如 <code>a += b</code>，编译器执行以下步骤：</p>
<ul class="typo-list typo-list_type_simple">
<li class="typo-list__item">如果右列的函数可用
    <ul class="typo-list typo-list_type_simple">
<li class="typo-list__item">如果相应的二元函数（即 <code>plusAssign()</code> 对应于 <code>plus()</code>）也可用，那么报告错误（模糊），</li>
<li class="typo-list__item">确保其返回类型是 <code>Unit</code>，否则报告错误，</li>
<li class="typo-list__item">生成 <code>a.plusAssign(b)</code> 的代码；</li>
</ul>
</li>
<li class="typo-list__item">否则试着生成 <code>a = a + b</code> 的代码（这里包含类型检测：<code>a + b</code> 的类型必须是 <code>a</code> 的子类型）。</li>
</ul>
<p class="typo-para"><em>注意</em>：赋值在 Kotlin 中<em>不是</em>表达式。</p>
<h3 class="typo-header typo-h3" id="equals">相等与不等操作符<a class="anchor" href="#equals"></a></h3>
<table class="typo-table">
<thead>
<tr class="typo-table__row">
<th>表达式</th>
<th>翻译为</th>
</tr>
</thead>
<tbody>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a == b</code></td>
<td class="typo-table__column"><code>a?.equals(b) ?: (b === null)</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a != b</code></td>
<td class="typo-table__column"><code>!(a?.equals(b) ?: (b === null))</code></td>
</tr>
</tbody>
</table>
<p class="typo-para">这些操作符只使用函数 <a class="typo-link" href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html"><code>equals(other: Any?): Boolean</code></a>，可以覆盖它来提供自定义的相等性检测实现。不会调用任何其他同名函数（如 <code>equals(other: Foo)</code>）。</p>
<p class="typo-para"><em>注意</em>：<code>===</code> 和 <code>!==</code>（同一性检测）不可重载，因此不存在对他们的约定。</p>
<p class="typo-para">这个 <code>==</code> 操作符有些特殊：它被翻译成一个复杂的表达式，用于筛选 <code>null</code> 值。
<code>null == null</code>  总是 true，对于非空的 <code>x</code>，<code>x == null</code> 总是 false 而不会调用 <code>x.equals()</code>。</p>
<h3 class="typo-header typo-h3" id="comparison">比较操作符<a class="anchor" href="#comparison"></a></h3>
<table class="typo-table">
<thead>
<tr class="typo-table__row">
<th>表达式</th>
<th>翻译为</th>
</tr>
</thead>
<tbody>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a &gt; b</code></td>
<td class="typo-table__column"><code>a.compareTo(b) &gt; 0</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a &lt; b</code></td>
<td class="typo-table__column"><code>a.compareTo(b) &lt; 0</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a &gt;= b</code></td>
<td class="typo-table__column"><code>a.compareTo(b) &gt;= 0</code></td>
</tr>
<tr class="typo-table__row">
<td class="typo-table__column"><code>a &lt;= b</code></td>
<td class="typo-table__column"><code>a.compareTo(b) &lt;= 0</code></td>
</tr>
</tbody>
</table>
<p class="typo-para">所有的比较都转换为对 <code>compareTo</code> 的调用，这个函数需要返回 <code>Int</code> 值</p>
<h3 class="typo-header typo-h3" id="属性委托操作符">属性委托操作符<a class="anchor" href="#属性委托操作符"></a></h3>
<p class="typo-para"><code>provideDelegate</code>、 <code>getValue</code> 以及 <code>setValue</code> 操作符函数已在<!--
--><a class="typo-link" href="delegated-properties.html">委托属性</a>中描述。</p>
<h2 class="typo-header typo-h2" id="具名函数的中缀调用">具名函数的中缀调用<a class="anchor" href="#具名函数的中缀调用"></a></h2>
<p class="typo-para">我们可以通过<a class="typo-link" href="functions.html#中缀表示法">中缀函数的调用</a> 来模拟自定义中缀操作符。</p>

        </article>