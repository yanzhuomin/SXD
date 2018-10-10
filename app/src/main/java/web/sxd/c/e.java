// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:45
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.c;

import android.util.Log;

//import web.sxd.a.ag;
//import web.sxd.a.p;
import web.sxd.b.*;

// Referenced classes of package web.sxd.c:
//            Fate

public final class e extends BaseFunc
{

    public e(MainThread c1)
    {
        super(c1, 0x2001d);
        a = 20;
        b = 40;
        c = 41;
        d = 42;
        e = 43;
        f = 44;
        g = 45;
        h = 46;
        i = 47;
        k = Boolean.valueOf(true);
    }

    public static void a(MainThread c1) throws Exception
    {
        (new TempDataOutputStream(0x20006)).sendMain(c1);
    }

    static void a(MainThread c1, int i1) throws Exception
    {
        (new TempDataOutputStream(0x2001d, i1)).sendMain(c1);
    }

    public static void b(MainThread c1) throws Exception
    {
        c();
        (new TempDataOutputStream(0x20029)).sendMain(c1);
    }

    public static String c(int i1)
    {
        switch(i1)
        {
        default:
            return (new StringBuilder("No.")).append(i1).toString();
        case 347:             return "黄玉牌";
        case 1411:            return "女娲石碎片";
        case 1444:            return "粽子";
        case 1488:            return "包子";
        case 1739:            return "声望";
        case 1740:            return "境界点";
        case 1741:            return "灵石";
        case 1742:            return "命格碎片";
        case 1743:            return "仙令";
        case 1747:            return "铜钱";
        case 1748:            return "阅历";
        case 1845:            return "混沌灵液";
        case 2016:            return "茶叶蛋";
        case 2197:            return "神兵锁";
        case 2263:            return "器魂";
        case 2395:            return "内丹";
        case 2397:            return "鸿蒙紫气";
        case 2403:            return "道缘";
        case 2405:            return "经验丹";
        case 2410:            return "太初";
        case 2427:            return "初级五行之灵";
        case 2452:            return "血脉精华";
        case 2453:            return "龙珠碎片";
        case 2471:            return "高级灵石";
        case 2682:            return "中级五行之灵";
        case 3050:            return "魔石碎片";
        case 3277:            return "初级金灵";
        case 3278:            return "初级木灵";
        case 3279:            return "初级水灵";
        case 3280:            return "初级火灵";
        case 3281:            return "初级土灵";
        case 3282:            return "中级金灵";
        case 3283:            return "中级木灵";
        case 3284:            return "中级水灵";
        case 3285:            return "中级火灵";
        case 3286:            return "中级土灵";
        case 3287:            return "高级金灵";
        case 3288:            return "高级木灵";
        case 3289:            return "高级水灵";
        case 3290:            return "高级火灵";
        case 3291:            return "高级土灵";
        case 3706:            return "星魂";
        case 3975:            return "白色晶魄";
        case 3976:            return "蓝色晶魄";
        case 3979:            return "紫色晶魄";
        case 3983:            return "种植祝福";
        case 3984:            return "取经祝福";
        }
    }

