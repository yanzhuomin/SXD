//// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:46
//// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
//// Decompiler options: packimports(3)
//
//package web.sxd.d;
//
//import android.util.Log;
//import web.sxd.b.*;
//
//// Referenced classes of package web.sxd.d:
////            h, i
//
//public final class g extends BaseFunc
//{
//
//    public g(MainThread c1)
//    {
//        super(c1, 0xd0000);
//        b = 0;
//        c = 0;
//        d = 0;
//        e = 0;
//        g = -1;
//        h = -1;
//        i = 9;
//        j = "";
//        k = "";
//        l = new web.sxd.d.h[8];
//        m = new i[8];
//        n = false;
//        o = true;
//        p = true;
//        q = true;
//    }
//
//    static String a(g g1)
//    {
//        return g1.b();
//    }
//
//    private void a(int i1, l l1)
//    {
//        int j1 = 0;
//        do
//        {
//            if(j1 >= m.length)
//                return;
//            if(m[j1] == null)
//            {
//                m[j1] = new i(this, i1, l1);
//                return;
//            }
//            if(m[j1].a == i1)
//            {
//                m[j1].a(l1);
//                return;
//            }
//            j1++;
//        } while(true);
//    }
//
//    static void a(MainThread c1)throws Exception
//    {
//        (new TempDataOutputStream(0xd0001)).sendMain(c1);
//    }
//
//    static void a(g g1, int i1)
//    {
//        g1.b = i1;
//    }
//
//    static int b(g g1)
//    {
//        return g1.b;
//    }
//
//    public static void b(MainThread c1) throws Exception
//    {
//        (new TempDataOutputStream(0xd0013)).sendMain(c1);
//    }
//
//    public static void c(MainThread c1) throws Exception
//    {
//        (new TempDataOutputStream(0xd0015)).sendMain(c1);
//    }
//
//    private void e()
//    {
//        if(!n) goto _L2; else goto _L1
//_L1:
//        return;
//_L2:
//        int i1;
//        char c1;
//        n = true;
//        b(3);
//        if((g <= 0 || C.a) && (h <= 0 || h < 8 && !C.b(43)) && (e == 0 || web.sxd.b.c.c(16)))
//        {
//            n = false;
//            (new m(0xd000c)).a(C);
//            return;
//        }
//        c1 = '\u70D8';
//        i1 = 0;
//_L5:
//        if(i1 < l.length) goto _L4; else goto _L3
//_L3:
//        int k1;
//        k1 = 0;
//        i1 = c1;
//_L6:
//        if(k1 < l.length)
//            break MISSING_BLOCK_LABEL_442;
//        n = false;
//        int j1 = i1;
//        if(i1 == 28888)
//            j1 = 300;
//        StringBuilder stringbuilder = new StringBuilder("\u3000\u836F\u56ED\u6CA1\u6709\u53EF\u7528\u571F\u5730, ");
//        Object obj;
//        if(o)
//            obj = "\u518D\u7B49";
//        else
//            obj = "\u7B49\u5F85";
//        obj = stringbuilder.append(((String) (obj))).toString();
//        if(j1 < 60)
//            web.sxd.b.c.a("%s %d\u79D2", new Object[] {
//                obj, Integer.valueOf(j1)
//            });
//        else
//        if(j1 < 4000)
//            web.sxd.b.c.a("%s %d\u5206\u949F", new Object[] {
//                obj, Integer.valueOf(j1 / 60)
//            });
//        else
//            web.sxd.b.c.a("%s %d\u65F6 %d\u5206", new Object[] {
//                obj, Integer.valueOf(j1 / 3600), Integer.valueOf((j1 / 60) % 60)
//            });
//        if(!o)
//        {
//            o = true;
//            b(j1 * 5);
//            o = false;
//            (new m(0xd0000)).a(C);
//            return;
//        }
//          goto _L1
//_L4:
//        if((C.b(43) && h > 0 || h == 8) && l[i1] != null && l[i1].b == b && l[i1].a())
//        {
//            Log.v(b(), (new StringBuilder("plants Coins @ #")).append(l[i1].a).toString());
//            l[i1].d = 0;
//            (new m(0xd0002, 3L)).a(C);
//            b(2);
//            obj = new m(0xd0005, l[i1].a);
//            ((m) (obj)).writeInt(c);
//            ((m) (obj)).write(3);
//            ((m) (obj)).write(1);
//            ((m) (obj)).a(C);
//            n = false;
//            return;
//        }
//        i1++;
//          goto _L5
//        j1 = i1;
//        if(l[k1] != null)
//            if(!l[k1].a())
//            {
//                j1 = i1;
//                if(l[k1].c > 0)
//                {
//                    j1 = i1;
//                    if(l[k1].c < i1)
//                        j1 = l[k1].c;
//                }
//            } else
//            {
//                if(h == 8)
//                {
//                    Log.v(b(), (new StringBuilder("plants Coins @ #")).append(l[k1].a).toString());
//                    l[k1].d = 0;
//                    (new m(0xd0002, 3L)).a(C);
//                    b(2);
//                    obj = new m(0xd0005, l[k1].a);
//                    ((m) (obj)).writeInt(c);
//                    ((m) (obj)).write(3);
//                    ((m) (obj)).write(1);
//                    ((m) (obj)).a(C);
//                    n = false;
//                    return;
//                }
//                if(g > 0 && !C.a)
//                {
//                    Log.v(b(), (new StringBuilder("plants XianLing @ #")).append(l[k1].a).toString());
//                    l[k1].d = 0;
//                    (new m(0xd0002, 4L)).a(C);
//                    b(2);
//                    obj = new m(0xd0005, l[k1].a);
//                    ((m) (obj)).writeInt(0);
//                    ((m) (obj)).write(4);
//                    ((m) (obj)).write(1);
//                    ((m) (obj)).a(C);
//                    n = false;
//                    return;
//                }
//                if(e > 0 && !web.sxd.b.c.c(16))
//                {
//                    Log.v(b(), (new StringBuilder("plants EXP @ #")).append(l[k1].a).toString());
//                    l[k1].d = 0;
//                    (new m(0xd0002, 2L)).a(C);
//                    b(2);
//                    obj = new m(0xd0005, l[k1].a);
//                    ((m) (obj)).writeInt(e);
//                    ((m) (obj)).write(2);
//                    ((m) (obj)).write(1);
//                    ((m) (obj)).a(C);
//                    n = false;
//                    return;
//                }
//                j1 = i1;
//                if(l[k1].c > 0)
//                {
//                    j1 = i1;
//                    if(l[k1].c < i1)
//                        j1 = l[k1].c;
//                }
//            }
//        k1++;
//        i1 = j1;
//          goto _L6
//    }
//
//    public final void a(l l1)
//    {
//        int i1;
//        int k1;
//        int i2;
//        i1 = 0;
//        k1 = 0;
//        i2 = 0;
//        super.a(l1);
//        l1.c();
//        JVM INSTR tableswitch 851968 851993: default 136
//    //                   851968 137
//    //                   851969 1536
//    //                   851970 357
//    //                   851971 136
//    //                   851972 136
//    //                   851973 406
//    //                   851974 799
//    //                   851975 136
//    //                   851976 136
//    //                   851977 136
//    //                   851978 1457
//    //                   851979 136
//    //                   851980 1147
//    //                   851981 136
//    //                   851982 1063
//    //                   851983 136
//    //                   851984 136
//    //                   851985 1373
//    //                   851986 1373
//    //                   851987 1402
//    //                   851988 1427
//    //                   851989 1959
//    //                   851990 2398
//    //                   851991 2641
//    //                   851992 2675
//    //                   851993 2755;
//           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L6 _L1 _L1 _L1 _L7 _L1 _L8 _L1 _L9 _L1 _L1 _L10 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
//_L1:
//        return;
//_L2:
//        int k2;
//        k2 = l1.readUnsignedShort();
//        i1 = 0;
//_L20:
//        if(i1 < k2) goto _L19; else goto _L18
//_L18:
//        i1 = i2;
//_L22:
//        if(i1 >= l.length)
//        {
//            e();
//            return;
//        }
//        break MISSING_BLOCK_LABEL_255;
//_L19:
//        int l2;
//        l2 = l1.readInt();
//        k1 = 0;
//_L21:
//        if(k1 < l.length)
//            if(l[k1] == null)
//            {
//                l[k1] = new web.sxd.d.h(this, l2, l1);
//            } else
//            {
//label0:
//                {
//                    if(l[k1].a != l2)
//                        break label0;
//                    l[k1].a(l1);
//                }
//            }
//        i1++;
//          goto _L20
//        k1++;
//          goto _L21
//        if(l[i1] != null && l[i1].b())
//        {
//            Log.v(b(), (new StringBuilder("harvest @ #")).append(l[i1].a).toString());
//            (new m(0xd0006, l[i1].a, (byte)15)).a(C);
//            c();
//            l[i1].d = 1;
//        }
//        i1++;
//          goto _L22
//_L4:
//        Log.v(b(), String.format("get_herbs_seed: %d,%dYB|%d", new Object[] {
//            Integer.valueOf(l1.readInt()), Integer.valueOf(l1.readInt()), Integer.valueOf(l1.read())
//        }));
//        return;
//_L5:
//        String s4;
//        i2 = l1.read();
//        k1 = l1.readInt();
//        String s = b();
//        k2 = l1.readInt();
//        String s2 = l1.readUTF();
//        s4 = l1.readUTF();
//        Log.d(s, String.format("%dplant_herbs#%d: %d(%s)%s(Lv%d)%d/%d|%d(Lv.%d)", new Object[] {
//            Integer.valueOf(i2), Integer.valueOf(k1), Integer.valueOf(k2), s2, s4, Integer.valueOf(l1.readInt()), Long.valueOf(l1.readLong()), Long.valueOf(l1.readLong()), Integer.valueOf(l1.readInt()), Integer.valueOf(l1.readInt())
//        }));
//        h = l1.readInt();
//        g = l1.readInt();
//        l1.read();
//        k2 = l1.read();
//        k2;
//        JVM INSTR tableswitch 2 4: default 600
//    //                   2 706
//    //                   3 724
//    //                   4 752;
//           goto _L23 _L24 _L25 _L26
//_L23:
//        web.sxd.b.c.a("\u3000%s \u79CD\u690Did=%d\u6811", new Object[] {
//            s4, Integer.valueOf(k2)
//        });
//_L27:
//        c();
//        if(i2 != 8)
//            continue; /* Loop/switch isn't completed */
//        (new m(0xd0006, k1, (byte)15)).a(C);
//        b(2);
//        if(k2 == 2)
//            break MISSING_BLOCK_LABEL_782;
//_L28:
//        if(i1 >= l.length)
//            continue; /* Loop/switch isn't completed */
//        if(l[i1] != null && l[i1].a == k1)
//        {
//            l[i1].d = 1;
//            return;
//        }
//        break MISSING_BLOCK_LABEL_775;
//_L24:
//        web.sxd.b.c.a("  %s \u4E0A\u9635\u7B49\u7EA7\u6700\u4F4E,\u79CD\u690D\u7ECF\u9A8C\u6811", new Object[] {
//            s4
//        });
//          goto _L27
//_L25:
//        web.sxd.b.c.a("\u3000%s \u79CD\u690D\u53D1\u8D22\u6811, \u5269 %d\u6EF4\u4ED9\u9732", new Object[] {
//            s4, Integer.valueOf(h)
//        });
//          goto _L27
//_L26:
//        web.sxd.b.c.a("\u3000\u81EA\u52A8\u79CD\u690D\u4ED9\u4EE4\u6811, \u5269\u4F59 %d \u4ED9\u4EE4\u79CD\u5B50", new Object[] {
//            Integer.valueOf(g)
//        });
//          goto _L27
//        i1++;
//          goto _L28
//        (new m(0xd0000)).a(C);
//        return;
//_L6:
//        i1 = l1.read();
//        StringBuilder stringbuilder = new StringBuilder(l1.readUTF());
//        stringbuilder.append(" \u6536\u83B7");
//        stringbuilder.append(l1.readUTF().replace("\u666E\u901A", ""));
//        long l3 = l1.readLong();
//        k1 = l1.readInt();
//        if(l3 > 0L || k1 > 0)
//        {
//            if(k1 > 0)
//            {
//                stringbuilder.append((new StringBuilder(", \u5347\u81F3")).append(k1).append("\u7EA7").toString());
//                if(k1 >= C.g())
//                    e = 0;
//            }
//            stringbuilder.append((new StringBuilder(", \u7ECF\u9A8C+")).append(l3).toString());
//        }
//        k1 = l1.readInt();
//        if(k1 > 0)
//            stringbuilder.append((new StringBuilder(", \u94DC\u94B1+")).append(k1).toString());
//        k1 = l1.readInt();
//        if(k1 > 0)
//            stringbuilder.append((new StringBuilder(", \u4ED9\u4EE4+")).append(k1).toString());
//        if(l1.readInt() <= 0)
//            stringbuilder.append(",");
//        web.sxd.b.c.a(stringbuilder.toString());
//        Log.i(b(), (new StringBuilder(String.valueOf(i1))).append("harvest HerbsType ").append(l1.read()).toString());
//        return;
//_L9:
//        i1 = l1.readInt();
//        web.sxd.b.c.a("\u3000\u53EF\u79CD\u690D %d \u68F5\u53D1\u8D22\u6811", new Object[] {
//            Integer.valueOf(i1)
//        });
//        if(i1 < h || h < 0)
//        {
//            h = i1;
//            return;
//        }
//        h = i1;
//        if(!n && C.b(15))
//        {
//            (new m(0xd0000)).a(C);
//            return;
//        }
//        continue; /* Loop/switch isn't completed */
//_L8:
//        h = l1.readInt();
//        if(o)
//        {
//            web.sxd.b.c.a("\u3000\u53EF\u79CD\u690D %d \u68F5\u53D1\u8D22\u6811", new Object[] {
//                Integer.valueOf(h)
//            });
//            return;
//        }
//        l1.skipBytes(8);
//        i1 = l1.readInt();
//        if(h > 0)
//        {
//            web.sxd.b.c.a("\u3000\u53EF\u79CD\u690D %d \u68F5\u53D1\u8D22\u6811", new Object[] {
//                Integer.valueOf(h)
//            });
//        } else
//        {
//            if(i1 < 60)
//                web.sxd.b.c.a("%s %d\u79D2", new Object[] {
//                    "\u3000\u836F\u56ED\u6CA1\u6709\u53EF\u7528\u4ED9\u9732, \u7B49\u5F85", Integer.valueOf(i1)
//                });
//            else
//            if(i1 < 4000)
//                web.sxd.b.c.a("%s %d\u5206\u949F", new Object[] {
//                    "\u3000\u836F\u56ED\u6CA1\u6709\u53EF\u7528\u4ED9\u9732, \u7B49\u5F85", Integer.valueOf(i1 / 60)
//                });
//            else
//                web.sxd.b.c.a("%s %d\u65F6 %d\u5206", new Object[] {
//                    "\u3000\u836F\u56ED\u6CA1\u6709\u53EF\u7528\u4ED9\u9732, \u7B49\u5F85", Integer.valueOf(i1 / 3600), Integer.valueOf((i1 / 60) % 60)
//                });
//            b(i1 * 5);
//        }
//        if(!n && C.b(15))
//        {
//            (new m(0xd0000)).a(C);
//            return;
//        }
//        continue; /* Loop/switch isn't completed */
//_L10:
//        g = l1.readInt();
//        web.sxd.b.c.a("\u3000\u53EF\u79CD\u690D %d \u68F5\u4ED9\u4EE4\u6811", new Object[] {
//            Integer.valueOf(g)
//        });
//        return;
//_L11:
//        if(l1.read() > 0)
//        {
//            (new m(0xd0014)).a(C);
//            return;
//        }
//        continue; /* Loop/switch isn't completed */
//_L12:
//        if(l1.read() == 8)
//        {
//            web.sxd.b.c.a("[\u836F\u56ED]\u6210\u529F\u9886\u53D6\u6BCF\u65E5\u4ED9\u4EE4 %s", new Object[] {
//                Integer.valueOf(l1.read())
//            });
//            return;
//        }
//        continue; /* Loop/switch isn't completed */
//_L7:
//        i1 = l1.readInt();
//        k1 = l1.readInt();
//        Log.v(b(), (new StringBuilder("plants: ")).append(k1).append("/").append(i1).toString());
//        if(k1 < i1 && k1 < i)
//        {
//            i = k1;
//            b(3);
//            e();
//            return;
//        } else
//        {
//            i = k1;
//            return;
//        }
//_L3:
//        if(web.sxd.b.c.c(76))
//            f = 0;
//        else
//            f = C.g();
//        k1 = l1.readUnsignedShort();
//        i1 = 0;
//        do
//        {
//            if(i1 >= k1)
//            {
//                if(C.b(43) && h < 0)
//                    (new m(0xd000c)).a(C);
//                b(10);
//                o = false;
//                Log.i(b(), (new StringBuilder("Farm Role: max[")).append(c).append("] Lv.").append(d).append(" min[").append(e).append("] Lv.").append(f).toString());
//                String s1 = j;
//                i1 = d;
//                String s3 = k;
//                k1 = f;
//                if(web.sxd.b.c.c(16))
//                    l1 = "x";
//                else
//                    l1 = "";
//                web.sxd.b.c.a("\u79CD\u5730: %s %d\u7EA7, %s %d\u7EA7%s", new Object[] {
//                    s1, Integer.valueOf(i1), s3, Integer.valueOf(k1), l1
//                });
//                (new m(0xd0000)).a(C);
//                return;
//            }
//            i2 = l1.readInt();
//            l1.readUTF();
//            s1 = l1.readUTF();
//            k2 = l1.readInt();
//            l1.skipBytes(28);
//            l2 = l1.read();
//            if(k2 > d)
//            {
//                d = k2;
//                c = i2;
//                j = s1;
//            }
//            if(l2 == 5 && (!web.sxd.b.c.c(76) && (k2 < f || k2 == f && i2 > e) || web.sxd.b.c.c(76) && (k2 > f || k2 == f && i2 > e) && k2 < C.g()))
//            {
//                f = k2;
//                e = i2;
//                k = s1;
//            }
//            i1++;
//        } while(true);
//_L13:
//        k1 = l1.readUnsignedShort();
//        i1 = 0;
//_L33:
//        if(i1 < k1) goto _L30; else goto _L29
//_L29:
//        i1 = 0;
//_L34:
//        if(i1 < m.length) goto _L32; else goto _L31
//_L31:
//        i2 = 28888;
//        k1 = 0;
//_L35:
//        if(k1 >= m.length)
//        {
//            if(i2 <= 0)
//                break MISSING_BLOCK_LABEL_2380;
//            StringBuilder stringbuilder1 = new StringBuilder("\u3000\u679C\u56ED\u6CA1\u6709\u53EF\u7528\u571F\u5730, ");
//            if(p)
//                l1 = "\u518D\u7B49";
//            else
//                l1 = "\u7B49\u5F85";
//            l1 = stringbuilder1.append(l1).toString();
//            if(i2 < 60)
//            {
//                web.sxd.b.c.a("%s %d\u79D2", new Object[] {
//                    l1, Integer.valueOf(i2)
//                });
//                return;
//            }
//            break MISSING_BLOCK_LABEL_2307;
//        }
//        break MISSING_BLOCK_LABEL_2180;
//_L30:
//        a(l1.readInt(), l1);
//        i1++;
//          goto _L33
//_L32:
//        if(m[i1] != null && m[i1].b())
//        {
//            Log.v(b(), (new StringBuilder("harvest @ #")).append(m[i1].a).toString());
//            (new m(0xd0019, m[i1].a)).a(C);
//            c();
//            m[i1].d = 1;
//        }
//        i1++;
//          goto _L34
//        i1 = i2;
//        if(m[k1] != null)
//            if(!m[k1].a())
//            {
//                i1 = i2;
//                if(m[k1].c > 0)
//                {
//                    i1 = i2;
//                    if(m[k1].c < i2)
//                        i1 = m[k1].c;
//                }
//            } else
//            {
//                i1 = i2;
//                if(m[k1].c >= 0)
//                {
//                    i1 = i2;
//                    if(m[k1].c < i2)
//                        i1 = m[k1].c;
//                }
//            }
//        k1++;
//        i2 = i1;
//          goto _L35
//        if(i2 < 4000)
//        {
//            web.sxd.b.c.a("%s %d\u5206\u949F", new Object[] {
//                l1, Integer.valueOf(i2 / 60)
//            });
//            return;
//        } else
//        {
//            web.sxd.b.c.a("%s %d\u65F6 %d\u5206", new Object[] {
//                l1, Integer.valueOf(i2 / 3600), Integer.valueOf((i2 / 60) % 60)
//            });
//            return;
//        }
//        (new m(0xd0016)).a(C);
//        return;
//_L14:
//        i2 = l1.readUnsignedShort();
//        i1 = 0;
//_L36:
//        int i3;
//        if(i1 >= i2)
//            continue; /* Loop/switch isn't completed */
//        k2 = l1.readInt();
//        k1 = l1.readInt();
//        l1.readInt();
//        l2 = l1.readInt();
//        i3 = l1.readInt();
//        if(k1 <= 0)
//            break MISSING_BLOCK_LABEL_2561;
//        k1 = 0;
//_L37:
//        if(k1 < m.length)
//        {
//label1:
//            {
//                if(m[k1] == null || !m[k1].a() || k2 != 169 && k2 != 171 && k2 != 172 && k2 != 173 && k2 != 174)
//                    break label1;
//                (new m(0xd0018, m[k1].a, k2)).a(C);
//            }
//        }
//_L38:
//        i1++;
//          goto _L36
//        k1++;
//          goto _L37
//        if((k2 == 169 || k2 == 171 || k2 == 172 || k2 == 173 || k2 == 174) && l2 > 0 && i3 == 0)
//            (new m(0xd0017, k2)).a(C);
//        else
//            q = false;
//          goto _L38
//_L15:
//        if(l1.read() == 8 && q)
//        {
//            (new m(0xd0016)).a(C);
//            return;
//        }
//        continue; /* Loop/switch isn't completed */
//_L16:
//        if(l1.read() == 8)
//        {
//            int j2 = l1.readInt();
//            (new m(0xd0019, j2)).a(C);
//            c();
//            int j1 = k1;
//            while(j1 < m.length)
//            {
//                if(m[j1].a == j2)
//                {
//                    m[j1].d = 1;
//                    return;
//                }
//                j1++;
//            }
//        }
//        if(true) goto _L1; else goto _L17
//_L17:
//        (new m(0xd0015)).a(C);
//        return;
//    }
//
//    protected final String[] a()
//    {
//        return a;
//    }
//
//    private static final String a[] = {
//        "FARM_", "get_farmlandinfo_list", "get_player_roleinfo_list", "get_herbs_seed", "refresh_herbs_seed", "get_top_herbs_seed", "plant_herbs", "harvest", "reclamation", "check_role_state",
//        "harvest_check_remain_exp", "get_simple_farmlandinfo", "clear_farmland_cd", "buy_coin_tree_count_info", "buy_coin_tree_count", "coin_tree_count_notify", "ingot_for_farmland", "up_farmland_level", "xianling_tree_count_notify", "xianling_tree_count_info",
//        "is_player_get_xian_ling_gift", "player_get_xian_ling_gift", "get_new_farmlandinfo_list", "new_farmland_herbs_list", "buy_new_herbs", "plant_new_herbs", "harvest_new", "new_clear_farmland_cd"
//    };
//    private int b;
//    private int c;
//    private int d;
//    private int e;
//    private int f;
//    private int g;
//    private int h;
//    private int i;
//    private String j;
//    private String k;
//    private web.sxd.d.h l[];
//    private i m[];
//    private boolean n;
//    private boolean o;
//    private boolean p;
//    private boolean q;
//
//}