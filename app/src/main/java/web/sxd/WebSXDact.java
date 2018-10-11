package web.sxd;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.hi.sxd.R;

import java.util.ArrayList;
import java.util.HashSet;

import web.sxd.b.Platform2Url;

public class WebSXDact extends AppCompatActivity {

    final Activity activity = this;//a

    private WebView webView;//Fate
    private AutoCompleteTextView textView;//c
    private boolean isExit;
    private boolean e;
    private String lru;
    private boolean g;

    @Override
    protected void onCreate(Bundle bundle) {
        SharedPreferences sharedpreferences;
        ArrayList arraylist;
        super.onCreate(bundle);
        //requestWindowFeature(Window.FEATURE_ACTION_BAR)
        activity.setTitle("aWebSXD_dev");
        //getWindow().requestFeature(2);
        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_main);
        e = false;
        isExit = false;
        g = false;
        lru = null;
        textView = (AutoCompleteTextView)findViewById(R.id.testView);
        textView.setOnEditorActionListener(new WebSXDEditorActionListener(this));
        textView.setOnItemClickListener(new WebSXDItemClickListener(this));
        textView.setOnFocusChangeListener(new WebSXDFocusChangeListener(this));
        webView = (WebView)findViewById(R.id.webView);
        //webView.getSettings().setPluginsEnabled(false);
        //支持javascript
        webView.getSettings().setJavaScriptEnabled(true);
        // 设置可以支持缩放
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setDomStorageEnabled(true);
        //自适应屏幕
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.addJavascriptInterface(new JSInterface(), "asxd");
        webView.setWebChromeClient(new WebSXDWebChromeClient(this));
        webView.setWebViewClient(new WebSXDWebViewClient(this));
        webView.setInitialScale(100);
        sharedpreferences = activity.getPreferences(0);
        String url =sharedpreferences.getString("web.sxd.URL", "http://baidu.com");
        //textView.setText(url);
        //webView.loadUrl(url);
        webView.loadUrl("http://sxd.xd.com");
        webView.requestFocusFromTouch();

//        arraylist = new ArrayList();
//        textView.setAdapter(new ArrayAdapter(a,"",arraylist));
//        webView.loadUrl("http://www.baidu.com");
//        webView.requestFocusFromTouch();
//        for (String d:sharedpreferences.getAll().keySet()
//             ) {
//            bundle.putString(d,sharedpreferences.getString(d,""));
//        }
//        Iterator<String> list = sharedpreferences.getAll().keySet().iterator();
        //Iterator<String> data  = sharedpreferences.getAll().keySet().iterator();
        //savedInstanceState = sharedpreferences.getAll().keySet().iterator().;
        //setContentView(R.layout.activity_main);

