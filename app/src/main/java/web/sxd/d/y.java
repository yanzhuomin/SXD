// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:48
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;
import java.util.HashMap;
import web.sxd.b.*;

public final class y extends web.sxd.b.h
{

    public y(MainThread c1)
    {
        super(c1, 0x2e0000);
        b = new HashMap();
        c = new HashMap();
    }

    static void a(MainThread c1)
    {
        web.sxd.b.MainThread.sendLog("[阵型]保存并移除伙伴: %s", new Object[] {
            d
        });
        web.sxd.b.MainThread.sendLog(5, d);
        d = "";
        (new m(0x2e0000)).a(c1);
    }

    public static void a(MainThread c1, String s)
    {
        d = s;
        if(s != null)
            web.sxd.b.MainThread.sendLog("[阵型]恢复: %s", new Object[] {
                d
            });
        (new m(0x2e0000)).a(c1);
    }

    public final void a(l l1)
    {
        super.a(l1);
        l1.c();
        JVM INSTR tableswitch 3014656 3014658: default 36
    //                   3014656 114
    //                   3014657 37
    //                   3014658 37;
           goto _L1 _L2 _L3 _L3
_L5:
        return;
_L3:
        int i;
        Object obj;
        i = l1.read();
        switch(i)
        {
        default:
            obj = b();
            break; /* Loop/switch isn't completed */

        case 0: // '\0'
            break;
        }
_L1:
        if(true) goto _L5; else goto _L4
_L4:
        if(l1.c() == 0x2e0001)
            l1 = "up";
        else
            l1 = "down";
        Log.i(((String) (obj)), (new StringBuilder(String.valueOf(l1))).append("_deploy error: ").append(i).toString());
        return;
_L2:
        int j;
        j = l1.readUnsignedShort();
        i = 0;
_L20:
        if(i < j) goto _L7; else goto _L6
_L6:
        int i2;
        Object obj1;
        if(d == null)
            obj = new String[10];
        else
            obj = d.split(",");
        if(d == null || !c.containsKey("\u4E3B\u89D2")) goto _L9; else goto _L8
_L8:
        i = 1;
_L16:
        if(i < obj.length) goto _L10; else goto _L9
_L9:
        obj1 = new StringBuilder();
        i2 = l1.readUnsignedShort();
        j = 0;
_L17:
        if(j < i2) goto _L12; else goto _L11
_L11:
        if(d == null) goto _L14; else goto _L13
_L13:
        i = 0;
_L18:
        if(i < obj.length) goto _L15; else goto _L14
_L7:
        int i1 = l1.readInt();
        int j2 = l1.read();
        String s = l1.a(2);
        obj1 = l1.readUTF();
        obj = l1.readUTF();
        s = String.format("[%d,%d%s,%s,%s,%d,%s,%s%s,%d,%d],", new Object[] {
            Integer.valueOf(i1), Integer.valueOf(j2), s, obj1, obj, Integer.valueOf(l1.readInt()), l1.readUTF(), l1.readUTF(), l1.a(3), Integer.valueOf(l1.read()), 
            Integer.valueOf(l1.readUnsignedShort())
        });
        if(((String) (obj1)).contains("YangJian"))
            C.d(i1);
        if(!b.containsKey(Integer.valueOf(i1)))
        {
            Log.v(b(), s);
            if(j2 > 0)
                obj = "\u4E3B\u89D2";
            b.put(Integer.valueOf(i1), obj);
            c.put(obj, Integer.valueOf(i1));
        }
        i++;
        continue; /* Loop/switch isn't completed */
_L10:
        if("\u4E3B\u89D2".equals(obj[i]))
        {
            obj1 = new m(0x2e0001);
            ((m) (obj1)).writeInt(((Integer)c.get("\u4E3B\u89D2")).intValue());
            ((m) (obj1)).write(i);
            ((m) (obj1)).a(C);
            c();
            obj[i] = null;
        }
        i++;
          goto _L16
_L12:
        i = l1.read();
        int j1 = l1.readInt();
        ((StringBuilder) (obj1)).append((new StringBuilder(String.valueOf(i))).append("=").append(j1).append(", ").toString());
        if(i >= 10 || i < 0)
            i = 0;
        if(d == null && j1 > 0)
            obj[i] = (String)b.get(Integer.valueOf(j1));
        if(d != null && j1 > 1 && (i >= obj.length || obj[i] != null && !obj[i].equals(b.get(Integer.valueOf(j1)))))
        {
            Log.d(b(), (new StringBuilder("down_deploy: ")).append(i).toString());
            int k1 = i;
            if(i == 0)
                k1 = 51;
            (new m(0x2e0002, k1)).a(C);
        }
        j++;
          goto _L17
_L15:
        if(c.containsKey(obj[i]))
        {
            Log.d(b(), (new StringBuilder("up_deploy: ")).append(i).append("_").append(obj[i]).toString());
            l1 = new m(0x2e0001);
            l1.writeInt(((Integer)c.get(obj[i])).intValue());
            int k;
            if(i == 0)
                k = 51;
            else
                k = i;
            l1.write(k);
            l1.a(C);
            c();
        }
        i++;
          goto _L18
_L14:
        Log.i(b(), ((StringBuilder) (obj1)).toString());
        if(d == null)
        {
            obj1 = new StringBuilder();
            i = 0;
            do
            {
                if(i >= 10)
                {
                    l1 = b();
                    obj = ((StringBuilder) (obj1)).toString();
                    d = ((String) (obj));
                    Log.i(l1, ((String) (obj)));
                    web.sxd.b.MainThread.a("[\u9635\u578B]\u5F53\u524D: %s", new Object[] {
                        d
                    });
                    return;
                }
                if(obj[i] == null)
                    l1 = ",";
                else
                    l1 = (new StringBuilder(String.valueOf(obj[i]))).append(",").toString();
                ((StringBuilder) (obj1)).append(l1);
                i++;
            } while(true);
        }
        l1 = C;
        d = null;
        (new m(0x2e0000)).a(l1);
        return;
        if(true) goto _L20; else goto _L19
_L19:
    }

    protected final String[] a()
    {
        return a;
    }

    private static final String a[] = {
        "SuperDeploy_", "super_deploy_list", "up_deploy", "down_deploy", "deploy_research_and_first_attack", "new_deploy_grid_open_notify"
    };
    private static String d = null;
    private HashMap b;
    private HashMap c;

}