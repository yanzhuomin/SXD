// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:37
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd;

import web.sxd.b.BaseFunc;

// Referenced classes of package web.sxd:
//            LoginAct

//等待40s 返回上一界面重新登陆
final class dThread extends Thread
{

    dThread(LoginAct loginact)
    {
        super();
        a = loginact;
    }

    public final void run()
    {
        BaseFunc.a(200);
        if(LoginAct.d())
            a.returnWebSXD();
    }

    final LoginAct a;
}