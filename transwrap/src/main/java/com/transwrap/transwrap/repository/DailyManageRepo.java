package com.transwrap.transwrap.repository;

import com.transwrap.transwrap.mapper.DailyManageMapper;
import com.transwrap.transwrap.po.DailyManage;
import com.transwrap.transwrap.utils.ApiResult;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: yml
 * @time: 2020/10/30
 */

@Repository
public class DailyManageRepo {

    @Resource
    DailyManageMapper dailyManageMapper;

    public ApiResult addManageItem(DailyManage dailyManage) {
        dailyManageMapper.insert(dailyManage);
        if (dailyManageMapper.queryDailyManageByItemID(String.valueOf(dailyManage.getId())) != null)
            return ApiResult.success("insert success ");
        else
            return ApiResult.fail(" insert failed ");
    }

    public ApiResult deleteManageItem(String id) {
        dailyManageMapper.deleteDailyManageByItemID(id);
        if (dailyManageMapper.queryDailyManageByItemID(id) == null)
            return ApiResult.success("delete success ");
        else
            return ApiResult.fail(" delete failed ");
    }

    public ApiResult getManageItemByTime() {
        Date current = new Date(System.currentTimeMillis());
        List<DailyManage> dailyList = dailyManageMapper.queryDailyManageByModifyTime(current);
        if (dailyList == null)
            return ApiResult.fail("error occur when get manage item by time");
        return ApiResult.success(dailyList);
    }

    public ApiResult getManageItemByID(String user_id) {
        List<DailyManage> userDailyWorks = dailyManageMapper.queryDailyManageByUserID(user_id);
        if (userDailyWorks == null)
            return ApiResult.fail("error occur when get manage item by user");
        return ApiResult.success(userDailyWorks);
    }


    public ApiResult updateManageItemMaintainTime(Date end_time,String item_id) {
        dailyManageMapper.updateDailyManageEndTime(end_time,item_id);
        DailyManage dailyManage = dailyManageMapper.queryDailyManageByItemID(item_id);
        if(dailyManage==null||dailyManage.getEndTime().equals(end_time))
            return ApiResult.fail(" update Failed ");
        return ApiResult.success();
    }

    public ApiResult getAllAvailableItem(String user_id){
        List<DailyManage> result = dailyManageMapper.getAllUsefulManageItem(user_id,new Date(System.currentTimeMillis()));
        if(result==null)
            return ApiResult.fail("error to get all useful manage item");
        return ApiResult.success(result);
    }


}
