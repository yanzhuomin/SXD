// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:47
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;

import java.io.IOException;

//import web.sxd.a.ae;
//import web.sxd.a.ah;
import web.sxd.b.MainThread;
import web.sxd.b.BaseFunc;
import web.sxd.b.TempDataInputStream;
//import web.sxd.c.a;
//import web.sxd.c.b;
//import web.sxd.c.f;
//import web.sxd.c.g;
import web.sxd.c.i;

// Referenced classes of package web.sxd.d:
//            n, l, x, ad, 
//            r, j, s, t, 
//            k, u, quit, e

public final class m extends BaseFunc
{

    public m(MainThread mainThread)
    {
        super(mainThread, 0);
        e = true;
        f = 0;
//        new g(c1);
        c = new n(mainThread);
//        new i(c1);
//        new a(c1);
        mainThread.start();
        d = false;
    }

    private static String a(String s1)
    {
        int i1;
        int length;
        i1 = 0;
        length = s1.length();
        while(s1.charAt(i1) == ' ' && i1 < length)
        {
            i1++;
        }
        int j1 = i1;
        if(i1 >= length - 1)
        {
            return s1.substring(j1).replace("&lt;", "<")
                    .replace("&gt;", ">")
                    .replace("&amp;", "&")
                    .replace("&Y", "")
                    .replace("&R", "")
                    .replace("&G", "")
                    .replace("</a>", "");//XML中的转义字符处理
        }
        j1 = i1;
        if(s1.charAt(i1) != '<')
        {
            return s1.substring(j1).replace("&lt;", "<")
                    .replace("&gt;", ">")
                    .replace("&amp;", "&")
                    .replace("&Y", "")
                    .replace("&R", "")
                    .replace("&G", "")
                    .replace("</a>", "");//XML中的转义字符处理
        }
        j1 = i1;
        if(s1.charAt(i1 + 1) != 'a')
        {
            return s1.substring(j1).replace("&lt;", "<")
                    .replace("&gt;", ">")
                    .replace("&amp;", "&")
                    .replace("&Y", "")
                    .replace("&R", "")
                    .replace("&G", "")
                    .replace("</a>", "");//XML中的转义字符处理
        }
        j1 = i1 + 2;
        while(s1.charAt(j1) != '>' && j1 < length)
        {
            j1++;
        }
        int k1;
        k1 = j1 + 1;
        j1 = i1;
        if(k1 >= length)
        {
            return s1.substring(j1).replace("&lt;", "<")
                    .replace("&gt;", ">")
                    .replace("&amp;", "&")
                    .replace("&Y", "")
                    .replace("&R", "")
                    .replace("&G", "")
                    .replace("</a>", "");//XML中的转义字符处理
        }
        i1 = k1;

        while(true) {
            j1 = i1;
            if (s1.charAt(i1) == ' ') {
                if (i1 < length)
                    break ;
                j1 = i1;
            }
            i1++;
        }
        return s1.substring(j1).replace("&lt;", "<")
                .replace("&gt;", ">")
                .replace("&amp;", "&")
                .replace("&Y", "")
                .replace("&R", "")
                .replace("&G", "")
                .replace("</a>", "");//XML中的转义字符处理
    }