    public static String d(int i1)
    {
        switch(i1)
        {
            default:
                return (new StringBuilder("No.")).append(i1).toString();
            case 2: // '\002'
                return "元宝";
            case 3: // '\003'
                return "铜钱";
            case 4: // '\004'
                return "体力";
            case 5: // '\005'
                return "声望";
            case 6: // '\006'
                return "灵石";
            case 7: // '\007'
                return "境界点";
            case 8: // '\Fate'
                return "仙令";
            case 9: // '\t'
                return "坐骑";
            case 10: // '\n'
                return "命格";
            case 11: // '\013'
                return "阅历";
            case 12: // '\f'
                return "经验";
            case 13: // '\r'
                return "宠物";
            case 14: // '\016'
                return "龙珠";
            case 15: // '\017'
                return "龙珠资源";
            case 16: // '\020'
                return "内丹";
            case 17: // '\021'
                return "血脉精华";
            case 18: // '\022'
                return "器魂";
            case 19: // '\023'
                return "神兵锁";
            case 20: // '\024'
                return "鸿蒙紫气";
            case 21: // '\025'
                return "方子晴碎片";
            case 22: // '\026'
                return "灵件";
            case 23: // '\027'
                return "翻牌次数";
            case 24: // '\030'
                return "灵气";
            case 25: // '\031'
                return "道缘";
            case 26: // '\032'
                return "卡魂";
            case 27: // '\033'
                return "格子";
            case 28: // '\034'
                return "称号";
            case 29: // '\035'
                return "伙伴套装";
            case 30: // '\036'
                return "觉醒技能书";
            case 31: // '\037'
                return "缘石";
            case 32: // ' '
                return "橙装碎片";
            case 518:
                return "BOSS击退礼包";
            case 2400:
                return "累登抽奖券";
            case 3065:
                return "蓝色夫妻宝箱";
            case 3066:
                return "紫色夫妻宝箱";
            case 3067:
                return "金色夫妻宝箱";
            case 4062:
                return "更新礼包";
            case 4063:
                return "伙伴之灵";
            case 4274:
                return "极限挑战宝箱";
            case 5246:
                return "五行宝箱";
            case 5315:
                return "普通谢礼";
            case 5321:
                return "帮派入侵终结礼包";
        }
    }

