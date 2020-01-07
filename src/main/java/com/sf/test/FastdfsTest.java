package com.sf.test;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

public class FastdfsTest {
	
	public static void main(String[] args) throws Exception {
		String uploadFilePath = "E:/abc.jpg";
		// 获取配置文件的路径
		String configPath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
		System.out.println(configPath);
		ClientGlobal.init(configPath);
		TrackerClient trackerClient = new TrackerClient();
		TrackerServer connection = trackerClient.getConnection();
		StorageServer storageServer = null;
		StorageClient storageClient = new StorageClient(connection, storageServer);
		String[] upload_file = storageClient.upload_file(uploadFilePath, ".jpg", null);
		for (String string : upload_file) {
			System.out.println(string);
		}
	}
}
