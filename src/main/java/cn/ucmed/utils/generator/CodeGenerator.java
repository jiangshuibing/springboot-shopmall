package cn.ucmed.utils.generator;

import cn.ucmed.utils.DateUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.sun.javafx.PlatformUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.baomidou.mybatisplus.generator.config.rules.DateType.ONLY_DATE;

/**
 * @auther Alpha丶X
 * @create 2018年12月21日 16:45
 * @describe 代码生成器
 */
public class CodeGenerator {

  public static final String PARENT_NAME = "cn.ucmed.modular";  // 代码生成位置
  public static final String MODULAR_NAME = "db-core"; // modular 名字
  public static final String SRC_MAIN_JAVA = "/src/main/java/"; // 基本路径
  public static final String AUTHOR = "CodeGenerator"; // 作者

  private static final boolean REST_CONTROLLER_STYLE = true; // 是否rest接口

  public static final String JDBC_MYSQL_URL = "jdbc:mysql://127.0.0.1:3306/zsyy_shopmall?useUnicode=true&useSSL=false&characterEncoding=utf8";
  public static final String JDBC_DRIVER_NAME = "com.mysql.jdbc.Driver";
  public static final String JDBC_USERNAME = "root";
  public static final String JDBC_PASSWORD = "jsb19930406";

  public static void main(String[] args) {
    // 代码生成器
    String moduleName = scanner("模块名");
    String tableName = scanner("表名");
    String tablePrefix = scanner("表前缀(无前缀输入#)").replaceAll("#","");

//    String moduleName = "system";
//    String tableName = "sys_less_variable";
//    String tablePrefix = "sys";


    atuoGenerator(moduleName,tableName,tablePrefix);
  }

  public static void atuoGenerator(String moduleName,String tableName,String tablePrefix) {
    new AutoGenerator()
            .setGlobalConfig(getGlobalConfig())
            .setDataSource(getDataSourceConfig())
            .setPackageInfo(getPackageConfig(moduleName))
            .setStrategy(getStrategyConfig(tableName,tablePrefix))
            .setCfg(getInjectionConfig())
            .setTemplate(getTemplateConfig())
            .execute();
  }

  private static InjectionConfig getInjectionConfig() {
    return new InjectionConfig() {
      @Override
      public void initMap() {
        Map map = new HashMap();
        String dateTime = DateUtil.format(new Date(), DateUtil.YCHAR_06);
        map.put("dateTime",dateTime);
        setMap(map);
      }
    };
  }

  /**
   * @Author Alpha丶X
   * @Date 2018-12-24 11:06:22
   * @Description 4.策略配置
   */
  private static StrategyConfig getStrategyConfig(String tableName,String tablePrefix) {
    return new StrategyConfig()
            .setNaming(NamingStrategy.underline_to_camel)  // 下划线转驼峰命名
            .setColumnNaming(NamingStrategy.underline_to_camel) // 下划线转驼峰命名
            .setInclude(tableName)
            .setRestControllerStyle(REST_CONTROLLER_STYLE)
            .setControllerMappingHyphenStyle(true)
            .entityTableFieldAnnotationEnable(true)
            .setTablePrefix(tablePrefix + "_");
  }

  /**
   * @Author Alpha丶X
   * @Date 2018-12-24 11:06:11
   * @Description 3.包名策略配置
   */
  private static PackageConfig getPackageConfig(String moduleName) {
    return new PackageConfig()
            .setModuleName(moduleName)
            .setParent(PARENT_NAME)
            .setMapper("mapper")//dao
            .setService("service")//servcie
            .setServiceImpl("service.impl") // impl
            .setController("controller")//controller
            .setEntity("entity")
            .setXml("mapper.mapping");//mapper.xml
  }

  /**
   * @Author Alpha丶X
   * @Date 2018-12-24 11:05:57
   * @Description 2.数据源配置
   */
  private static DataSourceConfig getDataSourceConfig() {
    return new DataSourceConfig()
            .setUrl(JDBC_MYSQL_URL)
            .setDriverName(JDBC_DRIVER_NAME)
            .setUsername(JDBC_USERNAME)
            .setPassword(JDBC_PASSWORD);
  }

  /**
   * @Author Alpha丶X
   * @Date 2018-12-24 11:05:45
   * @Description 1.全局配置
   */
  private static GlobalConfig getGlobalConfig() {
    String projectPath = System.getProperty("user.dir");
    //封装模板数据
    String filePath = projectPath + "/" + MODULAR_NAME + SRC_MAIN_JAVA;
    if (PlatformUtil.isWindows()) {
      filePath = filePath.replaceAll("/+|\\\\+", "\\\\");
    } else {
      filePath = filePath.replaceAll("/+|\\\\+", "/");
    }
    return new GlobalConfig()
            .setOutputDir(filePath)
            .setDateType(ONLY_DATE)
            .setIdType(IdType.UUID)
            .setAuthor(AUTHOR)
            .setBaseColumnList(true)
            .setSwagger2(true)
            .setEnableCache(false)
            .setBaseResultMap(true)
            .setOpen(false);
  }

  /**
   * @Author Alpha丶X
   * @Date 2018-12-24 11:06:35
   * @Description 5.模板位置
   */
  private static TemplateConfig getTemplateConfig(){
    // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
    // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
    return new TemplateConfig()
            .setController("/templates-generator/controller.java.vm")
            .setService("/templates-generator/service.java.vm")
            .setServiceImpl("/templates-generator/serviceImpl.java.vm")
            .setEntity("/templates-generator/entity.java.vm")
            .setMapper("/templates-generator/mapper.java.vm")
            .setXml("/templates-generator/mapper.xml.vm")
    ;
  }

  /**
   * @Author Alpha丶X
   * @Date 2018-12-24 11:06:47
   * @Description 读取控制台内容
   */
  public static String scanner(String tip) {
    Scanner scanner = new Scanner(System.in);
    StringBuilder help = new StringBuilder();
    help.append("请输入" + tip + "：");
    System.out.println(help.toString());
    if (scanner.hasNext()) {
      String ipt = scanner.next();
      if (StringUtils.isNotEmpty(ipt)) {
        return ipt;
      }
    }
    throw new MybatisPlusException("请输入正确的" + tip + "！");
  }

}
