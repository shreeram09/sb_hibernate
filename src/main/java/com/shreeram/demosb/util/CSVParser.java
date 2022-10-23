package com.shreeram.demosb.util;

import java.io.Reader;
import java.io.Writer;
import java.sql.Timestamp;

import net.sf.jsefa.csv.CsvDeserializer;
import net.sf.jsefa.csv.CsvIOFactory;
import net.sf.jsefa.csv.CsvSerializer;
import net.sf.jsefa.csv.config.CsvConfiguration;

public class CSVParser {

	private CsvConfiguration initializedConfiguration(char delimiter) {
		CsvConfiguration config = new CsvConfiguration();
		config.setFieldDelimiter(delimiter);
		config.getSimpleTypeConverterProvider().registerConverterType(short.class, ShortConverter.class);
		config.getSimpleTypeConverterProvider().registerConverterType(Short.class, ShortConverter.class);
		config.getSimpleTypeConverterProvider().registerConverterType(double.class, DoubleConverter.class);
		config.getSimpleTypeConverterProvider().registerConverterType(Double.class, DoubleConverter.class);
		config.getSimpleTypeConverterProvider().registerConverterType(Timestamp.class, TimeStampConverter.class);
		return config;
	}
	
	public CsvSerializer transformationObjectToCSV(Class c,Object o,char delimeter,Writer writer) {
		CsvConfiguration config=initializedConfiguration(delimeter);
		CsvSerializer serializer = CsvIOFactory.createFactory(config,c).createSerializer();
		serializer.open(writer);
		serializer.write(o);
		serializer.flush();
		return serializer;
	}
	
	public CsvDeserializer transormationCSVToObject(Class c , char delimeter, Reader reader) {
		CsvConfiguration config=initializedConfiguration(delimeter);
		CsvDeserializer deserializer = CsvIOFactory.createFactory(config,c).createDeserializer();
		deserializer.open(reader);
		return deserializer;
	}
}
