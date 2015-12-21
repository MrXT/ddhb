/**
 * Project Name:DTDP File Name:HttpUtils.java Package Name:com.manzz.utils
 * Date:2015年1月26日下午7:00:33 Copyright (c) 2015, manzz.com All Rights Reserved.
 */

package com.manzz.yz.util;




import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

/**
 * ClassName: HttpUtils <br/>
 * @author XT
 * @version 2015年12月4日
 */
public class HttpUtils
{
   /* public static String httpGet(String url)
    {
        HttpGet get = new HttpGet(url);
        try
        {
            HttpResponse response = client.execute(get);
            return EntityUtils.toString(response.getEntity());
        }
        catch (Exception e)
        {
            get.abort();
            e.printStackTrace();
        }
        finally
        {
            get.releaseConnection();
        }
        return null;
    }*/

    public static String httpPost(String url,String json)
    {
        HttpPost post = new HttpPost(url);
        try
        {
            HttpClient client = HttpClientUtils.getHttpClient();
            //post.setHeader("Cookie", "JSESSIONID=96D6B89B9C46E8EB9E40524266286E31");
            StringEntity entity = new StringEntity(json,"UTF-8");
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");//发送json数据需要设置contentType
            post.setEntity(entity);
            HttpResponse response = client.execute(post);
            return EntityUtils.toString(response.getEntity());
        }
        catch (Exception e)
        {
            post.abort();
            e.printStackTrace();
        }
        finally
        {
            post.releaseConnection();
        }
        return null;
    }
    
}
