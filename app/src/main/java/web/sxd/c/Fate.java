// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:45
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.c;

import android.util.Log;
import java.util.*;
import web.sxd.b.*;

/**
 * 猎命
 * */
public final class Fate extends BaseFunc
{

    public Fate(MainThread c1)
    {
        super(c1, 0x160000);
    }

    private static final String a(int i, MainThread c1)
    {
        if(i < 10)
            return " sale";
        if(i == 44)
        {
            web.sxd.b.MainThread.sendLog("[猎命]获得 命格碎片x1, 剩%dw", new Object[] {
                Integer.valueOf(c1.f())
            });
            return " pick";
        }
        int j;
        if(i - 10 < b.length)
            j = b[i - 10];
        else
            j = 5;
        if(j < 3)
            return " pick";
        switch(j)
        {
        default:
            return (new StringBuilder(String.valueOf(j))).append(":").append(i).toString();

        case 5: // '\005'
            if(i >= 37 && i <= 47)
                return d[i - 33];
            switch(i)
            {
            default:
                return e[0];

            case 20: // '\024'
                return d[1];

            case 34: // '"'
                return d[2];

            case 52: // '4'
                return d[3];
            }

        case 6: // '\006'
            return d[0];

        case 4: // '\004'
            if(web.sxd.b.MainThread.isFuncSelect(22))
                return e[1];
            // fall through

        case 3: // '\003'
            return " pick";
        }
    }

    public static void a(MainThread c1)throws Exception
    {
        a(3);
        (new TempDataOutputStream(0x160001)).sendMain(c1);
    }

    private static void a(MainThread c1, Collection collection, int i) throws Exception
    {

        if(collection.size() <= 0) return;
        else {
            TempDataOutputStream m1;
            m1 = new TempDataOutputStream(i);
            m1.writeShort(collection.size());
            Iterator it = collection.iterator();
            while (it.hasNext())
            {
                m1.writeInt(((Integer)it.next()).intValue());
            }

            c();
            m1.sendMain(c1);
            return;
        }
    }

    public static void b(MainThread c1) throws Exception
    {
        a(3);
        (new TempDataOutputStream(0x160011)).sendMain(c1);
    }

