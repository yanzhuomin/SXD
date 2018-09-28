//// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:38
//// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
//// Decompiler options: packimports(3)
//
package web.sxd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hi.sxd.R;

import java.io.IOException;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.ArrayList;

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
    private static final int F;//所有功能个数
    static boolean m;
    private Handler handler;//消息上下文
    private boolean C;
    private Socket socket; //主界面Socket
    private MainThread thread;
    private boolean funcSelect[];//功能选择标志  选择：true 未选择： false
    final Activity a = this;
    ArrayList b;
    View c;
    View d;
    AutoCompleteTextView e;
    TextView textView_configName;//根据版本号而来
    TextView textView_ip;
    TextView textView_port;
    TextView textView_playerName;
    TextView j;  //log TextView
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
        funcSelect = new boolean[F];
    }

    static MainThread getMainThread(LoginAct loginact)
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

    static void c()
    {
        B = true;
    }

    static String getHasCode(LoginAct loginact)
    {
        return loginact.hash_code;
    }

    static boolean d()
    {
        return B;
    }

    //功能个数
    static int getFuncCount()
    {
        return F;
    }

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

    static void l(LoginAct loginact)
    {
        loginact.C = true;
    }

    static boolean[] m(LoginAct loginact)
    {
        return loginact.funcSelect;
    }


    //返回到 WebSXDact 那个Activity
    public final void returnWebSXD()
    {
        B = true;
        m = true;
        Intent intent = new Intent(a, WebSXDact.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("web.sxd.LRU", lru);
        intent.putExtra("web.sxd.URL", url);
        startActivity(intent);
    }

    //断开连接
    public final void disconnect()
    {
        if(thread != null)
        {
            web.sxd.b.MainThread.sendLog(1, null);
            thread.quit();
            thread = null;
        }
        if(socket != null) {
            //break MISSING_BLOCK_LABEL_99;
            Toast.makeText(a, "断开登陆连接", Toast.LENGTH_SHORT).show();
            try {
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            socket = null;
        }
        button_login.setText("刷新");
        if(!web.sxd.b.MainThread.isFuncSelect(12) && m)
        {
            web.sxd.b.MainThread.sendLog("已开启自动重连，40秒后尝试登录……");
            B = true;
            (new dThread(this)).start();
        }
        return;
    }

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
                new ConnectThread(this).start();
                return;
            }
        }else
        {
            if(socket == null)
            {
                returnWebSXD();
                return;
            }else
            {
                B = false;
                m = false;
                web.sxd.b.MainThread.sendLog(-1, null);
                return;
            }
        }

    }

    public void bQuited(View view)
    {
        B = false;
        a.finish();
        (new ExitThread(this)).start();
    }

    public void bRelogined(View view)
    {
        Intent intent = new Intent(this, WebSXDact.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//V0x4000000);
        intent.putExtra("web.sxd.URL", "http://baidu.com");
        startActivity(intent);
    }

    public void bSetting(View view)
    {
        int i1 = 0;
        do
        {
            if(i1 >= F)
            {
                (new android.app.AlertDialog.Builder(this))
                        .setTitle("请选中需要的功能")
                        .setMultiChoiceItems(web.sxd.c.c.a, funcSelect,
                                new LoginMultiChoiceClickListener(this))
                        .setPositiveButton("\u786E\u5B9A", new LoginClickListener(this))
                        .setNegativeButton("\u53D6\u6D88", null).show();
                return;
            }
            //view = G;
            byte byte0;
            if(web.sxd.b.MainThread.isFuncSelect(web.sxd.d.m.a[i1]))
                funcSelect[i1] = false;
            else
                funcSelect[i1] = true;
            i1++;
        } while(true);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().requestFeature(2);
        handler = new web.sxd.LoginHandler(this, a);
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

                if(swf.contains("txwy"))
                    cur_ver = (new StringBuilder(String.valueOf(cur_ver))).append("tw").toString();
                else
                if(swf.contains("/app"))
                    cur_ver = (new StringBuilder(String.valueOf(cur_ver))).append("qq").toString();
                cur_ver = (new StringBuilder(String.valueOf(cur_ver))).append(".ini").toString();
                textView_configName.setText(cur_ver);

                web.sxd.b.MainThread.setHandler(handler);
                web.sxd.b.MainThread.sendLog(0, 0);

                try
                {
                    web.sxd.b.MainThread.a(a.getAssets().open(cur_ver));
                    j.append("\t\t协议匹配成功, 请登录");
                }
                catch(IOException ioexception)
                {
                    j.append("\t\t协议匹配失败, 请更新 或尝试强行登录");
                }

                C = false;
                if(B)
                {
                    B = false;
                    bLogined(button_login);
                    return;
                }

                //读取功能设置
                String as[];
                int j1=0,k1;
                String s1,s2;
                s1 = a.getPreferences(0).getString("web.sxd.VAR", "");
                Log.i("LoginAct", (new StringBuilder("Disabled: ")).append(s1).toString());
                as = s1.split(";");
                k1 = as.length;
                while(j1 < k1)
                {
                    s2 = as[j1];
                    try
                    {
                        web.sxd.b.MainThread.setFuncSelect(Integer.valueOf(s2).intValue(), true);
                    }
                    catch(NumberFormatException numberformatexception)
                    {

                    }
                    j1++;
                }
                j.append(web.sxd.c.c.a());//显示功能设置中禁用的功能


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


    static
    {
        F = web.sxd.d.m.a.length;
    }
}