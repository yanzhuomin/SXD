// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:48
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;
import java.util.HashMap;
import web.sxd.b.*;

public final class y extends BaseFunc
{

    public y(MainThread c1)
    {
        super(c1, 0x2e0000);
        b = new HashMap();
        c = new HashMap();
    }

    static void a(MainThread c1) throws Exception
    {
        web.sxd.b.MainThread.sendLog("[阵型]保存并移除伙伴: %s", new Object[] {
            d
        });
        web.sxd.b.MainThread.sendLog(5, d);
        d = "";
        (new TempDataOutputStream(0x2e0000)).sendMain(c1);
    }

    public static void a(MainThread c1, String s) throws  Exception
    {
        d = s;
        if(s != null)
            web.sxd.b.MainThread.sendLog("[\u9635\u578B]\u6062\u590D: %s", new Object[] {
                d
            });
        (new TempDataOutputStream(0x2e0000)).sendMain(c1);
    }

    public final void a(TempDataInputStream l1)
    {
        try {
            super.a(l1);
            switch (l1.getFuncCode()) {
                default:
                    return;
                case 3014656:
                    int i, j;
                    j = l1.readUnsignedShort();
                    i = 0;
                    while (i < j) {
                        int i1 = l1.readInt();
                        int j2 = l1.read();
                        String s = l1.a(2);
                        String obj1 = l1.readUTF();
                        String obj = l1.readUTF();
                        s = String.format("[%d,%d%s,%s,%s,%d,%s,%s%s,%d,%d],", new Object[]{
                                Integer.valueOf(i1), Integer.valueOf(j2), s, obj1, obj, Integer.valueOf(l1.readInt()), l1.readUTF(), l1.readUTF(), l1.a(3), Integer.valueOf(l1.read()),
                                Integer.valueOf(l1.readUnsignedShort())
                        });
                        if (((String) (obj1)).contains("YangJian"))
                            C.d(i1);
                        if (!b.containsKey(Integer.valueOf(i1))) {
                            Log.v(b(), s);
                            if (j2 > 0)
                                obj = "主角";
                            b.put(Integer.valueOf(i1), obj);
                            c.put(obj, Integer.valueOf(i1));
                        }
                        i++;
                    }
                        int i2;
                        String obj[];
                        Object obj1;
                        if (d == null)
                            obj = new String[10];
                        else
                            obj = d.split(",");
                        if (d == null || !c.containsKey("主角")) {
                        } else {
                            i = 1;
                            while (i < obj.length) {
                                if ("主角".equals(obj[i])) {
                                    TempDataOutputStream out = new TempDataOutputStream(0x2e0001);
                                    out.writeInt(((Integer) c.get("\u4E3B\u89D2")).intValue());
                                    out.write(i);
                                    out.sendMain(C);
                                    c();
                                    obj[i] = null;
                                }
                                i++;
                            }
                        }
                        obj1 = new StringBuilder();
                        i2 = l1.readUnsignedShort();
                        j = 0;
                        while (j < i2) {
                            i = l1.read();
                            int j1 = l1.readInt();
                            ((StringBuilder) (obj1)).append((new StringBuilder(String.valueOf(i))).append("=").append(j1).append(", ").toString());
                            if (i >= 10 || i < 0)
                                i = 0;
                            if (d == null && j1 > 0)
                                obj[i] = (String) b.get(Integer.valueOf(j1));
                            if (d != null && j1 > 1 && (i >= obj.length || obj[i] != null && !obj[i].equals(b.get(Integer.valueOf(j1))))) {
                                Log.d(b(), (new StringBuilder("down_deploy: ")).append(i).toString());
                                int k1 = i;
                                if (i == 0)
                                    k1 = 51;
                                (new TempDataOutputStream(0x2e0002, k1)).sendMain(C);
                            }
                            j++;
                        }
                        if (d == null) {
                        } else {
                            i = 0;
                            while (i < obj.length) {
                                if (c.containsKey(obj[i])) {
                                    Log.d(b(), (new StringBuilder("up_deploy: ")).append(i).append("_").append(obj[i]).toString());
                                    TempDataOutputStream out = new TempDataOutputStream(0x2e0001);
                                    out.writeInt(((Integer) c.get(obj[i])).intValue());
                                    int k;
                                    if (i == 0)
                                        k = 51;
                                    else
                                        k = i;
                                    out.write(k);
                                    out.sendMain(C);
                                    c();
                                }
                                i++;
                            }
                        }
                        Log.i(b(), ((StringBuilder) (obj1)).toString());
                        String str;
                        if (d == null) {
                            obj1 = new StringBuilder();
                            i = 0;
                            do {
                                if (i >= 10) {
                                    //l1 = b();
                                    str = obj1.toString();
                                    d = str;
                                    Log.i(b(), str);
                                    web.sxd.b.MainThread.sendLog("[阵型]当前: %s", new Object[]{
                                            d
                                    });
                                    return;
                                }
                                if (obj[i] == null)
                                    str = ",";
                                else
                                    str = (new StringBuilder(String.valueOf(obj[i]))).append(",").toString();
                                ((StringBuilder) (obj1)).append(l1);
                                i++;
                            } while (true);
                        }


                    d = null;
                    (new TempDataOutputStream(0x2e0000)).sendMain(C);
                    return;
                case 3014657:
                case 3014658:
                    //int i;
                    String str1;
                    i = l1.read();
                    switch(i)
                    {
                        default:
                            str1 = b();
                            break; /* Loop/switch isn't completed */

                        case 0: // '\0'
                            break;
                    }
                    return;

            }
//            String str;
//            if(l1.getFuncCode() == 0x2e0001)
//                str = "up";
//            else
//                str = "down";
//            Log.i((str), (new StringBuilder(String.valueOf(l1))).append("_deploy error: ").append(i).toString());
//            return;

        }catch (Exception e)
        {
            Log.v("web.sxd.d.y",e.getLocalizedMessage(),e);
        }
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