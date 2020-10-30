package com.transwrap.transwrap.control;

import com.transwrap.transwrap.po.DailyManage;
import com.transwrap.transwrap.repository.DailyManageRepo;
import com.transwrap.transwrap.utils.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description:
 * @author: yml
 * @time: 2020/10/30
 */

@Api(tags = "DailyManageOperate")
@RequestMapping(value = "/daily_manage")
@RestController
public class DailyManageController {

    @Resource
    DailyManageRepo dailyManageRepo;

    @ApiOperation("增加时间项目")
    @RequestMapping(value = "/add_manage_item", method = RequestMethod.POST)
    public ApiResult addManageItem(@RequestBody DailyManage dailyManage) {
        return dailyManageRepo.addManageItem(dailyManage);
    }

    @ApiOperation("删除时间项目")
    @RequestMapping(value = "/delete_manage_item_by_itemId", method = RequestMethod.POST)
    public ApiResult deleteManageItem(@RequestParam String id) {
        return dailyManageRepo.deleteManageItem(id);
    }

    @ApiOperation("获取时间项目(time)")
    @RequestMapping(value = "/get_manage_item_by_time", method = RequestMethod.POST)
    public ApiResult getManageItemByTime() {
        return dailyManageRepo.getManageItemByTime();
    }

    @ApiOperation("获取时间项目(userID)")
    @RequestMapping(value = "/get_manage_item_by_userId", method = RequestMethod.POST)
    public ApiResult getManageItemByID(@RequestParam String user_id) {
        return dailyManageRepo.getManageItemByID(user_id);
    }

    @ApiOperation("更新时间项目(userID)")
    @RequestMapping(value = "/update_manage_item_maintain_time", method = RequestMethod.POST)
    public ApiResult updateManageItemMaintainTime(@RequestParam Date time,@RequestParam String item_id ) {
        return dailyManageRepo.updateManageItemMaintainTime(time,item_id);
    }

    @ApiOperation("获取所有可行项目(userID,currentTime)")
    @RequestMapping(value = "/get_all_available_item", method = RequestMethod.POST)
    public ApiResult getAllAvailableItem(@RequestParam String item_id ) {
        return dailyManageRepo.getAllAvailableItem(item_id);
    }

}
