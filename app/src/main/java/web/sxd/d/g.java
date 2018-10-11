// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:46
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3)

package web.sxd.d;

import android.util.Log;
import web.sxd.b.*;

// Referenced classes of package web.sxd.d:
//            h, i

//种地
public final class g extends BaseFunc
{

    public g(MainThread c1)
    {
        super(c1, 0xd0000);
        b = 0;
        c = 0;
        d = 0;
        e = 0;
        g = -1;
        h = -1;
        i = 9;
        j = "";
        k = "";
        l = new web.sxd.d.h[8];
        m = new i[8];
        n = false;
        o = true;
        p = true;
        q = true;
    }

    static String a(g g1)
    {
        return g1.b();
    }

    private void a(int i1, TempDataInputStream l1) throws Exception
    {
        int j1 = 0;
        do
        {
            if(j1 >= m.length)
                return;
            if(m[j1] == null)
            {
                m[j1] = new i(this, i1, l1);
                return;
            }
            if(m[j1].a == i1)
            {
                m[j1].a(l1);
                return;
            }
            j1++;
        } while(true);
    }

    static void a(MainThread c1)throws Exception
    {
        (new TempDataOutputStream(0xd0001)).sendMain(c1);
    }

    static void a(g g1, int i1)
    {
        g1.b = i1;
    }

    static int b(g g1)
    {
        return g1.b;
    }

    public static void b(MainThread c1) throws Exception
    {
        (new TempDataOutputStream(0xd0013)).sendMain(c1);
    }

    public static void c(MainThread c1) throws Exception
    {
        (new TempDataOutputStream(0xd0015)).sendMain(c1);
    }

    private void e() throws Exception
    {
       if(n) return;
        int i1;
        char c1;
        n = true;
        sleep(3);
        if((g <= 0 || C.a) && (h <= 0 || h < 8 && !C.b(43)) && (e == 0 || web.sxd.b.MainThread.isFuncSelect(16)))
        {
            n = false;
            (new TempDataOutputStream(0xd000c)).sendMain(C);
            return;
        }
        c1 = '\u70D8';
        i1 = 0;
        while(i1 < l.length)
        {
            if((C.b(43) && h > 0 || h == 8) && l[i1] != null && l[i1].b == b && l[i1].a())
            {
                Log.v(b(), (new StringBuilder("plants Coins @ #")).append(l[i1].a).toString());
                l[i1].d = 0;
                (new TempDataOutputStream(0xd0002, 3L)).sendMain(C);
                sleep(2);
                TempDataOutputStream obj = new TempDataOutputStream(0xd0005, l[i1].a);
                obj.writeInt(c);
                obj.write(3);
                obj.write(1);
                obj.sendMain(C);
                n = false;
                return;
            }
            i1++;
        }
        int k1;
        k1 = 0;
        i1 = c1;
        int j1;
        while (k1 < l.length)
        {
            j1 = i1;
            if(l[k1] != null)
                if(!l[k1].a())
                {
                    j1 = i1;
                    if(l[k1].c > 0)
                    {
                        j1 = i1;
                        if(l[k1].c < i1)
                            j1 = l[k1].c;
                    }
                } else
                {
                    if(h == 8)
                    {
                        Log.v(b(), (new StringBuilder("plants Coins @ #")).append(l[k1].a).toString());
                        l[k1].d = 0;
                        (new TempDataOutputStream(0xd0002, 3L)).sendMain(C);
                        sleep(2);
                        TempDataOutputStream obj = new TempDataOutputStream(0xd0005, l[k1].a);
                        obj.writeInt(c);
                        obj.write(3);
                        obj.write(1);
                        obj.sendMain(C);
                        n = false;
                        return;
                    }
                    if(g > 0 && !C.a)
                    {
                        Log.v(b(), (new StringBuilder("plants XianLing @ #")).append(l[k1].a).toString());
                        l[k1].d = 0;
                        (new TempDataOutputStream(0xd0002, 4L)).sendMain(C);
                        sleep(2);
                        TempDataOutputStream obj = new TempDataOutputStream(0xd0005, l[k1].a);
                        obj.writeInt(0);
                        obj.write(4);
                        obj.write(1);
                        obj.sendMain(C);
                        n = false;
                        return;
                    }
                    if(e > 0 && !web.sxd.b.MainThread.isFuncSelect(16))
                    {
                        Log.v(b(), (new StringBuilder("plants EXP @ #")).append(l[k1].a).toString());
                        l[k1].d = 0;
                        (new TempDataOutputStream(0xd0002, 2L)).sendMain(C);
                        sleep(2);
                        TempDataOutputStream obj = new TempDataOutputStream(0xd0005, l[k1].a);
                        obj.writeInt(e);
                        obj.write(2);
                        obj.write(1);
                        obj.sendMain(C);
                        n = false;
                        return;
                    }
                    j1 = i1;
                    if(l[k1].c > 0)
                    {
                        j1 = i1;
                        if(l[k1].c < i1)
                            j1 = l[k1].c;
                    }
                }
            k1++;
            i1 = j1;
        }

        n = false;
        j1 = i1;
        if(i1 == 28888) //8个小时 = 28888s
            j1 = 300;
        StringBuilder stringbuilder = new StringBuilder("　药园没有可用土地, ");
        Object obj;
        if(o)
            obj = "再等";
        else
            obj = "等待";
        obj = stringbuilder.append(((String) (obj))).toString();
        if(j1 < 60)
            web.sxd.b.MainThread.sendLog("%s %d秒", new Object[] {
                    obj, Integer.valueOf(j1)
            });
        else
        if(j1 < 4000)
            web.sxd.b.MainThread.sendLog("%s %d分钟", new Object[] {
                    obj, Integer.valueOf(j1 / 60)
            });
        else
            web.sxd.b.MainThread.sendLog("%s %d时 %d分", new Object[] {
                    obj, Integer.valueOf(j1 / 3600), Integer.valueOf((j1 / 60) % 60)
            });
        if(!o)
        {
            o = true;
            sleep(j1 * 5);
            o = false;
            (new TempDataOutputStream(0xd0000)).sendMain(C);
            return;
        }
        return;

    }

