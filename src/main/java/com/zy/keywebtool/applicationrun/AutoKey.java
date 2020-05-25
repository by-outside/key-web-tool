package com.zy.keywebtool.applicationrun;

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
    public void run(ApplicationArguments args) throws Exception {
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        while (Boolean.TRUE){
            if(StatusConfigUtil.RUN_COUNT == 0){
                continue;
            }
            long l = (StatusConfigUtil.SLEEP_TIME / StatusConfigUtil.RUN_COUNT);
            long tl = l>50?l:50;
            try {
                if (StatusConfigUtil.KEY_Q){
                    Thread.sleep(tl);
                    r.keyPress(KeyEvent.VK_Q);
                    Thread.sleep(10L);
                    r.keyRelease(KeyEvent.VK_Q);
                }
                if (StatusConfigUtil.KEY_W){
                    Thread.sleep(tl);
                    r.keyPress(KeyEvent.VK_W);
                    Thread.sleep(10L);
                    r.keyRelease(KeyEvent.VK_W);
                }
                if (StatusConfigUtil.KEY_E){
                    Thread.sleep(tl);
                    r.keyPress(KeyEvent.VK_E);
                    Thread.sleep(10L);
                    r.keyRelease(KeyEvent.VK_E);
                }
                if (StatusConfigUtil.KEY_R){
                    Thread.sleep(tl);
                    r.keyPress(KeyEvent.VK_R);
                    Thread.sleep(10L);
                    r.keyRelease(KeyEvent.VK_R);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
