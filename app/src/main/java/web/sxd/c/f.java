// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:45
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.c;

import android.util.Log;
import web.sxd.b.*;

// Referenced classes of package web.sxd.c:
//            d, i, b

/*
* 普通副本
* */
public final class f extends BaseFunc
{

    public f(MainThread c1)
    {
        super(c1, 0x190001);
        c1.addFunc(4, a, this);
        d = c1.b(24);
        boolean flag = c1.b(51);
        c = flag;
        if(flag)
            new HeroMission(c1);
    }

    public static void a(MainThread c1) throws Exception
    {
        (new TempDataOutputStream(0x190005)).sendMain(c1);
    }

    private static void a(MainThread c1, int j) throws Exception
    {
        c();
        (new TempDataOutputStream(0x40000, j)).sendMain(c1);
    }

    public final void a(TempDataInputStream l1)
    {
        try {


            int j;
            int k;
            boolean flag1;
            j = 0;
            flag1 = false;
            k = l1.getFuncCode();
            if (l1.getFuncCodeH() != 4) {
                if (k != 0x190004)
                    super.a(l1);
            }

            Log.d(b(), printFuncName(l1.getFuncCodeL(), a));
            switch (k) {
                default:
                    return;
                case 262144:
                    int j2 = l1.readUnsignedShort();
                    int k1 = 0;
                    j = 0;
                    int i1 = 0;
                    int j1 = 0;
                    do {
                        int i2;
                        if (k1 >= j2)
                            if (i1 > 0) {
                                web.sxd.b.MainThread.sendLog("　最高普通本: [%d]%s%d", new Object[]{
                                        Integer.valueOf(i1), Town.d(Town.a[e]), Integer.valueOf(j1)
                                });
                                sleep(3);
                                f = C.j();
                                j1 = ((flag1) ? 1 : 0);
                                if (Town.a[e] < 14)
                                    j1 = 1;
                                if (f > 10 && j1 == 0)
                                    f = 10;
                                if (j > 5 && e > 0)
                                    e = e - 1;
                                boolean flag;
                                int k2;
                                if (f > 0 && (C.i() > 80 && h < 20 || j1 != 0)) {
                                    TempDataOutputStream out = new TempDataOutputStream(0x190001, i1);
                                    out.writeShort(f * 5);
                                    out.write(1);
                                    out.sendMain(C);
                                    return;
                                }
                                if (c) {
                                    c();
                                    HeroMission.a(C, e);
                                    return;
                                }
                                if (d) {
                                    c();
                                    web.sxd.c.Fate.a(C);
                                    return;
                                }
                                continue; /* Loop/switch isn't completed */
                            } else {
                                if (j2 == 0) {
                                    j = g + 1;
                                    g = j;
                                    if (j < Town.a.length) {
                                        a(C, Town.a[g]);
                                        return;
                                    }
                                }
                                continue; /* Loop/switch isn't completed */
                            }
                        i2 = l1.readInt();
                        int k2 = l1.read();
                        l1.read();
                        boolean flag;
                        if (l1.read() == 1)
                            flag = true;
                        else
                            flag = false;
                        l1.skipBytes(2);
                        l1.skipBytes(1);
                        if (k2 == 1 && !flag) {
                            j1 = k1 + 1;
                            e = g;
                            int ai[];
                            if (e < 8) {
                                e = 8;
                                i1 = i2;
                            } else {
                                i1 = i2;
                            }
                        } else if (flag)
                            j++;
                        k1++;
                    } while (true);
                case 1638401:
                    j = l1.read();
                    switch (j) {
                        default:
                            web.sxd.b.MainThread.sendLog("副本扫荡失败: 错误代码 %d", new Object[]{
                                    Integer.valueOf(j)
                            });
                            return;

                        case 0: // '\0'
                            web.sxd.b.MainThread.sendLog("开始扫荡副本 %d 次", new Object[]{
                                    Integer.valueOf(f)
                            });
                            //l1 = C;
                            //web.sxd.b.c.k();
                            return;

                        case 1: // '\001'
                            web.sxd.b.MainThread.sendLog("副本扫荡失败: 体力不足");
                            if (d) {
                                c();
                                web.sxd.c.Fate.a(C);
                                return;
                            }
                            break;

                        case 2: // '\002'
                            web.sxd.b.MainThread.sendLog("副本扫荡失败: 背包已满");
                            return;
                    }
                    break;
                case 1638404:
                    j = l1.read();
                    switch (j) {
                        case 3: // '\003'
                        case 4: // '\004'
                        default:
                            Log.i(b(), (new StringBuilder("notify_error: ")).append(j).toString());
                            return;

                        case 5: // '\005'
                            break;

                        case 1: // '\001'
                            web.sxd.b.MainThread.sendLog("副本扫荡失败: 体力不足");
                            if (d) {
                                c();
                                web.sxd.c.Fate.a(C);
                                return;
                            }
                            break;

                        case 2: // '\002'
                            web.sxd.b.MainThread.sendLog("副本扫荡失败: 背包已满");
                            sleep(2);
                            if (c) {
                                HeroMission.a(C, e);
                                return;
                            }
                            if (d) {
                                web.sxd.c.Fate.a(C);
                                return;
                            }
                            break;

                        case 6: // '\006'
                            h++;
                            j = f - 1;
                            f = j;
                            break;
                        //continue; /* Loop/switch isn't completed */
                    }
                    if (j == 0) {
                        web.sxd.b.MainThread.sendLog("　最高级普通副本扫荡完成");
                        sleep(3);
                        if (c) {
                            HeroMission.a(C, e);
                            return;
                        }
                        if (d) {
                            web.sxd.c.Fate.a(C);
                            return;
                        }
                    }
                    return;
                case 1638405:
                    l1.readUnsignedShort();
                    i1 = l1.readUnsignedShort();
                    do {
                        if (j >= i1) {
                            l1.skipBytes(11);
                            if (l1.readInt() > 0) {
                                web.sxd.b.MainThread.sendLog("　继续扫荡普通副本");
                                (new TempDataOutputStream(0x190006)).sendMain(C);
                                return;
                            }
                            break;
                        }
                        l1.skipBytes(7);
                        j++;
                    } while (true);
                    //l1 = C;
                    //ai = Town.a;
                    j = web.sxd.c.Town.c(C.g());
                    g = j;
                    a(C, Town.a[j]);
                    sleep(5);
                    return;
            }

        }catch (Exception e)
        {
            Log.v("web.sxd.c.f",e.getLocalizedMessage(),e);
        }
    }

    protected final String[] a()
    {
        return b;
    }

    private static final String a[] = {
        "Mission_", "get_sections"
    };
    private static final String b[] = {
        "MissionPractice_", "get_practice_info", "start_practice", "", "", "notify", "get_continue_practice_info", "continue_practice"
    };
    private static int g;
    private static int h = 0;
    private boolean c;
    private boolean d;
    private int e;
    private int f;

}