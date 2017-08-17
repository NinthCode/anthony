package com.paouke.practice.common.constant;

/**
 * Created by admin on 2017/7/29.
 */
public class DictConstant {
    //hasException字典项
    public final static Integer DICT_HAS_EXCEPTION = 1;
    public final static Integer DICT_NOT_HAS_EXCEPTION = 0;

    //gender
    public final static String DICT_GENDER_MAN = "Man";
    public final static String DICT_GENDER_WOMAN = "Woman";

    //user status
    public final static Integer DICT_STATUS_NOT_ACTIVE = 0;
    public final static Integer DICT_STATUS_NORMAL = 1;
    public final static Integer DICT_STATUS_INVALID = 2;
    public final static Integer DICT_STATUS_DELETED = 3;

    //register type
    public final static Integer DICT_REG_TYPE_ANDROID = 0;
    public final static Integer DICT_REG_TYPE_PC = 1;

    //是否
    public final static Boolean DICT_BOOL_YES = true;
    public final static Boolean DICT_BOOL_NO = false;


    //return status
    public final static String DICT_RET_SUCCESS = "100";//正常
    public final static String DICT_RET_USER_EXIST = "101";//用户已存在
    public final static String DICT_RET_ERROR_USERNAME = "102";//用户名错误
    public final static String DICT_RET_ERROR_PASSWD = "103";//密码错误
    public final static String DICT_RET_SYS_ERROR = "104";//系统异常
}
