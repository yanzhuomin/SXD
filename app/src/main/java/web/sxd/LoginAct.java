//// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:38
//// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
//// Decompiler options: packimports(3)
//
package web.sxd;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hi.sxd.R;

import java.io.IOException;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import web.sxd.b.MainThread;
import web.sxd.b.VarSplit;
//import web.sxd.c.a;
//import web.sxd.d.m;

// Referenced classes of package web.sxd:
//            WebSXDact, d, e, h,
//            f, g, a, c

public class LoginAct extends AppCompatActivity
{

    private static boolean B;
    //private static final int F;
    static boolean m;
    //private Handler A;
    private boolean C;
    private Socket socket;
    private MainThread thread;
    //private boolean G[];
    final Activity a = this;
    ArrayList b;
    View c;
    View d;
    AutoCompleteTextView e;
    TextView textView_configName;
    TextView textView_ip;
    TextView textView_port;
    TextView textView_playerName;
    TextView j;
    CheckBox k;
    Button button_login;
    private String swf; //JS中swf变量内容
    private String var;//JS中flashvar变量内容
    private String lru;//lru
    private String url;//url
    private String now_time;//登陆时间
    private String hash_code;//哈希
    private String cur_ver;//当前版本
    private String stage;//平台：心动 360 搜狗
    private String client;//客户端 web
    private String server_name;//服务器名
    private int regdate;//账号注册时间
    private int open_time;//开服时间
    private int is_newst;


    public LoginAct()
    {
        server_name = " - aWebSXD_dev";
        C = true;
        socket = null;
        thread = null;
        //G = new boolean[F];
    }

    static MainThread a(LoginAct loginact)
    {
        return loginact.thread;
    }

    static void setSocket(LoginAct loginact, Socket socket)
    {
        loginact.socket = socket;
    }

    static void setMainThread(LoginAct loginact, MainThread c1)
    {
        loginact.thread = c1;
    }

    static String getServerName(LoginAct loginact)
    {
        return loginact.server_name;
    }

    static Socket getSocket(LoginAct loginact)
    {
        return loginact.socket;
    }

//    static void c()
//    {
//        B = true;
//    }

    static String getHasCode(LoginAct loginact)
    {
        return loginact.hash_code;
    }

//    static boolean d()
//    {
//        return B;
//    }
//
//    static int e()
//    {
//        return F;
//    }

    static String getNowTime(LoginAct loginact)
    {
        return loginact.now_time;
    }

    static int getRegDate(LoginAct loginact)
    {
        return loginact.regdate;
    }

    static int getOpenTime(LoginAct loginact)
    {
        return loginact.open_time;
    }

    static int getNewst(LoginAct loginact)
    {
        return loginact.is_newst;
    }

    static String getStage(LoginAct loginact)
    {
        return loginact.stage;
    }

    static String getCurVer(LoginAct loginact)
    {
        return loginact.cur_ver;
    }

    static String getClient(LoginAct loginact)
    {
        return loginact.client;
    }

//    static void l(LoginAct loginact)
//    {
//        loginact.C = true;
//    }
//
//    static boolean[] m(LoginAct loginact)
//    {
//        return loginact.G;
//    }

