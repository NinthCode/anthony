package com.paouke.practice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.paouke.practice.common.constant.DictConstant;
import com.paouke.practice.common.helper.DataBuildHelper;
import com.paouke.practice.common.util.MD5Util;
import com.paouke.practice.common.util.StringUtil;
import com.paouke.practice.dao.RoleDao;
import com.paouke.practice.dao.UserDao;
import com.paouke.practice.domain.RoleEntity;
import com.paouke.practice.domain.UserEntity;
import com.paouke.practice.domain.UserRequestVo;
import com.paouke.practice.domain.UserResponseVo;
import com.paouke.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.provider.MD5;

import javax.xml.ws.Action;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/7/29.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    public UserResponseVo register(UserRequestVo requestVo) {
        UserEntity userEntity = new UserEntity();
        UserResponseVo userResponseVo = new UserResponseVo();
        String checkRes = checkRegister(requestVo);
        if(!DictConstant.DICT_RET_SUCCESS.equals(checkRes)) {
            userResponseVo.setStatus(false);
            userResponseVo.setCode(checkRes);
            return userResponseVo;
        }
        userEntity.setUserName(requestVo.getAccount());
        userEntity.setInheritOrganizationPower(DictConstant.DICT_BOOL_YES);
        userEntity.setPassword(MD5Util.md5(requestVo.getPassword()));
        userEntity.setRegisterTime(new Date());
        userEntity.setStatus(DictConstant.DICT_STATUS_NOT_ACTIVE);
        userEntity.setRegisterType(DictConstant.DICT_REG_TYPE_ANDROID);
        userEntity.setOperatorTime(new Date());
        userEntity = userDao.saveAndFlush(userEntity);
        userResponseVo.setStatus(true);
        userResponseVo.setUserName(userEntity.getUserName());
        userResponseVo.setCode(DictConstant.DICT_RET_SUCCESS);
        return userResponseVo;
    }

    public boolean updatePassword(UserRequestVo requestVo) {
        return false;
    }

    public Map<String, Object> login(UserRequestVo requestVo) {
        return null;
    }

    public Map<String, Object> getUserInfoById(Long id) {
        Map<String, Object> retMap = new HashMap<>();
        try{
            UserEntity userEntity = userDao.findOne(id);
            if(userEntity.getId() != null) {
                retMap.put("account", userEntity.getUserName());
                retMap.put("birthday", userEntity.getBirthday());
                retMap.put("email", userEntity.getEmail());
                List<RoleEntity> roleEntities = roleDao.findAllByUserId(id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String checkRegister(UserRequestVo userRequestVo) {
        String userName = userRequestVo.getAccount();
        if(StringUtil.isBlank(userName) || userName.length() > 20) {
            return DictConstant.DICT_RET_ERROR_USERNAME;
        }
        List<UserEntity> userEntitys = userDao.findAllByUserName(userName);
        if(userEntitys.size() != 0) {
            return DictConstant.DICT_RET_USER_EXIST;
        }
        if(StringUtil.isBlank(userRequestVo.getPassword()) || userRequestVo.getPassword().trim().length() < 8) {
            return DictConstant.DICT_RET_ERROR_PASSWD;
        }
        return DictConstant.DICT_RET_SUCCESS;
    }
}
