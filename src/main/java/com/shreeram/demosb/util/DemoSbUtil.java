package com.shreeram.demosb.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public interface DemoSbUtil {
	String CSV_FILE_PATH = "C:\\Users\\shreeram\\Downloads\\";
	String DB_PASSWORD = "postgres";

	static Date localDateToDate(LocalDate dt) {
		return Date.from(dt.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public static String getStackTrace(final Throwable throwable) {
		final StringWriter sw = new StringWriter();
		final PrintWriter pw = new PrintWriter(sw, true);
		throwable.printStackTrace(pw);
		return sw.getBuffer().toString();
	}
}
