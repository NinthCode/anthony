package com.paouke.practice.common.helper;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.paouke.practice.common.constant.DictConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/7/29.
 */
public class DataBuildHelper {
    public static Map<String, Object> buildRetBaseData(boolean status, String code, String msg) {
        Map<String, Object> retJO = new HashMap<>();
        retJO.put("hasException", status ? DictConstant.DICT_NOT_HAS_EXCEPTION : DictConstant.DICT_HAS_EXCEPTION);
        retJO.put("code", code);
        retJO.put("msg", msg);
        return retJO;
    }

    public static String buildRetBaseDataString(boolean status, String code, String msg) {
        return JSONObject.toJSONString(buildRetBaseData(status, code, msg));
    }
}
