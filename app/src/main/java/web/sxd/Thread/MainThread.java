// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:43
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3)

package web.sxd.Thread;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import web.sxd.LoginAct;
import web.sxd.Rule.MainLoginRule;
import web.sxd.base.BaseFunc;
import web.sxd.base.BaseFuncImp;
import web.sxd.base.BaseRule;
import web.sxd.base.ClassUtils;
import web.sxd.base.MESSAGE_TAG;
import web.sxd.base.Rule;
import web.sxd.base.TempDataInputStream;
import web.sxd.base.TempDataOutputStream;

//import web.sxd.base.BaseFunc;
//import web.sxd.b.QWChatThread;
//import web.sxd.b.SJChatThread;
//import web.sxd.b.SYChatThread;
//import web.sxd.b.TempDataInputStream;
//import web.sxd.b.TempDataOutputStream;
//import web.sxd.b.g;
//import web.sxd.b.i;
//import web.sxd.b.j;

// Referenced classes of package web.sxd.Fate:
//            SYSocket, l, QWSocket, XJSocket,
//            XJOutputStream, runState, valueMap, e,
//            Fate, namePrefixMap

public final class MainThread extends Thread {


    private static long AllStatistics = 0L;//本进程总流量
    private static long XJStatistics = 0L;//仙界流量
    private static long SYStatistics = 0L;//圣域流量
    private static long QWStatistics = 0L;//全网流量
    private static Handler uiHandler;//UI线程的Handler 发消息给UI时使用
    private static boolean iniReadFailed;  //ini配置文件读取失败标志  失败为true

    private static BaseRule rule ;
    private static HashMap<Integer,BaseFuncImp> funcMap = new HashMap<Integer, BaseFuncImp>();
    private static HashMap<String,Object> argMap = new HashMap<String, Object>();
    private static List<TempDataOutputStream>  messageList=  new ArrayList<TempDataOutputStream>();
//    private static HashMap<String,Object> xjArgMap = new HashMap<String, Object>();
//    private static HashMap<String,Object> syArgMap = new HashMap<String, Object>();
//    private static HashMap<String,Object> qwArgMap = new HashMap<String, Object>();
    /**<value,j>*/
    //private static HashMap valueMap = new HashMap();  //<value,j> 读取配置 获取j对象 放入
    /**<namePrefix,Town>*/
    //private static HashMap namePrefixMap = new HashMap();  //<namePrefix,Town>读取配置生成i对象 放入 重复不放入
    //private static boolean funcSelect[] = new boolean[320];//功能选择
    private String PlayerName;//角色名称
    private String ServerName;//服务器名：S1370
    private int PlayerID;
    private int PlayerGrade;//角色等级
    private int Gold;//元宝个数
    private int Coin;//铜钱(w)
    private int PlayerRanking;//竞技场排名
    private int H;//战力
    private int I;//体力
    private int TownID;//所在城镇的ID
    private int K;
    private int L;
    private long Exp;//角色当前等级经验
    private long MaxExp;//角色当前等级的最大经验
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
    //private String s[][][];
    private HashMap t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;



    public MainThread(String s1, InputStream inputstream, OutputStream outputstream)
    {
        rule = new MainLoginRule();
        new Thread(new RuleRunnable()).start();
        p = new boolean[320];
        q = new boolean[320];
//        s = (String[][][])Array.newInstance(String.class/*java/lang/String*/, new int[] {
//            255, 10, 2
//        });
        t = new HashMap();
        w = -1;
        ServerName = null;
        K = 0;
        L = 0;
        MaxExp = 0x7fffffffL;
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
        init();
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
        //namePrefixMap.clear();
        //valueMap.clear();
        //iniReadFailed = false;
    }

    private void init()
    {
        //List<Class> classes = ClassUtils.getAllClassByInterface(BaseFuncImp.class);
        for (String className: LoginAct.classList
             ) {
            try {
                Class classBaseFunc = Class.forName(className);
                Method method = classBaseFunc.getMethod("GetFuncCodeH");
                Constructor c1=classBaseFunc.getDeclaredConstructor(new Class[]{MainThread.class});
                c1.setAccessible(true);
                BaseFuncImp imp =  (BaseFuncImp) c1.newInstance(new Object[]{this});
                //Field field = classBaseFunc.getField("FuncCodeH");
                int funcCodeH = imp.GetFuncCodeH();
                //int funcCodeH = field.getInt (classBaseFunc);//int)method.invoke(classBaseFunc);
                if(funcMap.containsKey(funcCodeH))
                {
                    sendLog(0,"[注册]："+funcCodeH+"已经注册");
                }else
                {

                    funcMap.put(funcCodeH,imp);
                }
            }catch (Exception e)
            {
                Log.v("MainThread",e.getLocalizedMessage(),e);
            }

        }
    }

