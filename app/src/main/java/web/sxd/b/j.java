// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:44
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.b;

import android.util.Log;

// Referenced classes of package web.sxd.nameLast:
//            i, BaseFunc, l

final class j
{

    /**
     * @param k parent 属于那个前缀类i
     * @param nameLast nameLast  配置文件一条配置中名字的第一个下划线后面的部分
     * @param valueL funcCode%0x10000   值的后两个字节
     *
     * */
    j(i k, String nameLast, int valueL)
    {
        parent = k;
        //super();
        this.nameLast = nameLast;
        this.funcCodeL = valueL;
        funcCode = -1;
    }

    static int getFuncCodeL(j j1)
    {
        return j1.funcCodeL;
    }

    //索引 = parent 中的 d * 0x10000 + k
    static void setFuncCode(j j1, int k)
    {
        j1.funcCode = k;
    }

    public final int getFuncCodeL()
    {
        return funcCodeL;
    }

    public final void a(TempDataInputStream inputStream)
    {
        if(i.getBaseFunc(parent) != null && i.getFuncCodeH(parent) == 0 && i.getFuncCodeH(parent) == i.d(parent))
        {
            i.getBaseFunc(parent).a(inputStream);
            return;
        }
        if(i.getBaseFunc(parent) == null || funcCode < 0 || funcCodeL < 0)
        {
            Log.v("MF_Parser", (new StringBuilder("UnRegFunc: (")).append(inputStream.getFuncCodeH()).append(")").append(i.a(parent)).append(nameLast).append("(").append(inputStream.getFuncCodeL()).append(")").append(funcCode).toString());
            return;
        } else
        {
            inputStream.setFuncCode(funcCode);
            i.getBaseFunc(parent).a(inputStream);
            return;
        }
    }


    public final int getFuncCode()
    {
        return funcCode;
    }

    @Override
    public final String toString()
    {
        return (new StringBuilder(String.valueOf(i.a(parent)))).append(nameLast).toString();
    }

    final i parent;
    private String nameLast;
    private int funcCodeL;
    private int funcCode;
}