// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:39
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.a;

import android.util.Log;

import web.sxd.b.*;

// Referenced classes of package web.sxd.a:
//            ac

public final class af extends BaseFunc
{

    public af(MainThread c1)
    {
        super(c1, 0x1260000);
        a = 2;
    }

    public final void a(TempDataInputStream l1)
    {
        try {
            super.a(l1);
            switch (l1.getFuncCode()) {
                default:
                    return;
                case 19267584:
                    if (l1.read() == a) {
                        super.a(l1);
                        MainThread.sendLog("[圣域]进入圣域城镇");
                        (new TempDataOutputStream(0x1260006)).sendSY(C);
                        //TODO 暂时注释
//                        if (!c.c(7)) {
//                            new ac(C);
//                            c();
//                            ac.a(C);
//                            return;
//                        }
                    }
                    return;
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.a.af",e.getLocalizedMessage(),e);
        }

    }

    protected final String[] a()
    {
        return b;
    }

    private static final String b[] = {
        "SaintAreaTown_", "enter_town", "notify_enter_town", "leave_town", "notify_leave_town", "move_to", "notify_move_to", "get_players", "notify_image_change", "get_player_info"
    };
    int a;

}