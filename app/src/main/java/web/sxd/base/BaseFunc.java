// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:44
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.base;

import android.util.Log;

import java.util.HashMap;
import java.util.Random;

import web.sxd.Thread.MainThread;
import web.sxd.base.TempDataInputStream;

// Referenced classes of package web.sxd.b:
//            c, l

public abstract class BaseFunc implements BaseFuncImp
{

    protected static String FuncNamePrefix;
    protected static int FuncCodeH;
    protected static HashMap<Integer,String> funcList;//<funcCodeL,funcName>

    public BaseFunc(MainThread mainThread)
    {
        a = false;
        this.mainThread = mainThread;
        //C.a(i / 0x10000, this);
    }

    @Override
    public int GetFuncCodeH()
    {
        return FuncCodeH;
    }
    //public abstract void Progress(TempDataInputStream inputStream);

    //public abstract void messageCreate(int funcCode);
    //public void sendMessage(int funcCode)
//    {
//        messageCreate(funcCode);
//    }

    //protected abstract String[] a();

    protected final String getFuncNamePrefix()
    {
        return FuncNamePrefix;
    }


    protected final void d()
    {
        a = true;
    }

    //protected static Random D = new Random();
    protected MainThread mainThread;
    private boolean a;

}