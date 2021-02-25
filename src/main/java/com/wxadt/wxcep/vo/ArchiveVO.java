package com.wxadt.wxcep.vo;

/**
 * com.wxadt.wxcep.vo
 *
 * @author caofengnian
 * @Date 2020-07-16
 */
public class ArchiveVO {

    private String fileName;

    private String fileUrl;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public String toString() {
        return "ArchiveVO{" +
                "fileName='" + fileName + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                '}';
    }

}