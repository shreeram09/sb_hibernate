package com.shreeram.demosb.util;

public interface QueryName {
	String NAME_GETTABSHEDULESLOTS="tabScheduleSlotsId";
	String QUERY_GETTABSHEDULESLOTS="FROM TabScheduleSlots mdl where  mdl.ttsTcmTstDt between :ttsTcmTstDt and :ttsTcmTstDt order by mdl.ttsTcmTstTm asc";
}
