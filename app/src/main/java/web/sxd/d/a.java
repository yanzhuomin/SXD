// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:45
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;
import web.sxd.b.*;

public final class a extends BaseFunc
{

    public a(MainThread c1)
    {
        super(c1, 0x340000);
    }

    static void a(MainThread c1) throws Exception
    {
        (new TempDataOutputStream(0x340000)).sendMain(c1);
    }

    public final void a(TempDataInputStream l1)
    {
        try {


            super.a(l1);
            switch (l1.getFuncCode()) {
                default:
                    return;
                case 3407872:
                    b = 15;
                    StringBuilder stringbuilder = new StringBuilder(String.valueOf(l1.readInt()));
                    int i = 0;
                    do {
                        if (i >= 15) {
                            stringbuilder.append((new StringBuilder("|")).append(b).toString());
                            MainThread.sendLog("　小助手活跃度奖励 已领取至 #%d", new Object[]{
                                    Integer.valueOf(b)
                            });
                            Log.i(b(), stringbuilder.toString());
                            if (b < 15) {
                                c();
                                i = b + 1;
                                b = i;
                                (new TempDataOutputStream(0x340001, i)).sendMain(C);
                                return;
                            }
                            continue; /* Loop/switch isn't completed */
                        }
                        if (i % 3 == 0)
                            stringbuilder.append(',');
                        int i1 = l1.read();
                        stringbuilder.append(i1);
                        if (i < b && i1 == 0)
                            b = i;
                        i++;
                    } while (true);
                case 3407873:
                    int j = l1.read();
                    if (j == 0) {
                        MainThread.sendLog("　领取小助手活跃度奖励 #%d", new Object[]{
                                Integer.valueOf(b)
                        });
                        sleep(5);
                        j = b + 1;
                        b = j;
                        (new TempDataOutputStream(0x340001, j)).sendMain(C);
                        return;
                    }
                    if (j == 3) {
                        MainThread.sendLog("　小助手#%d 奖励领取失败: 背包已满", new Object[]{
                                Integer.valueOf(b)
                        });
                        return;
                    }
                    break;
                case 3407874:
                    int k = l1.readInt();
                    Log.v(b(), (new StringBuilder("AC_number: ")).append(k * 5).toString());
                    if (b > 0 && k % 10 == 0) {
                        c();
                        (new TempDataOutputStream(0x340001, b)).sendMain(C);
                        return;
                    }
                    return;
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.d.a",e.getLocalizedMessage(),e);
        }
    }

    protected final String[] a()
    {
        return a;
    }

    private static final String a[] = {
        "Assistant_", "info", "get_award", "complete_number"
    };
    private int b;

}