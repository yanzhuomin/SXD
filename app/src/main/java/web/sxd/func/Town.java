// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:45
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.func;

import android.media.MediaActionSound;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;

import web.sxd.base.BaseFunc;
import web.sxd.Thread.MainThread;
import web.sxd.base.MESSAGE_TAG;
import web.sxd.base.TempDataInputStream;
import web.sxd.base.TempDataOutputStream;
import web.sxd.base.Utils;

/*
* 城镇
* **/
public final class Town extends BaseFunc
{

    //static int FuncCodeH=1;
    public Town(MainThread c1)
    {
        super(c1);
    }

    static final int c(int j)
    {
        int k = (a.length + 12) - j / 5;
        if(k < a.length - 14)
        {
            j = k;
            if(k < 0)
                j = 0;
            return j;
        } else
        {
            return a.length - 2 - j / 10;
        }
    }

    static final String d(int j)
    {
        String s = e(j);
        return s.substring(0, s.indexOf('('));
    }

    public static final String e(int j)
    {
        int k;
        if(j < TownName.length && j>=0)
        {
            //Log.v("web.sxd.c.Town","城镇index:"+j);
            return TownName[j];
        }
        //Log.v("web.sxd.c.Town","城镇index:"+j);  //打印城镇索引
        return TownName[0];
    }

    @Override
    public final int Process(TempDataInputStream l1)
    {
        try {
            switch (l1.getFuncCode()) {
                default:
                    //super.a(l1);
                    return -1;
                case 0x10000:
                    int j = l1.read();
                    int k = l1.readInt();
                    if (k == mainThread.getPlayerID()) {
                        Log.i(getFuncNamePrefix(), (new StringBuilder("enter_town: ")).append(j).append(", self:").append(k).toString());
                        mainThread.setArg("Town_Enter_id",j);
                        return 0;
                    }
                case 0x10001:
                    if (l1.readInt() == mainThread.getPlayerID()) {
                        Log.i(getFuncNamePrefix(), "leave_town");
                        Utils.sleep(3);
                        //mainThread.l();
                        return 0;
                    }
                    return -1;
                case 0x10002:return 0;
                    //break;
            }
        }catch (Exception e)
        {
            Log.d("web.sxd.c.Town",e.getMessage());
        }
        return -1;
    }

    @Override
    public void SendOpertaion(int funcCode) throws IOException {


        switch (funcCode) {
            case 0x10000:
                if (mainThread.getArg("Town_Enter_id") == null) {
                    MainThread.sendLog(FuncNamePrefix +":"+  funcNames[0x10000%0x10000] + "Arg:" + "Town_Enter_id Not Found" );
                    return ;
                }
                TempDataOutputStream outputStream =new TempDataOutputStream(funcCode,
                        Integer.valueOf(mainThread.getArg("Town_Enter_id").toString()));
                outputStream.setMessageTag(MESSAGE_TAG.TAG_MAIN);
                mainThread.removArg("Town_Enter_id");
                mainThread.sendMessage(outputStream);
                return ;
                //break;
            case 0x10001:
                break;
            case 0x10002:
                break;
        }
        return ;

    }

//    protected final String[] a()
//    {
//        return c;
//    }

    static final int a[] = {
        76, 75, 73, 70, 68, 65, 62, 58, 56, 55, 
        54, 43, 40, 39, 35, 33, 29, 27, 26, 24, 
        23, 22, 21, 15, 14, 13, 9, 8, 7, 4, 
        3, 2, 1
    };
    private static final String TownName[] = {
            "未知", "亭林村(Lv1-10)", "姑苏城(Lv11-15)", "京城(Lv15-20)", "天剑宗(Lv20-30)", "昆仑(Lv20-30)", "未知06", "古道城(Lv30-40)", "玄霄宫(Lv40-50)", "雁门郡(Lv50-60)",
            "擎天木", "赤炎兽", "刀疤兔", "不归山(Lv60-70)", "扬州城(Lv70-80)", "月牙城(Lv80-90)", "集会所", "白虎殿帮派战", "玄武殿帮派战", "朱雀殿帮派战",
            "青龙殿帮派战", "逍遥城(Lv90-100)", "长安城(Lv100-110)", "太一城(Lv110-120)", "高丽城(Lv120-130)", "未知25", "魔都(Lv130-140)", "白鹿书院(Lv140-145)", "魔王试炼", "大理城(Lv145-150)",
            "未知30", "九空无界", "巅峰对决", "卧龙城(Lv150-155)", "中秋大冒险", "天庭(Lv155-160)", "封印妖魔", "狮王争霸", "圣诞树", "明镜城(Lv160-165)",
            "云中界(Lv165-170)", "仙界", "跨服BOSS", "海云台(Lv170-175)", "七夕鹊桥会", "爬塔90", "爬塔100", "爬塔110", "爬塔120", "爬塔130",
            "爬塔140", "爬塔150", "爬塔160", "爬塔170", "海市蜃楼(Lv176-180)", "天河镇(Lv181-185)", "神域(Lv186-190)", "王城争霸", "仙府(Lv191-195)", "仙盟集会所",
            "爬塔180", "爬塔190", "盘龙城(Lv196-200)", "结婚拜堂仪式", "家园住宅", "上古禁地(Lv201-205)", "仙盟攻城战", "占领", "帝苑(Lv206-210)", "夺宝奇兵",
            "凤凰城(Lv211-215)", "白泽", "青龙", "无妄之海(Lv216-220)", "地宫探宝", "天穹岭(Lv221-225)", "幻雪城(Lv226-230)", "游乐城", "圣域", "须弥山(Lv231-235)",
            "雪月湖(Lv236-240)","浮水湾(Lv241-245)"
    };
    private static final String funcNames[] = {
        "enter_town", "leave_town", "move_to"
    };

    static {//静态数据初始化
        FuncCodeH = 1;
        FuncNamePrefix = "Town";
        funcList = new HashMap<Integer, String>();
        for (int i=0;i<funcNames.length;i++ ){
            funcList.put(i,funcNames[i]);
        }
    }


    @Override
    public int GetFuncCodeH() {
        return FuncCodeH;
    }
}