package com.transwrap.transwrap.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：yml
 * @date ：Created in 2020/10/26 11:08
 * @description：返回结果统一
 * @modified By：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResult {
    private Object data_body;
    private String result = TRUE;

    private String rejectReason = "";

    public static final String TRUE = "true";
    public static final String FALSE = "false";

    public static ApiResult success(Object object) {
        return new ApiResult(object,TRUE, "");
    }

    public static ApiResult success() {
        return new ApiResult(TRUE, "",null);
    }


    public static ApiResult fail(String msg) {
        return new ApiResult(FALSE, msg,null);
    }

    public boolean succeed() {
        return TRUE.equals(result);
    }
}
