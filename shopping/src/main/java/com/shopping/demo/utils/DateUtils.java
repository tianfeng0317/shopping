package com.shopping.demo.utils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
    private static final String long_id_Format = "yyyyMMddHHmmssSSS";

    private static final String time_id_Format = "yyyy-MM-dd HH:mm:ss SSS";

    private static final SimpleDateFormat long_id_Formater = new SimpleDateFormat(long_id_Format);

    private static final SimpleDateFormat time23 = new SimpleDateFormat(time_id_Format);

    public static final SimpleDateFormat d8 = new SimpleDateFormat("yyyyMMdd");

    public static final SimpleDateFormat d1 = new SimpleDateFormat("yyyy/MM/dd");

    public static final SimpleDateFormat d0 = new SimpleDateFormat("yyyy-MM-dd");

    public static final SimpleDateFormat d3 = new SimpleDateFormat("yyyy年M月d日");

    public static final SimpleDateFormat dt14 = new SimpleDateFormat("yyyyMMddHHmmss");

    public static final SimpleDateFormat dt1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public static final SimpleDateFormat dt19 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final SimpleDateFormat dt3 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");

    public static String formatter18 = "yyyy-MM-dd HH:mm";

    public static String formatter19 = "yyyy-MM-dd HH:mm:ss";

    public static DateFormat datefmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatter10 = "yyyy-MM-dd";

    public static String formatter11 = "yyyyMMddHHmmss";

    public static String getNow19() {
        return dt19.format(new Date());
    }

    public static String getNow1() {
        return dt1.format(new Date());
    }

    public static String getNow14() {
        return dt14.format(new Date());
    }

    public static String getNow3() {
        return dt3.format(new Date());
    }

    public static String getTime() {
        return dt19.format(new Date()).substring(11);
    }

    public static long getTimeStamp() {
        return new Date().getTime();
    }

    public static String getLongTime() {
        return time23.format(new Date());
    }

    public static String getLongTimeID() {
        return long_id_Formater.format(new Date());
    }

    public static String getDate0() {
        return d0.format(new Date());
    }

    public static String getDate1() {
        return d1.format(new Date());
    }

    public static String getDate8() {
        return d8.format(new Date());
    }

    public static String getDateTime0(long time) {
        return dt19.format(new Date(time));
    }

    public static String getDateTime23(long time) {
        return time23.format(new Date(time));
    }

    public static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    public static String formatDate0(Date myDate) {
        return d0.format(myDate);
    }

    public static String formatDate8(Date myDate) {
        return d8.format(myDate);
    }

    public static String formatDate1(Date myDate) {
        return d1.format(myDate);
    }

    public static String formatDatetime19(Date myDate) {
        return dt19.format(myDate);
    }

    public static String formatDateTime14(Date myDate) {
        return dt14.format(myDate);
    }

    public static String formatDatetime1(Date myDate) {
        return dt1.format(myDate);
    }

    public static long toLongTime(String time) {
        try {
            return dt19.parse(time).getTime();
        } catch (ParseException ex) {
            return 0L;
        }
    }

    public static Date toDate0(String date) {
        try {
            return d0.parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date toDate1(String date) {
        try {
            return d1.parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date toDate2(String date) {
        try {
            return d3.parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date toDate8(String date) {
        try {
            if(date!=null){
                date=date.substring(0,8);
            }
            return d8.parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date toDatetime14(String date) {
        try {
            return dt14.parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 日期按格式转换
     *
     * @param date
     * @param format
     * @return
     */
    public static String dateToString(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    /**
     * 字符串日期按格式转换字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String dateToString2(String date, String format) {
        Date date1 = DateUtils.toDatetime14(date);
        return DateUtils.dateToString(date1, format);
    }

    /**
     * 返回当前时间戳
     *
     * @return
     */
    public static Date getSysTime() {
        Calendar c = Calendar.getInstance();
        return c.getTime();
    }

    /**
     * 获得当前时间yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getDate19() {
        SimpleDateFormat formatter = new SimpleDateFormat(formatter19);
        return formatter.format(new Date());
    }

    /**
     * 获得当前时间yyyy-MM-dd
     *
     * @return
     */
    public static String getDate10() {
        SimpleDateFormat formatter = new SimpleDateFormat(formatter10);
        return formatter.format(new Date());
    }

    /**
     * 时间戳按指定格式转换
     *
     * @param pFormat
     * @return
     */
    public static String toFormat(String pFormat) {
        SimpleDateFormat format = new SimpleDateFormat(pFormat);
        Calendar calendar = Calendar.getInstance();
        String result = format.format(calendar.getTime());
        return result;
    }

    /**
     * 指定时间戳按格式转换
     *
     * @param time
     * @param format
     * @return
     */
    public static String toFormat(long time, String format) {
        return (new SimpleDateFormat(format)).format(new Date(time));
    }

    /**
     * 按“年”、“月”、“日”增加数量，并输出指定格式
     *
     * @param pFormat
     * @param sFlag
     * @param num
     * @return
     */
    public static String addDate(String pFormat, String sFlag, int num) {
        SimpleDateFormat format = new SimpleDateFormat(pFormat);
        Calendar calendar = Calendar.getInstance();
        String result = format.format(calendar.getTime());
        if ("month".equalsIgnoreCase(sFlag) || "m".equalsIgnoreCase(sFlag)) {
            calendar.add(Calendar.MONTH, num);
        }
        if ("year".equalsIgnoreCase(sFlag) || "y".equalsIgnoreCase(sFlag)) {
            calendar.add(Calendar.YEAR, num);
        }
        if ("day".equalsIgnoreCase(sFlag) || "d".equalsIgnoreCase(sFlag)) {
            calendar.add(Calendar.DATE, num);
        }
        Date d1 = calendar.getTime();

        result = format.format(d1);
        return result;
    }

    /**
     * 按“年”、“月”、“日”增加数量，并输出指定格式
     *
     * @param d10
     * @param sFlag
     * @param num
     * @return
     */
    public static String addDate0(String d10, String sFlag, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(toDate0(d10));
        Date rd1;
        if ("month".equalsIgnoreCase(sFlag) || "m".equalsIgnoreCase(sFlag)) {
            calendar.add(Calendar.MONTH, num);
        }
        if ("year".equalsIgnoreCase(sFlag) || "y".equalsIgnoreCase(sFlag)) {
            calendar.add(Calendar.YEAR, num);
        }
        if ("day".equalsIgnoreCase(sFlag) || "d".equalsIgnoreCase(sFlag)) {
            calendar.add(Calendar.DATE, num);
        }
        rd1 = calendar.getTime();
        return d0.format(rd1);
    }

    /**
     * 日期比较大小
     *
     * @param t1
     * @param t2
     * @return
     */
    public static long compare(String t1, String t2) {
        try {
            return dt19.parse(t1).getTime() - dt19.parse(t2).getTime();
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 获得指定日期的年份
     *
     * @param time
     * @return
     */
    public static int getYear(String time) {
        try {
            return Integer.valueOf(time.substring(0, 4)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 获得指定日期的月份
     *
     * @param time
     * @return
     */
    public static int getMonth(String time) {
        try {
            return Integer.valueOf(time.substring(5, 7)).intValue();
        } catch (Exception e) {
            return 0;
        }

    }

    /**
     * 获得指定时间的日期
     *
     * @param time
     * @return
     */
    public static int getDay(String time) {
        try {
            return Integer.valueOf(time.substring(8, 10)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 获得指定时间的小时
     *
     * @param time
     * @return
     */
    public static int getHour(String time) {
        try {
            return Integer.valueOf(time.substring(11, 13)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 获得指定时间的分钟
     *
     * @param time
     * @return
     */
    public static int getMinute(String time) {
        try {
            return Integer.valueOf(time.substring(14, 16)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 获得指定时间的秒
     *
     * @param time
     * @return
     */
    public static int getSecond(String time) {
        try {
            return Integer.valueOf(time.substring(17, 19)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 获得字符串时间的时间戳
     *
     * @param time
     * @return
     * @throws ParseException
     */
    public static long getTimeStamp(String time) throws ParseException {
        return long_id_Formater.parse(time).getTime();
    }

    public static int getDateValue(String time) {
        try {
            return Integer.valueOf(time.substring(8, 10)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    public static String getDisplayTime(long time, String string) {
        return (new SimpleDateFormat(string)).format(new Date(time));
    }

    public static long getLongTime(String time) {
        try {
            return dt19.parse(time).getTime();
        } catch (ParseException ex) {
            return 0L;
        }
    }

    /**
     * Needed to create XMLGregorianCalendar instances
     */
    private static DatatypeFactory df = null;

    static {
        try {
            df = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException dce) {
            throw new IllegalStateException("Exception while obtaining DatatypeFactory instance", dce);
        }
    }

    /**
     * Converts a java.util.Date into an instance of XMLGregorianCalendar
     *
     * @param date Instance of java.util.Date or a null reference
     * @return XMLGregorianCalendar instance whose value is based upon the value
     * in the date parameter. If the date parameter is null then this
     * method will simply return null.
     */
    public static XMLGregorianCalendar asXMLGregorianCalendar(Date date) {
        if (date == null) {
            return null;
        } else {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTimeInMillis(date.getTime());
            return df.newXMLGregorianCalendar(gc);
        }
    }

    /**
     * Converts an XMLGregorianCalendar to an instance of java.util.Date
     *
     * @param xgc Instance of XMLGregorianCalendar or a null reference
     * @return java.util.Date instance whose value is based upon the value in
     * the xgc parameter. If the xgc parameter is null then this method
     * will simply return null.
     */
    public static Date asDate(XMLGregorianCalendar xgc) {
        if (xgc == null) {
            return null;
        } else {
            return xgc.toGregorianCalendar().getTime();
        }
    }

    public static String formatDate(Date date, String format) {
        if (date == null)
            return null;
        String str_date = null;
        if (format != null) {
            DateFormat formater = new SimpleDateFormat(format);
            str_date = formater.format(date);
        } else {
            str_date = datefmt.format(date);
        }
        return str_date;
    }

    public static Date parseToDate(String date, String format) throws ParseException {
        if (date == null)
            return null;
        Date dDate = null;
        if (format != null) {
            DateFormat formater = new SimpleDateFormat(format);
            dDate = formater.parse(date);
        } else {
            DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            dDate = formater.parse(date);
        }
        return dDate;
    }

    public static boolean equalsDate(Date d1, Date d2) {
        if (d1 != null && d2 != null) {
            return d1.getTime() == d2.getTime();
        }
        return false;
    }

    public static boolean isNextDay(Date day, Date nextDay) {
        return (getBetweenDays(day, nextDay) == -1);
    }

    public static boolean isSameDay(Date day, Date otherDay) {
        return (getBetweenDays(day, otherDay) == 0);
    }

    public static int getBetweenDays(Date fDate, Date sDate) {
        int day = (int) ((fDate.getTime() - sDate.getTime()) / 86400000L);
        return day;
    }

    /**
     * 日期加年份
     *
     * @param date
     * @param addYears
     * @return
     */
    public static Date addYears(Date date, int addYears) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.add(Calendar.YEAR, addYears);
        return calender.getTime();
    }

    /**
     * 指定日期加月
     *
     * @param date
     * @param addMonths
     * @return
     */
    public static Date addMonth(Date date, int addMonths) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.add(Calendar.MONTH, addMonths);
        return calender.getTime();
    }

    /**
     * 指定日期加天
     *
     * @param date
     * @param addDays
     * @return
     */
    public static Date addDay(Date date, int addDays) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.add(Calendar.DAY_OF_YEAR, addDays);
        return calender.getTime();
    }

    /**
     * 获取年份的第一天
     *
     * @param year
     * @return
     */
    public static Date getFirstDateOfYear(int year) {
        Calendar calender = Calendar.getInstance();
        calender.set(Calendar.YEAR, year);
        calender.set(Calendar.DAY_OF_YEAR, calender.getActualMinimum(Calendar.DAY_OF_YEAR));
        setStartTimeOfDay(calender);
        return calender.getTime();
    }

    /**
     * 获取年份的最后一天
     *
     * @param year
     * @return
     */
    public static Date getLastDateOfYear(int year) {
        Calendar calender = Calendar.getInstance();
        calender.set(Calendar.YEAR, year);
        calender.set(Calendar.DAY_OF_YEAR, calender.getActualMaximum(Calendar.DAY_OF_YEAR));
        setEndTimeOfDay(calender);
        return calender.getTime();
    }

    /**
     * 验证是否当月的最后一天
     *
     * @param date
     * @return
     */
    public static boolean isLastDayOfMonth(Date date) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        int day = calender.get(Calendar.DAY_OF_MONTH);
        int lastDay = calender.getActualMaximum(Calendar.DAY_OF_MONTH);
        return day == lastDay;
    }

    /**
     * 获得指定年月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(int year, int month) {
        Calendar calender = Calendar.getInstance();
        calender.set(year, month - 1, 1);
        calender.set(Calendar.DAY_OF_MONTH, calender.getActualMaximum(Calendar.DAY_OF_MONTH));
        setEndTimeOfDay(calender);
        return calender.getTime();
    }

    public static Date getLastDayOfMonth(Date date) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.set(Calendar.DAY_OF_MONTH, calender.getActualMaximum(Calendar.DAY_OF_MONTH));
        setEndTimeOfDay(calender);
        return calender.getTime();
    }

    private static void setEndTimeOfDay(Calendar calender) {
        calender.set(Calendar.HOUR_OF_DAY, calender.getActualMaximum(Calendar.HOUR_OF_DAY));
        calender.set(Calendar.MINUTE, calender.getActualMaximum(Calendar.MINUTE));
        calender.set(Calendar.SECOND, calender.getActualMaximum(Calendar.SECOND));
        calender.set(Calendar.MILLISECOND, calender.getActualMaximum(Calendar.MILLISECOND));
    }

    public static Date getFirstDayOfMonth(int year, int month) {
        Calendar calender = Calendar.getInstance();
        calender.set(year, month - 1, 1);
        calender.set(Calendar.DAY_OF_MONTH, calender.getActualMinimum(Calendar.DAY_OF_MONTH));
        setStartTimeOfDay(calender);
        return calender.getTime();
    }

    public static Date getFirstDayOfMonth(Date date) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.set(Calendar.DAY_OF_MONTH, calender.getActualMinimum(Calendar.DAY_OF_MONTH));
        setStartTimeOfDay(calender);
        return calender.getTime();
    }

    private static void setStartTimeOfDay(Calendar calender) {
        calender.set(Calendar.HOUR_OF_DAY, calender.getActualMinimum(Calendar.HOUR_OF_DAY));
        calender.set(Calendar.MINUTE, calender.getActualMinimum(Calendar.MINUTE));
        calender.set(Calendar.SECOND, calender.getActualMinimum(Calendar.SECOND));
        calender.set(Calendar.MILLISECOND, calender.getActualMinimum(Calendar.MILLISECOND));
    }

    public static Date getStartTimeOfDay(Date date) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        setStartTimeOfDay(calender);
        return calender.getTime();
    }

    public static Date getEndTimeOfDay(Date date) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        setEndTimeOfDay(calender);
        return calender.getTime();

    }

    public static String getThisYearMonth() throws ParseException {
        return getYearMonth(new Date());
    }

    public static String getYearMonth(Date date) {
        Calendar today = Calendar.getInstance();
        today.setTime(date);
        return (today.get(Calendar.YEAR)) + "-" + ((today.get(Calendar.MONTH) + 1) >= 10
                ? (today.get(Calendar.MONTH) + 1) : ("0" + (today.get(Calendar.MONTH) + 1)));
    }

    public static int getBetweenMonths(Date date1, Date date2) {
        int iMonth = 0;
        int flag = 0;
        Calendar objCalendarDate1 = Calendar.getInstance();
        objCalendarDate1.setTime(date1);

        Calendar objCalendarDate2 = Calendar.getInstance();
        objCalendarDate2.setTime(date2);

        if (objCalendarDate2.equals(objCalendarDate1))
            return 0;
        if (objCalendarDate1.after(objCalendarDate2)) {
            Calendar temp = objCalendarDate1;
            objCalendarDate1 = objCalendarDate2;
            objCalendarDate2 = temp;
        }
        if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1.get(Calendar.DAY_OF_MONTH))
            flag = 1;

        if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1.get(Calendar.YEAR))
            iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1.get(Calendar.YEAR)) * 12
                    + objCalendarDate2.get(Calendar.MONTH) - flag) - objCalendarDate1.get(Calendar.MONTH);
        else
            iMonth = objCalendarDate2.get(Calendar.MONTH) - objCalendarDate1.get(Calendar.MONTH) - flag;

        return iMonth;
    }

    public static String reduceDateTime(String beginDateTime, String unit, long day_date) throws ParseException {
        Date beginDate = dt14.parse(beginDateTime);
        long time = 0L;
        if ("N".equals(unit)) {
            time = beginDate.getTime() - day_date * 60 * 1000;
        }
        if ("H".equals(unit)) {
            time = beginDate.getTime() - day_date * 60 * 60 * 1000;
        }
        if ("D".equals(unit)) {
            time = beginDate.getTime() - day_date * 24 * 60 * 60 * 1000;
        }
        if ("M".equals(unit)) {
            time = beginDate.getTime() - day_date * 30 * 24 * 60 * 60 * 1000;
        }
        Date date1 = new Date(time);
        String yyyyMMddHHmm = dateToString(date1, "yyyyMMddHHmm");

        return yyyyMMddHHmm;
    }

    public static int getBetweenYears(Date date1, Date date2) {
        return getBetweenMonths(date1, date2) / 12;
    }


    /**
     * 星期的数字转换成中文
     *
     * @param num
     * @return
     */
    public static String week2ZH(int num) {

        String sRet = "";
        switch (num) {
            case 1: {

                sRet = "日";
                break;
            }
            case 2: {

                sRet = "一";
                break;
            }
            case 3: {
                sRet = "二";
                break;
            }
            case 4: {
                sRet = "三";
                break;
            }
            case 5: {
                sRet = "四";
                break;
            }
            case 6: {
                sRet = "五";
                break;
            }
            case 7: {
                sRet = "六";
                break;
            }
        }
        return sRet;
    }
    public static String week2EN(int num) {

        String sRet = "";
        switch (num) {
            case 1: {

                sRet = "SUN";
                break;
            }
            case 2: {

                sRet = "MON";
                break;
            }
            case 3: {
                sRet = "TUS";
                break;
            }
            case 4: {
                sRet = "WED";
                break;
            }
            case 5: {
                sRet = "THU";
                break;
            }
            case 6: {
                sRet = "FRI";
                break;
            }
            case 7: {
                sRet = "SAT";
                break;
            }
        }
        return sRet;
    }
    public static String getUnit(String unit) {
        if ("N".equals(unit)) {
            return "分钟";
        } else if ("D".equals(unit)) {
            return "天";
        } else if ("M".equals(unit)) {
            return "月";
        } else {
            return "小时";
        }
    }

    private static final Map<String, String> MONTHS = new HashMap<String, String>() {
        {
            put("JAN", "01");
            put("FEB", "02");
            put("MAR", "03");
            put("APR", "04");
            put("MAY", "05");
            put("JUN", "06");
            put("JUL", "07");
            put("AUG", "08");
            put("SEP", "09");
            put("OCT", "10");
            put("NOV", "11");
            put("DEC", "12");
        }
    };

    private static final Map<String, String> FLYMONTHS = new HashMap<String, String>() {
        {
            put("01", "JAN");
            put("02", "FEB");
            put("03", "MAR");
            put("04", "APR");
            put("05", "MAY");
            put("06", "JUN");
            put("07", "JUL");
            put("08", "AUG");
            put("09", "SEP");
            put("10", "OCT");
            put("11", "NOV");
            put("12", "DEC");
        }
    };

    public static String arridDate(String str, Integer arrid) {
        Integer year = Integer.parseInt(str.substring(0, 4));
        Integer month = Integer.parseInt(str.substring(4, 6));
        Integer day = Integer.parseInt(str.substring(6, 8));
        String other = str.substring(8);
        Calendar cld = Calendar.getInstance();
        cld.set(Calendar.YEAR, year);
        cld.set(Calendar.MONDAY, month);
        cld.set(Calendar.DATE, day);
        cld.add(Calendar.DATE, arrid);
        Integer newyear = cld.get(Calendar.YEAR);
        Integer newmonth = cld.get(Calendar.MONTH);
        Integer newdate = cld.get(Calendar.DATE);
        if (newmonth.toString().length() == 1) {
            if (newdate.toString().length() == 1) {
                return newyear + "0" + newmonth + "0" + newdate + other;
            } else {
                return newyear + "0" + newmonth + "" + newdate + other;
            }
        }
        if (newmonth.toString().length() == 1) {
            if (newdate.toString().length() == 1) {
                return newyear + "" + newmonth + "0" + newdate + other;
            } else {
                return newyear + "" + newmonth + "" + newdate + other;
            }
        }
        return null;

    }

    public static String toFormatFlyDate(String str) {
        String month = FLYMONTHS.get(str.substring(4, 6));
        if (null != month) {
            if (str.length() == 8) {
                return str.substring(6, 8) + month + str.substring(2, 4);
            }

        }
        return null;

    }


    public static String toFormatStringDate(String str) {
        String month = MONTHS.get(str.substring(2, 5));
        if (null != month) {
            if (str.length() == 9) {
                return str.substring(5, 9) + month + str.substring(0, 2);
            }
            return "20" + str.substring(5, 7) + month + str.substring(0, 2);
        }

        return null;

    }

    /**
     * 把字符串日期转换成 20DEC19/19:00 格式
     *
     * @param
     * @return
     */
    public static String toTravelSkyDate(String oldDate) {
        String date = "";
        String month = FLYMONTHS.get(oldDate.substring(4, 6));
        if (null != month) {
            date = oldDate.substring(6, 8) + month + oldDate.substring(0, 4);
        }
        String dateTime = date + "/" + oldDate.substring(8, 10) + ":" + oldDate.substring(10, 12);
        return dateTime;
    }


    /**
     * @Author: tianfeng
     * description: 将字符串日期转换成Calendar类型
     * create time: 10:48 2020/4/3
     */
    public static Calendar getCalendar(String dateTime){
        Calendar calendar = Calendar.getInstance();//到达时间
        String year = dateTime.substring(0, 4);
        String mon = dateTime.substring(4, 6);
        String day = dateTime.substring(6, 8);
        String hour = dateTime.substring(8, 10);
        String min = dateTime.substring(10, 12);
        calendar.set(Integer.parseInt(year), Integer.parseInt(mon) - 1, Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(min), 00);
        return calendar;
    }

    /**
     * @Author: tianfeng
     * description: 将字符串日期减去两个小时转换成Calendar类型
     * create time: 10:48 2020/4/3
     */
    public static Calendar reduceSpeciDate(String dateTime){
        Calendar calendar = Calendar.getInstance();//到达时间
        String year = dateTime.substring(0, 4);
        String mon = dateTime.substring(4, 6);
        String day = dateTime.substring(6, 8);
        String hour = dateTime.substring(8, 10);
        String min = dateTime.substring(10, 12);
        calendar.set(Integer.parseInt(year), Integer.parseInt(mon) - 1, Integer.parseInt(day), Integer.parseInt(hour) - 2, Integer.parseInt(min), 00);
        return calendar;
    }

    public static Date String2Date(String string, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = formatter.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
