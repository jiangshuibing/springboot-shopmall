package cn.ucmed.web.service.admin;

import cn.ucmed.web.module.admin.Admin;
import org.springframework.stereotype.Service;

/**
 * Created by ucmed on 2019/4/25.
 */

public interface AdminLoginService {

    Admin selectByPrimaryKey(Integer id);
}
