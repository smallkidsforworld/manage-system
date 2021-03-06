package com.transwrap.transwrap.mapper;

import com.transwrap.transwrap.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @author ：yml
 * @date ：Created in 2020/10/29 14:42
 * @description：用户信息表的数据库操作
 * @modified By：
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user")
    List<User> getAllUser();

    @Select("select * from user where id = #{id}")
    User queryByUserId(@Param("id") String id);

    @Select("select * from user where phone = #{phone}")
    User queryByPhone(@Param("phone") String phone);

    @Update("update user set user_authority = #{user_authority} where id = #{id}")
    void updateStatus(@Param("id") String id, @Param("user_authority") String user_authority);
}
