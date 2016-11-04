package khalifa.ahmad.easyfunder.storage.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {
    private static String FIRST_TIME_LAUNCH = "FirstTimeLaunch";
    private static String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static int PRIVATE_MODE = 0;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public SharedPreferencesManager(Context context){
        preferences = context.getSharedPreferences(FIRST_TIME_LAUNCH, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public boolean isFirstTimeLaunch(){
        return preferences.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void setFirstTimeLaunch(boolean isFirstTime){
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }
}
