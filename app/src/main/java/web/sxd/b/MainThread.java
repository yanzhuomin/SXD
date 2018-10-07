// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:43
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3)

package web.sxd.b;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.*;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.*;

// Referenced classes of package web.sxd.b:
//            SYSocket, l, QWSocket, XJSocket,
//            XJOutputStream, runState, valueMap, e,
//            b, namePrefixMap

public final class MainThread extends Thread {


    private static long AllStatistics = 0L;//本进程总流量
    private static long XJStatistics = 0L;//仙界流量
    private static long SYStatistics = 0L;//圣域流量
    private static long QWStatistics = 0L;//全网流量
    private static Handler uiHandler;//UI线程的Handler 发消息给UI时使用
    private static boolean iniReadFailed;  //ini配置文件读取失败标志  失败为true
    /**<value,j>*/
    private static HashMap valueMap = new HashMap();  //<value,j> 读取配置 获取j对象 放入
    /**<namePrefix,i>*/
    private static HashMap namePrefixMap = new HashMap();  //<namePrefix,i>读取配置生成i对象 放入 重复不放入
    private static boolean funcSelect[] = new boolean[320];//功能选择
    private String A;//角色名称
    private String B;
    private int C;
    private int D;//角色等级
    private int E;//元宝个数
    private int F;//铜钱(w)
    private int G;
    private int H;
    private int I;//体力
    private int J;
    private int K;
    private int L;
    private long M;//角色当前等级经验
    private long N;//角色当前等级的最大经验
    public boolean a;
    private boolean runState;//运行状态 线程判断标志
    //private HashMap e; /**<value,j>  web.sxd.runState.*类中定义的  **/
    private Socket XJSocket;//仙界
    private Socket SYSocket;//圣域
    private Socket QWSocket;//全网
    private InputStream mainInputStream;  //主界面
    private OutputStream mainOutputStream; //主界面
    private OutputStream XJOutputStream;//仙界
    private OutputStream SYOutputStream;//圣域
    private OutputStream QWOutputStream;//全网
    private boolean p[];
    private boolean q[];
    private String s[][][];
    private HashMap t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;



    public MainThread(String s1, InputStream inputstream, OutputStream outputstream)
    {
        p = new boolean[320];
        q = new boolean[320];
        s = (String[][][])Array.newInstance(String.class/*java/lang/String*/, new int[] {
            255, 10, 2
        });
        t = new HashMap();
        w = -1;
        B = null;
        K = 0;
        L = 0;
        N = 0x7fffffffL;
        mainInputStream = inputstream;
        mainOutputStream = outputstream;
        XJSocket = null;
        XJOutputStream = null;
        SYSocket = null;
        SYOutputStream = null;
        boolean flag;
        if(s1.compareTo("20131129") > 0)
            flag = true;
        else
            flag = false;
        a = flag;
        //e = new HashMap();
        runState = true;
    }

    public static void sendLog(int i1, int j1)
    {
        sendLog(1, i1, j1, null);
    }

    public static void sendLog(int i1, int j1, int k1, Object obj)
    {
        Message message = new Message();
        message.what = i1;
        message.obj = obj;
        message.arg1 = j1;
        message.arg2 = k1;
        uiHandler.sendMessage(message);
    }

    public static void sendLog(int i1, Object obj)
    {
        Message message = new Message();
        message.what = i1;
        message.obj = obj;
        message.arg2 = 0;
        message.arg1 = 0;
        uiHandler.sendMessage(message);
    }

    public static void setHandler(Handler handler)
    {
        uiHandler = handler;
        namePrefixMap.clear();
        valueMap.clear();
        iniReadFailed = false;
    }

