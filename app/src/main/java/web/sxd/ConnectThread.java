// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:37
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3)

package web.sxd;

import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import web.sxd.b.MainThread;
import web.sxd.b.TempDataOutputStream;

// Referenced classes of package web.sxd:
//            LoginAct

final class ConnectThread extends  Thread
{

    ConnectThread(LoginAct loginact)
    {
        super();
        a = loginact;
    }

    public final void run()
    {
        TempDataOutputStream m1;
        try
        {
            LoginAct.setSocket(a, new Socket(a.textView_ip.getText().toString(), Integer.valueOf(a.textView_port.getText().toString()).intValue()));
            if(!LoginAct.getSocket(a).isConnected())
            {
                Toast.makeText(a.a, "登录失败", Toast.LENGTH_SHORT).show();
                LoginAct.setSocket(a, null);
                a.button_login.setEnabled(true);
                return;
            }

            a.j.append("尝试登录");
            BufferedOutputStream bos = new BufferedOutputStream(LoginAct.getSocket(a).getOutputStream());
            m1 = new TempDataOutputStream(0);
            m1.writeUTF(a.textView_playerName.getText().toString());
            m1.writeUTF(LoginAct.getHasCode(a));
            m1.writeUTF(LoginAct.getNowTime(a));
            m1.writeUTF("");
            m1.writeInt(LoginAct.getRegDate(a));
            m1.writeUTF("");
            m1.writeInt(LoginAct.getOpenTime(a));
            m1.writeByte(LoginAct.getNewst(a));
            m1.writeUTF(LoginAct.getStage(a));
            if(LoginAct.getCurVer(a).compareTo("20130802") > 0)
                m1.writeUTF(LoginAct.getClient(a));
            m1.send(0, bos, 0);

            LoginAct.setMainThread(a, new MainThread(LoginAct.getCurVer(a), LoginAct.getSocket(a).getInputStream(), bos));
            new web.sxd.d.m(LoginAct.getMainThread(a));
            a.button_login.setText("停止");
            a.button_login.setEnabled(false);
            //a.c.setVisibility(0);
            //a.d.setVisibility(8);
            LoginAct.l(a);
            LoginAct.m = true;
        }
        catch(IOException ie)
        {
            Log.e("LoginAct", ((Exception) (ie)).getLocalizedMessage(), ((Throwable) (ie)));
            a.j.append("登录失败, ");
            if(((Exception) (ie)).getMessage().equals("Connection timed out"))
                a.j.append("连接超时");
            else
                a.j.append(((Exception) (ie)).getMessage());
            a.button_login.setText("登陆");
            a.button_login.setEnabled(true);
            return;
        }

        if(LoginAct.getSocket(a).isClosed())
        {
            Toast.makeText(a.a, "登录失败", Toast.LENGTH_SHORT).show();
            LoginAct.setSocket(a, null);
            a.button_login.setText("登陆");
            a.button_login.setEnabled(true);
            return;
        }

        return;
    }

    final LoginAct a;
}