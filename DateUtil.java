public class DateUtil{
	
	/**
	* 日期加减法
	* @param date 日期
	* @param unit 单位，YEAR:年，MONTH：月...
	* @param count 加减数字，正数加，负数减
	* @return 日期
	*/
	public Date dateAddOrMinus(Date date,String unit,int count){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if("YEAR".equals(unit){
			cal.add(Calendar.YEAR,count);
			date = cal.getTime();
			return;
		}
		if("MONTH".equals(unit){
			cal.add(Calendar.MONTH,count);
			date = cal.getTime();
			return;
		}
		if("DAY".equals(unit){
			cal.add(Calendar.DAY_OF_YEAR,count);
			date = cal.getTime();
			return;
		}
		if("HOUR".equals(unit){
			cal.add(Calendar.HOUR_OF_DAY,count);
			date = cal.getTime();
			return;
		}
		if("MINUTE".equals(unit){
			cal.add(Calendar.MINUTE,count);
			date = cal.getTime();
			return;
		}
		return null;
	}
}