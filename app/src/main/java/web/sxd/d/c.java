// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:46
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import web.sxd.b.MainThread;
import web.sxd.b.TempDataOutputStream;

final class c
{

    c(MainThread c1, int l)
    {
        h = c1;
        i = l;
        a = i + 9;
        d = 0x30d40;
    }

    final String a()
    {
        int l;
        int i1;
        int j1;
        String s;
        s = (new StringBuilder(String.valueOf(toString()))).append(" ").toString();
        i1 = k / 60;
        l = i1 / 60;
        i1 %= 60;
        if(i != 3)
        {
            StringBuilder stringbuilder = (new StringBuilder(String.valueOf(s))).append(l).append(":");
            if(i1 < 10)
                s = "0";
            else
                s = "";
            return stringbuilder.append(s).append(i1).toString();
        }
        j1 = l / 24;
        switch (j)
        {
            default:break;
            case 0:
                s = (new StringBuilder(String.valueOf(s))).append("本").toString();
                //s = (new StringBuilder(String.valueOf(s))).append("下").toString();
                break;
            case 1:s = (new StringBuilder(String.valueOf(s))).append("下").toString();break;
        }
        StringBuilder stringbuilder1 = (new StringBuilder(String.valueOf(s))).append(g[(j1 + 4) % 7]).append((l + 8) % 24).append(":");
        if(i1 < 10)
            s = "0";
        else
            s = "";
        return stringbuilder1.append(s).append(i1).toString();
    }

    final void a(int l, int i1)
    {
        k = l;
        j = i1;
    }

    final void b()
    {
        if(c == d)
        {
            web.sxd.b.MainThread.sendLog("[BOSS]%d级, 满血: %dw", new Object[] {
                Integer.valueOf(b), Integer.valueOf(d)
            });
            return;
        } else
        {
            web.sxd.b.MainThread.sendLog("[BOSS]%d级, %dw/%dw", new Object[] {
                Integer.valueOf(b), Integer.valueOf(c), Integer.valueOf(d)
            });
            web.sxd.b.MainThread.sendLog(c, d);
            return;
        }
    }

    final void c() throws Exception
    {
        (new TempDataOutputStream(0x180002, i)).sendMain(h);
    }

    public final String toString()
    {
        return f[i];
    }

    private static final String f[] = {
            "未知", "擎天木", "赤炎兽", "刀疤兔", "跨服Boss", "", "", "", "", "",
            "白泽", "青龙"
    };
    private static final String g[] = {
            "周日", "周一", "周二", "周三", "周四", "周五", "周六"
    };
    int a;
    int b;
    int c;
    int d;
    int e;
    private web.sxd.b.MainThread h;
    private int i;
    private int j;
    private int k;

}