// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:45
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.c;

import android.util.Log;
import web.sxd.b.*;
import web.sxd.d.b;
import web.sxd.d.n;

/**
 * 聊天
 * */
public final class Chat extends BaseFunc
{

    public Chat(MainThread c1)
    {
        super(c1, 0x60001);
    }

    public static void a(MainThread c1, int i, String s) throws Exception
    {
        int j = i;
        if(i == 2)
        {
            j = i;
            if(!c1.b(13))
                j = 0;
        }
        Log.i(a[0], (new StringBuilder(String.valueOf(j))).append(s).toString());
        TempDataOutputStream m1 = new TempDataOutputStream(0x60000);
        m1.write(j);
        m1.writeUTF(s);
        m1.writeUTF("");
        m1.writeUTF("");
        m1.sendMain(c1);
    }

    public final void a(TempDataInputStream l1)
    {
        try {

            switch (l1.getFuncCode()) {
                default:
                    return;
                case 393217:
                    int i;
                    int j;
                    j = l1.readUnsignedShort();
                    i = 0;
                    while (i < j) {
                        int k;
                        int i1;
                        Object obj;
                        k = l1.readInt();
                        obj = new StringBuilder((new StringBuilder(String.valueOf(l1.readUTF()))).append(": ").toString());
                        if (l1.read() == 1)
                            ((StringBuilder) (obj)).insert(0, '@');
                        if (l1.read() == 1)
                            ((StringBuilder) (obj)).insert(0, '*');
                        i1 = l1.read();
                        switch (i1) {
                            default:
                                break;
                            case 0:
                                ((StringBuilder) (obj)).insert(0, "[活动]");
                                break;
                            case 1:
                                ((StringBuilder) (obj)).insert(0, "[世界]");
                                break;
                            case 2:
                                ((StringBuilder) (obj)).insert(0, "[帮派]");
                                break;
                            case 3:
                                break;
                            case 4:
                                ((StringBuilder) (obj)).insert(0, "[仙界]");
                                break;
                            case 5:
                                ((StringBuilder) (obj)).insert(0, "[仙盟]");
                                break;
                            case 6:
                                ((StringBuilder) (obj)).insert(0, "[圣域]");
                                break;
                            case 7:
                                break;
                            case 8:
                                break;
                            case 9:
                                break;
                            case 10:
                                break;
                            case 11:
                                break;
                            case 12:
                                break;
                            case 13:
                                break;
                            case 14:
                                break;
                            case 15:
                                ((StringBuilder) (obj)).insert(0, "<喇叭>");
                                break;
                        }
                        String s = l1.readUTF();
                        String s1 = l1.readUTF();
                        if (s.length() > 0) {
                            ((StringBuilder) (obj)).append(s.replace(b.a[0], "魔王_"));
                            MainThread.sendLog(((StringBuilder) (obj)).toString());
                        } else {
                            MainThread.sendLog("%s[表情%s]", new Object[]{
                                    ((StringBuilder) (obj)).toString(), s1
                            });
                        }
                        obj = String.format("(%d)%s;%s;%s mt%d %s@%d", new Object[]{
                                Integer.valueOf(k), ((StringBuilder) (obj)).toString(), s1, l1.readUTF(), Integer.valueOf(i1), n.c(l1.readInt()), Integer.valueOf(l1.readInt())
                        });
                        Log.i(b(), ((String) (obj)));
                        i++;
                    }
            }
        }catch (Exception e)
        {
            Log.v("web.sxd.c.a",e.getLocalizedMessage(),e);
        }
    }

    protected final String[] a()
    {
        return a;
    }

    private static final String a[] = {
        "Chat_", "chat_with_players", "bro_to_players", "", "", "", "", "send_all", "send_all_message", "", 
        "", "", "send_all_speaker_message"
    };

}