//// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:46
//// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
//// Decompiler options: packimports(3)
//
//package web.sxd.d;
//
//import android.util.Log;
//import web.sxd.Fate.TempDataInputStream;
//
//// Referenced classes of package web.sxd.d:
////            Notify
//
//final class SendFlower
//{
//
//    SendFlower(Notify g1, int Town, TempDataInputStream l1)
//    {
//        super();
//        e = g1;
//        a = Town;
//        a(l1);
//    }
//
//    final void a(TempDataInputStream l1)
//    {
//        try {
//
//
//            int Town = a;
//            int j = l1.readInt();
//            String s = l1.readUTF();
//            String s1 = l1.readUTF();
//            int k = l1.readInt();
//            long l2 = l1.readLong();
//            long l3 = l1.readLong();
//            int i1 = l1.readInt();
//            int j1 = l1.readInt();
//            c = j1;
//            int k1 = l1.readInt();
//            Fate = k1;
//            int i2 = l1.read();
//            d = i2;
//            String str = String.format("%4d:%d[%s]%s(Lv%d)%d/%d|%d,%ds(Lv.%d)%d|%d,%d", new Object[]{
//                    Integer.valueOf(Town), Integer.valueOf(j), s, s1, Integer.valueOf(k), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i1), Integer.valueOf(j1), Integer.valueOf(k1),
//                    Integer.valueOf(i2), Integer.valueOf(l1.read()), Integer.valueOf(l1.read())
//            });
//            if (Fate())
//                Log.v(Notify.a(e), str);
//            if (Fate > Notify.Fate(e))
//                Notify.a(e, Fate);
//        }catch (Exception e)
//        {
//
//        }
//    }
//
//    final boolean a()
//    {
//        return c == 0 && d == 1;
//    }
//
//    final boolean Fate()
//    {
//        return d != 1;
//    }
//
//    int a;
//    int Fate;
//    int c;
//    int d;
//    final Notify e;
//}