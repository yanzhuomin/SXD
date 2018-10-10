// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:46
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;

import web.sxd.b.BaseFunc;
import web.sxd.b.MainThread;
import web.sxd.b.TempDataInputStream;
import web.sxd.b.TempDataOutputStream;

// Referenced classes of package web.sxd.d:
//            c, y, x

//Boss
public final class WorldBoss extends BaseFunc
{

    WorldBoss(MainThread c1)
    {
        super(c1, 0x180000);
        c = new web.sxd.d.c[12];
        e = 100;
        f = 0;
        g = -1L;
        int i = 1;
        do
        {
            if(i >= 12)
                return;
            c[i] = new web.sxd.d.c(c1, i);
            i++;
        } while(true);
    }

    static void a(MainThread c1) throws Exception
    {
        if(web.sxd.b.MainThread.isFuncSelect(3))
        {
            y.a(c1);
            a(5);
        }
        h = false;
        (new TempDataOutputStream(0x180001)).sendMain(c1);
    }

    static void a(MainThread c1, long l1) throws Exception
    {
        (new TempDataOutputStream(0x180000, l1)).sendMain(c1);
    }

    private boolean a(web.sxd.d.c c1, int i) throws Exception
    {
        int j;
        boolean flag;
            flag = false;
            if(i >= 0)
            {
                j = i;
                if(i >= 5)
                    j = 5;
            }else {
                j = 5;
            }
        web.sxd.b.MainThread.sendLog("[BOSS]%s %s", new Object[] {
            c1.a(), b[j]
        });
        if(j == 1 || j == 4)
        {
            web.sxd.b.MainThread.sendLog("[BOSS]进入 BOSS 场景");
            C.j(c1.a);
            c();
            a(C);
            flag = true;
        }
        return flag;
    }

    private void e() throws Exception
    {
        if(!h)
        {
            h = true;
            web.sxd.b.MainThread.sendLog(5, null);
            //TODO 暂时注释
            if(!x.a(C) && !web.sxd.a.ad.a(C))
                C.m();
        }
    }

