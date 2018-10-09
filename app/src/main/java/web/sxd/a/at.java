// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:40
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.a;

import android.util.Log;

import web.sxd.b.*;

public final class at extends BaseFunc
{

    public at(MainThread c1)
    {
        super(c1, 0xf20000);
        a = 0;
        b = 1;
        c = 2;
    }

    public static void a(MainThread c1) throws Exception
    {
        (new TempDataOutputStream(0xf20000)).sendMain(c1);
    }

    public final void a(TempDataInputStream l1)
    {
        try {


            super.a(l1);
            switch (l1.getFuncCode()) {
                default:
                    return;
                case 15859712:
                    if (l1.read() == a) {
                        (new TempDataOutputStream(0xf20001)).sendMain(C);
                        return;
                    }
                    break;
                case 15859713:
                    if (l1.readInt() > 0) {
                        (new TempDataOutputStream(0xf20002)).sendMain(C);
                        return;
                    } else {
                        web.sxd.b.MainThread.sendLog("[周末]水果机次数已用完");
                        return;
                    }
                case 15859714:
                    if (l1.read() == c) {
                        sleep(10);
                        (new TempDataOutputStream(0xf20001)).sendMain(C);
                        return;
                    }
                    break;
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.a.at",e.getLocalizedMessage(),e);
        }

    }

    protected final String[] a()
    {
        return d;
    }

    private static final String d[] = {
        "SUNDAYFRUIT_", "active_status", "sunday_fruit_info", "draw"
    };
    int a;
    int b;
    int c;

}