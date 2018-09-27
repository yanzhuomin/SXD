// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:38
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.AutoCompleteTextView;
import java.io.PrintStream;

// Referenced classes of package web.sxd:
//            WebSXDact

final class WebSXDWebChromeClient extends WebChromeClient
{

    WebSXDWebChromeClient(WebSXDact websxdact)
    {
        super();
        a = websxdact;

    }

    public final void onCloseWindow(WebView webview)
    {
        a.activity.setTitle("Closed");
    }

    public final void onProgressChanged(WebView webview, int i)
    {
        a.activity.setProgress(i * 100);
    }

    public final void onReceivedIcon(WebView webview, Bitmap bitmap)
    {
        System.err.println((new StringBuilder(String.valueOf(bitmap.getWidth()))).append("x").append(bitmap.getHeight()).append("@").append(bitmap.getDensity()).toString());
        WebSXDact.getAutoCompleteTextView(a).setCompoundDrawables(new BitmapDrawable(a.activity.getResources(), bitmap), null, null, null);
    }

    public final void onReceivedTitle(WebView webview, String s)
    {
        a.activity.setTitle(s);
    }

    public final void onRequestFocus(WebView webview)
    {
        System.err.println("x");
        webview.requestFocusFromTouch();
    }

    final WebSXDact a;
}