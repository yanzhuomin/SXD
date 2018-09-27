// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:38
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package web.sxd:
//            WebSXDact

final class WebSXDItemClickListener
    implements AdapterView.OnItemClickListener
{

    WebSXDItemClickListener(WebSXDact websxdact)
    {
        super();
        a = websxdact;

    }

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        a.bLoaded(a.getWebView(a));
    }

    final WebSXDact a;
}