    public final void a(TempDataInputStream l1)
    {
        int i1;
        i1 = l1.getFuncCode();
        if(i1 != 3 && i1 != 9 && i1 != 40)
            super.a(l1); //打印
        try {
            switch (i1) {
                default:
                    return;
                case 0:
                case 1:
                    switch (l1.read()) {
                        default:
                            web.sxd.b.MainThread.sendLog("未知登录错误");
                            return;
                        case 0:
                            String s1 = "登录成功，查询角色信息：";
                            C.e(l1.readInt());
                            (new web.sxd.b.TempDataOutputStream(2)).sendMain(C);
                            //l1 = s1;
                            //continue;
                            web.sxd.b.MainThread.sendLog(s1);
                            return;
                        case 1:
                            web.sxd.b.MainThread.sendLog(-2, "登录失败，请重试 (2 秒后自动刷新)");
                            return;
                        case 2:
                            web.sxd.b.MainThread.sendLog("尚未创建角色");
                            return;
                        case 3:
                            web.sxd.b.MainThread.sendLog("未知登录错误");
                            return;
                        case 4:
                            String s2 = "登录成功，查询角色信息：";
                            C.e(l1.readInt());
                            (new web.sxd.b.TempDataOutputStream(2)).sendMain(C);
                            //l1 = s1;
                            //continue;
                            web.sxd.b.MainThread.sendLog(s2);
                            return;
                    }
                case 2:
                    String s2 = l1.readUTF();
                    int j2 = l1.readInt();
                    C.a(s2, j2, l1.readInt(), l1.a());
                    web.sxd.b.MainThread.sendLog("%s(%d级) %d元宝 %dw", new Object[]{
                            s2, Integer.valueOf(j2), Integer.valueOf(C.e()), Integer.valueOf(C.f())
                    });
                    l1.skipBytes(8);
                    int j3 = l1.readInt();
                    C.g(j3);
                    long l4 = l1.readLong();
                    long l6 = l1.readLong();
                    C.b(l4);
                    C.c(l6);
                    boolean flag1;
                    if (l6 > 0x989680L)
                        i1 = 1;
                    else
                        i1 = 0;
                    if (i1 != 0) {
                        l6 /= 10000L;
                        web.sxd.b.MainThread.sendLog("  体力%d  %dw/%dw (%d%%)", new Object[]{
                                Integer.valueOf(j3), Long.valueOf(l4 / 10000L), Long.valueOf(l6), Integer.valueOf(C.h())
                        });
                    } else {
                        web.sxd.b.MainThread.sendLog("  体力%d  %d/%d (%d%%)", new Object[]{
                                Integer.valueOf(j3), Long.valueOf(l4), Long.valueOf(l6), Integer.valueOf(C.h())
                        });
                    }
                    c();
                    (new web.sxd.b.TempDataOutputStream(46)).sendMain(C);
                    c();
                    (new web.sxd.b.TempDataOutputStream(9)).sendMain(C);
                    i1 = l1.readInt();
                    j3 = l1.readInt();
                    C.h(i1);
                    Log.i(b(), (new StringBuilder("Login: town=")).append(i1).append(", boss=").append(j3).append(", jhs=").append(l1.readInt()).toString());
                    C.a(l1);
                    if (j3 > 0)
                        flag1 = true;
                    else
                        flag1 = false;
                    d = flag1;
                    if (d) {
                        web.sxd.b.MainThread.sendLog("[BOSS]%s, %s", new Object[]{
                                i.e(j3), i.e(i1)
                        });
                        //new ad(C); //TODO 暂时注释
                        c();
                        C.j(j3);
                    } else {
                        web.sxd.b.MainThread.sendLog("进入城镇: %s", new Object[]{
                                i.e(i1)
                        });
                        C.m();
                    }
                    if (j2 >= 60) {
                        //new r(C);
                        c();
                        //web.sxd.d.r.a(C);
                        web.sxd.b.MainThread.sendLog("达到60级");
                    } else {
                        web.sxd.b.MainThread.sendLog("未开启签到功能(60级)！");
                    }
                    //web.sxd.d.j.a(C);
                    c();
                    (new web.sxd.b.TempDataOutputStream(48, C.d())).sendMain(C);
                    c();
                    (new web.sxd.b.TempDataOutputStream(6)).sendMain(C);
                    sleep(20);
                    if (C.b(64)) {
                        (new web.sxd.b.TempDataOutputStream(42)).sendMain(C);
                        return;
                    }
                    return;
                    //continue;
                case 3:
                    int l3;
                    l3 = l1.readUnsignedShort();
                    i1 = 0;

                    long l5;
                    //if (i1 >= l3)return;
                        //continue; /* Loop/switch isn't completed */
                    while(i1<l3) {
                        j3 = l1.read();
                        l5 = l1.readLong();
                        if (l5 < 0x7fffffffL)
                            j2 = (int) l5;
                        else
                            j2 = 0x7fffffff;
                        switch (j3) {
                            default:
                                i1++;break;
                            case 13:
                                C.f(j2);
                                i1++;break;
                            case 15:
                                if(l5>0) C.a(l5);
                                i1++;break;
                            case 18:
                                if(C.i()>=j2)
                                {
                                    if(C.i()==j2)
                                    {i1++;break;}
                                }else{
                                    Log.i(b(), C.toString());
                                    web.sxd.b.MainThread.sendLog((new StringBuilder("[流量]")).append(C).toString());
                                    //TODO 暂时删除
//                                    web.sxd.d.s.a(C);
//                                    MainThread c3 = C;
//                                    t.e();

                                }
                                String s3;
                                if(C.i() > j2)
                                    s3 = "减少为";
                                else
                                    s3 = "增加至";
                                web.sxd.b.MainThread.sendLog("　体力%s %d", new Object[] {
                                        s3, Integer.valueOf(j2)
                                });
                                C.g(j2);
                                break;
                            case 20:
                                C.b(l5);
                                i1++;break;
                            case 21:
                                C.c(l5);
                                i1++;break;
                            case 43:
                                i1++;break;
                            case 50:
                                i1++;break;
                            case 56:
                                i1++;break;
                            case 58:
                                if(j2 > 0)
                                    C.b(134);
                                i1++;break;
                            case 66:
                                if(l5 <= 0L || e)
                                {
                                    i1++;break;
                                }else {
                                    int i4;
                                    int ai[];
                                    e = true;
                                    web.sxd.b.MainThread.sendLog("[提醒]新的俸禄: %d", new Object[] {
                                            Integer.valueOf(j2)
                                    });
                                    c();
                                    ai = a;
                                    i4 = ai.length;
                                    j3 = 0;
                                    //TODO weiwan
                                }
                            case 67:
                                if(j2 > 0)
                                {
                                    C.g(-j2);
                                    web.sxd.b.MainThread.sendLog("额外体力: %d", new Object[] {
                                            Integer.valueOf(j2)
                                    });
                                }
                        }
                    }
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.d.m", e.getLocalizedMessage(), e);
            //Log.d("sxd.web.d.m",e.printStackTrace());
        }
//        i1;
//        JVM INSTR lookupswitch 13: default 144
//    //                   0: 1093
//    //                   1: 1093
//    //                   2: 1190
//    //                   3: 1828
//    //                   6: 645
//    //                   9: 2547
//    //                   20: 2517
//    //                   35: 2869
//    //                   40: 2918
//    //                   41: 145
//    //                   42: 239
//    //                   46: 2816
//    //                   48: 1788;
//           goto _L1 _L2 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
//_L1:
//        return;
//_L10:
//        i1 = l1.readInt();
//        if(i1 > 0)
//        {
//            web.sxd.b.c.a("[阵营战]冷却中, %d秒后重试", new Object[] {
//                Integer.valueOf(i1)
//            });
//            sleep(i1 * 5);
//        }
//        if(C.b(37))
//        {
//            if(C.g() >= 40 && C.g() <= 80)
//            {
//                web.sxd.d.l.b(C);
//                return;
//            }
//            if(C.g() > 80)
//            {
//                web.sxd.b.c.a("[阵营战]功能已终结");
//                return;
//            }
//        }
//        continue; /* Loop/switch isn't completed */
//_L11:
//        l1.readInt();
//        l1.readInt();
//        l1.readInt();
//        l1.readInt();
//        l1.readInt();
//        l1.readInt();
//        l1.readInt();
//        l1.readInt();
//        l1.readInt();
//        l1.readInt();
//        l1.readInt();
//        l1.readInt();
//        l1.readInt();
//        if(l1.readInt() != 1)
//        {
//            c();
//            (new web.sxd.b.m(20)).a(C);
//        }
//        l1.readInt();
//        i1 = l1.readInt();
//        if(i1 > 0)
//            web.sxd.b.c.a("[小助手]今日还可帮派祭神 %d 次", new Object[] {
//                Integer.valueOf(i1)
//            });
//        i1 = l1.readInt();
//        if(i1 > 0)
//            web.sxd.b.c.a("[小助手]今日还可竞技场挑战 %d 次", new Object[] {
//                Integer.valueOf(i1)
//            });
//        l1.readInt();
//        i1 = l1.readInt();
//        if(i1 > 0)
//            web.sxd.b.c.a("[小助手]今日还可护送取经 %d 次", new Object[] {
//                Integer.valueOf(i1)
//            });
//        l1.readInt();
//        i1 = l1.readInt();
//        if(i1 > 0)
//        {
//            web.sxd.b.c.a("[小助手]今日还可送花 %d 次", new Object[] {
//                Integer.valueOf(i1)
//            });
//            if(C.b(45))
//            {
//                new web.sxd.c.h(C);
//                c();
//                web.sxd.c.h.a(C);
//            }
//        }
//        l1.readInt();
//        i1 = l1.readInt();
//        if(i1 > 0)
//            web.sxd.b.c.a("[小助手]今日还可使用药园仙露 %d 次", new Object[] {
//                Integer.valueOf(i1)
//            });
//        l1.readInt();
//        l1.readInt();
//        l1.readInt();
//        i1 = l1.readInt();
//        if(i1 > 0)
//            web.sxd.b.c.a("[小助手]今日还可吉星高照投掷 %d 次", new Object[] {
//                Integer.valueOf(i1)
//            });
//        i1 = l1.readInt();
//        if(i1 > 0)
//            web.sxd.b.c.a("[小助手]今日还可祭拜关公 %d 次", new Object[] {
//                Integer.valueOf(i1)
//            });
//        l1.readInt();
//        i1 = l1.readInt();
//        if(i1 > 0)
//            web.sxd.b.c.a("[小助手]今日还可摘仙桃 %d 次", new Object[] {
//                Integer.valueOf(i1)
//            });
//        l1.readInt();
//        l1.readInt();
//        l1.readInt();
//        l1.skipBytes(l1.readUnsignedShort() * 16);
//        l1.skipBytes(l1.readUnsignedShort() * 16);
//        return;
//_L5:
//        int j2;
//        j2 = l1.readUnsignedShort();
//        i1 = 0;
//_L19:
//        if(i1 < j2) goto _L15; else goto _L14
//_L14:
//        l1 = a;
//        j2 = l1.length;
//        i1 = 0;
//_L28:
//        if(i1 < j2) goto _L17; else goto _L16
//_L16:
//        c.a(a);
//        l1 = a;
//        j2 = l1.length;
//        i1 = 0;
//_L34:
//        int j3;
//        int k3;
//        boolean flag;
//        c c1;
//        if(i1 >= j2)
//        {
//            e = false;
//            return;
//        }
//        j3 = l1[i1];
//          goto _L18
//_L15:
//        j3 = l1.readInt();
//        k3 = l1.read();
//        c1 = C;
//        if(k3 == 1)
//            flag = true;
//        else
//            flag = false;
//        c1.a(j3, flag);
//        i1++;
//          goto _L19
//_L17:
//        j3 = l1[i1];
//        if(!C.b(j3)) goto _L21; else goto _L20
//_L20:
//        j3;
//        JVM INSTR lookupswitch 5: default 820
//    //                   33: 992
//    //                   39: 941
//    //                   91: 827
//    //                   165: 872
//    //                   179: 916;
//           goto _L22 _L23 _L24 _L25 _L26 _L27
//_L22:
//        break; /* Loop/switch isn't completed */
//_L23:
//        break MISSING_BLOCK_LABEL_992;
//_L21:
//        i1++;
//          goto _L28
//_L25:
//        new x(C);
//        if(!d || !C.b(39))
//        {
//            c();
//            web.sxd.d.x.a(C);
//        }
//          goto _L21
//_L26:
//        new ae(C);
//        if(!d || !C.b(39))
//        {
//            c();
//            ae.a(C);
//        }
//          goto _L21
//_L27:
//        new ah(C);
//        c();
//        ah.a(C);
//          goto _L21
//_L24:
//        c();
//        if(d)
//        {
//            web.sxd.d.ad.a(C);
//        } else
//        {
//            web.sxd.b.c.a(5, null);
//            c();
//            new ad(C);
//            web.sxd.d.ad.a(C, 0L);
//        }
//          goto _L21
//        c();
//          goto _L21
//_L18:
//        if(!C.b(j3)) goto _L30; else goto _L29
//_L29:
//        j3;
//        JVM INSTR lookupswitch 2: default 1044
//    //                   24: 1078
//    //                   38: 1051;
//           goto _L31 _L32 _L33
//_L31:
//        break; /* Loop/switch isn't completed */
//_L32:
//        break MISSING_BLOCK_LABEL_1078;
//_L30:
//        i1++;
//          goto _L34
//_L33:
//        new f(C);
//        b(3);
//        web.sxd.c.f.a(C);
//          goto _L30
//        new b(C);
//          goto _L30
//_L2:
//        l1.read();
//        JVM INSTR tableswitch 0 4: default 1132
//    //                   0 1140
//    //                   1 1176
//    //                   2 1184
//    //                   3 1132
//    //                   4 1140;
//           goto _L35 _L36 _L37 _L38 _L35 _L36
//_L35:
//        l1 = "未知登录错误";
//_L39:
//        web.sxd.b.c.a(l1);
//        return;
//_L36:
//        String s1 = "登录成功，查询角色信息：";
//        C.e(l1.readInt());
//        (new web.sxd.b.m(2)).a(C);
//        l1 = s1;
//        continue; /* Loop/switch isn't completed */
//_L37:
//        web.sxd.b.c.a(-2, "登录失败，请重试 (2 秒后自动刷新)");
//        return;
//_L38:
//        l1 = "尚未创建角色";
//        if(true) goto _L39; else goto _L3
//_L3:
//        String s2 = l1.readUTF();
//        j2 = l1.readInt();
//        C.a(s2, j2, l1.readInt(), l1.a());
//        web.sxd.b.c.a("%s(%d级) %d元宝 %dw", new Object[] {
//            s2, Integer.valueOf(j2), Integer.valueOf(C.e()), Integer.valueOf(C.f())
//        });
//        l1.skipBytes(8);
//        j3 = l1.readInt();
//        C.g(j3);
//        long l4 = l1.readLong();
//        long l6 = l1.readLong();
//        C.b(l4);
//        C.c(l6);
//        boolean flag1;
//        if(l6 > 0x989680L)
//            i1 = 1;
//        else
//            i1 = 0;
//        if(i1 != 0)
//        {
//            l6 /= 10000L;
//            web.sxd.b.c.a("  体力%d  %dw/%dw (%d%%)", new Object[] {
//                Integer.valueOf(j3), Long.valueOf(l4 / 10000L), Long.valueOf(l6), Integer.valueOf(C.h())
//            });
//        } else
//        {
//            web.sxd.b.c.a("  体力%d  %d/%d (%d%%)", new Object[] {
//                Integer.valueOf(j3), Long.valueOf(l4), Long.valueOf(l6), Integer.valueOf(C.h())
//            });
//        }
//        c();
//        (new web.sxd.b.m(46)).a(C);
//        c();
//        (new web.sxd.b.m(9)).a(C);
//        i1 = l1.readInt();
//        j3 = l1.readInt();
//        C.h(i1);
//        Log.i(b(), (new StringBuilder("Login: town=")).append(i1).append(", boss=").append(j3).append(", jhs=").append(l1.readInt()).toString());
//        C.a(l1);
//        if(j3 > 0)
//            flag1 = true;
//        else
//            flag1 = false;
//        d = flag1;
//        if(d)
//        {
//            web.sxd.b.c.a("[BOSS]%s, %s", new Object[] {
//                i.e(j3), i.e(i1)
//            });
//            new ad(C);
//            c();
//            C.j(j3);
//        } else
//        {
//            web.sxd.b.c.a("进入城镇: %s", new Object[] {
//                i.e(i1)
//            });
//            C.m();
//        }
//        if(j2 >= 60)
//        {
//            new r(C);
//            c();
//            web.sxd.d.r.a(C);
//        } else
//        {
//            web.sxd.b.c.a("未开启签到功能(60级)！");
//        }
//        web.sxd.d.j.a(C);
//        c();
//        (new web.sxd.b.m(48, C.d())).a(C);
//        c();
//        (new web.sxd.b.m(6)).a(C);
//        b(20);
//        if(C.b(64))
//        {
//            (new web.sxd.b.m(42)).a(C);
//            return;
//        }
//        continue; /* Loop/switch isn't completed */
//_L13:
//        if(l1.readUnsignedShort() != 0)
//        {
//            c c2 = C;
//            i1 = l1.readInt();
//            j2 = l1.readInt();
//            l1.readUTF();
//            c2.a(i1, j2, l1.readInt());
//            return;
//        }
//        continue; /* Loop/switch isn't completed */
//_L4:
//        int l3;
//        l3 = l1.readUnsignedShort();
//        i1 = 0;
//_L49:
//        long l5;
//        if(i1 >= l3)
//            continue; /* Loop/switch isn't completed */
//        j3 = l1.read();
//        l5 = l1.readLong();
//        if(l5 < 0x7fffffffL)
//            j2 = (int)l5;
//        else
//            j2 = 0x7fffffff;
//        j3;
//        JVM INSTR lookupswitch 11: default 1968
//    //                   13: 1982
//    //                   15: 2017
//    //                   18: 2036
//    //                   20: 1993
//    //                   21: 2005
//    //                   43: 1968
//    //                   50: 1968
//    //                   56: 1968
//    //                   58: 2172
//    //                   66: 2223
//    //                   67: 2190;
//           goto _L40 _L41 _L42 _L43 _L44 _L45 _L40 _L40 _L40 _L46 _L47 _L48
//_L40:
//        i1++;
//          goto _L49
//_L41:
//        C.f(j2);
//          goto _L40
//_L44:
//        C.b(l5);
//          goto _L40
//_L45:
//        C.c(l5);
//          goto _L40
//_L42:
//        if(l5 > 0L)
//            C.a(l5);
//          goto _L40
//_L43:
//        if(C.i() >= j2) goto _L51; else goto _L50
//_L50:
//        Log.i(b(), C.toString());
//        web.sxd.b.c.a((new StringBuilder("[\u6D41\u91CF]")).append(C).toString());
//        web.sxd.d.s.a(C);
//        c c3 = C;
//        t.e();
//_L52:
//        String s3;
//        if(C.i() > j2)
//            s3 = "减少为";
//        else
//            s3 = "增加至";
//        web.sxd.b.c.a("　体力%s %d", new Object[] {
//            s3, Integer.valueOf(j2)
//        });
//        C.g(j2);
//        break; /* Loop/switch isn't completed */
//_L51:
//        if(C.i() == j2) goto _L40; else goto _L52
//_L46:
//        if(j2 > 0)
//            C.b(134);
//          goto _L40
//_L48:
//        if(j2 > 0)
//        {
//            C.g(-j2);
//            web.sxd.b.c.a("　额外体力: %d", new Object[] {
//                Integer.valueOf(j2)
//            });
//        }
//          goto _L40
//_L47:
//        if(l5 <= 0L || e) goto _L40; else goto _L53
//_L53:
//        int i4;
//        int ai[];
//        e = true;
//        web.sxd.b.c.a("[提醒]新的俸禄: %d", new Object[] {
//            Integer.valueOf(j2)
//        });
//        c();
//        ai = a;
//        i4 = ai.length;
//        j3 = 0;
//_L61:
//label0:
//        {
//            if(j3 < i4)
//                break label0;
//            c.b(a);
//            int j4;
//            if(C.b(38))
//            {
//                c();
//                web.sxd.c.f.a(C);
//            } else
//            {
//                e = false;
//            }
//        }
//          goto _L40
//        j4 = ai[j3];
//        if(!C.b(j4)) goto _L55; else goto _L54
//_L54:
//        j4;
//        JVM INSTR lookupswitch 5: default 2388
//    //                   24: 2406
//    //                   33: 2416
//    //                   56: 2397
//    //                   90: 2461
//    //                   93: 2439;
//           goto _L55 _L56 _L57 _L58 _L59 _L60
//_L55:
//        j3++;
//          goto _L61
//_L58:
//        k.e();
//_L62:
//        c();
//          goto _L55
//_L56:
//        web.sxd.c.b.a(C);
//          goto _L62
//_L57:
//        if(j2 > 0)
//            (new web.sxd.b.m(20)).a(C);
//          goto _L62
//_L60:
//        if(C.b(91))
//            web.sxd.d.t.a(C);
//          goto _L62
//_L59:
//        if(C.b(91))
//            if(C.a)
//            {
//                web.sxd.d.u.a(C);
//            } else
//            {
//                q.e();
//                c();
//                web.sxd.d.q.a(C);
//            }
//          goto _L62
//_L7:
//        if(l1.read() == 87)
//        {
//            web.sxd.b.c.a("[小助手]领取俸禄：%d 铜钱", new Object[] {
//                Integer.valueOf(l1.readInt())
//            });
//            return;
//        }
//        continue; /* Loop/switch isn't completed */
//_L6:
//        j2 = l1.readUnsignedShort();
//        i1 = 0;
//_L70:
//        String s4;
//        if(i1 >= j2)
//            continue; /* Loop/switch isn't completed */
//        s4 = a(l1.readUTF());
//        j3 = l1.readInt();
//        j3;
//        JVM INSTR lookupswitch 6: default 2636
//    //                   3: 2690
//    //                   32: 2712
//    //                   45: 2776
//    //                   47: 2720
//    //                   49: 2712
//    //                   149: 2786;
//           goto _L63 _L64 _L65 _L66 _L67 _L65 _L68
//_L64:
//        break; /* Loop/switch isn't completed */
//_L63:
//        Log.i((new StringBuilder("DelayMsg_")).append(j3).toString(), s4);
//        web.sxd.b.c.a("%s[msg%d]", new Object[] {
//            s4, Integer.valueOf(j3)
//        });
//_L71:
//        i1++;
//        if(true) goto _L70; else goto _L69
//_L69:
//        if(C.b(38))
//        {
//            c();
//            web.sxd.c.f.a(C);
//        }
//_L65:
//        web.sxd.b.c.a(s4);
//          goto _L71
//_L67:
//        web.sxd.b.c.a(s4.replace("[replace,7]", "周日 ").replace("[replace,", "周").replace(']', ' '));
//        if(C.b(39))
//        {
//            c();
//            web.sxd.d.ad.a(C, 1L);
//        }
//          goto _L71
//_L66:
//        web.sxd.d.e.b(C);
//          goto _L71
//_L68:
//        if(C.a)
//            web.sxd.d.u.a(C);
//        else
//            web.sxd.d.q.a(C);
//          goto _L71
//_L12:
//        int k2 = l1.readUnsignedShort();
//        int j1 = 0;
//        do
//        {
//            if(j1 >= k2)
//            {
//                (new web.sxd.b.m(35)).a(C);
//                return;
//            }
//            web.sxd.b.c.a("[公告]%s", new Object[] {
//                l1.readUTF()
//            });
//            j1++;
//        } while(true);
//_L8:
//        int l2 = l1.readUnsignedShort();
//        int k1 = 0;
//        while(k1 < l2)
//        {
//            web.sxd.b.c.a("[公告%d]%s", new Object[] {
//                Integer.valueOf(l1.readInt()), a(l1.readUTF())
//            });
//            k1++;
//        }
//        if(true) goto _L1; else goto _L9
//_L9:
//        switch(l1.read())
//        {
//        case 83: // 'S'
//        default:
//            return;
//
//        case 82: // 'R'
//            int i2 = l1.readInt();
//            int i3 = l1.readInt();
//            if(i2 + i3 != f)
//            {
//                f = i2 + i3;
//                web.sxd.b.c.a("[打坐]15秒经验%d + %d", new Object[] {
//                    Integer.valueOf(i2), Integer.valueOf(i3)
//                });
//            }
//            if(i3 > 0)
//            {
//                Log.v(b(), (new StringBuilder("UPDATE_PRACTICE: ")).append(i2).append(" + ").append(i3).toString());
//                return;
//            }
//            break;
//
//        case 84: // 'T'
//            C.l();
//            return;
//        }
//        if(true) goto _L1; else goto _L72
//_L72:
    }

    @Override
    protected final String[] a()
    {
        return b;
    }

    public static final int a[] = {
        127, 32, 35, 34, 123, 135, 117, 166, 164, 64, 
        18, 146, 45, 134, 173, 169, 143, 133, 59, 129, 
        36, 126, 142, 160, 140, 172, 12, 68, 56, 70, 
        39, 4, 3, 41, 33, 13, 8, 15, 43, 16, 
        76, 171, 54, 55, 38, 51, 37, 25, 46, 48, 
        86, 81, 60, 85, 90, 27, 91, 94, 132, 102, 
        103, 157, 93, 87, 165, 7, 179
    };
    private static final String b[] = {
        "Player_","login","player_first_init","get_player_info",//0,1,2
            "update_player_data","update_player_data_for_town","buy_power",//3,4,5
            "get_player_function","sign_play_player_function","set_player_camp",//6,7,8
            "receive_player_delay_notify_message","validate_id_card",//9,10
            "against_wallows_notify","","","","","","","","",//11
            "get_player_camp_salary","","server_time",//20,22
            "get_buy_power_data","get_other_player_info","","","","","",//23,24
            "player_get_online_gift","get_player_current_online_gift","","","",//30,31
            "get_affiche_list","start_practice","get_practice_data","sign_finished_practice",//35,36,37,38
            "cancel_practice","practice_notify","get_player_war_cd_time","get_game_assistant_info",//39,40,41,42
            "send_ingot_receive_show_vip","against_wallows_info","get_last_player_version",//43,44,45
            "get_warning_affiche","back_times","player_info_contrast","player_consume_alert_set_info",//46,47,48,49
            "player_consume_alert_set","get_player_info_by_username","player_follow_setting",//50,51,52
            "is_weichengnian","set_custom_pannel","pc_client_gift_info",//53,54,55
            "receive_client_gift","notify_have_client_gift","gamebang_player_status",//56,57,58
            "set_player_setting","player_open_new_game_function","player_get_internet_bar_online_gift",//59,60,61
            "get_player_current_internet_bar_online_gift","set_in_st_town",//62,63
            "is_in_st_town","super_town_level_info","compare_war_power",//64,65,66
            "operation_activity_time_list","is_test_server","check_function_open",//67,68,69
            "player_ui_list","set_player_ui","get_player_mission_loading_interface_id",//70,71,72
            "set_player_mission_loading_interface_id","award_item_notify",//73,74
            "","","","","",     "","","","","",      "","","","","",    "","","","","",   "","","","",
            "jiekou_test"//99
    };
    private n c;
    private boolean d;
    private boolean e;
    private int f;

}