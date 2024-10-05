package ir.kamali.fruitland;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;

public class G extends Application {
    public static Handler handler = new Handler();
    public static  Activity mCurrentActivity = null;
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
