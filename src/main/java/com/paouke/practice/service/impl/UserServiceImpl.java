package com.paouke.practice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.paouke.practice.common.constant.DictConstant;
import com.paouke.practice.common.helper.DataBuildHelper;
import com.paouke.practice.dao.RoleDao;
import com.paouke.practice.dao.UserDao;
import com.paouke.practice.domain.RoleEntity;
import com.paouke.practice.domain.UserEntity;
import com.paouke.practice.domain.UserRequestVo;
import com.paouke.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public UserEntity register(UserRequestVo requestVo) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(requestVo.getAccount());
        userEntity.setGender(DictConstant.DICT_GENDER_MAN.equals(requestVo.getSex()) ? 1 :
                DictConstant.DICT_GENDER_WOMAN.equals(requestVo.getSex()) ? 0 : 2);
        userEntity.setBirthday(requestVo.getBirthday());
        userEntity.setEmail(requestVo.getEmail());
        userEntity.setName(requestVo.getName());
        userEntity.setHeadPhoto(requestVo.getPhoto());
        userEntity.setInheritOrganizationPower(requestVo.getInheritOrganizationPower());
        userEntity.setPassword(requestVo.getPassword());//TODO
        userEntity.setOrganizationId(requestVo.getOrganizationId());
        userEntity.setRegisterTime(new Date());
        userEntity.setStatus(DictConstant.DICT_STATUS_NOT_ACTIVE);
        userEntity.setRegisterType(DictConstant.DICT_REG_TYPE_ANDROID);
        userEntity.setOperatorTime(new Date());
        userEntity.setPhoneNumber(requestVo.getPhoneNumber());
        userEntity = userDao.saveAndFlush(userEntity);
        return userEntity;
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
}
