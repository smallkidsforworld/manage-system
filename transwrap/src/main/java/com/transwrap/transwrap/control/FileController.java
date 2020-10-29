package com.transwrap.transwrap.control;

import com.transwrap.transwrap.service.FileService;
import com.transwrap.transwrap.utils.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author ：yml
 * @date ：Created in 2020/10/26 11:05
 * @description：文件相关
 * @modified By：
 */
@RestController
@RequestMapping(value = "/file")
@Api(tags = "FileOperate")
public class FileController {

    @Resource
    FileService fileService;

    @ApiOperation("单个文件上传")
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ApiResult upLoadFile(@RequestParam String fileType, @RequestParam MultipartFile file) throws IOException {
        return fileService.upLoadFile(fileType, file);
    }

    @ApiOperation("多个文件上传")
    @RequestMapping(value = "/uploadMoreFile", method = RequestMethod.POST)
    public ApiResult upLoadMoreFile(@RequestPart String[] fileType, @RequestPart MultipartFile[] file) throws IOException {
        return fileService.upLoadMoreFile(fileType, file);
    }

    @ApiOperation("文件列表")
    @RequestMapping(value = "/getFileList", method = RequestMethod.GET)
    public ApiResult getFileList(@RequestParam String path) throws IOException {
        return fileService.getAllFile(path);
    }

    @ApiOperation("单个文件下载")
    @RequestMapping(value = "/fileDownLoad", method = RequestMethod.POST)
    public void downLoadFile(@RequestParam String filename, HttpServletResponse response) throws ExecutionException, InterruptedException {
        fileService.downLoadFIle(filename, response);
    }

    @ApiOperation("批量文件下载")
    @RequestMapping(value = "/fileMoreDownLoad", method = RequestMethod.POST)
    public ApiResult downLoadMoreFile(@RequestPart String[] fileList) {
        return ApiResult.success();
    }

}
