import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;

/**
 * Created with Android Studio.
 * Desc: TimeUtils
 * 时间格式解析工具类
 *
 */
public class TimeUtils {

    /**
     * Parse the time in milliseconds into String with the format: hh:mm:ss or mm:ss
     *
     * @param duration The time needs to be parsed.
     */
    @SuppressLint("DefaultLocale")
    public static String formatDuration(long duration) {
        duration /= 1000; // milliseconds into seconds
        long minute = duration / 60;
        long hour = minute / 60;
        minute %= 60;
        long second = duration % 60;
        if (hour != 0)
            return String.format("%2d:%02d:%02d", hour, minute, second);
        else
            return String.format("%02d:%02d", minute, second);
    }

    @SuppressLint("DefaultLocale")
    public static String formatDuration2(int duration) {
        //duration /= 1000; // milliseconds into seconds
        long minute = duration / 60;
        long hour = minute / 60;
        minute %= 60;
        long second = duration % 60;
        if (hour != 0)
            return String.format("%2d:%02d:%02d", hour, minute, second);
        else
            return String.format("%02d:%02d", minute, second);
    }

    public static String formatLongToDate(long longTime){
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 HH:mm");
        return sdf.format(longTime);
    }
}
