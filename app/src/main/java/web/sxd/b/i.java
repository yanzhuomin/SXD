// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:44
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.b;

import java.util.HashMap;

// Referenced classes of package web.sxd.b:
//            j, h

public final class i
{

    i(int k, String s)
    {
        c = k;
        e = s;
        a = new HashMap();
    }

    static String a(i k)
    {
        return k.e;
    }

    static h b(i k)
    {
        return k.b;
    }

    static int c(i k)
    {
        return k.c;
    }

    static int d(i k)
    {
        return k.d;
    }

    public final int a()
    {
        return c;
    }

    public final int a(j j1)
    {
        return c * 0x10000 + j.a(j1);
    }

    public final j a(String s, int k)
    {
        j j2 = (j)a.get(s);
        j j1 = j2;
        if(j2 == null)
        {
            HashMap hashmap = a;
            j1 = new j(this, s, k);
            hashmap.put(s, j1);
        }
        return j1;
    }

    final void a(int k, h h)
    {
        d = k;
        b = h;
    }

    final j b(String s, int k)
    {
        j j1 = (j)a.get(s);
        if(s != null && b != null)
        {
            j.a(j1, d * 0x10000 + k);
            return j1;
        } else
        {
            return null;
        }
    }

    public final String toString()
    {
        return e;
    }

    private HashMap a;
    private h b;
    private int c;
    private int d;
    private String e;
}