// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:44
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.b;

import android.util.Log;

// Referenced classes of package web.sxd.nameLast:
//            i, h, l

final class j
{

    /**
     * @param k parent
     * @param nameLast nameLast  配置文件一条配置中名字的第一个下划线后面的部分
     * @param valueL value%0x10000   值的后两个字节
     *
     * */
    j(i k, String nameLast, int valueL)
    {
        a = k;
        //super();
        this.nameLast = nameLast;
        this.valueL = valueL;
        d = -1;
    }

    static int a(j j1)
    {
        return j1.valueL;
    }

    static void a(j j1, int k)
    {
        j1.d = k;
    }

    public final int a()
    {
        return valueL;
    }

    public final void a(TempDataInputStream l1)
    {
        if(i.b(a) != null && i.c(a) == 0 && i.c(a) == i.d(a))
        {
            i.b(a).a(l1);
            return;
        }
        if(i.b(a) == null || d < 0 || valueL < 0)
        {
            Log.v("MF_Parser", (new StringBuilder("UnRegFunc: (")).append(l1.d()).append(")").append(i.a(a)).append(nameLast).append("(").append(l1.e()).append(")").append(d).toString());
            return;
        } else
        {
            l1.b(d);
            i.b(a).a(l1);
            return;
        }
    }

    //设置索引号 0开始
    public final int b()
    {
        return d;
    }

    public final String toString()
    {
        return (new StringBuilder(String.valueOf(i.a(a)))).append(nameLast).toString();
    }

    final i a;
    private String nameLast;
    private int valueL;
    private int d;
}