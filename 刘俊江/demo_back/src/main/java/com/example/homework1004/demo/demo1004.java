package com.example.homework1004.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.homework1004.HttpUtils.HttpUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;


/*前后端交互接口：
interface_test--
{
      "request_type" : String--"",
      "request_address" : String--"",
      "request_format":String--"",
      "request_body" : json--{},
}

前端向后端传输固定数据方式-----
Post
http://127.0.0.1:9999/test
json----interface_test^^^^^^^^^

*
* */
@RestController
public class demo1004 extends HttpUtils {

    static ArrayList<String> List = new ArrayList<>();

    /**
     *
     *单个接口交互的后端路由
     */
    @RequestMapping(value = "/test")
    public String interface_test(@RequestBody JSONObject user, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");

        String format = user.getString("request_format");
        String address = user.getString("request_address");
        String type = user.getString("request_type");
        String result = "";
        if(type.equals("Post")){
            if(format.equals("json")){
                //前端请求json--post格式
                JSONObject JSONbody = user.getJSONObject("request_body");
                String body = JSONbody.toString();
                result = doPost(address,body);
            }
            else{//前端请求form--post格式
                Map<String,String> data = toMap(user.getJSONObject("request_body"));
                result = doPost(address,data);
            }
        }else{
            if(format.equals("json")){
                //前端请求json--get格式
                result = doGet(address);
            }
            else{//前端请求form--get格式
                Map<String,String> data = toMap(user.getJSONObject("request_body"));
                result = doGet(address,data);
            }
        }
        JSONObject json = JSON.parseObject(result);
        this.List.add(result);
        return  result;
    }

    @RequestMapping(value = "/response",method = RequestMethod.GET)
    public ArrayList<String> interface_response(HttpServletResponse response){

        return this.List;
    }

    /**
     * 多个接口测试的后端交互路由
     */
    @RequestMapping(value = "/test1")
    public String interface_test1(@RequestBody JSONObject user, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");

        String format = user.getString("request_format");
        String address = user.getString("request_address");
        String type = user.getString("request_type");
        String name = user.getString("request_name");

        String result = "";
        if(type.equals("Post")){
            if(format.equals("json")){
                //前端请求json--post格式
                JSONObject JSONbody = user.getJSONObject("request_body");
                String body = JSONbody.toString();
                result = doPost(address,body);
            }
            else{//前端请求form--post格式
                Map<String,String> data = toMap(user.getJSONObject("request_body"));
                result = doPost(address,data);
            }
        }else{
            if(format.equals("json")){
                //前端请求json--get格式
                result = doGet(address);
            }
            else{//前端请求form--get格式
                Map<String,String> data = toMap(user.getJSONObject("request_body"));
                result = doGet(address,data);
            }
        }
        result = "测试用例名称："+name+"    响应数据："+result;
        this.List.add(result);
        return  result;
    }


