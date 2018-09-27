// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:37
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd;

import web.sxd.b.h;

// Referenced classes of package web.sxd:
//            LoginAct

final class dThread extends Thread
{

    dThread(LoginAct loginact)
    {
        super();
        a = loginact;
    }

    public final void run()
    {
        h.a(200);
        if(LoginAct.d())
            a.a();
    }

    final LoginAct a;
}