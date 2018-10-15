package web.sxd.base;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by fdc on 2018-10-14.
 */

public abstract class BaseRule implements BaseRuleImp {

    public boolean state;
    protected static List<Rule> list ;
    private  int index=0;

    @Override
    public void start()
    {
        if(list.get(0).WaitReason==Rule.WAIT_NONE)
            state=true;
        state=false;
        index=0;
    }
    @Override
    public boolean next()
    {
        if( list.size() <= (index+1) ) {
            state=false;
            return false;
        }
        index++;
        if(list.get(index).WaitReason==Rule.WAIT_NONE)
            state=true;
        state=false;
        return true;
    }




    @Override
    public int getFuncCode()
    {
        return list.get(index).FuncCode;
    }
    @Override
    public int getWaitReason()
    {
        return list.get(index).WaitReason;
    }
    @Override
    public int getArg()
    {
        return list.get(index).Arg;
    }




}
