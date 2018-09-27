//// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:43
//// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
//// Decompiler options: packimports(3)
//
//package web.sxd.b;
//
//import android.os.Handler;
//import android.os.Message;
//import android.util.Log;
//import java.io.*;
//import java.lang.reflect.Array;
//import java.net.Socket;
//import java.util.*;
//
//// Referenced classes of package web.sxd.b:
////            i, l, j, h,
////            m, d, f, e,
////            b, g
//
//public final class c extends Thread
//{
//
//    public c(String s1, InputStream inputstream, OutputStream outputstream)
//    {
//        p = new boolean[320];
//        q = new boolean[320];
//        s = (String[][][])Array.newInstance(java/lang/String, new int[] {
//            255, 10, 2
//        });
//        t = new HashMap();
//        w = -1;
//        B = null;
//        K = 0;
//        L = 0;
//        N = 0x7fffffffL;
//        k = inputstream;
//        l = outputstream;
//        h = null;
//        m = null;
//        i = null;
//        n = null;
//        boolean flag;
//        if(s1.compareTo("20131129") > 0)
//            flag = true;
//        else
//            flag = false;
//        a = flag;
//        e = new HashMap();
//        d = true;
//    }
//
//    public static void a(int i1, int j1)
//    {
//        a(1, i1, j1, null);
//    }
//
//    public static void a(int i1, int j1, int k1, Object obj)
//    {
//        Message message = new Message();
//        message.what = i1;
//        message.obj = obj;
//        message.arg1 = j1;
//        message.arg2 = k1;
//        b.sendMessage(message);
//    }
//
//    public static void a(int i1, Object obj)
//    {
//        Message message = new Message();
//        message.what = i1;
//        message.obj = obj;
//        message.arg2 = 0;
//        message.arg1 = 0;
//        b.sendMessage(message);
//    }
//
//    public static void a(Handler handler)
//    {
//        b = handler;
//        g.clear();
//        f.clear();
//        c = false;
//    }
//
//    public static void a(InputStream inputstream)
//    {
//        BufferedReader bufferedreader;
//        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
//        if(!bufferedreader.ready())
//        {
//            bufferedreader.close();
//            return;
//        }
//_L7:
//        inputstream = bufferedreader.readLine();
//        if(inputstream == null)
//            break; /* Loop/switch isn't completed */
//        if(inputstream.length() == 0 || inputstream.charAt(0) == ';') goto _L2; else goto _L1
//_L1:
//        int i1;
//        int k1 = inputstream.indexOf(',');
//        i1 = k1;
//        if(k1 < 0)
//            i1 = inputstream.indexOf('=');
//        if(i1 <= 0) goto _L4; else goto _L3
//_L3:
//        String s1;
//        String s2;
//        s1 = inputstream.substring(0, i1);
//        s2 = inputstream.substring(i1 + 1);
//        i1 = s1.indexOf('_');
//        if(i1 <= 0) goto _L2; else goto _L5
//_L5:
//        int l1;
//        int i2;
//        i j2;
//        String s3;
//        s3 = s1.substring(0, i1 + 1);
//        l1 = Integer.valueOf(s2).intValue();
//        i2 = l1 / 0x10000;
//        j2 = (i)g.get(s3);
//        inputstream = j2;
//        if(j2 != null)
//            break MISSING_BLOCK_LABEL_178;
//        inputstream = new i(i2, s3);
//        g.put(s3, inputstream);
//        f.put(Integer.valueOf(l1), inputstream.a(s1.substring(i1 + 1), l1 % 0x10000));
//_L2:
//        if(bufferedreader.ready()) goto _L7; else goto _L6
//_L6:
//        bufferedreader.close();
//        inputstream = g.values().iterator();
//_L8:
//        if(!inputstream.hasNext())
//        {
//            c = true;
//            return;
//        }
//        break MISSING_BLOCK_LABEL_308;
//        inputstream;
//        Log.v("PktThread", (new StringBuilder(String.valueOf(s1))).append(" protocol with invalid code ").append(s2).toString());
//          goto _L2
//_L4:
//        Log.v("PktThread", (new StringBuilder("',' or '=' not found in protocol line: ")).append(inputstream).toString());
//          goto _L2
//        i k2 = (i)inputstream.next();
//        int j1 = k2.a() * 0x10000;
//        if(j1 > 0 && !f.containsKey(Integer.valueOf(j1)))
//            f.put(Integer.valueOf(j1), k2.a("?", -1));
//          goto _L8
//    }
//
//    public static void a(Object obj)
//    {
//        a(0, obj);
//    }
//
//    public static transient void a(String s1, Object aobj[])
//    {
//        a(0, String.format(s1, aobj));
//    }
//
//    static void a(c c1)
//    {
//        c1.h = null;
//    }
//
//    public static void b(int i1, boolean flag)
//    {
//        if(i1 < 320 && i1 >= 0)
//            r[i1] = flag;
//    }
//
//    public static void b(l l1)
//    {
//        j j2 = (j)f.get(Integer.valueOf(l1.c()));
//        j j1 = j2;
//        if(j2 == null)
//            j1 = (j)f.get(Integer.valueOf(l1.d() * 0x10000));
//        if(j1 == null)
//        {
//            Log.i("PktThread", (new StringBuilder("Unknown: ")).append(l1.d()).append("_").append(l1.e()).toString());
//            return;
//        } else
//        {
//            j1.a(l1);
//            return;
//        }
//    }
//
//    static boolean b(c c1)
//    {
//        return c1.d;
//    }
//
//    static Socket c(c c1)
//    {
//        return c1.h;
//    }
//
//    public static boolean c(int i1)
//    {
//        return i1 < 320 && i1 >= 0 && r[i1];
//    }
//
//    static void d(long l1)
//    {
//        P = l1;
//    }
//
//    static void d(c c1)
//    {
//        c1.i = null;
//    }
//
//    static Socket e(c c1)
//    {
//        return c1.i;
//    }
//
//    static void e(long l1)
//    {
//        Q = l1;
//    }
//
//    static void f(long l1)
//    {
//        R = l1;
//    }
//
//    static void f(c c1)
//    {
//        c1.j = null;
//    }
//
//    private static String g(long l1)
//    {
//        long l3 = 0L;
//        int i1 = 0;
//        long l2 = 0L;
//        do
//        {
//            if(l1 <= 1024L)
//            {
//                if(i1 == 0)
//                    return String.valueOf(l1);
//                break;
//            }
//            l2 = l1 % 1024L;
//            l1 /= 1024L;
//            i1++;
//        } while(true);
//        if(l2 > 949L)
//        {
//            l1++;
//            l2 = l3;
//        } else
//        {
//            l2 /= 100L;
//        }
//        return String.format("%d.%d %c", new Object[] {
//            Long.valueOf(l1), Long.valueOf(l2), Character.valueOf(" KMGT".charAt(i1))
//        });
//    }
//
//    static Socket g(c c1)
//    {
//        return c1.j;
//    }
//
//    public static void k()
//    {
//    }
//
//    static long r()
//    {
//        return P;
//    }
//
//    static long s()
//    {
//        return Q;
//    }
//
//    static long t()
//    {
//        return R;
//    }
//
//    public final int a()
//    {
//        return u;
//    }
//
//    public final void a(int i1)
//    {
//        if(i1 < 320 && i1 >= 0)
//            q[i1] = true;
//    }
//
//    public final void a(int i1, int j1, int k1)
//    {
//        if(C == i1)
//        {
//            G = j1;
//            H = k1;
//        }
//    }
//
//    public final void a(int i1, h h1)
//    {
//        a(i1, h1.a(), h1);
//    }
//
//    public final void a(int i1, m m1, int j1)
//    {
//        this;
//        JVM INSTR monitorenter ;
//        if(j1 != 1) goto _L2; else goto _L1
//_L1:
//        if(m != null) goto _L2; else goto _L3
//_L3:
//        Log.e("PacketOS", "[\u4ED9\u754C]\u8FDE\u63A5\u672A\u5EFA\u7ACB");
//_L4:
//        this;
//        JVM INSTR monitorexit ;
//        return;
//_L2:
//        if(j1 != 2)
//            break MISSING_BLOCK_LABEL_57;
//        if(n != null)
//            break MISSING_BLOCK_LABEL_57;
//        Log.e("PacketOS", "[\u5723\u57DF]\u8FDE\u63A5\u672A\u5EFA\u7ACB");
//          goto _L4
//        m1;
//        throw m1;
//        if(j1 != 3)
//            break MISSING_BLOCK_LABEL_82;
//        if(o != null)
//            break MISSING_BLOCK_LABEL_82;
//        Log.e("PacketOS", "[\u5168\u7F51]\u8FDE\u63A5\u672A\u5EFA\u7ACB");
//          goto _L4
//        if(i1 < 0x10000)
//            break MISSING_BLOCK_LABEL_94;
//        if(c)
//            break MISSING_BLOCK_LABEL_203;
//        if(!d)
//            break MISSING_BLOCK_LABEL_160;
//        if(j1 != 3) goto _L6; else goto _L5
//_L5:
//        Object obj = o;
//_L7:
//        m1.a(i1, ((OutputStream) (obj)), j1);
//          goto _L4
//_L6:
//        if(j1 != 2)
//            break MISSING_BLOCK_LABEL_137;
//        obj = n;
//          goto _L7
//        if(j1 != 1)
//            break MISSING_BLOCK_LABEL_151;
//        obj = m;
//          goto _L7
//        obj = l;
//          goto _L7
//        Log.i("PacketOS", (new StringBuilder("UnSent: ")).append(i1 / 0x10000).append("_").append(i1 % 0x10000).toString());
//          goto _L4
//        obj = (j)e.get(Integer.valueOf(i1));
//        if(obj == null)
//            break MISSING_BLOCK_LABEL_388;
//        if(!d)
//            break MISSING_BLOCK_LABEL_343;
//        Log.v("PacketOS", (new StringBuilder()).append(obj).append("(").append(((j) (obj)).a()).append(")").toString());
//        i1 = ((j) (obj)).a.a(((j) (obj)));
//        if(j1 != 3) goto _L9; else goto _L8
//_L8:
//        obj = o;
//_L10:
//        m1.a(i1, ((OutputStream) (obj)), j1);
//          goto _L4
//_L9:
//        if(j1 != 2)
//            break MISSING_BLOCK_LABEL_320;
//        obj = n;
//          goto _L10
//        if(j1 != 1)
//            break MISSING_BLOCK_LABEL_334;
//        obj = m;
//          goto _L10
//        obj = l;
//          goto _L10
//        Log.i("PacketOS", (new StringBuilder()).append(obj).append("(").append(((j) (obj)).a()).append(") unSent").toString());
//          goto _L4
//        Log.i("PacketOS", (new StringBuilder("UnRegFunc sends: ")).append(i1 / 0x10000).append("_").append(i1 % 0x10000).toString());
//          goto _L4
//    }
//
//    public final void a(int i1, boolean flag)
//    {
//        if(i1 < 320 && i1 >= 0)
//            p[i1] = flag;
//    }
//
//    public final void a(int i1, String as[], h h1)
//    {
//        boolean flag;
//        boolean flag1;
//        i l1;
//        flag1 = true;
//        flag = true;
//        l1 = (i)g.get(as[0]);
//        if(!c || l1 == null) goto _L2; else goto _L1
//_L1:
//        l1.a(i1, h1);
//        i1 = ((flag) ? 1 : 0);
//_L7:
//        if(i1 < as.length) goto _L4; else goto _L3
//_L3:
//        return;
//_L4:
//        if(as[i1].length() != 0)
//        {
//            h1 = l1.b(as[i1], i1 - 1);
//            if(h1 != null)
//            {
//                int j1 = h1.b();
//                e.put(Integer.valueOf(j1), h1);
//            } else
//            {
//                Log.e("PktThread", (new StringBuilder(String.valueOf(as[0]))).append(as[i1]).toString());
//            }
//        }
//        i1++;
//        continue; /* Loop/switch isn't completed */
//_L2:
//        if(c || l1 != null) goto _L3; else goto _L5
//_L5:
//        i i2 = new i(i1, as[0]);
//        g.put(as[0], i2);
//        i2.a(i1, h1);
//        int k1 = ((flag1) ? 1 : 0);
//        if(i1 == 0)
//        {
//            f.put(Integer.valueOf(0), i2.a("Login", 0));
//            i2.b("Login", 0);
//            return;
//        }
//        for(; k1 < as.length; k1++)
//            if(as[k1].length() > 0)
//            {
//                h1 = i2.a(as[k1], k1 - 1);
//                i1 = i2.a(h1);
//                Log.v("PktThread", (new StringBuilder(String.valueOf(as[0]))).append(as[k1]).append("(").append(i1 / 0x10000).append("_").append(i1 % 0x10000).append(")").toString());
//                f.put(Integer.valueOf(i1), h1);
//                i2.b(as[k1], k1 - 1);
//            }
//
//        return;
//        if(true) goto _L7; else goto _L6
//_L6:
//    }
//
//    public final void a(long l1)
//    {
//        if(l1 < 20000L)
//        {
//            int i1;
//            if(l1 > 0L)
//                i1 = 1;
//            else
//                i1 = 0;
//            F = i1;
//        } else
//        {
//            l1 /= 10000L;
//            if(l1 < 0x7fffffffL)
//            {
//                F = (int)l1;
//                return;
//            }
//        }
//    }
//
//    public final void a(String s1, int i1, int j1, int k1)
//    {
//        A = s1;
//        D = i1;
//        E = j1;
//        F = k1;
//    }
//
//    public final void a(h h1)
//    {
//        if(h1 != null)
//        {
//            h h2 = (h)t.put(h1.getClass(), h1);
//            if(h2 != null && !h2.equals(h1))
//                h2.d();
//        }
//    }
//
//    public final void a(l l1)
//    {
//        l1.skipBytes(20);
//        u = l1.readInt();
//        v = l1.readInt();
//        l1.read();
//        y = l1.readInt();
//        l1.skipBytes(16);
//        l1.read();
//        x = l1.readInt();
//        z = l1.readInt();
//        Log.i("PktThread", (new StringBuilder(String.valueOf(u))).append(",").append(v).append(" ").append(y).append(",").append(z).append(" ").append(x).toString());
//    }
//
//    public final boolean a(String s1)
//    {
//        return s1.equals(B);
//    }
//
//    public final boolean a(String s1, int i1, String s2, int j1, String s3)
//    {
//        if(h != null)
//        {
//            if(h.isConnected() && !h.isClosed())
//                return true;
//            h = null;
//        }
//        if(i1 == 0)
//        {
//            a(0, "[\u4ED9\u754C]\u5F53\u524D\u672A\u5F00\u653E");
//            return false;
//        }
//        h = new Socket(s1, i1);
//        if(h.isConnected())
//            break MISSING_BLOCK_LABEL_84;
//        a(0, "[\u4ED9\u754C]\u65E0\u6CD5\u5EFA\u7ACB\u8FDE\u63A5");
//        h = null;
//        return false;
//        B = s2;
//        Log.i("PktThread", (new StringBuilder("[\u4ED9\u754C]\u5C1D\u8BD5\u767B\u5F55 ")).append(B).toString());
//        m = new BufferedOutputStream(h.getOutputStream());
//        s1 = new m(0x5e0000);
//        s1.writeUTF(s2);
//        s1.writeInt(C);
//        s1.writeUTF(A);
//        s1.writeInt(j1);
//        s1.writeUTF(s3);
//        s1.a(0x5e0000, m, 1);
//        if(!h.isClosed())
//            break MISSING_BLOCK_LABEL_217;
//        Log.i("PktThread", "[\u4ED9\u754C]\u8FDE\u63A5\u5DF2\u4E2D\u65AD");
//        h = null;
//        return false;
//        try
//        {
//            (new d(this, h.getInputStream())).start();
//        }
//        // Misplaced declaration of an exception variable
//        catch(String s1)
//        {
//            Log.e("PktThread", s1.getLocalizedMessage(), s1);
//            a(0, "[\u4ED9\u754C] -_- \u8DE8\u670D\u8FDE\u63A5\u5931\u8D25");
//            h = null;
//            return false;
//        }
//        return true;
//    }
//
//    public final boolean a(String s1, int i1, String s2, String s3, String s4, int j1, String s5)
//    {
//        if(j != null)
//        {
//            if(j.isConnected() && !j.isClosed())
//                return true;
//            j = null;
//        }
//        if(i1 == 0)
//        {
//            a(0, "[\u5168\u7F51]\u5F53\u524D\u672A\u5F00\u653E");
//            return false;
//        }
//        j = new Socket(s1, i1);
//        if(j.isConnected())
//            break MISSING_BLOCK_LABEL_84;
//        a(0, "[\u5168\u7F51]\u65E0\u6CD5\u5EFA\u7ACB\u8FDE\u63A5");
//        j = null;
//        return false;
//        B = s3;
//        Log.i("PktThread", (new StringBuilder("[\u5168\u7F51]\u5C1D\u8BD5\u767B\u5F55 ")).append(B).toString());
//        o = new BufferedOutputStream(j.getOutputStream());
//        s1 = new m(0x150000c);
//        s1.writeUTF(s2);
//        s1.writeInt(C);
//        s1.writeUTF(s3);
//        s1.writeUTF(s4);
//        s1.writeInt(j1);
//        s1.writeUTF(s5);
//        s1.a(0x150000c, o, 3);
//        if(!j.isClosed())
//            break MISSING_BLOCK_LABEL_222;
//        Log.i("PktThread", "[\u5168\u7F51]\u8FDE\u63A5\u5DF2\u4E2D\u65AD");
//        j = null;
//        return false;
//        try
//        {
//            (new f(this, j.getInputStream())).start();
//        }
//        // Misplaced declaration of an exception variable
//        catch(String s1)
//        {
//            Log.e("PktThread", s1.getLocalizedMessage(), s1);
//            a(0, "[\u5168\u7F51] -_- \u8DE8\u670D\u8FDE\u63A5\u5931\u8D25");
//            j = null;
//            return false;
//        }
//        return true;
//    }
//
//    public final int b()
//    {
//        return w;
//    }
//
//    public final void b(long l1)
//    {
//        M = l1;
//    }
//
//    public final boolean b(int i1)
//    {
//        return i1 < 320 && i1 >= 0 && p[i1] && !r[i1] && !q[i1];
//    }
//
//    public final boolean b(String s1, int i1, String s2, int j1, String s3)
//    {
//        if(i != null)
//        {
//            if(i.isConnected() && !i.isClosed())
//                return true;
//            i = null;
//        }
//        if(i1 == 0)
//        {
//            a(0, "[\u5723\u57DF]\u5F53\u524D\u672A\u5F00\u653E");
//            return false;
//        }
//        i = new Socket(s1, i1);
//        if(i.isConnected())
//            break MISSING_BLOCK_LABEL_84;
//        a(0, "[\u5723\u57DF]\u65E0\u6CD5\u5EFA\u7ACB\u8FDE\u63A5");
//        i = null;
//        return false;
//        B = s2;
//        Log.i("PktThread", (new StringBuilder("[\u5723\u57DF]\u5C1D\u8BD5\u767B\u5F55 ")).append(B).toString());
//        n = new BufferedOutputStream(i.getOutputStream());
//        s1 = new m(0x1250000);
//        s1.writeUTF(s2);
//        s1.writeInt(C);
//        s1.writeUTF(A);
//        s1.writeInt(j1);
//        s1.writeUTF(s3);
//        s1.a(0x1250000, n, 2);
//        if(!i.isClosed())
//            break MISSING_BLOCK_LABEL_217;
//        Log.i("PktThread", "[\u5723\u57DF]\u8FDE\u63A5\u5DF2\u4E2D\u65AD");
//        i = null;
//        return false;
//        try
//        {
//            (new e(this, i.getInputStream())).start();
//        }
//        // Misplaced declaration of an exception variable
//        catch(String s1)
//        {
//            Log.e("PktThread", s1.getLocalizedMessage(), s1);
//            a(0, "[\u5723\u57DF] -_- \u8DE8\u670D\u8FDE\u63A5\u5931\u8D25");
//            i = null;
//            return false;
//        }
//        return true;
//    }
//
//    public final int c()
//    {
//        return H;
//    }
//
//    public final void c(long l1)
//    {
//        if(l1 > 0L)
//            N = l1;
//    }
//
//    public final int d()
//    {
//        return C;
//    }
//
//    public final void d(int i1)
//    {
//        w = i1;
//    }
//
//    public final int e()
//    {
//        return E;
//    }
//
//    public final void e(int i1)
//    {
//        C = i1;
//    }
//
//    public final int f()
//    {
//        return F;
//    }
//
//    public final void f(int i1)
//    {
//        D = i1;
//    }
//
//    public final int g()
//    {
//        return D;
//    }
//
//    public final void g(int i1)
//    {
//        if(i1 >= 0)
//        {
//            I = i1;
//            return;
//        } else
//        {
//            I = I - i1;
//            return;
//        }
//    }
//
//    public final int h()
//    {
//        return (int)((M * 100L) / N);
//    }
//
//    public final void h(int i1)
//    {
//        J = i1;
//    }
//
//    public final int i()
//    {
//        return I;
//    }
//
//    public final void i(int i1)
//    {
//        K = i1;
//    }
//
//    public final int j()
//    {
//        return K;
//    }
//
//    public final void j(int i1)
//    {
//        (new m(0x10000, i1)).a(this);
//        l();
//    }
//
//    public final void l()
//    {
//        web.sxd.b.h.a(3);
//        (new m(93)).a(this);
//    }
//
//    public final void m()
//    {
//        if(b(91) && h != null)
//        {
//            web.sxd.b.h.c();
//            (new m(0x5f0000, 41)).b(this);
//        } else
//        {
//            j(J);
//        }
//        if(b(165) && i != null)
//        {
//            web.sxd.b.h.c();
//            (new m(0x1260000, 78)).c(this);
//        }
//    }
//
//    public final void n()
//    {
//        (new m(41, 23)).a(this);
//    }
//
//    public final boolean o()
//    {
//        return h == null && b(91);
//    }
//
//    public final boolean p()
//    {
//        return i == null && b(165);
//    }
//
//    public final void q()
//    {
//        d = false;
//        if(h == null)
//            break MISSING_BLOCK_LABEL_24;
//        h.close();
//        h = null;
//_L1:
//        if(i == null)
//            break MISSING_BLOCK_LABEL_43;
//        i.close();
//        i = null;
//_L2:
//        Object obj = t.values().iterator();
//_L3:
//        if(!((Iterator) (obj)).hasNext())
//        {
//            t.clear();
//            return;
//        }
//        break MISSING_BLOCK_LABEL_131;
//        obj;
//        Log.v("PktThread", ((IOException) (obj)).getLocalizedMessage(), ((Throwable) (obj)));
//        h = null;
//          goto _L1
//        obj;
//        h = null;
//        throw obj;
//        obj;
//        Log.v("PktThread", ((IOException) (obj)).getLocalizedMessage(), ((Throwable) (obj)));
//        i = null;
//          goto _L2
//        obj;
//        i = null;
//        throw obj;
//        ((h)((Iterator) (obj)).next()).d();
//          goto _L3
//    }
//
//    public final void run()
//    {
//        byte abyte0[] = web.sxd.b.l.a(k);
//_L1:
//        boolean flag = d;
//        if(!flag || abyte0 == null)
//        {
//            a(-1, "\u670D\u52A1\u5668\u8FDE\u63A5\u5DF2\u4E2D\u65AD");
//            q();
//            Log.i("PktThread", "CONN_BREAK");
//            return;
//        }
//        O += abyte0.length + 4;
//        web.sxd.b.b.a();
//        (new g(this, abyte0)).start();
//        abyte0 = web.sxd.b.l.a(k);
//          goto _L1
//        Object obj;
//        obj;
//        Log.e("PktThread", ((IOException) (obj)).getLocalizedMessage());
//        a(-1, "\u670D\u52A1\u5668\u8FDE\u63A5\u5DF2\u4E2D\u65AD");
//        q();
//        Log.i("PktThread", "CONN_BREAK");
//        return;
//        obj;
//        a(-1, "\u670D\u52A1\u5668\u8FDE\u63A5\u5DF2\u4E2D\u65AD");
//        q();
//        Log.i("PktThread", "CONN_BREAK");
//        throw obj;
//    }
//
//    public final String toString()
//    {
//        return String.format("\u672C\u8FDB\u7A0B %s +%s(\u4ED9\u754C) +%s(\u5723\u57DF) +%s(\u5168\u7F51)", new Object[] {
//            g(O), g(P), g(Q), g(R)
//        });
//    }
//
//    private static long O = 0L;
//    private static long P = 0L;
//    private static long Q = 0L;
//    private static long R = 0L;
//    private static Handler b;
//    private static boolean c;
//    private static HashMap f = new HashMap();
//    private static HashMap g = new HashMap();
//    private static boolean r[] = new boolean[320];
//    private String A;
//    private String B;
//    private int C;
//    private int D;
//    private int E;
//    private int F;
//    private int G;
//    private int H;
//    private int I;
//    private int J;
//    private int K;
//    private int L;
//    private long M;
//    private long N;
//    public boolean a;
//    private boolean d;
//    private HashMap e;
//    private Socket h;
//    private Socket i;
//    private Socket j;
//    private InputStream k;
//    private OutputStream l;
//    private OutputStream m;
//    private OutputStream n;
//    private OutputStream o;
//    private boolean p[];
//    private boolean q[];
//    private String s[][][];
//    private HashMap t;
//    private int u;
//    private int v;
//    private int w;
//    private int x;
//    private int y;
//    private int z;
//
//}