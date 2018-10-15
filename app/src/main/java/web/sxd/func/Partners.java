package web.sxd.func;

import android.util.Log;

import java.io.IOException;
import java.util.HashMap;

import web.sxd.Thread.MainThread;
import web.sxd.base.BaseFunc;
import web.sxd.base.TempDataInputStream;

/**
 * Created by fdc on 2018-10-15.
 */


//招募伙伴
public final class Partners  extends BaseFunc
{

    public Partners(MainThread mainThread)
    {
        super(mainThread);
    }


    @Override
    public int Process(TempDataInputStream inputStream) {
        try {

            int i1=0;
            switch (inputStream.getFuncCode()) {
                case 0x80001:
                    i1 = inputStream.read();
                    if (i1 >= 6) {
                        String str1 = FuncNamePrefix;
                        StringBuilder stringbuilder = new StringBuilder("Partners_invite: ");
                        String str5;
                        if (i1 - 6 < k.length)
                            str5 = k[i1 - 6];
                        else
                            str5 = Integer.valueOf(i1).toString();
                        //Log.i(str1, stringbuilder.append(inputStream).toString());
                        return 0;
                    } else {
                        Log.i(FuncNamePrefix, (new StringBuilder("Partners_invite: ")).append(i1).toString());
                        return 0;
                    }
            }
        }catch (Exception e)
        {

        }
        return 0;
    }

    @Override
    public void SendOpertaion(int funcCode) throws IOException {

    }

    private String k[] = {
            "招募成功", "招募失败", "铜钱不足", "声望不足", "队伍已满", "NOTCHANGE", "NO_ENOUGH_PIECES", "伙伴碎片不足", "主角等级不到", "STAGE_COMPLETE",
            "INSUFFICIENT_KEY"
    };

    private static final String funcNames[] = {
            "Partners_", "partners_invite"
    };

    static {//静态数据初始化
        FuncCodeH = 8;
        FuncNamePrefix = "Partners";
        funcList = new HashMap<Integer, String>();
        for (int i=0;i<funcNames.length;i++ ){
            funcList.put(i,funcNames[i]);
        }
    }

}
