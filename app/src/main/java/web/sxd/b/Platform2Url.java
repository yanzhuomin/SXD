// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:44
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.b;


public final class Platform2Url
{

    public static String getUrl(String s)
    {
        String s1 = "http://sxd.xd.com";
        if(s != null && s.length() != 0)
        {
            int i = s.indexOf('.');
            if(i != 0) {
                s1 = s;
                if (i <= 0)
                {
                    s1 = s1.toLowerCase();
                    if (s1.equals("iqiyi") || s1.equals("pps"))
                        return "http://Notify.iqiyi.com/shenxiandao";
                } else {
                    s1 = s;
                    if (!s.startsWith("http://"))
                        return (new StringBuilder("http://")).append(s).toString();
                }
            }else
            {
                s1 = s.substring(s.lastIndexOf('.') + 1);
//                int j;
//                do {
//                    j = Town + 1;
//                    Town = j;
//                } while (s.charAt(j) == '.');
//                s1 = s.substring(j);
            }

        }else
        {
            s1 = "http://sxd.xd.com";
            return s1;
        }


        if(s1.startsWith("http://playgame.iqiyi.com/login/iframe_page_web/top?game_id=171&server_order="))
            return s1.replace("login/iframe_page_web/top", "togame/entry_web");
        if(s1.equals("qq833") || s1.equals("QQ833"))
            return "http://qq833.com/game/sxd/";
        if(s1.equals("jd"))
            return "http://jd.zf.xd.com/sxd";
        if(s1.equals("ledu"))
            return "http://sx.ledu.com";
        if(s1.indexOf("ledu") > 0)
            return s1.replace(".game.ledu.com", ".ledu.com");
        if(s1.equals("51"))
            return "http://game.51.com/sxd/";
        if(s1.equals("115"))
            return "http://wan.115.com/sxd";
        if(s1.equals("373"))
            return "http://www.373you.com/game/sxd.phtml";
        if(s1.equals("6711"))
            return "http://www.6711.com/servers_list_sxd.php";
        if(s1.equals("4399"))
            return "http://my.4399.com/yxsxd";
        if(s1.equals("591pk"))
            return "http://www.591pk.com/sxd";
        if(s1.equals("175ha"))
            return "http://user.175ha.com/Game/Areas/sxd";
        if(s1.equals("kaixin"))
            return "http://game.kaixin001.com/sxd.html";
        if(s1.equals("91y"))
            return "http://www.91y.com.cn/game.php?action=server_list&game_id=11";
        if(s1.equals("awo"))
            return "http://www.awo.cn/webGame/sxd/index.aspx";
        if(s1.equals("xilu"))
            return "http://game.xilu.com/ShowGame.aspx?Id=10";
        if(s1.equals("zixia"))
            return "http://game.zixia.com/game-sxd";
        if(s1.equals("xunlei"))
            return "http://sxd.xunlei.com";
        if(s1.equals("sina") || s1.equals("wanwan"))
            return "http://wanwan.sina.com.cn/sxd";
        if(s1.equals("sxddj"))
            return "http://sxddj.wanwan.sina.com.cn";
        if(s1.equals("weibo"))
            return "http://game.weibo.com/shenxiandao";
        if(s1.equals("qq") || s1.equals("dh"))
            return "http://dh.qq.com/server/server.shtml";
        if(s1.equals("txwy") || s1.equals("tw"))
            return "http://sxd.txwy.tw";
        if(s1.equals("360") || s1.equals("1360"))
            return "http://sxd.wan.360.cn/game_login.php";
        if(s1.equals("baidu") || s1.equals("xxj"))
            return "http://youxi.baidu.com/xxj/index/";
        if(s1.equals("ayoyo") || s1.equals("fsllq") || s1.equals("caijun") || s1.equals("ad") || s1.equals("sb") || s1.equals("lgd") || s1.equals("bk") || s1.equals("sc") || s1.equals("xm") || s1.equals("pk") || s1.equals("ss") || s1.equals("dt") || s1.equals("zh") || s1.equals("7"))
            return (new StringBuilder("http://")).append(s1).append(".xd.com").toString();
        s = s1;
        if(s1.equals("vv"))
            s = (new StringBuilder(String.valueOf(s1))).append("wan").toString();
        s1 = s;
        if(s.equals("sogou"))
            s1 = (new StringBuilder("wan.")).append(s).toString();
        return (new StringBuilder("http://sxd.")).append(s1).append(".com").toString();
    }

    public static final String a[] = {
        "sxd/Login.aspx?", "175ha.com/Game/PlayInterface", "/yxsxd/?ac=go&sid=", "game.zixia.com/sxd/", "/ingame.php?game_id=", "weibo/sxd?action=play", ".sxd.renren.com/?f=", ".591pk.com/goto/", "/InGame.aspx?gameId=", "GameCenter/Start/start.ashx?GameID=29&ServerID=", 
        "/PayGame.aspx?gid=", "175pt.com/pt/Server", "game_play.php?sid=", "api/kaixin/login.php", "/login_game_by_post.xhtml?", "/playgame.do?", "glogin.aspx?", "/login_api", "360.cn/game_login.php?", ".qqopenapp.com/index.php?", 
        "/EnterGame.ashx?", "/game.php?", "/ingame.php?", "6fan.com?do=run&sid=", "6711.com/entergame.php"
    };

}