    public void setArg(String key,Object value)
    {
        argMap.put(key,value);
    }
    public Object getArg(String key){
        return argMap.get(key);
    }
    public void removArg(String key)
    {
        if(argMap.get(key)!=null) argMap.remove(key);
    }

    // ini配置文件读取
//    public static void iniRead(InputStream inputstream) throws IOException
//    {
//        BufferedReader bufferedreader;
//        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
//        if(!bufferedreader.ready())
//        {
//            bufferedreader.close();
//            return;
//        }
//        do {
//            String str = bufferedreader.readLine();
//            if(str == null) break;
//            if(str.length() == 0 || str.charAt(0) == ';') //忽略空行和注释行
//            {}else
//            {
//                int i1;
//                int k1 = str.indexOf(',');
//                i1 = k1;
//                if(k1 < 0)
//                    i1 = str.indexOf('=');
//                if(i1 <= 0)
//                {
//                    Log.v("PktThread", (new StringBuilder("',' or '=' not found in protocol line: ")).append(inputstream).toString());
//                }else
//                {
//                    String name;
//                    String valueStr;
//                    /*  eg:    Player_player_ui_list,70
//                        name        =   Player_player_ui_list
//                        value       =   70
//                        namePrefix  =   Player_
//                    */
//                    name = str.substring(0, i1);
//                    valueStr = str.substring(i1 + 1);
//                    i1 = name.indexOf('_');
//                    if(i1 <= 0)
//                    {
//                        Log.v("PktThread", (new StringBuilder(String.valueOf(name))).append(" protocol with invalid code ").append(valueStr).toString());
//                    }else
//                    {
//                        int value;
//                        i j2;
//                        String namePrefix;
//                        namePrefix = name.substring(0, i1 + 1);
//                        value = Integer.valueOf(valueStr); //字符串转Int
//                        j2 = (i) namePrefixMap.get(namePrefix);
//                        if(j2 != null)
//                            break ;
//                        j2 = new i(value / 0x10000, namePrefix);
//                        namePrefixMap.put(namePrefix, j2);
//                        valueMap.put(value, j2.addConfig(name.substring(i1 + 1), value % 0x10000));
//                    }
//                }
//            }
//        }while(bufferedreader.ready());
//        bufferedreader.close();
//        Iterator value = namePrefixMap.values().iterator();
//        do{
//            if(!value.hasNext())
//            {
//                iniReadFailed = true;
//                return;
//            }
//            i k2 = (i)value.next();
//            int j1 = k2.getFuncCodeH() * 0x10000;
//            if(j1 > 0 && !valueMap.containsKey(j1))
//                valueMap.put(j1, k2.addConfig("?", -1));
//        }while (true);
//    }

    public static void sendLog(Object obj)
    {
        sendLog(0, obj);
    }

    public static void sendLog(String s1, Object aobj[])
    {
        sendLog(0, String.format(s1, aobj));
    }



//    public static void setFuncSelect(int i1, boolean flag)
//    {
//        if(i1 < 320 && i1 >= 0)
//            funcSelect[i1] = flag;
//    }

    //解析接收的消息
    public static void ProcessReceive(TempDataInputStream inputStream) {
        //inputStream.getFuncCodeH();
        BaseFuncImp funcClass = funcMap.get(inputStream.getFuncCodeH());
        if(funcClass!=null) {
            int result = funcClass.Process(inputStream);
            //if (inputStream.getFuncCode() == rule.getFuncCode()) {
            if (rule.getWaitReason() == Rule.WAIT_FUNC_FINSH) {
                if (inputStream.getFuncCode() == rule.getArg()) {//等待触发的功能码和当前的一样
                    rule.state = true;
                }
            }
            if (result == 0 && rule.getWaitReason() == Rule.WAIT_FUNC_SUCCESS) {
                if (inputStream.getFuncCode() == rule.getArg()) {//等待触发的功能码和当前的一样
                    rule.state = true;
                }
            }

            if (rule.getWaitReason() == Rule.WAIT_FUNC_TRIGGER) {
                if (inputStream.getFuncCode() == rule.getArg()) {//等待触发的功能码和当前的一样
                    rule.state = true;
                }
            }
        }else {
            sendLog("[未注册]"+String.format("%x",inputStream.getFuncCode()));
        }
    }


