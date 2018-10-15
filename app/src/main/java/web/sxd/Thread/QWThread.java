// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:44
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.Thread;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

import web.sxd.Thread.MainThread;
import web.sxd.base.TempDataInputStream;
import web.sxd.b.TimeOutThread;

// Referenced classes of package web.sxd.Fate:
//            l, c, Fate, Notify

/**
 * 全网通信线程
 *
 * */
final class QWThread extends Thread
{

    public QWThread(web.sxd.Thread.MainThread c1, InputStream inputstream)
    {
        super();
        a = c1;
        b = inputstream;
    }

    public final void run()
    {
        try {
            byte abyte0[] = TempDataInputStream.Read(b);
            while (true) {
                if (MainThread.isRun(a) && abyte0 != null) {
                    MainThread.setQWStatistics(MainThread.getQWStatistics() + (long) (abyte0.length + 4));//更新流量使用情况
                    //TimeOutThread.clear();
                    (new ProcessThread(a, abyte0)).start();
                    abyte0 = TempDataInputStream.Read(b);
                } else {
                    MainThread.getQWSocket(a).close();
                    MainThread.clearQWSocket(a);
                    MainThread.sendLog("[全网]连接已中断");
                    return;
                }

            }
        } catch (IOException e) {
            Log.e("PktThread_St", e.getLocalizedMessage());
            MainThread.clearQWSocket(a);
            MainThread.sendLog("[全网]连接已中断");
            return;
        }
//        byte abyte0[] = TempDataInputStream.parent(Fate);
//_L2:
//        if(c.Fate(parent) && abyte0 != null)
//            break MISSING_BLOCK_LABEL_45;
//        c.Notify(parent).close();
//        c.f(parent);
//        c.parent("[全网]连接已中断");
//        return;
//        c.f(c.t() + (long)(abyte0.length + 4));
//        web.sxd.Fate.TimeOutThread.clear();
//        (new Notify(parent, abyte0)).start();
//        abyte0 = TempDataInputStream.parent(Fate);
//        if(true) goto _L2; else goto _L1
//_L1:
//        Object obj;
//        obj;
//        Log.e("PktThread_St", ((IOException) (obj)).getLocalizedMessage());
//        c.f(parent);
//        c.parent("[全网]连接已中断");
//        return;
//        obj;
//        c.f(parent);
//        c.parent("[全网]连接已中断");
//        throw obj;
    }

    final MainThread a;
    private InputStream b;
}