package cn.ucmed.web.controller.admin;

import cn.ucmed.web.module.admin.Admin;
import cn.ucmed.web.service.admin.AdminLoginService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/admin")
@Api(tags = "用户接口")
public class AdminLogin {

    @Autowired
    private AdminLoginService adminLoginService;

    @GetMapping()
    @ApiOperation("用户登陆跳转")
    public String Index(HttpServletRequest request, Model model, ModelMap map){
        return "web/admin/adminlogin";
    }

    @PostMapping(value = "/login")
    @ApiOperation("登陆")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userName", value = "userName", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "passWord", value = "passWord", required = true, dataType = "String", paramType = "path")
    })
    public String Login(HttpServletRequest request, Model model, ModelMap map,
                        @PathVariable(value = "userName") final String userName,
                        @PathVariable(value = "passWord") final String passWord){
        Admin admin = adminLoginService.selectByPrimaryKey(userName);
        if(admin == null){
            // 登录名错误
        }else if(!passWord.equals(admin.getPassWord())){
            // 密码错误
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);
            return "web/admin/index";
        }
        return null;
    }

}
