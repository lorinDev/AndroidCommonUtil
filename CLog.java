
import android.util.Log;

/**
 * Created by czj on 2017/9/21.
 * 自定义Log,通过CURRENT_LV可以控制Log级别的显示与不显示
 */

public class CLog {

    private static final int VERBOSE = 1;
    private static final int DEBUG = 2;
    private static final int INFO = 3;
    private static final int WARN = 4;
    private static final int ERROR = 5;
    private static final int NULL = 6;
    private static final String TAG = "czj";

    //控制log级别的开关
    private static final int CURRENT_LV = VERBOSE;

    public static void v(String tag, String msg){
        if (CURRENT_LV <= VERBOSE){
            Log.v(tag,msg);
        }
    }

    public static void v(String msg){
        if (CURRENT_LV <= VERBOSE){
            Log.v(TAG,msg);
        }
    }

    public static void d(String tag, String msg){
        if (CURRENT_LV <= DEBUG){
            Log.d(tag,msg);
        }
    }

    public static void d(String msg){
        if (CURRENT_LV <= DEBUG){
            Log.d(TAG,msg);
        }
    }

    public static void i(String tag, String msg){
        if (CURRENT_LV <= INFO){
            Log.i(tag,msg);
        }
    }

    public static void i(String msg){
        if (CURRENT_LV <= INFO){
            Log.i(TAG,msg);
        }
    }

    public static void w(String tag, String msg){
        if (CURRENT_LV <= WARN){
            Log.w(tag,msg);
        }
    }

    public static void w(String msg){
        if (CURRENT_LV <= WARN){
            Log.w(TAG,msg);
        }
    }

    public static void e(String tag, String msg){
        if (CURRENT_LV <= ERROR){
            Log.e(tag,msg);
        }
    }
    public static  void e(String msg){
        if (CURRENT_LV <= ERROR){
            Log.e(TAG,msg);
        }
    }

}
