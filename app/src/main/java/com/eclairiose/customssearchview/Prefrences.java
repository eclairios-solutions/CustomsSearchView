package com.eclairiose.customssearchview;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefrences {



    public static void isAppInstalled(Context context, String key, boolean value) {
        SharedPreferences sharedPref = context.getSharedPreferences( "Prefs", Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean( key, value );
        editor.apply();
    }

    public static boolean AppNotInstalled(Context context, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences( "Prefs", Context.MODE_PRIVATE );
        return sharedPref.getBoolean( key, false );
    }

    public static void saveName(Context context, String key, boolean value) {
        SharedPreferences sharedPref = context.getSharedPreferences( "Prefs", Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean( key, value );
        editor.apply();
    }

    public static boolean getName(Context context, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences( "Prefs", Context.MODE_PRIVATE );
        return sharedPref.getBoolean( key, false );
    }

    public static void saveDate(Context context, String key, boolean value) {
        SharedPreferences sharedPref = context.getSharedPreferences( "Prefs", Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean( key, value );
        editor.apply();
    }

    public static boolean getDate(Context context, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences( "Prefs", Context.MODE_PRIVATE );
        return sharedPref.getBoolean( key, false );
    }


    public static void saveAscending(Context context, String key, boolean value) {
        SharedPreferences sharedPref = context.getSharedPreferences( "Prefs", Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean( key, value );
        editor.apply();
    }

    public static boolean getAscendinging(Context context, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences( "Prefs", Context.MODE_PRIVATE );
        return sharedPref.getBoolean( key, false );
    }

    public static void saveDescending(Context context, String key, boolean value) {
        SharedPreferences sharedPref = context.getSharedPreferences( "Prefs", Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean( key, value );
        editor.apply();
    }

    public static boolean getDescending(Context context, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences( "Prefs", Context.MODE_PRIVATE );
        return sharedPref.getBoolean( key, false );
    }

}
