// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:43
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.b;

import java.io.ByteArrayOutputStream;

final class a extends ByteArrayOutputStream
{

    a()
    {
    }

    final void a()
    {
        a = count;
        count = 0;
    }

    final void b()
    {
        count = a;
    }

    private int a;
}