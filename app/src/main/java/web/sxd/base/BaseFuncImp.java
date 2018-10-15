package web.sxd.base;

import android.os.Message;

import java.io.IOException;
import java.util.HashMap;

import web.sxd.b.MainThread;

/**
 * Created by fdc on 2018-10-13.
 */

public interface BaseFuncImp {


    public int GetFuncCodeH(); //获取功能码
    public int Process(TempDataInputStream imputStream);//处理消息
    public void SendOpertaion(int funcCode) throws IOException;//发送操作

}
