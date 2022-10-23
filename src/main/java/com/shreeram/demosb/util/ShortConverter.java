package com.shreeram.demosb.util;

import net.sf.jsefa.common.converter.SimpleTypeConverter;

public class ShortConverter implements SimpleTypeConverter {
	private static final ShortConverter INSTANCE = new ShortConverter();
	
	private ShortConverter() {}
	
	public static ShortConverter create() {
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
		Short s = null;
		if(value!=null) {
			s=Short.valueOf(value);
		}
		return s;
	}

}
