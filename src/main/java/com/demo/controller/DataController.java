package com.demo.controller;

import com.demo.entity.User;
import com.demo.entity.UserDto;
import com.demo.entity.WechatMessageTemplate;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*import org.apache.commons.codec.digest.DiestUtils;*/
import javax.servlet.http.HttpSession;

@Controller
//@SessionAttributes({"k","kk"})//从request作用域中把数据复制到session作用域中//k: request作用域中的key
public class DataController {

    @RequestMapping("/login")
    public @ResponseBody Map login(User user){
        Map map =new HashMap();
        String username=user.getUsername();
        String password=user.getPassword();

        System.out.println("==username==:"+username);
        System.out.println("==password==:"+password);
        //登录校验，返回user对象
        User us=new User("张三","123");
        if(us!=null){
            map.put("isLogin",true);
            return map;
        }
        map.put("isLogin",false);
        return map;
    }

  /*  通过方法形参接收数据的方式/3===========================start===================================*/
    @RequestMapping("/receiveParam")
    public String receiveParam(User user){

        String username=user.getUsername();
        String password=user.getPassword();
        System.out.println("==username==:"+username);
        System.out.println("==password==:"+password);
        return "index";
    }

    @RequestMapping("/receiveParam2")
    public String receiveParam2(String username,String password){

        System.out.println("==username==:"+username);
        System.out.println("==password==:"+password);
        return "index";
    }

    @RequestMapping("/receiveParam3")
    public String receiveParam3(HttpServletRequest request){

        System.out.println("==username==:"+request.getAttribute("username"));

        return "index";
    }

    @RequestMapping("/receiveManyParam")
    public String receiveManyParam(int[] id){

        System.out.println("====通过数组接收同名多参数===:"+ Arrays.toString(id));

        return "index";
    }

    /*批量添加用户*/
    @RequestMapping("/receiveManyParam2")
    public String receiveManyParam2(UserDto userDto){
        //由于该dto对象有一个属性是一个list集合，前台通过users[0].username,users[1].username可以批量添加多个user到list集合中
        System.out.println("====封装新的实体对象DTO===");
        /*遍历集合逐个添加数据至数据库*/
        return "index";
    }
    /*  通过方法形参接收数据的方式===========================END===================================*/

    /*  通过方法形参传递数据的方式/3===========================start===================================*/
    @RequestMapping("/sendData")
    public String saveData(Map map){
        map.put("key","通过map向request作用域中存数据");
        return "index";
    }

    @RequestMapping("/sendData2")
    public String saveData2(HttpSession session){
        session.setAttribute("key","向session中存数据");
        return "index";
    }

    @RequestMapping("/sendData3")
    public String sendData3(HttpServletRequest request){

        request.setAttribute("username","向request作用域中存放数据");

        return "index";
    }

    @RequestMapping("/sendData4")
    public String sendData4(Model model){
        //数据放置在request作用域中
        model.addAttribute("k",new User("李四","1234"));
        return "index";
    }

    @RequestMapping("/sendData5")
    public String sendData5(ModelMap modelMap){
        //数据放置在request作用域中
        modelMap.addAttribute("k",new User("李四","1234"));
        modelMap.put("k","这是通过ModelMap的put方法放进来的一个字符串");
        return "index";
    }

    /*  通过方法形参传递数据的方式===========================END===================================*/


    @RequestMapping("/receiveDateParam")
    public String receiveDateParam(){

        return "index";
    }

    /*  跳转方式===========================start===================================*/
    @RequestMapping("/skip")
    public String skip(){

        System.out.println("skip method........");

        return "success";//通过视图解析器，转发请求物理视图
        //return "forward:/index.jsp";//不通过视图解析器，直接转发至指定的地址
        //return "redirect:/login.do";//不通过视图解析器，直接重定向至指定的地址
    }

    @RequestMapping("/skip2")
    public ModelAndView skip2(){

        System.out.println("skip2 method........");
        //ModelAndView中可以保存发送到页面的数据（被放在request作用域中），也可以保存逻辑视图名
        //new ModelAndView("逻辑视图名"，"放置在request作用域中的key","放置在request作用域中的value");
        return new ModelAndView("index","key","value");
    }
     /*  跳转方式===========================END===================================*/

    /* 数据的转存============================start==================================================*/

    //类上面加注解@sessionAttributes({"k","kk"})从request作用域中把数据复制到session作用域中

    @RequestMapping("/setData")
    public String setData(@ModelAttribute("username") String username){//key要和参数名一样//接收到的数据会放置在request作用域中
    // public String setData(@ModelAttribute("userrr") User user){//对象类型可以任意
        System.out.println("==username==:"+username);

        return "index";
    }

     /* 数据的转存============================END==================================================*/

    @RequestMapping("/getMyJson")
    public String getMyJosn(String touser){//key要和参数名一样//接收到的数据会放置在request作用域中
        System.out.println("==getMyJson==============");
        System.out.println("==touser=============="+touser);

        return "index";
    }

    /*前端传递过来的json参数,解析post请求json参数*/
    @RequestMapping(value = "/getMyJson2", method = RequestMethod.POST, consumes = "application/json")
    public  @ResponseBody String getMyJson2(@RequestBody WechatMessageTemplate wechatMessageTemplate) {
        System.out.println("============wechatMessageTemplate : "+wechatMessageTemplate );

        // 操作 ...
        return "index";
    }

   /* @RequestParam注解主要有哪些参数：
    value：参数名字，即入参的请求参数名字，如username表示请求的参数区中的名字为username的参数的值将传入；
    required：是否必须，默认是true，表示请求中一定要有相应的参数，否则将报404错误码；
    defaultValue：默认值，表示如果请求中没有同名参数时的默认值。*/


    /**
     * @PathVariable注解的使用
     *  绑定URI模板变量值，
     *  用来获得请求url中的动态参数的，
     *  将请求URL中的模板变量映射到功能处理方法的参数上。//配置url和方法的一个关系
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/testPathVarible/{rows}/{page}") //没有先后顺序，指明对应的变量即可
    public String testPathVarible(@PathVariable("page") Integer page,@PathVariable("rows") Integer rows){
        System.out.println(page+"======testPathVarible======"+rows);
        return "index";
    }

}
