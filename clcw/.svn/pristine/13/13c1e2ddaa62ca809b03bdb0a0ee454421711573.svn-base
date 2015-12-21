/**
 * Project Name:dtdp
 * File Name:ServletUtils.java
 * Package Name:com.manzz.framework.core.util
 * Date:2014-09-29下午7:07:08
 * Copyright (c) 2014, manzz.com All Rights Reserved.
 *
 */

package com.manzz.framework.core.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manzz.framework.core.exception.SystemException;

/**
 * ClassName: ServletUtils <br/>
 * Function: Servlet工具类. <br/>
 *
 * @author WJK
 * @version 2014-09-29 
 */
public class ServletUtils {
    /**
     * 功能:文件下载. <br/>
     */
    public static void download(HttpServletRequest request, HttpServletResponse response,String fileName) {
        //默认下载路径
    	//request.setCharacterEncoding("UTF-8");
        String ctxPath = request.getSession().getServletContext().getRealPath("/") + "download"+ File.separator;
        String downLoadPath = ctxPath + fileName;   
        download(response,fileName,downLoadPath);
    }

    /**
     * 功能:文件下载. <br/>
     */
    public static void download(HttpServletResponse response,String fileName,String downLoadPath) {
        response.setContentType("text/html;charset=utf-8");
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            Long fileLength = new File(downLoadPath).length();
            response.setContentType("application/x-msdownload;");
            response.setContentLength(fileLength.intValue());//支持迅雷下载
            //response.setHeader("Content-Length", String.valueOf(fileLength));
            response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
            bis = new BufferedInputStream(new FileInputStream(downLoadPath));   
            bos = new BufferedOutputStream(response.getOutputStream());   
            IoUtils.copyTo(bis, bos);
        } catch (Exception e) {   
            throw new SystemException(e.getMessage());
        } finally {
        	IoUtils.closeQuietly(bis);
        	IoUtils.closeQuietly(bos);
        }
    }

    /**
     * 功能:显示图片. <br/>
     * @param image
     * @param response
     */
    public static void showImage(byte[] data, HttpServletResponse response) {
        response.setContentType("application/octet-stream;charset=UTF-8");
        try {
            IoUtils.copyTo(data,response.getOutputStream());
        } catch (IOException e) {
            throw new SystemException(e.getMessage());
        }
    }

    /**
     * 功能:获得应用路径
     * @param response
     */
    public static String getBasePath(HttpServletRequest request){
        return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
    }
}

