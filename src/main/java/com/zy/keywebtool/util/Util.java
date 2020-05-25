package com.zy.keywebtool.util;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import com.zy.keywebtool.config.StatusConfigUtil;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.net.*;
import java.util.Enumeration;

@Component
@EnableAsync
public class Util {
    public static boolean isRun() {
        try {
            URL url = new URL("http://127.0.0.1:8888/");
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection httpUrlConnection = (HttpURLConnection) urlConnection;
            httpUrlConnection.connect();
            System.out.println(httpUrlConnection.getResponseCode());
            if (httpUrlConnection.getResponseCode() == 200) {
                openClient(0L,"231312212123");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void registerHotKey() {
        try {
            JIntellitype.setLibraryLocation("C:\\JIntellitype.dll");
            JIntellitype.getInstance().registerHotKey(2, JIntellitype.MOD_CONTROL, (int) 'P');
            StatusConfigUtil.GLOBAL = Boolean.TRUE;
            //快捷键回调
            listenerHomeKey();
            System.out.println("全局监听启动(*^_^*)");
        } catch (Exception e) {
            System.out.println("全局监听启动失败o(╥﹏╥)o");
            StatusConfigUtil.GLOBAL = Boolean.FALSE;
        }
    }

    private static void listenerHomeKey() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
                    @Override
                    public void onHotKey(int i) {
                        if (i == 2) {
                            openClient(0L,"adsasdadadadadadada");
                        }
                    }
                });
            }
        }).start();

    }

    public static void openClient(final Long l, String type) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (java.awt.Desktop.isDesktopSupported()) {
                    try {
                        Thread.sleep(l);
                        // 创建一个URI实例
                        java.net.URI uri = java.net.URI.create("http://127.0.0.1:8888");
                        // 获取当前系统桌面扩展
                        java.awt.Desktop dp = java.awt.Desktop.getDesktop();
                        // 判断系统桌面是否支持要执行的功能
                        if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
                            // 获取系统默认浏览器打开链接
                            dp.browse(uri);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void getLocalIP(){
        try {
            InetAddress addr = InetAddress.getLocalHost();
            //获取本机IP
            StatusConfigUtil.LOCAL_IP = addr.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static boolean isLocal(ServletRequest servletRequest) {
        String ipAddress = getIpAddress((HttpServletRequest) servletRequest);
        //127.0.0.1
        //0:0:0:0:0:0:0:1
        //局域网本机IP
        if("127.0.0.1".equals(ipAddress)||"0:0:0:0:0:0:0:1".equals(ipAddress)||StatusConfigUtil.LOCAL_IP.equals(ipAddress)){
            return true;
        }else {
            return false;
        }
    }


    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (null == ip)
            return "";

        return ip.split(",")[0];
    }

    public static void createToken() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20; i++) {
             int t=(int)(Math.random() * (90-64))+65;
            sb.append((char)t);
        }
        StatusConfigUtil.WEB_TOKEN = sb.toString();
        System.out.println(StatusConfigUtil.WEB_TOKEN);
    }



    static {
        //生成token
        createToken();
        //获取局域网IP
        getLocalIP();
    }

    public static void main(String[] args) throws UnknownHostException {


        getLocalIP();

    }

}