        //4868623@s1370.sxd.xd.com
//        while(list.hasNext())
//        {
//            Object obj = (String)list.next();
//            if(((String) (obj)).contains("@") && (((String) (obj)).contains("S") || ((String) (obj)).endsWith("/")))
//                arraylist.add(obj);
//        }
//        if(arraylist.size() <= 0)
//        {
//            list = sharedpreferences.getAll().keySet().iterator();
//            if(!list.hasNext())
//            {
//                c.setAdapter(new ArrayAdapter(a, 0x109000a, arraylist));
//                Object obj = getIntent();
//                bundle = ((Intent) (obj)).getStringExtra("web.sxd.URL");
//                int i1;
//                int j1;
//                String s1;
//                if(bundle == null)
//                {
//                    bundle = sharedpreferences.getString("web.sxd.URL", "http://baidu.com");
//                    f = sharedpreferences.getString("web.sxd.LRU", null);
//                    c.setText(bundle);
//                } else
//                {
//                    f = ((Intent) (obj)).getStringExtra("web.sxd.LRU");
//                }
//                Fate.loadUrl(bundle);
//                Fate.requestFocusFromTouch();
//                return;
//            }
//            break MISSING_BLOCK_LABEL_661;
//        }else
//        {
//            android.content.SharedPreferences.Editor editor;
//            Iterator iterator;
//            editor = sharedpreferences.edit();
//            iterator = arraylist.iterator();
//            while(iterator.hasNext())
//            {
//                String s = (String)iterator.next();
//                s1 = sharedpreferences.getString(s, "");
//                System.out.println((new StringBuilder(String.valueOf(s))).append(" = ").append(s1).toString());
//                if(s1.length() == 0)
//                {
//                    editor.remove(s);
//                } else
//                {
//                    i1 = s.indexOf('S');
//                    boolean flag;
//                    if(i1 > 0)
//                    {
//                        bundle = (new StringBuilder(String.valueOf(s.substring(0, i1)))).append("s").append(s.substring(i1 + 1)).toString();
//                        flag = true;
//                    } else
//                    {
//                        flag = false;
//                        bundle = s;
//                    }
//                    j1 = bundle.length() - 1;
//                    obj = bundle;
//                    if(bundle.charAt(j1) == '/')
//                    {
//                        obj = bundle.substring(0, j1);
//                        flag = true;
//                    }
//                    if(flag)
//                    {
//                        editor.remove(s);
//                        editor.putString(((String) (obj)), s1);
//                    }
//                }
//            }
//            editor.commit();
//            arraylist.clear();
//        }

    }

    /*
    * 返回键两次退出
    * */
    @Override
    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if(i1 == KeyEvent.KEYCODE_BACK)
        {
            if(!isExit)
            {
                if(webView.canGoBack())
                {
                    isExit = false;
                    webView.goBack();
                    if(!e)
                        return true;
                    if(webView.canGoBack())
                    {
                        webView.goBack();
                        return true;
                    }
                }
                isExit = true;
                Toast.makeText(activity, "再按一次返回键退出",Toast.LENGTH_SHORT).show();
                return false;
            } else
            {
                return super.onKeyDown(i1, keyevent);
            }
        } else
        {
            isExit = false;
            return false;
        }
    }



    static void setFlag(WebSXDact websxdact, boolean flag)
    {
        websxdact.e = flag;
    }

    static void cannelExit(WebSXDact websxdact)
    {
        websxdact.isExit = false;
    }
    static void e(WebSXDact websxdact)
    {
        websxdact.g = true;
    }

    /*
    * 加载网页
    * */
    public void bLoaded(View view)
    {
//        Toast.makeText(activity, "loading",Toast.LENGTH_SHORT).show();
//        webView.loadUrl("http://www.baidu.com");
//        webView.requestFocusFromTouch();
//        return;
        String viewString;
        boolean flag;
        String s;
        flag = true;
        s = textView.getText().toString();
        if(s.length() != 0)
        {
            isExit = false;
            ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), 0);
            int i1;
            if(s.indexOf('.') > 0 && s.charAt(0) == 's' && s.charAt(1) >= '0' && s.charAt(1) <= '9')
                i1 = 1;
            else
                i1 = 0;
            int j1;
            String s1;
            if(g && s.startsWith("sx"))
            {

                HashSet hashset;

                String as[];
                if(s.indexOf('.') > 0 && s.charAt(0) == 's' && s.charAt(2) >= '0' && s.charAt(2) <= '9')
                    i1 = 1;
                else
                    i1 = 0;
                int k1;
                String s2;
                String s3;
                if(i1 != 0)
                    viewString = s.replace(".game.ledu.com", ".ledu.com");
                else
                    viewString =  s;
            } else
            {
                viewString = s;
            }
            j1 = i1;
            if(g)
            {
                j1 = i1;
                if(viewString.startsWith("http://sx"))
                    if(viewString.indexOf('.') > 0 && viewString.charAt(7) == 's' && viewString.charAt(9) >= '0' && viewString.charAt(9) <= '9')
                        j1 = 1;
                    else
                        j1 = 0;
            }
            if(viewString.startsWith("sxd"))
                if(viewString.indexOf('.') > 0 && viewString.charAt(0) == 's' && viewString.charAt(3) >= '0' && viewString.charAt(3) <= '9')
                    j1 = 1;
                else
                    j1 = 0;
            i1 = viewString.indexOf('@');
            if(i1 <= 0){}else {
                s1 = activity.getPreferences(0).getString(viewString, "");
                s = (new StringBuilder("http://")).append(viewString.substring(i1 + 1)).toString();
                viewString = s;
                i1 = ((flag) ? 1 : 0);

                if (s1.length() <= 0) {
                    textView.dismissDropDown();
                    textView.setText(viewString);
                    webView.loadUrl(viewString);
                    webView.requestFocusFromTouch();
                    if (i1 != 0) {
                        lru = viewString;
                        return;
                    }
                } else {
                    CookieManager cookie = CookieManager.getInstance();
                    System.out.println((new StringBuilder(String.valueOf(s))).append(" = ").append(cookie.getCookie(s)).toString());
                    System.out.println((new StringBuilder(String.valueOf(s))).append(" = ").append(s1).toString());
                    HashSet hashset = new HashSet();
                    String[] as = s1.replace(" ", "").split(";");
                    j1 = as.length;
                    i1 = 0;
                }
            }
            webView.loadUrl(Platform2Url.getUrl(s));
        }else
        {
            webView.requestFocusFromTouch();
        }
        return;
    }
    static AutoCompleteTextView getAutoCompleteTextView(WebSXDact websxdact)
    {
        return websxdact.textView;
    }
    static WebView getWebView(WebSXDact websxdact)
    {
        return websxdact.webView;
    }
    static String getLRU(WebSXDact websxdact)
    {
        return websxdact.lru;
    }
    static void setLRU(WebSXDact websxdact, String s)
    {
        websxdact.lru = s;
    }
    private class JSInterface
    {
        @JavascriptInterface
        public void recall(String s, String s1)
        {
            WebSXDact.getAutoCompleteTextView(a).dismissDropDown();
            System.err.println((new StringBuilder(String.valueOf(s))).append("\n").append(s1).toString());
            String s2 = WebSXDact.getLRU(a);//WebSXDact.getWebView(a).getUrl();//WebSXDact.getLRU(a);//getWebView(a).getUrl();
            Object obj = new Intent(a.activity, LoginAct.class);
            ((Intent) (obj)).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//(0x4000000);
            ((Intent) (obj)).putExtra("web.sxd.LRU", WebSXDact.getLRU(a));
            ((Intent) (obj)).putExtra("web.sxd.URL", s2);
            ((Intent) (obj)).putExtra("web.sxd.SWF", s);
            ((Intent) (obj)).putExtra("web.sxd.VAR", s1);
            LoginAct.m = false;
            a.startActivity(((Intent) (obj)));
            obj = a.activity.getPreferences(0).edit();
            ((android.content.SharedPreferences.Editor) (obj)).putString("web.sxd.LRU", WebSXDact.getLRU(a));
            ((android.content.SharedPreferences.Editor) (obj)).putString("web.sxd.URL", s2);
            if(s2.startsWith("http://"))
            {
                int i1 = s1.indexOf("player_name=") + 12;
                String s3 = s1.substring(i1, s1.indexOf('&', i1));
                String s4 = CookieManager.getInstance().getCookie(s2);
                s1 = s2.substring(7).toLowerCase();
                i1 = s1.length() - 1;
                s = s1;
                if(s1.charAt(i1) == '/')
                    s = s1.substring(0, i1);
                ((android.content.SharedPreferences.Editor) (obj)).putString((new StringBuilder(String.valueOf(s3))).append("@").append(s).toString(), s4);
            }
            ((android.content.SharedPreferences.Editor) (obj)).commit();
            a.activity.finish();
        }

        final WebSXDact a;

        JSInterface()
        {
            super();
            a = WebSXDact.this;

        }
    }


}
