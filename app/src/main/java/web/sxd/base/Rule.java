package web.sxd.base;

/**
 * Created by fdc on 2018-10-14.
 */

public class Rule
{
    public static final int WAIT_NONE=0;
    public static final int WAIT_FUNC_FINSH=1;//等待功能完成
    public static final int WAIT_FUNC_SUCCESS=2;//等待功能成功
    public static final int WAIT_TIME=3;
    public static final int WAIT_FUNC_TRIGGER=4;//等待触发


    public Rule(int funcCode,int waitReason,int arg)
    {
        FuncCode=funcCode;
        WaitReason =waitReason;
        Arg = arg;
    }
    public int FuncCode;  //将要执行的功能码
    public int WaitReason;//等待原因
    public int Arg;         //参数
}
