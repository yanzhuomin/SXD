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
            }
        };
    }
}
