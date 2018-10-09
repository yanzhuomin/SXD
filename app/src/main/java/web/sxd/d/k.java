// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:47
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;

import web.sxd.b.*;

// Referenced classes of package web.sxd.d:
//            n

public final class k extends BaseFunc
{

    public k(MainThread c1)
    {
        super(c1, 0x280003);
    }

    static void a(MainThread c1) throws Exception
    {
        (new TempDataOutputStream(0x280003)).sendMain(c1);
    }

    static void e()
    {
        b = 0;
    }

    public final void a(TempDataInputStream l1)
    {
        try {


            int i;
            int i1;
            super.a(l1);
            i1 = l1.getFuncCode();
            i = l1.read();
            switch (i1) {
                default:
                    return;
                case 2621441:
                    int j = l1.readInt();
                    if (j == 0) {
                        j = b + 1;
                        b = j;
                        if (j >= 25) {
                            MainThread.sendLog("　第 %d 次摘桃失败，暂停尝试。", new Object[]{
                                    Integer.valueOf(b)
                            });
                            return;
                        } else {
                            MainThread.sendLog("　第 %d 次摘桃失败，重新挑战。", new Object[]{
                                    Integer.valueOf(b)
                            });
                            sleep(b);
                            (new TempDataOutputStream(0x280001)).sendMain(C);
                            return;
                        }
                    } else {
                        b = 0;
                        MainThread.sendLog("摘桃成功，获得经验：%d。", new Object[]{
                                Integer.valueOf(j)
                        });
                        (new TempDataOutputStream(0x280003)).sendMain(C);
                        c();
                        n.a(C);
                        return;
                    }
                case 2621442:
                    return;
                case 2621443:
                    int j1 = l1.read();
                    if (j1 == 0) {
                        MainThread.sendLog("　%d级 桃子已经摘完啦！", new Object[]{
                                Integer.valueOf(i * 5 + 70)
                        });
                        return;
                    }
                    if (i >= 10 && j1 >= 5 && l1.read() == 1) {
                        MainThread.sendLog("还剩 %d个 %d级桃子，尝试批量摘桃", new Object[]{
                                Integer.valueOf(j1), Integer.valueOf(i * 5 + 70)
                        });
                        c();
                        (new TempDataOutputStream(0x280005)).sendMain(C);
                        return;
                    }
                    if (b < 25) {
                        MainThread.sendLog("还剩 %d个 %d级桃子，准备开始挑战", new Object[]{
                                Integer.valueOf(j1), Integer.valueOf(i * 5 + 70)
                        });
                        sleep(10);
                        (new TempDataOutputStream(0x280001)).sendMain(C);
                        return;
                    }
                    return;
                case 2621444:
                    return;
                case 2621445:
                    if (i == 0) {
                        MainThread.sendLog("批量摘桃成功，获得经验：%d。", new Object[]{
                                Integer.valueOf(l1.readInt())
                        });
                        return;
                    } else {
                        MainThread.sendLog("批量摘桃失败，尝试逐个摘取");
                        sleep(b);
                        (new TempDataOutputStream(0x280001)).sendMain(C);
                        return;
                    }
                    //return;
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.d.k",e.getLocalizedMessage(),e);
        }
    }

    protected final String[] a()
    {
        return a;
    }

    private static final String a[] = {
        "GetPeach_", "", "get_peach", "", "peach_info", "", "batch_get_peach"
    };
    private static int b = 0;

}