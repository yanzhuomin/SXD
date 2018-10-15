// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:47
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.func;

import android.util.Log;

import java.io.IOException;
import java.util.HashMap;

import web.sxd.Thread.MainThread;
import web.sxd.base.BaseFunc;
import web.sxd.base.TempDataInputStream;
import web.sxd.base.TempDataOutputStream;

//Role  伙伴
public final class Role extends BaseFunc
{

    public Role(MainThread c1)
    {
        super(c1);//0x50007
    }

    @Override
    public final int Process(TempDataInputStream imputStream) {
        int funcCode = imputStream.getFuncCode();
        if ((funcCode == 0x50007)) return 0;
        try {
            switch (funcCode)
            {
                case 0x50008:
                    int j1 = imputStream.readUnsignedShort();
                    int i1 = 0;
                    do {
                        if (i1 >= j1) {
                        //    sleep(10);
                            mainThread.sendMessage(new TempDataOutputStream(0x80001, 132));//.sendMain(C);
                            return 0;
                        }
                        int k1 = imputStream.readInt();
                        int i2 = imputStream.readInt();
                        if (i2 == 35 || i2 == 62 || i2 == 70)
                            mainThread.d(k1);
                        i1++;
                    } while (true);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    @Override
    public void SendOpertaion(int funcCode) throws IOException {
        switch (funcCode)
        {
            case 0x50008:
                mainThread.sendMessage(new TempDataOutputStream(0x50008, mainThread.getPlayerID()));//.sendMain(C);
                return;
        }
        return;
    }


    private static final String funcNames[] = {
        "Role_", "", "", "", "", "", "", "exp_change_notify", "get_simple_role_list"
    };

    static {//静态数据初始化
        FuncCodeH = 5;
        FuncNamePrefix = "Role";
        funcList = new HashMap<Integer, String>();
        for (int i=0;i<funcNames.length;i++ ){
        funcList.put(i,funcNames[i]);
        }
    }


}