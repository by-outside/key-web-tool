package com.zy.keywebtool.controller;

import com.zy.keywebtool.config.StatusConfigUtil;
import com.zy.keywebtool.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CommonController {


    @RequestMapping("getBaseMsg")
    @ResponseBody
    public Object getBaseMsg(){
        Map map=new HashMap();
        map.put("Q", StatusConfigUtil.KEY_Q);
        map.put("W",StatusConfigUtil.KEY_W);
        map.put("E",StatusConfigUtil.KEY_E);
        map.put("R",StatusConfigUtil.KEY_R);
        map.put("TIME",StatusConfigUtil.SLEEP_TIME);
        map.put("localIP", StatusConfigUtil.LOCAL_IP);
        map.put("token",StatusConfigUtil.WEB_TOKEN);
        return map;
    }

    @RequestMapping(value = {"/","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping("updateKey/{key}/{select}")
    @ResponseBody
    public String update(@PathVariable("key") String key, @PathVariable("select") int select){
        if("Q".equals(key)){
            if (select==0){
                StatusConfigUtil.KEY_Q = Boolean.TRUE;
                StatusConfigUtil.RUN_COUNT++;
            }
            else{
                StatusConfigUtil.KEY_Q = Boolean.FALSE;
                StatusConfigUtil.RUN_COUNT--;
            }
        }else if("W".equals(key)){
            if (select==0){
                StatusConfigUtil.KEY_W = Boolean.TRUE;
                StatusConfigUtil.RUN_COUNT++;
            }
            else{
                StatusConfigUtil.KEY_W = Boolean.FALSE;
                StatusConfigUtil.RUN_COUNT--;
            }
        }else if("E".equals(key)){
            if (select==0){
                StatusConfigUtil.KEY_E = Boolean.TRUE;
                StatusConfigUtil.RUN_COUNT++;
            }
            else{
                StatusConfigUtil.KEY_E = Boolean.FALSE;
                StatusConfigUtil.RUN_COUNT--;
            }
        }else if("R".equals(key)) {
            if (select==0){
                StatusConfigUtil.KEY_R = Boolean.TRUE;
                StatusConfigUtil.RUN_COUNT++;
            }
            else{
                StatusConfigUtil.KEY_R = Boolean.FALSE;
                StatusConfigUtil.RUN_COUNT--;
            }
        }else {
            return "你逗我呢";
        }
        return "success";
    }

    @RequestMapping("updateSleep/{time}")
    @ResponseBody
    public String updateSleep(@PathVariable("time") long time){
        StatusConfigUtil.SLEEP_TIME = time;
        return "success";
    }

    @RequestMapping("shutDown")
    @ResponseBody
    public String shutDown(){
        System.exit(2);
        return "success";
    }

    @RequestMapping("retoken")
    @ResponseBody
    public String retoken(){
        Util.createToken();
        return StatusConfigUtil.WEB_TOKEN;
    }

}
