package com.transwrap.transwrap.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "user")
public class User {

//    @Id
//    @Column
    private Long id;

//    @Column
    private String name;

//    @Column
    private String introduction;

//    @Column
    private String phone;

//    @Column
    private String password;

//    @Column
    private Long userAuthority;


//    @Column
    private Date createTime;

//    @Column
    private Date modifyTime;

}
