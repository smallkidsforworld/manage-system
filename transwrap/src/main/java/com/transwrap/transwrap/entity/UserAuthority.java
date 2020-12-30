package com.transwrap.transwrap.entity;

import lombok.AllArgsConstructor;

/**
 * @description:
 * @author: yml
 * @time: 2020/12/30
 */

@AllArgsConstructor
public enum UserAuthority {
    VISIT(0), STUDEHT(1), SCHOOLTEACHER(2), COMPANYTEACHER(3), COMPANYUSER(4),SYSTEMMANAGER(5);
    private int authority;
}
