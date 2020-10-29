package com.transwrap.transwrap.service;

import com.transwrap.transwrap.entity.CodeValue;
import com.transwrap.transwrap.entity.FileInfo;
import com.transwrap.transwrap.utils.ApiResult;
import com.transwrap.transwrap.utils.FileUtil;
import com.transwrap.transwrap.utils.ZipUtil;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author ：yml
 * @date ：Created in 2020/10/26 11:04
 * @description：文件上传
 * @modified By：
 */
@Service
public class FileService {

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Value("${store.path}")
    private String file_store_path;

    @Value("${store.temporary}")
    private String file_temporary_path;

    public ApiResult getAllFile(String path) throws IOException {
        List<FileInfo> fileInfoList = FileUtil.getAllFileAbsolutePath(path);
        return fileInfoList == null ? ApiResult.fail("no file") : ApiResult.success(fileInfoList);
    }

    public ApiResult upLoadFile(String fileType, MultipartFile file) throws IOException {
        if (file.isEmpty())
            return ApiResult.fail(" file is empty ");
        String filePath = StringUtils.join(Arrays.asList(file_store_path, fileType, file.getOriginalFilename()), FileUtil.split);
        File store_file = FileUtil.byteToFile(file.getBytes(), filePath);
        if (store_file == null)
            return ApiResult.fail(" can't read the file");
        return ApiResult.success(true);
    }

    public ApiResult upLoadMoreFile(String[] file_list, MultipartFile[] file_info) throws IOException {

        if (file_list == null || file_info == null || file_list.length != file_info.length || file_list.length == 0)
            return ApiResult.fail("input param is wrong");
        List<CodeValue> load_info = new ArrayList<>();
        for (int i = 0; i < file_list.length; ++i)
            load_info.add(new CodeValue(file_info[i].getOriginalFilename(), upLoadFile(file_list[i], file_info[i])));
        return ApiResult.success(load_info);
    }

    public void downLoadFIle(String filename, HttpServletResponse response) throws ExecutionException, InterruptedException {
        Future<ApiResult> d = executorService.submit(() -> {
            File file = new File(filename);
            if (!file.exists())
                return ApiResult.fail("file not exists");
            byte[] file_info = Files.readAllBytes(file.toPath());
            if (file_info == null || file_info.length <= 0)
                return ApiResult.fail("the file info is empty");
            response.reset();
            response.addHeader("Content-Disposition", "attachment;filename=" + filename);
            response.addHeader("Content-Length", "" + file_info.length);
            response.setContentType("application/octet-stream");
            response.getOutputStream().write(file_info);
            return ApiResult.success();
        });
    }

    public void downLoadMoreFile(String[] file_list) throws Exception {
        File file = ZipUtil.zipFileList(file_temporary_path + "temp.zip", file_list);
    }
}