    public final void a(TempDataInputStream l1)
    {
        try {


            int i1;
            i1 = 1;
            super.a(l1);
            switch (l1.getFuncCode()) {
                default:
                    return;
                case 131078://0x20006
                    m = l1.readUnsignedShort();
                    if (m <= 0) break;
                    //continue; /* Loop/switch isn't completed */
                    while (i1 <= m) {
                        int k1 = l1.readInt();
                        int j2 = l1.readInt();
                        String s = l1.readUTF();
                        l1.readUTF();
                        l1.skipBytes(l1.readUnsignedShort() * 9);
                        if (j2 == 4 || j2 == 10 || j2 == 14 || j2 == 16 || j2 == 19 ||
                                j2 == 27 || j2 == 40 || j2 == 90 || j2 == 149 || j2 == 145) {
                            a(5);
                            (new TempDataOutputStream(0x2001d, k1)).sendMain(C);
                            web.sxd.b.MainThread.sendLog((new StringBuilder("[礼包]")).append(s).toString());
                        } else if (j2 == 136) {
                            a(5);
                            (new TempDataOutputStream(0x2001d, k1)).sendMain(C);
                            web.sxd.b.MainThread.sendLog((new StringBuilder("[礼包]")).append(s).toString());
                        } else if (j2 == 135) {
                            a(5);
                            (new TempDataOutputStream(0x2001d, k1)).sendMain(C);
                            web.sxd.b.MainThread.sendLog((new StringBuilder("[礼包]")).append(s).toString());
                            if (C.b(32))
                                (new TempDataOutputStream(0x20029)).sendMain(C);
                        } else{
                            web.sxd.b.MainThread.sendLog((new StringBuilder("[不领礼包]")).append(j2).append(s).toString());
                        }
                        i1++;
                    }
                    if (!C.b(32)) return;
                    else {
                        (new TempDataOutputStream(0x20029)).sendMain(C);
                        return;
                    }
                case 131101://0x2001D
                    switch (l1.read()) {
                        default:
                            return;

                        case 22: // '\026'
                            web.sxd.b.MainThread.sendLog("[礼包]领取失败: 背包已满");
                            break;
                    }
                    if (C.b(32)) {
                        (new TempDataOutputStream(0x20029)).sendMain(C);
                        return;
                    }
                    break;
                case 131113://0x20029
                    int k2;
                    l1.readUnsignedShort();
                    l1.readInt();
                    k2 = l1.readUnsignedShort();
                    i1 = 0;
                    while (i1 < k2) {
                        int l2;
                        int i3;
                        int j3;
                        int k3;

                        l2 = l1.readInt();
                        i3 = l1.readInt();
                        j3 = l1.readInt();
                        l1.readInt();
                        l1.readInt();
                        k3 = l1.readInt();
                        l1.skipBytes(26);
                        if (!C.b(32) || i3 != 518 && i3 != 2400 && i3 != 3065 && i3 != 3066 && i3 != 3067 && i3 != 4062 && i3 != 4063 && i3 != 4274 && i3 != 5246 && i3 != 5315 && i3 != 5321) {
                        } else {
                            int i2;
                            j = i3;
                            i2 = 0;
                            while (i2 < k3) {
                                c();
                                (new TempDataOutputStream(0x20035, (short) j3)).sendMain(C);
                                i2++;
                            }
                            if (i3 != 4872) ;
                            else {
                                c();
                                web.sxd.b.MainThread.sendLog("  打开普通藏宝图,挖宝中...");
                                if (k.booleanValue())
                                    ;//TODO 暂时注释new p(C);
                                c();
                                //TODO 暂时注释p.a(C, j3);
                                return;
                            }
                        }
                        if (k.booleanValue() && (i3 == 2475 || i3 == 2476 || i3 == 2477)) {
                            //TODO 暂时注释new ag(C);
                            k = Boolean.valueOf(false);
                        }
                        if (i3 == 382 || i3 == 383 || i3 == 385 || i3 == 386 || i3 == 387 || i3 == 395 || i3 == 397 || i3 == 399 || i3 == 401 || i3 == 403 || i3 == 411 || i3 == 413 || i3 == 415 || i3 == 417 || i3 == 420 || i3 == 793 || i3 == 794 || i3 == 795 || i3 == 1009 || i3 == 1010) {
                            c();
                            if (C.b(35))
                                (new TempDataOutputStream(0x20049, (short) j3)).sendMain(C);
                        }
                        if (i3 == 2475) {
                            ;//TODO 暂时注释ag.a(C, l2);
                        }else if (i3 == 2476) {
                            ;//TODO 暂时注释ag.Fate(C, l2);
                        } else {
                            if (i3 != 2477)
                                continue; /* Loop/switch isn't completed */
                            //TODO 暂时注释ag.c(C, l2);
                        }

                        i1++;
                    }

                    if (k.booleanValue()) {
                        //TODO 暂时注释 new ag(C);
                        //TODO 暂时注释 ag.a(C);
                        return;
                    }
                    break;

                case 131125://0x20035
                    int j1 = l1.read();
                    if (j1 == a) {
                        web.sxd.b.MainThread.sendLog("[礼包]%s 成功打开 ", new Object[]{
                                d(j)
                        });
                        return;
                    }
                    if (j1 == h) {
                        Fate.b(C);
                        (new TempDataOutputStream(0x20029)).sendMain(C);
                        return;
                    }
                    break;
                case 131202://0x20082
                    if (l1.read() == a) {
                        web.sxd.b.MainThread.sendLog("[礼包]%s 批量打开成功 ", new Object[]{
                                d(j)
                        });
                        return;
                    }
                    break;
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.c.e",e.getLocalizedMessage(),e);
        }

    }

    protected final String[] a()
    {
        return l;
    }

    private static final String l[] = {
        "Item_", "", "", "", "", "", "", "get_player_gift_all_info", "", "", 
        "", "", "", "", "", "", "", "", "", "", 
        "", "", "", "", "", "", "", "", "", "", 
        "player_get_super_gift", "", "", "", "", "", "", "", "", "", 
        "", "", "get_player_pack_item_list", "", "", "", "", "", "", "", 
        "", "", "", "", "player_use_grid_item", "", "", "", "", "has_level_gift_item", 
        "", "", "", "", "", "", "", "", "", "", 
        "", "", "", "", "player_sell_item", "", "", "", "", "", 
        "", "", "", "", "", "", "", "", "", "", 
        "", "", "", "", "", "", "", "", "", "", 
        "", "", "", "", "", "", "", "", "", "", 
        "", "", "", "", "", "", "", "", "", "", 
        "", "", "", "", "", "", "", "", "", "", 
        "", "large_use_grid_item", "", "", "", "", "", "", "", "", 
        "", ""
    };
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    Boolean k;
    private int m;

}