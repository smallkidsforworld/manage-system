package com.transwrap.transwrap.service;

import com.transwrap.transwrap.entity.CodeValue;
import com.transwrap.transwrap.entity.FileInfo;
import com.transwrap.transwrap.utils.ApiResult;
import com.transwrap.transwrap.utils.FileUtil;
import com.transwrap.transwrap.utils.ZipUtil;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.*;

/**
 * @author ：yml
 * @date ：Created in 2020/10/26 11:04
 * @description：文件操作
 * @modified By：
 */
@Service
public class FileService {
    @Value("${store.path}")
    private String file_store_path;

    @Value("${store.temporary}")
    private String file_temporary_path;

    public ApiResult getAllFile(String path) throws IOException {
        List<FileInfo> fileInfoList = FileUtil.getAllFileAbsolutePath(path);
        return fileInfoList == null ? ApiResult.fail("no file") : ApiResult.success(fileInfoList);
    }

    public ApiResult upLoadFile(String fileType, MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ApiResult.fail(" file is empty ");
        }
        String filePath = StringUtils.join(Arrays.asList(file_store_path, fileType, file.getOriginalFilename()), FileUtil.split);
        File director = new File(file_store_path + FileUtil.split + fileType);
        if (!director.exists())
            if(!director.mkdirs())
                return ApiResult.fail(" 路径创建失败 ");
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

    public void downLoadFile(String filename, HttpServletResponse response, HttpServletRequest request) throws Exception {
        File file = new File(filename);
        if(file.exists()){
            //设置相应类型让浏览器知道用什么打开  用application/octet-stream也可以，看是什么浏览器
            response.setContentType("application/octet-stream");
            //设置头信息
            response.setHeader("Content-Disposition", "attachment;filename=\"" + filename.substring(filename.lastIndexOf(FileUtil.split)+1) + "\"");
            InputStream inputStream = new FileInputStream(file);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(Files.readAllBytes(file.toPath()));
            outputStream.close();
            inputStream.close();
        }else{
            request.setAttribute("errorResult", "文件不存在,下载失败!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void downLoadMoreFile(String[] file_list,HttpServletResponse response, HttpServletRequest request) throws Exception {
        File file = ZipUtil.zipFileList(file_temporary_path + "temp.zip", file_list);
        downLoadFile(file.getAbsolutePath(),response,request);
    }
}
