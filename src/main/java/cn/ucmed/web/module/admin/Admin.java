package cn.ucmed.web.module.admin;

/**
 * Created by ucmed on 2019/4/25.
 */
public class Admin {

    private Integer id;

    private String adminName;

    private String passWord;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