    static boolean getRunState(MainThread c1)
    {
        return c1.runState;
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
        if(PlayerID == i1)
        {
            PlayerRanking = j1;
            H = k1;
        }
    }
    /**
     * 发送数据到服务器
     * tag类型 ： 主界面：0   仙界：1  圣域：2 全网：3
     *
     */
    private final void send(TempDataOutputStream m1) //throws  Exception
    {
        OutputStream out;
//        this;
//        JVM INSTR monitorenter ;
        synchronized (this)
        {
            int tag = m1.getMessageTag();
            if(tag == MESSAGE_TAG.TAG_XJ){
                if(XJOutputStream == null){
                    Log.e("PacketOS", "[仙界]连接未建立");
                    return;
                }
                out = XJOutputStream;

            }else if(tag == MESSAGE_TAG.TAG_SY){
                if(SYOutputStream == null){
                    Log.e("PacketOS", "[圣域]连接未建立");
                    return;
                }
                out = SYOutputStream;
            }else if(tag == MESSAGE_TAG.TAG_QW){
                if(QWOutputStream == null){
                    Log.e("PacketOS", "[全网]连接未建立");
                    return;
                }
                out = QWOutputStream;

            }else
            {
                out = mainOutputStream;
            }
            try {
                m1.send(out);
            }catch (Exception e)
            {
                Log.v("MainTread.Send",e.getLocalizedMessage(),e);
            }
        }
    }

    public final void a(int i1, boolean flag)
    {
        if(i1 < 320 && i1 >= 0)
            p[i1] = flag;
    }

    public final void setCoin(long l1)
    {
        if(l1 < 20000L)
        {
            int i1;
            if(l1 > 0L)
                i1 = 1;
            else
                i1 = 0;
            Coin = i1;
        } else
        {
            l1 /= 10000L;
            if(l1 < 0x7fffffffL)
            {
                Coin = (int)l1;
                return;
            }
        }
    }

    public final void a(String s1, int i1, int j1, int k1)
    {
        PlayerName = s1;
        PlayerGrade = i1;
        Gold = j1;
        Coin = k1;
    }

//    public final void a(BaseFunc h1)
//    {
//        if(h1 != null)
//        {
//            BaseFunc h2 = (BaseFunc)t.put(h1.getClass(), h1);
//            if(h2 != null && !h2.equals(h1))
//                h2.d();
//        }
//    }

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
        return s1.equals(ServerName);
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
            ServerName = s2;
            Log.i("PktThread", (new StringBuilder("[仙界]尝试登录 ")).append(ServerName).toString());
            XJOutputStream = new BufferedOutputStream(XJSocket.getOutputStream());
            TempDataOutputStream out = new TempDataOutputStream(0x5e0000);
            out.writeUTF(s2);
            out.writeInt(PlayerID);
            out.writeUTF(PlayerName);
            out.writeInt(j1);
            out.writeUTF(s3);
            out.setMessageTag(MESSAGE_TAG.TAG_XJ);
            out.send(XJOutputStream);
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
            (new SJThread(this, XJSocket.getInputStream())).start();
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
            ServerName = s3;
            Log.i("PktThread", (new StringBuilder("[全网]尝试登录 ")).append(ServerName).toString());
            QWOutputStream = new BufferedOutputStream(QWSocket.getOutputStream());
            TempDataOutputStream out = new TempDataOutputStream(0x150000c);
            out.writeUTF(s2);
            out.writeInt(PlayerID);
            out.writeUTF(s3);
            out.writeUTF(s4);
            out.writeInt(j1);
            out.writeUTF(s5);
            out.setMessageTag(MESSAGE_TAG.TAG_QW);
            out.send(QWOutputStream);
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
            (new QWThread(this, QWSocket.getInputStream())).start();
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
            ServerName = s2;
            Log.i("PktThread", (new StringBuilder("[圣域]尝试登录 ")).append(ServerName).toString());
            SYOutputStream = new BufferedOutputStream(SYSocket.getOutputStream());
            TempDataOutputStream out = new TempDataOutputStream(0x1250000);
            out.writeUTF(s2);
            out.writeInt(PlayerID);
            out.writeUTF(PlayerName);
            out.writeInt(j1);
            out.writeUTF(s3);
            out.setMessageTag(MESSAGE_TAG.TAG_SY);
            out.send(SYOutputStream);
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
            (new SYThread(this, SYSocket.getInputStream())).start();
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

