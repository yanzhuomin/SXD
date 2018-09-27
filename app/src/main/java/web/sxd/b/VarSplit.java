// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:44
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.b;

/*
*
* JS中flashVars的分割查找变量
* */
public final class VarSplit
{

    public VarSplit(String s)
    {
        a = s;
        b = s.toLowerCase();
    }

    /*
    * 查找变量的值
    * */
    public final String Find(String s, String s1)
    {
        c = b.indexOf(s, 0);
        if(c < 0)
        {
            return "";
        } else
        {
            int i = c + s.length();
            int j = b.indexOf(s1, i);
            return a.substring(i, j);
        }
    }

    private String a;
    private String b;
    private int c;
}