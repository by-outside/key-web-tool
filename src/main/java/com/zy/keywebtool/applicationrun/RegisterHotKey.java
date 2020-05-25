package com.zy.keywebtool.applicationrun;

import com.zy.keywebtool.util.Util;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(value = 1)
@Component
public class RegisterHotKey implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Util.registerHotKey();
    }

}
