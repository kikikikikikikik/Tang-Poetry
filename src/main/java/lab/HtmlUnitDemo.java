package lab;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HtmlUnitDemo {
    public static void main(String[] args) throws IOException {
        //无界面的浏览器（HTTP客户端）
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //关闭流浏览器的css执行引擎，不再执行网页中的 css 脚本
        webClient.getOptions().setCssEnabled(false);
        //关闭浏览器的js引擎，不再执行网页中的 js 脚本
        webClient.getOptions().setJavaScriptEnabled(false);
        HtmlPage page = webClient.getPage("https://so.gushiwen.org/gushi/tangshi.aspx");
        //System.out.println(page);
    }
}
