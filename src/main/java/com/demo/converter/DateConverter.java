package com.demo.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义日期类型转换器1/3
 */
public class DateConverter implements Converter<String,Date> {

    private String pattern="yyyy-MM-dd HH:mm:ss";
    /*给格式提供一个赋值的入口，在使用的时候可以自定义*/
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Date convert(String s) {
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        Date date=null;
        try {
            date=sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
