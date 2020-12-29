package com.shopping.demo;

import com.shopping.demo.utils.DateUtils;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * @Author :tianfeng
 * @Date : 2020/12/14 10:13
 * @Description:
 */
public class CalendarTest {

    public static void main(String[] args) {
//        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        Calendar birthday = Calendar.getInstance();//生日
        int year = Integer.parseInt("1989");
        int mon = Integer.parseInt("08");
        int day = Integer.parseInt("06");
        birthday.set(year, mon - 1, day);
        XMLGregorianCalendar xmlGregorianCalendar = DateUtils.asXMLGregorianCalendar(birthday.getTime());
        System.out.println("1989-08-06T10:21:26.305+08:00");
        System.out.println(xmlGregorianCalendar);
    }
}