    public final void a(TempDataInputStream l1)
    {
        try {


            int i;
            i = l1.getFuncCode();
            if (i != 0x160009 && i != 0x160003 && i != 0x160002)
                super.a(l1);
            switch (i) {
                default:
                    return;
                case 1441792:
                    int k2 = l1.read();
                    int i3 = l1.readUnsignedShort();
                    int j = 0;
                    i = 0;
                    do {
                        if (j >= i3) {
                            if (i > 0) {
                                Log.i(b(), (new StringBuilder("appoint_fate_npc: ")).append(i).toString());
                                if (i < 5 || k2 > 0 || web.sxd.b.MainThread.isFuncSelect(20)) {
                                    int k1;
                                    if (k2 > 0)
                                        web.sxd.b.MainThread.sendLog("[猎命]免费次数: %s", new Object[]{
                                                c[i]
                                        });
                                    else
                                        web.sxd.b.MainThread.sendLog("[猎命]尝试点亮至姜子牙");
                                    (new TempDataOutputStream(0x160009, i)).sendMain(C);
                                    return;
                                } else {
                                    web.sxd.b.MainThread.sendLog("[猎命]当前已点亮姜子牙, 留待明日");
                                    return;
                                }
                            }
                            continue; /* Loop/switch isn't completed */
                        }
                        int k1 = l1.read();
                        if (l1.read() > 0 && k1 > i)
                            i = k1;
                        l1.skipBytes(4);
                        j++;
                    } while (true);
                case 1441793:
                    f = 0;
                    ArrayList arraylist = new ArrayList();
                    ArrayList arraylist1 = new ArrayList();
                    int k = l1.readUnsignedShort();
                    i = 0;
                    do {
                        if (i >= k) {
                            a(C, ((Collection) (arraylist)), 0x160003);
                            a(C, ((Collection) (arraylist1)), 0x160002);
                            if (C.f() > 80) {
                                c();
                                (new TempDataOutputStream(0x160000)).sendMain(C);
                                return;
                            }
                            continue; /* Loop/switch isn't completed */
                        }
                        int i2 = l1.readInt();
                        int l2 = l1.readUnsignedShort();
                        String s2 = a(l2, C);
                        Log.i(b(), String.format("fate: @%d [%d]%s", new Object[]{
                                Integer.valueOf(i2), Integer.valueOf(l2), s2
                        }));
                        if (l2 < 10)
                            arraylist.add(Integer.valueOf(i2));
                        else if (s2.equals(" pick"))
                            arraylist1.add(Integer.valueOf(i2));
                        i++;
                    } while (true);
                case 1441794:
                    String s;
                    i = l1.read();
                    StringBuilder stringbuilder = new StringBuilder("pickup_fate: ");
                    stringbuilder.append(i);
                    int i1 = l1.readUnsignedShort();
                    i = 0;
                    do {
                        if (i >= i1) {
                            Log.d(b(), stringbuilder.toString());
                            c();
                            if (web.sxd.b.MainThread.isFuncSelect(21))
                                continue; /* Loop/switch isn't completed */
                            if (C.g() >= 110) {
                                long l3;
                                //String s;
                                if (!web.sxd.b.MainThread.isFuncSelect(22))
                                    l3 = 28L;
                                else
                                    l3 = 27L;
                                (new TempDataOutputStream(0x1000015, l3)).sendMain(C);
                                return;
                            }
                            break;
                        }
                        if (i == 0)
                            s = ", ";
                        else
                            s = "|";
                        stringbuilder.append(s);
                        stringbuilder.append(l1.readInt());
                        i++;
                    } while (true);
                    if (C.g() >= 90 && web.sxd.b.MainThread.isFuncSelect(22)) {
                        (new TempDataOutputStream(0x1000015, 27L)).sendMain(C);
                        return;
                    } else {
                        (new TempDataOutputStream(0x160011)).sendMain(C);
                        return;
                    }
                case 1441801:
                    int j1;
                    i = l1.read();
                    if (i == 12) {
                        web.sxd.b.MainThread.sendLog("[猎命]命格大厅已满, 停止猎命");
                        return;
                    }
                    if (i != 0) {
                        Log.i(b(), (new StringBuilder("appoint_error: ")).append(i).toString());
                        return;
                    }
                    i = l1.readUnsignedShort();
                    String s1 = a(i, C);
                    j1 = l1.readUnsignedByte();
                    int j2 = l1.readInt();
                    if (i < 10) {
                        TempDataOutputStream out = new TempDataOutputStream(0x160003);
                        out.writeShort(1);
                        out.writeInt(j2);
                        out.sendMain(C);
                    } else if (s1.equals(" pick")) {
                        TempDataOutputStream out = new TempDataOutputStream(0x160002);
                        out.writeShort(1);
                        out.writeInt(j2);
                        c();
                        out.sendMain(C);
                    } else {
                        Log.i(b(), (new StringBuilder(String.valueOf(C.f()))).append("w [").append(i).append("]").append(s1).toString());
                        web.sxd.b.MainThread.sendLog("[猎命]获得[%d]%s, 剩%dw", new Object[]{
                                Integer.valueOf(i), s1, Integer.valueOf(C.f())
                        });
                    }
                    f = f + 1;
                    if (f >= 100 && !web.sxd.b.MainThread.isFuncSelect(20)) {
                        web.sxd.b.MainThread.sendLog("[猎命]已尝试 %d 次, 暂时停止", new Object[]{
                                Integer.valueOf(f)
                        });
                        return;
                    }
                    if ((j1 >= 4 || C.f() <= 50) && (j1 != 4 || C.f() <= 150) && (!web.sxd.b.MainThread.isFuncSelect(20) || C.f() <= 50)) {
                        web.sxd.b.MainThread.sendLog("[猎命]%d 已点亮 %s, 留待明日", new Object[]{
                                Integer.valueOf(f), c[j1]
                        });
                        return;
                    } else {
                        if (j1 <= 2) {
                            i = j1;
                            if (j1 <= 0)
                                i = 1;
                        } else {
                            web.sxd.b.MainThread.sendLog("　[猎命]已点亮 %s, 次数 %d", new Object[]{
                                    c[j1], Integer.valueOf(f)
                            });
                            i = j1;
                        }
                        (new TempDataOutputStream(0x160009, i)).sendMain(C);
                        return;
                    }

            }
        }catch (Exception e)
        {
            Log.v("web.sxd.c.Fate",e.getLocalizedMessage(),e);
        }


    }

    protected final String[] a()
    {
        return a;
    }

    private static final String a[] = {
        "Fate_", "get_fate_npc", "get_temp_fate", "pickup_fate", "sale_temp_fate", "", "", "", "", "", 
        "appoint_fate_npc", "", "", "", "", "", "", "", "merge_all_in_bag", "", 
        "", "", "merge_all_normal_in_bag"
    };
    private static final int b[] = {
        3, 4, 3, 4, 3, 4, 3, 4, 3, 4, 
        5, 2, 3, 4, 3, 2, 3, 4, 3, 2, 
        3, 4, 3, 4, 5, 6, 4
    };
    private static final String c[] = {
            "无", "周一仙", "小仙女", "左慈", "张道陵", "姜子牙"
    };
    private static final String d[] = {
            "太初", "飞仙", "万寿无疆", "天衣无缝", "百步穿杨", "破碎虚空", "斗转星移", "诛仙", "真逢龙遇虎", "真轩辕剑体",
            "真大破坏神", "命格碎片", "真霸者横栏", "真千惊万喜", "真天地无用"
    };
    private static final String e[] = {
            "金色命格", "紫色命格", "蓝色命格"
    };
    private int f;

}