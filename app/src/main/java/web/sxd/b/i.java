// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:44
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.b;

import java.util.HashMap;

// Referenced classes of package web.sxd.b:
//            j, h

public final class i
{

    /**
     * @param namePrefix namePrefix     名字中的前缀
     * @param valueH value/0x10000  值的高两个字节
     * */
    i(int valueH, String namePrefix)
    {
        this.valueH = valueH;
        this.namePrefix = namePrefix;
        map = new HashMap();
    }

    static String a(i k)
    {
        return k.namePrefix;
    }

    static h b(i k)
    {
        return k.b;
    }

    static int c(i k)
    {
        return k.valueH;
    }

    static int d(i k)
    {
        return k.d;
    }

    public final int getValueH()
    {
        return valueH;
    }

    public final int a(j j1)
    {
        return valueH * 0x10000 + j.a(j1);
    }

    public final j addConfig(String nameLast, int valueL)
    {
        j j2 = (j) map.get(nameLast);
        j j1 = j2;
        if(j2 == null)
        {
            HashMap hashmap = map;
            j1 = new j(this, nameLast, valueL);
            hashmap.put(nameLast, j1);
        }
        return j1;
    }

    final void a(int k, h h)
    {
        d = k;
        b = h;
    }

    final j b(String nameLast, int k)
    {
        j j1 = (j) map.get(nameLast);
        if(nameLast != null && b != null)
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
        return namePrefix;
    }

    private HashMap map;
    private h b;
    private int valueH;
    private int d; //web.sxd.d.* 类中的valueH
    private String namePrefix;
}