// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:47
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;
import web.sxd.a.ab;
import web.sxd.a.ak;
import web.sxd.a.at;
import web.sxd.a.au;
import web.sxd.a.av;
import web.sxd.a.aw;
import web.sxd.a.ay;
import web.sxd.a.b;
import web.sxd.a.d;
import web.sxd.a.g;
import web.sxd.a.j;
import web.sxd.a.q;
import web.sxd.a.r;
import web.sxd.a.t;
import web.sxd.a.v;
import web.sxd.a.w;
import web.sxd.a.x;
import web.sxd.a.y;
import web.sxd.a.z;
import web.sxd.b.BaseFunc;
import web.sxd.b.MainThread;
import web.sxd.b.TempDataInputStream;
import web.sxd.b.TempDataOutputStream;
import web.sxd.b.c;
import web.sxd.b.h;
import web.sxd.b.l;
import web.sxd.b.m;

// Referenced classes of package web.sxd.d:
//            j, l, y, ab, 
//            o, b, e, u, 
//            g, p, a, d, 
//            z, k, aa

public final class n extends BaseFunc
{

    public n(MainThread c1)
    {
        super(c1, 0x50007);
        j = true;
        //TODO 暂时注释
//        new web.sxd.d.j(c1);
//        new web.sxd.d.l(c1);
//        new web.sxd.d.y(c1);
    }

    public static String a(MainThread c1, TempDataInputStream l1)
    {
        String s = l1.readUTF();
        l1 = l1.readUTF();
        if(c1.a(l1))
            return "";
        StringBuilder stringbuilder = new StringBuilder("^");
        c1 = l1;
        if(l1.toLowerCase().startsWith(s.toLowerCase()))
            c1 = l1.substring(s.length());
        return stringbuilder.append(s).append(c1).toString();
    }

    static MainThread a(n n1)
    {
        return n1.C;
    }

    static void a(MainThread c1)
    {
        if(c1.b(85))
            (new TempDataOutputStream(0x680000)).sendMain(c1);
    }

    static String b(n n1)
    {
        return n1.b();
    }

    public static String c(int i1)
    {
        switch(i1)
        {
        default:
            return "未知";

        case 1: // '\001'
        case 103: // 'g'
        case 108: // 'l'
            return "男剑";

        case 2: // '\002'
        case 105: // 'i'
        case 110: // 'n'
            return "女剑";

        case 3: // '\003'
        case 99: // 'c'
        case 107: // 'k'
            return "拳男";

        case 4: // '\004'
        case 101: // 'e'
        case 109: // 'm'
            return "拳女";

        case 5: // '\005'
        case 100: // 'd'
        case 104: // 'h'
            return "男弓";

        case 6: // '\006'
        case 102: // 'f'
        case 106: // 'j'
            return "女弓";
        }
    }

