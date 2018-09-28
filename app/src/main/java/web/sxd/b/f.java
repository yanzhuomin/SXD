// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:44
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.b;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

// Referenced classes of package web.sxd.b:
//            l, c, b, g
/**
 * 全网信息读取
 *
 * */
final class f extends Thread
{

    public f(MainThread c1, InputStream inputstream)
    {
        super();
        a = c1;
        b = inputstream;
    }

    public final void run()
    {
        try {
            byte abyte0[] = TempDataInputStream.a(b);
            while (true) {
                if (MainThread.b(a) && abyte0 != null) {
                    MainThread.f(MainThread.t() + (long) (abyte0.length + 4));
                    web.sxd.b.TimeOutThread.clear();
                    (new g(a, abyte0)).start();
                    abyte0 = TempDataInputStream.a(b);
                } else {
                    MainThread.g(a).close();
                    MainThread.f(a);
                    MainThread.sendLog("[全网]连接已中断");
                    return;
                }

            }
        } catch (IOException e) {
            Log.e("PktThread_St", e.getLocalizedMessage());
            MainThread.f(a);
            MainThread.sendLog("[全网]连接已中断");
            return;
        }
//        byte abyte0[] = TempDataInputStream.a(b);
//_L2:
//        if(c.b(a) && abyte0 != null)
//            break MISSING_BLOCK_LABEL_45;
//        c.g(a).close();
//        c.f(a);
//        c.a("[全网]连接已中断");
//        return;
//        c.f(c.t() + (long)(abyte0.length + 4));
//        web.sxd.b.TimeOutThread.clear();
//        (new g(a, abyte0)).start();
//        abyte0 = TempDataInputStream.a(b);
//        if(true) goto _L2; else goto _L1
//_L1:
//        Object obj;
//        obj;
//        Log.e("PktThread_St", ((IOException) (obj)).getLocalizedMessage());
//        c.f(a);
//        c.a("[全网]连接已中断");
//        return;
//        obj;
//        c.f(a);
//        c.a("[全网]连接已中断");
//        throw obj;
    }

    final MainThread a;
    private InputStream b;
}