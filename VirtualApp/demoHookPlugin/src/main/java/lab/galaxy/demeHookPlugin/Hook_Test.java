package lab.galaxy.demeHookPlugin;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Hook_Test {
    public static String className = "com.xingin.xhs.index.indexNewActivity";
    public static String methodName = "onCreate";
    public static String methodSig = "(Landroid/os/Bundle;)V";

    public static Activity LauncherUi;

    public static void hook(Object thiz, Bundle b) {
        Log.w("zyz", "LauncherUI oncreate");
    }

    public static void backup(Object thiz, Bundle b) {
        Log.w("YAHFA", "LauncherUI backup");
    }
}
