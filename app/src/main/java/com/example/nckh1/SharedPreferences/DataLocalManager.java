package com.example.nckh1.SharedPreferences;

import android.content.Context;

public class DataLocalManager {

    private static DataLocalManager instance;
    private MySharedPreferences mySharedPreferences;

    public static final String keyms = "DataMs";
    public static final String keyhvt = "DataHvt";
    public static final String keyns = "DataNs";
    public static final String keygt = "DataGioiTinh";
    public static final String keynoio = "DataNoio";
    public static final String keynnb = "Datannb";
    public static final String keynnm = "Datannm";
    public static final String keycs = "Datacs";
    public static final String keysinh = "Datasinh";
    public static final String keyts = "Datats";

    public static void init(Context context) {
        instance = new DataLocalManager();
        instance.mySharedPreferences = new MySharedPreferences(context);
    }

    public static DataLocalManager getInstance() {
        if (instance == null) {
            instance = new DataLocalManager();
        }
        return instance;
    }
   //SharedPreFerences mã số
    public static void setStringMs(String name) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(keyms, name);
    }

    public static String getStringMs() {
        return DataLocalManager.getInstance().mySharedPreferences.getString(keyms);
    }
    //SharedPreFerences hvt
    public static void setStringhvt(String name) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(keyhvt, name);
    }

    public static String getStringhvt() {
        return DataLocalManager.getInstance().mySharedPreferences.getString(keyhvt);
    }
    //SharedPreFerences ns
    public static void setStringns(String name) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(keyns, name);
    }

    public static String getStringns() {
        return DataLocalManager.getInstance().mySharedPreferences.getString(keyns);
    }
    //SharedPreFerences gt
    public static void setStringgt(String name) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(keygt, name);
    }

    public static String getStringgt() {
        return DataLocalManager.getInstance().mySharedPreferences.getString(keygt);
    }
    //SharedPreFerences noi o
    public static void setStringnoio(String name) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(keynoio, name);
    }

    public static String getStringnoio() {
        return DataLocalManager.getInstance().mySharedPreferences.getString(keynoio);
    }
    //SharedPreFerences nnb
    public static void setStringnnb(String name) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(keynnb, name);
    }

    public static String getStringnnb() {
        return DataLocalManager.getInstance().mySharedPreferences.getString(keynnb);
    }

    //SharedPreFerences nnm
    public static void setStringnnm(String name) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(keynnm, name);
    }

    public static String getStringnnm() {
        return DataLocalManager.getInstance().mySharedPreferences.getString(keynnm);
    }

    //SharedPreFerences cs
    public static void setStringcs(String name) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(keycs, name);
    }

    public static String getStringcs() {
        return DataLocalManager.getInstance().mySharedPreferences.getString(keycs);
    }

    //SharedPreFerences gt
    public static void setStrings(String name) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(keysinh, name);
    }

    public static String getStrings() {
        return DataLocalManager.getInstance().mySharedPreferences.getString(keysinh);
    }

    //SharedPreFerences ts
    public static void setStringts(String name) {
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(keyts, name);
    }

    public static String getStringts() {
        return DataLocalManager.getInstance().mySharedPreferences.getString(keyts);
    }


}
