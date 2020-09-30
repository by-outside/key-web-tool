package com.zy.keywebtool.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.zy.keywebtool.config.StatusConfigUtil;
import com.zy.keywebtool.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CommonController {


    @RequestMapping("wifiList")
    @ResponseBody
    public Object wifiList() {
        return "adsasddadadadadada";
    }

    @RequestMapping("getBaseMsg")
    @ResponseBody
    public Object getBaseMsg() {
        Map map = new HashMap();
        map.put("Q", StatusConfigUtil.KEY_Q);
        map.put("W", StatusConfigUtil.KEY_W);
        map.put("E", StatusConfigUtil.KEY_E);
        map.put("R", StatusConfigUtil.KEY_R);
        map.put("Q_INTERVAL", StatusConfigUtil.Q_INTERVAL);
        map.put("W_INTERVAL", StatusConfigUtil.W_INTERVAL);
        map.put("E_INTERVAL", StatusConfigUtil.E_INTERVAL);
        map.put("R_INTERVAL", StatusConfigUtil.R_INTERVAL);
        map.put("localIP", StatusConfigUtil.LOCAL_IP);
        map.put("token", StatusConfigUtil.WEB_TOKEN);
        map.put("allStop", StatusConfigUtil.ALL_STOP);

        return map;
    }

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("updateKey/{key}")
    @ResponseBody
    public String update(@PathVariable("key") String key) {
        if ("Q".equals(key)) {
            StatusConfigUtil.KEY_Q =  !StatusConfigUtil.KEY_Q;
        } else if ("W".equals(key)) {
            StatusConfigUtil.KEY_W =  !StatusConfigUtil.KEY_W;
        } else if ("E".equals(key)) {
            StatusConfigUtil.KEY_E =  !StatusConfigUtil.KEY_E;
        } else if ("R".equals(key)) {
            StatusConfigUtil.KEY_R =  !StatusConfigUtil.KEY_R;
        } else {
            return "你逗我呢";
        }
        return "success";
    }

    @RequestMapping("updateSleep/{key}/{time}")
    @ResponseBody
    public String updateSleep(@PathVariable("key") String key, @PathVariable("time") long time) {
        if ("Q".equals(key)) {
            StatusConfigUtil.Q_INTERVAL = time > 50 ? time : 50;
        } else if ("W".equals(key)) {
            StatusConfigUtil.W_INTERVAL = time > 50 ? time : 50;
        } else if ("E".equals(key)) {
            StatusConfigUtil.E_INTERVAL = time > 50 ? time : 50;
        } else if ("R".equals(key)) {
            StatusConfigUtil.R_INTERVAL = time > 50 ? time : 50;
        } else {
            return "别闹...";
        }
        return "success";
    }

    //全部暂停
    @RequestMapping("allStop")
    @ResponseBody
    public String allStop(){
        StatusConfigUtil.ALL_STOP = !StatusConfigUtil.ALL_STOP;
        return "success";
    }

    @RequestMapping("shutDown")
    @ResponseBody
    public String shutDown() {
        System.exit(2);
        return "success";
    }

    @RequestMapping("retoken")
    @ResponseBody
    public String retoken() {
        Util.createToken();
        return StatusConfigUtil.WEB_TOKEN;
    }

}
