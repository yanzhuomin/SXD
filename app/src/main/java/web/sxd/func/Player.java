// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:47
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.func;

import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import web.sxd.Thread.MainThread;
import web.sxd.base.BaseFunc;
import web.sxd.base.MESSAGE_TAG;
import web.sxd.base.TempDataInputStream;
import web.sxd.base.TempDataOutputStream;
//import web.sxd.a.ah;
//import web.sxd.c.Fate;

// Referenced classes of package web.sxd.d:
//            n, l, x, ad, 
//            r, j, s, t,
//            k, u, quit, e

public final class Player extends BaseFunc
{
    public Player(MainThread mainThread)
    {
        super(mainThread);
        e = true;
        f = 0;
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


    @Override
    public int Process(TempDataInputStream l1)
    {
        int i1;
        i1 = l1.getFuncCode();
        try {
            switch (i1) {
                default:
                    return -1;
                case 0:
                case 1:
                    switch (l1.read()) {
                        default:
                            MainThread.sendLog("未知登录错误");
                            return -1;
                        case 0:
                            String s1 = "登录成功，查询角色信息：";
                            mainThread.setPlayerID(l1.readInt());
                            //(new web.sxd.b.TempDataOutputStream(2)).sendMain(C);
                            MainThread.sendLog(s1);
                            return 0;
                        case 1:
                            MainThread.sendLog(-2, "登录失败，请重试 (2 秒后自动刷新)");
                            return -1;
                        case 2:
                            MainThread.sendLog("尚未创建角色");
                            return -1;
                        case 3:
                            MainThread.sendLog("未知登录错误");
                            return -1;
                        case 4:
                            String s2 = "登录成功，查询角色信息：";
                            mainThread.setPlayerID(l1.readInt());
                            MainThread.sendLog(s2);
                            return 0;
                    }
                case 2:
                    String s2 = l1.readUTF();
                    int j2 = l1.readInt();
                    mainThread.a(s2, j2, l1.readInt(), l1.a());
                    MainThread.sendLog("%s(%d级) %d元宝 %dw铜钱", new Object[]{
                            s2, Integer.valueOf(j2), Integer.valueOf(mainThread.getGold()), Integer.valueOf(mainThread.getCoin())
                    });
                    l1.skipBytes(8);
                    int j3 = l1.readInt();
                    mainThread.g(j3);
                    long l4 = l1.readLong();
                    long l6 = l1.readLong();
                    mainThread.setExp(l4);
                    mainThread.setMaxExp(l6);
                    boolean flag1;
                    if (l6 > 0x989680L)
                        i1 = 1;
                    else
                        i1 = 0;
                    if (i1 != 0) {
                        l6 /= 10000L;
                        MainThread.sendLog("  体力%d  %dw/%dw (%d%%)", new Object[]{
                                Integer.valueOf(j3), Long.valueOf(l4 / 10000L), Long.valueOf(l6), Integer.valueOf(mainThread.h())
                        });
                    } else {
                        MainThread.sendLog("  体力%d  %d/%d (%d%%)", new Object[]{
                                Integer.valueOf(j3), Long.valueOf(l4), Long.valueOf(l6), Integer.valueOf(mainThread.h())
                        });
                    }
//                    (new web.sxd.b.TempDataOutputStream(46)).sendMain(C);
//                    (new web.sxd.b.TempDataOutputStream(9)).sendMain(C);
                    i1 = l1.readInt();
                    j3 = l1.readInt();
                    mainThread.h(i1);
                    Log.i(FuncNamePrefix, (new StringBuilder("Login: town=")).append(i1).append(", boss=").append(j3).append(", jhs=").append(l1.readInt()).toString());
                    mainThread.a(l1);
                    if (j3 > 0)
                        flag1 = true;
                    else
                        flag1 = false;
                    d = flag1;
                    if (d) {
                        MainThread.sendLog("[BOSS]%s, %s", new Object[]{
                                Town.e(j3), Town.e(i1)
                        });
//                        new WorldBoss(C);
//                        c();
//                        mainThread.j(j3);
                    } else {
                        MainThread.sendLog("进入城镇: %s", new Object[]{
                                Town.e(i1)
                        });
                        //mainThread.m();//进入仙界圣域等等
                    }
                    if (j2 >= 60) {
//                        new SignIn(C); //签到
//                        c();
//                        SignIn.a(C);
                        MainThread.sendLog("达到60级");
                    } else {
                        MainThread.sendLog("未开启签到功能(60级)！");
                    }
//                    web.sxd.d.j.a(C);
//                    c();
//                    (new TempDataOutputStream(48, mainThread.d())).sendMain(C);
//                    c();
//                    (new TempDataOutputStream(6)).sendMain(C);
//                    sleep(20);
//                    if (mainThread.b(64)) {
//                        (new web.sxd.b.TempDataOutputStream(42)).sendMain(C);
//                        return;
//                    }
                    //break;
                    return 0;
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
                        if(l1.available()<8){
                            byte[] bytes = new byte[10];
                            //MainThread.sendLog("web.sxd.d.m"+web.sxd.b.HexPrint.Print(bytes));
                            return -1;
                        }
                        l5 = l1.readLong();
                        if (l5 < 0x7fffffffL)
                            j2 = (int) l5;
                        else
                            j2 = 0x7fffffff;
                        switch (j3) {
                            default:
                                i1++;
                                break;
                            case 13:
                                mainThread.setPlayerGrade(j2);//角色等级
                                i1++;
                                break;
                            case 15:
                                if (l5 > 0) mainThread.setCoin(l5);//铜钱
                                i1++;
                                break;
                            case 18:
                                if (mainThread.i() >= j2) //体力和获取的值
                                {
                                    if (mainThread.i() == j2) {
                                        i1++;
                                        break;
                                    }
                                } else {
                                    Log.i(FuncNamePrefix, mainThread.toString());
                                    MainThread.sendLog((new StringBuilder("[流量]")).append(mainThread).toString());
//                                    web.sxd.d.s.a(C);
//                                    t.e();

                                }
                                String s3;
                                if (mainThread.i() > j2)
                                    s3 = "减少为";
                                else
                                    s3 = "增加至";
                                MainThread.sendLog("　体力%s %d", new Object[]{
                                        s3, Integer.valueOf(j2)
                                });
                                mainThread.g(j2);
                                break;
                            case 20:
                                mainThread.setExp(l5); //当前经验
                                i1++;
                                break;
                            case 21:
                                mainThread.setMaxExp(l5);//当前等级经验MAX
                                i1++;
                                break;
                            case 43:
                                i1++;
                                break;
                            case 50:
                                i1++;
                                break;
                            case 56:
                                i1++;
                                break;
                            case 58:
                                //if(j2 > 0)
                                //    mainThread.b(134);
                                i1++;
                                break;
                            case 66:
                                if (l5 <= 0L || e) {
                                    i1++;
                                    break;
                                } else {
                                    int i4;
                                    int ai[];
                                    e = true;
                                    MainThread.sendLog("[提醒]新的俸禄: %d", new Object[]{
                                            Integer.valueOf(j2)
                                    });
//                                    c();
//                                    ai = a;
//                                    i4 = ai.length;
//                                    j3 = 0;
//                                    if(j3<i4) break;
//                                    c.b(a);
//                                    int j4;
//                                    if(mainThread.b(38))  //副本扫荡
//                                    {
//                                        c();
//                                        web.sxd.mainThread.f.a(C);
//                                    } else
//                                    {
//                                        e = false;
//                                    }
                                    break;

                                }
                            case 67: //TODO 不知道对不对
                                if (j2 > 0) {
                                    mainThread.g(-j2);
                                    MainThread.sendLog("额外体力: %d", new Object[]{
                                            Integer.valueOf(j2)
                                    });
                                }
                                break;
                        }
                    }
                    return 0;
                case 6://_L5
                    //int j2;
                    j2 = l1.readUnsignedShort();
                    i1 = 0;
                    while(i1<j2)
                    {
                        j3 = l1.readInt();
                        int k3 = l1.read();
                        //c1 = C;
                        boolean flag;
                        if(k3 == 1)
                            flag = true;
                        else
                            flag = false;
                        mainThread.a(j3, flag);
                        i1++;
                    }
                    j2 = a.length;
                    i1 = 0;
                    while (i1<j2)
                    {
                        j3 = a[i1];
//                        if(!mainThread.b(j3)){}else
//                        {
//                            switch (j3)
//                            {
//                                default:break;
//                                case 33:break;
//                                case 39:
//                                    c();
//                                    if(d)
//                                    {
//                                        WorldBoss.a(C);
//                                    } else
//                                    {
//                                        MainThread.sendLog(5, null);//恢复阵型
//                                        c();
//                                        new WorldBoss(C);
//                                        WorldBoss.a(C, 0L);
//                                    }
//                                    c();
//                                    break;
//                                case 91:
//                                    new x(C);//仙界
//                                    if(!d || !mainThread.b(39))
//                                    {
//                                        c();
//                                        x.a(C);
//                                    }
//                                    break;
//                                case 165:
////                                    neww ae(C);//TODO 暂时注释  圣域
////                                    if(!d || !mainThread.b(39))
////                                    {
////                                        c();
////                                        ae.a(C);//TODO 暂时注释
////                                    }
//                                    break;
//                                case 179:
//                                    //new ah(C);//TODO 暂时注释  全网宠物喂养
//                                    //c();
//                                    //ah.a(C);//TODO 暂时注释
//                                    break;
//                            }
//                        }
                        i1++;
                    }
                    //mainThread.a(a);
                    j2 = a.length;
                    i1 = 0;
                    while(i1<j2)
                    {
                        //int j3;
                        int k3;
                        boolean flag;
                        //c c1;

                        j3 = a[i1];
//                        if(!mainThread.b(j3))
//                        {}else
//                        {
//                            switch (j3)
//                            {
//                                default:break;
//                                case 24:break;
//                                case 38:
////                                    new f(C);
////                                    sleep(3);
////                                    web.sxd.mainThread.f.a(C);
////                                    new Fate(C);
//                                    break;
//                            }
//                        }
                        i1++;
                    }
                    e = false;
                    return 0;
                case 9://_L6
                    j2 = l1.readUnsignedShort();
                    i1 = 0;
                    String s4;
                    if(i1 >= j2) break;
                        //continue; /* Loop/switch isn't completed */
                    while(i1<j2) {
                        s4 = a(l1.readUTF());
                        j3 = l1.readInt();
                        switch (j3) {
                            default://_63
                                Log.i((new StringBuilder("DelayMsg_")).append(j3).toString(), s4);
                                MainThread.sendLog("%s[msg%d]", new Object[]{
                                        s4, Integer.valueOf(j3)
                                });
                                break;
                            case 3:break;//_64
                            case 32:
                                MainThread.sendLog(s4);break;//_65
                            case 45:/*web.sxd.d.e.b(C);*/break;//_66
                            case 47://_67
                                MainThread.sendLog(s4.replace("[replace,7]", "周日 ")
                                        .replace("[replace,", "周")
                                        .replace(']', ' '));
//                                if(mainThread.b(39))
//                                {
//                                    c();
//                                    WorldBoss.a(C, 1L);
//                                }
                                break;
                            case 49:
                                MainThread.sendLog(s4);break;//_65
                            case 149:
//                                if(mainThread.a)
//                                    web.sxd.d.u.a(C);//TODO 暂时注释   仙界取经
//                                else
//                                    web.sxd.d.q.a(C);//TODO 暂时注释   仙界如来上香
                                break;
                        }
                        i1++;
                    }
//                    if(mainThread.b(38))
//                    {
//                        c();
//                        web.sxd.mainThread.f.a(C);
//                    }
                    return 0;
                case 20://_L7
                    if(l1.read() == 87)
                    {
                        MainThread.sendLog("[小助手]领取俸禄：%d 铜钱", new Object[] {
                                Integer.valueOf(l1.readInt())
                        });
                        return 0;
                    }
                    return 0;
                case 35://_L8
                    int l2 = l1.readUnsignedShort();
                    int k1 = 0;
                    while(k1 < l2)
                    {
                        MainThread.sendLog("[公告%d]%s", new Object[] {
                                Integer.valueOf(l1.readInt()), a(l1.readUTF())
                        });
                        k1++;
                    }
                    return 0;
                case 40://_L9
                    switch(l1.read())
                    {
                        case 83: // 'S'
                        default:
                            return 0;

                        case 82: // 'R'
                            int i2 = l1.readInt();
                            int i3 = l1.readInt();
                            if(i2 + i3 != f)
                            {
                                f = i2 + i3;
                                MainThread.sendLog("[打坐]15秒经验%d + %d", new Object[] {
                                        Integer.valueOf(i2), Integer.valueOf(i3)
                                });
                            }
                            if(i3 > 0)
                            {
                                Log.v(FuncNamePrefix, (new StringBuilder("UPDATE_PRACTICE: ")).append(i2).append(" + ").append(i3).toString());
                                return 0;
                            }
                            break;

                        case 84: // 'T'
                            //mainThread.l(); //发送93功能码
                            return 0;
                    }
                    return 0;
                case 41://_L10
                    i1 = l1.readInt();
                    if(i1 > 0)
                    {
                        MainThread.sendLog("[阵营战]冷却中, %d秒后重试", new Object[] {
                                Integer.valueOf(i1)
                        });
                        //sleep(i1 * 5);
                    }
//                    if(mainThread.b(37))
//                    {
//                        if(mainThread.g() >= 40 && mainThread.g() <= 80)
//                        {
//                            //web.sxd.d.l.b(C);//TODO 暂时注释  阵营战
//                            return;
//                        }
//                        if(mainThread.g() > 80)
//                        {
//                            MainThread.sendLog("[阵营战]功能已终结");
//                            return;
//                        }
//                    }
                    return 0;
                case 42://_L11
                    l1.readInt();
                    l1.readInt();
                    l1.readInt();
                    l1.readInt();
                    l1.readInt();
                    l1.readInt();
                    l1.readInt();
                    l1.readInt();
                    l1.readInt();
                    l1.readInt();
                    l1.readInt();
                    l1.readInt();
                    l1.readInt();
                    if(l1.readInt() != 1)
                    {
                        mainThread.setArg("get_player_camp_salary",1); //领取俸禄
                        //c();
                        //(new web.sxd.b.TempDataOutputStream(20)).sendMain(C);
                    }
                    l1.readInt();
                    i1 = l1.readInt();
                    if(i1 > 0)
                        MainThread.sendLog("[小助手]今日还可帮派祭神 %d 次", new Object[] {
                                Integer.valueOf(i1)
                        });
                    i1 = l1.readInt();
                    if(i1 > 0)
                        MainThread.sendLog("[小助手]今日还可竞技场挑战 %d 次", new Object[] {
                                Integer.valueOf(i1)
                        });
                    l1.readInt();
                    i1 = l1.readInt();
                    if(i1 > 0)
                        MainThread.sendLog("[小助手]今日还可护送取经 %d 次", new Object[] {
                                Integer.valueOf(i1)
                        });
                    l1.readInt();
                    i1 = l1.readInt();
                    if(i1 > 0)
                    {
                        MainThread.sendLog("[小助手]今日还可送花 %d 次", new Object[] {
                                Integer.valueOf(i1)
                        });
//                        if(mainThread.b(45))
//                        {
//                            new web.sxd.mainThread.SendFlower(C);
//                            c();
//                            web.sxd.mainThread.SendFlower.a(C);
//                        }
                    }
                    l1.readInt();
                    i1 = l1.readInt();
                    if(i1 > 0)
                        MainThread.sendLog("[小助手]今日还可使用药园仙露 %d 次", new Object[] {
                                Integer.valueOf(i1)
                        });
                    l1.readInt();
                    l1.readInt();
                    l1.readInt();
                    i1 = l1.readInt();
                    if(i1 > 0)
                        MainThread.sendLog("[小助手]今日还可吉星高照投掷 %d 次", new Object[] {
                                Integer.valueOf(i1)
                        });
                    i1 = l1.readInt();
                    if(i1 > 0)
                        MainThread.sendLog("[小助手]今日还可祭拜关公 %d 次", new Object[] {
                                Integer.valueOf(i1)
                        });
                    l1.readInt();
                    i1 = l1.readInt();
                    if(i1 > 0)
                        MainThread.sendLog("[小助手]今日还可摘仙桃 %d 次", new Object[] {
                                Integer.valueOf(i1)
                        });
                    l1.readInt();
                    l1.readInt();
                    l1.readInt();
                    l1.skipBytes(l1.readUnsignedShort() * 16);
                    l1.skipBytes(l1.readUnsignedShort() * 16);
                    return 0;
                case 46://_L12
                    int k2 = l1.readUnsignedShort();
                    int j1 = 0;
                    do
                    {
                        if(j1 >= k2)
                        {
                            mainThread.sendMessage(new TempDataOutputStream(35)
                                    .setMessageTag(MESSAGE_TAG.TAG_MAIN));
                            return 0;
                        }
                        MainThread.sendLog("[公告]%s", new Object[] {
                                l1.readUTF()
                        });
                        j1++;
                    } while(true);
                case 48://_L13
                    if(l1.readUnsignedShort() != 0)
                    {
                        //c c2 = C;
                        i1 = l1.readInt();
                        j2 = l1.readInt();//竞技排名
                        l1.readUTF();
                        //MainThread.sendLog("帮派：%s 测试：%d 竞技排名：%d ",new Object[]{l1.readUTF(),i1,j2});
                        mainThread.a(i1, j2, l1.readInt());//i1 不知道 (应该是自己的ID号)     j2  竞技排名     最后一个战力

                        return 0;
                    }
                    return -1;
            }
        }catch (Exception e)
        {
            Log.v(FuncNamePrefix, e.getLocalizedMessage(), e);
            //Log.d("sxd.web.d.m",e.printStackTrace());
        }
        return 0;
    }