    @RequestMapping(value = "/common/fgadmin/login",method = RequestMethod.POST)
    public JSONObject interface1(@RequestBody JSONObject user, HttpServletResponse response){
        response.setContentType("application/json;charset=UTF-8");

        String phoneArea = user.getString("phoneArea");

        String phoneNumber = user.getString("phoneNumber");

        String password = user.getString("password");

        JSONObject result = new JSONObject();

         if(phoneArea.equals("86")&&phoneNumber.equals("20000000000")&&password.equals("netease123")){

            result.put("message","success");
            result.put("code",200);
            Cookie cookie = new Cookie("login","true");
            cookie.setPath("/");
            response.addCookie(cookie);

         }

         return  result;
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public JSONObject interfacelogin(HttpServletResponse response){
        response.setContentType("application/json;charset=UTF-8");

        JSONObject result = new JSONObject();
        result.put("message","success");
        result.put("code",200);

        return result;
    }

    @RequestMapping(value = "/common/skuList",method = RequestMethod.GET)
    public  JSONObject interface2(@RequestParam int goodsId, HttpServletResponse response){

        response.setContentType("application/json;charset=UTF-8");
        JSONObject result = new JSONObject();


        if(goodsId == 1){
            result.put("code",200);
            result.put("message","success");
        }


        return  result;
    }

    @RequestMapping(value = "/common/skuList1",method = RequestMethod.POST)
    public  JSONObject interfacetest(@RequestParam int goodsId, HttpServletResponse response){

        response.setContentType("application/json;charset=UTF-8");
        JSONObject result = new JSONObject();


        if(goodsId == 1){
            result.put("code",200);
            result.put("message","success");
        }


        return  result;
    }

    @RequestMapping(value = "/fgadmin/address/list",method = RequestMethod.GET)
    public  JSONObject interface3(HttpServletRequest request , HttpServletResponse response){

        response.setContentType("application/json;charset=UTF-8");

        Cookie[] cookies = request.getCookies();


        JSONObject result = new JSONObject();

        if(Objects.isNull(cookies)){
            result.put("message","请登录");
        }else{
            for(Cookie cookie :cookies){
                if(cookie.getValue().equals("true")&&cookie.getName().equals("login")){
                    result.put("message","登陆成功");
                    result.put("code",200);
                }
            }
        }

        return  result;
    }

    @RequestMapping(value = "/common/getTransportFee",method = RequestMethod.GET)
    public  JSONObject  interface4(@RequestParam int id,@RequestParam String addressDetail,HttpServletResponse response){
        response.setContentType("application/json;charset=UTF-8");
        JSONObject result = new JSONObject();

        if(id == 1&&addressDetail.equals("浙江省_杭州市_滨江区")){
            result.put("code",200);
            result.put("message","success");
            result.put("result",6.0);
        }

        return  result;
    }

    @RequestMapping(value = "/fgadmin/orders/submit",method = RequestMethod.POST)
    public JSONObject interface5(HttpServletRequest request,@RequestBody JSONObject user,HttpServletResponse response){

        response.setContentType("application/json;charset=UTF-8");

        String skuIds = user.getString("skuIds");
        String skuNumbers = user.getString("skuNumbers");
        String stockIds = user.getString("stockIds");

        Cookie[] cookies = request.getCookies();
        JSONObject result = new JSONObject();

        JSONObject e1 = new JSONObject();
        JSONObject e2 = new JSONObject();

        e1.put("area","滨江区");
        e1.put("cellPhone","123456789");
        e2.put("status",0);
        e2.put("finish",0);

        JSONArray array = new JSONArray();

        array.add(e1);
        array.add(e2);


        if(Objects.isNull(cookies)){
            result.put("message","请登录");
        }else{
            for(Cookie cookie :cookies){
                if(cookie.getValue().equals("true")&&cookie.getName().equals("login")){

                    if(skuIds.contains("2")&&skuNumbers.equals("1")&& stockIds.equals("Netease123")){
                        result.put("message","success");
                        result.put("code",200);
                        result.put("result",array);
                    }
                }
            }
        }

        return  result;
    }

    @RequestMapping(value = "/fgadmin/address/new",method = RequestMethod.POST)
    public JSONObject interface6(HttpServletRequest request,@RequestBody JSONObject user,HttpServletResponse response){
        response.setContentType("application/json;charset=UTF-8");

        Cookie[] cookies = request.getCookies();
        JSONObject result = new JSONObject();
        String receiverName = user.getString("receiverName");
        String cellPhone = user.getString("cellPhone");
        String province = user.getString("province");
        String city = user.getString("city");
        String area = user.getString("area");


        if(Objects.isNull(cookies)){
            result.put("message","请登录");
        }else{
            for(Cookie cookie :cookies){
                if(cookie.getValue().equals("true")&&cookie.getName().equals("login")){
                    if(receiverName.equals("张三")&&cellPhone.equals("123456789")&&province.equals("浙江省")&&city.equals("杭州市")&&area.equals("滨江区")){

                        result.put("message","success");
                        result.put("code",200);
                    }
                }
            }
        }
        return  result;
    }

    @RequestMapping(value = "/fgadmin/address/delete",method = RequestMethod.POST)
    public JSONObject interface7(HttpServletRequest request,HttpServletResponse response,@RequestBody JSONObject user){

        response.setContentType("application/json;charset=UTF-8");

        JSONObject result = new JSONObject();
        Cookie[] cookies = request.getCookies();

        int id = user.getInteger("id");

        if(Objects.isNull(cookies)){
            result.put("message","请登录");
        }else{
            for(Cookie cookie :cookies){
                if(cookie.getValue().equals("true")&&cookie.getName().equals("login")){
                    if(id == 77243286){

                        //响应体为空，删除成功
                    }
                    if(id !=77243286){
                        result.put("code",400);
                        result.put("message","失败");
                    }
                }
            }
        }
        return  result;
    }
}
