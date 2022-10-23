package com.shreeram.demosb.service;

import java.util.List;

import com.shreeram.demosb.model.TabScheduleSlots;

public interface DemoSbService {
	public List<TabScheduleSlots> getTabScheduleSlot(String queryId,String date,boolean isModelObj);

	public void exportSlotsToCSV(String queryId, String date, boolean isModelObj);
	
	public void importSlotsToDB(String queryId,String date,boolean isModelObj);
	
}
