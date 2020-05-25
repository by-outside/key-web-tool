package com.zy.keywebtool.applicationrun;

import com.zy.keywebtool.util.Util;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value = 2)
@Component
public class OpenClient implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //打开浏览器
        Util.openClient(3000L, "---------------++++++++");
    }
}
