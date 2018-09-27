// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:43
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.b;


// Referenced classes of package web.sxd.b:
//            c
/*
*  3分钟超时退出 监测线程
* */
public final class TimeOutThread extends Thread
{

    private TimeOutThread()
    {
        b = 200;
        start();
    }

    static void clear()
    {
        if(a != null) {
            TimeOutThread b1 = a;
            boolean flag;
            if (b1.b > 0) {
                b1.b = 200;
                flag = true;
            } else {
                b1.b = -2;
                flag = false;
            }
            if (flag)//超时
                //TODO Here;
                ;
        }
        a = new TimeOutThread();

    }

    static void TimeOutThread()
    {
        if(a != null)
        {
            a.b = -2;
            a = null;
        }
    }

    public final void run()
    {
        while (true)
        {
            int i;
            i = b;
            b = i - 1;
            if(i > 0)
            {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    return;
                }
            }else
            {
                if(b >= -1 && !MainThread.isFuncSelect(12))
                    MainThread.sendLog(-1, "最近3分钟未收到新消息，断开连接");
                return;
            }
        }
    }

    private static TimeOutThread a = null;
    private int b;

}