    @Override
    public final void a(TempDataInputStream l1)
    {
        try {


            int i1;
            int k1;
            int i2;
            i1 = 0;
            k1 = 0;
            i2 = 0;
            super.a(l1);
            switch (l1.getFuncCode()) {
                default:
                    return;
                case 851968://_L2  0xD0000
                    int k2;
                    k2 = l1.readUnsignedShort();
                    i1 = 0;
                    while (i1 < k2) {
                        int l2;
                        l2 = l1.readInt();
                        k1 = 0;

                        if (k1 < l.length) {
                            if (l[k1] == null) {
                                l[k1] = new web.sxd.d.h(this, l2, l1);
                            } else {
                                label0:
                                {
                                    if (l[k1].a != l2)
                                        break label0;
                                    l[k1].a(l1);
                                }
                            }

                        }
                        k1++;
                        i1++;

                    }
                    i1 = i2;
                    while(i1<l.length) {
                        if (l[i1] != null && l[i1].b()) {
                            Log.v(b(), (new StringBuilder("harvest @ #")).append(l[i1].a).toString());
                            (new TempDataOutputStream(0xd0006, l[i1].a, (byte) 15)).sendMain(C);
                            c();
                            l[i1].d = 1;
                        }
                        i1++;
                    }
                    e();
                    return;
                case 851969://_L3  0xD0001
                    if(web.sxd.b.MainThread.isFuncSelect(76))
                        f = 0;
                    else
                        f = C.g();
                    k1 = l1.readUnsignedShort();
                    i1 = 0;
                    do
                    {
                        if(i1 >= k1)
                        {
                            if(C.b(43) && h < 0)
                                (new TempDataOutputStream(0xd000c)).sendMain(C);
                            sleep(10);
                            o = false;
                            Log.i(b(), (new StringBuilder("Farm Role: max[")).append(c).append("] Lv.").append(d).append(" min[").append(e).append("] Lv.").append(f).toString());
                            String s1 = j;
                            i1 = d;
                            String s3 = k;
                            k1 = f;
                            String str;
                            if(web.sxd.b.MainThread.isFuncSelect(16))
                                str = "x";
                            else
                                str = "";
                            web.sxd.b.MainThread.sendLog("种地: %s %d级, %s %d级%s", new Object[] {
                                    s1, Integer.valueOf(i1), s3, Integer.valueOf(k1), str
                            });
                            (new TempDataOutputStream(0xd0000)).sendMain(C);
                            return;
                        }
                        i2 = l1.readInt();
                        l1.readUTF();
                        String s1 = l1.readUTF();
                        k2 = l1.readInt();
                        l1.skipBytes(28);
                        int l2 = l1.read();
                        if(k2 > d)
                        {
                            d = k2;
                            c = i2;
                            j = s1;
                        }
                        if(l2 == 5 && (!web.sxd.b.MainThread.isFuncSelect(76) && (k2 < f || k2 == f && i2 > e) || web.sxd.b.MainThread.isFuncSelect(76) && (k2 > f || k2 == f && i2 > e) && k2 < C.g()))
                        {
                            f = k2;
                            e = i2;
                            k = s1;
                        }
                        i1++;
                    } while(true);
                case 851970://_L4
                    Log.v(b(), String.format("get_herbs_seed: %d,%dYB|%d", new Object[]{
                            Integer.valueOf(l1.readInt()), Integer.valueOf(l1.readInt()), Integer.valueOf(l1.read())
                    }));
                    return;
                case 851971:
                    return;
                case 851972:
                    return;
                case 851973://_L5  0xD0005
                    String s4;
                    i2 = l1.read();
                    k1 = l1.readInt();
                    String s = b();
                    k2 = l1.readInt();
                    String s2 = l1.readUTF();
                    s4 = l1.readUTF();
                    Log.d(s, String.format("%dplant_herbs#%d: %d(%s)%s(Lv%d)%d/%d|%d(Lv.%d)", new Object[] {
                            Integer.valueOf(i2), Integer.valueOf(k1), Integer.valueOf(k2), s2, s4, Integer.valueOf(l1.readInt()), Long.valueOf(l1.readLong()), Long.valueOf(l1.readLong()), Integer.valueOf(l1.readInt()), Integer.valueOf(l1.readInt())
                    }));
                    h = l1.readInt();
                    g = l1.readInt();
                    l1.read();
                    k2 = l1.read();
                    switch (k2)
                    {
                        default :
                            web.sxd.b.MainThread.sendLog("　%s 种植id=%d树", new Object[] {
                                    s4, Integer.valueOf(k2)
                            });
                            break;
                        case 2 :
                            web.sxd.b.MainThread.sendLog("  %s 上阵等级最低,种植经验树", new Object[] {
                                    s4
                            });
                            break;
                        case 3 :
                            web.sxd.b.MainThread.sendLog("　%s 种植发财树, 剩 %d滴仙露", new Object[] {
                                    s4, Integer.valueOf(h)
                            });
                            break;
                        case 4 :
                            web.sxd.b.MainThread.sendLog("　自动种植仙令树, 剩余 %d 仙令种子", new Object[] {
                                    Integer.valueOf(g)
                            });
                            break;
                    }
                    c();
                    if(i2 != 8) {//地没种完
                        (new TempDataOutputStream(0xd0006, k1, (byte) 15)).sendMain(C);
                        sleep(2);
                        if (k2 != 2) {
                            while (i1 < l.length) {
                                if (l[i1] != null && l[i1].a == k1) {
                                    l[i1].d = 1;
                                    return;
                                }


                                i1++;
                            }
                        }
                        (new TempDataOutputStream(0xd0000)).sendMain(C);
                    }
                    return;
                case 851974://_L6  0xD0006
                    i1 = l1.read();
                    StringBuilder stringbuilder = new StringBuilder(l1.readUTF());
                    stringbuilder.append(" 收获");
                    stringbuilder.append(l1.readUTF().replace("普通", ""));
                    long l3 = l1.readLong();
                    k1 = l1.readInt();
                    if (l3 > 0L || k1 > 0) {
                        if (k1 > 0) {
                            stringbuilder.append((new StringBuilder(", 升至")).append(k1).append("级").toString());
                            if (k1 >= C.g())
                                e = 0;
                        }
                        stringbuilder.append((new StringBuilder(", 经验+")).append(l3).toString());
                    }
                    k1 = l1.readInt();
                    if (k1 > 0)
                        stringbuilder.append((new StringBuilder(", 铜钱+")).append(k1).toString());
                    k1 = l1.readInt();
                    if (k1 > 0)
                        stringbuilder.append((new StringBuilder(", 仙令+")).append(k1).toString());
                    if (l1.readInt() <= 0)
                        stringbuilder.append(",");
                    web.sxd.b.MainThread.sendLog(stringbuilder.toString());
                    Log.i(b(), (new StringBuilder(String.valueOf(i1))).append("harvest HerbsType ").append(l1.read()).toString());
                    return;
                case 851975:
                    return;
                case 851976:
                    return;
                case 851977:
                    return;
                case 851978://_L7
                    i1 = l1.readInt();
                    k1 = l1.readInt();
                    Log.v(b(), (new StringBuilder("plants: ")).append(k1).append("/").append(i1).toString());
                    if (k1 < i1 && k1 < i) {
                        i = k1;
                        sleep(3);
                        e();
                        return;
                    } else {
                        i = k1;
                        return;
                    }

                case 851979:
                    return;
                case 851980://_L8
                    h = l1.readInt();
                    c();
                    sleep(10);
                    if (o) {
                        web.sxd.b.MainThread.sendLog("　可种植 %d 棵发财树", new Object[]{
                                Integer.valueOf(h)
                        });
                        return;
                    }
                    l1.skipBytes(8);
                    i1 = l1.readInt();
                    if (h > 0) {
                        web.sxd.b.MainThread.sendLog("　可种植 %d 棵发财树", new Object[]{
                                Integer.valueOf(h)
                        });
                    } else {
                        if (i1 < 60)
                            web.sxd.b.MainThread.sendLog("%s %d秒", new Object[]{
                                    "　药园没有可用仙露, 等待", Integer.valueOf(i1)
                            });
                        else if (i1 < 4000)
                            web.sxd.b.MainThread.sendLog("%s %d分钟", new Object[]{
                                    "　药园没有可用仙露, 等待", Integer.valueOf(i1 / 60)
                            });
                        else
                            web.sxd.b.MainThread.sendLog("%s %d时 %d分", new Object[]{
                                    "　药园没有可用仙露, 等待", Integer.valueOf(i1 / 3600), Integer.valueOf((i1 / 60) % 60)
                            });
                        sleep(i1 * 5);
                    }
                    if (!n && C.b(15)) {
                        (new TempDataOutputStream(0xd0000)).sendMain(C);
                        return;
                    }
                    break;
                case 851981:
                    return;
                case 851982://_L9  0xD000E
                    i1 = l1.readInt();
                    web.sxd.b.MainThread.sendLog("　可种植 %d 棵发财树", new Object[]{
                            Integer.valueOf(i1)
                    });
                    if (i1 < h || h < 0) {
                        h = i1;
                        return;
                    }
                    h = i1;
                    if (!n && C.b(15)) {
                        (new TempDataOutputStream(0xd0000)).sendMain(C);
                        return;
                    }
                    break;
                case 851983:
                    return;
                case 851984:
                    return;
                case 851985://_L10
                case 851986://_L10
                    g = l1.readInt();
                    web.sxd.b.MainThread.sendLog("　可种植 %d 棵仙令树", new Object[]{
                            Integer.valueOf(g)
                    });
                    return;
                case 851987://_L11
                    if (l1.read() > 0) {
                        (new TempDataOutputStream(0xd0014)).sendMain(C);
                        return;
                    }
                    break;
                case 851988://_L12
                    if (l1.read() == 8) {
                        web.sxd.b.MainThread.sendLog("[药园]成功领取每日仙令 %s", new Object[]{
                                Integer.valueOf(l1.read())
                        });
                        return;
                    }
                    break;
                case 851989://_L13
                    k1 = l1.readUnsignedShort();
                    i1 = 0;
                    while(i1<k1)
                    {
                        a(l1.readInt(), l1);
                        i1++;
                    }
                    i1 = 0;
                    while (i1 < m.length)
                    {
                        if(m[i1] != null && m[i1].b())
                        {
                            Log.v(b(), (new StringBuilder("harvest @ #")).append(m[i1].a).toString());
                            (new TempDataOutputStream(0xd0019, m[i1].a)).sendMain(C);
                            c();
                            m[i1].d = 1;
                        }
                        i1++;
                    }
                    i2 = 28888;
                    k1 = 0;
                    while (k1 < m.length)
                    {
                        i1 = i2;
                        if(m[k1] != null)
                            if(!m[k1].a())
                            {
                                i1 = i2;
                                if(m[k1].c > 0)
                                {
                                    i1 = i2;
                                    if(m[k1].c < i2)
                                        i1 = m[k1].c;
                                }
                            } else
                            {
                                i1 = i2;
                                if(m[k1].c >= 0)
                                {
                                    i1 = i2;
                                    if(m[k1].c < i2)
                                        i1 = m[k1].c;
                                }
                            }
                        k1++;
                        i2 = i1;
                    }
                    if(i2 <= 0) {//有空闲的地
                        (new TempDataOutputStream(0xd0016)).sendMain(C);
                        return;
                    }
                    StringBuilder stringbuilder1 = new StringBuilder("　果园没有可用土地, ");
                    String str;
                    if(p)
                        str = "再等";
                    else
                        str = "等待";
                    str = stringbuilder1.append(str).toString();
                    if(i2 < 60) {
                        web.sxd.b.MainThread.sendLog("%s %d秒", new Object[]{
                                str, Integer.valueOf(i2)
                        });
                        return;
                    }
                    if(i2 < 4000)
                    {
                        web.sxd.b.MainThread.sendLog("%s %d分钟", new Object[] {
                                str, Integer.valueOf(i2 / 60)
                        });
                        return;
                    } else
                    {
                        web.sxd.b.MainThread.sendLog("%s %d时 %d分", new Object[] {
                                str, Integer.valueOf(i2 / 3600), Integer.valueOf((i2 / 60) % 60)
                        });
                        return;
                    }
                case 851990://_L14
                    i2 = l1.readUnsignedShort();
                    i1 = 0;
                    int i3;
                    while (i1<i2)
                    {
                        k2 = l1.readInt();
                        k1 = l1.readInt();
                        l1.readInt();
                        int l2 = l1.readInt();
                        i3 = l1.readInt();
                        if(k1 > 0) {
                            k1 = 0;
                            while (k1 < m.length) {
                                if (m[k1] == null || !m[k1].a() || k2 != 169 && k2 != 171 && k2 != 172 && k2 != 173 && k2 != 174)
                                {
                                    k1++;
                                    continue;
                                }
                                (new TempDataOutputStream(0xd0018, m[k1].a, k2)).sendMain(C);
                                k1++;
                            }
                        }
                        if((k2 == 169 || k2 == 171 || k2 == 172 || k2 == 173 || k2 == 174) && l2 > 0 && i3 == 0)
                            (new TempDataOutputStream(0xd0017, k2)).sendMain(C);
                        else
                            q = false;
                        i1++;
                    }
                    break;
                case 851991://_L15
                    if (l1.read() == 8 && q) {
                        (new TempDataOutputStream(0xd0016)).sendMain(C);
                        return;
                    }
                    break;
                case 851992://_L16
                    if (l1.read() == 8) {
                        int j2 = l1.readInt();
                        (new TempDataOutputStream(0xd0019, j2)).sendMain(C);
                        c();
                        int j1 = k1;
                        while (j1 < m.length) {
                            if (m[j1].a == j2) {
                                m[j1].d = 1;
                                return;
                            }
                            j1++;
                        }
                    }
                    return;
                case 851993://_L17
                    (new TempDataOutputStream(0xd0015)).sendMain(C);
                    return;
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.d.g",e.getLocalizedMessage(),e);
        }
    }

    protected final String[] a()
    {
        return a;
    }

    private static final String a[] = {
        "FARM_", "get_farmlandinfo_list", "get_player_roleinfo_list", "get_herbs_seed", "refresh_herbs_seed", "get_top_herbs_seed", "plant_herbs", "harvest", "reclamation", "check_role_state",
        "harvest_check_remain_exp", "get_simple_farmlandinfo", "clear_farmland_cd", "buy_coin_tree_count_info", "buy_coin_tree_count", "coin_tree_count_notify", "ingot_for_farmland", "up_farmland_level", "xianling_tree_count_notify", "xianling_tree_count_info",
        "is_player_get_xian_ling_gift", "player_get_xian_ling_gift", "get_new_farmlandinfo_list", "new_farmland_herbs_list", "buy_new_herbs", "plant_new_herbs", "harvest_new", "new_clear_farmland_cd"
    };
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private String j;
    private String k;
    private web.sxd.d.h l[];
    private i m[];
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;

}