// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:39
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3)

package web.sxd.a;

import android.util.Log;

import web.sxd.b.*;

// Referenced classes of package web.sxd.a:
//            ad

public final class ae extends BaseFunc
{

    public ae(MainThread c1)
    {
        super(c1, 0x1230000);
    }

    public static void a(MainThread c1) throws Exception
    {
        (new TempDataOutputStream(0x1230000)).sendMain(c1);
    }

    public static void b(MainThread c1) throws Exception
    {
        (new TempDataOutputStream(0x1230004)).sendSY(c1);
    }

    public final void a(TempDataInputStream l1)
    {
        try {
            int i;
            i = 0;
            super.a(l1);
            switch (l1.getFuncCode()) {
                default:
                    return;
                case 19070976:
                    int k = l1.readUnsignedShort();
                    while (i < k) {
                        l1.read();
                        l1.read();
                        if (l1.read() == 1)
                        {
                            new ad(C);
                            c();
                            ad.a(C);
                        }
                        l1.skipBytes(l1.readUnsignedShort() * 6);
                        l1.readInt();
                        l1.readUTF();
                        l1.readUTF();
                        l1.read();
                        l1.readInt();
                        l1.readInt();
                        i++;
                    }
                    l1.read();
                    l1.readUnsignedShort();
                    return;
                case 19070977:
                    return;
                case 19070978:
                    return;
                case 19070979:
                    return;
                case 19070980:
                    int j = l1.read();
                    l1.readInt();
                    int i1 = l1.readInt();
                    l1.readUnsignedShort();
                    if (j == 0)
                        if (i1 >= 3600) {
                            MainThread.sendLog("[\u5723\u57DF]\u5269\u4F59\u4FEE\u70BC\u65F6\u95F4: %d\u5C0F\u65F6 %d\u5206\u949F", new Object[]{
                                    Integer.valueOf(i1 / 3600), Integer.valueOf((i1 % 3600) / 60)
                            });
                            return;
                        } else {
                            MainThread.sendLog("[\u5723\u57DF]\u5269\u4F59\u4FEE\u70BC\u65F6\u95F4: %d\u5206\u949F", new Object[]{
                                    Integer.valueOf(i1 / 60)
                            });
                            return;
                        }
                    return;
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.a.ae",e.getLocalizedMessage(),e);
        }
    }

    protected final String[] a()
    {
        return a;
    }

    private static final String a[] = {
        "SAPRACTICE_", "get_enter_saint_area_info", "find", "get_npc_shop_info", "buy_prop", "get_practice_info", "notify_saint_area_status"
    };

}