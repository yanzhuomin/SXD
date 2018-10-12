// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:39
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.a;

import android.util.Log;

import web.sxd.b.*;

// Referenced classes of package web.sxd.a:
//            ae, af

public final class ad extends BaseFunc
{

    public ad(MainThread c1)
    {
        super(c1, 0x1250001);
        new ae(c1);//TODO 暂时注释
        //c1.addFunc(293, a, this);
        new af(c1);
    }

    public static boolean a(MainThread c1) throws Exception
    {
        if(c1.p())
        {
            (new TempDataOutputStream(0x1250001)).sendMain(c1);
            return true;
        } else
        {
            return false;
        }
    }

    public final void a(TempDataInputStream l1)
    {
        try {


            super.a(l1);
            switch (l1.getFuncCode()) {
                case 19202050:
                default:
                    return;

                case 19202048:
                    if (l1.read() == 0)
                        MainThread.sendLog("[圣域] ^o^ 跨服登录成功 ");
                    else
                        MainThread.sendLog("[圣域] -_- 跨服登录失败");
                    c();
                    C.m();
                    ae.b(C);
                    return;

                case 19202049:
                    C.b(l1.readUTF(), l1.readUnsignedShort(), l1.readUTF(), l1.readInt(), l1.readUTF());
                    return;

                case 19202051:
                    a(C);
                    return;
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.a.ad",e.getLocalizedMessage(),e);
        }
    }

    protected final String[] a()
    {
        return a;
    }

    private static final String a[] = {
        "SaintAreaLogin_", "login", "get_login_info", "get_status", "notify_change_status", "get_saint_area_server_host"
    };

}