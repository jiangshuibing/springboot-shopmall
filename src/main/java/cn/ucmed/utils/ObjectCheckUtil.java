package cn.ucmed.utils;

/**
 * @auther Alpha丶X
 * @create 2019年01月16日 17:15
 * @describe
 */
public class ObjectCheckUtil {

    /**
     * @author Alpha丶X
     * @date 2019-01-16 17:21:16
     * @desc 判断空值
     */
    public static boolean isNull(Object object){
        if (null == object){
            return true;
        }
        return false;
    }

    /**
     * @author Alpha丶X
     * @date 2019-01-16 17:21:16
     * @desc 判断字符串空值
     */
    public static boolean isEmpty(String str){
        if (null == str && "".equals(str)){
            return true;
        }
        return false;
    }
}
