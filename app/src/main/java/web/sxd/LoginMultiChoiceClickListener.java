// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:37
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd;

import android.content.DialogInterface;

// Referenced classes of package web.sxd:
//            LoginAct

final class LoginMultiChoiceClickListener
    implements DialogInterface.OnMultiChoiceClickListener
{

    LoginMultiChoiceClickListener(LoginAct loginact)
    {
        super();
        a = loginact;
    }

    public final void onClick(DialogInterface dialoginterface, int i, boolean flag)
    {
        LoginAct.m(a)[i] = flag;
    }

    final LoginAct a;
}