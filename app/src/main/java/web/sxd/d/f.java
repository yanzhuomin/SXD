// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:46
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;

import web.sxd.b.*;

public final class f extends BaseFunc
{

    public f(MainThread c1)
    {
        super(c1, 0x460000);
        b = 0;
    }

    static void a(MainThread c1) throws Exception
    {
        (new TempDataOutputStream(0x460000)).sendMain(c1);
    }

    public final void a(TempDataInputStream l1)
    {
        try {


            int i;
            super.a(l1);
            i = l1.read();
            switch (l1.getFuncCode()) {
                default:
                    return;
                case 4587520:
                    switch (i) {
                        default:
                            return;

                        case 0: // '\0'
                            if (b == 0) {
                                b = 5;
                                c = 1;
                                c();
                                (new TempDataOutputStream(0x460004)).sendMain(C);
                                c();
                                (new TempDataOutputStream(0x460001)).sendMain(C);
                                return;
                            }
                            break;

                        case 1: // '\001'
                            web.sxd.b.MainThread.sendLog("[帮派]怪物入侵未开始");
                            return;

                        case 2: // '\002'
                            b = 0;
                            web.sxd.b.MainThread.sendLog("[帮派]怪物入侵已结束");
                            // fall through

                        case 3: // '\003'
                            c();
                            (new TempDataOutputStream(0x460007)).sendMain(C);
                            return;
                    }
                    return;
                case 4587521:
                    i = l1.read();
                    int j = l1.readUnsignedShort();
                    b = j;
                    web.sxd.b.MainThread.sendLog("[帮派入侵]剩余 %d只 %d级怪物", new Object[]{
                            Integer.valueOf(j), Integer.valueOf(i)
                    });
                    c();
                    if (j > 0 && i > 0) {
                        (new TempDataOutputStream(0x460002, l1.readInt())).sendMain(C);
                        return;
                    }
                    return;
                case 4587522:
                    switch (i) {
                        default:
                            sleep(50);
                            (new TempDataOutputStream(0x460001)).sendMain(C);
                            return;
                        case 3:
                            web.sxd.b.MainThread.sendLog("[帮派入侵]击杀一只怪物, 等%d分钟", new Object[]{
                                    Integer.valueOf(c)
                            });
                            do {
                                if (b <= 0) {
                                    return;
                                }
                                if (c > 0) {
                                    sleep(c * 60 * 5);
                                    c = c + 1;
                                } else {
                                    c();
                                }
                            } while (b <= 1 && (b <= 0 || c <= 6 && c != 0));
                            (new TempDataOutputStream(0x460001)).sendMain(C);
                            return;
                        case 4:
                            web.sxd.b.MainThread.sendLog("[帮派入侵]怪物已被击杀, 换一只");
                            c();
                            (new TempDataOutputStream(0x460001)).sendMain(C);
                            return;
                        case 6:
                            web.sxd.b.MainThread.sendLog("[帮派入侵]怪物击杀次数已满");
                        case 5:
                            web.sxd.b.MainThread.sendLog("[帮派入侵]击杀冷却中, 10秒后重试");
                            sleep(50);
                            (new TempDataOutputStream(0x460001)).sendMain(C);
                            return;

                    }
                case 4587523:
                    if (i == 4) {
                        b = b - 1;
                        c();
                        web.sxd.b.MainThread.sendLog("[帮派入侵]怪物 %d 被击杀, 剩%d", new Object[]{
                                Integer.valueOf(l1.readInt()), Integer.valueOf(b)
                        });
                        return;
                    }
                    switch (i) {
                        default:
                            return;

                        case 0: // '\0'
                            if (b == 0) {
                                b = 5;
                                c = 1;
                                c();
                                (new TempDataOutputStream(0x460004)).sendMain(C);
                                c();
                                (new TempDataOutputStream(0x460001)).sendMain(C);
                                return;
                            }
                            break;

                        case 1: // '\001'
                            web.sxd.b.MainThread.sendLog("[帮派]怪物入侵未开始");
                            return;

                        case 2: // '\002'
                            b = 0;
                            web.sxd.b.MainThread.sendLog("[帮派]怪物入侵已结束");
                            // fall through

                        case 3: // '\003'
                            c();
                            (new TempDataOutputStream(0x460007)).sendMain(C);
                            return;
                    }
                    return;
                case 4587524:
                    return;
                case 4587525:
                    return;
                case 4587526:
                    return;
                case 4587527:
                    int k;
                    l1.skipBytes(4);
                    k = l1.read();
                    switch (i) {
                        default:
                            break;
                        case 7:
                            web.sxd.b.MainThread.sendLog("[帮派入侵]奖励领取失败: 背包已满");
                            break;
                    }
                    if (k > 0) {
                        web.sxd.b.MainThread.sendLog("[帮派入侵]领取奖励: %d个青龙令", new Object[]{
                                Integer.valueOf(k)
                        });
                        return;
                    }
                    return;
                case 4587528:
                    l1.skipBytes(3);
                    String s1 = l1.readUTF();
                    boolean flag;
                    String s;
                    if (l1.read() == 1)
                        flag = true;
                    else
                        flag = false;
                    l1.readInt();
                    if (flag)
                        s = "\u51FB\u6740";
                    else
                        s = "\u534F\u52A9";
                    web.sxd.b.MainThread.sendLog("[帮派]%s %s领取 青龙令x%d", new Object[]{
                            s1, s, Integer.valueOf(l1.read())
                    });
                    return;
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.d.f",e.getLocalizedMessage(),e);
        }

    }

    protected final String[] a()
    {
        return a;
    }

    private static final String a[] = {
        "FactionMonster_", "get_status", "get_monster_info", "start_fight", "notify", "join", "get_win_player_list", "is_can_get_award", "get_award", "notify_get_award"
    };
    private int b;
    private int c;

}