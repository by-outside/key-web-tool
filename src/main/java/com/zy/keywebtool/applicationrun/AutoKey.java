package com.zy.keywebtool.applicationrun;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.zy.keywebtool.config.StatusConfigUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.KeyEvent;

@Order(value = 3)
@Component
public class AutoKey implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) {
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            System.out.println("键盘未就绪.........");
            e.printStackTrace();
        }
        while (Boolean.TRUE) {
            if(StatusConfigUtil.ALL_STOP){
                continue;
            }
            StatusConfigUtil.allAdd();
            try {
                if (StatusConfigUtil.KEY_Q && StatusConfigUtil.Q_NOW >= StatusConfigUtil.Q_INTERVAL) {
                    r.keyPress(KeyEvent.VK_Q);
                    Thread.sleep(10L);
                    r.keyRelease(KeyEvent.VK_Q);
                    StatusConfigUtil.Q_NOW = 0L;
                }
                if (StatusConfigUtil.KEY_W && StatusConfigUtil.W_NOW >= StatusConfigUtil.W_INTERVAL) {
                    r.keyPress(KeyEvent.VK_W);
                    Thread.sleep(10L);
                    r.keyRelease(KeyEvent.VK_W);
                    StatusConfigUtil.W_NOW = 0L;
                }
                if (StatusConfigUtil.KEY_E && StatusConfigUtil.E_NOW >= StatusConfigUtil.E_INTERVAL) {
                    r.keyPress(KeyEvent.VK_E);
                    Thread.sleep(10L);
                    r.keyRelease(KeyEvent.VK_E);
                    StatusConfigUtil.E_NOW = 0L;
                }
                if (StatusConfigUtil.KEY_R && StatusConfigUtil.R_NOW >= StatusConfigUtil.R_INTERVAL) {
                    r.keyPress(KeyEvent.VK_R);
                    Thread.sleep(10L);
                    r.keyRelease(KeyEvent.VK_R);
                    StatusConfigUtil.R_NOW = 0L;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
