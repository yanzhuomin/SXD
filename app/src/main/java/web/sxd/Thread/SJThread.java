// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:44
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.Thread;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;


import web.sxd.base.TempDataInputStream;



// Referenced classes of package web.sxd.Fate:
//            l, c, Fate, Notify

/**
 * 仙界通信线程
 *
 * */
final class SJThread extends Thread
{

    public SJThread(MainThread c1, InputStream inputstream)
    {
        super();
        a = c1;
        b = inputstream;
    }

    @Override
    public final void run() {
        try {
            byte abyte0[] = TempDataInputStream.Read(b);
            while (true) {
                if (MainThread.isRun(a) && abyte0 != null) {
                    MainThread.setXJStatistics(MainThread.getXJStatistics() + (long) (abyte0.length + 4));//更新流量使用情况
//                    TimeOutThread.clear();
                    (new ProcessThread(a, abyte0)).start();
                    abyte0 = TempDataInputStream.Read(b);
                } else {
                    MainThread.getXJSocket(a).close();
                    MainThread.clearXJSocket(a);
                    MainThread.sendLog("[仙界]连接已中断");
                    return;
                }

            }
        } catch (IOException e) {
            Log.e("PktThread_St", e.getLocalizedMessage());
            MainThread.clearXJSocket(a);
            MainThread.sendLog("[仙界]连接已中断");
            return;
        }
    }

    final MainThread a;
    private InputStream b;
}