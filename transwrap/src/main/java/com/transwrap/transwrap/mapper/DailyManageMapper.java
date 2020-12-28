package com.transwrap.transwrap.mapper;

import com.transwrap.transwrap.po.DailyManage;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: yml
 * @time: 2020/10/30
 */

@Mapper
public interface DailyManageMapper extends BaseMapper<DailyManage> {

    @Select("select * from daily_manage where id = #{id}")
    DailyManage queryDailyManageByItemID(@Param("id") String id);

    @Select("select * from daily_manage where user_id = #{user_id}")
    List<DailyManage> queryDailyManageByUserID(@Param("user_id") String user_id);

    @Select("select * from daily_manage where end_time > #{end_time}")
    List<DailyManage> queryDailyManageByModifyTime(@Param("end_time") Date end_time);

    @Delete("delete from daily_manage where id = #{id}")
    void deleteDailyManageByItemID(@Param("id") String id);

    @Update("update daily_manage set end_time = #{end_time} where id = #{id}")
    void updateDailyManageEndTime(@Param("end_time") Date end_time, @Param("id") String id);

    @Select("select * from daily_manage where user_id = #{user_id} and end_time > #{end_time}")
    List<DailyManage> getAllUsefulManageItem(@Param("user_id") String user_id, @Param("end_time") Date end_time);
}