    // ini配置文件读取
    public static void iniRead(InputStream inputstream) throws IOException
    {
        BufferedReader bufferedreader;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        if(!bufferedreader.ready())
        {
            bufferedreader.close();
            return;
        }
        do {
            String str = bufferedreader.readLine();
            if(str == null) break;
            if(str.length() == 0 || str.charAt(0) == ';') //忽略空行和注释行
            {}else
            {
                int i1;
                int k1 = str.indexOf(',');
                i1 = k1;
                if(k1 < 0)
                    i1 = str.indexOf('=');
                if(i1 <= 0)
                {
                    Log.v("PktThread", (new StringBuilder("',' or '=' not found in protocol line: ")).append(inputstream).toString());
                }else
                {
                    String name;
                    String valueStr;
                    /*  eg:    Player_player_ui_list,70
                        name        =   Player_player_ui_list
                        value       =   70
                        namePrefix  =   Player_
                    */
                    name = str.substring(0, i1);
                    valueStr = str.substring(i1 + 1);
                    i1 = name.indexOf('_');
                    if(i1 <= 0)
                    {
                        Log.v("PktThread", (new StringBuilder(String.valueOf(name))).append(" protocol with invalid code ").append(valueStr).toString());
                    }else
                    {
                        int value;
                        i j2;
                        String namePrefix;
                        namePrefix = name.substring(0, i1 + 1);
                        value = Integer.valueOf(valueStr); //字符串转Int
                        j2 = (i) namePrefixMap.get(namePrefix);
                        if(j2 != null)
                            break ;
                        j2 = new i(value / 0x10000, namePrefix);
                        namePrefixMap.put(namePrefix, j2);
                        valueMap.put(value, j2.addConfig(name.substring(i1 + 1), value % 0x10000));
                    }
                }
            }
        }while(bufferedreader.ready());
        bufferedreader.close();
        Iterator value = namePrefixMap.values().iterator();
        do{
            if(!value.hasNext())
            {
                iniReadFailed = true;
                return;
            }
            i k2 = (i)value.next();
            int j1 = k2.getFuncCodeH() * 0x10000;
            if(j1 > 0 && !valueMap.containsKey(j1))
                valueMap.put(j1, k2.addConfig("?", -1));
        }while (true);
    }

    public static void sendLog(Object obj)
    {
        sendLog(0, obj);
    }

    public static void sendLog(String s1, Object aobj[])
    {
        sendLog(0, String.format(s1, aobj));
    }



    public static void setFuncSelect(int i1, boolean flag)
    {
        if(i1 < 320 && i1 >= 0)
            funcSelect[i1] = flag;
    }

    //解析接收的消息
    public static void processReceive(TempDataInputStream inputStream)
    {
        j j2 = (j) valueMap.get(Integer.valueOf(inputStream.getFuncCode()));
        j j1 = j2;
        if(j2 == null)
            j1 = (j) valueMap.get(Integer.valueOf(inputStream.getFuncCodeH() * 0x10000));
        if(j1 == null)
        {
            Log.i("PktThread", (new StringBuilder("Unknown: ")).append(inputStream.getFuncCodeH()).append("_").append(inputStream.getFuncCodeL()).toString());
            return;
        } else
        {
            j1.a(inputStream);
            return;
        }
    }

    static boolean b(MainThread c1)
    {
        return c1.runState;
    }



    public static boolean isFuncSelect(int i1)
    {
        return i1 < 320 && i1 >= 0 && funcSelect[i1];
    }


    //设置仙界Socket
    static Socket getXJSocket(MainThread c1)
    {
        return c1.XJSocket;
    }
    static void clearXJSocket(MainThread c1)
    {
        c1.XJSocket = null;
    }
    //设置圣域Socket
    static Socket getSYSocket(MainThread c1)
    {
        return c1.SYSocket;
    }
    static void clearSYSocket(MainThread c1)
    {
        c1.SYSocket = null;
    }
    //设置全网Socket
    static Socket getQWSocket(MainThread c1)
    {
        return c1.QWSocket;
    }
    static void clearQWSocket(MainThread c1)
    {
        c1.QWSocket = null;
    }



//    public static void mainInputStream()
//    {
//    }

    //获取仙界流量
    static long getXJStatistics()
    {
        return XJStatistics;
    }
    //设置仙界流量
    static void setXJStatistics(long l1)
    {
        XJStatistics = l1;
    }

    //获取圣域流量
    static long getSYStatistics()
    {
        return SYStatistics;
    }
    //设置圣域流量
    static void setSYStatistics(long l1)
    {
        SYStatistics = l1;
    }

