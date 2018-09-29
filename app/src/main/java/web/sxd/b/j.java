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
     * @param k parent 属于那个前缀类i
     * @param nameLast nameLast  配置文件一条配置中名字的第一个下划线后面的部分
     * @param valueL value%0x10000   值的后两个字节
     *
     * */
    j(i k, String nameLast, int valueL)
    {
        parent = k;
        //super();
        this.nameLast = nameLast;
        this.valueL = valueL;
        value = -1;
    }

    static int getVauleL(j j1)
    {
        return j1.valueL;
    }

    //索引 = parent 中的 d * 0x10000 + k
    static void setValue(j j1, int k)
    {
        j1.value = k;
    }

    public final int getVauleL()
    {
        return valueL;
    }

    public final void a(TempDataInputStream l1)
    {
        if(i.b(parent) != null && i.c(parent) == 0 && i.c(parent) == i.d(parent))
        {
            i.b(parent).a(l1);
            return;
        }
        if(i.b(parent) == null || value < 0 || valueL < 0)
        {
            Log.v("MF_Parser", (new StringBuilder("UnRegFunc: (")).append(l1.d()).append(")").append(i.a(parent)).append(nameLast).append("(").append(l1.e()).append(")").append(value).toString());
            return;
        } else
        {
            l1.b(value);
            i.b(parent).a(l1);
            return;
        }
    }

    //设置索引号 0开始
    public final int getValue()
    {
        return value;
    }

    public final String toString()
    {
        return (new StringBuilder(String.valueOf(i.a(parent)))).append(nameLast).toString();
    }

    final i parent;
    private String nameLast;
    private int valueL;
    private int value;
}