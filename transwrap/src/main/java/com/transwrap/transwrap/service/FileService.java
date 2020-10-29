package com.transwrap.transwrap.service;

import com.transwrap.transwrap.entity.FileInfo;
import com.transwrap.transwrap.utils.ApiResult;
import com.transwrap.transwrap.utils.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author ：yml
 * @date ：Created in 2020/10/26 11:04
 * @description：文件上传
 * @modified By：
 */
@Service
public class FileService {

    @Value("${store.path}")
    String file_store_path;

    public ApiResult getAllFile(String path) throws IOException {
        List<FileInfo> fileInfoList = FileUtil.getAllFileAbsolutePath(path);
        return fileInfoList == null ? ApiResult.fail("no file") : ApiResult.success(fileInfoList);
    }


}
