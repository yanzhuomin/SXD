// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:38
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd;

import android.annotation.SuppressLint;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import java.io.PrintStream;


// Referenced classes of package web.sxd:
//            WebSXDact

final class WebSXDWebViewClient extends WebViewClient
{

    WebSXDWebViewClient(WebSXDact websxdact)
    {
        super();
        a = websxdact;

    }

    public final void onLoadResource(WebView webview, String s)
    {
        boolean flag;
        String s1;
        flag = false;
        s1 = s;
        if(s.startsWith("/"))
        {
            s1 = webview.getUrl().substring(7);
            s1 = (new StringBuilder(String.valueOf(s1.substring(0, s1.indexOf('/'))))).append(s).toString();
        }
        if(s1.indexOf("sxd.xd.com%2Fbaidu%2Fsxd%2Fconversion%2F&dr=") > 0 && WebSXDact.getLRU(a) == null && s1.indexOf("ledu.com") <= 0)
        {
            s1.indexOf("sxd.xd.com%2Fbaidu%2Fsxd%2Fconversion%2F&dr=");
            WebSXDact.setLRU(a, s1.substring(s1.indexOf("sxd.xd.com%2Fbaidu%2Fsxd%2Fconversion%2F&dr=") + 54));
            WebSXDact.setLRU(a, WebSXDact.getLRU(a).substring(0, WebSXDact.getLRU(a).indexOf("&")));
            WebSXDact.setLRU(a, WebSXDact.getLRU(a).replace("%3A", ":"));
            WebSXDact.setLRU(a, WebSXDact.getLRU(a).replace("%2F%2F", "//"));
            WebSXDact.setLRU(a, WebSXDact.getLRU(a).replace("%2F", ""));
            WebSXDact.getWebView(a).stopLoading();
            WebSXDact.getAutoCompleteTextView(a).setText(WebSXDact.getLRU(a));
            WebSXDact.getWebView(a).loadUrl(WebSXDact.getLRU(a));
            a.bLoaded(WebSXDact.getWebView(a));
        }
        return;
    }

    public final void onPageFinished(WebView webview, String s)
    {
        if(!s.equals(b))
        {
            WebSXDact.setFlag(a, false);
            b = null;
            if(WebSXDact.getLRU(a) != null)
            {
                System.err.println((new StringBuilder("$_")).append(s).append(" # ").append(WebSXDact.getLRU(a)).toString());
                int i = s.indexOf('/', 7);
                String s1 = s;
                if(i > 0)
                    s1 = s.substring(0, i);
                if(WebSXDact.getLRU(a).startsWith(s1))
                {
                    WebSXDact.getAutoCompleteTextView(a).dismissDropDown();
                    WebSXDact.getAutoCompleteTextView(a).setText(s1);
                    webview.requestFocusFromTouch();
                    webview.loadUrl("javascript:window.asxd.recall(swf,flashVars)");
                    return;
                }
                i = WebSXDact.getLRU(a).indexOf('/', 7);
                if(i > 0)
                {
                    s = WebSXDact.getLRU(a).substring(0, i);
                    if(s.endsWith(".baidu.sxd.xd.com") || s.endsWith("Notify.iqiyi.com/shenxiandao") || s.endsWith(".sxd.wan.sogou.com"))
                    {
                        WebSXDact.setLRU(a, s);
                        webview.loadUrl(s);
                        System.out.println((new StringBuilder("rl1:")).append(WebSXDact.getLRU(a)).toString());
                        return;
                    }
                }
            }
        }
    }

    @SuppressLint("WrongConstant")
    public final void onReceivedError(WebView webview, int i, String s, String s1)
    {
        b = s1;
        System.err.println((new StringBuilder(String.valueOf(s))).append(i).append(s1).toString());
        webview.loadData(s,"text/html","utf-8");// = s;
        if(i == -2)
        {
            WebSXDact.setFlag(a, true);
            webview .loadData (new StringBuilder(String.valueOf(s)).append("，请检查手机网络是否开启").toString(),
                    "text/html","utf-8");
        }
        Toast.makeText(a.activity, (new StringBuilder("Err")).append(i).append(webview).toString(), 0).show();
    }

    @Override
    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        WebSXDact.cannelExit(a);
        if(s.contains("/login_api.php?"))
        {
            WebSXDact.setLRU(a, s);
            System.err.println((new StringBuilder("^_")).append(s).toString());
        }
        if(!s.startsWith("about:blank") && !s.endsWith("youxi.baidu.com/") && !s.endsWith("/login.do?gid=&sid=") && !s.endsWith("www.sogou.com/"))
        {
            if(s.indexOf("iqiyi") > 0)
                webview.loadUrl(s.replace("login/iframe_page_web/top", "togame/entry_web"));
            else
            if(s.indexOf("4399.com/yxsxd/tpl-") > 0)
                webview.loadUrl(s.replace("game.iwan4399.com", "my.4399.com").replace("tpl-sid-", "play?sid=").replace("-site-", "&site=").replace("-channel-", "&channel=").replace("-randsj-", "&randsj="));
            else
            if(s.indexOf("qq833") > 0)
                webview.loadUrl(s.replace("play", "play/game"));
            else
            if(s.endsWith(".game.ledu.com/") || s.endsWith(".game.ledu.com"))
            {
                WebSXDact.getAutoCompleteTextView(a).setText(s);
                s = s.replace(".game.ledu.com/", ".ledu.com").replace(".game.ledu.com", ".ledu.com");
                webview.loadUrl(s);
                WebSXDact.e(a);
            } else
            {
                webview.loadUrl(s);
            }
            System.out.println((new StringBuilder("rl3:")).append(s).toString());
        }
        //webview.loadUrl(s);
        return true;
    }

    final WebSXDact a;
    private String b;
}