package com.zy.keywebtool.config;

public class StatusConfigUtil {


    public static String LOCAL_IP = "";
    public static volatile boolean ALL_STOP = Boolean.FALSE;
    public static volatile boolean KEY_Q = Boolean.FALSE;
    public static volatile boolean KEY_W = Boolean.FALSE;
    public static volatile boolean KEY_E = Boolean.FALSE;
    public static volatile boolean KEY_R = Boolean.FALSE;

    //间隔
    public static volatile long Q_INTERVAL = 100L;
    public static volatile long W_INTERVAL = 100L;
    public static volatile long E_INTERVAL = 100L;
    public static volatile long R_INTERVAL = 100L;

    //当前
    public static volatile long Q_NOW = 0L;
    public static volatile long W_NOW = 0L;
    public static volatile long E_NOW = 0L;
    public static volatile long R_NOW = 0L;



    public static volatile String WEB_TOKEN = "";

    //全部加10
    public static void allAdd(){
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = 0;
        if (KEY_Q){
            i++;
        }
        if (KEY_W){
            i++;
        }
        if (KEY_E){
            i++;
        }
        if (KEY_R){
            i++;
        }
        Q_NOW+=10 * i;
        W_NOW+=10 * i;
        E_NOW+=10 * i;
        R_NOW+=10 * i;
    }

}
