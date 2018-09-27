// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:37
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;
import web.sxd.b.MainThread;
import web.sxd.d.m;

// Referenced classes of package web.sxd:
//            LoginAct

final class LoginClickListener
    implements DialogInterface.OnClickListener
{

    LoginClickListener(LoginAct loginact)
    {
        super();
        a = loginact;
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        StringBuilder select = new StringBuilder();
        i = 0;
        do
        {
            if(i >= LoginAct.getFuncCount())
            {
                SharedPreferences.Editor editor = a.a.getPreferences(0).edit();
                editor.putString("web.sxd.VAR", select.toString());
                editor.commit();
                Log.i("LoginAct", (new StringBuilder("Disabled: ")).append(select.toString()).toString());
                Toast.makeText(a.a, "保存成功，重启设置生效", Toast.LENGTH_SHORT).show();
                return;
            }
            int j = m.a[i];
            boolean flag;
            if(LoginAct.m(a)[i])
                flag = false;
            else
                flag = true;
            MainThread.setFuncSelect(j, flag);
            if(!LoginAct.m(a)[i])
            {
                if(select.length() > 0)
                    select.append(';');
                select.append(m.a[i]);
            }
            i++;
        } while(true);
    }

    final LoginAct a;
}