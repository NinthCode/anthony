package com.paouke.practice.service;

import com.alibaba.fastjson.JSONObject;
import com.paouke.practice.domain.UserEntity;
import com.paouke.practice.domain.UserRequestVo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/7/29.
 */
public interface UserService {

    UserEntity register(UserRequestVo requestVo);

    boolean updatePassword(UserRequestVo requestVo);

    Map<String, Object> login(UserRequestVo requestVo);

    Map<String, Object> getUserInfoById(Long id);

}
