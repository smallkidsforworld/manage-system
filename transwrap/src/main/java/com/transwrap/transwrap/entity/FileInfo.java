package com.transwrap.transwrap.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：yml
 * @date ：Created in 2020/10/29 17:55
 * @description：用于描述文件信息
 * @modified By：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileInfo {
    private String file_name;
    private String file_size;
}