    //获取全网流量
    static long getQWStatistics()
    {
        return QWStatistics;
    }
    //设置全网流量
    static void setQWStatistics(long l1)
    {
        QWStatistics = l1;
    }

    public final int a()
    {
        return u;
    }

    public final void a(int i1)
    {
        if(i1 < 320 && i1 >= 0)
            q[i1] = true;
    }

    public final void a(int i1, int j1, int k1)
    {
        if(C == i1)
        {
            G = j1;
            H = k1;
        }
    }

    public final void a(int i1, BaseFunc h1)
    {
        addFunc(i1, h1.a(), h1);
    }
    /**
     * 发送数据到服务器
     * @param j1 类型 ： 主界面：0   仙界：1  圣域：2 全网：3
     *
     */
    public final void send(int funcCode, TempDataOutputStream m1, int j1) //throws  Exception
    {
        OutputStream out;
//        this;
//        JVM INSTR monitorenter ;
        synchronized (this)
        {
            if(j1 == 1){
                if(XJOutputStream == null){
                    Log.e("PacketOS", "[仙界]连接未建立");
                    return;
                }
                out = XJOutputStream;

            }else if(j1 == 2){
                if(SYOutputStream == null){
                    Log.e("PacketOS", "[圣域]连接未建立");
                    return;
                }
                out = SYOutputStream;
            }else if(j1 == 3){
                if(QWOutputStream == null){
                    Log.e("PacketOS", "[全网]连接未建立");
                    return;
                }
                out = QWOutputStream;

            }else
            {
                out = mainOutputStream;
            }
            //j j2 =    (j)e.get(Integer.valueOf(funcCode));
            j j2 =    (j)valueMap.get(Integer.valueOf(funcCode));
            if(j2 == null)
            {
                Log.i("PacketOS", (new StringBuilder("UnSent: ")).append(funcCode / 0x10000).append("_").append(funcCode % 0x10000).toString());
                Log.v("PacketOS", (new StringBuilder()).append(j2).append("(").append(((j) (j2)).getFuncCodeL()).append(")").toString());
                Log.i("PacketOS", (new StringBuilder()).append(j2).append("(").append(((j) (j2)).getFuncCodeL()).append(") unSent").toString());
                Log.i("PacketOS", (new StringBuilder("UnRegFunc sends: ")).append(funcCode / 0x10000).append("_").append(funcCode % 0x10000).toString());
                return;
            }
            funcCode = j2.parent.getFuncCode(j2);
            try {
                m1.send(funcCode, out, j1);//信息发送 init
            }catch (IOException e)
            {

            }

        }
//        Log.i("PacketOS", (new StringBuilder("UnSent: ")).append(i1 / 0x10000).append("_").append(i1 % 0x10000).toString());
//        Log.v("PacketOS", (new StringBuilder()).append(j2).append("(").append(((j) (j2)).getFuncCodeL()).append(")").toString());
//        Log.i("PacketOS", (new StringBuilder()).append(j2).append("(").append(((j) (j2)).getFuncCodeL()).append(") unSent").toString());
//        Log.i("PacketOS", (new StringBuilder("UnRegFunc sends: ")).append(i1 / 0x10000).append("_").append(i1 % 0x10000).toString());


//_L4:
//        this;
//        JVM INSTR monitorexit ;
//        return;
//
//
//
//        if(i1 < 0x10000)
//            break MISSING_BLOCK_LABEL_94;
//        if(iniReadFailed)
//            break MISSING_BLOCK_LABEL_203;
//        if(!runState)
//            break MISSING_BLOCK_LABEL_160;
//        if(j1 != 3) goto _L6; else goto _L5
//_L5:
//        Object obj = QWOutputStream;
//_L7:
//        m1.a(i1, ((OutputStream) (obj)), j1);
//          goto _L4
//_L6:
//        if(j1 != 2)
//            break MISSING_BLOCK_LABEL_137;
//        obj = SYOutputStream;
//          goto _L7
//        if(j1 != 1)
//            break MISSING_BLOCK_LABEL_151;
//        obj = XJOutputStream;
//          goto _L7
//        obj = mainOutputStream;
//          goto _L7
//        Log.i("PacketOS", (new StringBuilder("UnSent: ")).append(i1 / 0x10000).append("_").append(i1 % 0x10000).toString());
//          goto _L4
//        obj = (j)e.get(Integer.valueOf(i1));
//        if(obj == null)
//            break MISSING_BLOCK_LABEL_388;
//        if(!runState)
//            break MISSING_BLOCK_LABEL_343;
//        Log.v("PacketOS", (new StringBuilder()).append(obj).append("(").append(((j) (obj)).a()).append(")").toString());
//        i1 = ((j) (obj)).parent.a(((j) (obj)));
//        if(j1 != 3) goto _L9; else goto _L8
//_L8:
//        obj = QWOutputStream;
//_L10:
//        m1.a(i1, ((OutputStream) (obj)), j1);
//          goto _L4
//_L9:
//        if(j1 != 2)
//            break MISSING_BLOCK_LABEL_320;
//        obj = SYOutputStream;
//          goto _L10
//        if(j1 != 1)
//            break MISSING_BLOCK_LABEL_334;
//        obj = XJOutputStream;
//          goto _L10
//        obj = mainOutputStream;
//          goto _L10
//        Log.i("PacketOS", (new StringBuilder()).append(obj).append("(").append(((j) (obj)).a()).append(") unSent").toString());
//          goto _L4
//        Log.i("PacketOS", (new StringBuilder("UnRegFunc sends: ")).append(i1 / 0x10000).append("_").append(i1 % 0x10000).toString());
//          goto _L4
    }

