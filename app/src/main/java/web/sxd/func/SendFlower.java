// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:45
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.func;

import android.util.Log;

import java.io.IOException;
import java.util.HashMap;

import web.sxd.Thread.MainThread;
import web.sxd.base.BaseFunc;
import web.sxd.base.MESSAGE_TAG;
import web.sxd.base.TempDataInputStream;
import web.sxd.base.TempDataOutputStream;

/**
 * 送花
 */
public final class SendFlower extends BaseFunc
{
    String a;
    public SendFlower(MainThread c1)
    {
        super(c1);
    }

    @Override
    public int Process(TempDataInputStream imputStream)
    {    try {


            int i;
            i = 0;
            switch (imputStream.getFuncCode()) {
                default:
                    return 0;
                case 0x1f0000://2031616:
                    imputStream.read();
                    imputStream.readInt();
                    imputStream.readUTF();
                    imputStream.readInt();
                    int j = imputStream.readInt();
                    imputStream.readUTF();
                    imputStream.readInt();
                    imputStream.readInt();
                    int k = imputStream.read();
                    int i1 = imputStream.readUnsignedShort();
                    while (i<i1){
//                        if (i >= i1) {
//                            if (k == 3 && j > 0) {
//                                mainThread.sendMessage(new TempDataOutputStream(0x1f0001, j, 1));
//                                return 0;
//                            }
//                            continue; /* Loop/switch isn't completed */
//                        }
                        j = imputStream.readInt();
                        a = imputStream.readUTF();

                        imputStream.readInt();
                        imputStream.readInt();
                        imputStream.readInt();
                        //mainThread.sendLog("index:"+i+"ID:"+j+"Name:"+a);
                        i++;
                    }
                    if (k == 3 && j > 0) {
                        mainThread.sendMessage(new TempDataOutputStream(0x1f0001, j, 1));
                        return 0;
                    }
                    else if(k == 4) {
                        MainThread.sendLog("[送花]失败：次数不足");
                        return 0;
                    }
                case 0x1F0001://2031617:
                    int reslut = imputStream.read();
                    if (reslut == 0) {
                        MainThread.sendLog("[送花]送给 %s [1朵鲜花]", new Object[]{
                                a
                        });
                        return 0;
                    }else
                    {
                        MainThread.sendLog("[送花]送给 %s  失败 result: %d",new Object[]{a,reslut});
                    }
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.c.SendFlower",e.getLocalizedMessage(),e);
        }
        return 0;
    }

    @Override
    public void SendOpertaion(int funcCode) throws IOException {
        switch (funcCode)
        {
            case 0x1f0000:
                TempDataOutputStream out = new TempDataOutputStream(funcCode,mainThread.getPlayerID())
                        .setMessageTag(MESSAGE_TAG.TAG_MAIN);
                mainThread.sendMessage(out);
                return;
        }
    }


    private static final String FuncNames[] = {
        "SendFlower_", "player_send_flower_info", "send_player_flower"
    };

    static {
        FuncCodeH = 0x1F;
        FuncNamePrefix = "SendFlower";
        funcList = new HashMap<Integer, String>();
        for (int i=0;i<FuncNames.length;i++ ){
            funcList.put(i,FuncNames[i]);
        }
    }

}