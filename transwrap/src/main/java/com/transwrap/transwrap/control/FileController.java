package com.transwrap.transwrap.control;

import com.transwrap.transwrap.utils.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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


    @ApiOperation("单个文件上传")
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ApiResult upLoadFile(@RequestParam String fileType, @RequestParam MultipartFile file) {
        return ApiResult.success();
    }

    @ApiOperation("多个文件上传")
    @RequestMapping(value = "/uploadMoreFile", method = RequestMethod.POST)
    public ApiResult upLoadMoreFile(@RequestPart String[] fileType, @RequestPart MultipartFile[] file) {
        return ApiResult.success();
    }

    @ApiOperation("文件列表")
    @RequestMapping(value = "/getFileList", method = RequestMethod.GET)
    public ApiResult getFileList() {
        return ApiResult.success();
    }

    @ApiOperation("单个文件下载")
    @RequestMapping(value = "/fileDownLoad", method = RequestMethod.POST)
    public ApiResult downLoadFile(@RequestParam String filename) {
        return ApiResult.success();
    }

    @ApiOperation("批量文件下载")
    @RequestMapping(value = "/fileMoreDownLoad", method = RequestMethod.POST)
    public ApiResult downLoadMoreFile(@RequestPart String[] fileList) {
        return ApiResult.success();
    }
}
