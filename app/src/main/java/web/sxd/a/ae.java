//// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:39
//// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
//// Decompiler options: packimports(3)
//
//package web.sxd.a;
//
//import web.sxd.b.*;
//
//// Referenced classes of package web.sxd.a:
////            ad
//
//public final class ae extends BaseFunc
//{
//
//    public ae(MainThread c1)
//    {
//        super(c1, 0x1230000);
//    }
//
//    public static void a(MainThread c1)
//    {
//        (new TempDataOutputStream(0x1230000)).sendMain(c1);
//    }
//
//    public static void b(MainThread c1)
//    {
//        (new TempDataOutputStream(0x1230004)).sendSY(c1);
//    }
//
//    public final void a(TempDataInputStream l1)
//    {
//        int i;
//        i = 0;
//        super.a(l1);
//        l1.c();
//        JVM INSTR tableswitch 19070976 19070980: default 44
//    //                   19070976 45
//    //                   19070977 44
//    //                   19070978 44
//    //                   19070979 44
//    //                   19070980 159;
//           goto _L1 _L2 _L1 _L1 _L1 _L3
//_L1:
//        return;
//_L2:
//        int k = l1.readUnsignedShort();
//_L7:
//        if(i < k) goto _L5; else goto _L4
//_L4:
//        l1.read();
//        l1.readUnsignedShort();
//        return;
//_L5:
//        l1.read();
//        l1.read();
//        if(l1.read() != 1)
//            break; /* Loop/switch isn't completed */
//        new ad(C);
//        c();
//        ad.a(C);
//        if(true) goto _L4; else goto _L6
//_L6:
//        l1.skipBytes(l1.readUnsignedShort() * 6);
//        l1.readInt();
//        l1.readUTF();
//        l1.readUTF();
//        l1.read();
//        l1.readInt();
//        l1.readInt();
//        i++;
//          goto _L7
//_L3:
//        int j = l1.read();
//        l1.readInt();
//        int i1 = l1.readInt();
//        l1.readUnsignedShort();
//        if(j == 0)
//            if(i1 >= 3600)
//            {
//                c.a("[\u5723\u57DF]\u5269\u4F59\u4FEE\u70BC\u65F6\u95F4: %d\u5C0F\u65F6 %d\u5206\u949F", new Object[] {
//                    Integer.valueOf(i1 / 3600), Integer.valueOf((i1 % 3600) / 60)
//                });
//                return;
//            } else
//            {
//                c.a("[\u5723\u57DF]\u5269\u4F59\u4FEE\u70BC\u65F6\u95F4: %d\u5206\u949F", new Object[] {
//                    Integer.valueOf(i1 / 60)
//                });
//                return;
//            }
//        if(true) goto _L1; else goto _L8
//_L8:
//    }
//
//    protected final String[] a()
//    {
//        return a;
//    }
//
//    private static final String a[] = {
//        "SAPRACTICE_", "get_enter_saint_area_info", "find", "get_npc_shop_info", "buy_prop", "get_practice_info", "notify_saint_area_status"
//    };
//
//}