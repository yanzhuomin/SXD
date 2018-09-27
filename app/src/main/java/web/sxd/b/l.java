// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:44
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.b;

import java.io.*;
import java.util.zip.InflaterInputStream;

public final class l extends DataInputStream
{

    l(byte abyte0[])
    {
        Object obj = new ByteArrayInputStream(abyte0);
        if(abyte0[0] == 120 && abyte0[1] == -100)
            obj = new InflaterInputStream(((InputStream) (obj)));
        super(((InputStream) (obj)));
        b = abyte0.length;
        a = readInt();
    }

    static byte[] a(InputStream inputstream)
    {
        int k = 0;
        int j = 0;
        int i = 0;
        do
        {
            if(j >= 4)
            {
                byte abyte0[] = new byte[i];
                j = k;
                do
                {
                    k = j + inputstream.read(abyte0, j, i - j);
                    j = k;
                } while(k < i);
                return abyte0;
            }
            int i1 = inputstream.read();
            if(i1 < 0)
                return null;
            i = i * 256 + i1;
            j++;
        } while(true);
    }

    public final int a()
    {
        long l1 = readLong();
        if(l1 < 20000L)
            return l1 <= 0L ? 0 : 1;
        l1 /= 10000L;
        if(l1 < 0x7fffffffL)
            return (int)l1;
        else
            return 0x7fffffff;
    }

    public final String a(int i)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int j = 0;
        do
        {
            if(j >= i)
                return stringbuilder.toString();
            stringbuilder.append(',');
            stringbuilder.append(readInt());
            j++;
        } while(true);
    }

    public final int b()
    {
        return b;
    }

    final void b(int i)
    {
        a = i;
    }

    public final int c()
    {
        return a;
    }

    public final int d()
    {
        return a / 0x10000;
    }

    public final int e()
    {
        return a % 0x10000;
    }

    private int a;
    private int b;
}