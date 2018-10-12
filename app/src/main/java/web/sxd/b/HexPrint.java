package web.sxd.b;

/**
 * Created by fdc on 2018-10-12.
 */

public class HexPrint {
    public static String Print(byte[] bytes)
    {
        StringBuilder sb = new StringBuilder();
        for (byte b:bytes
             ) {
            ;
            sb.append(String.format("0x%X",b));
        }
        return sb.toString();
    }
}
