package com.imlyb.tlias.controller;

import com.imlyb.tlias.pojo.Result;
import com.imlyb.tlias.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("接收参数：{}", file.getOriginalFilename());
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("接收文件url：{}",url);
        return Result.success(url);
    }
}
