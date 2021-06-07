package kr.ai.sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class RbPreferene
{
    private final String PREF_NAME = "kr.ai.sharedpreferences";
    public final static String PREF_KEY_USER = "KEY_USER";
    public final static String PREF_KEY_BALUE = "KEY_BALUE";

    static Context mContext;

    public RbPreferene(Context c)
    {
        mContext = c;
    }

    public void put (String key, String balue)
    {
        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);

        SharedPreferences.Editor editor = pref.edit();

        editor.putString(key, balue);

        editor.commit();
    }

    public void put (String key, int balue)
    {
        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);

        SharedPreferences.Editor editor = pref.edit();

        editor.putInt(key, balue);

        editor.commit();
    }

    public String getBalue (String key, String defBalue)
    {
        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);

        return pref.getString(key,defBalue);
    }

    public int getBalue(String key, int defBalue)
    {
        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);

        return pref.getInt(key,defBalue);
    }
}
