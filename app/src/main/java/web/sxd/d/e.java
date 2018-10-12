// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:46
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;

import web.sxd.a.s;
import web.sxd.b.*;

// Referenced classes of package web.sxd.d:
//            f, ad

//帮派
public final class e extends BaseFunc
{

    public e(MainThread c1)
    {
        super(c1, 0xa0012);
        c1.a(new f(c1));//帮派怪物
    }

    static void a(MainThread c1)throws Exception
    {
        (new TempDataOutputStream(0xa0012)).sendMain(c1);
    }

    static void b(MainThread c1) throws Exception
    {
        (new TempDataOutputStream(0xa0032)).sendMain(c1);
    }

    public final void a(TempDataInputStream l1)
    {
        try {


            int i;
            int k;
            int i1;
            int j1;
            k = 0;
            i = 0;
            j1 = l1.getFuncCode();
            if (j1 != 0xa0020)
                super.a(l1);
            i1 = l1.read();
            switch (j1) {
                default:
                    return;
                case 655378://0xA0012
                    if (i1 == 0 && l1.read() == 0) {
                        web.sxd.b.MainThread.sendLog("[帮派]没有加入帮派");
                        C.a(13, false);
                        return;
                    }
                    c();
                    l1.readInt();
                    String s1 = l1.readUTF();
                    l1.readInt();
                    l1.readUTF();
                    a = l1.readUnsignedShort();
                    i = l1.readUnsignedShort();
                    web.sxd.b.MainThread.sendLog("[帮派]%s(Lv.%d) %d/%d", new Object[]{
                            s1, Integer.valueOf(a), Integer.valueOf(l1.readUnsignedShort()), Integer.valueOf(i)
                    });
                    if (a > 5)
                        a = 5;
                    switch (a) {

                        case 5:
                            (new TempDataOutputStream(0xa002c)).sendMain(C);
                        case 4:
                            if (C.b(39)) {
                                c();
                                WorldBoss.a(C, 1L);//刀疤兔
                            }
                            sleep(2);
                            f.a(C);//帮派怪物
                        case 3:
                            sleep(2);
                            (new TempDataOutputStream(0xa001c)).sendMain(C);
                        case 2:
                            sleep(2);
                            (new TempDataOutputStream(0xa0032)).sendMain(C);
                        case 1:
                            sleep(2);
                            (new TempDataOutputStream(0xa0017, 1)).sendMain(C);
                        default:
                            if (C.b(8)) {
                                new s(C);
                                c();
                                s.a(C);
                                return;
                            }
                            break;
                    }
                    break;
                case 655383:
                    if (i1 == 32) {
                        web.sxd.b.MainThread.sendLog("[帮派]上香成功");
                    } else {
                        c();
                        (new TempDataOutputStream(0xa0018)).sendMain(C);
                    }
                    c();
                    return;
                case 655384:
                    l1.read();
                    i = l1.readUnsignedShort();
                    if (i > 0)
                        web.sxd.b.MainThread.sendLog("[帮派]祝福 %d 次铜钱+%d%%", new Object[]{
                                Integer.valueOf(i), Integer.valueOf(l1.readInt())
                        });
                    C.i(i);
                    return;
                case 655385:
                    if (i1 == 38) {
                        i = l1.readInt();
                        web.sxd.b.MainThread.sendLog("[帮派]剩余 %d 次铜钱祝福", new Object[]{
                                Integer.valueOf(i)
                        });
                        C.i(i);
                        return;
                    }
                    break;
                case 655388://0xA001C
                    StringBuilder sb = new StringBuilder("[帮派]七星封魔加入");
                    switch (i1) {
                        default:
                            sb.append("失败: ");
                            sb.append(i1);
                            web.sxd.b.MainThread.sendLog(sb.toString());
                            return;

                        case 55: // '7'
                        case 54: // '6'
                            sb.append("成功");
                            web.sxd.b.MainThread.sendLog(sb.toString());
                            return;

                        case 56: // '8'
                        case 57: // '9'
                            sb.append("失败: 重试");
                            break; /* Loop/switch isn't completed */
                    }
                    web.sxd.b.MainThread.sendLog(sb+""+i1);
                    return;
                case 655399://0xA0027
                    if (i1 == 32) {
                        web.sxd.b.MainThread.sendLog("[帮派]仙宴参加成功");
                        return;
                    }
                    break;
                case 655400:
                    l1.readInt();
                    return;
                case 655401:
                    return;
                case 655404:
                    if (i1 > 0) {
                        web.sxd.b.MainThread.sendLog("[帮派]吉星高照剩余 %d 次", new Object[]{
                                Integer.valueOf(i1)
                        });
                        int j = k;
                        while (j < i1) {
                            c();
                            (new TempDataOutputStream(0xa002e)).sendMain(C);
                            j++;
                        }
                    }
                    return;
                case 655406:
                    if (i1 == 32) {
                        web.sxd.b.MainThread.sendLog("[帮派]吉星: %s, 分数+%d=>%d", new Object[]{
                                c[l1.read()], Integer.valueOf(l1.readInt()), Integer.valueOf(l1.readInt())
                        });
                        return;
                    }
                    return;
                case 655410://0xA0032
                    if (i1 != 32)
                        break; /* Loop/switch isn't completed */
                    l1.readInt();
                    l1.readInt();
                    l1.readInt();
                    l1.readUnsignedShort();
                    l1.readUnsignedShort();
                    k = l1.readUnsignedShort();
                    do {
                        if (i >= k) {
                            if (l1.read() > 0) {
                                (new TempDataOutputStream(0xa0034)).sendMain(C);
                                return;
                            }
                            continue; /* Loop/switch isn't completed */
                        }
                        l1.read();
                        l1.readUTF();
                        l1.readInt();
                        l1.read();
                        i++;
                    } while (true);
                case 655412://0xa0034
                    if (i1 == 32) {
                        l1.read();
                        l1.read();
                        l1.readInt();
                        (new TempDataOutputStream(0xa0035)).sendMain(C);
                        return;
                    }
                    break;
                case 655413://0xa0035
                    if (i1 == 32) {
                        web.sxd.b.MainThread.sendLog("[帮派]新仙宴参加成功");
                        return;
                    }
                    break;
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.d.e",e.getLocalizedMessage(),e);
        }
    }

    protected final String[] a()
    {
        return b;
    }

    private static final String b[] = {
        "FACTION_", "", "found_faction", "disband_faction", "faction_request", "cancel_request", "accept_request", "deny_request", "appoint_job", "dismiss_job", 
        "kickout_member", "master_transfer", "faction_list", "request_list", "member_list", "modify_faction_desc", "modify_faction_notice", "quit_faction", "quit_job", "my_faction_info", 
        "found_faction_coin", "modify_group_number", "faction_contribution_list", "faction_god_info", "incense", "get_blessing_count", "blessing_count_change", "faction_message_notify", "clean_faction_request", "join_seal_satan", 
        "seal_satan_call_npc", "seal_satan_join_notify", "seal_satan_call_faction_member", "seal_satan_info", "seal_satan_award_notify", "seal_satan_member_list", "close_seal_satan", "call_eat_info", "call_eat", "call_eat_detailed_info", 
        "join_eat", "get_faction_level", "is_can_join_activity", "get_faction_master_trace", "seize_the_throne", "faction_roll_cake_remain_times", "faction_roll_cake_info", "roll_cake", "", "receive_call_join_faction", 
        "invite_info", "open_feast_panel", "activeness_quicken", "get_feast_info", "join_feast", "notify_feast_status_change"
    };
    private static final String c[] = {
            "无", "平安", "一吉", "二吉", "大运", "三吉", "福禄寿", "大吉大利", "五子登科", "吉祥如意",
            "洪福齐天", "吉星高照", "大吉大利", "寿比南山", "财源滚滚", "平步青云", "万事如意", "招财进宝"
    };
    int a;

}