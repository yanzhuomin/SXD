// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:37
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd;

import android.os.Process;

// Referenced classes of package web.sxd:
//            LoginAct

final class ExitThread extends Thread
{

    ExitThread(LoginAct loginact)
    {
        super();
        a = loginact;
    }

    public final void run()
    {
        try
        {
            Thread.sleep(1800L);
        }
        catch(InterruptedException interruptedexception) { }
        Process.killProcess(Process.myPid());
    }

    final LoginAct a;
}