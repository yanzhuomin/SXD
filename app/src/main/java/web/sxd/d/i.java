// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:47
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3)

package web.sxd.d;

import android.util.Log;

import web.sxd.b.TempDataInputStream;

// Referenced classes of package web.sxd.d:
//            g

final class i
{

    i(g g1, int j, TempDataInputStream l1) throws Exception
    {
        f = g1;
        //super();
        a = j;
        a(l1);
    }

    final void a(TempDataInputStream l1) throws Exception
    {
        int j = a;
        int k = l1.readInt();
        int i1 = l1.readInt();
        c = i1;
        int j1 = l1.readInt();
        b = j1;
        int k1 = l1.read();
        d = k1;
        int i2 = l1.readUnsignedShort();
        e = i2;
        String s = String.format("%d, %d, %d, %d, %d, %d", new Object[] {
            Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i1), Integer.valueOf(j1), Integer.valueOf(k1), Integer.valueOf(i2)
        });
        l1.skipBytes(e * 12);
        if(b())
            Log.v(g.a(f), s);
        if(b > g.b(f))
            g.a(f, b);
    }

    final boolean a()
    {
        return c == 0 && d == 1;
    }

    final boolean b()
    {
        return d != 1;
    }

    int a;
    int b;
    int c;
    int d;
    int e;
    final g f;
}