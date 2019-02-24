package com.tensor.org.web.utils;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.tensor.org.api.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.multipart.FilePart;

import java.io.*;

/**
 * @author liaochuntao
 */
@Slf4j
public class FileUploadUtils {

    /**
     * 文件合并请求
     * @param parentPath
     * @param fileName
     * @param chunkNum
     * @return
     */
    public static String fileMerge(String parentPath, String fileMD5, String fileName, int chunkNum) {
        String finalFileName = null;
        FileOutputStream targetFile = null;
        try {
            new File(filePathCreate(parentPath, fileMD5)).mkdirs();
            finalFileName = filePathCreate(parentPath, fileMD5, fileName);
            log.info("finalFileName : {}", finalFileName);
            targetFile = new FileOutputStream(finalFileName);
            byte[] buffer = new byte[1024];
            for (int i = 1; i <= chunkNum; i ++ ) {
                String chunkFile = i + ".tmp";
                File tmpFile = new File(filePathCreate(parentPath, fileName, chunkFile));
                InputStream inputStream = new FileInputStream(tmpFile);
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    targetFile.write(buffer, 0, len);
                }
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            log.error("File merge FileNotFoundException : {}", e.getMessage());
            finalFileName = "Err";
        } catch (IOException e) {
            log.error("File merge IOException : {}", e.getMessage());
        } finally {
            if (targetFile != null) {
                try {
                    targetFile.close();
                } catch (IOException e) {
                    log.error("File merge IOException : {}", e.getMessage());
                }
            }
        }
        return finalFileName;
    }

    /**
     * 保存文件
     * @param uploadFile
     * @param parentPath
     * @param name
     * @return
     */
    public static ResultData<HttpStatus> saveFile(FilePart uploadFile, String parentPath, String name) {
        if (uploadFile == null || StringUtils.isNotEmpty(name)) {
            return ResultData.builder().value(HttpStatus.CONFLICT).errMsg("上传失败").builded();
        }
        new File(parentPath).mkdirs();
        String fileName = parentPath + name;
        File file = new File(fileName);
        if (file.exists()) {
            return ResultData.builder().value(HttpStatus.CONFLICT).errMsg("文件已存在").builded();
        }
        uploadFile.transferTo(file);
        return ResultData.builder().value(HttpStatus.OK).builded();
    }

    /**
     * 判断文件是否存在
     * @param parentPath
     * @param fileName
     * @return
     */
    public static boolean judgeFileExist(String parentPath, String fileName) {
        return new File(parentPath + fileName).exists();
    }

    /**
     * 创建文件路径
     * @param parent
     * @param present
     * @param other
     * @return
     */
    public static String filePathCreate(String parent, String present, String... other) {
        StringBuilder sb = new StringBuilder();
        sb.append(parent).append(present).append("/");
        for (String s : other) {
            sb.append(s).append("/");
        }
        return sb.toString();
    }

}
