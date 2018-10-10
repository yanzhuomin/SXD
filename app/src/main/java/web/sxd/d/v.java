// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:48
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;

import web.sxd.b.*;

// Referenced classes of package web.sxd.d:
//            s

/**
 * 进入仙界城镇
 * */
public final class v extends BaseFunc
{

    public v(MainThread c1)
    {
        super(c1, 0x5f0000);
    }

    public final void a(TempDataInputStream l1) {
        try {


            switch (l1.getFuncCode()) {
                default:
                    return;
                case 6225920://0x5F0000
                    if (l1.read() == 0) {
                        super.a(l1);
                        MainThread.sendLog("[仙界]进入仙界城镇");
                        C.l();
                        if (C.b(94)) {
                            c();
                            s.a(C);
                            return;
                        }
                    }
                    return;
            }
        } catch (Exception e)
        {
            Log.v("web.sxd.d.v", e.getLocalizedMessage(),e);
        }
    }

    protected final String[] a()
    {
        return a;
    }

    private static final String a[] = {
        "StTown_", "enter_town", "leave_town", "notify_enter_town", "notify_level_town", "notify_move_to", "notify_image_change"
    };

}