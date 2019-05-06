package cn.ucmed.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @auther Alpha丶X
 * @create 2019年01月16日 15:21
 * @describe
 */
public class NumberUtil {

    /**
     * @author Alpha丶X
     * @date 2019-01-16 15:18:07
     * @desc 0 指前面补充零 formatLength 字符总长度为 formatLength d 代表为正数。
     */
    public static String frontCompWithZore(int sourceDate,int formatLength) {
        return String.format("%0" + formatLength + "d", sourceDate);
    }

    /**
     * 保留两位小数
     */
    public static String retainedDecimal(String money) {
        return retainedDecimal(money,"#0.00");
    }

    /**
     *
     */
    public static String retainedDecimal(String money,String dfStr) {
        String str = money;
        try {
            DecimalFormat df = new DecimalFormat(dfStr);
            str = df.format(Double.parseDouble(money));
        } catch (Exception e) {
        }
        return str;
    }

    /**
     * 元转分，确保price保留两位有效数字
     * @return
     */
    public static String changeY2F(String price) {
        String fen = retainedDecimal(price);
        return String.valueOf((int)(Double.parseDouble(fen) * 100));
    }

    /**
     * 分转元，转换为bigDecimal在toString
     * @return
     */
    public static String changeF2Y(String price) {
        return BigDecimal.valueOf(Long.valueOf(retainedDecimal(price,"#0"))).divide(new BigDecimal(100)).toString();
    }

    public static void main(String[] args) {
        System.out.println(changeF2Y("2.73"));
    }
}
