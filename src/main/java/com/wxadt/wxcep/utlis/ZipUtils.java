package com.wxadt.wxcep.utlis;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * com.wxadt.wxcep.utlis
 *
 * @author caofengnian
 * @Date 2020-07-16
 */
public class ZipUtils {
    
    /**
     * 生成压缩文件
     *
     * @param fileName
     * @param inputStream
     */
    public static void generateZip(ZipOutputStream zipOutputStream, String fileName, InputStream inputStream) {
        // 输出流直接用ZipOutputStream包裹，这样直接输出压缩后的流。减少服务器生成压缩文件步骤。
        try {
            ZipEntry zipEntryXtv = new ZipEntry(fileName);
            zipOutputStream.putNextEntry(zipEntryXtv);
            
            // 设置数据缓冲
            byte[] bs = new byte[1024 * 2];
            // 读取到的数据长度
            int len;
            while ((len = inputStream.read(bs)) != -1) {
                zipOutputStream.write(bs, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}