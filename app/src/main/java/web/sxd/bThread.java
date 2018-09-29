// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:37
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd;

import web.sxd.b.BaseFunc;

// Referenced classes of package web.sxd:
//            LoginAct, a

final class bThread extends Thread
{

    bThread(LoginHandler a1)
    {
        super();
        a = a1;
    }

    public final void run()
    {
        BaseFunc.a(10);
        if(LoginAct.d())
            web.sxd.LoginHandler.a(a).returnWebSXD();
    }

    final LoginHandler a;
}