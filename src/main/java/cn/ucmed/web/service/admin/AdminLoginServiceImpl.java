package cn.ucmed.web.service.admin;

import cn.ucmed.web.mapper.admin.AdminLoginMapper;
import cn.ucmed.web.module.admin.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ucmed on 2019/4/25.
 */
@Service
public class AdminLoginServiceImpl implements AdminLoginService{

    @Autowired
    private AdminLoginMapper adminLoginMapper;

    @Override
    public Admin selectByPrimaryKey(String userName) {
        return adminLoginMapper.selectByPrimaryKey(userName);
    }
}
