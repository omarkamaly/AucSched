package com.example.aucschedd;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PrefConfig {

    public static void writeListInPref(Context context, ArrayList<Course> list){
        Gson gson = new Gson();
        String jsonString = gson.toJson(list);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("courses", jsonString);
        editor.apply();
    }

    public static ArrayList<Course> readListFromPref(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString("courses", " ");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Course>>() {}.getType();
        ArrayList<Course> list = gson.fromJson(jsonString, type);
        return list;
    }

    public static void writeAssignmentsInPref(Context context, ArrayList<Assignment> list){
        Gson gson = new Gson();
        String jsonString = gson.toJson(list);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("Assignments", jsonString);
        editor.apply();
    }

    public static ArrayList<Assignment> readAssignmentFromPref(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString("Assignments", " ");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Assignment>>() {}.getType();
        ArrayList<Assignment> list = gson.fromJson(jsonString, type);
        return list;
    }

    public static void writeInitInPref(Context context, boolean init){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("Created", init);
        editor.apply();
    }

    public static boolean readInitFromPref(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        boolean status = pref.getBoolean("Created", true);
        return status;
    }

}
