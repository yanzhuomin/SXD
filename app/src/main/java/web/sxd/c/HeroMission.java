// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:45
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.c;

import android.util.Log;
import web.sxd.b.*;

// Referenced classes of package web.sxd.c:
//            i, b

public final class HeroMission extends BaseFunc
{

    public HeroMission(MainThread c1)
    {
        super(c1, 0x230002);
        c = c1.b(24);
    }

    private static void a(MainThread c1) throws Exception
    {
        if(a >= 8 && c1.b(51))
        {
            c();
            if(c1.i() >= 80)
            {
                a++;
                int j = Town.a[a];
                if(j >= 14)
                {
                    Log.i("HeroMission", (new StringBuilder("try start_practice: ")).append(j).toString());
                    TempDataOutputStream m1 = new TempDataOutputStream(0x230002);
                    m1.writeShort(j);
                    m1.write(1);
                    m1.write(0);
                    m1.sendMain(c1);
                    return;
                }
                if(j < 13)
                    web.sxd.b.MainThread.sendLog("　未通关扬州城, 不进行精英扫荡");
                else
                    web.sxd.b.MainThread.sendLog("　已扫荡至扬州城, 精英扫荡结束");
            } else
            {
                web.sxd.b.MainThread.sendLog("　体力不足80, 精英扫荡结束");
            }
            c1.l();
            if(c1.b(24))
            {
                web.sxd.c.Fate.a(c1);
                return;
            }
        }
    }

    static void a(MainThread c1, int j) throws Exception
    {
        a = j;
        if(j < 8)
            a = 8;
        (new TempDataOutputStream(0x230005)).sendMain(c1);
    }

    public final void a(TempDataInputStream l1)
    {
        try {


            super.a(l1);
            switch (l1.getFuncCode()) {
                default:return;
                case 2293762 :
                    int k = l1.read();
                    int i1 = Town.a[a];
                    switch(k)
                    {
                        case 4: // '\004'
                        case 5: // '\005'
                        default:
                            web.sxd.b.MainThread.sendLog("精英扫荡失败: 错误代码 %d", new Object[] {
                                    Integer.valueOf(k)
                            });
                            if(c)
                            {
                                web.sxd.c.Fate.a(C);
                                return;
                            }
                            break;

                        case 3: // '\003'
                            web.sxd.b.MainThread.sendLog("开始扫荡 %s 精英", new Object[] {
                                    Town.e(i1)
                            });
                            //l1 = C;
                            //web.sxd.b.MainThread.k();
                            return;

                        case 8: // '\b'
                            web.sxd.b.MainThread.sendLog(" %s 精英已扫荡", new Object[] {
                                    Town.e(i1)
                            });
                            a(C);
                            return;

                        case 6: // '\006'
                        case 7: // '\007'
                            String str;
                            if(k == 7)
                                str = "体力不足";
                            else
                                str = "背包已满";
                            web.sxd.b.MainThread.sendLog("精英扫荡失败: %s", new Object[] {
                                    str
                            });
                            if(c)
                            {
                                web.sxd.c.Fate.a(C);
                                return;
                            }
                            break;
                    }
                    return;
                case 2293763 :return;
                case 2293764 :
                    int j = l1.read();
                    switch(j)
                    {
                        case 8: // '\b'
                        default:
                            web.sxd.b.MainThread.sendLog("精英扫荡失败: 错误代码 %d", new Object[] {
                                    Integer.valueOf(j)
                            });
                            return;

                        case 6: // '\006'
                        case 7: // '\007'
                            String str;
                            if(j == 7)
                                str = "体力不足";
                            else
                                str = "背包已满";
                            web.sxd.b.MainThread.sendLog("精英扫荡停止: %s", new Object[] {
                                    str
                            });
                            C.l();
                            if(c)
                            {
                                web.sxd.c.Fate.a(C);
                                return;
                            }
                            break;

                        case 10: // '\n'
                            web.sxd.b.MainThread.sendLog("%s 精英扫荡完成", new Object[] {
                                    Town.e(Town.a[a])
                            });
                            a(C);
                            return;

                        case 9: // '\t'
                            break;
                    }
                    return;
                case 2293765 :
                    if(l1.read() > 0)
                    {
                        web.sxd.b.MainThread.sendLog("继续扫荡 %s 精英", new Object[] {
                                Town.e(l1.readUnsignedShort())
                        });
                        c();
                        (new TempDataOutputStream(0x230006)).sendMain(C);
                        return;
                    } else
                    {
                        a(C);
                        return;
                    }
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.c.HeroMission",e.getLocalizedMessage(),e);
        }


    }

    protected final String[] a()
    {
        return b;
    }

    static int a = 7;
    private static final String b[] = {
        "HeroMission_", "", "", "start_practice", "", "notify", "get_continue_practice_info", "continue_practice"
    };
    private boolean c;

}