package cn.ucmed.web.mapper.admin;

import cn.ucmed.web.module.admin.Admin;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * Created by ucmed on 2019/4/25.
 */
@Mapper
public interface AdminLoginMapper {

    @Select({
            "select",
            "id, admin_name, pass_word",
            "from admin",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="admin_name", property="adminName", jdbcType=JdbcType.VARCHAR),
            @Result(column="pass_word", property="passWord", jdbcType=JdbcType.VARCHAR)
    })
    Admin selectByPrimaryKey(Integer id);
}
