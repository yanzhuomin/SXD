// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:41
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.a;

import android.util.Log;

import web.sxd.b.*;

public final class ay extends BaseFunc
{

    public ay(MainThread c1)
    {
        super(c1, 0xa90000);
        b = 3;
        c = 4;
    }

    public static void a(MainThread c1) throws Exception
    {
        (new TempDataOutputStream(0xa90000)).sendMain(c1);
    }

    public final void a(TempDataInputStream l1)
    {
        try {


            super.a(l1);
            switch (l1.getFuncCode()) {
                default:
                    return;
                case 11075584:
                    l1.read();
                    if (l1.readUnsignedShort() == 10) {
                        (new TempDataOutputStream(0xa90006)).sendMain(C);
                        return;
                    }
                    break;
                case 11075585:
                case 11075586:
                case 11075587:
                case 11075588:
                    return;
                case 11075589:
                    web.sxd.b.MainThread.sendLog("[礼包]极限挑战终结宝箱领取成功");
                    return;
                case 11075590:
                    if (l1.readUnsignedShort() + l1.readUnsignedShort() > 0) {
                        (new TempDataOutputStream(0xa90005)).sendMain(C);
                        return;
                    }
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.a.ay",e.getLocalizedMessage(),e);
        }

    }

    protected final String[] a()
    {
        return a;
    }

    public static final String a[] = {
        "UNLIMITCHALLENGE_", "player_unlimit_challenge_info", "monster_deploy_info", "activate_war_addition", "start_challenge", "get_award", "get_end_award", "get_player_end_box_number"
    };
    int b;
    int c;

}