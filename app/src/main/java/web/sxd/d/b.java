// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:46
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;

import web.sxd.b.*;

public final class b extends BaseFunc
{

    public b(MainThread c1)
    {
        super(c1, 0x390017);
        b = false;
    }

    public static void a(MainThread c1) throws Exception
    {
        (new TempDataOutputStream(0x390017)).sendMain(c1);
    }

    public final void a(TempDataInputStream l1)
    {
        try {

            String str;
            super.a(l1);
            switch (l1.getFuncCode()) {
                default:
                    return;
                case 3735575:
                    int i = l1.readInt();
                    int j = l1.readInt();
                    boolean flag;
                    if (l1.readInt() == 1)
                        flag = true;
                    else
                        flag = false;
                    if (j == 0)
                        str = "无奖励";
                    else if (flag)
                        str = "今日已领取";
                    else
                        str = "尝试领取";
                    MainThread.sendLog("道行经验%d(Lv.%d) %s", new Object[]{
                            Integer.valueOf(i), Integer.valueOf(j), l1
                    });
                    if (j > 0 && !flag) {
                        sleep(5);
                        (new TempDataOutputStream(0x390018, 0)).sendMain(C);
                        sleep(5);
                        if (!b) {
                            a(C);
                            return;
                        } else {
                            b = false;
                            return;
                        }
                    }
                    return;
                case 3735576:
                    if (l1.read() == 5)
                        str = "成功";
                    else
                        str = "失败";
                    MainThread.sendLog("　道行奖励领取%s", new Object[]{
                            l1
                    });
                    b = true;
                    return;

            }
        }catch (Exception e)
        {
            Log.v("web.sxd.d.Fate",e.getLocalizedMessage(),e);
        }
    }

    protected final String[] a()
    {
        return a;
    }

    public static final String a[] = {
        "BeelzebubTrials_", "", "", "", "", "", "", "", "", "", 
        "", "", "", "", "", "", "", "", "", "", 
        "", "", "", "", "open_moral", "get_moral_award"
    };
    private boolean b;

}