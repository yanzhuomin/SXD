// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:47
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;
import java.util.*;
import web.sxd.b.*;

// Referenced classes of package web.sxd.d:
//            ac, n

public final class t extends BaseFunc
{

    public t(MainThread c1)
    {
        super(c1, 0x730000);
        a = Boolean.valueOf(false);
        e = true;
        f = -1;
        g = -1;
    }

    static void a(MainThread c1) throws Exception
    {
        (new TempDataOutputStream(0x730000)).sendXJ(c1);
    }

    static void e()
    {
    }

    public final void a(TempDataInputStream l1)
    {
        try {

            super.a(l1);
            switch (l1.getFuncCode()) {
                default:return;
                case 7536640:
                    int flag = l1.read();
                    switch(flag)
                    {
                        default:
                            web.sxd.b.MainThread.sendLog("[神魔竞技]日程状态异常");
                            d = -1;
                            return;

                        case 25: // '\031'
                            d = 0;
                            c();
                            (new TempDataOutputStream(0x730024)).sendXJ(C);
                            return;

                        case 21: // '\025'
                        case 22: // '\026'
                        case 23: // '\027'
                        case 24: // '\030'
                            d = flag - 20;
                            flag = d;
                            break;
                    }
                    String str;
                    if(d == 4)
                        str = ", 下午争霸赛";
                    else
                        str = "";
                    web.sxd.b.MainThread.sendLog("[神魔竞技]积分赛第 %d 天%s", new Object[] {
                            Integer.valueOf(flag), str
                    });
                    c();
                    (new TempDataOutputStream(0x730001)).sendXJ(C);
                    return;
                case 7536641:
                    f = l1.readUnsignedShort();
                    l1.readUnsignedShort();
                    int k = l1.readUnsignedShort();
                    int i1 = l1.readUnsignedShort();
                    l1.read();
                    boolean flag1;
                    int j2;
                    if(l1.read() == 26)
                        flag1 = true;
                    else
                        flag1 = false;
                    j2 = f;
                    if(flag1)
                        str = "已";
                    else
                        str = "未";
                    web.sxd.b.MainThread.sendLog("[神魔竞技]%d次, 小组第%d 奖励%s领取", new Object[] {
                            Integer.valueOf(k), Integer.valueOf(j2), str
                    });
                    if(!flag1)
                    {
                        TempDataOutputStream out = new TempDataOutputStream(0x730009);
                        out.writeShort(C.g());
                        out.sendXJ(C);
                        c();
                    }
                    if(k <= 0 || !C.b(93)) return; else {

                        if (i1 == 0) {
                            c();
                            (new TempDataOutputStream(0x730002)).sendXJ(C);
                            return;
                        } else {
                            web.sxd.b.MainThread.sendLog("[神魔竞技]冷却时间 %s 秒, 等待中", new Object[]{
                                    Integer.valueOf(i1)
                            });
                            sleep(i1 * 5);
                            (new TempDataOutputStream(0x730001)).sendXJ(C);
                            return;
                        }
                    }
                case 7536642:
                    if(!C.b(93)) return;
                    int l4;
                    int max = 0x7fffffff;
                    k = -1;
                    l4 = l1.readUnsignedShort();
                    i1 = 0;
                    while (true)
                    {
                        int i6;
                        if(i1 >= l4)
                        {
                            e = false;
                            if(k < 0)
                            {
                                web.sxd.b.MainThread.sendLog("[神魔竞技]没有可挑战对手, 等待刷新");
                                e = true;
                                return;
                            }
                            break; /* Loop/switch isn't completed */
                        }
                        int j4 = l1.read();
                        int j5 = l1.readInt();
                        String obj = l1.readUTF();
                        int k5 = l1.readUnsignedShort();
                        int l5 = l1.readUnsignedShort();
                        int j3 = l1.readInt();
                        i6 = l1.read();
                        boolean flag2;
                        String s;
                        String s1;
                        if(i6 != 27)
                            flag2 = true;
                        else
                            flag2 = false;
                        s = (new StringBuilder(String.valueOf(obj))).append(n.a(C, l1)).toString();
                        l1.readUnsignedShort();
                        s1 = b();
                        if(flag2)
                            break; /* Loop/switch isn't completed */
                        obj = "未挑战";
                        if(i6 == 28)
                            obj = "已击败";
                        else
                            obj = "挑战失败";
                        Log.i(s1, String.format("%d:Lv%d,%d: <%d>%s [%d] %s", new Object[] {
                                Integer.valueOf(j4), Integer.valueOf(l5), Integer.valueOf(j3), Integer.valueOf(j5), s, Integer.valueOf(i6), obj
                        }));
                        if(!flag2 && e)
                            web.sxd.b.MainThread.sendLog("[神魔竞技]对手%d: Lv.%d 战力%d %s %s", new Object[] {
                                    Integer.valueOf(j4), Integer.valueOf(l5), Integer.valueOf(j3), n.c(k5), s
                            });
                        if(!flag2 && j3 < max)
                        {
                            k = j4;
                            max = j3;
                        }

                        i1++;
                    }
                    if(max > C.c() && web.sxd.b.MainThread.isFuncSelect(87)) {
                        web.sxd.b.MainThread.sendLog("[神魔竞技]对手战力%d, 自己%d, 停止挑战", new Object[]{
                                Integer.valueOf(max), Integer.valueOf(C.c())
                        });
                        return;
                    } else {
                        web.sxd.b.MainThread.sendLog("[神魔竞技]挑战对手%d, 战力%d", new Object[]{
                                Integer.valueOf(k), Integer.valueOf(max)
                        });
                        c();
                        (new TempDataOutputStream(0x730003, (byte) k)).sendXJ(C);
                        return;
                    }
                case 7536643:
                case 7536649:
                case 7536651:
                case 7536652:return;
                case 7536653:return;
                case 7536670:
                case 7536672:
                case 7536676:
                case 7536677:
                case 7536679:
                case 7536680:
                case 7536681:
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.d.t",e.getLocalizedMessage(),e);
        }

//        JVM INSTR lookupswitch 15: default 140
//    //                   7536640: 1494
//    //                   7536641: 1642
//    //                   7536642: 1914
//    //                   7536643: 2349
//    //                   7536649: 1860
//    //                   7536651: 1119
//    //                   7536652: 140
//    //                   7536653: 140
//    //                   7536670: 1202
//    //                   7536672: 147
//    //                   7536676: 1125
//    //                   7536677: 999
//    //                   7536679: 141
//    //                   7536680: 147
//    //                   7536681: 2508;
//           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L1 _L1 _L8 _L9 _L10 _L11 _L12 _L9 _L13
//_L1:
//        return;
//_L12:
//        l1 = C;
//        return;
//_L9:
//        int i;
//        int k;
//        int i1;
//        int k3;
//        TreeMap treemap;
//        i = l1.read();
//        k3 = l1.readUnsignedShort();
//        Log.i(b(), (new StringBuilder("group ")).append(i).append(": ").append(k3).append(" pairs").toString());
//        treemap = new TreeMap();
//        i = 0;
//        i1 = 0;
//        k = 0;
//_L28:
//        if(i1 < k3 * 2) goto _L15; else goto _L14
//_L14:
//        i1 = l1.readUnsignedShort();
//        k = 0;
//_L30:
//        if(k < i1) goto _L17; else goto _L16
//_L16:
//        Object obj;
//        Object obj1;
//        int j1;
//        int k2;
//        int l3;
//        int k4;
//        int i5;
//        if(l1.c() == 0x730028)
//            k = 1;
//        else
//            k = 4;
//        obj1 = new StringBuilder();
//        i1 = 0;
//        obj = null;
//_L37:
//        if(i1 < k) goto _L19; else goto _L18
//_L18:
//        ((StringBuilder) (obj1)).append(l1.readInt());
//        ((StringBuilder) (obj1)).append(": ");
//        l3 = l1.readUnsignedShort();
//        k = 0;
//        i1 = 0;
//_L40:
//        if(k < l3) goto _L21; else goto _L20
//_L20:
//        Log.i(b(), ((StringBuilder) (obj1)).toString());
//        l1 = ((l) (obj));
//        if(obj != null) goto _L23; else goto _L22
//_L22:
//        if(treemap.size() <= 0) goto _L25; else goto _L24
//_L24:
//        l1 = (ac)treemap.get(treemap.firstKey());
//_L23:
//        if(i1 == 0 || g < 0)
//        {
//            web.sxd.b.c.a("[\u795E\u9B54\u4E89\u9738]\u76EE\u524D\u4E0D\u53EF\u652F\u6301");
//            return;
//        }
//        continue; /* Loop/switch isn't completed */
//_L15:
//        j1 = l1.readInt();
//        obj1 = l1.readUTF();
//        obj = n.c(l1.readUnsignedShort());
//        k2 = l1.readInt();
//        k4 = l1.readInt();
//        i5 = l1.readUnsignedShort();
//        obj1 = (new StringBuilder(String.valueOf(obj1))).append(n.a(C, l1)).toString();
//        if(k2 > k)
//        {
//            i = j1;
//            k = k2;
//        }
//        treemap.put(Integer.valueOf(-k2), new ac(j1, ((String) (obj1)), i5, k2));
//        obj = new StringBuilder(String.format("%4d %d,%d,%slv.%d,%s %dw [", new Object[] {
//            Integer.valueOf(j1), Integer.valueOf(k4), Integer.valueOf(k2), obj, Integer.valueOf(i5), obj1, Integer.valueOf(l1.a())
//        }));
//        k2 = l1.readUnsignedShort();
//        j1 = 0;
//_L29:
//        if(j1 < k2) goto _L27; else goto _L26
//_L26:
//        ((StringBuilder) (obj)).append(String.format("]pet%s%d.%d %d", new Object[] {
//            l1.readUTF(), Integer.valueOf(l1.readUnsignedShort()), Integer.valueOf(l1.read()), Integer.valueOf(l1.read())
//        }));
//        Log.i(b(), ((StringBuilder) (obj)).toString());
//        i1++;
//          goto _L28
//_L27:
//        ((StringBuilder) (obj)).append(l1.readUnsignedShort());
//        ((StringBuilder) (obj)).append(',').append(l1.readUnsignedShort());
//        j1++;
//          goto _L29
//_L17:
//        l1.skipBytes(8);
//        l1.readUTF();
//        k++;
//          goto _L30
//_L19:
//        int l2;
//        ((StringBuilder) (obj1)).append('[');
//        l2 = l1.readUnsignedShort();
//        if(l2 <= 0) goto _L32; else goto _L31
//_L31:
//        int k1;
//        HashSet hashset;
//        hashset = new HashSet();
//        k1 = l1.readInt();
//        hashset.add(Integer.valueOf(k1));
//        ((StringBuilder) (obj1)).append(k1);
//        k1 = 1;
//_L38:
//        if(k1 < l2) goto _L34; else goto _L33
//_L33:
//        Iterator iterator = treemap.values().iterator();
//_L39:
//        if(iterator.hasNext()) goto _L36; else goto _L35
//_L35:
//        obj = null;
//_L32:
//        ((StringBuilder) (obj1)).append("] ");
//        if(i1 == 0 && k > 1)
//            ((StringBuilder) (obj1)).append("\n   ");
//        i1++;
//          goto _L37
//_L34:
//        int i4 = l1.readInt();
//        hashset.add(Integer.valueOf(i4));
//        ((StringBuilder) (obj1)).append(',').append(i4);
//        k1++;
//          goto _L38
//_L36:
//        obj = (ac)iterator.next();
//        if(!hashset.contains(Integer.valueOf(((ac) (obj)).a()))) goto _L39; else goto _L32
//_L21:
//        int i3 = l1.readInt();
//        int i2 = i1;
//        if(i3 > i1)
//            i2 = i3;
//        if(k > 0)
//            ((StringBuilder) (obj1)).append(',');
//        ((StringBuilder) (obj1)).append(i3);
//        k++;
//        i1 = i2;
//          goto _L40
//        if(i <= 0 || i1 == 0 || g < 0) goto _L1; else goto _L41
//_L41:
//        web.sxd.b.c.a("[\u795E\u9B54\u4E89\u9738]\u652F\u6301 %s", new Object[] {
//            l1.toString().split(" ")[2]
//        });
//        (new m(0x730025, l1.a())).b(C);
//        return;
//_L11:
//        i = l1.read();
//        l1 = new StringBuilder("[\u795E\u9B54\u4E89\u9738]\u652F\u6301");
//        if(i == 28)
//        {
//            l1.append("\u6210\u529F");
//            web.sxd.b.c.a(l1.toString());
//            return;
//        }
//        l1.append("\u5931\u8D25: ");
//        i;
//        JVM INSTR tableswitch 45 47: default 1072
//    //                   45 1086
//    //                   46 1097
//    //                   47 1108;
//           goto _L42 _L43 _L44 _L45
//_L42:
//        l1.append(i);
//_L46:
//        web.sxd.b.c.a(l1.toString());
//        return;
//_L43:
//        l1.append("\u91CD\u590D\u652F\u6301");
//          goto _L46
//_L44:
//        l1.append("\u8D5B\u7A0B\u4E0D\u5B58\u5728");
//          goto _L46
//_L45:
//        l1.append("\u94DC\u94B1\u4E0D\u8DB3");
//          goto _L46
//_L7:
//        l1.read();
//        return;
//_L10:
//        i = l1.readUnsignedShort();
//        if(i == 0)
//        {
//            a = Boolean.valueOf(false);
//            (new m(0x73001e)).b(C);
//            return;
//        }
//        a = Boolean.valueOf(true);
//        l1.read();
//        l1.readInt();
//        l1 = l1.readUTF();
//        if(i > 0)
//        {
//            web.sxd.b.c.a("[\u795E\u9B54\u4E89\u9738]\u5DF2\u652F\u6301 %s", new Object[] {
//                l1
//            });
//            return;
//        }
//          goto _L25
//_L8:
//        if(a.booleanValue()) goto _L25; else goto _L47
//_L47:
//        g = -1;
//        k = l1.read();
//        Log.i(b(), (new StringBuilder("get_race_step: ")).append(k).toString());
//        k;
//        JVM INSTR lookupswitch 2: default 1276
//    //                   4: 1370
//    //                   18: 1379;
//           goto _L48 _L49 _L50
//_L48:
//        if(k >= 5 && k <= 17)
//        {
//            boolean flag;
//            if(k % 2 == 1)
//                flag = true;
//            else
//                flag = false;
//            if(k == 5)
//            {
//                web.sxd.b.c.a("[\u795E\u9B54\u7ADE\u6280]\u795E\u9B54\u4E89\u9738\u51C6\u5907\u4E2D");
//                d = 0;
//            } else
//            if(d == 0)
//            {
//                obj = c[k / 2 - 3];
//                if(flag)
//                    l1 = "\u5DF2\u7ED3\u675F";
//                else
//                    l1 = "\u8FDB\u884C\u4E2D";
//                web.sxd.b.c.a("[\u795E\u9B54\u4E89\u9738]%s %s", new Object[] {
//                    obj, l1
//                });
//            }
//            g = k / 2 - 2;
//            switch(k)
//            {
//            case 16: // '\020'
//            default:
//                c();
//                (new m(0x730020, (byte)0)).b(C);
//                return;
//
//            case 17: // '\021'
//                if(d == 0)
//                {
//                    d = 1;
//                    (new m(0x730001)).b(C);
//                }
//                // fall through
//
//            case 15: // '\017'
//                c();
//                (new m(0x730028)).b(C);
//                return;
//            }
//        }
//_L25:
//        if(true) goto _L1; else goto _L49
//_L49:
//        web.sxd.b.c.a("[\u795E\u9B54\u7ADE\u6280]\u795E\u9B54\u4E89\u9738\u5DF2\u5173\u95ED");
//          goto _L48
//_L50:
//        web.sxd.b.c.a("[\u795E\u9B54\u7ADE\u6280]\u795E\u9B54\u4E89\u9738\u5DF2\u5F00\u59CB");
//          goto _L48
//
//
//
//_L6:
//        if(l1.read() != 28) goto _L1; else goto _L52
//_L52:
//        web.sxd.b.c.a("[\u795E\u9B54\u7ADE\u6280]\u9886\u53D6\u5956\u52B1: \u94DC\u94B1%dw, \u58F0\u671B%d, \u8840\u8109x%d", new Object[] {
//            Integer.valueOf(l1.readInt() / 10000), Integer.valueOf(l1.readUnsignedShort()), Integer.valueOf(l1.read())
//        });
//        return;
//_L4:
//        if(!C.b(93)) goto _L1; else goto _L53
//_L53:
//        int l4;
//        flag1 = 0x7fffffff;
//        k = -1;
//        l4 = l1.readUnsignedShort();
//        i1 = 0;
//_L55:
//        int i6;
//        if(i1 >= l4)
//        {
//            e = false;
//            if(k < 0)
//            {
//                web.sxd.b.c.a("[\u795E\u9B54\u7ADE\u6280]\u6CA1\u6709\u53EF\u6311\u6218\u5BF9\u624B, \u7B49\u5F85\u5237\u65B0");
//                e = true;
//                return;
//            }
//            break; /* Loop/switch isn't completed */
//        }
//        int j4 = l1.read();
//        int j5 = l1.readInt();
//        obj = l1.readUTF();
//        int k5 = l1.readUnsignedShort();
//        int l5 = l1.readUnsignedShort();
//        int j3 = l1.readInt();
//        i6 = l1.read();
//        boolean flag2;
//        String s;
//        String s1;
//        if(i6 != 27)
//            flag2 = true;
//        else
//            flag2 = false;
//        s = (new StringBuilder(String.valueOf(obj))).append(n.a(C, l1)).toString();
//        l1.readUnsignedShort();
//        s1 = b();
//        if(flag2)
//            break; /* Loop/switch isn't completed */
//        obj = "\u672A\u6311\u6218";
//_L56:
//        Log.i(s1, String.format("%d:Lv%d,%d: <%d>%s [%d] %s", new Object[] {
//            Integer.valueOf(j4), Integer.valueOf(l5), Integer.valueOf(j3), Integer.valueOf(j5), s, Integer.valueOf(i6), obj
//        }));
//        if(!flag2 && e)
//            web.sxd.b.c.a("[\u795E\u9B54\u7ADE\u6280]\u5BF9\u624B%d: Lv.%d \u6218\u529B%d %s %s", new Object[] {
//                Integer.valueOf(j4), Integer.valueOf(l5), Integer.valueOf(j3), n.c(k5), s
//            });
//        if(!flag2 && j3 < flag1)
//        {
//            k = j4;
//            flag1 = j3;
//        }
//        i1++;
//        if(true) goto _L55; else goto _L54
//_L54:
//        if(i6 == 28)
//            obj = "\u5DF2\u51FB\u8D25";
//        else
//            obj = "\u6311\u6218\u5931\u8D25";
//          goto _L56
//        if(true) goto _L55; else goto _L57
//_L57:
//        if(flag1 > C.c() && web.sxd.b.c.c(87))
//        {
//            web.sxd.b.c.a("[\u795E\u9B54\u7ADE\u6280]\u5BF9\u624B\u6218\u529B%d, \u81EA\u5DF1%d, \u505C\u6B62\u6311\u6218", new Object[] {
//                Integer.valueOf(flag1), Integer.valueOf(C.c())
//            });
//            return;
//        } else
//        {
//            web.sxd.b.c.a("[\u795E\u9B54\u7ADE\u6280]\u6311\u6218\u5BF9\u624B%d, \u6218\u529B%d", new Object[] {
//                Integer.valueOf(k), Integer.valueOf(flag1)
//            });
//            c();
//            (new m(0x730003, (byte)k)).b(C);
//            return;
//        }
//
//_L5:
//        int j = l1.read();
//        switch(j)
//        {
//        default:
//            web.sxd.b.c.a("[\u795E\u9B54\u7ADE\u6280]\u6311\u6218\u5931\u8D25: %d", new Object[] {
//                Integer.valueOf(j)
//            });
//            return;
//
//        case 28: // '\034'
//            l1.readInt();
//            web.sxd.b.c.a("[\u795E\u9B54\u7ADE\u6280]\u53D1\u8D77\u6311\u6218, \u58F0\u671B+%d, \u79EF\u5206+%d", new Object[] {
//                Integer.valueOf(l1.read()), Integer.valueOf(l1.readUnsignedShort())
//            });
//            b(5);
//            (new m(0x730002)).b(C);
//            return;
//
//        case 29: // '\035'
//            web.sxd.b.c.a("[\u795E\u9B54\u7ADE\u6280]\u6311\u6218\u5931\u8D25");
//            return;
//
//        case 30: // '\036'
//            web.sxd.b.c.a("[\u795E\u9B54\u7ADE\u6280]\u4E0A\u4E00\u573A\u5931\u8D25, \u51B7\u5374\u4E2D");
//            e = true;
//            return;
//
//        case 31: // '\037'
//            web.sxd.b.c.a("[\u795E\u9B54\u7ADE\u6280]\u6311\u6218\u5931\u8D25: \u5DF2\u6311\u6218");
//            return;
//
//        case 32: // ' '
//            web.sxd.b.c.a("[\u795E\u9B54\u7ADE\u6280]\u6311\u6218\u5931\u8D25: \u8D5B\u7A0B\u672A\u5F00");
//            return;
//
//        case 33: // '!'
//            web.sxd.b.c.a("[\u795E\u9B54\u7ADE\u6280]\u6311\u6218\u5931\u8D25: \u6CA1\u6B21\u6570\u4E86");
//            break;
//        }
//        return;
//_L13:
//        l1.read();
//        return;
    }

    protected final String[] a()
    {
        return b;
    }

    private static final String b[] = {
        "StSuperSport_", "get_st_super_sport_status", "get_player_st_super_sport", "challenge_list", "challenge", "", "", "", "get_player_group_score", "get_score_rank", 
        "get_rank_award", "", "", "", "", "", "", "", "", "", 
        "", "", "", "", "", "", "", "", "", "", 
        "", "get_race_step", "get_standings", "get_race_list", "get_war_result_list", "get_race_standings", "get_player_war_report", "get_player_bet", "bet", "get_bet_coin_rank", 
        "notify_war_race_start", "get_finally_race_list", "get_st_sup_war_bet"
    };
    private static final String c[] = {
            "16强赛", "8强赛", "4强赛", "半决赛", "决赛", "终极之战"
    };
    private static int d = -1;
    Boolean a;
    private boolean e;
    private int f;
    private int g;

}