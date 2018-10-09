// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:45
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.c;

import android.util.Log;

import web.sxd.b.MainThread;
import web.sxd.b.TempDataInputStream;
import web.sxd.b.TempDataOutputStream;

//送花
public final class SendFlower extends web.sxd.b.BaseFunc
{

    public SendFlower(MainThread c1)
    {
        super(c1, 0x1f0000);
    }

    public static void a(MainThread c1) throws Exception
    {
        (new TempDataOutputStream(0x1f0000, c1.d())).sendMain(c1);
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
                case 0x1f0000://2031616:
                    l1.read();
                    l1.readInt();
                    l1.readUTF();
                    l1.readInt();
                    int j = l1.readInt();
                    l1.readUTF();
                    l1.readInt();
                    l1.readInt();
                    int k = l1.read();
                    int i1 = l1.readUnsignedShort();
                    do {
                        if (i >= i1) {
                            if (k == 3 && j > 0) {
                                (new TempDataOutputStream(0x1f0001, j, 1)).sendMain(C);
                                return;
                            }
                            continue; /* Loop/switch isn't completed */
                        }
                        j = l1.readInt();
                        a = l1.readUTF();
                        l1.readInt();
                        l1.readInt();
                        l1.readInt();
                        i++;
                    } while (true);
                case 0x1F0001://2031617:
                    if (l1.read() == 0) {
                        MainThread.sendLog("[送花]送给 %s [1朵鲜花]", new Object[]{
                                a
                        });
                        return;
                    }
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.c.SendFlower",e.getLocalizedMessage(),e);
        }

    }

    protected final String[] a()
    {
        return b;
    }

    private static final String b[] = {
        "SendFlower_", "player_send_flower_info", "send_player_flower"
    };
    String a;

}