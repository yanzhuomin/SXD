// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:44
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.b;

import android.util.Log;

// Referenced classes of package web.sxd.b:
//            i, h, l

final class j
{

    j(i k, String s, int i1)
    {
        a = k;
        //super();
        b = s;
        c = i1;
        d = -1;
    }

    static int a(j j1)
    {
        return j1.c;
    }

    static void a(j j1, int k)
    {
        j1.d = k;
    }

    public final int a()
    {
        return c;
    }

    public final void a(TempDataInputStream l1)
    {
        if(i.b(a) != null && i.c(a) == 0 && i.c(a) == i.d(a))
        {
            i.b(a).a(l1);
            return;
        }
        if(i.b(a) == null || d < 0 || c < 0)
        {
            Log.v("MF_Parser", (new StringBuilder("UnRegFunc: (")).append(l1.d()).append(")").append(i.a(a)).append(b).append("(").append(l1.e()).append(")").append(d).toString());
            return;
        } else
        {
            l1.b(d);
            i.b(a).a(l1);
            return;
        }
    }

    public final int b()
    {
        return d;
    }

    public final String toString()
    {
        return (new StringBuilder(String.valueOf(i.a(a)))).append(b).toString();
    }

    final i a;
    private String b;
    private int c;
    private int d;
}