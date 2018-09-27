// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:38
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package web.sxd:
//            WebSXDact

final class i
    implements TextView.OnEditorActionListener
{

    i(WebSXDact websxdact)
    {
        super();
        a = websxdact;

    }

    public final boolean onEditorAction(TextView textview, int j, KeyEvent keyevent)
    {
        a.bLoaded(textview);
        return true;
    }

    final WebSXDact a;
}