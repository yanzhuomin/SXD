// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:47
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;

//import web.sxd.a.an;
import web.sxd.b.*;
import web.sxd.c.e;

// Referenced classes of package web.sxd.d:
//            b

public final class j extends BaseFunc
{

    public j(MainThread c1)
    {
        super(c1, 0x7f0000);
    }

    public static void a(MainThread c1) throws Exception
    {
        (new TempDataOutputStream(0x7f0000)).sendMain(c1);
    }

    public static void b(MainThread c1) throws Exception
    {
        (new TempDataOutputStream(0x7f0001)).sendMain(c1);
    }

    public final void a(TempDataInputStream l1)
    {
        try {


            super.a(l1);
            switch (l1.getFuncCode()) {
                default:
                    return;
                case 8323072:
                    int i;
                    int i1;
                    i1 = l1.readUnsignedShort();
                    i = 0;
                    while (i < i1) {
                        int k1 = l1.readUnsignedShort();
                        if (l1.read() == 1) {
                            String s;
                            switch (k1) {
                                default:
                                    s = (new StringBuilder("No.")).append(k1).toString();
                                    break;
                                case 54:
                                    s = "吉星高照";
                                    break;
                                case 55:
                                    s = "拜关公";
                                    break;
                                case 68:
                                    s = "魔王试炼";
                                    break;
                                case 70:
                                    s = "喜从天降";
                                    break;
                                case 85:
                                    s = "采集灵气";
                                    break;
                                case 106:
                                    s = "自定义挑战";
                                    break;
                                case 112:
                                    s = "极限挑战";
                                    break;
                            }
                            web.sxd.b.MainThread.sendLog("[功能]%s 已终结", new Object[]{
                                    s
                            });
                            if (k1 == 106) {
                                //TODO 暂时注释 new an(C);
                                c();
                                //TODO 暂时注释 an.a(C);
                            }
                            if (k1 == 68) {
                                new b(C);
                                c();
                                web.sxd.d.b.a(C);
                            } else if (k1 != 112)
                                C.a(k1);
                        }

                        i++;
                    }
                    return;
                case 8323073:
                    i = l1.readUnsignedShort();
                    f = i;
                    if (i <= 0) {
                    } else {
                        a = new short[f + 1];
                        e = new int[f + 1];
                        a[0] = (short) f;
                        i = 1;
                        while (i <= f) {
                            short word0 = (short) l1.readUnsignedShort();
                            a[i] = word0;
                            int j1 = l1.readUnsignedShort();
                            int i2 = l1.readInt();
                            int j2 = l1.readInt();
                            int k2 = l1.readInt();
                            int l2 = l1.readInt();
                            int i3 = l1.readUnsignedShort();
                            int j3 = l1.readUnsignedShort();
                            int k3 = l1.readInt();
                            l1.read();
                            if (j1 > 0 || i2 > 0 || j2 > 0 || k2 > 0 || l2 > 0 || i3 > 0 || j3 > 0 || k3 > 0)
                                e[i] = 1;
                            i++;
                        }
                    }
                    if (f > 0) {
                        short word0;
                        int j1;
                        int i2;
                        int j2;
                        int k2;
                        int l2;
                        int i3;
                        int j3;
                        int k3;
                        if (e[f] == 0)
                            (new TempDataOutputStream(0x7f0003, a[f])).sendMain(C);
                        else
                            (new TempDataOutputStream(0x7f0002, a[f])).sendMain(C);
                        c();
                    }
                    new e(C);
                    c();
                    web.sxd.c.e.a(C);
                    return;
                case 8323074:
                    int k = l1.read();
                    if (k == 0) {
                        f--;
                        a[0] = (short) f;
                        if (f > 0 && k == 0)
                            if (e[f] == 0) {
                                (new TempDataOutputStream(0x7f0003, a[f])).sendMain(C);
                                return;
                            } else {
                                (new TempDataOutputStream(0x7f0002, a[f])).sendMain(C);
                                return;
                            }
                        if (k == 0) {
                            web.sxd.b.MainThread.sendLog("[礼包]功能终结礼包领取成功 ");
                            return;
                        }
                    }
                    return;
                case 8323075:
                    e[f] = 1;
                    (new TempDataOutputStream(0x7f0002, a[f])).sendMain(C);
                    return;
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.d.j",e.getLocalizedMessage(),e);
        }


    }

    protected final String[] a()
    {
        return b;
    }

    public static short a[] = new short[100];
    private static final String b[] = {
        "FunctionEnd_", "is_game_function_end", "game_function_end_gift", "get_game_function_end_gift", "random_award", "get_end_gift_info", "get_end_gift"
    };
    private static boolean c = false;
    private static short d = 0;
    private static int e[] = new int[100];
    private static int f;

}