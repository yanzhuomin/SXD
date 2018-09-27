//// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:44
//// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
//// Decompiler options: packimports(3)
//
//package web.sxd.b;
//
//import java.io.DataOutputStream;
//import java.io.OutputStream;
//
//// Referenced classes of package web.sxd.b:
////            a, c
//
//public final class m extends DataOutputStream
//{
//
//    public m(byte byte0, short word0)
//    {
//        this(0x840001);
//        write(byte0);
//        writeShort(word0);
//    }
//
//    public m(int i)
//    {
//        super(new a());
//        b = null;
//        writeInt(4);
//        a = i;
//        writeInt(i);
//    }
//
//    public m(int i, byte byte0)
//    {
//        this(i);
//        write(byte0);
//    }
//
//    public m(int i, byte byte0, byte byte1)
//    {
//        this(i);
//        write(byte0);
//        write(byte1);
//    }
//
//    public m(int i, char c1)
//    {
//        this(0x1570001);
//        write(0);
//        writeInt(i);
//    }
//
//    public m(int i, int j)
//    {
//        this(i);
//        writeInt(j);
//    }
//
//    public m(int i, int j, byte byte0)
//    {
//        this(i);
//        writeInt(j);
//        write(byte0);
//    }
//
//    public m(int i, int j, int k)
//    {
//        this(i);
//        writeInt(j);
//        writeInt(k);
//    }
//
//    public m(int i, int j, int k, int l)
//    {
//        this(0x11f0001);
//        writeInt(i);
//        writeInt(j);
//        writeInt(k);
//        writeInt(l);
//    }
//
//    public m(int i, long l)
//    {
//        this(i);
//        write((int)l);
//    }
//
//    public m(int i, short word0)
//    {
//        this(i);
//        writeShort(word0);
//    }
//
//    public m(String s)
//    {
//        this(0xda0025);
//        writeUTF(s);
//    }
//
//    public m(String s, String s1)
//    {
//        this(0x150000d);
//        writeUTF(s);
//        writeUTF(s1);
//    }
//
//    public m(String s, String s1, String s2)
//    {
//        this(0x1500014);
//        writeUTF(s);
//        writeUTF(s1);
//        writeUTF(s2);
//    }
//
//    public m(short word0)
//    {
//        this(0x3a001b);
//        writeShort(word0);
//        write(33);
//    }
//
//    public m(short word0, int i)
//    {
//        this(0xe10021);
//        writeShort(word0);
//        writeInt(i);
//    }
//
//    public final void a(int i, OutputStream outputstream, int j)
//    {
//        byte byte0 = 0;
//        boolean flag;
//        if(i != 0 && i != 0x5e0000 && i != 0x1250000 && i != 0x150000c)
//            flag = false;
//        else
//            flag = true;
//        if(b == null)
//        {
//            b = (a)out;
//            b.a();
//            int k = written;
//            if(flag)
//                byte0 = 4;
//            writeInt(k - byte0);
//            writeInt(i);
//        }
//        b.b();
//        if(!flag)
//            writeInt(c[j]);
//        c[j] = i;
//        flush();
//        b.writeTo(outputstream);
//        outputstream.flush();
//    }
//
//    public final void a(c c1)
//    {
//        c1.a(a, this, 0);
//    }
//
//    public final void b(c c1)
//    {
//        c1.a(a, this, 1);
//    }
//
//    public final void c(c c1)
//    {
//        c1.a(a, this, 2);
//    }
//
//    public final void d(c c1)
//    {
//        c1.a(a, this, 3);
//    }
//
//    private static int c[] = new int[4];
//    int a;
//    private a b;
//
//}