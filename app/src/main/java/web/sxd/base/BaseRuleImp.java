package web.sxd.base;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by fdc on 2018-10-14.
 */

public interface BaseRuleImp {

    //public LinkedHashMap<Integer,Integer> getList();
    //public void start();

    public int getFuncCode();
    public int getWaitReason();
    public int getArg();
    //public int waitFor();
    public void start();
    public boolean next();
}
