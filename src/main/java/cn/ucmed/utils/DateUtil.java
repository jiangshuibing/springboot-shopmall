package cn.ucmed.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther Alpha丶X
 * @create 2018年12月26日 09:19
 * @describe 时间格式处理
 */
public class DateUtil {

  public static final String YCHAR_01 = "MM-dd";

  public static final String YCHAR_02 = "HH:mm";

  public static final String YCHAR_03 = "HH:mm:ss";

  public static final String YCHAR_04 = "yyyy-MM-dd";

  public static final String YCHAR_05 = "yyyy/MM/dd";

  public static final String YCHAR_06 = "yyyy-MM-dd HH:mm:ss";

  public static final String YCHAR_07 = "yyyy-MM-dd'T'HH:mm:ss";

  public static final String YCHAR_08 = "yyyy-MM-dd HH:mm:ss:SSS";

  public static final String NCHAR_01 = "MMdd";

  public static final String NCHAR_02 = "HHmm";

  public static final String NCHAR_03 = "HHmmss";

  public static final String NCHAR_04 = "yyyyMMdd";

  public static final String NCHAR_05 = "yyyyMMddHHmmss";

  public static final String NCHAR_06 = "yyyyMMdd'T'HHmmss";

  public static final String NCHAR_07 = "yyyyMMddHHmmssSSS";

  /** 锁对象 */
  private static final Object lockObj = new Object();

  /** 存放不同的日期模板格式的sdf的Map */
  private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

  /**
   * 返回一个ThreadLocal的sdf,每个线程只会new一次sdf
   *
   * @param pattern
   * @return
   */
  private static SimpleDateFormat getDateFormat(final String pattern) {
    ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);

    // 此处的双重判断和同步是为了防止sdfMap这个单例被多次put重复的sdf
    if (tl == null) {
      synchronized (lockObj) {
        tl = sdfMap.get(pattern);
        if (tl == null) {
          // 只有Map中还没有这个pattern的sdf才会生成新的sdf并放入map
          // 这里是关键,使用ThreadLocal<SimpleDateFormat>替代原来直接new SimpleDateFormat
          tl = new ThreadLocal<SimpleDateFormat>() {
            @Override
            protected SimpleDateFormat initialValue() {
              return new SimpleDateFormat(pattern);
            }
          };
          sdfMap.put(pattern, tl);
        }
      }
    }

    return tl.get();
  }


  /**
   * date类型转String类型
   * @param date
   * @param dateFormat
   * @return
   */
  public static String format(Date date,String dateFormat){
    return getDateFormat(dateFormat).format(date);
  }

  /**
   * String类型转date类型
   * @param dateStr
   * @param dateFormat
   * @return
   * @throws ParseException
   */
  public static Date parse(String dateStr,String dateFormat) throws ParseException {
    return getDateFormat(dateFormat).parse(dateStr);
  }

  /**
   *
   * @param dateStr
   * @param beforeFormat
   * @param afterFormat
   * @return
   * @throws ParseException
   */
  public static String strFormat(String dateStr,String beforeFormat,String afterFormat) {
    try {
      Date date = parse(dateStr,beforeFormat);
      return format(date,afterFormat);
    }catch (Exception e){
    }
    return dateStr;
  }

  /**
   * @author Alpha丶X
   * @date 2019-01-16 16:41:52
   * @desc 获取一定天数前或后的时间
   */
  public static String getDateByDays(Integer days,String dateFormat) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_YEAR, days);
    return format(calendar.getTime(),dateFormat);
  }

  /**
   * @author Alpha丶X
   * @date 2019-01-16 16:42:42
   * @desc 获取一定天数前或后的时间 格式：yyyy-MM-dd
   */
  public static String getDateByDays(Integer days) {
    return getDateByDays(days,YCHAR_04);
  }

  /**
   * @author Alpha丶X
   * @date 2019-01-16 16:41:52
   * @desc 获取指定日期一定天数前或后的时间
   */
  public static String getDateByDays(String date, Integer days, String dateFormat) {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
    LocalDate inputDate = LocalDate.parse(date, formatter);
    LocalDate resultDate = inputDate.plus(days, ChronoUnit.DAYS);
    return resultDate.toString();
  }



  /**
   * @Author Alpha丶X
   * @Date 2018-12-26 18:15:46
   * @Description 获取今天，用于路径拼接
   */
  public static String getToday(){
    return format(new Date(), DateUtil.NCHAR_04);
  }

  public static Date addDate(Date date, int field, int time) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(field, time);
    return calendar.getTime();
  }

  public static Date addDate(Date date, String field, int time) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(getField(field), time);
    return calendar.getTime();
  }

  /**
   * 时效单位：y年，M月，d日，h小时，m分钟，s秒
   * 默认分钟
   * @param field
   * @return
   */
  public static int getField(String field) {
    if("y".equals(field)) {
      return Calendar.YEAR;
    }
    if("M".equals(field)) {
      return Calendar.MONTH;
    }
    if("d".equals(field)) {
      return Calendar.DAY_OF_MONTH;
    }
    if("h".equals(field)) {
      return Calendar.HOUR;
    }
    if("m".equals(field)) {
      return Calendar.MINUTE;
    }
    if("s".equals(field)) {
      return Calendar.SECOND;
    }
    return Calendar.MINUTE;
  }

}
