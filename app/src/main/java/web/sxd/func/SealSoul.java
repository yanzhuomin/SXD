package web.sxd.func;

import java.io.IOException;
import java.util.HashMap;

import web.sxd.Thread.MainThread;
import web.sxd.base.TempDataOutputStream;
import web.sxd.base.BaseFunc;
import web.sxd.base.TempDataInputStream;

/**
 * Created by fdc on 2018-10-15.
 */

//灵石
public class SealSoul extends BaseFunc{

    public SealSoul(MainThread mainThread)
    {
        super(mainThread);
    }

    @Override
    public int Process(TempDataInputStream inputStream) {
        try {


            switch (inputStream.getFuncCode()) {
                case 0x220012:
                    int result = inputStream.read();
                    if (result == 1) {
                        MainThread.sendLog("　成功领取 %d 灵石", new Object[]{
                                Integer.valueOf(inputStream.readInt())
                        });
                        return 0;
                    }
                    else{
                        MainThread.sendLog("　领取灵石失败： %d ", new Object[]{
                                result});
                    }
            }
        }catch (Exception e)
        {

        }
        return 0;
    }

    @Override
    public void SendOpertaion(int funcCode) throws IOException {
        switch (funcCode)
        {
            case 0x220012:
                mainThread.sendMessage(new TempDataOutputStream(0x220012,0L));
                return;
        }
    }


    private static final String funcNames[] = {//灵石
            "SealSoul_","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","","get_day_stone"
    };
    static {//静态数据初始化
        FuncCodeH = 0x22;
        FuncNamePrefix = "SealSoul";
        funcList = new HashMap<Integer, String>();
        for (int i=0;i<funcNames.length;i++ ){
            funcList.put(i,funcNames[i]);
        }
    }


}
