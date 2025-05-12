package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaTest {
	@GetMapping("/javatest")
	public String javaTest() {
		
		String result="""
				<style type=\"text/css\">
			ul, ol {
				background: #fffde8;
				box-shadow: 0px 0px 0px 10px #fffde8;/*線の外側*/
				border: dashed 2px #ffb03f;/*破線*/
				border-radius: 9px;
				margin-left: 10px;/*はみ出ないように調整*/
				margin-right: 10px;/*はみ出ないように調整*/
				padding: 0.5em 0.5em 0.5em 2em;
			}
			ul li, ol li {
				line-height: 1.5;
				padding: 0.5em 0;
			}
		</style>
		<h1>HTMLの基礎</h1>
		<ul>
			<li>ホーム</li>
			<li>会社案内</li>
			<li>アクセス</li>
			<li>お問い合わせ</li>
		</ul>
		<p>
			HTMLの基礎を勉強しています。<br>
			HTMLの基礎を勉強しています。<br>
			HTMLの基礎を勉強しています。
		</p>
				""";
		return result;
	}
}
