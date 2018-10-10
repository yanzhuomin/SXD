// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:42
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.a;

import android.util.Log;

import web.sxd.b.*;


/*
* 钓鱼
* */
public final class n extends BaseFunc
{

    public n(MainThread c1)
    {
        super(c1, 0xd90000);
        g = 0;
    }

    public static void a(MainThread c1) throws Exception
    {
        if(a.booleanValue())
            (new TempDataOutputStream(0xd90000)).sendMain(c1);
        a = Boolean.valueOf(false);
    }

    public final void a(TempDataInputStream l1)
    {
        try {


            int i;
            i = 1;
            super.a(l1);
            switch (l1.getFuncCode()) {
                default:
                    return;
                case 14221312:
                    d = l1.readInt();
                    web.sxd.b.MainThread.sendLog("[钓鱼]剩余鱼钩%d个  ", new Object[]{
                            Integer.valueOf(d)
                    });
                    if (d > 0) {
                        (new TempDataOutputStream(0xd90001)).sendMain(C);
                        d = d - 1;
                        return;
                    }
                    break;
                case 14221313:
                    e = l1.read();
                    f = l1.readInt();
                    g = l1.readInt();
                    switch (e) {
                        default:
                            break;
                        case 0:
                            break;
                        case 1:
                            web.sxd.b.MainThread.sendLog("[\u9493\u9C7C]\u9C7C\u94A9\u4E0D\u8DB3");
                            break;
                        case 2:
                            web.sxd.b.MainThread.sendLog("[\u9493\u9C7C]\u547D\u683C\u80CC\u5305\u6EE1");
                            web.sxd.c.Fate.b(C);
                            i = b - 1;
                            b = i;
                            if (i > 0) {
                                a = Boolean.valueOf(true);
                                a(C);
                            }
                            break;
                        case 3:
                            web.sxd.b.MainThread.sendLog("[\u9493\u9C7C]\u80CC\u5305\u6EE1");
                            int j = b - 1;
                            b = j;
                            if (j <= 0)
                                i = 0;
                            if (i!= 0 && C.b(32))
                                web.sxd.c.e.b(C);
                            break;
                        case 4:
                            web.sxd.b.MainThread.sendLog("[\u9493\u9C7C]\u4E94\u884C\u80CC\u5305\u6EE1");
                            break;
                        case 5:
                            web.sxd.b.MainThread.sendLog("[\u9493\u9C7C]\u9F99\u73E0\u683C\u5B50\u4E0D\u8DB3");
                            break;
                        case 6:
                            web.sxd.b.MainThread.sendLog("[\u9493\u9C7C]\u6B8B\u5377\u80CC\u5305\u6EE1");
                            break;
                    }
                    if (d > 0 && e == 0) {
                        c();
                        (new TempDataOutputStream(0xd90000)).sendMain(C);
                        return;
                    }
                    return;
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.a.n",e.getLocalizedMessage(),e);
        }
    }

    protected final String[] a()
    {
        return c;
    }

    static Boolean a = Boolean.valueOf(true);
    static int b = 6;
    private static final String c[] = {
        "Fish_", "get_player_fishhook", "do_fishing"
    };
    private int d;
    private int e;
    private int f;
    private int g;

}