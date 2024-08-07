package com.example.nckh1.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {

    private static final  String NAME_SHARE="My_Share";
    private Context mContext;

    public MySharedPreferences(Context mContext) {
        this.mContext = mContext;
    }
    //Hàm put dữ liệu
    public void putStringValue(String key,String value){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME_SHARE,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,value);
        editor.commit();
        editor.apply();
    }
    //Nhận dữ liệu
    public String getString(String key){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME_SHARE,Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,"");
    }
    // double
    public void putDouble(String key, float value){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME_SHARE,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key,value);
        editor.apply();
    }
    //Nhận dữ liệu
    public float getDouble(String key){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(NAME_SHARE,Context.MODE_PRIVATE);
        return sharedPreferences.getFloat(key,0);
    }

}
