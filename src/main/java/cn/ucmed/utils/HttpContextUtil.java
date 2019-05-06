package cn.ucmed.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author：Qieyt
 * @Date: Created in 14:50 2019-01-10
 * @Description: 获取 HttpServletRequest HttpServletResponse
 */
public class HttpContextUtil {

    /**
     * 获取 HttpServletRequest
     * @return
     */
    public static HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(servletRequestAttributes == null) {
            return null;
        }
        return servletRequestAttributes.getRequest();
    }

    /**
     * 获取 HttpServletResponse
     * @return
     */
    public static HttpServletResponse getHttpServletResponse() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(servletRequestAttributes == null) {
            return null;
        }
        return servletRequestAttributes.getResponse();
    }

}
