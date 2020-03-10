package com.hazer.file.utils;

import com.hazer.file.entity.FastDFSFile;
import org.bouncycastle.eac.EACIOException;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * @ClassName: FastDFSClient
 * @description: ${description}
 * @author: Hazer
 * @create: 2020-03-07 11:36
 **/
public class FastDFSClient {
    private static final Logger logger = LoggerFactory.getLogger(FastDFSClient.class);

    static {
        try {
            //获取tracker的配置文件fastDFS_client.conf的位置
            String path = new ClassPathResource("fastDFS_client.conf").getPath();
            //加载tracker配置信息
            ClientGlobal.init(path);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
     //文件上传
    /****
     * 文件上传
     * @param file : 要上传的文件信息封装->FastDFSFile
     * @return String[]
     *          1:文件上传所存储的组名
     *          2:文件存储路径
     */
    public static String[] upload(FastDFSFile file){
        //获取文件作者
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] =new NameValuePair(file.getAuthor());

        /***
         * 文件上传后的返回值
         * uploadResults[0]:文件上传所存储的组名，例如:group1
         * uploadResults[1]:文件存储路径,例如：M00/00/00/wKjThF0DBzaAP23MAAXz2mMp9oM26.jpeg
         */
        String[] uploadResults = null;
        try {
            //获取StorageClient对象
            StorageClient storageClient = getStorageClient();
            //执行文件上传
            uploadResults = storageClient.upload_file(file.getContent(), file.getExt(), meta_list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return uploadResults;
    }




    /***
     * 文件下载
     * @param groupName:组名
     * @param remoteFileName：文件存储完整名
     * @return
     */
    public static InputStream downFile(String groupName, String remoteFileName){
        try {
            //获取StorageClient
            StorageClient storageClient = getStorageClient();
            //通过StorageClient下载文件
            byte[] fileByte = storageClient.download_file(groupName, remoteFileName);
            //将字节数组转换成字节输入流
            return new ByteArrayInputStream(fileByte);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /***
     * 文件删除实现
     * @param groupName:组名
     * @param remoteFileName：文件存储完整名
     */
    public static void deleteFile(String groupName,String remoteFileName){
        try {
            //获取StorageClient
            StorageClient storageClient = getStorageClient();
            //通过StorageClient删除文件
            storageClient.delete_file(groupName,remoteFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * 获取文件信息
     * @param groupName:组名
     * @param remoteFileName：文件存储完整名
     */
    public static FileInfo getFile(String groupName,String remoteFileName){
        try {
            //获取StorageClient对象
            StorageClient storageClient = getStorageClient();
            //获取文件信息
            return storageClient.get_file_info(groupName,remoteFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 获取Tracker服务地址
     */
    public static String getTrackerUrl(){
        try {
            //创建TrackerClient对象
            TrackerClient trackerClient = new TrackerClient();
            //通过TrackerClient获取TrackerServer对象
            TrackerServer trackerServer = trackerClient.getConnection();
            //获取Tracker地址
            return "http://"+trackerServer.getInetSocketAddress().getHostString()+":"+ClientGlobal.getG_tracker_http_port();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 获取TrackerServer
     */
    public static TrackerServer getTrackerServer() throws Exception{
        //创建TrackerClient对象
        TrackerClient trackerClient = new TrackerClient();
        //通过TrackerClient获取TrackerServer对象
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerServer;
    }

    /**
     * 获取StorageClient对象
     *
     * @return
     */
    public static StorageClient getStorageClient() throws Exception {
        //获取TrackerServer
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        //获取StorageClient对象
        //String storageServerIp = getStorageServerIp(trackerClient, trackerServer);
        //StorageServer storageServer = getStorageServer(storageServerIp);
        StorageClient storageClient = new StorageClient(trackerServer, null);

        return storageClient;

    }

    /**
     * 得到Storage服务
     *
     * @param storageIp
     * @return 返回Storage服务
     */
    private static StorageServer getStorageServer(String storageIp) {
        StorageServer storageServer = null;
        if (storageIp != null && !("").equals(storageIp)) {
            try {
                // ip port store_path下标
                storageServer = new StorageServer(storageIp, 23000, 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger.debug("——storage server生成");
        return storageServer;
    }
    /**
     * 获得可用的storage IP
     *
     * @param trackerClient
     * @param trackerServer
     * @return 返回storage IP
     */
    private static String getStorageServerIp(TrackerClient trackerClient, TrackerServer trackerServer) {
        String storageIp = null;
        if (trackerClient != null && trackerServer != null) {
            try {
                StorageServer storageServer = trackerClient.getStoreStorage(trackerServer, "group1");
                storageIp = storageServer.getSocket().getInetAddress().getHostAddress();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger.debug("——获取组中可用的storage IP——" + storageIp);
        return storageIp;
    }
}
