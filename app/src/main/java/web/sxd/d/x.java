// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:48
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3)

package web.sxd.d;

import android.util.Log;

import web.sxd.a.*;
import web.sxd.b.*;

// Referenced classes of package web.sxd.d:
//            v, w, s, u,
//            t

/**
 * 仙界登陆
 */
public final class x extends BaseFunc
{

    public x(MainThread c1)
    {
        super(c1, 0x600000);
        c1.addFunc(94, b, this);
            new v(c1);
    }

    static boolean a(MainThread c1) throws Exception
    {
        if(c1.o())
        {
            (new TempDataOutputStream(0x600000)).sendMain(c1);
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
                default:
                    return;

                case 6160384:
                    if (l1.read() == 0)
                        MainThread.sendLog("[仙界] ^o^ 跨服登录成功 ");
                    else
                        MainThread.sendLog("[仙界] -_- 跨服登录失败");
                    new w(C);
                    if (C.b(94)) {
                        new s(C);
                        c();
                        s.a(C);
                    }
                    if (C.b(90)) {
                        //TODO 暂时注释 u.a(C);
                        sleep(5);
                    }
                    c();
                    C.m();
                    if (C.b(91) && C.b(30)) {
                        //TODO 暂时注释 new i(C);
                        c();
                        //TODO 暂时注释 i.a(C);
                    }
                    //TODO 暂时注释 new t(C);
                    c();
                    //TODO 暂时注释 t.a(C);
                    if (C.b(91) && C.b(132)) {
                        //TODO 暂时注释 new ar(C);
                        c();
                        //TODO 暂时注释 ar.a(C);
                        //TODO 暂时注释 new am(C);
                        c();
                        //TODO 暂时注释 am.a(C);
                    }
                    if (C.b(91) && C.b(157)) {
                        //TODO 暂时注释 new aq(C);
                        c();
                        //TODO 暂时注释 aq.a(C);
                    }
                    if (C.b(91) && (C.b(102) || C.b(103))) {
                        //TODO 暂时注释 new ao(C);
                        c();
                        //TODO 暂时注释 ao.a(C);
                    }
                    C.b(18);
                    return;

                case 6291456:
                    C.a(l1.readUTF(), l1.readUnsignedShort(), l1.readUTF(), l1.readInt(), l1.readUTF());
                    return;

                case 6291458:
                    a(C);
                    return;
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.d.x",e.getLocalizedMessage(),e);
        }
    }

    protected final String[] a()
    {
        return a;
    }

    private static final String a[] = {
        "StcLogin_", "get_login_info", "", "notify_change_status"
    };
    private static final String b[] = {
        "StLogin_", "login"
    };

}