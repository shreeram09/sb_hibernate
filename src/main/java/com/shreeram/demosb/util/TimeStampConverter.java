package com.shreeram.demosb.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.jsefa.common.converter.SimpleTypeConverter;

public class TimeStampConverter implements SimpleTypeConverter {
	private static final TimeStampConverter INSTANCE = new TimeStampConverter();
	
	private TimeStampConverter() {}
	
	public static TimeStampConverter create() {
		return INSTANCE;
	}

	@Override
	public String toString(Object value) {
		String dateStr = "";
		if(value!=null) {
			Timestamp tstmp = (Timestamp) value;
			Date d1 = new Date(tstmp.getTime());
			dateStr = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(d1);
			return value.toString();
		}
		return dateStr;
	}

	@Override
	public Object fromString(String value) {
		Timestamp tstmp = null;
		
		try {
			Date dt= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(value);
			tstmp = new Timestamp(dt.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return tstmp;
	}

}