    public final void a(int i1, boolean flag)
    {
        if(i1 < 320 && i1 >= 0)
            p[i1] = flag;
    }


    //将as中列出的功能添加到HashMap中  valueH  是功能码的高两个字节
    public final void addFunc(int valueH, String funcName[], BaseFunc h1)
    {
        boolean flag;
        boolean flag1;
        i l1;
        flag1 = true;
        flag = true;
        l1 = (i) namePrefixMap.get(funcName[0]);
        if(!iniReadFailed || l1 == null)
        {
            if(iniReadFailed || l1 != null)
            {
                return;
            }else   //ini加载失败的话
            {
                i i2 = new i(valueH, funcName[0]);
                namePrefixMap.put(funcName[0], i2);
                i2.a(valueH, h1);
                int index = ((flag1) ? 1 : 0);
                if(valueH == 0)
                {
                    valueMap.put(Integer.valueOf(0), i2.addConfig("Login", 0));
                    i2.setChildValue("Login", 0);
                    //return;
                }
                for(; index < funcName.length; index++)
                    if(funcName[index].length() > 0)
                    {
                        j j1 = i2.addConfig(funcName[index], index - 1);
                        int value = i2.getFuncCode(j1);
                        Log.v("PktThread", (new StringBuilder(String.valueOf(funcName[0]))).append(funcName[index]).append("(").append(value / 0x10000).append("_").append(valueH % 0x10000).append(")").toString());
                        valueMap.put(Integer.valueOf(value), j1);
                        i2.setChildValue(funcName[index], index - 1);
                    }

                return;
            }
        }else{//ini加载成功的话
            l1.a(valueH, h1);// valueH = valueH  类中的value
            int index = ((flag) ? 1 : 0);
            while ((index < funcName.length)){
                if (funcName[index].length() != 0) {
                        j j1 = l1.setChildValue(funcName[index], index - 1);
                        if (j1 != null) {
                            int j2 = j1.getFuncCode();
                            //e.put(Integer.valueOf(j2), j1);
                            valueMap.put(Integer.valueOf(j2), j1);
                        } else {
                            Log.e("PktThread", (new StringBuilder(String.valueOf(funcName[0]))).append(funcName[index]).toString());
                        }
                }
                index++;

            }

        }
    }

    public final void a(long l1)
    {
        if(l1 < 20000L)
        {
            int i1;
            if(l1 > 0L)
                i1 = 1;
            else
                i1 = 0;
            F = i1;
        } else
        {
            l1 /= 10000L;
            if(l1 < 0x7fffffffL)
            {
                F = (int)l1;
                return;
            }
        }
    }

