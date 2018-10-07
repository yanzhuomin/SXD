// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 2018/9/25 13:11:45
// Home Page: http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 

package web.sxd.c;

import web.sxd.d.m;


public abstract class c
{
    //显示功能设置中禁用的功能
    public static final String a()
    {
        StringBuilder stringbuilder = new StringBuilder(b[0]);
        int i = 1;
        boolean flag = false;
        do
        {
            if(i >= b.length)
            {
                if(!flag)
                    stringbuilder.append(" 无");
                return stringbuilder.toString();
            }
            boolean flag1 = flag;
            if(web.sxd.b.MainThread.isFuncSelect(i))
            {
                if(flag)
                    stringbuilder.append(',');
                else
                    flag = true;
                if(b[i].charAt(0) != ' ')
                    stringbuilder.append(' ');
                stringbuilder.append(b[i]);
                flag1 = flag;
            }
            i++;
            flag = flag1;
        } while(true);
    }

    public static final String a[];
    private static final String b[] = {
            "　已禁用:", "强化", "培养主角武力", "└全员上阵(否则单主角)", "├非帮派BOSS鼓舞", "世界", "成就", "└圣域擂台赛", "  └帮派转盘", "坐骑",
            "├X8/X9级时才培养", "好友", "3分钟无消息/断线重连", "帮派功能", "日常", "种植药园", "└种植经验树", "离线", "活动", "仓库",
            "  ├点亮姜子牙后停止", "  └合成背包命格", "  ├拾取(合成)紫色命格", "精英", "└自动猎命", "└退出重进连杀高队伍", "招财神符", "├拦截悟空等(耗流量)", "技能", "└主角满后培养杨戬",
            "领取奖励", "└只领已知(避免包满)", "├打开已知礼包(测试)", "每日俸禄", "仙旅奇缘", "└卖出5级卷&BOSS卡", "结婚赠送亲密度", "阵营战", "副本扫荡", "世界BOSS",
            "购买体力", "本服竞技", "神秘商店", "├铜钱树(等级最高者)", "护送取经", "送花", "六道轮回塔免费刷新", "传承", "领取灵石", "查看属性",
            "替身娃娃", "├精英扫荡", "首杀", "渡劫", "吉星高照", "拜关公", "摘仙桃", "阵_营_战", "生肖", "寻找单身狗",
            "培养龙宠", "功能大厅", "仙梦", "灵猫寻宝", "小助手", "光环战记", "周榜", "百炼壶", "道行奖励", "特殊伙伴",
            "画龙鱼", "精简面板", "符印", "替补", "大闹天宫", "神器", "  └上阵最低种(否则最高)", "└X仙令树", "藏经阁", "活跃度",
            "云中界伙伴", "└不进行铜钱猎妖", "神甲", "神通", "神仙幻境", "灵脉采集", "免费猎妖3次", "  └挑战战力高于自己的", "聚宝盆", "龙珠",
            "仙界护送取经", "仙界城镇(稍耗流量)", "血脉", "├神魔竞技自动挑战", "├仙界练功房", "战力查看", "混沌虚空", "仙界道缘", "猎命师的猫", "仙界战帖",
            "八仙过海", "神兵", "├仙界道缘商店(灵珠)", "├仙界道缘商店(真元)", "主角成仙", "仙界伙伴", "自定义挑战", "金丹", "比较战力", "橙装",
            "功能110", "功能111", "功能112", "功能113", "功能114", "功能115", "活动", "五行天仪(-铜钱)", "功能118", "功能119",
            "功能120", "功能121", "功能122", "混沌虚空", "功能124", "功能125", "禁地之书", "领取奖励", "功能128", "结婚宝箱",
            "功能130", "功能131", "├仙界竞技场", "宠物房", "钓鱼", "五福临门", "功能136", "功能137", "功能138", "失却之阵",
            "结缘宝箱(包满自动合成)", "功能141", "幸运大转盘", "壶中界", "功能144", "功能145", "聚灵", "功能147", "功能148", "功能149",
            "功能150", "功能151", "功能152", "功能153", "功能154", "功能155", "功能156", "└仙界矿山", "功能158", "功能159",
            "百炼乾坤(一键闯关)", "功能161", "功能162", "功能163", "圣器淬炼池(-铜钱)", "圣域(挂机)", "缘魂宝箱(-铜钱)", "功能167", "功能168", "兵法(-铜钱)",
            "功能170", "└种植果园(-铜钱)", "孩子培养", "劫镖", "功能174", "功能175", "功能176", "功能177", "神仙典当行", "全网聊天",
            "全网聊天", "HorseSkill", "ServerTower", "DanceAction", "Email", "ElixirSoul"
    };
    private static final String c[] = {
            "　已禁用:", "强化", "培养", "布阵", "", "世界", "成就", "Medical", "奇术", "坐骑",
            "", "好友", "HorseRaces", "帮派", "DailyQuest", "药园", "Sport", "OfflineExp", "伙伴", "仓库",
            "", "", "", "英雄副本", "猎命", "", "招财神符", "", "Stunt", "",
            "PK", "ExtraPower", "在线礼包", "领取俸禄", "仙旅奇缘", "练功", "EquipUpgradeQueue", "阵营战", "副本扫荡", "世界Boss",
            "购买体力", "竞技场", "神秘商人", "发财树", "TakeBible", "送花", "六道轮回", "传承", "SealSoul", "WarAttribute",
            "Robot", "英雄扫荡", "FirstAttcak", "DuJie", "吉星高照", "拜关公", "摘仙桃", "HeroesWar", "Zodiac", "武魂",
            "PetAnimal", "FunctionHall", "DreamSection", "CatHunt", "小助手", "HaloRole", "周排行榜", "Furnace", "道行奖励", "成仙志",
            "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "",
            "护送取经", "", "血脉", "", "练功房", "战力", "混沌虚空", "SuperTownLevel", "FateCat", "StFightCard",
            "八仙过海", "神兵", "仙界商店", "", "", "", "自定义挑战", "", "", "",
            "", "", "极限挑战", "五行天仪", "", "", "", "", "", "",
            "", "卡魂", "", "", "", "好友助手", "觉醒", "", "", "",
            "魔石", "庄园", "", "宠物", "钓鱼", "CourtyardFurnace", "FindImmortal2", "六道轮回塔(二)", "RoleToSage", "失却之阵",
            "结缘", "LinkFatePve", "LinkFateBox", "PotWorld", "RoleScrap", "威望", "天书", "聚灵", "GoldOilOpenLight", "聚元",
            "StPanTao", "坐骑套装", "MiracleFighters", "LunHui", "MainRoleSaint", "GhostlyTower", "StAltar", "StMine", "DragonballNewGrid", "MountUpgrade",
            "百炼乾坤", "MagicWeapon", "GhostlyTower2", "RefinePool", "圣器", "圣域", "天缘录", "双修", "", "",
            "", "", "", "", "", "", "", "", "", "神仙典当行",
            ""
    };
    private static final String d[] = {
        "Body", "Upgrade", "Deploy", "PartnerSoul", "LinkFate", "Dragonball", "SealSoul", "Fate", "Awake", "MagicWeapon", 
        "Children", "JuYuan", "Friend", "MountOrSuit", "Tactics", "PartnerLink", "PartnerPractice", "SantWeapon", "MiracleFighters", "Faction", 
        "TianShu", "CardSoul", "Library", "Practice"
    };

    static 
    {
        int i = 0;
        int j = m.a.length;
        a = new String[j];
        do
        {
            if(i >= j)
                break;
            a[i] = b[m.a[i]];
            i++;
        } while(true);
    }
}