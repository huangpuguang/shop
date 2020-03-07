package com.hazer.file.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: FastDFSFile
 * @description: ${description}
 * @author: Hazer
 * @create: 2020-03-07 11:35
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FastDFSFile {
    //文件名字
    private String name;
    //文件内容
    private byte[] content;
    //文件扩展名
    private String ext;
    //文件MD5摘要值
    private String md5;
    //文件创建作者
    private String author;
}
