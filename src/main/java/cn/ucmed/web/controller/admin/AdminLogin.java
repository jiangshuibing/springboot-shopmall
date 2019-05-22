package cn.ucmed.web.controller.admin;

import cn.ucmed.web.module.admin.Admin;
import cn.ucmed.web.service.admin.AdminLoginService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/admin")
@Api(tags = "用户接口")
public class AdminLogin {

    @Autowired
    private AdminLoginService adminLoginService;

    @GetMapping()
    public String Index(HttpServletRequest request, Model model, ModelMap map){
        return "web/admin/login";
    }

    @ResponseBody
    @PostMapping(value = "/login")
    public JSONObject Login(HttpServletRequest request, Model model, ModelMap map){
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        JSONObject res = new JSONObject();
        Admin admin = adminLoginService.selectByPrimaryKey(userName);
        if(admin == null){
            // 登录名错误
            res.put("code", 500);
            res.put("message", "用户名错误");
        }else if(!passWord.equals(admin.getPassWord())){
            // 密码错误
            res.put("code", 500);
            res.put("message", "密码错误");
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);
            res.put("code", 200);
            res.put("message", "成功");
        }
        return res;
    }

    @GetMapping(value = "/shop")
    public String IndexTest(HttpServletRequest request, Model model, ModelMap map){
        return "web/admin/index";
    }
}
