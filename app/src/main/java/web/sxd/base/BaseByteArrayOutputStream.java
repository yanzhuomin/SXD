// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:43
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.base;

import java.io.ByteArrayOutputStream;

final class BaseByteArrayOutputStream extends ByteArrayOutputStream
{

    BaseByteArrayOutputStream()
    {
    }

    //写指针指向开始
    final void posToStart()
    {
        a = count;
        count = 0;
    }

    //恢复指针
    final void posToEnd()
    {
        count = a;
    }

    private int a;
}