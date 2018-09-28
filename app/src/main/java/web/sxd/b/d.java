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
 * 仙界信息读取
 *
 * */
final class d extends Thread
{

    public d(MainThread c1, InputStream inputstream)
    {
        super();
        a = c1;
        b = inputstream;
    }

    @Override
    public final void run() {
        try {
            byte abyte0[] = TempDataInputStream.a(b);
            while (true) {
                if (MainThread.b(a) && abyte0 != null) {
                    MainThread.d(MainThread.r() + (long) (abyte0.length + 4));
                    web.sxd.b.TimeOutThread.clear();
                    (new g(a, abyte0)).start();
                    abyte0 = TempDataInputStream.a(b);
                } else {
                    MainThread.c(a).close();
                    MainThread.a(a);
                    MainThread.sendLog("[仙界]连接已中断");
                    return;
                }

            }
        } catch (IOException e) {
            Log.e("PktThread_St", e.getLocalizedMessage());
            MainThread.a(a);
            MainThread.sendLog("[仙界]连接已中断");
            return;
        }
    }

    final MainThread a;
    private InputStream b;
}