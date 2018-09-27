// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:44
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.b;

import android.util.Log;
import java.util.Random;

// Referenced classes of package web.sxd.b:
//            c, l

public abstract class h
{

    public h(MainThread c1, int i)
    {
        a = false;
        C = c1;
        C.a(i / 0x10000, this);
    }

    protected static final String a(int i, String as[])
    {
        if(i + 1 < as.length)
            return (new StringBuilder(String.valueOf(as[0]))).append("(").append(i).append(")").append(as[i + 1]).toString();
        else
            return (new StringBuilder(String.valueOf(as[0]))).append(i).toString();
    }

    public static void a(int i)
    {
        if(i <= 0)
            return;
        if(i <= 10)
            try
            {
                Thread.sleep((D.nextInt(40) + 181) * i);
                return;
            }
            catch(InterruptedException interruptedexception)
            {
                return;
            }
        try {
            Thread.sleep((long)i * 200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return;
    }

    protected static void c()
    {
        try
        {
            Thread.sleep(D.nextInt(40) + 81);
            return;
        }
        catch(InterruptedException interruptedexception)
        {
            return;
        }
    }

    public void a(l l1)
    {
        Log.d(a()[0], a(l1.e(), a()));
    }

    protected abstract String[] a();

    protected final String b()
    {
        return a()[0];
    }

    protected final void b(int i)
    {
        boolean flag = false;
        if(i >= 327) goto _L2; else goto _L1
_L1:
        a(i);
_L4:
        return;
_L2:
        int j;
        int k;
        try
        {
            Thread.sleep((i % 50) * 200);
            k = i / 5;
            j = k / 10;
        }
        catch(InterruptedException interruptedexception)
        {
            return;
        }
        i = ((flag) ? 1 : 0);
_L6:
        if(j <= 0) goto _L4; else goto _L3
_L3:
        if(a)
        {
            Log.v(a()[0], (new StringBuilder("Interrupted ")).append(j).append("0s / ").append(k).toString());
            return;
        }
          goto _L5
_L7:
        Log.v(a()[0], (new StringBuilder("Waiting for ")).append(j).append("0s / ").append(k).toString());
_L8:
        Thread.sleep(10000L);
        j--;
        i++;
          goto _L6
_L5:
        if(j >= 10 && i % 10 != 0) goto _L8; else goto _L7
    }

    protected final void d()
    {
        a = true;
    }

    protected static Random D = new Random();
    protected MainThread C;
    private boolean a;

}