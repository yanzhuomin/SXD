// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:38
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd;

import android.text.Editable;
import android.view.View;
import android.widget.AutoCompleteTextView;

// Referenced classes of package web.sxd:
//            WebSXDact

final class k
    implements View.OnFocusChangeListener
{

    k(WebSXDact websxdact)
    {
        super();
        a = websxdact;

    }

    public final void onFocusChange(View view, boolean flag)
    {
        AutoCompleteTextView testView = (AutoCompleteTextView)view;
        if(flag && testView.getText().length() == 0)
            testView.showDropDown();
    }

    final WebSXDact a;
}