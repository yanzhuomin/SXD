package web.sxd.Rule;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import web.sxd.base.BaseRule;
import web.sxd.base.BaseRuleImp;
import web.sxd.base.Rule;

/**
 * Created by fdc on 2018-10-14.
 */

public class MainLoginRule extends BaseRule {

    static {
        list = new ArrayList<Rule>(){
            {
                add(0,new Rule(0x0002,Rule.WAIT_FUNC_FINSH,0x0000));  //获取登陆角色信息
                add(1,new Rule(0x0009,Rule.WAIT_FUNC_FINSH,0x0002));
                add(2,new Rule(0x002E,Rule.WAIT_TIME,200));
                add(3,new Rule(0x0006,Rule.WAIT_FUNC_FINSH,0x002E));
                add(4,new Rule(0x0023,Rule.WAIT_TIME,200));
                add(5,new Rule(0x0030,Rule.WAIT_TIME,200));
                add(6,new Rule(0x002A,Rule.WAIT_TIME,200));
                add(7,new Rule(0x0014,Rule.WAIT_FUNC_FINSH,0x0002A));
                add(8,new Rule(0x1f0000,Rule.WAIT_TIME,5000));//送花
                add(9,new Rule(0x0006,Rule.WAIT_TIME,5000));//领取面板
                add(10,new Rule(0x220012,Rule.WAIT_TIME,5000));//领取灵石

            }
        };
    }
}