    public final void setExp(long l1)
    {
        Exp = l1;
    }




    public final int c()
    {
        return H;
    }

    public final void setMaxExp(long l1)
    {
        if(l1 > 0L)
            MaxExp = l1;
    }

    public final int getPlayerID()
    {
        return PlayerID;
    }

    public final void d(int i1)
    {
        w = i1;
    }

    public final int getGold()
    {
        return Gold;
    }

    public final void setPlayerID(int i1)
    {
        PlayerID = i1;
    }

    public final int getCoin()
    {
        return Coin;
    }

    public final void setPlayerGrade(int i1)
    {
        PlayerGrade = i1;
    }

    public final int g()
    {
        return PlayerGrade;
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
        return (int)((Exp * 100L) / MaxExp);
    }

    public final void h(int i1)
    {
        TownID = i1;
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

//    public final void j(int i1) throws IOException
//    {
//        (new TempDataOutputStream(0x10000, i1)).sendMain(this);
//        l();
//    }
//
//    public final void l() throws IOException
//    {
//        BaseFunc.a(3);
//        (new TempDataOutputStream(93)).sendMain(this);
//    }
//
//    public final void m() throws IOException
//    {
//        if(b(91) && XJSocket != null)
//        {
//            BaseFunc.c();
//            (new TempDataOutputStream(0x5f0000, 41)).sendXJ(this);
//        } else
//        {
//            j(TownID);
//        }
//        if(b(165) && SYSocket != null)
//        {
//            BaseFunc.c();
//            (new TempDataOutputStream(0x1260000, 78)).sendSY(this);
//        }
//    }
//
//    public final void n() throws IOException
//    {
//        (new TempDataOutputStream(41, 23)).sendMain(this);
//    }

    public final boolean o()
    {
        return XJSocket == null ;//&& b(91);
    }

    public final boolean p()
    {
        return SYSocket == null ;//&& b(165);
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
            byte abyte0[] = TempDataInputStream.Read(mainInputStream);
            do {
                boolean flag = runState;
                if (!flag || abyte0 == null) {
                    sendLog(-1, "服务器连接已中断");
                    quit();
                    Log.i("PktThread", "CONN_BREAK");
                    return;
                }
                AllStatistics += abyte0.length + 4;
                //web.sxd.b.TimeOutThread.clear();
                (new ProcessThread(this, abyte0)).start();
                abyte0 = TempDataInputStream.Read(mainInputStream);
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

    @Override
    public final String toString()
    {
        return String.format("本进程 %s +%s(仙界) +%s(圣域) +%s(全网)", new Object[] {
                statisticsFormat(AllStatistics), statisticsFormat(XJStatistics), statisticsFormat(SYStatistics), statisticsFormat(QWStatistics)
        });
    }


    static boolean isRun(MainThread c1)
    {
        return c1.runState;
    }

    public void sendMessage(TempDataOutputStream tempDataOutputStream) {
        messageList.add(tempDataOutputStream);
    }


    class RuleRunnable implements Runnable
    {
        private int time;
        @Override
        public void run() {
            rule.start();
            while (true) {
                try {
                    if(rule.getWaitReason()== Rule.WAIT_TIME && time==(rule.getArg()/100))
                        rule.state = true;
                    while (rule.state) {
                        BaseFuncImp funcImp = funcMap.get(rule.getFuncCode()/0x10000);
                        if(funcImp!=null) {
                            int funcCode = rule.getFuncCode();
                            rule.next();
                            funcImp.SendOpertaion(funcCode);
                            sendLog("rule:funcCode:"+rule.getFuncCode());
                        }else
                        {
                            rule.next();
                        }
                        time=0;
                        //rule.next();
                    }

                    while (!messageList.isEmpty())
                    {
                        send(messageList.get(0));
                        messageList.remove(0);
                    }
                    time++;
                    Thread.sleep(100);
                }catch (Exception e)
                {

                }
            }
        }
    }


}