package com.blog.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public final class DateUtil {
	
	
    /**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
    public static int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    } 
    
    /**  
     * 计算两个日期之间相差的周数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差周数 
     * @throws ParseException  
     */    
    public static int weekBetween(String smdate,String bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(sdf.parse(smdate));    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(sdf.parse(bdate));    
        long time2 = cal.getTimeInMillis();         
        long between_week=(time2-time1)/(1000*3600*24*7);  
            
       return Integer.parseInt(String.valueOf(between_week));           
    }    
    
    /**  
     * 计算两个日期之间相差的月数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差月数 
     * @throws ParseException  
     */    
    public static int monthBetween(String smdate,String bdate) throws ParseException    
    {    
    	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
         Calendar cal = Calendar.getInstance();    
         cal.setTime(sdf.parse(smdate));    
         long time1 = cal.getTimeInMillis();                 
         cal.setTime(sdf.parse(bdate));    
         long time2 = cal.getTimeInMillis(); 
         long between_month=(time2-time1)/(1000*3600*24*30);  
            
       return Integer.parseInt(String.valueOf(between_month));           
    }    
    
    /**  
     * 计算两个日期之间相差的年数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差年数 
     * @throws ParseException  
     */    
    public static int yearBetween(String smdate,String bdate) throws ParseException    
    {    
    	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
         Calendar cal = Calendar.getInstance();    
         cal.setTime(sdf.parse(smdate));    
         long time1 = cal.getTimeInMillis();                 
         cal.setTime(sdf.parse(bdate));    
         long time2 = cal.getTimeInMillis();          
         long between_year=(time2-time1)/(1000*3600*24*365);  
            
       return Integer.parseInt(String.valueOf(between_year));           
    }    
    
    /**  
     * 判断两个时间的大小 
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return boolean 
     * @throws ParseException  
     */    
    public static boolean dateCompare(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
            
       return time2>=time1;           
    }    
    
    /**  
     * 计算两个日期之间相差的时分秒  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差时分秒  
     * @throws ParseException  
     */    
    public static String timeBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        //获取剩余时分秒
      	StringBuilder timeString = new StringBuilder();
      	timeString.append((time2-time1)/1000/60/60).append("时");//时
		timeString.append((time2-time1)/1000/60%60).append("分");//分
		timeString.append((time2-time1)/1000/60%60%60).append("秒");//秒
            
       return timeString.toString();           
    }    
    
    /**
     * 
     * @author	wwd
     * @date	2015-8-25
     * @param smdate
     * @param bdate
     * @return
     * @throws ParseException
     */
    public static int daysBetween(String smdate,String bdate) throws ParseException{  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(sdf.parse(smdate));    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(sdf.parse(bdate));    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
        return Integer.parseInt(String.valueOf(between_days));     
    } 
    
	public static Date getDiffDay(Date date,int days){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, days);
		return c.getTime();
	}
	
	/**
	 * 获取之前的日期列表
	 * @param date
	 * @param days
	 * @return
	 */
	public static List<Date> getBeforeDays(Date date,int days){
		Calendar c = Calendar.getInstance();
		List<Date> dl = new ArrayList<Date>();
		if(days > 0){
			for(int i = days; i > 0; i--){
				c.setTime(date);
				c.add(Calendar.DAY_OF_MONTH, -i);
				dl.add(c.getTime());
			}
		}
		return dl;
	}
	
	/**
	 * 获取之后的日期列表
	 * @param date
	 * @param days
	 * @return
	 */
	public static List<Date> getAfterDays(Date date,int days){
		Calendar c = Calendar.getInstance();
		List<Date> dl = new ArrayList<Date>();
		if(days > 0){
			for(int i = 1; i <= days; i++){
				c.setTime(date);
				c.add(Calendar.DAY_OF_MONTH, i);
				dl.add(c.getTime());
			}
		}
		return dl;
	}
	
	public static Date getCurrentTime() {
		Calendar c = Calendar.getInstance();
		return c.getTime();
	}

	public static java.sql.Timestamp getCurrentTimestamp() {
		return new java.sql.Timestamp(getCurrentTime().getTime());
	}
	
	public static java.sql.Timestamp getCurrentTimestamp(Date date) {
		return new java.sql.Timestamp(date.getTime());
	}
	
	/**
	 * 当前Calendar
	 * 
	 * @return
	 *
	 */
	public static Calendar currentCal(){
		return Calendar.getInstance();
	}
	
	/**
	 * Calendar
	 * 
	 * @return
	 *
	 */
	public static Calendar calendar(Calendar cal){
		return null != cal ? cal : currentCal();
	}	
	
	/**
	 * 当前日期
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Date currentDate() {
		return calendar(null).getTime();
	}
	
	/**
	 * 当前日期
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Date currentDate(Calendar cal) {
		return calendar(cal).getTime();
	}
	
	/**
	 * 年份
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Integer currentYear(Calendar cal) {
		return calendar(cal).get(Calendar.YEAR);
	}	
	
	/**
	 * 月份
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Integer currentMonth(Calendar cal) {
		return calendar(cal).get(Calendar.MONTH) + 1;
	}
	
	/**
	 * 几号
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Integer currentDayOfMonth(Calendar cal) {
		return calendar(cal).get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * 小时
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Integer currentHour(Calendar cal) {
		return calendar(cal).get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * 分钟
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Integer currentMinute(Calendar cal) {
		return calendar(cal).get(Calendar.MINUTE);
	}
	
	/**
	 * 秒数
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Integer currentSecond(Calendar cal) {
		return calendar(cal).get(Calendar.SECOND);
	}
	
	/**
	 * 当前毫秒数
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Integer currentMilliSecond(Calendar cal){
		return calendar(cal).get(Calendar.MILLISECOND);
	}	
	
	/**
	 * 长毫秒数
	 * 
	 * @param cal
	 * @return
	 *
	 */
	public static Long currentMilliLong(Calendar cal){
		return currentDate(cal).getTime();
	}
}
