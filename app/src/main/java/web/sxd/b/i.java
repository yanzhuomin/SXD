// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:44
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.b;

import java.util.HashMap;

// Referenced classes of package web.sxd.b:
//            j, BaseFunc

public final class i
{

    /**
     * @param namePrefix namePrefix     功能名字中的前缀
     * @param valueH value/0x10000  值的高两个字节
     * */
    i(int valueH, String namePrefix)
    {
        this.funcCodeH = valueH;
        this.namePrefix = namePrefix;
        map = new HashMap();
    }

    static String a(i k)
    {
        return k.namePrefix;
    }

    static BaseFunc getBaseFunc(i k)
    {
        return k.b;
    }

    static int getFuncCodeH(i k)
    {
        return k.funcCodeH;
    }

    static int d(i k)
    {
        return k.d;
    }

    public final int getFuncCodeH()
    {
        return funcCodeH;
    }

    public final int    getFuncCode(j j1)
    {
        return funcCodeH * 0x10000 + j.getFuncCodeL(j1);
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

    final void a(int k, BaseFunc h)
    {
        d = k;
        b = h;
    }

    final j setChildValue(String nameLast, int k)
    {
        j j1 = (j) map.get(nameLast);
        if(nameLast != null && b != null)
        {
            j.setFuncCode(j1, d * 0x10000 + k);
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
    private BaseFunc b;
    private int funcCodeH; //ini中的valueH
    private int d; //web.sxd.d.* 类中的valueH
    private String namePrefix;
}