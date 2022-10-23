package com.shreeram.demosb.util;

import net.sf.jsefa.common.converter.SimpleTypeConverter;

public class DoubleConverter implements SimpleTypeConverter {
	private static final DoubleConverter INSTANCE = new DoubleConverter();
	
	private DoubleConverter() {}
	
	public static DoubleConverter create() {
		return INSTANCE;
	}

	@Override
	public String toString(Object value) {
		if(value!=null) {
			return value.toString();
		}
		return null;
	}

	@Override
	public Object fromString(String value) {
		Double s = null;
		if(value!=null) {
			s=Double.valueOf(value);
		}
		return s;
	}

}
