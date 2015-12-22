/**
 * Project Name:DTDP File Name:HttpUtils.java Package Name:com.cht.utils
 * Date:2015年1月26日下午7:00:33 Copyright (c) 2015, cht.com All Rights Reserved.
 */

package com.cht.framework.core.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 功能: HttpClient工具类
 * @author WJK
 * @version 2015-06-10
 */
public class HttpClientUtils {
    /** 设置连接超时时间:60秒 */  
    public final static int CONNECT_TIMEOUT = 60000;
    /** 设置读取超时时间:100秒 */  
    public final static int SOCKET_TIMEOUT = 100000;

//    private static CloseableHttpClient httpClient = HttpClients.createDefault();// 4.3以后的版本将不在使用DefaultHttpClient
    
    // 设置httpClient的头信息，也可以设置其他信息
    private static CloseableHttpClient getHttpClient() {
        Collection<BasicHeader> collection = new ArrayList<BasicHeader>();
        collection.add(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"));
        
        collection.add(new BasicHeader("Accept", "text/html, application/xhtml+xml, */*"));
//      collection.add(new BasicHeader("Accept", " image/gif, image/x-xbitmap, image/jpeg, " + "image/pjpeg, application/x-silverlight, application/vnd.ms-excel, "
//         + "application/vnd.ms-powerpoint, application/msword, application/x-shockwave-flash, */*"));
//      collection.add(new BasicHeader("Accept", "application/json"));
        
//      collection.add(new BasicHeader("Accept-Encoding", "gzip, deflate"));
//      collection.add(new BasicHeader("ApiSystemId", "mytest"));
//      collection.add(new BasicHeader("ApiLoginName", "wjk"));
//      collection.add(new BasicHeader("ApiPassword", "test"));

        // 设置超时时间
        RequestConfig defaultRequestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT)
            .setConnectionRequestTimeout(SOCKET_TIMEOUT).build();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultHeaders(collection).setDefaultRequestConfig(defaultRequestConfig).build();
        return httpClient;
    }
    
    /** 功能: 关闭httpClient */
    public static void closeHttpClient(){
        try {
            getHttpClient().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 功能: 通过GET方式调用http请求
     * @param url 调用地址
     * @return 返回相应的内容
     * @throws IOException
     */
    public static String doHttpGet(String url) throws IOException{
        return doHttpGet(url, getHttpClient(), true);
    }
    
    /**
     * 功能: 通过GET方式调用http请求
     * @param url 调用地址
     * @param httpClient httpClient对象
     * @return 返回相应的内容
     * @throws IOException
     */
    public static String doHttpGet(String url, CloseableHttpClient httpClient) throws IOException{
        return doHttpGet(url, getHttpClient(), true);
    }
    
    /**
     * 功能: 通过GET方式调用http请求
     * @param url 调用地址
     * @param isCloseClient 调用后是否关闭httpClient
     * @param httpClient httpClient对象
     * @return 返回相应的内容
     * @throws IOException
     */
    public static String doHttpGet(String url, CloseableHttpClient httpClient, boolean isCloseClient) throws IOException {
        String result = null;
        CloseableHttpResponse response = getHttpClient().execute(new HttpGet(url));
        HttpEntity entity = response.getEntity();
        try {
            int status = response.getStatusLine().getStatusCode();
            if (status == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity(), Consts.UTF_8);
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        } finally {
            EntityUtils.consume(entity);
            if(isCloseClient){
                response.close();
            }
        }
        return result;
    }
    /**
     * 功能: 通过POST方式调用http请求
     * @param url 调用地址
     * @return 返回相应的内容
     * @throws IOException
     */
    public static String doHttpPost(String url) throws IOException{
        return doHttpPost(url, null ,true);
    }
    /**
     * 功能: 通过POST方式调用http请求
     * @param url 调用地址
     * @param param 请求参数
     * @return 返回相应的内容
     * @throws IOException
     */
    public static String doHttpPost(String url, Map<String, String> param) throws IOException{
        return doHttpPost(url, param, true);
    }
    /**
     * 功能: 通过POST方式调用http请求
     * @param url 调用地址
     * @param param 请求参数
     * @param isCloseClient 调用后是否关闭httpClient
     * @return 返回相应的内容
     * @throws IOException
     */
    public static String doHttpPost(String url, Map<String, String> param, boolean isCloseClient) throws IOException {
        String result = null;
        CloseableHttpClient httpClient = getHttpClient();
        HttpPost httpPost = new HttpPost(url);
        //拼接参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for(String key :param.keySet()){
            nvps.add(new BasicNameValuePair(key, param.get(key)));
        }
        
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
        CloseableHttpResponse response = getHttpClient().execute(httpPost);
        HttpEntity entity = response.getEntity();
        try {
            result = EntityUtils.toString(response.getEntity(), Consts.UTF_8);
            // 针对响应值的处理类
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
                    HttpEntity entity = response.getEntity();
                    StatusLine statusLine = response.getStatusLine();
                    int status = statusLine.getStatusCode();
                    if (status >= HttpStatus.SC_MULTIPLE_CHOICES) {
                        throw new HttpResponseException(status, statusLine.getReasonPhrase());  
                    } else if(entity == null){
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    } else {
                        return EntityUtils.toString(entity);
                    }
                }
            };
            result = httpClient.execute(httpPost, responseHandler);
        } finally {
            EntityUtils.consume(entity);//关闭Http实体内容流通过消耗掉Http实体内容来保持相关的http连接
            if(isCloseClient){
                response.close();//关闭Http响应会立即关闭、丢弃http连接
            }
        }
        return result;
    }
}
