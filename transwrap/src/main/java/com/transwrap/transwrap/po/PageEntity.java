package com.transwrap.transwrap.po;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
/**
 * @description:
 * @author: yml
 * @time: 2020/10/31
 */

@Data
@AllArgsConstructor
public class PageEntity<T> {
    private List<T> data;
    private int size;
    private int page;

    
}
