// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:46
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;
import web.sxd.b.*;

public final class d extends BaseFunc
{

    public d(MainThread c1)
    {
        super(c1, 0x440001);
        c = 0;
    }

    static void a(MainThread c1) throws Exception
    {
        if(c1.b(70))
            (new TempDataOutputStream(0x440001)).sendMain(c1);
    }

    public final void a(TempDataInputStream l1)
    {
        try {


            super.a(l1);
            switch (l1.getFuncCode()) {
                default:
                    return;
                case 4456449:
                    c = l1.readUnsignedShort();
                    String s = b();
                    int i = l1.readUnsignedShort();
                    int i1 = l1.readInt();
                    int i2 = l1.readUnsignedShort();
                    int l2 = l1.readUnsignedShort();
                    int j3 = l1.readUnsignedShort();
                    int l3 = l1.read();
                    int j4 = l1.read();
                    Log.d(s, String.format("DrawFish_[fame+%d,skill+%d,cul+%d,sp+%d,yp+%d],%d,#%d,%d %d times", new Object[]{
                            Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(l2), Integer.valueOf(j3), Integer.valueOf(l3), Integer.valueOf(j4), Integer.valueOf(l1.readInt()), Integer.valueOf(l1.readInt())
                    }));
                    if (j4 > 0 || c > 0)
                        web.sxd.b.MainThread.sendLog("　当前 %s 龙鱼, 还可画 %d 龙鱼", new Object[]{
                                b[j4], Integer.valueOf(c)
                        });
                    c();
                    if (i1 > 0 || j4 > 0) {
                        (new TempDataOutputStream(0x440004)).sendMain(C);
                        return;
                    }
                    if (l3 == 0 && c > 0) {
                        (new TempDataOutputStream(0x440002)).sendMain(C);
                        return;
                    }
                    break;
                case 4456450:
                    int j = l1.read();
                    if (j > 0) {
                        Log.i(b(), (new StringBuilder("FindImmortal_start_find_immortal failed: ")).append(j).toString());
                        return;
                    }
                    String s1 = b();
                    j = l1.readUnsignedShort();
                    int j1 = l1.readInt();
                    int j2 = l1.readUnsignedShort();
                    int i3 = l1.readUnsignedShort();
                    int k3 = l1.readUnsignedShort();
                    int i4 = l1.read();
                    int k4 = l1.read();
                    int l4 = l1.readUnsignedShort();
                    c = l4;
                    Log.d(s1, String.format("DrawFish_[fame+%d,skill+%d,cul+%d,sp+%d,yp+%d],%d,#%d,%d %d times", new Object[]{
                            Integer.valueOf(j), Integer.valueOf(j1), Integer.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(k3), Integer.valueOf(i4), Integer.valueOf(k4), Integer.valueOf(l4), Integer.valueOf(l1.readInt())
                    }));
                    if (k4 > 0 && k4 < 5) {
                        web.sxd.b.MainThread.sendLog("　画出 %s 龙鱼, 还可画 %d 龙鱼", new Object[]{
                                b[k4], Integer.valueOf(c)
                        });
                        c();
                        (new TempDataOutputStream(0x440004)).sendMain(C);
                        return;
                    }
                    return;
                case 4456451:
                    return;
                case 4456452:
                    int k = l1.read();
                    if (k > 0) {
                        Log.i(b(), (new StringBuilder("FindImmortal_pickup_award failed: ")).append(k).toString());
                        return;
                    }
                    k = l1.readUnsignedShort();
                    int k1;
                    int k2;
                    String s2;
                    if (k > 0) {
                        s2 = (new StringBuilder("声望+")).append(k).toString();
                        l1.readInt();
                    } else {
                        s2 = (new StringBuilder("阅历+")).append(l1.readInt()).toString();
                    }
                    k = l1.readUnsignedShort();
                    k1 = l1.readUnsignedShort();
                    k2 = l1.readUnsignedShort();
                    if (k1 > 0)
                        s2 = (new StringBuilder("境界点+")).append(k1).toString();
                    else if (k2 > 0)
                        s2 = (new StringBuilder("玉牌+")).append(k2).toString();
                    web.sxd.b.MainThread.sendLog("见好就收, %s, 仙令+%d 共%d", new Object[]{
                            s2, Integer.valueOf(k), Integer.valueOf(l1.readInt())
                    });
                    if (c > 0) {
                        c();
                        (new TempDataOutputStream(0x440002)).sendMain(C);
                        return;
                    } else {
                        sleep(5);
                        a(C);
                        return;
                    }
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.d.d",e.getLocalizedMessage(),e);
        }
    }

    protected final String[] a()
    {
        return a;
    }

    private static final String a[] = {
        "DrawFish_", "", "open_find_immortal", "start_find_immortal", "goad", "pickup_award", "get_xun_xian_ling_number", "exchange_xian_ling"
    };
    private static final String b[] = {
            "没有", "绿色", "蓝色", "紫色", "金色"
    };
    private int c;

}