    public final void a(String s1, int i1, int j1, int k1)
    {
        A = s1;
        D = i1;
        E = j1;
        F = k1;
    }

    public final void a(BaseFunc h1)
    {
        if(h1 != null)
        {
            BaseFunc h2 = (BaseFunc)t.put(h1.getClass(), h1);
            if(h2 != null && !h2.equals(h1))
                h2.d();
        }
    }

    public final void a(TempDataInputStream l1) throws IOException
    {
        l1.skipBytes(20);
        u = l1.readInt();
        v = l1.readInt();
        l1.read();
        y = l1.readInt();
        l1.skipBytes(16);
        l1.read();
        x = l1.readInt();
        z = l1.readInt();
        Log.i("PktThread", (new StringBuilder(String.valueOf(u))).append(",").append(v).append(" ").append(y).append(",").append(z).append(" ").append(x).toString());
    }

    public final boolean a(String s1)
    {
        return s1.equals(B);
    }


    //仙界连接(应该是聊天)
    public final boolean a(String ip, int port, String s2, int j1, String s3)
    {
        if(XJSocket != null)
        {
            if(XJSocket.isConnected() && !XJSocket.isClosed())
                return true;
            XJSocket = null;
        }
        if(port == 0)
        {
            sendLog(0, "[仙界]当前未开放");
            return false;
        }
        try {
            XJSocket = new Socket(ip, port);
            if (!XJSocket.isConnected()) {
                //break MISSING_BLOCK_LABEL_84;
                sendLog(0, "[仙界]无法建立连接");
                XJSocket = null;
                return false;
            }
            B = s2;
            Log.i("PktThread", (new StringBuilder("[仙界]尝试登录 ")).append(B).toString());
            XJOutputStream = new BufferedOutputStream(XJSocket.getOutputStream());
            TempDataOutputStream out = new TempDataOutputStream(0x5e0000);
            out.writeUTF(s2);
            out.writeInt(C);
            out.writeUTF(A);
            out.writeInt(j1);
            out.writeUTF(s3);
            out.send(0x5e0000, XJOutputStream, 1);
            if (XJSocket.isClosed()) {
                //break MISSING_BLOCK_LABEL_217;
                Log.i("PktThread", "[仙界]连接已中断");
                XJSocket = null;
                return false;
            }
        }catch (Exception e)
        {
            Log.e("PktThread", e.getLocalizedMessage(), e);
            sendLog(0, "[仙界]连接已中断");
            XJSocket = null;
            return false;
        }
        try
        {
            (new SJChatThread(this, XJSocket.getInputStream())).start();
        }
        // Misplaced declaration of an exception variable
        catch(Exception e)
        {
            Log.e("PktThread", e.getLocalizedMessage(), e);
            sendLog(0, "[仙界] -_- 跨服连接失败");
            XJSocket = null;
            return false;
        }
        return true;
    }

    //全网(应该是聊天)
    public final boolean a(String ip, int port, String s2, String s3, String s4, int j1, String s5)
    {
        if(QWSocket != null)
        {
            if(QWSocket.isConnected() && !QWSocket.isClosed())
                return true;
            QWSocket = null;
        }
        if(port == 0)
        {
            sendLog(0, "[全网]当前未开放");
            return false;
        }
        try {
            QWSocket = new Socket(ip, port);
            if (!QWSocket.isConnected()) {
                //break MISSING_BLOCK_LABEL_84;
                sendLog(0, "[全网]无法建立连接");
                QWSocket = null;
                return false;
            }
            B = s3;
            Log.i("PktThread", (new StringBuilder("[全网]尝试登录 ")).append(B).toString());
            QWOutputStream = new BufferedOutputStream(QWSocket.getOutputStream());
            TempDataOutputStream out = new TempDataOutputStream(0x150000c);
            out.writeUTF(s2);
            out.writeInt(C);
            out.writeUTF(s3);
            out.writeUTF(s4);
            out.writeInt(j1);
            out.writeUTF(s5);
            out.send(0x150000c, QWOutputStream, 3);
            if (!QWSocket.isClosed()) {
                //break MISSING_BLOCK_LABEL_222;
                Log.i("PktThread", "[全网]连接已中断");
                QWSocket = null;
                return false;
            }
        }catch (Exception e)
        {
            Log.e("PktThread", e.getLocalizedMessage(), e);
            sendLog(0, "[全网]连接已中断");
            QWSocket = null;
            return false;
        }
        try
        {
            (new QWChatThread(this, QWSocket.getInputStream())).start();
        }
        // Misplaced declaration of an exception variable
        catch(Exception e)
        {
            Log.e("PktThread", e.getLocalizedMessage(), e);
            sendLog(0, "[全网] -_- 跨服连接失败");
            QWSocket = null;
            return false;
        }
        return true;
    }

