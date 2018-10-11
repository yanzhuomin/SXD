// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:39
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.a;

import android.util.Log;

import web.sxd.b.*;

public final class ab extends BaseFunc
{

    public ab(MainThread c1)
    {
        super(c1, 0x13a000c);
    }

    public static void a(MainThread c1) throws Exception
    {
        (new TempDataOutputStream(0x13a000c)).sendMain(c1);
        c();
        (new TempDataOutputStream(0x13a0000)).sendMain(c1);
    }

    public final void a(TempDataInputStream l1)
    {
        try {
            super.a(l1);
            switch (l1.getFuncCode())
            {
                default : return;
                case 20578304 :
                    l1.read();
                    l1.readInt();
                    if(l1.readInt() > 0)
                    {
                        (new TempDataOutputStream(0x13a0001)).sendMain(C);
                        return;
                    } else
                    {
                        MainThread.sendLog("[劫镖]今日已完成");
                        return;
                    }
                case 20578305 :
                    l1.skipBytes(l1.readUnsignedShort() * 4);
                    if(l1.read() == 5)
                    {
                        a(5);
                        (new TempDataOutputStream(0x13a0005)).sendMain(C);
                        return;
                    }
                    break;
                case 20578306 :
                    if(l1.read() == 5)
                    {
                        int i;
                        int j1;
                        MainThread.sendLog("[劫镖]成功");
                        j1 = l1.readUnsignedShort();
                        i = 0;
                        while (i < j1)
                        {
                            int i2 = l1.readInt();
                            int k2 = l1.readInt();
                            if(i2 == 1747)
                                MainThread.sendLog("[劫镖]获得%d万铜钱", new Object[] {
                                        Integer.valueOf(k2 / 10000)
                                });
                            i++;
                        }
                    }
                    (new TempDataOutputStream(0x13a000d)).sendMain(C);
                    return;
                case 20578307 : return;
                case 20578308 : return;
                case 20578309 :
                    int k1 = l1.readUnsignedShort();
                    if(k1 > 0)
                    {
                        int j = 0;
                        while(j < k1)
                        {
                            int j2 = l1.readInt();
                            String s = l1.readUTF();
                            l1.readUnsignedShort();
                            l1.readInt();
                            (new TempDataOutputStream(0x13a0006, j2)).sendMain(C);
                            MainThread.sendLog("[劫镖]邀请好友: %s", new Object[] {
                                    s
                            });
                            j++;
                        }
                    } else
                    {
                        MainThread.sendLog("[劫镖]无好友在线,尝试劫镖");
                        (new TempDataOutputStream(0x13a0002)).sendMain(C);
                        return;
                    }
                    return;
                case 20578310 : return;
                case 20578311 : return;
                case 20578312 : return;
                case 20578313 :
                    int k = l1.readInt();
                    c();
                    (new TempDataOutputStream(0x13a0007, k)).sendMain(C);
                    return;
                case 20578314 :
                    int i1 = l1.readInt();
                    l1.readInt();
                    l1.readUTF();
                    if(i1 == 5)
                    {
                        c();
                        (new TempDataOutputStream(0x13a0002)).sendMain(C);
                        return;
                    }
                    return;
                case 20578315 : return;
                case 20578316 : return;
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.a.ab",e.getLocalizedMessage(),e);
        }

    }

    protected final String[] a()
    {
        return a;
    }

    private static final String a[] = {
        "NineRigions_", "get_rob_money_info", "search", "rob", "buy_rob_times", "notify_refresh_ship", "friend_list", "apply_friend", "approve_apply", "reject_apply", 
        "notify_apply", "notify_be_apply", "notify_activity_status", "open_panel", "close_panel"
    };

}