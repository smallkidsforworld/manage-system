package com.transwrap.transwrap.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description: 日常事物映射类
 * @author: yml
 * @time: 2020/10/30
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "daily_manage")
public class DailyManage {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "info")
    private String info;

    @Column(name = "title")
    private String title;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "modify_time")
    private Date modifyTime;

    @Column(name = "end_time")
    private Date endTime;
}
