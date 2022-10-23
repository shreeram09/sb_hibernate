package com.shreeram.demosb.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shreeram.demosb.dao.DemoSbDao;
import com.shreeram.demosb.model.ResultBean;
import com.shreeram.demosb.model.TabScheduleSlots;
import com.shreeram.demosb.util.CSVParser;
import com.shreeram.demosb.util.DemoSbUtil;

import net.sf.jsefa.csv.CsvDeserializer;
import net.sf.jsefa.csv.CsvSerializer;

@Service
public class DemoSbServiceImpl implements DemoSbService {

	@Autowired
	private DemoSbDao<TabScheduleSlots, Long> tabDAO;

	@Transactional
	public List<TabScheduleSlots> getTabScheduleSlot(String queryId, String date, boolean isModelObj) {
		Map<String, Object> queryParamMap = new HashMap<String, Object>();
		if (isModelObj) {
			Date dt = DemoSbUtil.localDateToDate(LocalDate.parse(date, DateTimeFormatter.ISO_DATE));
			queryParamMap.put("ttsTcmTstDt",dt);
		}
		return (List<TabScheduleSlots>) tabDAO.findVOByNamedQuery(TabScheduleSlots.class, queryId, queryParamMap);
	}

	@Override
	public void exportSlotsToCSV(String queryId, String date, boolean isModelObj) {
		List<TabScheduleSlots> list = getTabScheduleSlot( queryId, date, isModelObj);
		ResultBean rs = new ResultBean();
		rs.setTsslst(list);
		writeContentToCSV(rs);
		
	}
	
	@Override
	public void importSlotsToDB(String queryId, String date, boolean isModelObj) {
		File file = new File(DemoSbUtil.CSV_FILE_PATH+"result.csv");
		ResultBean rb = readContentFromCSV(file);
		List<TabScheduleSlots> tsslst = rb.getTsslst();
		if(tsslst!=null && tsslst.size()>0) {
			for(TabScheduleSlots tss:tsslst) {
				tabDAO.merge(tss);
			}
		}
	}

	private void writeContentToCSV(ResultBean rs) {
		CSVParser parser = new CSVParser();
		CsvSerializer serializer=null;
		Writer writer=null;
		try {
			String csvFilePath = DemoSbUtil.CSV_FILE_PATH+"result.csv";
			writer = new FileWriter(csvFilePath);
			serializer = parser.transformationObjectToCSV(rs.getClass(), csvFilePath, ',', writer);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private ResultBean readContentFromCSV(File file) {
		ResultBean bean  = null;
		CSVParser parser = new CSVParser();
		try {
			Reader reader = new InputStreamReader(new FileInputStream(file));
			CsvDeserializer deserializer  = parser.transormationCSVToObject(bean.getClass(), ',', reader);
			while(deserializer.hasNext()) {
				bean=deserializer.next();
			}
			deserializer.close(true);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	
}
