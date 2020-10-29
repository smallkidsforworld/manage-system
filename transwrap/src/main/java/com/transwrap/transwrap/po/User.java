package com.transwrap.transwrap.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private String introduction;

    @Column
    private String phone;

    @Column
    private Timestamp createTime;

    @Column
    private Timestamp modifyTime;

}
