package com.shreeram.demosb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.shreeram.demosb.util.QueryName;

@Entity
@Table(name = "tab_schedule_slots")
@NamedQueries({
	@NamedQuery(name=QueryName.NAME_GETTABSHEDULESLOTS,query = QueryName.QUERY_GETTABSHEDULESLOTS)
})
public class TabScheduleSlots implements Serializable {
	private Long ttsSrNo;
	private Date ttsTcmTstDt;
	private String ttsTcmTstTm;
	private Long ttsClientId;
	private Timestamp ttsCrteDt;
	private String ttsCrtrBy;
	private Timestamp ttsUpdtDt;
	private String ttsUpdtBy;
	private String defaultFlag;
	private BigDecimal ttsAvalSeats;
	private BigDecimal ttsExamDuration;
	private Timestamp ttsStartTime;
	private Timestamp ttsEndTime;
	private String lableForTabShedule;
	private BigDecimal ttsStartMin;
	private BigDecimal ttsEndMin;
	
	public TabScheduleSlots() {}
	public TabScheduleSlots(Long ttsSrNo, Date ttsTcmTstDt, String ttsTcmTstTm) {
		this.ttsSrNo = ttsSrNo;
		this.ttsTcmTstDt = ttsTcmTstDt;
		this.ttsTcmTstTm = ttsTcmTstTm;
	}
	public TabScheduleSlots(Long ttsSrNo, 
			 Date ttsTcmTstDt, String ttsTcmTstTm,
			Long ttsClientId, Timestamp ttsCrteDt, String ttsCrtrBy,
			Timestamp ttsUpdtDt, String ttsUpdtBy, String defaultFlag,
			BigDecimal ttsAvalSeats, BigDecimal ttsExamDuration,
			Timestamp ttsStartTime, Timestamp ttsEndTime) {
		this.ttsSrNo = ttsSrNo;
		this.ttsTcmTstDt = ttsTcmTstDt;
		this.ttsTcmTstTm = ttsTcmTstTm;
		this.ttsClientId = ttsClientId;
		this.ttsCrteDt = ttsCrteDt;
		this.ttsCrtrBy = ttsCrtrBy;
		this.ttsUpdtDt = ttsUpdtDt;
		this.ttsUpdtBy = ttsUpdtBy;
		this.defaultFlag = defaultFlag;
		this.ttsAvalSeats = ttsAvalSeats;
		this.ttsExamDuration = ttsExamDuration;
		this.ttsStartTime = ttsStartTime;
		this.ttsEndTime = ttsEndTime;
	}

	@Id
	@Column(name = "tts_sr_no", unique = true, nullable = false, precision = 16, scale = 0)
	public Long getTtsSrNo() {
		return this.ttsSrNo;
	}

	public void setTtsSrNo(Long ttsSrNo) {
		this.ttsSrNo = ttsSrNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "tts_tcm_tst_dt", nullable = false, length = 13)
	public Date getTtsTcmTstDt() {
		return this.ttsTcmTstDt;
	}

	public void setTtsTcmTstDt(Date ttsTcmTstDt) {
		this.ttsTcmTstDt = ttsTcmTstDt;
	}

	@Column(name = "tts_tcm_tst_tm", nullable = false, length = 20)
	public String getTtsTcmTstTm() {
		return this.ttsTcmTstTm;
	}

	public void setTtsTcmTstTm(String ttsTcmTstTm) {
		this.ttsTcmTstTm = ttsTcmTstTm;
	}

	@Column(name = "tts_client_id", precision = 16, scale = 0)
	public Long getTtsClientId() {
		return this.ttsClientId;
	}

	public void setTtsClientId(Long ttsClientId) {
		this.ttsClientId = ttsClientId;
	}

	@Column(name = "tts_crte_dt", length = 25)
	public Timestamp getTtsCrteDt() {
		return this.ttsCrteDt;
	}

	public void setTtsCrteDt(Timestamp ttsCrteDt) {
		this.ttsCrteDt = ttsCrteDt;
	}

	@Column(name = "tts_crtr_by", length = 20)
	public String getTtsCrtrBy() {
		return this.ttsCrtrBy;
	}

	public void setTtsCrtrBy(String ttsCrtrBy) {
		this.ttsCrtrBy = ttsCrtrBy;
	}

	@Column(name = "tts_updt_dt", length = 25)
	public Timestamp getTtsUpdtDt() {
		return this.ttsUpdtDt;
	}

	public void setTtsUpdtDt(Timestamp ttsUpdtDt) {
		this.ttsUpdtDt = ttsUpdtDt;
	}

	@Column(name = "tts_updt_by", length = 20)
	public String getTtsUpdtBy() {
		return this.ttsUpdtBy;
	}

	public void setTtsUpdtBy(String ttsUpdtBy) {
		this.ttsUpdtBy = ttsUpdtBy;
	}

	@Column(name = "default_flag", length = 1)
	public String getDefaultFlag() {
		return this.defaultFlag;
	}

	public void setDefaultFlag(String defaultFlag) {
		this.defaultFlag = defaultFlag;
	}

	@Column(name = "tts_aval_seats", precision = 38, scale = 0)
	public BigDecimal getTtsAvalSeats() {
		return this.ttsAvalSeats;
	}

	public void setTtsAvalSeats(BigDecimal ttsAvalSeats) {
		this.ttsAvalSeats = ttsAvalSeats;
	}

	@Column(name = "tts_exam_duration", precision = 38, scale = 0)
	public BigDecimal getTtsExamDuration() {
		return this.ttsExamDuration;
	}

	public void setTtsExamDuration(BigDecimal ttsExamDuration) {
		this.ttsExamDuration = ttsExamDuration;
	}

	@Column(name = "tts_start_time", length = 25)
	public Timestamp getTtsStartTime() {
		return this.ttsStartTime;
	}

	public void setTtsStartTime(Timestamp ttsStartTime) {
		this.ttsStartTime = ttsStartTime;
	}

	@Column(name = "tts_end_time", length = 25)
	public Timestamp getTtsEndTime() {
		return this.ttsEndTime;
	}

	public void setTtsEndTime(Timestamp ttsEndTime) {
		this.ttsEndTime = ttsEndTime;
	}
	
    @Transient
	public String getLableForTabShedule() {
    	
    	String dateValue =this.ttsTcmTstTm;
    	setLableForTabShedule(dateValue);
    	return lableForTabShedule;
	}

	public void setLableForTabShedule(String lableForTabShedule) {
		this.lableForTabShedule = lableForTabShedule;
	}

	@Column(name = "tts_start_min", precision = 131089, scale = 0)
	public BigDecimal getTtsStartMin() {
		return this.ttsStartMin;
	}

	public void setTtsStartMin(BigDecimal ttsStartMin) {
		this.ttsStartMin = ttsStartMin;
	}

	@Column(name = "tts_end_min", precision = 131089, scale = 0)
	public BigDecimal getTtsEndMin() {
		return this.ttsEndMin;
	}

	public void setTtsEndMin(BigDecimal ttsEndMin) {
		this.ttsEndMin = ttsEndMin;
	}


}
