// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:47
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import web.sxd.b.*;

/**
 * 签到
 * */
public final class SignIn extends BaseFunc
{

    public SignIn(MainThread c1)
    {
        super(c1, 0x970000);
    }

    private static String getTime(long l1)
    {
        return (new SimpleDateFormat("yyyy年M月d日")).format(new Date(1000L * l1));
    }

    static void a(MainThread c1) throws  Exception
    {
        (new TempDataOutputStream(0x970000)).sendMain(c1);
    }

    private void b(TempDataInputStream l1) throws Exception
    {
        int j = l1.read();
        int k = l1.readUnsignedShort();
        int i = 0;
        do
        {
            if(i >= k)
                return;
            int i1 = l1.read();
            int j1 = l1.read();
            l1.skipBytes(12);
            if(j1 != 21)
                Log.i(b(), (new StringBuilder("GTA_")).append(i1).append("=").append(j1).toString());
            if(20 == j1)
            {
                MainThread.sendLog("当前有%d个大红花，集齐 %d个大红花可领取奖励", new Object[] {
                    Integer.valueOf(j), Integer.valueOf(i1)
                });
                (new TempDataOutputStream(0x970003, (byte)i)).sendMain(C);
            }
            i++;
        } while(true);
    }

    public final void a(TempDataInputStream l1)
    {
        try {


            int i;
            i = 0;
            super.a(l1);
            switch (l1.getFuncCode()) {
                default:
                    return;
                case 0x970000:// 9895936:
                    i = l1.readInt();
                    int j = l1.readInt();
                    int k1 = l1.readInt();
                    MainThread.sendLog("[签到] %s ~ %s 今天%s", new Object[]{
                            getTime(i), getTime(j), getTime(k1)
                    });
                    if (System.currentTimeMillis() >= (long) i * 1000L && System.currentTimeMillis() <= (long) j * 1000L) {
                        int k;
                        if (l1.read() == 0)
                            i = 1;
                        else
                            i = 0;
                        l1.skipBytes(l1.readUnsignedShort() * 9);
                        k = l1.read();
                        l1.read();
                        b(l1);
                        if (i == 0)
                            (new TempDataOutputStream(0x970002, (byte) 0)).sendMain(C);
                        String str;
                        if (i != 0)
                            str = "已";
                        else
                            str = "未";
                        MainThread.sendLog("[签到]累计签到 %d 天, 今日%s签到", new Object[]{
                                Integer.valueOf(k), l1
                        });
                        return;
                    }
                    break;
                case 0x970001://9895937:
                    int i1 = l1.read();
                    String s="";
                    switch (i1) {
                        default:
                            s = (new StringBuilder("领取失败: ")).append(i1).toString();

                        case 24:
                            break;
                        case 25:
                            s = "已领取";
                            break;
                        case 26:
                            s = (new StringBuilder("领取失败: ")).append(i1).toString();
                            break;
                        case 27:
                            s = (new StringBuilder("领取失败: ")).append(i1).toString();
                            break;
                        case 28:
                            s = "领取失败";
                            break;
                    }
                    MainThread.sendLog("累计签到大礼包 %s", new Object[]{
                            s
                    });
                    int j1 = l1.readUnsignedShort();
                    while (i < j1) {
                        int i2 = l1.read();
                        int j2 = l1.read();
                        l1.skipBytes(12);
                        if (j2 != 7)
                            Log.i(b(), (new StringBuilder("GTAgot_")).append(i2).append(" = ").append(j2).toString());
                        i++;
                    }
                    return;
                case 0x970002://9895938:
                    i = l1.read();
                    l1.read();
                    l1.skipBytes(l1.readUnsignedShort() * 9);
                    if (i == 24) {
                        MainThread.sendLog("签到成功");
                        b(l1);
                        return;
                    }
                    if (i != 25) {
                        MainThread.sendLog("签到失败");
                        return;
                    }
                    break;
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.d.SignIn",e.getLocalizedMessage(),e);
        }
    }

    protected final String[] a()
    {
        return a;
    }

    private static final String a[] = {
        "ThreeAnniversarySignIn_", "get_player_sign_in_info", "get_sign_in_status", "player_sign_in", "exchange_tea_eggs"
    };

}