    public final void a(TempDataInputStream l1)
    {
        try {
            int i = l1.getFuncCode();
            if (i != 0x18000e && i != 0x18000d)
                super.a(l1);
            switch (l1.getFuncCode()) {
                default:
                    return;
                case 1572864:
                    int k4 = l1.readUnsignedShort();
                    int i1 = 0;
                    do {
                        if (i1 >= k4)
                            continue; /* Loop/switch isn't completed */
                        web.sxd.d.c c2 = c[l1.read()];
                        c2.a = l1.read();
                        c2.b = l1.readInt();
                        int l2 = l1.read();
                        l1.read();
                        int i5 = l1.readInt();
                        l1.readInt();
                        c2.a(i5, l1.read());
                        if (l1.read() == 1)
                            l2 = 6;
                        if (a(c2, l2))
                            continue; /* Loop/switch isn't completed */
                        l1.skipBytes(8);
                        i1++;
                    } while (true);
                case 1572865:
                    d = false;
                    web.sxd.d.c ac1[] = c;
                    int j1 = l1.read();
                    web.sxd.d.c c3 = ac1[j1];
                    (new TempDataOutputStream(0x180004, j1)).sendMain(C);
                    l1.readInt();
                    int i3 = l1.read();
                    c3.a = l1.readInt();
                    l1.skipBytes(12);
                    c3.b = l1.readInt();
                    long l6 = l1.readLong();
                    if(l6 > 10000L)
                        j1 = (int)(l6 / 10000L);
                    else
                        j1 = 1;
                    c3.c = j1;
                    c3.d = l1.a();
                    if(c3.d <= 0)
                        c3.d = 10000;
                    c3.b();
                    if(i3 == 1)
                    {
                        c3.c();
                        return;
                    }
                    return;
                case 1572866:
                    int i2 = l1.read();
                    switch(l1.read())
                    {
                        default:
                            C.j(c[i2].a);
                            return;

                        case 0: // '\0'
                            d = true;
                            return;

                        case 1: // '\001'
                            Log.d(b(), "fight_world_boss FAILED");
                            web.sxd.b.MainThread.sendLog("[BOSS]复活时间还未结束");
                            return;

                        case 2: // '\002'
                            web.sxd.b.MainThread.sendLog("[BOSS]挑战还没开始");
                            return;

                        case 3: // '\003'
                            web.sxd.b.MainThread.sendLog("[BOSS]挑战已结束");
                            return;

                        case 4: // '\004'
                            web.sxd.b.MainThread.sendLog("[BOSS]已被击杀");
                            return;

                        case 5: // '\005'
                            web.sxd.b.MainThread.sendLog("[BOSS]冷却时间未结束");
                            break;
                    }
                    return;
                case 1572867:return;
                case 1572868:
                    web.sxd.d.c ac[] = c;
                    int j = l1.read();
                    web.sxd.d.c c1 = ac[j];
                    int i4 = l1.readUnsignedShort();
                    if(i4 <= 0 || g == 0L && c1.c == 0)
                    {
                        e = 100;
                        return;
                    }
                    int l4 = l1.readInt();
                    l1.readUTF();
                    long l5 = l1.readLong();
                    int k2;
                    if(g < 0L)
                        k2 = 0;
                    else
                        k2 = (int)((l5 - g) / 1000L);
                    g = l5;
                    if(k2 > 0 && c1.c > 1)
                    {
                        web.sxd.b.MainThread.sendLog("[BOSS]　本次伤害: %d.%dw 剩 %d%%", new Object[] {
                                Integer.valueOf(k2 / 10), Integer.valueOf(k2 % 10), Integer.valueOf((c1.c * 100) / c1.d)
                        });
                        if(web.sxd.b.MainThread.isFuncSelect(3) && j < 3 && (k2 < 290 || C.g() >= 100 && k2 < 590))
                            (new TempDataOutputStream(0x180007, 0L)).sendMain(C);
                    }
                    f = 0;
                    j = 1;
                    do
                    {
                        if(j >= i4)
                        {
                            if(f == 0)
                            {
                                Log.i(b(), (new StringBuilder(String.valueOf(k2 / 10000))).append("w selfHurt: ").append(g).toString());
                                web.sxd.b.MainThread.sendLog("我的伤害: %dw", new Object[] {
                                        Long.valueOf(g / 10000L)
                                });
                            }
                            Log.v(b(), C.toString());
                            if(c1.c == 0)
                            {
                                g = 0L;
                                return;
                            }
                            break;
                        }
                        int j5 = l1.readInt();
                        String s = l1.readUTF();
                        long l8 = l1.readLong();
                        String s2 = (new StringBuilder(String.valueOf(j5))).append(": ").append(s).append(", ").append(l8 / 10000L).append("w").toString();
                        if(c1.c == 0)
                            web.sxd.b.MainThread.sendLog("第%d名\t%dw\t%s", new Object[] {
                                    Integer.valueOf(j), Long.valueOf(l8 / 10000L), s
                            });
                        if(j5 != l4)
                        {
                            Log.d(b(), s2);
                            l5 += l8;
                        } else
                        {
                            Log.i(b(), String.format("%s / %d.%dw", new Object[] {
                                    s2, Integer.valueOf(k2 / 10), Integer.valueOf(k2 % 10)
                            }));
                            f = j;
                        }
                        j++;
                    } while(true);
                    if(c1.d > 0)
                    {
                        int j4 = c1.d;
                        int k;
                        if(c1.c > 1)
                        {
                            e = j4 - c1.c - 1;
                            if(e <= 0)
                                k = 100;
                            else
                                k = (int)(l5 / (long)e / 100L);
                            e = k;
                            if(e <= 0 || e > 100)
                                e = 100;
                            k = (int)((long)j4 - l5 / 10000L);
                        } else
                        {
                            k = (int)((long)j4 - l5 / (long)e / 100L);
                        }
                        Log.i(b(), (new StringBuilder(String.valueOf(e))).append("% rankLife: ").append(k).toString());
                        j4 = k;
                        if(k < 0)
                            j4 = 1;
                        k = c1.d;
                        String str;
                        if(f > 0)
                            str = (new StringBuilder(" 排名: ")).append(f).toString();
                        else
                            str = "";
                        web.sxd.b.MainThread.sendLog(3, j4, k, l1);
                        if(c1.c == 1 && c1.e > j4)
                        {
                            if(k2 > 0)
                                web.sxd.b.MainThread.sendLog("[BOSS]　我的伤害: %d.%dw 剩 %d%%", new Object[] {
                                        Integer.valueOf(k2 / 10), Integer.valueOf(k2 % 10), Integer.valueOf(j4 / (c1.d / 100))
                                });
                            else
                                web.sxd.b.MainThread.sendLog("[BOSS]　受到伤害: %dw 剩 %d%%", new Object[] {
                                        Integer.valueOf(c1.e - j4), Integer.valueOf(j4 / (c1.d / 100))
                                });
                            c1.e = j4;
                        }
                        if(c1.c > 1)
                        {
                            c1.e = c1.c;
                            return;
                        }
                    }
                    break;

                case 1572869:
                case 1572870:return;
                case 1572871:
                    l1.read();
                    l1.read();
                    int k1 = l1.read();
                    switch(k1)
                    {
                        default:
                            web.sxd.b.MainThread.sendLog("[BOSS]鼓舞错误: %d", new Object[] {
                                    Integer.valueOf(k1)
                            });
                            return;

                        case 0: // '\0'
                            Log.i(b(), "strengthen_combat SUCCESS");
                            return;

                        case 1: // '\001'
                            Log.d(b(), "strengthen_combat FAILED");
                            if(!web.sxd.b.MainThread.isFuncSelect(3))
                                web.sxd.b.MainThread.sendLog("[BOSS]鼓舞失败");
                            if(!web.sxd.b.MainThread.isFuncSelect(4))
                            {
                                (new TempDataOutputStream(0x180007, 0L)).sendMain(C);
                                return;
                            }
                            break;

                        case 8: // '\b'
                            web.sxd.b.MainThread.sendLog("[BOSS]鼓舞阅历不足");
                            return;

                        case 9: // '\t'
                            Log.d(b(), "strengthen_combat COMBAT_LIMIT");
                            return;
                    }
                    break;

                case 1572872:return;
                case 1572873:

                    web.sxd.d.c c4;
                    String s1;
                    c4 = c[l1.read()];
                    s1 = l1.readUTF();
                    k1 = l1.read();
                    switch (k1)
                    {
                        default:
                            Log.i(b(), (new StringBuilder("open_world_boss: ")).append(s1).append(", ").append(k1).toString());
                            a(c4, k1);
                            return;
                        case 0:
                            k1 = 4;
                            break;
                        case 1:
                            g = 0L;
                            web.sxd.b.MainThread.sendLog("世界BOSS %s 挑战开始", new Object[] {
                                    s1
                            });
                            Log.i(b(), (new StringBuilder("open_world_boss: ")).append(s1).append(", ").append(k1).toString());
                            a(c4, k1);
                            return;
                    }

                case 1572874:
                    web.sxd.b.MainThread.sendLog(1, "[BOSS]世界BOSS 已结束");
                    e();
                    return;
                case 1572875:
                    sleep(3);
                    web.sxd.b.MainThread.sendLog(1, "[BOSS]世界BOSS 被成功击杀");
                    e();
                    return;
                case 1572876:
                    long l7;
                    k1 = l1.read();
                    c4 = c[k1];
                    l7 = l1.readLong();
                    if(l7 <= 0L)
                    {
                        c4.c = 0;
                        web.sxd.b.MainThread.sendLog(1, null);
                        if(d)
                        {
                            d = false;
                            (new TempDataOutputStream(0x180004, k1)).sendMain(C);
                        }
                        e();
                        return;
                    }
                    if(l7 >= 10000L) {
                        l7 /= 10000L;
                        int k3 = c4.c;
                        c4.c = (int)l7;
                        c();
                        if(!d)
                        {
                            if((long)k3 >= l7 && c4.c > 1)
                            {
                                web.sxd.b.MainThread.sendLog(c4.c, c4.d);
                                if(l1.readInt() > 2)
                                {
                                    (new TempDataOutputStream(0x180004, k1)).sendMain(C);
                                    return;
                                }
                            }
                        } else
                        {
                            if((long)k3 >= l7 && c4.c > 1)
                            {
                                web.sxd.b.MainThread.sendLog(c4.c, c4.d);
                                (new TempDataOutputStream(0x180004, k1)).sendMain(C);
                            } else
                            {
                                web.sxd.b.MainThread.sendLog("[BOSS]当前血量: %dw, %d", new Object[] {
                                        Long.valueOf(l7), Integer.valueOf(l1.readInt())
                                });
                            }
                            C.l();
                            d = false;
                            return;
                        }
                        break; /* Loop/switch isn't completed */
                    }
                    if(c4.c > 1)
                    {
                        c4.e = c4.c;
                        c4.c = 1;
                    }
                    (new TempDataOutputStream(0x180004, k1)).sendMain(C);
                    if(d)
                    {
                        d = false;
                        C.l();
                        return;
                    }
                    return;
                case 1572877:
                    int j2 = l1.read();
                    if(l1.readInt() == C.d())
                    {
                        int l3 = l1.readInt();
                        if(l3 == 0)
                        {
                            c[j2].c();
                            return;
                        } else
                        {
                            Log.d(b(), (new StringBuilder("player_death_cd: ")).append(l3).toString());
                            web.sxd.b.MainThread.sendLog("[BOSS]%d 秒后再战, 挑战成功", new Object[] {
                                    Integer.valueOf(l3)
                            });
                            return;
                        }
                    }
                    return;

                case 1572878:return;
                case 1572879:
                    k1 = l1.read();
                    int j3 = l1.read();
                    if(k1 == 3)
                    {
                        web.sxd.b.MainThread.sendLog("[BOSS]帮派BOSS, 不鼓舞+%d%%", new Object[] {
                                Integer.valueOf(j3)
                        });
                        return;
                    }
                    if(web.sxd.b.MainThread.isFuncSelect(4))
                    {
                        web.sxd.b.MainThread.sendLog("[BOSS]世界BOSS, 不鼓舞+%d%%", new Object[] {
                                Integer.valueOf(j3)
                        });
                        return;
                    }
                    web.sxd.b.MainThread.sendLog("[BOSS]鼓舞+%d%%, 可浴火 %d 次", new Object[] {
                            Integer.valueOf(j3), Integer.valueOf(l1.read())
                    });
                    if(j3 < 100)
                    {
                        (new TempDataOutputStream(0x180007, 0L)).sendMain(C);
                        return;
                    }

                case 1572880:return;
                case 1572881:return;
                case 1572882:
                    c[l1.read()].c = 1;
                    web.sxd.b.MainThread.sendLog(2, "世界BOSS 已重伤, 大家冲啊");
                    return;

            }
        }catch (Exception e)
        {
            Log.v("web.sxd.d.ad",e.getLocalizedMessage(),e);
        }
    }

    protected final String[] a()
    {
        return a;
    }

    private static final String a[] = {
        "WorldBoss_", "get_world_boss_list", "get_world_boss_data", "fight_world_boss", "", "get_defeat_record_list", "", "", "strengthen_combat", "", 
        "open_world_boss", "close_world_boss", "defeat_world_boss", "hurt_world_boss", "player_death_cd", "update_world_boss_position", "player_world_boss_buff", "faction_boss_time_list", "", "world_boss_low_health", 
        ""
    };
    private static final String b[] = {
        "未开始", "开始了", "已结束", "已击杀", "准备中", "本周已满", "替身娃娃"
    };
    private static boolean h = true;
    private web.sxd.d.c c[];
    private boolean d;
    private int e;
    private int f;
    private long g;

}