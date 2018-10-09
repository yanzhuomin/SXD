// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:45
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.c;

import android.util.Log;
import web.sxd.b.*;

// Referenced classes of package web.sxd.c:
//            e

public final class Notify extends BaseFunc
{

    public Notify(MainThread c1)
    {
        super(c1, 0x14000f);
        b = false;
        d = false;
        new e(c1);
    }

    private static void a(MainThread c1, TempDataInputStream l1) throws Exception
    {
        int i;
        int j;
        int k;
        int i1;
        String s;
        StringBuilder stringbuilder;
        j = l1.readInt();
        k = l1.readInt();
        s = (new StringBuilder(String.valueOf(l1.readUTF().replace("，", ", ")))).append(l1.readUTF()).toString();
        stringbuilder = new StringBuilder((new StringBuilder("newG-")).append(j).append(":").append(k).append(" ").append(s).toString());
        i1 = l1.readUnsignedShort();
        i = 0;
        while(i < i1)
        {
            int j1 = l1.read();
            stringbuilder.append((new StringBuilder(", ")).append(web.sxd.c.e.d(j1)).append("x").append(l1.readInt()).toString());
            i++;
        }
        switch (k)
        {
            default :
                Log.i(a[0], stringbuilder.toString());
                if(!web.sxd.b.MainThread.isFuncSelect(31)) {
                    return;
                }
            case 4:
            case 14:
            case 15:
            case 16:
            case 19:
            case 27:
            case 40:
                if(!web.sxd.b.MainThread.isFuncSelect(30))
                    break; /* Loop/switch isn't completed */
                web.sxd.b.MainThread.sendLog((new StringBuilder("[不领礼包]")).append(s).toString());

        }
        web.sxd.b.MainThread.sendLog((new StringBuilder("[礼包]")).append(s).toString());
        a(2);
        web.sxd.c.e.a(c1, j);
        return;
    }

    public final void a(TempDataInputStream l1)
    {
        try {


            switch (l1.getFuncCode()) {
                default:
                    super.a(l1);
                    return;
                case 1310735:
                    int i;
                    int j;
                    if (b) {
                        c = true;
                        Log.d(b(), (new StringBuilder(String.valueOf(printFuncName(l1.getFuncCodeL(), a)))).append(" DUP").toString());
                        return;
                    }
                    b = true;
                    c = false;
                    super.a(l1);
                    j = l1.readUnsignedShort();
                    i = 0;
                    while (i < j) {
                        int k;
                        int i1;
                        int j1;
                        String s;
                        k = l1.readInt();
                        i1 = l1.readInt();
                        j1 = l1.readInt();
                        s = l1.readUTF();
                        switch (i1) {
                            default:
                                Log.i(b(), (new StringBuilder(String.valueOf(k))).append(":").append(i1).append("-").append(j1).append(" ").append(s).toString());
                                if (!web.sxd.b.MainThread.isFuncSelect(31)) break;
                            case 4:
                            case 14:
                            case 15:
                            case 16:
                            case 19:
                            case 27:
                            case 40:
                                if (web.sxd.b.MainThread.isFuncSelect(30)) {
                                    web.sxd.b.MainThread.sendLog((new StringBuilder("[不领礼包]")).append(s).toString());
                                } else {
                                    web.sxd.b.MainThread.sendLog((new StringBuilder("[礼包]")).append(s).toString());
                                    sleep(2);
                                    web.sxd.c.e.a(C, k);
                                }
                        }
                        i++;
                    }
                    b = false;
                    sleep(2);
                    if (c) {
                        (new TempDataOutputStream(0x14000f)).sendMain(C);
                        return;
                    }
                    return;
                case 1310799:
                    return;
                case 1310806:
                    switch (l1.read()) {
                        case 18: // '\022'
                            web.sxd.b.MainThread.sendLog("[仙界]云游商人降临仙界，小伙伴火速前往抢购");
                            break;

                        case 19: // '\023'
                            web.sxd.b.MainThread.sendLog("[仙界]云游商人已离开");
                            break;
                    }
                    super.a(l1);
                    return;
                case 1310807:
                    if (d) {
                        e = true;
                        Log.d(b(), (new StringBuilder(String.valueOf(printFuncName(l1.getFuncCodeL(), a)))).append(" DUP").toString());
                        return;
                    } else {
                        d = true;
                        super.a(l1);
                        a(C, l1);
                        d = false;
                        sleep(5);
                        return;
                    }
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.c.Notify",e.getLocalizedMessage(),e);
        }
    }

    protected final String[] a()
    {
        return a;
    }

    private static final String a[] = {
        "Notify_", "update_player_super_gift", "notify_luxury_seat", "notify_travel_shop_status", "notify_player_new_gift"
    };
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;

}