package com.transwrap.transwrap.entity;

import tk.mybatis.mapper.common.BaseMapper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：yml
 * @date ：Created in 2020/10/30 14:33
 * @description：用于缓存信息
 * @modified By：
 */
public class ItemCache<T> {
    private final Map<String,T> map = new ConcurrentHashMap<>();

    public T getCached(String id){
        return map.getOrDefault(id,null);
    }

    public void updateCache(String id, T object){
        if(!map.containsKey(id))
            return;
        map.put(id,object);
    }

    public boolean checkTheCacheWithDB(BaseMapper<T> mapper){
        for(String id:map.keySet())
            if(!mapper.selectByPrimaryKey(id).equals(map.get(id)))
                return false;
        return true;
    }


    public boolean containsObject(String id){
        return map.containsKey(id);
    }
}
