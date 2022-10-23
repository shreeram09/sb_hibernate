package com.shreeram.demosb.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shreeram.demosb.service.DemoSbService;
import com.shreeram.demosb.util.QueryName;

@RestController
public class DemoSbController {
	private static final Logger log=LogManager.getLogger(DemoSbController.class);
	
	@Autowired
	private DemoSbService dss;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome() {
		return ResponseEntity.ok("Welcome To demo !");
	}

	@GetMapping("/slots/{dt}")
	public ResponseEntity<?> getTestScheduleSlots(@PathVariable String dt){
		log.info("date:{}", dt);
		List<?> list = dss.getTabScheduleSlot(QueryName.NAME_GETTABSHEDULESLOTS,dt, (dt!=null && !"".equals(dt)));
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/slots/exportCSV/{dt}")
	public ResponseEntity<?> getSlotsCSV(@PathVariable String dt){
		log.info("date:{}", dt);
		dss.exportSlotsToCSV(QueryName.NAME_GETTABSHEDULESLOTS,dt, (dt!=null && !"".equals(dt)));
		return ResponseEntity.ok("success");
	}
}
