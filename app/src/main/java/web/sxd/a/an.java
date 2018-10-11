// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:40
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.a;

import android.util.Log;

import web.sxd.b.*;

//自定义挑战
public final class an extends BaseFunc
{

    public an(MainThread c1)
    {
        super(c1, 0x880001);
    }

    public static void a(MainThread c1)throws Exception
    {
        (new TempDataOutputStream(0x880001)).sendMain(c1);
    }

    public final void a(TempDataInputStream l1)
    {
        try {
            super.a(l1);
            switch (l1.getFuncCode())
            {
                default :return;
                case 8912897 :
                    l1.readUnsignedShort();
                    (new TempDataOutputStream(0x88000a)).sendMain(C);
                    return;
                case 8912898 : return;
                case 8912899 : return;
                case 8912900 : return;
                case 8912901 : return;
                case 8912902 : return;
                case 8912903 : return;
                case 8912904 : return;
                case 8912905 : return;
                case 8912906 :
                    int i = l1.readInt();
                    int k = l1.readUnsignedShort();
                    int j1 = l1.readUnsignedShort();
                    if(i > 0 || k > 0 || j1 > 0)
                    {
                        (new TempDataOutputStream(0x880014)).sendMain(C);
                        return;
                    }
                    return;
                case 8912907 : return;
                case 8912908 : return;
                case 8912909 : return;
                case 8912910 : return;
                case 8912911 : return;
                case 8912912 : return;
                case 8912913 : return;
                case 8912914 : return;
                case 8912915 : return;
                case 8912916 :
                    int j = l1.read();
                    int i1 = l1.readInt();
                    int k1 = l1.readUnsignedShort();
                    int i2 = l1.readUnsignedShort();
                    if(j == 10)
                        MainThread.sendLog("[礼包]领取 自定义挑战 终结礼包  %d万 铜钱, %d 道缘, %d 声望  ", new Object[] {
                                Integer.valueOf(i1 / 10000), Integer.valueOf(k1), Integer.valueOf(i2)
                        });
                    C.a(106);
                    return;
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.a.an",e.getLocalizedMessage(),e);
        }
    }

    protected final String[] a()
    {
        return a;
    }

    public static final String a[] = {
        "STCHALLENGE_", "", "get_player_st_challenge_info", "customizing_info", "choose_difficult_type", "choose_war_change", "change_monster_deploy", "change_stunt", "change_supernatural", "start_challenge", 
        "get_award", "get_end_li_bao_info", "", "", "", "", "", "", "", "", 
        "", "get_end_li_bao"
    };

}