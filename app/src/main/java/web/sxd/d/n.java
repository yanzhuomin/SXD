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
        try {
            String s = l1.readUTF();
            String s1 = l1.readUTF();
            if (c1.a(s1))
                return "";
            StringBuilder stringbuilder = new StringBuilder("^");
            //c1 = l1;
            if (s1.toLowerCase().startsWith(s.toLowerCase()))
                s1 = s1.substring(s.length());
            return stringbuilder.append(s).append(s1).toString();
        }catch (Exception e)
        {
            Log.d("web.sxd.d.n",e.getMessage());
        }
    }

    static MainThread a(n n1)
    {
        return n1.C;
    }

    static void a(MainThread c1)
    {
        try {
            if (c1.b(85))
                (new TempDataOutputStream(0x680000)).sendMain(c1);
        }catch (Exception e)
        {
            Log.d("web.sxd.d.n",e.getMessage());
        }
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
        int funcCode = l1.getFuncCode();
        switch (funcCode)
        {
            default:
                int i1;
                int k1;
                String s;
                s = b();
                i1 = l1.getFuncCodeH();
                k1 = l1.getFuncCodeL();
                switch (i1)
                {
                    default:
                        String str = (new StringBuilder(String.valueOf(i1))).append("_").append(k1).toString();
                        Log.d(s, str);
                        switch (funcCode)
                        {
                            default: return;
                            case 0x50008:
                                int j1 = l1.readUnsignedShort();
                                i1 = 0;
                                do
                                {
                                    if(i1 >= j1)
                                    {
                                        b(10);
                                        (new TempDataOutputStream(0x80001, 132)).sendMain(C);
                                        return;
                                    }
                                    k1 = l1.readInt();
                                    int i2 = l1.readInt();
//                                    String.format("%d,%d,%d,%d,%d,%d",
//                                            Integer.valueOf(k1), Integer.valueOf(i2), Integer.valueOf(l1.readInt()), Integer.valueOf(l1.read()), Integer.valueOf(l1.read()), Integer.valueOf(l1.readUnsignedShort())
//                                    );
                                    if(i2 == 35 || i2 == 62 || i2 == 70)
                                        C.d(k1);
                                    i1++;
                                } while(true);

                                l1.readUnsignedShort();
                                web.sxd.b.MainThread.sendLog("　祝福 %d 次经验+%d%%", new Object[] {
                                        Integer.valueOf(l1.readUnsignedShort()), Integer.valueOf(l1.readInt())
                                });
                                return;
                            case 0x80001:
                                i1 = l1.read();
                                if(i1 >= 6)
                                {
                                    String str1 = b();
                                    StringBuilder stringbuilder = new StringBuilder("Partners_invite: ");
                                    if(i1 - 6 < k.length)
                                        l1 = k[i1 - 6];
                                    else
                                        l1 = Integer.valueOf(i1);
                                    Log.i(str1, stringbuilder.append(l1).toString());
                                    return;
                                } else
                                {
                                    Log.i(b(), (new StringBuilder("Partners_invite: ")).append(i1).toString());
                                    return;
                                }
                            case 0x220012:
                                if(l1.read() == 1)
                                {
                                    web.sxd.b.MainThread.sendLog("　成功领取 %d 灵石", new Object[] {
                                            Integer.valueOf(l1.readInt())
                                    });
                                    return;
                                }
                            case 0x290001:
                                if(l1.read() == 0)
                                {
                                    web.sxd.b.MainThread.sendLog("关公上香成功");
                                    (new TempDataOutputStream(0x290002)).sendMain(C);
                                    return;
                                }
                            case 0x290002:
                                l1.readUnsignedShort();
                                web.sxd.b.MainThread.sendLog("　祝福 %d 次经验+%d%%", new Object[] {
                                        Integer.valueOf(l1.readUnsignedShort()), Integer.valueOf(l1.readInt())
                                });
                                return;
                            case 0x300000:
                                l1.readUTF();
                            case 0x300003:
                                i1 = l1.read();
                                k1 = l1.read();
                                int k2 = l1.readInt();
                                if(i1 >= 10 && k1 >= 10)
                                {
                                    web.sxd.b.MainThread.sendLog("龙宠:%d变%d阶 已培养满", new Object[] {
                                            Integer.valueOf(i1 - 1), Integer.valueOf(k1)
                                    });
                                    return;
                                }
                                if(j1 == 0x300003)
                                {
                                    web.sxd.b.MainThread.sendLog("龙宠:%d变%d阶 进化成功 经验%d", new Object[] {
                                            Integer.valueOf(i1 - 1), Integer.valueOf(k1), Integer.valueOf(k2)
                                    });
                                } else
                                {
                                    j1 = l1.readInt();
                                    web.sxd.b.MainThread.sendLog("龙宠:%d变%d阶 经验%d 剩余%d次", new Object[] {
                                            Integer.valueOf(i1 - 1), Integer.valueOf(k1), Integer.valueOf(k2), Integer.valueOf(j1)
                                    });
                                    if(j1 <= 0)
                                        return;//continue; /* Loop/switch isn't completed */
                                    b(10);
                                }
                                c();
                                (new TempDataOutputStream(0x300002, 0L)).sendMain(C);
                                return;
                            case 0x300002:
                                i1 = l1.read();
                                if(i1 == 2)
                                    (new TempDataOutputStream(0x300003)).sendMain(C);
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
                                    web.sxd.b.MainThread.sendLog("　培养龙宠: 经验+%d%s 剩余%d次", new Object[] {
                                            Integer.valueOf(i1), l1, Integer.valueOf(j1)
                                    });
                                    if(j1 > 0)
                                    {
                                        b(2);
                                        (new TempDataOutputStream(0x300002, 0L)).sendMain(C);
                                        return;
                                    } else
                                    {
                                        (new TempDataOutputStream(0x300000, C.d())).sendMain(C);
                                        return;
                                    }
                                }
                                return;
                            //case 0x300003:
                            case 0x680000:
                                i1 = l1.readInt();
                                j1 = l1.readUnsignedShort();
                                web.sxd.b.MainThread.sendLog("灵气: %d, 葫芦: %d+%d, 灵脉x%d", new Object[] {
                                        Integer.valueOf(i1), Integer.valueOf(j1), Integer.valueOf(l1.readUnsignedShort()), Integer.valueOf(l1.readUnsignedShort())
                                });
                                if(j1 > 0)
                                {
                                    c();
                                    (new TempDataOutputStream(0x680001, 0L)).sendMain(C);
                                    return;
                                }
                            case 0x680001:
                                i1 = l1.read();
                                if(i1 == 0)
                                {
                                    i1 = l1.readInt();
                                    j1 = l1.readInt();
                                    int j2;
                                    String str2;
                                    if(l1.read() > 0)
                                        str2 = "灵脉";
                                    else
                                        str2 = "";
                                    k1 = l1.readUnsignedShort();
                                    j2 = l1.readUnsignedShort();
                                    web.sxd.b.MainThread.sendLog("　灵气+%d=>%d %sx%d 剩余%d", new Object[] {
                                            Integer.valueOf(j1), Integer.valueOf(i1), str2, Integer.valueOf(k1), Integer.valueOf(j2)
                                    });
                                    if(j2 > 0)
                                    {
                                        c();
                                        (new TempDataOutputStream(0x680001, 0L)).sendMain(C);
                                        return;
                                    }
                                } else
                                {
                                    web.sxd.b.MainThread.sendLog("木葫芦采集灵气失败: %d", new Object[] {
                                            Integer.valueOf(i1)
                                    });
                                    return;
                                }
                            case 0x690001:
                                i1 = l1.read();
                                k1 = l1.read();
                                l1.read();
                                l1.readUnsignedShort();
                                if(j1 == 0x690001)
                                    web.sxd.b.MainThread.sendLog("[猎妖]剩余 %d次免费, %d次铜钱猎妖", new Object[] {
                                            Integer.valueOf(i1), Integer.valueOf(k1)
                                    });
                                c();
                                if(i1 > 0)
                                {
                                    (new m(0x690002, (byte)0, (byte)0)).a(C);
                                    return;
                                }
                            case 0x690002:
                                StringBuilder sb = new StringBuilder("[猎妖]");
                                i1 = l1.read();
                                if(i1 != 5)
                                    sb.append("打开宝箱失败: ");
                                switch (i1)
                                {
                                    default:
                                        break;
                                    case 5:
                                        sb.append("成功");
                                    case 6:
                                        sb.append("背包已满");
                                    case 7:
                                        sb.append("元宝不足");
                                    case 8:
                                        sb.append("铜钱不足");
                                    case 9:
                                        sb.append("没次数了");
                                    case 10:
                                        sb.append("龙鱼令已满");
                                }
                                if(i1 != 5)
                                {
                                    web.sxd.b.MainThread.sendLog(sb.toString());
                                    return;
                                }
                        }
                    case 5:printFuncName(k1,a);break;
                    case 8:printFuncName(k1,h);break;
                    case 9:printFuncName(k1,b);break;
                    case 34:printFuncName(k1,f);break;
                    case 41:printFuncName(k1,e);break;
                    case 48:printFuncName(k1,g);break;
                    case 86:printFuncName(k1,d);break;
                    case 104:printFuncName(k1,c);break;
                }
            case 0x50007:
            case 0x9000A:
            case 0x290003:
                return;
        }

        int k1 = l1.readUnsignedShort();
        int i1 = 0;
        //TODO 没完


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
            "招募成功", "招募失败", "铜钱不足", "声望不足", "队伍已满", "NOTCHANGE", "NO_ENOUGH_PIECES", "伙伴碎片不足", "主角等级不到", "STAGE_COMPLETE",
            "INSUFFICIENT_KEY"
    };
    private String l[] = {
            ",铜钱", ",", ",阅历", ",龙鱼令", ",未知"
    };

}