// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:44
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.b;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import java.util.Date;

// Referenced classes of package web.sxd.b:
//            b, c

public abstract class BaseHandler extends Handler
{

    protected BaseHandler(Activity activity)
    {
        b = false;
        c = "";
        a = activity;
    }

    protected abstract void a();

    protected abstract void a(String s);

    protected abstract void b();

    protected abstract void b(String s);

    protected abstract void c();

    protected abstract boolean c(String s);

    @Override
    public void handleMessage(Message message)
    {
        if(message.obj != null && message.what < 3)
        {
            String s = message.obj.toString();
            a((new StringBuilder("\n")).append(s).toString());
        }
        switch (message.what)
        {
            default: return;
            case -2: b();return;
            case -1:        a();
                            web.sxd.b.TimeOutThread.TimeOutThread();
                            return;
            case 0:        return;
            case 2:
                a.setProgressBarIndeterminateVisibility(true);
                a.setProgress(100);
                b = true;
                return;
            case 1:
            if(message.arg2 <= 0)
            {
                c();
                a.setProgress(10000);
                a.setProgressBarIndeterminateVisibility(false);
                b = false;
                return;
            } else
            {
                int i = (int)(((long)message.arg1 * 10000L) / (long)message.arg2);
                a.setProgress(i);
                a.setTitle(String.format("　　　%dw / %dw (%d%%)%s", new Object[] {
                        Integer.valueOf(message.arg1), Integer.valueOf(message.arg2), Integer.valueOf(i / 100), c.toString()
                }));
                return;
            }
            case 3:
            c = message.obj;
            if(message.arg2 > 0)
            {
                int j = (int)(((long)message.arg1 * 10000L) / (long)message.arg2);
                a.setSecondaryProgress(j);
                if(b)
                {
                    a.setTitle(String.format("　　　%dw / %dw (%d%%)%s", new Object[] {
                            Integer.valueOf(message.arg1), Integer.valueOf(message.arg2), Integer.valueOf(j / 100), c.toString()
                    }));
                    return;
                }
            }
            //continue; /* Loop/switch isn't completed */
            case 4:
            if(!web.sxd.b.MainThread.isFuncSelect(12))
            {
                Date date = new Date();
                c(String.format("%s%tT", new Object[] {
                        message.obj, date
                }));
                return;
            }
            return ;
            //if(true) goto _L1; else goto _L8
            case 5:
            b((String)message.obj);
            return;
        }

    }

    private Activity a;
    private boolean b;
    private Object c;
}