    //圣域(应该是聊天)
    public final boolean b(String ip, int port, String s2, int j1, String s3)
    {
        if(SYSocket != null)
        {
            if(SYSocket.isConnected() && !SYSocket.isClosed())
                return true;
            SYSocket = null;
        }
        if(port == 0)
        {
            sendLog(0, "[圣域]当前未开放");
            return false;
        }
        try {
            SYSocket = new Socket(ip, port);
            if (!SYSocket.isConnected()) {
                //break MISSING_BLOCK_LABEL_84;
                sendLog(0, "[圣域]无法建立连接");
                SYSocket = null;
                return false;
            }
            B = s2;
            Log.i("PktThread", (new StringBuilder("[圣域]尝试登录 ")).append(B).toString());
            SYOutputStream = new BufferedOutputStream(SYSocket.getOutputStream());
            TempDataOutputStream out = new TempDataOutputStream(0x1250000);
            out.writeUTF(s2);
            out.writeInt(C);
            out.writeUTF(A);
            out.writeInt(j1);
            out.writeUTF(s3);
            out.send(0x1250000, SYOutputStream, 2);
            if (SYSocket.isClosed()) {
                //break MISSING_BLOCK_LABEL_217;
                Log.i("PktThread", "[圣域]连接已中断");
                SYSocket = null;
                return false;
            }
        }catch (Exception e)
        {
            Log.e("PktThread", e.getLocalizedMessage(), e);
            sendLog(0, "[圣域]连接已中断");
            SYSocket = null;
            return false;
        }
        try
        {
            (new SYChatThread(this, SYSocket.getInputStream())).start();
        }
        // Misplaced declaration of an exception variable
        catch(Exception e)
        {
            Log.e("PktThread", e.getLocalizedMessage(), e);
            sendLog(0, "[圣域] -_- 跨服连接失败");
            SYSocket = null;
            return false;
        }
        return true;
    }

    public final int b()
    {
        return w;
    }

    public final void b(long l1)
    {
        M = l1;
    }

    public final boolean b(int i1)
    {
        return i1 < 320 && i1 >= 0 && p[i1] && !funcSelect[i1] && !q[i1];
    }



    public final int c()
    {
        return H;
    }

    public final void c(long l1)
    {
        if(l1 > 0L)
            N = l1;
    }

    public final int d()
    {
        return C;
    }

    public final void d(int i1)
    {
        w = i1;
    }

    public final int e()
    {
        return E;
    }

    public final void e(int i1)
    {
        C = i1;
    }

    public final int f()
    {
        return F;
    }

    public final void f(int i1)
    {
        D = i1;
    }

    public final int g()
    {
        return D;
    }

    public final void g(int i1)
    {
        if(i1 >= 0)
        {
            I = i1;
            return;
        } else
        {
            I = I - i1;
            return;
        }
    }

    public final int h()
    {
        return (int)((M * 100L) / N);
    }

    public final void h(int i1)
    {
        J = i1;
    }

    public final int i()
    {
        return I;
    }

    public final void i(int i1)
    {
        K = i1;
    }

    public final int j()
    {
        return K;
    }

    public final void j(int i1) throws IOException
    {
        (new TempDataOutputStream(0x10000, i1)).sendMain(this);
        l();
    }

