// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:47
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;
//import web.sxd.a.ab;
//import web.sxd.a.ak;
import web.sxd.a.at;
//import web.sxd.a.au;
//import web.sxd.a.av;
//import web.sxd.a.aw;
import web.sxd.a.ay;
//import web.sxd.a.Fate;
//import web.sxd.a.d;
//import web.sxd.a.Notify;
//import web.sxd.a.j;
//import web.sxd.a.q;
//import web.sxd.a.r;
//import web.sxd.a.t;
//import web.sxd.a.v;
//import web.sxd.a.w;
//import web.sxd.a.x;
//import web.sxd.a.y;
//import web.sxd.a.z;
import web.sxd.b.BaseFunc;
import web.sxd.b.MainThread;
import web.sxd.b.TempDataInputStream;
import web.sxd.b.TempDataOutputStream;
//import web.sxd.Fate.c;
//import web.sxd.Fate.SendFlower;
//import web.sxd.Fate.l;
//import web.sxd.Fate.m;

// Referenced classes of package web.sxd.d:
//            j, l, y, ab, 
//            o, Fate, e, u,
//            Notify, p, a, d,
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

    public static String a(MainThread mainThread, TempDataInputStream inputStream)
    {
        try {
            String s = inputStream.readUTF();
            String s1 = inputStream.readUTF();
            if (mainThread.a(s1))
                return "";
            StringBuilder stringbuilder = new StringBuilder("^");
            //c1 = l1;
            if (s1.toLowerCase().startsWith(s.toLowerCase()))
                s1 = s1.substring(s.length());
            return stringbuilder.append(s).append(s1).toString();
        }catch (Exception e)
        {
            Log.v("web.sxd.d.n", e.getLocalizedMessage(), e);
            //Log.d("web.sxd.d.n",e.getMessage());
        }
        return "";
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
            //e.printStackTrace();
            //Log.d("web.sxd.d.n",e.getMessage());
            Log.v("web.sxd.d.n", e.getLocalizedMessage(), e);
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
        case 103: // 'Notify'
        case 108: // 'l'
            return "男剑";

        case 2: // '\002'
        case 105: // 'Town'
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
        case 104: // 'SendFlower'
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
        if( (funcCode ==0x50007) || (funcCode ==0x9000A) || (funcCode ==0x290003) ) return;
        try {
//        switch (funcCode)
//        {
//            default:
            int i1;
            int k1;
            String s;
            s = b();
            i1 = l1.getFuncCodeH();
            k1 = l1.getFuncCodeL();
            String str = "";
            switch (i1) {
                case 5: //_L4
                    str = printFuncName(k1, a);
                    break;
                case 8://_L5
                    str = printFuncName(k1, h);
                    break;
                case 9:
                    str = printFuncName(k1, b);
                    break;
                case 34:
                    str = printFuncName(k1, f);
                    break;
                case 41:
                    str = printFuncName(k1, e);
                    break;
                case 48:
                    str = printFuncName(k1, g);
                    break;
                case 86:
                    str = printFuncName(k1, d);
                    break;
                case 104:
                    str = printFuncName(k1, c);
                    break;

                default:
                    str = (new StringBuilder(String.valueOf(i1))).append("_").append(k1).toString();
                    break;
            }
            Log.d(s, str);
            switch (funcCode) {
                default:
                    return;
                case 0x50008:
                    int j1 = l1.readUnsignedShort();
                    i1 = 0;
                    do {
                        if (i1 >= j1) {
                            sleep(10);
                            (new TempDataOutputStream(0x80001, 132)).sendMain(C);
                            return;
                        }
                        k1 = l1.readInt();
                        int i2 = l1.readInt();
//                                    String.format("%d,%d,%d,%d,%d,%d",
//                                            Integer.valueOf(k1), Integer.valueOf(i2), Integer.valueOf(l1.readInt()), Integer.valueOf(l1.read()), Integer.valueOf(l1.read()), Integer.valueOf(l1.readUnsignedShort())
//                                    );
                        if (i2 == 35 || i2 == 62 || i2 == 70)
                            C.d(k1);
                        i1++;
                    } while (true);


                case 0x80001:
                    i1 = l1.read();
                    if (i1 >= 6) {
                        String str1 = b();
                        StringBuilder stringbuilder = new StringBuilder("Partners_invite: ");
                        String str5;
                        if (i1 - 6 < k.length)
                            str5 = k[i1 - 6];
                        else
                            str5 = Integer.valueOf(i1).toString();
                        Log.i(str1, stringbuilder.append(l1).toString());
                        return;
                    } else {
                        Log.i(b(), (new StringBuilder("Partners_invite: ")).append(i1).toString());
                        return;
                    }
                case 0x220012:
                    if (l1.read() == 1) {
                        web.sxd.b.MainThread.sendLog("　成功领取 %d 灵石", new Object[]{
                                Integer.valueOf(l1.readInt())
                        });
                        return;
                    }
                case 0x290001:
                    if (l1.read() == 0) {
                        web.sxd.b.MainThread.sendLog("关公上香成功");
                        (new TempDataOutputStream(0x290002)).sendMain(C);
                        return;
                    }
                case 0x290002:
                    l1.readUnsignedShort();
                    web.sxd.b.MainThread.sendLog("　祝福 %d 次经验+%d%%", new Object[]{
                            Integer.valueOf(l1.readUnsignedShort()), Integer.valueOf(l1.readInt())
                    });
                    return;
                case 0x300000:
                    l1.readUTF();
                case 0x300003:
                    i1 = l1.read();
                    k1 = l1.read();
                    int k2 = l1.readInt();
                    if (i1 >= 10 && k1 >= 10) {
                        web.sxd.b.MainThread.sendLog("龙宠:%d变%d阶 已培养满", new Object[]{
                                Integer.valueOf(i1 - 1), Integer.valueOf(k1)
                        });
                        return;
                    }
                    if (funcCode == 0x300003) {
                        web.sxd.b.MainThread.sendLog("龙宠:%d变%d阶 进化成功 经验%d", new Object[]{
                                Integer.valueOf(i1 - 1), Integer.valueOf(k1), Integer.valueOf(k2)
                        });
                    } else {
                        j1 = l1.readInt();
                        web.sxd.b.MainThread.sendLog("龙宠:%d变%d阶 经验%d 剩余%d次", new Object[]{
                                Integer.valueOf(i1 - 1), Integer.valueOf(k1), Integer.valueOf(k2), Integer.valueOf(j1)
                        });
                        if (j1 <= 0)
                            return;//continue; /* Loop/switch isn't completed */
                        sleep(10);
                    }
                    c();
                    (new TempDataOutputStream(0x300002, 0L)).sendMain(C);
                    return;
                case 0x300002:
                    i1 = l1.read();
                    if (i1 == 2)
                        (new TempDataOutputStream(0x300003)).sendMain(C);
                    if (i1 == 0) {
                        l1.read();
                        l1.read();
                        l1.readInt();
                        i1 = l1.readInt();
                        l1.read();
                        j1 = l1.readInt();
                        String str3;
                        if (l1.read() > 0)
                            str3 = " !!";
                        else
                            str3 = "";
                        web.sxd.b.MainThread.sendLog("　培养龙宠: 经验+%d%s 剩余%d次", new Object[]{
                                Integer.valueOf(i1), str3, Integer.valueOf(j1)
                        });
                        if (j1 > 0) {
                            sleep(2);
                            (new TempDataOutputStream(0x300002, 0L)).sendMain(C);
                            return;
                        } else {
                            (new TempDataOutputStream(0x300000, C.d())).sendMain(C);
                            return;
                        }
                    }
                    return;
                //case 0x300003:
                case 0x680000:
                    i1 = l1.readInt();
                    j1 = l1.readUnsignedShort();
                    web.sxd.b.MainThread.sendLog("灵气: %d, 葫芦: %d+%d, 灵脉x%d", new Object[]{
                            Integer.valueOf(i1), Integer.valueOf(j1), Integer.valueOf(l1.readUnsignedShort()), Integer.valueOf(l1.readUnsignedShort())
                    });
                    if (j1 > 0) {
                        c();
                        (new TempDataOutputStream(0x680001, 0L)).sendMain(C);
                        return;
                    }
                    return;
                case 0x680001:
                    i1 = l1.read();
                    if (i1 == 0) {
                        i1 = l1.readInt();
                        j1 = l1.readInt();
                        int j2;
                        String str2;
                        if (l1.read() > 0)
                            str2 = "灵脉";
                        else
                            str2 = "";
                        k1 = l1.readUnsignedShort();
                        j2 = l1.readUnsignedShort();
                        web.sxd.b.MainThread.sendLog("　灵气+%d=>%d %sx%d 剩余%d", new Object[]{
                                Integer.valueOf(j1), Integer.valueOf(i1), str2, Integer.valueOf(k1), Integer.valueOf(j2)
                        });
                        if (j2 > 0) {
                            c();
                            (new TempDataOutputStream(0x680001, 0L)).sendMain(C);
                            return;
                        }
                    } else {
                        web.sxd.b.MainThread.sendLog("木葫芦采集灵气失败: %d", new Object[]{
                                Integer.valueOf(i1)
                        });
                        return;
                    }
                case 0x690001:
                    i1 = l1.read();
                    k1 = l1.read();
                    l1.read();
                    l1.readUnsignedShort();
                    web.sxd.b.MainThread.sendLog("[猎妖]剩余 %d次免费, %d次铜钱猎妖", new Object[]{
                            Integer.valueOf(i1), Integer.valueOf(k1)
                    });
                    c();
                    if (i1 > 0) {
                        (new TempDataOutputStream(0x690002, (byte) 0, (byte) 0)).sendMain(C);
                        return;
                    }
                case 0x690002:
                    StringBuilder sb = new StringBuilder("[猎妖]");
                    i1 = l1.read();
                    if (i1 != 5)
                        sb.append("打开宝箱失败: ");
                    switch (i1) {
                        default:sb.append("未知："+i1);
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
                    if (i1 != 5) {
                        web.sxd.b.MainThread.sendLog(sb.toString());
                        return;
                    }
            }


//            case 0x50007:
//            case 0x9000A:
//            case 0x290003:
//                return;
//        }

            //猎妖奖励
            k1 = l1.readUnsignedShort();
            i1 = 0;
            StringBuilder obj = new StringBuilder();
            while(i1<k1)
            {
                int l2 = l1.read();
                int i3 = l1.readInt();
                if(l2 >= 0 && l2 < l.length)
                    obj.append(l[l2]);
                else
                    obj.append(l[l.length - 1]);
                switch (i3)
                {
                    default :
                        obj.append(i3);break;
                    case 347: break;
                    case 1411: obj.append("女娲石");break;
                    case 1444: obj.append("粽子");break;
                    case 1487: obj.append("包子");break;
                    case 1740: obj.append("境界点");break;
                    case 1741: obj.append("灵石");break;
                    case 1742: obj.append("命格碎片");break;
                    case 1743: obj.append("仙令");break;
                }
                ((StringBuilder) (obj)).append("x");
                ((StringBuilder) (obj)).append(l1.readInt());
                i1++;
            }
            if(l1.read() == 1)
                ((StringBuilder) (obj)).append(" !!");
            web.sxd.b.MainThread.sendLog(obj.toString());
            if(!web.sxd.b.MainThread.isFuncSelect(81) || k1 <= 0)
                return;
            else
                (new TempDataOutputStream(0x690002, (byte)1, (byte)0)).sendMain(C);
            return;
            //TODO 没完

        }catch (Exception e)
        {
            Log.v("web.sxd.d.n",e.getLocalizedMessage(),e);
        }



    }

    final void a(int ai[]) throws Exception
    {
        int i1;
        int j1;
        j1 = ai.length;
        i1 = 0;
        int k1;
        while(i1<j1)
        {
            k1 = ai[i1];
            if(!C.b(k1))
            {}else
            {
                switch (k1)
                {
//                    default : break;
//                        case 2:
//                            C.addFunc(8, SendFlower, this);
//                            new web.sxd.d.ab(C);
//                            if(C.Fate() <= 0)
//                            {
//                                c();
//                                (new TempDataOutputStream(0x50008, C.d())).sendMain(C);
//                            }
//                            (new o(this)).start();
//                            break;
//                        case 8: break;
//                        case 13: new e(C);break;
//                        case 15:
//                            C.a(new web.sxd.d.Notify(C));
//                            web.sxd.d.Notify.a(C);
//                            break;
//                        case 18:
//                            new v(C);
//                            c();
//                            new web.sxd.a.m(C);
//                            break;
//                        case 34:
//                            new av(C);
//                            break;
//                        case 37: break;
//                        case 41: new web.sxd.d.z(C);break;
//                        case 46: break;
//                        case 54: new p(C);break;
                        case 56: new k(C);break;//摘仙桃
//                        case 59: new web.sxd.a.l(C);break;
//                        case 64: new a(C);break;
//                        case 68: new web.sxd.d.Fate(C);break;
//                        case 70: new web.sxd.d.d(C);break;
//                        case 90: new u(C);break;
//                        case 116: break;
//                        case 117: new q(C);break;
//                        case 123: new ak(C);break;
//                        case 126: new Fate(C);break;
                        case 127: new j(C); //终结功能
                            new at(C);
                            new ay(C);
                            break;
//                        case 129: new t(C);break;
//                        case 133: new Notify(C);break;
//                        case 134: new web.sxd.a.n(C);break;
//                        case 135: new web.sxd.a.j(C);break;
//                        case 140: new r(C);break;
//                        case 142: new aw(C);break;
//                        case 143: new y(C);break;
//                        case 146: new w(C);break;
//                        case 160: new web.sxd.a.c(C);break;
//                        case 164: new z(C);break;
//                        case 166: new x(C);break;
//                        case 169: new au(C);//TODO daiding
//                                    new aa(C);break;
//                        case 171:
//                            if(C.Fate(15))
//                                web.sxd.d.Notify.c(C);
//                            break;
//                        case 172: new d(C);break;
//                        case 173: new ab(C);break;
                }
            }
            i1++;
        }

        if(C.b(11))
            C.addFunc(9, b, this);
        if(C.b(85))
            C.addFunc(104, c, this);
        if(C.b(55))
            C.addFunc(0x29, e, this);
        if(C.b(48))
            C.addFunc(34, f, this);
        if(C.b(86))
            C.addFunc(105, d, this);
        if(C.b(60))
            C.addFunc(48, g, this);
        j = false;
        b(ai);
        return;
    }

    @Override
    protected final String[] a()
    {
        return a;
    }

    final void b(int ai[]) throws Exception
    {
        int i1;
        int j1;
        if(j)
            return;
        j = true;
        sleep(10);
        j1 = ai.length;
        i1 = 0;

        int k1;
        while (i1<j1)
        {
            k1 = ai[i1];
            if(!C.b(k1)){}else
            {
                switch (k1)
                {
                    default : break;
//                        case 8: c();break;
//                        case 13:
//                            web.sxd.d.e.a(C);
//                            c();
//                            break;
//                        case 18:
//                            v.a(C);
//                            c();
//                            web.sxd.a.m.a(C);
//                            c();
//                            break;
//                        case 34:
//                            av.a(C);
//                            c();
//                            break;
//                        case 41:
//                            z.a(C);
//                            c();
//                            break;
//                        case 46: break;
//                        case 54:
//                            sleep(3);
//                            p.a(C);
//                            c();
//                            break;
                        case 56:
                            web.sxd.d.k.a(C);
//                            c();
//                            break;
//                        case 59:
//                            web.sxd.a.l.a(C);
//                            c();
//                            break;
//                        case 64:
//                            web.sxd.d.a.a(C);
//                            c();
//                            break;
//                        case 68:
//                            web.sxd.d.Fate.a(C);
//                            c();
//                            break;
//                        case 70:
//                            sleep(3);
//                            web.sxd.d.d.a(C);
//                            c();
//                            break;
//                        case 77:
//                            web.sxd.d.Notify.Fate(C);
//                            c();
//                            break;
//                        case 116:
//                        case 117:
//                            q.a(C);
//                            c();
//                            break;
//                        case 123:
//                            ak.a(C);
//                            c();
//                            break;
//                        case 126:
//                            web.sxd.a.Fate.a(C);
//                            c();
//                            break;
//                        case 127:
//                            new web.sxd.d.Notify(C);
//                            c();
//                            web.sxd.d.Notify.Fate(C);
//                            web.sxd.d.j.Fate(C);
//                            ay.a(C);
//                            web.sxd.d.l.c(C);
//                            at.a(C);
//                            c();
//                            break;
//                        case 129:
//                            t.a(C);
//                            c();
//                            break;
//                        case 133:
//                            web.sxd.a.Notify.a(C);
//                            c();
//                            break;
//                        case 134:
//                            web.sxd.a.n.a(C);
//                            c();
//                            break;
//                        case 135:
//                            web.sxd.a.j.a(C);
//                            c();
//                            break;
//                        case 140:
//                            r.a(C);
//                            c();
//                            break;
//                        case 142:
//                            aw.a(C);
//                            c();
//                            break;
//                        case 143:
//                            y.a(C);
//                            c();
//                            break;
//                        case 146:
//                            w.a(C);
//                            c();
//                            break;
//                        case 160:
//                            web.sxd.a.c.a(C);
//                            c();
//                            break;
//                        case 164:
//                            z.a(C);
//                            c();
//                            break;
//                        case 166:
//                            x.a(C);
//                            c();
//                            break;
//                        case 169:
//                            au.a(C);
//                            c();
//                            aa.a(C);
//                            break;
//                        case 172:
//                            web.sxd.a.d.a(C);
//                            c();
//                            break;
//                        case 173:
//                            ab.a(C);
//                            c();
//                            break;
                }
            }
            i1++;
        }
        c();
        j1 = ai.length;
        i1 = 0;
        while (i1<j1) {
            k1 = ai[i1];
            if (!C.b(k1)) {
            } else {
                switch (k1)
                {
                    default :break;
                        case 48:
                            (new TempDataOutputStream(0x220012, 0L)).sendMain(C);
                            c();
                            break;
                        case 55:
                            (new TempDataOutputStream(0x290001, 1)).sendMain(C);
                            c();
                            break;
                        case 60:
                            (new TempDataOutputStream(0x300000, C.d())).sendMain(C);
                            c();
                            break;
                        case 85:
                            (new TempDataOutputStream(0x680000)).sendMain(C);
                            c();
                            break;
                        case 86:
                            (new TempDataOutputStream(0x690001, (byte)1)).sendMain(C);
                            c();
                            break;
                }
            }
            i1++;
        }
        j = false;
        return;
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
    private static final String e[] = {//关公
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