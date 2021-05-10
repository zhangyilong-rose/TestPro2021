package com.example.homework1004.HttpUtils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class HttpUtils {

    //一般get方法
    public static String doGet(String url) {
        String result = null;
        CloseableHttpResponse response = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            // 执行请求
            response = httpclient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //带参数的get方法 ---拼接字符串方式
    public static String doGet(String url,Map<String,String> data){
        String result;

        url = url+"?";
        for(String key:data.keySet()){
            url = url+key+"="+data.get(key)+"&";
        }
        url = url.substring(0,url.length()-1);

        result = doGet(url);
        System.out.println(url);
        return result;
    }

    //一般post方法
    public static String doPost(String url, String jsonStr) {
        // 创建httpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建post请求方式实例
        HttpPost httpPost = new HttpPost(url);

        // 设置请求头 发送的是json数据格式
        httpPost.setHeader("Content-type", "application/json;charset=utf-8");
        httpPost.setHeader("Connection", "Close");

        // 设置参数---设置消息实体 也就是携带的数据
        StringEntity entity = new StringEntity(jsonStr, StandardCharsets.UTF_8);
        // 设置编码格式
        entity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        entity.setContentType("application/json");
        // 把请求消息实体塞进去
        httpPost.setEntity(entity);

        // 执行http的post请求
        CloseableHttpResponse httpResponse;
        String result = null;
        try {
            httpResponse = httpClient.execute(httpPost);
            result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static String doPost(String url, Map<String,String > data) throws IOException {
        String result;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        List<NameValuePair> nameValuePairList = new ArrayList<>(data.size());
        for (Iterator iter = data.keySet().iterator(); iter.hasNext(); ) {
            String name = (String)iter.next();
            String value = String.valueOf(data.get(name));
            nameValuePairList.add(new BasicNameValuePair(name, value));
        }

        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        httpPost.setHeader("Connection", "Close");

        UrlEncodedFormEntity httpEntity = new UrlEncodedFormEntity(nameValuePairList,StandardCharsets.UTF_8);
        httpPost.setEntity(httpEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity responseEntity = response.getEntity();
        result = EntityUtils.toString(responseEntity);
        return  result;
    }

    public Map<String, String> toMap(JSONObject obj) {
        Map<String, String> params = JSONObject.parseObject(obj.toString(), new TypeReference<Map<String, String>>() {
        });
        return params;
    }

}
