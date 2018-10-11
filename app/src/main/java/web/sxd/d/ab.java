// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:46
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.d;

import android.util.Log;

import java.io.IOException;

import web.sxd.b.*;

public final class ab extends BaseFunc
{

    public ab(MainThread c1)
    {
        super(c1, 0xc0001);
    }

    static void a(MainThread c1) throws IOException
    {
        if(web.sxd.b.MainThread.isFuncSelect(10) || c1.g() % 10 >= 8)
            (new TempDataOutputStream(0xc0000, c1.a())).sendMain(c1);
    }

    public final void a(TempDataInputStream l1)
    {
        try {
            super.a(l1);
            switch (l1.getFuncCode())
            {
                default :
                    return;
                case 786432 :
                    if(web.sxd.b.MainThread.isFuncSelect(10) || C.g() % 10 >= 8)
                    {
                        b = l1.readInt();
                        int k1 = l1.readInt();
                        int k = 5000 / C.g();
                        int i = k;
                        if(k > 100)
                            i = 100;
                        int k2 = l1.readInt() / i;
                        String s = l1.readUTF();
                        int j3 = l1.readInt();
                        int i4 = l1.readInt();
                        int j4 = l1.readInt();
                        int k4 = l1.read();
                        d = 0;
                        e = 0;
                        int l4 = l1.readUnsignedShort();
                        k = 0;
                        i = 0;
                        do
                        {
                            if(i >= l4)
                            {
                                web.sxd.b.MainThread.sendLog("[培养]%d级 %d,%d,%d : %d,%d,%d", new Object[] {
                                        Integer.valueOf(k1), Integer.valueOf(j3 + d), Integer.valueOf(e + i4), Integer.valueOf(j4 + k), Integer.valueOf(d), Integer.valueOf(e), Integer.valueOf(k)
                                });
                                if(C.f() < k2)
                                {
                                    web.sxd.b.MainThread.sendLog("[培养]铜钱少于%dw, 暂不培养", new Object[] {
                                            Integer.valueOf(k2)
                                    });
                                    return;
                                }
                                break;
                            }
                            if(i == 0)
                            {
                                d = l1.readInt();
                                e = l1.readInt();
                                k = l1.readInt();
                                Log.i(b(), (new StringBuilder(String.valueOf(b))).append(s).append(k4).append(",").append(k2).append("w ").append(d).append("/").append(e).append("/").append(k).toString());
                            } else
                            {
                                Log.i(b(), (new StringBuilder(String.valueOf(l1.readInt()))).append("/").append(l1.readInt()).append("/").append(l1.readInt()).toString());
                            }
                            i++;
                        } while(true);
                        if((C.g() * 4 + 20) - d < 5 || d / e < 8)
                        {
                            if(web.sxd.b.MainThread.isFuncSelect(29) || C.b() < 0)
                            {
                                web.sxd.b.MainThread.sendLog("[培养]武力接近等级上限, 暂不培养");
                                return;
                            }
                            if(b == C.a())
                            {
                                web.sxd.b.MainThread.sendLog("[培养]主角武力接近上限, 培养杨戬");
                                c();
                                (new TempDataOutputStream(0xc0000, C.b())).sendMain(C);
                                return;
                            } else
                            {
                                web.sxd.b.MainThread.sendLog("[培养]杨戬武力接近上限, 暂不培养");
                                return;
                            }
                        } else
                        {
                            c = 0;
                            TempDataOutputStream out = new TempDataOutputStream(0xc0001, b);
                            out.write(0);
                            out.sendMain(C);
                            return;
                        }
                    }
                    return;
                case 786433 :
                    int j = l1.read();
                    switch (j) {
                        default :
                            web.sxd.b.MainThread.sendLog("[培养]失败: %d", new Object[] {
                                    Integer.valueOf(j)
                            });
                            return;
                        case 6 :break;

                        case 7 :
                            web.sxd.b.MainThread.sendLog("[培养]培养失败, 暂停培养");
                            break;
                        case 8 :
                            web.sxd.b.MainThread.sendLog("[培养]铜钱不足, 暂停培养");
                            break;
                    }
                    c = c + 1;
                    j = l1.readInt();
                    int i1 = l1.readInt();
                    int i2 = l1.readInt();
                    int l2 = d;
                    int k3 = c;
                    String str;
                    if(j > d)
                        str = " !!!";
                    else
                        str = "";
                    web.sxd.b.MainThread.sendLog("[培养]原始%d, 第%2d次: %d,%d,%d%s", new Object[] {
                            Integer.valueOf(l2), Integer.valueOf(k3), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(i2), str
                    });
                    if(j > d || j == d && i1 > e && j / i1 >= 8)
                    {
                        c();
                        (new TempDataOutputStream(0xc0002, b)).sendMain(C);
                        return;
                    }
                    if(c < 99 || c < C.g() * 2)
                    {
                        TempDataOutputStream out = new TempDataOutputStream(0xc0001, b);
                        out.write(0);
                        out.sendMain(C);
                        return;
                    } else
                    {
                        web.sxd.b.MainThread.sendLog("[培养]已培养%2d次, 暂时停止", new Object[] {
                                Integer.valueOf(c)
                        });
                        return;
                    }
                case 786434 :
                    int j1;
                    int j2;
                    int i3;
                    int l3;
                    j2 = l1.read();
                    i3 = d;
                    l3 = l1.readUnsignedShort();
                    j1 = 0;
                    j = 0;
                    while (j < l3)
                    {
                        if(j == 0)
                        {
                            d = l1.readInt();
                            e = l1.readInt();
                            j1 = l1.readInt();
                            Log.i(b(), (new StringBuilder(String.valueOf(d))).append("/").append(e).append("/").append(j1).toString());
                        } else
                        {
                            Log.i(b(), (new StringBuilder(String.valueOf(l1.readInt()))).append("/").append(l1.readInt()).append("/").append(l1.readInt()).toString());
                        }
                        j++;
                    }
                    if(j2 == 6)
                        str = "成功";
                    else
                        str = "失败";
                    web.sxd.b.MainThread.sendLog("[培养]属性保存%s: %d => %d,%d,%d", new Object[] {
                            str, Integer.valueOf(i3), Integer.valueOf(d), Integer.valueOf(e), Integer.valueOf(j1)
                    });
                    if(j2 == 6)
                    {
                        c();
                        a(C);
                        return;
                    }
                    return;
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.d.ab",e.getLocalizedMessage(),e);   
        }
    }

    protected final String[] a()
    {
        return a;
    }

    private static final String a[] = {
        "Training_", "panel_show", "training", "modify_role_data"
    };
    private int b;
    private int c;
    private int d;
    private int e;

}