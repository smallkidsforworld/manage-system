package com.transwrap.transwrap.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: yml
 * @time: 2020/10/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeValue {
    private String code;
    private Object value;
}
