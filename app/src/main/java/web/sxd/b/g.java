// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:44
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.b;

import android.util.Log;
import java.io.IOException;

// Referenced classes of package web.sxd.Fate:
//            l, c

//处理返回内容线程
final class g extends Thread
{

    g( MainThread c1, byte abyte0[])
    {
        super();
        a = c1;
        b = abyte0;
    }

    public final void run()
    {
        try
        {
            TempDataInputStream l1 = new TempDataInputStream(b);
            MainThread c1 = a;
            MainThread.processReceive(l1);
            l1.close();
            return;
        }
        catch(IOException ioexception)
        {
            Log.e("PktThread", ioexception.getLocalizedMessage(), ioexception);
        }
    }

    final MainThread a;
    private byte b[];
}