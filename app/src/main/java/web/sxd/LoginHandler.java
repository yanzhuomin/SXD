// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:37
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd;

import android.app.Activity;
import android.content.SharedPreferences;
import android.text.Editable;
import android.widget.EditText;
import web.sxd.b.BaseHandler;
//import web.sxd.d.y;

// Referenced classes of package web.sxd:
//            LoginAct, Fate

//LoginAct 的Handler 用来接收其他线程的数据更新UI
final class LoginHandler extends BaseHandler
{

    LoginHandler(LoginAct loginact, Activity activity)
    {
        super(activity);
        a = loginact;

    }

    static LoginAct a(LoginHandler a1)
    {
        return a1.a;
    }

    @Override
    protected final void a()
    {
        a.disconnect();
    }

    protected final void a(String s)
    {
        a.j.append(s);
        //a.j.getText().append(s);
    }

    protected final void b()
    {
        LoginAct.c();
        (new bThread(this)).start();
    }

    protected final void b(String s)
    {
        Object obj = null;
        SharedPreferences sharedpreferences = a.a.getPreferences(0);
        String s1 = sharedpreferences.getString("web.sxd.SWF", null);
        if(s1 == null || s1.length() > 0)
            obj = s1;
        if(obj != null && s != null)
            return;
        if(obj != null || s == null)
            try
            {

                //TODO  [阵型]恢复  暂时注释
                //y.a(LoginAct.getMainThread(a), ((String) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch(Exception e)
            {
                ((Exception) (e)).printStackTrace();
            }
        obj = sharedpreferences.edit();
        if(s != null && s.length() > 0)
            ((SharedPreferences.Editor) (obj)).putString("web.sxd.SWF", s);
        else
            ((SharedPreferences.Editor) (obj)).remove("web.sxd.SWF");
        ((SharedPreferences.Editor) (obj)).commit();
    }

    protected final void c()
    {
        a.a.setTitle(LoginAct.getServerName(a));
    }

    protected final boolean c(String s)
    {
        a.textView_configName.setText(s);
        return LoginAct.m;
    }

    final LoginAct a;
}