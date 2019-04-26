package cn.ucmed.web.controller.admin;

import cn.ucmed.web.module.admin.Admin;
import cn.ucmed.web.service.admin.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/admin")
public class AdminLogin {

    @Autowired
    private AdminLoginService adminLoginService;

    @GetMapping(value = "/login")
    public String Login(HttpServletRequest request, Model model, ModelMap map){
        Admin admin = adminLoginService.selectByPrimaryKey(1);

        return "web/admin/adminlogin";
    }

}