    @Override
    public void SendOpertaion(int funcCode) throws IOException {
        switch (funcCode)
        {
            default:return;
            case 20:
                if(mainThread.getArg("get_player_camp_salary")==null) return;
                mainThread.removArg("get_player_camp_salary");
            case 2:
            case 6:
            case 9:
            case 0x2A://42:
            case 0x2E://46:
                TempDataOutputStream out = new TempDataOutputStream(funcCode);
                out.setMessageTag(MESSAGE_TAG.TAG_MAIN);
                mainThread.sendMessage(out);//.send();
                return ;
//            case 0x23://35
//                if(mainThread.getArg("get_affiche_list")==null) return;
//                mainThread.removArg("get_affiche_list");
//                out = new TempDataOutputStream(funcCode);
//                out.setMessageTag(MESSAGE_TAG.TAG_MAIN);
//                mainThread.send(out);//.send();
//                return ;
            case 0x30://48
                out = new TempDataOutputStream(funcCode,mainThread.getPlayerID());
                out.setMessageTag(MESSAGE_TAG.TAG_MAIN);
                mainThread.sendMessage(out);
                return;
        }
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

    private static final String funcNames[] = {
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

    static {//静态数据初始化
        FuncCodeH = 0;
        FuncNamePrefix = "Player";
        funcList = new HashMap<Integer, String>();
        for (int i=0;i<funcNames.length;i++ ){
            funcList.put(i,funcNames[i]);
        }
    }


    //private n c;
    private boolean d;
    private boolean e;
    private int f;

}
