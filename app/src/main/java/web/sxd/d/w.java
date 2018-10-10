// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:48
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;
import web.sxd.b.*;

public final class w extends BaseFunc
{

    public w(MainThread c)
    {
        super(c, 0x77000f);
    }

    public final void a(TempDataInputStream l1)
    {
        try {


            boolean flag = false;
            switch (l1.getFuncCode()) {
                default:
                    super.a(l1);
                    return;
                case 7798799:
                    int i;
                    int j;
                    int k;
                    int i1;
                    StringBuilder stringbuilder;
                    j = l1.read();
                    k = l1.read();
                    i1 = l1.readUnsignedShort();
                    stringbuilder = new StringBuilder();
                    i = 0;
                    while (i < i1) {
                        stringbuilder.append((new StringBuilder("[")).append(l1.readInt()).append(l1.readUTF()).append(l1.readUnsignedShort()).append("], ").toString());
                    }
                    i = l1.readUnsignedShort();
                    i1 = l1.readUnsignedShort();
                    switch (j) {
                        default:
                            Log.i(b(), (new StringBuilder("notify: ")).append(j).append(", ").append(k).append(", ").append(i).toString());
                            break;
                        case 34:
                            Log.i(b(), (new StringBuilder("NOTIFY_CHANGE: ")).append(k).append(", ").append(i).toString());
                            break;
                        case 35:
                            String s = (new StringBuilder("POSITION_CHANGE: ")).append(k).append(", ").append(i).toString();
                            if (stringbuilder.length() == 0 && k == 42 && i1 == 0 && i == 0) return;
                            Log.v(b(), s);
                            break;
                    }
                    i = 0;
                    while (i < i1) {
                        stringbuilder.append(", ");
                        stringbuilder.append(l1.readUTF());
                        stringbuilder.append(l1.readUTF());
                        i++;
                    }
                    if (stringbuilder.length() > 0) {
                        Log.i(b(), stringbuilder.toString());
                        return;
                    }
                    return;

            }
        }catch (Exception e)
        {
            Log.v("web.sxd.d.w",e.getLocalizedMessage(),e);
        }
    }

    protected final String[] a()
    {
        return a;
    }

    private static final String a[] = {
        "StXianFuSup_", "notify"
    };

}