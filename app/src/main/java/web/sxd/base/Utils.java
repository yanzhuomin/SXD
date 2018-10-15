package web.sxd.base;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;

import dalvik.system.DexFile;

/**
 * Created by fdc on 2018-10-13.
 */


public class Utils {

    public static final int TAG_MAIN=0;
    public static final int TAG_XJ=1;
    public static final int TAG_SY=2;
    public static final int TAG_QW=3;

    public static void sleepOne(int i)
    {
        if(i <= 0)
            return;
        if(i <= 10)
        {
            try
            {
                Thread.sleep((40/*D.nextInt(40)*/ + 181) * i);
                return;
            }
            catch(InterruptedException interruptedexception)
            {
                return;
            }
        }
        try {
            Thread.sleep((long)i * 200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return;
    }

    public static void sleep(int i)
    {
        boolean flag = false;
        if(i >= 327)
        {
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
            while (j>0) {
//                if (a) {
//                    Log.v(a()[0], (new StringBuilder("Interrupted ")).append(j).append("0s / ").append(k).toString());
//                    return;
//                }
//                if (j >= 10 && i % 10 != 0) {
//                } else {
//                    Log.v(a()[0], (new StringBuilder("Waiting for ")).append(j).append("0s / ").append(k).toString());
//                }
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                j--;
                i++;
            }
        }else
        {
            sleepOne(i);
            return;
        }
    }


    /*
    *  sleep 100ms
    * */
    protected static void sleep()
    {
        try
        {
            Thread.sleep(40 + 81);
            return;
        }
        catch(InterruptedException interruptedexception)
        {
            return;
        }
    }


}