    @Override
    public final void a(TempDataInputStream l1)
    {
        int j1 = l1.c();
        j1;
        JVM INSTR lookupswitch 3: default 40
    //                   327687: 276
    //                   589834: 276
    //                   2686979: 276;
           goto _L1 _L2 _L2 _L2
_L1:
        int i1;
        int k1;
        String s;
        s = b();
        i1 = l1.d();
        k1 = l1.e();
        i1;
        JVM INSTR lookupswitch 8: default 132
    //                   5: 277
    //                   8: 294
    //                   9: 302
    //                   34: 310
    //                   41: 318
    //                   48: 326
    //                   86: 334
    //                   104: 342;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L3:
        Object obj = (new StringBuilder(String.valueOf(i1))).append("_").append(k1).toString();
_L49:
        Log.d(s, ((String) (obj)));
        j1;
        JVM INSTR lookupswitch 12: default 276
    //                   327688: 451
    //                   524289: 350
    //                   2228242: 894
    //                   2686977: 643
    //                   2686978: 607
    //                   3145728: 923
    //                   3145730: 1110
    //                   3145731: 928
    //                   6815744: 674
    //                   6815745: 754
    //                   6881281: 1464
    //                   6881282: 1269;
           goto _L2 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23
_L2:
        return;
_L4:
        obj = a;
_L24:
        obj = a(k1, ((String []) (obj)));
        continue; /* Loop/switch isn't completed */
_L5:
        obj = h;
        continue; /* Loop/switch isn't completed */
_L6:
        obj = b;
        continue; /* Loop/switch isn't completed */
_L7:
        obj = f;
        continue; /* Loop/switch isn't completed */
_L8:
        obj = e;
        continue; /* Loop/switch isn't completed */
_L9:
        obj = g;
        continue; /* Loop/switch isn't completed */
_L10:
        obj = d;
        continue; /* Loop/switch isn't completed */
_L11:
        obj = c;
        if(true) goto _L24; else goto _L13
_L13:
        i1 = l1.read();
        if(i1 >= 6)
        {
            obj = b();
            StringBuilder stringbuilder = new StringBuilder("Partners_invite: ");
            if(i1 - 6 < k.length)
                l1 = k[i1 - 6];
            else
                l1 = Integer.valueOf(i1);
            Log.i(((String) (obj)), stringbuilder.append(l1).toString());
            return;
        } else
        {
            Log.i(b(), (new StringBuilder("Partners_invite: ")).append(i1).toString());
            return;
        }
_L12:
        j1 = l1.readUnsignedShort();
        i1 = 0;
        do
        {
            if(i1 >= j1)
            {
                b(10);
                (new m(0x80001, 132)).a(C);
                return;
            }
            k1 = l1.readInt();
            int i2 = l1.readInt();
            String.format("%d,%d,%d,%d,%d,%d", new Object[] {
                Integer.valueOf(k1), Integer.valueOf(i2), Integer.valueOf(l1.readInt()), Integer.valueOf(l1.read()), Integer.valueOf(l1.read()), Integer.valueOf(l1.readUnsignedShort())
            });
            if(i2 == 35 || i2 == 62 || i2 == 70)
                C.d(k1);
            i1++;
        } while(true);
_L16:
        l1.readUnsignedShort();
        web.sxd.b.c.a("\u3000\u795D\u798F %d \u6B21\u7ECF\u9A8C+%d%%", new Object[] {
            Integer.valueOf(l1.readUnsignedShort()), Integer.valueOf(l1.readInt())
        });
        return;
_L15:
        if(l1.read() == 0)
        {
            web.sxd.b.c.a("\u5173\u516C\u4E0A\u9999\u6210\u529F");
            (new m(0x290002)).a(C);
            return;
        }
        if(true)
            continue; /* Loop/switch isn't completed */
_L20:
        i1 = l1.readInt();
        j1 = l1.readUnsignedShort();
        web.sxd.b.c.a("\u7075\u6C14: %d, \u846B\u82A6: %d+%d, \u7075\u8109x%d", new Object[] {
            Integer.valueOf(i1), Integer.valueOf(j1), Integer.valueOf(l1.readUnsignedShort()), Integer.valueOf(l1.readUnsignedShort())
        });
        if(j1 > 0)
        {
            c();
            (new m(0x680001, 0L)).a(C);
            return;
        }
        if(true) goto _L2; else goto _L21
_L21:
        i1 = l1.read();
        if(i1 == 0)
        {
            i1 = l1.readInt();
            j1 = l1.readInt();
            int j2;
            if(l1.read() > 0)
                obj = "\u7075\u8109";
            else
                obj = "";
            k1 = l1.readUnsignedShort();
            j2 = l1.readUnsignedShort();
            web.sxd.b.c.a("\u3000\u7075\u6C14+%d=>%d %sx%d \u5269\u4F59%d", new Object[] {
                Integer.valueOf(j1), Integer.valueOf(i1), obj, Integer.valueOf(k1), Integer.valueOf(j2)
            });
            if(j2 > 0)
            {
                c();
                (new m(0x680001, 0L)).a(C);
                return;
            }
        } else
        {
            web.sxd.b.c.a("\u6728\u846B\u82A6\u91C7\u96C6\u7075\u6C14\u5931\u8D25: %d", new Object[] {
                Integer.valueOf(i1)
            });
            return;
        }
        if(true)
            continue; /* Loop/switch isn't completed */
_L14:
        if(l1.read() == 1)
        {
            web.sxd.b.c.a("\u3000\u6210\u529F\u9886\u53D6 %d \u7075\u77F3", new Object[] {
                Integer.valueOf(l1.readInt())
            });
            return;
        }
        if(true) goto _L2; else goto _L17
_L17:
        l1.readUTF();
_L19:
        i1 = l1.read();
        k1 = l1.read();
        int k2 = l1.readInt();
        if(i1 >= 10 && k1 >= 10)
        {
            web.sxd.b.c.a("\u9F99\u5BA0:%d\u53D8%d\u9636 \u5DF2\u57F9\u517B\u6EE1", new Object[] {
                Integer.valueOf(i1 - 1), Integer.valueOf(k1)
            });
            return;
        }
        if(j1 == 0x300003)
        {
            web.sxd.b.c.a("\u9F99\u5BA0:%d\u53D8%d\u9636 \u8FDB\u5316\u6210\u529F \u7ECF\u9A8C%d", new Object[] {
                Integer.valueOf(i1 - 1), Integer.valueOf(k1), Integer.valueOf(k2)
            });
        } else
        {
            j1 = l1.readInt();
            web.sxd.b.c.a("\u9F99\u5BA0:%d\u53D8%d\u9636 \u7ECF\u9A8C%d \u5269\u4F59%d\u6B21", new Object[] {
                Integer.valueOf(i1 - 1), Integer.valueOf(k1), Integer.valueOf(k2), Integer.valueOf(j1)
            });
            if(j1 <= 0)
                continue; /* Loop/switch isn't completed */
            b(10);
        }
        c();
        (new m(0x300002, 0L)).a(C);
        return;
_L18:
        i1 = l1.read();
        if(i1 == 2)
            (new m(0x300003)).a(C);
        if(i1 == 0)
        {
            l1.read();
            l1.read();
            l1.readInt();
            i1 = l1.readInt();
            l1.read();
            j1 = l1.readInt();
            if(l1.read() > 0)
                l1 = " !!";
            else
                l1 = "";
            web.sxd.b.c.a("\u3000\u57F9\u517B\u9F99\u5BA0: \u7ECF\u9A8C+%d%s \u5269\u4F59%d\u6B21", new Object[] {
                Integer.valueOf(i1), l1, Integer.valueOf(j1)
            });
            if(j1 > 0)
            {
                b(2);
                (new m(0x300002, 0L)).a(C);
                return;
            } else
            {
                (new m(0x300000, C.d())).a(C);
                return;
            }
        }
        if(true) goto _L2; else goto _L23
_L23:
        obj = new StringBuilder("[\u730E\u5996]");
        i1 = l1.read();
        if(i1 != 5)
            ((StringBuilder) (obj)).append("\u6253\u5F00\u5B9D\u7BB1\u5931\u8D25: ");
        i1;
        JVM INSTR tableswitch 5 10: default 1340
    //                   5 1354
    //                   6 1366
    //                   7 1378
    //                   8 1390
    //                   9 1401
    //                   10 1413;
           goto _L25 _L26 _L27 _L28 _L29 _L30 _L31
_L25:
        if(i1 != 5)
        {
            web.sxd.b.c.a(((StringBuilder) (obj)).toString());
            return;
        }
        break; /* Loop/switch isn't completed */
_L26:
        ((StringBuilder) (obj)).append("\u6210\u529F");
        continue; /* Loop/switch isn't completed */
_L27:
        ((StringBuilder) (obj)).append("\u80CC\u5305\u5DF2\u6EE1");
        continue; /* Loop/switch isn't completed */
_L28:
        ((StringBuilder) (obj)).append("\u5143\u5B9D\u4E0D\u8DB3");
        continue; /* Loop/switch isn't completed */
_L29:
        ((StringBuilder) (obj)).append("\u94DC\u94B1\u4E0D\u8DB3");
        continue; /* Loop/switch isn't completed */
_L30:
        ((StringBuilder) (obj)).append("\u6CA1\u6B21\u6570\u4E86");
        continue; /* Loop/switch isn't completed */
_L31:
        ((StringBuilder) (obj)).append("\u9F99\u9C7C\u4EE4\u5DF2\u6EE1");
        if(true) goto _L25; else goto _L32
_L32:
        k1 = l1.readUnsignedShort();
        i1 = 0;
_L45:
        if(i1 < k1) goto _L34; else goto _L33
_L33:
        if(l1.read() == 1)
            ((StringBuilder) (obj)).append(" !!");
        web.sxd.b.c.a(((StringBuilder) (obj)).toString());
_L22:
        i1 = l1.read();
        k1 = l1.read();
        l1.read();
        l1.readUnsignedShort();
        if(j1 == 0x690001)
            web.sxd.b.c.a("[\u730E\u5996]\u5269\u4F59 %d\u6B21\u514D\u8D39, %d\u6B21\u94DC\u94B1\u730E\u5996", new Object[] {
                Integer.valueOf(i1), Integer.valueOf(k1)
            });
        c();
        if(i1 > 0)
        {
            (new m(0x690002, (byte)0, (byte)0)).a(C);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L34:
        int l2 = l1.read();
        int i3 = l1.readInt();
        if(l2 >= 0 && l2 < l.length)
            ((StringBuilder) (obj)).append(l[l2]);
        else
            ((StringBuilder) (obj)).append(l[l.length - 1]);
        i3;
        JVM INSTR lookupswitch 8: default 1660
    //                   347: 1715
    //                   1411: 1727
    //                   1444: 1739
    //                   1487: 1751
    //                   1740: 1763
    //                   1741: 1775
    //                   1742: 1787
    //                   1743: 1799;
           goto _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43
_L36:
        break; /* Loop/switch isn't completed */
_L35:
        ((StringBuilder) (obj)).append(i3);
_L46:
        ((StringBuilder) (obj)).append("x");
        ((StringBuilder) (obj)).append(l1.readInt());
        i1++;
        if(true) goto _L45; else goto _L44
_L44:
        ((StringBuilder) (obj)).append("\u9EC4\u7389\u724C");
          goto _L46
_L37:
        ((StringBuilder) (obj)).append("\u5973\u5A32\u77F3");
          goto _L46
_L38:
        ((StringBuilder) (obj)).append("\u7CBD\u5B50");
          goto _L46
_L39:
        ((StringBuilder) (obj)).append("\u5305\u5B50");
          goto _L46
_L40:
        ((StringBuilder) (obj)).append("\u5883\u754C\u70B9");
          goto _L46
_L41:
        ((StringBuilder) (obj)).append("\u7075\u77F3");
          goto _L46
_L42:
        ((StringBuilder) (obj)).append("\u547D\u683C\u788E\u7247");
          goto _L46
_L43:
        ((StringBuilder) (obj)).append("\u4ED9\u4EE4");
          goto _L46
        if(!web.sxd.b.c.c(81) || k1 <= 0) goto _L2; else goto _L47
_L47:
        (new m(0x690002, (byte)1, (byte)0)).a(C);
        return;
        if(true) goto _L49; else goto _L48
_L48:
    }

    final void a(int ai[])
    {
        int i1;
        int j1;
        j1 = ai.length;
        i1 = 0;
_L39:
        int k1;
        if(i1 >= j1)
        {
            if(C.b(11))
                C.a(9, b, this);
            if(C.b(85))
                C.a(104, c, this);
            if(C.b(55))
                C.a(41, e, this);
            if(C.b(48))
                C.a(34, f, this);
            if(C.b(86))
                C.a(105, d, this);
            if(C.b(60))
                C.a(48, g, this);
            j = false;
            b(ai);
            return;
        }
        k1 = ai[i1];
        if(!C.b(k1)) goto _L2; else goto _L1
_L1:
        k1;
        JVM INSTR lookupswitch 36: default 488
    //                   2: 529
    //                   8: 488
    //                   13: 620
    //                   15: 650
    //                   18: 678
    //                   34: 805
    //                   37: 495
    //                   41: 790
    //                   46: 1129
    //                   54: 730
    //                   56: 820
    //                   59: 745
    //                   64: 760
    //                   68: 605
    //                   70: 775
    //                   90: 635
    //                   116: 488
    //                   117: 994
    //                   123: 940
    //                   126: 1009
    //                   127: 955
    //                   129: 880
    //                   133: 850
    //                   134: 1024
    //                   135: 925
    //                   140: 1039
    //                   142: 1054
    //                   143: 865
    //                   146: 835
    //                   160: 1069
    //                   164: 1084
    //                   166: 1099
    //                   169: 1114
    //                   171: 708
    //                   172: 895
    //                   173: 910;
           goto _L3 _L4 _L3 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L3 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37
_L11:
        break MISSING_BLOCK_LABEL_1129;
_L3:
        break; /* Loop/switch isn't completed */
_L9:
        break; /* Loop/switch isn't completed */
_L2:
        i1++;
        if(true) goto _L39; else goto _L38
_L38:
        if(C.g() >= 40 && C.g() <= 80)
            web.sxd.d.l.a(C);
          goto _L2
_L4:
        C.a(8, h, this);
        new web.sxd.d.ab(C);
        if(C.b() <= 0)
        {
            c();
            (new m(0x50008, C.d())).a(C);
        }
        (new o(this)).start();
          goto _L2
_L16:
        new web.sxd.d.b(C);
          goto _L2
_L5:
        new e(C);
          goto _L2
_L18:
        new u(C);
          goto _L2
_L6:
        C.a(new web.sxd.d.g(C));
        web.sxd.d.g.a(C);
          goto _L2
_L7:
        new v(C);
        c();
        new web.sxd.a.m(C);
          goto _L2
_L35:
        if(C.b(15))
            web.sxd.d.g.c(C);
          goto _L2
_L12:
        new p(C);
          goto _L2
_L14:
        new web.sxd.a.l(C);
          goto _L2
_L15:
        new a(C);
          goto _L2
_L17:
        new web.sxd.d.d(C);
          goto _L2
_L10:
        new web.sxd.d.z(C);
          goto _L2
_L8:
        new av(C);
          goto _L2
_L13:
        new k(C);
          goto _L2
_L30:
        new w(C);
          goto _L2
_L24:
        new g(C);
          goto _L2
_L29:
        new y(C);
          goto _L2
_L23:
        new t(C);
          goto _L2
_L36:
        new d(C);
          goto _L2
_L37:
        new ab(C);
          goto _L2
_L26:
        new j(C);
          goto _L2
_L20:
        new ak(C);
          goto _L2
_L22:
        new web.sxd.d.j(C);
        new at(C);
        new ay(C);
          goto _L2
_L19:
        new q(C);
          goto _L2
_L21:
        new b(C);
          goto _L2
_L25:
        new web.sxd.a.n(C);
          goto _L2
_L27:
        new r(C);
          goto _L2
_L28:
        new aw(C);
          goto _L2
_L31:
        new web.sxd.a.c(C);
          goto _L2
_L32:
        new z(C);
          goto _L2
_L33:
        new x(C);
          goto _L2
_L34:
        new au(C);
          goto _L2
        new aa(C);
          goto _L2
    }

    protected final String[] a()
    {
        return a;
    }

    final void b(int ai[])
    {
        int i1;
        int j1;
        if(j)
            return;
        j = true;
        b(10);
        j1 = ai.length;
        i1 = 0;
_L38:
        if(i1 < j1) goto _L2; else goto _L1
_L1:
        c();
        j1 = ai.length;
        i1 = 0;
_L46:
        int k1;
        if(i1 >= j1)
        {
            j = false;
            return;
        }
        k1 = ai[i1];
          goto _L3
_L2:
        k1 = ai[i1];
        if(!C.b(k1)) goto _L5; else goto _L4
_L4:
        k1;
        JVM INSTR lookupswitch 32: default 332
    //                   8: 389
    //                   13: 405
    //                   18: 415
    //                   34: 495
    //                   41: 505
    //                   46: 695
    //                   54: 445
    //                   56: 515
    //                   59: 460
    //                   64: 470
    //                   68: 395
    //                   70: 480
    //                   77: 435
    //                   116: 595
    //                   117: 595
    //                   123: 585
    //                   126: 605
    //                   127: 339
    //                   129: 535
    //                   133: 525
    //                   134: 615
    //                   135: 575
    //                   140: 625
    //                   142: 635
    //                   143: 645
    //                   146: 565
    //                   160: 655
    //                   164: 665
    //                   166: 675
    //                   169: 685
    //                   172: 545
    //                   173: 555;
           goto _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37
_L6:
        break; /* Loop/switch isn't completed */
_L12:
        break MISSING_BLOCK_LABEL_695;
_L5:
        i1++;
          goto _L38
_L23:
        new web.sxd.d.g(C);
        c();
        web.sxd.d.g.b(C);
        web.sxd.d.j.b(C);
        ay.a(C);
        web.sxd.d.l.c(C);
        at.a(C);
_L7:
        c();
          goto _L5
_L17:
        web.sxd.d.b.a(C);
          goto _L7
_L8:
        web.sxd.d.e.a(C);
          goto _L7
_L9:
        v.a(C);
        c();
        web.sxd.a.m.a(C);
          goto _L7
_L19:
        web.sxd.d.g.b(C);
          goto _L7
_L13:
        b(3);
        p.a(C);
          goto _L7
_L15:
        web.sxd.a.l.a(C);
          goto _L7
_L16:
        web.sxd.d.a.a(C);
          goto _L7
_L18:
        b(3);
        web.sxd.d.d.a(C);
          goto _L7
_L10:
        av.a(C);
          goto _L7
_L11:
        z.a(C);
          goto _L7
_L14:
        web.sxd.d.k.a(C);
          goto _L7
_L25:
        web.sxd.a.g.a(C);
          goto _L7
_L24:
        t.a(C);
          goto _L7
_L36:
        web.sxd.a.d.a(C);
          goto _L7
_L37:
        ab.a(C);
          goto _L7
_L31:
        w.a(C);
          goto _L7
_L27:
        web.sxd.a.j.a(C);
          goto _L7
_L21:
        ak.a(C);
          goto _L7
_L20:
        q.a(C);
          goto _L7
_L22:
        web.sxd.a.b.a(C);
          goto _L7
_L26:
        web.sxd.a.n.a(C);
          goto _L7
_L28:
        r.a(C);
          goto _L7
_L29:
        aw.a(C);
          goto _L7
_L30:
        y.a(C);
          goto _L7
_L32:
        web.sxd.a.c.a(C);
          goto _L7
_L33:
        z.a(C);
          goto _L7
_L34:
        x.a(C);
          goto _L7
_L35:
        au.a(C);
          goto _L7
        aa.a(C);
          goto _L7
_L3:
        if(!C.b(k1)) goto _L40; else goto _L39
_L39:
        k1;
        JVM INSTR lookupswitch 5: default 776
    //                   48: 826
    //                   55: 805
    //                   60: 868
    //                   85: 783
    //                   86: 847;
           goto _L40 _L41 _L42 _L43 _L44 _L45
_L40:
        i1++;
          goto _L46
_L44:
        (new m(0x680000)).a(C);
_L47:
        c();
          goto _L40
_L42:
        (new m(0x290001, 1)).a(C);
          goto _L47
_L41:
        (new m(0x220012, 0L)).a(C);
          goto _L47
_L45:
        (new m(0x690001, (byte)1)).a(C);
          goto _L47
_L43:
        (new m(0x300000, C.d())).a(C);
          goto _L47
    }

    private static final String a[] = {
        "Role_", "", "", "", "", "", "", "exp_change_notify", "get_simple_role_list"
    };
    private static final String b[] = {
        "Friend_", "", "", "", "", "", "", "", "", "", 
        "", "notify_online_state"
    };
    private static final String c[] = {
        "Nimbus_", "nimbus_info", "gather_nimbus"
    };
    private static final String d[] = {
        "HuntDemon_", "", "open_hunt_demon", "hunt_demon"
    };
    private static final String e[] = {
        "WorshipMars_", "mars_info", "incense", "get_blessing_times_and_exp_add", "blessing_times_and_exp_add_notify", "get_remain_incense_times"
    };
    private static final String f[] = {
        "SealSoul_", "get_day_stone"
    };
    private static final String g[] = {
        "PetAnimal_", "pet_animal_info", "change_name", "feed_pet_animal", "up_pet_animal"
    };
    private static final String h[] = {
        "Partners_", "partners_invite"
    };
    private static final String i[] = {
        "HeroesWar_", "get_heroes_open_time", "open_heroes_war", "close_heroes_war", "get_heroes_player", "join_heroes_war", "get_war_result", "notify", "notify_report", "notify_heroes_result", 
        "exit_heroes_war", "finish_war", "buy_buff", "get_buff", "set_robot", "get_robot_status", "get_war_mode", "notify_first_open_heroes_war", "get_end_gift_info", "get_end_gift"
    };
    private boolean j;
    private String k[] = {
        "\u62DB\u52DF\u6210\u529F", "\u62DB\u52DF\u5931\u8D25", "\u94DC\u94B1\u4E0D\u8DB3", "\u58F0\u671B\u4E0D\u8DB3", "\u961F\u4F0D\u5DF2\u6EE1", "NOTCHANGE", "NO_ENOUGH_PIECES", "\u4F19\u4F34\u788E\u7247\u4E0D\u8DB3", "\u4E3B\u89D2\u7B49\u7EA7\u4E0D\u5230", "STAGE_COMPLETE", 
        "INSUFFICIENT_KEY"
    };
    private String l[] = {
            ",铜钱", ",", ",阅历", ",龙鱼令", ",未知"
    };

}