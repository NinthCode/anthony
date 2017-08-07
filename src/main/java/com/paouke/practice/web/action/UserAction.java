package com.paouke.practice.web.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.paouke.practice.common.helper.DataBuildHelper;
import com.paouke.practice.domain.UserEntity;
import com.paouke.practice.domain.UserRequestVo;
import com.paouke.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by admin on 2017/7/29.
 */
@RestController
@RequestMapping(path = "/api/user")
public class UserAction {

    @Autowired
    UserService userService;

    @GetMapping("/index")
    public ResponseEntity helloWord() {
        return ResponseEntity.ok("hello word");
    }

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity register(@RequestBody UserRequestVo userRequestVo) {
        Map<String, Object> retMap = null;
        try{
            UserEntity userEntity = userService.register(userRequestVo);
            if(userEntity != null) {
                retMap = DataBuildHelper.buildRetBaseData(true, "ok", "注册成功");
                retMap.put("id", userEntity.getId());
            } else {
                retMap = DataBuildHelper.buildRetBaseData(false, "300002", "注册失败，用户名已存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            retMap = DataBuildHelper.buildRetBaseData(false, "300001", e.getMessage());
        }
        return ResponseEntity.ok(JSON.toJSONString(retMap));
    }

    @GetMapping(path = "/getUserById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getUserById(@RequestParam("id") Long id) {
        userService.getUserInfoById(id);
        return null;
    }


}
