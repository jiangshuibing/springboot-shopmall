package cn.ucmed.web.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by ucmed on 2019/4/25.
 */
public class test {

    public static void main(String[] args) {
        String urldecode = "https://testjsb.zwjk.com";
        String urlencode = "https%3A%2F%2Ftestjsb.zwjk.com";
        try {


            System.out.println(urldecode+"----->"+URLEncoder.encode(urldecode, "UTF-8"));
            System.out.println(urlencode+"----->"+ URLDecoder.decode(urlencode, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
