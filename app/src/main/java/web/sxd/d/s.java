// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:47
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;
import web.sxd.b.*;

// Referenced classes of package web.sxd.d:
//            n

public final class s extends BaseFunc
{

    public s(MainThread c1)
    {
        super(c1, 0x750000);
        d = 0;
    }

    public static void a(MainThread c1) throws Exception
    {
        if(c1.b(91) && c1.b(94))
            (new TempDataOutputStream(0x750000)).sendMain(c1);
    }

    public final void a(TempDataInputStream l1)
    {
        try {
            int i;
            i = l1.getFuncCode();
            super.a(l1);
            switch (i) {
                default:
                    return;
                case 7667712:
                    int k;
                    StringBuilder stringbuilder;
                    d = -1;
                    stringbuilder = new StringBuilder("Rooms: ");
                    k = l1.readUnsignedShort();
                    i = 0;
                    while (i < k) {
                        int j1 = l1.read();
                        int i2 = l1.readUnsignedShort();
                        stringbuilder.append((new StringBuilder(String.valueOf(j1))).append("星x").append(i2).append(", ").toString());
                        if (j1 > d && j1 > 0 && j1 < b.length && i2 < b[j1 - 1])
                            d = j1;
                        i++;
                    }
                    i = l1.read();
                    c = l1.read();
                    if (c > b.length)
                        c = 0;
                    stringbuilder.append((new StringBuilder(String.valueOf(i))).append(": ").append(c).toString());
                    Log.i(b(), stringbuilder.toString());
                    if (c == 0)
                        web.sxd.b.MainThread.sendLog("[仙界]当前处于普通练功场");
                    c();
                    (new TempDataOutputStream(0x750006)).sendXJ(C);
                    if (d > c) {
                        web.sxd.b.MainThread.sendLog("[仙界]%d星练功房还有空位", new Object[]{
                                Integer.valueOf(d)
                        });
                        c();
                        (new TempDataOutputStream(0x750001, (byte) d)).sendXJ(C);
                        return;
                    }
                    return;
                case 7667713:
                    int j = l1.readUnsignedShort();
                    boolean aflag[] = new boolean[12];
                    i = 0;
                    while (i < 12) {
                        aflag[i] = true;
                        i++;
                    }
                    i = 0;
                    do {
                        if (i >= j) {
                            Log.i(b(), (new StringBuilder(String.valueOf(l1.readInt()))).append("s ").append(l1.readInt()).append("exp rob").append(l1.readUnsignedShort()).append("s ").append(l1.read()).append("\u661F").toString());
                            i = 0;
                            do {
                                int i1;
                                int k1;
                                int j2;
                                int k2;
                                int l2;
                                int i3;
                                String s1;
                                if (i >= b[d - 1])
                                    if (d > c && d > 1) {
                                        d = d - 1;
                                        c();
                                        (new TempDataOutputStream(0x750001, (byte) d)).sendXJ(C);
                                        return;
                                    } else {
                                        web.sxd.b.MainThread.sendLog("[仙界]练功房没有%d星以上空位了", new Object[]{
                                                Integer.valueOf(d)
                                        });
                                        return;
                                    }
                                if (aflag[i]) {
                                    web.sxd.b.MainThread.sendLog("[仙界]练功房有空位: %d星, %d", new Object[]{
                                            Integer.valueOf(d), Integer.valueOf(i)
                                    });
                                    if (c > 0) {
                                        (new TempDataOutputStream(0x75000d)).sendXJ(C);
                                        c();
                                    }
                                    (new TempDataOutputStream(0x750002, (byte) d, (byte) i)).sendXJ(C);
                                    return;
                                }
                                i++;
                            } while (true);
                        }
                        int i1 = l1.read();
                        int k1 = l1.readInt();
                        if (k1 > 0)
                            aflag[i1] = false;
                        int j2 = l1.readInt();
                        int k2 = l1.readInt();
                        String s1 = (new StringBuilder(String.valueOf(web.sxd.d.n.c(j2)))).append(" ").append(l1.readUTF()).append(n.a(C, l1)).toString();
                        int l2 = l1.readInt();
                        int i3 = l1.readInt();
                        l1.read();
                        Log.i(b(), String.format("%d: %d Lv.%d,%d %s r%d,e%d,", new Object[]{
                                Integer.valueOf(i1), Integer.valueOf(k1), Integer.valueOf(i3), Integer.valueOf(l2), s1, Integer.valueOf(j2), Integer.valueOf(k2)
                        }));
                        i++;
                    } while (true);
                case 7667714:
                    switch (l1.read()) {
                        default:
                            return;

                        case 4: // '\004'
                            web.sxd.b.MainThread.sendLog("[仙界]练功房成功入座");
                            return;

                        case 5: // '\005'
                            web.sxd.b.MainThread.sendLog("[仙界]练功房入座房间错误");
                            return;

                        case 6: // '\006'
                            web.sxd.b.MainThread.sendLog("[仙界]练功房位置上已经有人");
                            return;

                        case 7: // '\007'
                            web.sxd.b.MainThread.sendLog("[仙界]练功经验未领取,不能入座");
                            return;

                        case 8: // '\b'
                            web.sxd.b.MainThread.sendLog("[仙界]练功房功能未开放");
                            return;

                        case 9: // '\t'
                            web.sxd.b.MainThread.sendLog("[仙界]练功房已入座,不能争夺");
                            break;
                    }
                    (new TempDataOutputStream(0x75000d)).sendXJ(C);
                    return;
                case 7667715:
                case 7667716:
                case 7667717:
                    return;
                case 7667718:
                    i = l1.read();
                    c();
                    if (i == 4) {
                        c();
                        web.sxd.b.MainThread.sendLog("[仙界]%d星练功经验%d, %d级%d%%", new Object[]{
                                Integer.valueOf(c), Integer.valueOf(l1.readInt()), Integer.valueOf(C.g()), Integer.valueOf(C.h())
                        });
                        return;
                    } else {
                        c = 0;
                        d = 5;
                        (new TempDataOutputStream(0x750001, (byte) d)).sendXJ(C);
                        return;
                    }
                case 7667719:
                case 7667720:
                case 7667721:
                case 7667722:
                case 7667723:
                    return;
                case 7667724:
                    if ((i = l1.readInt()) > 0) {
                        Log.v(b(), (new StringBuilder("notify_refresh_exp: ")).append(i).toString());
                        c();
                        (new TempDataOutputStream(0x750006)).sendXJ(C);
                        return;
                    }
                    return;
                case 7667725:
                    web.sxd.b.MainThread.sendLog("[仙界]练功房已离开座位");
                    (new TempDataOutputStream(0x750006)).sendXJ(C);
                    return;
                case 7667726:
                    return;
                case 7667727:
                    i = l1.read();
                    switch (i) {
                        default:
                            web.sxd.b.MainThread.sendLog("[仙界]练功房消息: %d", new Object[]{
                                    Integer.valueOf(i)
                            });
                            break;
                        case 19:
                            web.sxd.b.MainThread.sendLog("[仙界]练功房消息: 时间到");
                            c();
                            (new TempDataOutputStream(0x750006)).sendXJ(C);
                            break;
                        case 20:
                            web.sxd.b.MainThread.sendLog("[仙界]练功房消息: 被抢夺");
                            c();
                            (new TempDataOutputStream(0x750006)).sendXJ(C);
                    }
                    sleep(5);
                    a(C);
                    return;
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.d.s",e.getLocalizedMessage(),e);
        }
    }

    protected final String[] a()
    {
        return a;
    }

    private static final String a[] = {
        "StPracticeRoom_", "get_rooms", "get_room_info", "sit_down", "get_seat_info", "", "", "get_room_practice_exp", "get_exp_flag", "enter_room", 
        "exit_room", "", "", "notify_refresh_exp", "player_leave_seat", "get_player_room_quality", "notify_practice_room_msg", "", ""
    };
    private static final int b[] = {
        6, 7, 8, 10, 12, 18
    };
    private int c;
    private int d;

}