//// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:47
//// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
//// Decompiler options: packimports(3)
//
//package web.sxd.d;
//
//import android.util.Log;
//
//import web.sxd.b.BaseFunc;
//import web.sxd.b.MainThread;
//import web.sxd.b.TempDataOutputStream;
//
//
//// Referenced classes of package web.sxd.d:
////            n
//
//public final class l extends BaseFunc
//{
//
//    public l(MainThread c1)
//    {
//        super(c1, 0x2a0001);
//        c = false;
//        d = false;
//        e = -1;
//        f = 0;
//        g = -1;
//        h = 0;
//        i = 0;
//        j = 0;
//    }
//
//    static void a(MainThread c1) throws Exception
//    {
//        (new TempDataOutputStream(0x2a0000)).sendMain(c1);
//    }
//
//    static void b(MainThread c1) throws Exception
//    {
//        if(a == 1)
//            (new TempDataOutputStream(0x2a0004)).sendMain(c1);
//    }
//
//    private void b(web.sxd.b.TempDataInputStream l1) throws  Exception
//    {
//        int k;
//        int i1;
//        int j1;
//        int k1;
//        int i2;
//        int j3;
//        String s;
//        k1 = -1;
//        s = "";
//        j3 = l1.readUnsignedShort();
//        i2 = 0;
//        i1 = 0;
//        j1 = -1;
//        k = -1;
//while(true) {//TODO 逻辑待定
//    int j2;
//    int l2;
//    int i3;
//    String s1;
//    if (i2 >= j3) {
//        String str = "";
//        if (k1 > 0)
//            str = (new StringBuilder(", 我")).append(k1).toString();
//        if (j1 > 0 && (e != j1 || i1 > f)) {
//            e = j1;
//            f = i1;
//            g = k;
//            web.sxd.b.MainThread.sendLog("[阵营]%s %d连杀%s", new Object[]{
//                    s, Integer.valueOf(i1), str
//            });
//        }
//        return;
//    }
//    i3 = l1.readInt();
//    s1 = l1.readUTF();
//    j2 = l1.readUnsignedShort();
//    l2 = l1.read();
//    s1 = (new StringBuilder(String.valueOf(n.c(l1.readInt())))).append(" ").append(s1).toString();
//    if (i3 != C.d())
//        break; /* Loop/switch isn't completed */
//    k1 = k;
//    k = j2;
//
//    //_L3:
//    j2 = i2 + 1;
//    i2 = k1;
//    k1 = k;
//    k = i2;
//    i2 = j2;
//
//    if(i3 > 0 && j2 > i1)
//    {
//        s = s1;
//        k = k1;
//        j1 = i3;
//        i1 = j2;
//        k1 = l2;
//    } else
//    {
//        int k2 = k;
//        k = k1;
//        k1 = k2;
//    }
//
//}
////        if(true) goto _L2; else goto _L1
////_L1:
////        if(i3 > 0 && j2 > i1)
////        {
////            s = s1;
////            k = k1;
////            j1 = i3;
////            i1 = j2;
////            k1 = l2;
////        } else
////        {
////            int k2 = k;
////            k = k1;
////            k1 = k2;
////        }
////          goto _L3
////        if(true) goto _L2; else goto _L4
////_L4:
//    }
//
//    public static void c(MainThread c1) throws Exception
//    {
//        (new TempDataOutputStream(0x2a0011)).sendMain(c1);
//    }
//
//    public final void a(web.sxd.b.TempDataInputStream l1)
//    {
//        try {
//
//            int k;
//            k = l1.getFuncCode();
//            if (k != 0x2a0008 && k != 0x2a0006)
//                super.a(l1);
//            switch (k) {
//                default:
//                    return;
//                case 2752512://0x2A0000
//                    int l2;
//                    a = l1.read();
//                    l2 = l1.readUnsignedShort();
//                    k = 0;
//                    int l3;
//                    int j4;
//                    while (k < l2) {
//                        l3 = l1.readInt();
//                        j4 = l1.readInt();
//                        if (System.currentTimeMillis() <= (long) l3 * 1000L) {
//                            web.sxd.b.MainThread.sendLog("[阵营战]今日未未开始 ");
//                        } else {
//                            if (System.currentTimeMillis() < (long) j4 * 1000L)
//                                continue; /* Loop/switch isn't completed */
//                            web.sxd.b.MainThread.sendLog("[阵营战]今日已结束 ");
//                        }
//                        k++;
//                    }
//                    if (System.currentTimeMillis() <= (long) l3 * 1000L || System.currentTimeMillis() >= (long) j4 * 1000L)
//                        return;
//                    a = 1;
//                    (new TempDataOutputStream(0x2a000f)).sendMain(C);
//                    return;
//
//                case 2752513 ://0x2A0001
//                    i = 0;
//                    j = 0;
//                    f = 0;
//                    e = -1;
//                    g = -1;
//                    c();
//                    (new TempDataOutputStream(0x2a000b, 18L)).sendMain(C);
//                    b(C);
//                    l1.skipBytes(25);
//                    b(l1);
//                    return;
//                case 2752514 :
//                case 2752515 :return;
//                case 2752516 :
//                    int i2 = l1.read();
//                    switch(i2)
//                    {
//                        default:
//                            web.sxd.b.MainThread.sendLog("[阵营战]加入失败: %d", new Object[] {
//                                    Integer.valueOf(i2)
//                            });
//                            // fall through
//
//                        case 6: // '\006'
//                            C.n();
//                            return;
//
//                        case 5: // '\005'
//                            d = true;
//                            break;
//                    }
//                    if(web.sxd.b.MainThread.isFuncSelect(25))
//                    {
//                        web.sxd.b.MainThread.sendLog("[阵营战]加入成功, 祝您百战百胜");
//                        return;
//                    }
//                    return;
//                case 2752517 :return;
//                case 2752518 ://_L5
//                    int i1 = l1.read();
//                    int l4 = l1.readUnsignedShort();
//                    switch(i1)
//                    {
//                        case 3: // '\003'
//                        case 4: // '\004'
//                        case 5: // '\005'
//                        case 6: // '\006'
//                        case 7: // '\007'
//                        case 10: // '\n'
//                        case 13: // '\r'
//                        default:
//                            return;
//
//                        case 2: // '\002'
//                            web.sxd.b.MainThread.sendLog("[阵营]群英战开始了");
//                            c();
//                            (new TempDataOutputStream(0x2a0001)).sendMain(C);
//                            return;
//
//                        case 9: // '\t'
//                        case 11: // '\013'
//                            int j1 = 0;
//                            byte byte0 = -1;
//                            do
//                            {
//                                if(j1 >= l4)
//                                {
//                                    if(!web.sxd.b.MainThread.isFuncSelect(25) && byte0 >= 0)
//                                    {
//                                        c();
//                                        if(d)
//                                        {
//                                            d = false;
//                                            int i4;
//                                            int k4;
//                                            int i5;
//                                            int j5;
//                                            int k5;
//                                            String s;
//                                            String s1;
//                                            if(!c && g >= 0 && byte0 != g && h < 100)
//                                            {
//                                                (new TempDataOutputStream(0x2a0009)).sendMain(C);
//                                                h = h + 1;
//                                                c();
//                                                b(C);
//                                                return;
//                                            } else
//                                            {
//                                                web.sxd.b.MainThread.sendLog("[阵营战]加入完成, 祝您百战百胜");
//                                                return;
//                                            }
//                                        }
//                                    }
//                                    continue; /* Loop/switch isn't completed */
//                                }
//                                i5 = l1.readInt();
//                                s = l1.readUTF();
//                                k4 = l1.read();
//                                j5 = l1.readUnsignedShort();
//                                i4 = l1.readUnsignedShort();
//                                k5 = l1.read();
//                                s1 = String.format("%d,%s,%d,%d,%d,%d", new Object[] {
//                                        Integer.valueOf(i5), s, Integer.valueOf(k4), Integer.valueOf(j5), Integer.valueOf(i4), Integer.valueOf(k5)
//                                });
//                                i4 = byte0;
//                                if(k5 == 3)
//                                {
//                                    if(s.length() > 0)
//                                        Log.i(b(), s1);
//                                    if(i5 == e && C.g() >= j5)
//                                    {
//                                        g = k4;
//                                        i4 = byte0;
//                                    } else
//                                    {
//                                        i4 = byte0;
//                                        if(i5 == C.d())
//                                            i4 = k4;
//                                    }
//                                }
//                                j1++;
//                                byte0 = i4;
//                            } while(true);
//
//                        case 8: // '\b'
//                            web.sxd.b.c.a("[\u9635\u8425]\u7FA4\u82F1\u6218\u7ED3\u675F\u4E86");
//                            return;
//                        continue; /* Loop/switch isn't completed */
//
//                        case 12: // '\f'
//                            int k1 = 0;
//                            do
//                            {
//                                if(k1 >= l4)
//                                {
//                                    int i3 = l1.readUnsignedShort();
//                                    k1 = 0;
//                                    while(k1 < i3)
//                                    {
//                                        Log.i(b(), (new StringBuilder(String.valueOf(k1 + 1))).append("th ").append(l1.readUnsignedShort()).append(",").append(l1.readUnsignedShort()).toString());
//                                        b(l1);
//                                        k1++;
//                                    }
//                                    continue; /* Loop/switch isn't completed */
//                                }
//                                l1.readInt();
//                                l1.readUTF();
//                                l1.skipBytes(6);
//                                k1++;
//                            } while(true);
//
//                        case 14: // '\016'
//                            web.sxd.b.c.a("[\u9635\u8425\u6218]\u5F00\u59CB\u4E00\u573A\u6218\u6597");
//                            c = false;
//                            b(5);
//                            (new m(0x2a000a)).a(C);
//                            b(65);
//                            c = true;
//                            return;
//                        break;
//
//                        case 15: // '\017'
//                            web.sxd.b.c.a("[\u9635\u8425\u6218]\u73B0\u5728\u53EF\u4EE5\u52A0\u5165\u6218\u6597");
//                            h = 0;
//                            b(C);
//                            return;
//                    }
//                    continue; /* Loop/switch isn't completed */
//                case 2752519 410
//                case 2752520 410
//                case 2752521 112
//                case 2752522 112
//                case 2752523 1082
//                case 2752524 112
//                case 2752525 112
//                case 2752526 112
//                case 2752527 186
//                case 2752528 1064
//                case 2752529 113
//                case 2752530 139;
//            }
//        }catch (Exception e)
//        {
//            Log.v("web.sxd.d.l",e.getLocalizedMessage(),e);
//        }
//        k;
//        JVM INSTR tableswitch 2752512 2752530: default 112
//    //                   2752512 215
//    //                   2752513 343
//    //                   2752514 112
//    //                   2752515 112
//    //                   2752516 990
//    //                   2752517 112
//    //                   2752518 416
//    //                   2752519 410
//    //                   2752520 410
//    //                   2752521 112
//    //                   2752522 112
//    //                   2752523 1082
//    //                   2752524 112
//    //                   2752525 112
//    //                   2752526 112
//    //                   2752527 186
//    //                   2752528 1064
//    //                   2752529 113
//    //                   2752530 139;
//           goto _L1 _L2 _L3 _L1 _L1 _L4 _L1 _L5 _L6 _L6 _L1 _L1 _L7 _L1 _L1 _L1 _L8 _L9 _L10 _L11
//_L1:
//        return;
//_L10:
//        if(l1.read() == 27)
//        {
//            (new m(0x2a0012)).a(C);
//            return;
//        }
//        continue; /* Loop/switch isn't completed */
//_L11:
//        k = l1.read();
//        int k2 = l1.readInt();
//        int k3 = l1.readInt();
//        if(k == 27)
//        {
//            web.sxd.b.c.a("[\u793C\u5305]\u9635\u8425\u6218\u7EC8\u7ED3\u793C\u5305\u9886\u53D6\u6210\u529F,\u94DC\u94B1 %d,\u58F0\u671B %d", new Object[] {
//                Integer.valueOf(k3), Integer.valueOf(k2)
//            });
//            return;
//        }
//        continue; /* Loop/switch isn't completed */
//_L8:
//        if((long)l1.read() == 26L)
//        {
//            (new m(0x2a0001)).a(C);
//            return;
//        }
//        continue; /* Loop/switch isn't completed */
//
//
//_L6:
//        c = false;
//        return;
//_L5:
//        int i1 = l1.read();
//        int l4 = l1.readUnsignedShort();
//        switch(i1)
//        {
//        case 3: // '\003'
//        case 4: // '\004'
//        case 5: // '\005'
//        case 6: // '\006'
//        case 7: // '\007'
//        case 10: // '\n'
//        case 13: // '\r'
//        default:
//            return;
//
//        case 2: // '\002'
//            web.sxd.b.c.a("[\u9635\u8425]\u7FA4\u82F1\u6218\u5F00\u59CB\u4E86");
//            c();
//            (new m(0x2a0001)).a(C);
//            return;
//
//        case 9: // '\t'
//        case 11: // '\013'
//            int j1 = 0;
//            byte byte0 = -1;
//            do
//            {
//                if(j1 >= l4)
//                {
//                    if(!web.sxd.b.c.c(25) && byte0 >= 0)
//                    {
//                        c();
//                        if(d)
//                        {
//                            d = false;
//                            int i4;
//                            int k4;
//                            int i5;
//                            int j5;
//                            int k5;
//                            String s;
//                            String s1;
//                            if(!c && g >= 0 && byte0 != g && h < 100)
//                            {
//                                (new m(0x2a0009)).a(C);
//                                h = h + 1;
//                                c();
//                                b(C);
//                                return;
//                            } else
//                            {
//                                web.sxd.b.c.a("[\u9635\u8425\u6218]\u52A0\u5165\u5B8C\u6210, \u795D\u60A8\u767E\u6218\u767E\u80DC");
//                                return;
//                            }
//                        }
//                    }
//                    continue; /* Loop/switch isn't completed */
//                }
//                i5 = l1.readInt();
//                s = l1.readUTF();
//                k4 = l1.read();
//                j5 = l1.readUnsignedShort();
//                i4 = l1.readUnsignedShort();
//                k5 = l1.read();
//                s1 = String.format("%d,%s,%d,%d,%d,%d", new Object[] {
//                    Integer.valueOf(i5), s, Integer.valueOf(k4), Integer.valueOf(j5), Integer.valueOf(i4), Integer.valueOf(k5)
//                });
//                i4 = byte0;
//                if(k5 == 3)
//                {
//                    if(s.length() > 0)
//                        Log.i(b(), s1);
//                    if(i5 == e && C.g() >= j5)
//                    {
//                        g = k4;
//                        i4 = byte0;
//                    } else
//                    {
//                        i4 = byte0;
//                        if(i5 == C.d())
//                            i4 = k4;
//                    }
//                }
//                j1++;
//                byte0 = i4;
//            } while(true);
//
//        case 8: // '\b'
//            web.sxd.b.c.a("[\u9635\u8425]\u7FA4\u82F1\u6218\u7ED3\u675F\u4E86");
//            return;
//            continue; /* Loop/switch isn't completed */
//
//        case 12: // '\f'
//            int k1 = 0;
//            do
//            {
//                if(k1 >= l4)
//                {
//                    int i3 = l1.readUnsignedShort();
//                    k1 = 0;
//                    while(k1 < i3)
//                    {
//                        Log.i(b(), (new StringBuilder(String.valueOf(k1 + 1))).append("th ").append(l1.readUnsignedShort()).append(",").append(l1.readUnsignedShort()).toString());
//                        b(l1);
//                        k1++;
//                    }
//                    continue; /* Loop/switch isn't completed */
//                }
//                l1.readInt();
//                l1.readUTF();
//                l1.skipBytes(6);
//                k1++;
//            } while(true);
//
//        case 14: // '\016'
//            web.sxd.b.c.a("[\u9635\u8425\u6218]\u5F00\u59CB\u4E00\u573A\u6218\u6597");
//            c = false;
//            b(5);
//            (new m(0x2a000a)).a(C);
//            b(65);
//            c = true;
//            return;
//            break;
//
//        case 15: // '\017'
//            web.sxd.b.c.a("[\u9635\u8425\u6218]\u73B0\u5728\u53EF\u4EE5\u52A0\u5165\u6218\u6597");
//            h = 0;
//            b(C);
//            return;
//        }
//        continue; /* Loop/switch isn't completed */
//
//
//_L9:
//        web.sxd.b.c.a("[\u9635\u8425]%s \u52A0\u5165\u4E86\u7FA4\u82F1\u6218", new Object[] {
//            l1.readUTF()
//        });
//        return;
//_L7:
//        int j2 = l1.read();
//        int j3 = l1.read();
//        switch(j2)
//        {
//        default:
//            web.sxd.b.c.a("[\u9635\u8425\u6218]\u9F13\u821E\u9519\u8BEF%d: %d%%", new Object[] {
//                Integer.valueOf(j2), Integer.valueOf(l1.read())
//            });
//            return;
//
//        case 5: // '\005'
//            j = j + 1;
//            if(j3 <= 0)
//            {
//                web.sxd.b.c.a("[\u9635\u8425\u6218]\u9F13\u821E\u5931\u8D25");
//            } else
//            {
//                i = l1.read();
//                web.sxd.b.c.a("[\u9635\u8425\u6218]\u9F13\u821E\u6210\u529F, \u6218\u529B\u751F\u547D+%d%%", new Object[] {
//                    Integer.valueOf(i)
//                });
//            }
//            if(i < 100 && j < 50)
//            {
//                c();
//                (new m(0x2a000b, 18L)).a(C);
//                return;
//            }
//            break;
//
//        case 20: // '\024'
//            web.sxd.b.c.a("[\u9635\u8425\u6218]\u9F13\u821E\u9605\u5386\u4E0D\u8DB3");
//            return;
//
//        case 21: // '\025'
//            i = 100;
//            web.sxd.b.c.a("[\u9635\u8425\u6218]\u9F13\u821E\u5DF2\u6EE1");
//            return;
//        }
//        if(true) goto _L1; else goto _L15
//_L15:
//    }
//
//    protected final String[] a()
//    {
//        return b;
//    }
//
//    static int a;
//    private static final String b[] = {
//        "HeroesWar_", "get_heroes_open_time", "open_heroes_war", "close_heroes_war", "get_heroes_player", "join_heroes_war", "get_war_result", "notify", "notify_report", "notify_heroes_result",
//        "exit_heroes_war", "finish_war", "buy_buff", "get_buff", "set_robot", "get_robot_status", "get_war_mode", "notify_first_open_heroes_war", "get_end_gift_info", "get_end_gift"
//    };
//    private boolean c;
//    private boolean d;
//    private int e;
//    private int f;
//    private int g;
//    private int h;
//    private int i;
//    private int j;
//
//}