package com.paouke.practice.web.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.paouke.practice.common.constant.DictConstant;
import com.paouke.practice.common.helper.DataBuildHelper;
import com.paouke.practice.domain.UserEntity;
import com.paouke.practice.domain.UserRequestVo;
import com.paouke.practice.domain.UserResponseVo;
import com.paouke.practice.service.UserService;
import org.apache.log4j.Logger;
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
    private final static Logger logger = Logger.getLogger(UserAction.class);

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
            UserResponseVo userResponseVo = userService.register(userRequestVo);
            if(userResponseVo.isStatus()) {
                retMap = DataBuildHelper.buildRetBaseData(true, DictConstant.DICT_RET_SUCCESS, "注册成功");
                retMap.put("userName", userResponseVo.getUserName());
                retMap.put("token", userResponseVo.getToken());
            } else {
                retMap = DataBuildHelper.buildRetBaseData(false, userResponseVo.getCode(), "注册失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[Antony]-register:注册失败，错误信息：", e);
            retMap = DataBuildHelper.buildRetBaseData(false, DictConstant.DICT_RET_SYS_ERROR, e.getMessage());
        }
        return ResponseEntity.ok(JSON.toJSONString(retMap));
    }

    @GetMapping(path = "/getUserById", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getUserById(@RequestParam("id") Long id) {
        userService.getUserInfoById(id);
        return null;
    }


}
