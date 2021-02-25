package com.wxadt.wxcep.controller;

import com.wxadt.wxcep.utlis.HttpsUtils;
import com.wxadt.wxcep.utlis.ZipUtils;
import com.wxadt.wxcep.vo.ArchiveVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipOutputStream;

/**
 * 获得压缩文件
 *
 * @author caofengnian
 * @Date 2020-07-16
 */
@Controller
@RequestMapping("archive")
public class ArchiveGenerateController {

    /**
     * 根据图片路径压缩文件
     *
     * @param fileList    文件集合
     * @param archiveName 压缩文件名称
     */
    @PostMapping("getArchiveByList")
    public void getArchiveByList(HttpServletResponse response, @RequestBody List<ArchiveVO> fileList, String archiveName) {
        try {
            //设置导出文件名称
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(archiveName.getBytes("GB2312"), "ISO-8859-1"));
            response.setContentType("application/zip;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            //获得http连接
            HttpsUtils httpsUtils = new HttpsUtils();
            //生成zip文件流
            ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());
            fileList.forEach(x -> {
                try {
                    InputStream inputStream = httpsUtils.httpRequest(x.getFileUrl());
                    ZipUtils.generateZip(zipOutputStream, x.getFileName(), inputStream);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            zipOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}