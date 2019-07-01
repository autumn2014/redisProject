package com.example.nosqlredis01.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.nosqlredis01.model.Goods;

import java.util.List;

/**
 * 实体转化能为json字符串
 */
public class Json {
    public void JsonUtil(){
        Goods goods=new Goods();
        goods.setGoodsInfo("info");
        goods.setAdInfo("adinfo");
        JSONObject jsonObject=new JSONObject();
        System.out.println(jsonObject.toJSONString(goods));
    }
    //
    public static String toJson(Object object){
        JSONObject jsonObject=new JSONObject();
        return jsonObject.toJSONString(object);
    }
}
