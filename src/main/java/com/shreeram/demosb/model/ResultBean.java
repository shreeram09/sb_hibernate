package com.shreeram.demosb.model;

import java.util.List;

import net.sf.jsefa.csv.annotation.CsvDataType;
import net.sf.jsefa.csv.annotation.CsvSubRecordList;
import net.sf.jsefa.rbf.annotation.Record;

@CsvDataType(defaultPrefix = "result")
public class ResultBean {

	@CsvSubRecordList(pos=1,records = {@Record(prefix="tabsst",objectType = TabScheduleSlots.class)})
	private List<TabScheduleSlots> tsslst;

	public List<TabScheduleSlots> getTsslst() {
		return tsslst;
	}

	public void setTsslst(List<TabScheduleSlots> tsslst) {
		this.tsslst = tsslst;
	}

}
