// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:47
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;
import java.io.IOException;

import web.sxd.b.BaseFunc;

// Referenced classes of package web.sxd.d:
//            n, ab

final class o extends Thread
{

    o(n n1)
    {
        a = n1;
        //super();
    }

    public final void run()
    {
        BaseFunc.a(50);
        try
        {
            ab.a(n.a(a));
            return;
        }
        catch(IOException ioexception)
        {
            Log.e(n.b(a), "Training_", ioexception);
        }
    }

    final n a;
}