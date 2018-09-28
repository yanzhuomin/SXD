// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:44
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3)

package web.sxd.b;

import java.io.DataOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package web.sxd.b:
//            a, c

public final class TempDataOutputStream extends DataOutputStream
{

    public TempDataOutputStream(byte byte0, short word0) throws IOException
    {
        this(0x840001);
        write(byte0);
        writeShort(word0);
    }

    public TempDataOutputStream(int i) throws IOException
    {
        super(new BaseByteArrayOutputStream());
        b = null;
        writeInt(4);
        a = i;
        writeInt(i);
    }

    public TempDataOutputStream(int i, byte byte0) throws IOException
    {
        this(i);
        write(byte0);
    }

    public TempDataOutputStream(int i, byte byte0, byte byte1) throws IOException
    {
        this(i);
        write(byte0);
        write(byte1);
    }

    public TempDataOutputStream(int i, char c1) throws IOException
    {
        this(0x1570001);
        write(0);
        writeInt(i);
    }

    public TempDataOutputStream(int i, int j) throws IOException
    {
        this(i);
        writeInt(j);
    }

    public TempDataOutputStream(int i, int j, byte byte0) throws IOException
    {
        this(i);
        writeInt(j);
        write(byte0);
    }

    public TempDataOutputStream(int i, int j, int k) throws IOException
    {
        this(i);
        writeInt(j);
        writeInt(k);
    }

    public TempDataOutputStream(int i, int j, int k, int l) throws IOException
    {
        this(0x11f0001);
        writeInt(i);
        writeInt(j);
        writeInt(k);
        writeInt(l);
    }

    public TempDataOutputStream(int i, long l) throws IOException
    {
        this(i);
        write((int)l);
    }

    public TempDataOutputStream(int i, short word0) throws IOException
    {
        this(i);
        writeShort(word0);
    }

    public TempDataOutputStream(String s) throws IOException
    {
        this(0xda0025);
        writeUTF(s);
    }

    public TempDataOutputStream(String s, String s1) throws IOException
    {
        this(0x150000d);
        writeUTF(s);
        writeUTF(s1);
    }

    public TempDataOutputStream(String s, String s1, String s2) throws IOException
    {
        this(0x1500014);
        writeUTF(s);
        writeUTF(s1);
        writeUTF(s2);
    }

    public TempDataOutputStream(short word0) throws IOException
    {
        this(0x3a001b);
        writeShort(word0);
        write(33);
    }

    public TempDataOutputStream(short word0, int i) throws IOException
    {
        this(0xe10021);
        writeShort(word0);
        writeInt(i);
    }

    /**
    * @param i 类型 ： 主界面：0   仙界：0x5e0000  圣域：0x1250000 全网：0x150000c
    *
    * */
    public final void a(int i, OutputStream outputstream, int j)  throws IOException
    {
        byte byte0 = 0;
        boolean flag;
        if(i != 0 && i != 0x5e0000 && i != 0x1250000 && i != 0x150000c)
            flag = false;
        else
            flag = true;
        if(b == null)
        {
            b = (BaseByteArrayOutputStream)out;
            b.BaseByteArrayOutputStream();
            int k = written;
            if(flag)
                byte0 = 4;
            writeInt(k - byte0);
            writeInt(i);
        }
        b.b();
        if(!flag)
            writeInt(c[j]);
        c[j] = i;
        flush();
        b.writeTo(outputstream);
        outputstream.flush();
    }

    public final void a(MainThread c1)
    {
        c1.a(a, this, 0);
    }

    public final void b(MainThread c1)
    {
        c1.a(a, this, 1);
    }

    public final void c(MainThread c1)
    {
        c1.a(a, this, 2);
    }

    public final void d(MainThread c1)
    {
        c1.a(a, this, 3);
    }

    private static int c[] = new int[4];
    int a;
    private BaseByteArrayOutputStream b;

}