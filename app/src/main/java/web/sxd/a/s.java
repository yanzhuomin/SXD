// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:43
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.a;

import android.util.Log;

import web.sxd.b.*;
import web.sxd.c.e;

//帮派转盘
public final class s extends BaseFunc
{

    public s(MainThread c1)
    {
        super(c1, 0x450001);
        a = 2;
        b = 3;
        c = 4;
    }

    public static void a(MainThread c1) throws Exception
    {
        (new TempDataOutputStream(0x450001)).sendMain(c1);
    }

    public final void a(TempDataInputStream l1)
    {
        try {


            super.a(l1);
            switch (l1.getFuncCode()) {
                default:
                    return;
                case 4521985:
                    l1.read();
                    l1.readInt();
                    d = l1.readInt();
                    if (d > 0) {
                        web.sxd.b.MainThread.sendLog("[帮派]青龙令剩余%d个,开始转盘", new Object[]{
                                Integer.valueOf(d)
                        });
                        (new TempDataOutputStream(0x450002)).sendMain(C);
                        return;
                    }
                    break;
                case 4521986:
                    int i = l1.read();
                    l1.read();
                    int j = l1.readInt();
                    l1.readInt();
                    if (d == j) {
                        if (i != a) {
                            web.sxd.b.MainThread.sendLog("[帮派]转盘失败,青龙令剩余%d个", new Object[]{
                                    Integer.valueOf(d)
                            });
                            return;
                        }
                        d = 0;
                    } else {
                        d = j;
                    }
                    if (i == a && d > 0) {
                        (new TempDataOutputStream(0x450002)).sendMain(C);
                        return;
                    }
                    if (i == a && d == 0) {
                        web.sxd.b.MainThread.sendLog("[帮派]转盘成功");
                        return;
                    }
                    if (i != a && d > 0) {
                        web.sxd.c.e.b(C);
                        sleep(15);
                        (new TempDataOutputStream(0x450002)).sendMain(C);
                        return;
                    }
                    return;
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.a.s",e.getLocalizedMessage(),e);
        }

    }

    protected final String[] a()
    {
        return e;
    }

    private static final String e[] = {
        "LUCKYWHEEL_", "", "open_lucky_wheel", "start_lucky_wheel"
    };
    int a;
    int b;
    int c;
    int d;

}