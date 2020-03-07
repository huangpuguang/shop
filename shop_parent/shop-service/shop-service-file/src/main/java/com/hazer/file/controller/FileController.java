package com.hazer.file.controller;

import com.hazer.file.entity.FastDFSFile;
import com.hazer.file.utils.FastDFSClient;
import com.hazer.goods.entity.Result;
import com.hazer.goods.entity.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @ClassName: FileController
 * @description: ${description}
 * @author: Hazer
 * @create: 2020-03-07 12:11
 **/
@RestController
@CrossOrigin
@RequestMapping("/file")
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    /**
     * method:
     * description: 文件上传
     * @author
     * @date  12:51
     * @param
     * @return
     */
    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) {
        try {
            //封装一个FastDFSFile
            FastDFSFile fastDFSFile = new FastDFSFile();
            fastDFSFile.setAuthor("Hazer");
            fastDFSFile.setContent(file.getBytes());
            fastDFSFile.setExt(StringUtils.getFilenameExtension(file.getOriginalFilename()));
            fastDFSFile.setName(file.getOriginalFilename());
            //文件上传
            String[] uploads = FastDFSClient.upload(fastDFSFile);
            String path = FastDFSClient.getTrackerUrl() + "/" + uploads[0] + "/" + uploads[1];
            return new Result(true, StatusCode.OK, "成功", path);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return new Result(false, StatusCode.ERROR, "上传异常", e.getMessage());
        }
    }

    /**
     * description: FastDFS文件下载
     * @author hazer
     * @date  12:44
     * @param
     * @return
     */
    @GetMapping("/download")
    public Result download(@RequestParam String groupName,
                           @RequestParam String fileName,
                           @RequestParam String tarDir) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            //文件下载
            inputStream = FastDFSClient.downFile(groupName, fileName);
            if(inputStream == null){
                return new Result(false, StatusCode.NOTFOUNDERROR, "文件不存在");
            }
          outputStream = new FileOutputStream(tarDir);
            //定义缓冲区
            byte buffer[] = new byte[1024];
            while (inputStream.read(buffer) != -1){
                outputStream.write(buffer);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            return new Result(true, StatusCode.OK, "下载成功");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new Result(false, StatusCode.ERROR, "下载异常", e.getMessage());
        }

    }

    /**
     * 文件删除
     * @param groupName
     * @param fileName
     * @return
     */
    @PostMapping("/delete")
    public Result delete(@RequestParam String groupName,
                         @RequestParam String fileName){
        FastDFSClient.deleteFile(groupName,fileName);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