    public final void l() throws IOException
    {
        BaseFunc.a(3);
        (new TempDataOutputStream(93)).sendMain(this);
    }

    public final void m() throws IOException
    {
        if(b(91) && XJSocket != null)
        {
            BaseFunc.c();
            (new TempDataOutputStream(0x5f0000, 41)).sendXJ(this);
        } else
        {
            j(J);
        }
        if(b(165) && SYSocket != null)
        {
            BaseFunc.c();
            (new TempDataOutputStream(0x1260000, 78)).sendSY(this);
        }
    }

    public final void n() throws IOException
    {
        (new TempDataOutputStream(41, 23)).sendMain(this);
    }

    public final boolean o()
    {
        return XJSocket == null && b(91);
    }

    public final boolean p()
    {
        return SYSocket == null && b(165);
    }

    public final void quit()
    {
        runState = false;
        if(XJSocket != null) {
            //break MISSING_BLOCK_LABEL_24;
            try {
                XJSocket.close();
            } catch (IOException e1) {
                //e1.printStackTrace();
                Log.v("PktThread", e1.getLocalizedMessage(), e1);
            }
            XJSocket = null;
        }
        if(SYSocket != null) {
            //break MISSING_BLOCK_LABEL_43;
            try {
                SYSocket.close();
            } catch (IOException e1) {
                //e1.printStackTrace();
                Log.v("PktThread", e1.getLocalizedMessage(), e1);
            }
            SYSocket = null;
        }
        Iterator obj = t.values().iterator();
        if(!obj.hasNext())
        {
            t.clear();
            return;
        }
//        break MISSING_BLOCK_LABEL_131;
//        obj;
//        Log.v("PktThread", ((IOException) (obj)).getLocalizedMessage(), ((Throwable) (obj)));
//        XJSocket = null;
//          goto _L1
//        obj;
//        XJSocket = null;
//        throw obj;
//        obj;
//        Log.v("PktThread", ((IOException) (obj)).getLocalizedMessage(), ((Throwable) (obj)));
//        SYSocket = null;
//          goto _L2
//        obj;
//        SYSocket = null;
//        throw obj;
//        ((BaseFunc)((Iterator) (obj)).next()).runState();
//          goto _L3
    }


    @Override
    public final void run()
    {
        try {
            byte abyte0[] = web.sxd.b.TempDataInputStream.a(mainInputStream);
            do {
                boolean flag = runState;
                if (!flag || abyte0 == null) {
                    sendLog(-1, "服务器连接已中断");
                    quit();
                    Log.i("PktThread", "CONN_BREAK");
                    return;
                }
                AllStatistics += abyte0.length + 4;
                web.sxd.b.TimeOutThread.clear();
                (new g(this, abyte0)).start();
                abyte0 = web.sxd.b.TempDataInputStream.a(mainInputStream);
            } while (true);
        }catch (Exception e)
        {
            sendLog(-1, "服务器连接已中断");
            quit();
            Log.i("PktThread", "CONN_BREAK");
            return;
        }
    }


    /*
    * 数据流量统计格式化输出
    */
    private static String statisticsFormat(long l1)
    {
        long l3 = 0L;
        int i1 = 0;
        long l2 = 0L;
        do
        {
            if(l1 <= 1024L)
            {
                if(i1 == 0)
                    return String.valueOf(l1);
                break;
            }
            l2 = l1 % 1024L;
            l1 /= 1024L;
            i1++;
        } while(true);
        if(l2 > 949L)
        {
            l1++;
            l2 = l3;
        } else
        {
            l2 /= 100L;
        }
        return String.format("%runState.%runState %iniReadFailed", new Object[] {
                Long.valueOf(l1), Long.valueOf(l2), Character.valueOf(" KMGT".charAt(i1))
        });
    }

    public final String toString()
    {
        return String.format("本进程 %s +%s(仙界) +%s(圣域) +%s(全网)", new Object[] {
                statisticsFormat(AllStatistics), statisticsFormat(XJStatistics), statisticsFormat(SYStatistics), statisticsFormat(QWStatistics)
        });
    }

}