    public final void a()
    {
        B = true;
        m = true;
        Intent intent = new Intent(a, WebSXDact.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("web.sxd.LRU", lru);
        intent.putExtra("web.sxd.URL", url);
        startActivity(intent);
    }

//    public final void b()
//    {
//        if(E != null)
//        {
//            web.sxd.b.c.a(1, null);
//            E.q();
//            E = null;
//        }
//        if(D == null)
//            break MISSING_BLOCK_LABEL_99;
//        Toast.makeText(a, 0x7f040010, 0).show();
//        D.close();
//        D = null;
//        l.setText(0x7f040005);
//        if(!web.sxd.b.c.c(12) && m)
//        {
//            web.sxd.b.c.a("\u5DF2\u5F00\u542F\u81EA\u52A8\u91CD\u8FDE\uFF0C40\u79D2\u540E\u5C1D\u8BD5\u767B\u5F55\u2026\u2026");
//            B = true;
//            (new d(this)).start();
//        }
//_L2:
//        return;
//        Object obj;
//        obj;
//        Log.v("LoginAct", ((IOException) (obj)).getLocalizedMessage(), ((Throwable) (obj)));
//        D = null;
//        l.setText(0x7f040005);
//        if(web.sxd.b.c.c(12) || !m) goto _L2; else goto _L1
//_L1:
//        web.sxd.b.c.a("\u5DF2\u5F00\u542F\u81EA\u52A8\u91CD\u8FDE\uFF0C40\u79D2\u540E\u5C1D\u8BD5\u767B\u5F55\u2026\u2026");
//        B = true;
//        (new d(this)).start();
//        return;
//        obj;
//        D = null;
//        l.setText(0x7f040005);
//        if(!web.sxd.b.c.c(12) && m)
//        {
//            web.sxd.b.c.a("\u5DF2\u5F00\u542F\u81EA\u52A8\u91CD\u8FDE\uFF0C40\u79D2\u540E\u5C1D\u8BD5\u767B\u5F55\u2026\u2026");
//            B = true;
//            (new d(this)).start();
//        }
//        throw obj;
//    }
//
//    public void bChatd(View view)
//    {
//        Object obj = e.getText();
//        if(((Editable) (obj)).length() <= 0) goto _L2; else goto _L1
//_L1:
//        String s1;
//        s1 = ((Editable) (obj)).toString();
//        ((Editable) (obj)).clear();
//        obj = E;
//        int i1;
//        if(k.isChecked())
//            i1 = 1;
//        else
//            i1 = 2;
//        web.sxd.c.a.a(((c) (obj)), i1, s1);
//        obj = b.iterator();
//_L5:
//        if(((Iterator) (obj)).hasNext()) goto _L4; else goto _L3
//_L3:
//        ((ArrayAdapter)e.getAdapter()).add(s1);
//_L2:
//        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
//        return;
//_L4:
//        boolean flag = ((String)((Iterator) (obj)).next()).equals(s1);
//        if(flag)
//            return;
//          goto _L5
//        IOException ioexception;
//        ioexception;
//          goto _L2
//    }

    public void bLogined(View view)
    {
        if(!C)
        {
            if(socket == null)
            {
                button_login.setEnabled(false);
                j.append("\n　正在连接服务器 ... ");
                //view.post(new e(this));
                return;
            }
        }else
        {
            if(socket == null)
            {
                a();
                return;
            }else
            {
                B = false;
                m = false;
                //web.sxd.b.c.a(-1, null);
                return;
            }
        }

    }

//    public void bQuited(View view)
//    {
//        B = false;
//        a.finish();
//        (new h(this)).start();
//    }

    public void bRelogined(View view)
    {
        Intent intent = new Intent(this, WebSXDact.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//V0x4000000);
        intent.putExtra("web.sxd.URL", "http://baidu.com");
        startActivity(intent);
    }

//    public void bSetting(View view)
//    {
//        int i1 = 0;
//        do
//        {
//            if(i1 >= F)
//            {
//                (new android.app.AlertDialog.Builder(this)).setTitle("\u8BF7\u9009\u4E2D\u9700\u8981\u7684\u529F\u80FD").setMultiChoiceItems(web.sxd.c.c.a, G, new f(this)).setPositiveButton("\u786E\u5B9A", new g(this)).setNegativeButton("\u53D6\u6D88", null).show();
//                return;
//            }
//            view = G;
//            byte byte0;
//            if(web.sxd.b.c.c(m.a[i1]))
//                byte0 = 0;
//            else
//                byte0 = 1;
//            view[i1] = byte0;
//            i1++;
//        } while(true);
//    }
//
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().requestFeature(2);
        //A = new web.sxd.a(this, a);
        setContentView(R.layout.activity_login);
        button_login = (Button)findViewById(R.id.button_login);
        button_login.requestFocusFromTouch();
        //c = findViewById(0x7f050000);
        //d = findViewById(R.id.textView_log);
        //c.setVisibility(8);
        //d.setVisibility(TextView.VISIBLE);
        textView_configName = (TextView)findViewById(R.id.textView_configName);
        textView_ip = (TextView)findViewById(R.id.textView_ip);
        textView_port = (TextView)findViewById(R.id.textView_port);
        textView_playerName = (TextView)findViewById(R.id.textView_playerName);
//        e = (AutoCompleteTextView)findViewById(0x7f050001);
//        k = (CheckBox)findViewById(0x7f050002);
//        b = new ArrayList();
//        e.setAdapter(new ArrayAdapter(a, 0x109000a, b));
//        e.setOnFocusChangeListener(new web.sxd.LoginFocusChangeListener(this));
        j = (TextView)findViewById(R.id.textView_log);
        if(bundle != null)
        {
            swf = bundle.getString("web.sxd.SWF");
            var = bundle.getString("web.sxd.VAR");
            url = bundle.getString("web.sxd.URL");
        } else
        {
            //bundle = getIntent();
            swf = getIntent().getStringExtra("web.sxd.SWF");
            var = getIntent().getStringExtra("web.sxd.VAR");
            lru = getIntent().getStringExtra("web.sxd.LRU");
            url = getIntent().getStringExtra("web.sxd.URL");
        }
        //bundle = j.getText();
        if(var != null)
        {
            VarSplit n1 = new VarSplit(var);
            stage = URLDecoder.decode(n1.Find("&stage=", "&"));
            if(stage.length() > 0)
                server_name = (new StringBuilder(" - ")).append(stage).toString();
            cur_ver = n1.Find("&cur_ver=", "&");
            server_name = (new StringBuilder(String.valueOf(n1.Find("server_name=", "&")))).append(server_name).toString();
            a.setTitle(server_name);
            client = n1.Find("&client=", "&");
            textView_ip.setText(n1.Find("ip=", "&"));
            textView_port.setText(n1.Find("port=", "&"));
            textView_playerName.setText(URLDecoder.decode(n1.Find("player_name=", "&")));
            hash_code = n1.Find("hash_code=", "&");
            now_time = n1.Find("&time=", "&");
            is_newst = Integer.valueOf(n1.Find("&is_newst=", "&")).intValue();
            regdate = Integer.valueOf(n1.Find("regdate=", "&")).intValue();
            open_time = Integer.valueOf(n1.Find("open_time=", "&")).intValue();
            int i1 = (Integer.valueOf(now_time).intValue() - open_time) / 3600;
            j.append(String.format("已开服: %d天 %d小时\n", new Object[] {
                Integer.valueOf(i1 / 24), Integer.valueOf(i1 % 24)
            }));
        }
        if(swf == null)
        {
            return;
        }else
        {
            j.append(swf.replace("/Index.swf", "/Main.swf"));
            if(cur_ver.length() > 0)
            {
                int j1;
                String as[];
                int k1;
                String s1;
                if(swf.contains("txwy"))
                    cur_ver = (new StringBuilder(String.valueOf(cur_ver))).append("tw").toString();
                else
                if(swf.contains("/app"))
                    cur_ver = (new StringBuilder(String.valueOf(cur_ver))).append("qq").toString();
                cur_ver = (new StringBuilder(String.valueOf(cur_ver))).append(".ini").toString();
                textView_configName.setText(cur_ver);
                s1 = a.getPreferences(0).getString("web.sxd.VAR", "");
                Log.i("LoginAct", (new StringBuilder("Disabled: ")).append(s1).toString());
                as = s1.split(";");
                k1 = as.length;
                j1 = 0;

//                if(j1 < k1)
//                    break label0;
//                web.sxd.b.c.a(A);
//                web.sxd.b.c.a(0, 0);
                String s2;
//                try
//                {
//                    //web.sxd.b.c.a(a.getAssets().open(cur_ver));
//                    j.append("\t\t协议匹配成功, 请登录");
//                }
//                catch(IOException ioexception)
//                {
//                    j.append("\t\t协议匹配失败, 请更新 或尝试强行登录");
//                }
                //j.append(web.sxd.c.c.a());
                C = false;
                if(B)
                {
                    B = false;
                    bLogined(button_login);
                    return;
                }

            }else
            {
                j.append("\t\t协议匹配失败, 请更新 或尝试强行登录");
                return;
            }
        }
    }

//    public void onDestroy()
//    {
//        b();
//        super.onDestroy();
//    }
//


//    static
//    {
//        F = m.a.length;
//    }
}