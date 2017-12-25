package com.tcs.Repo.model;

import java.math.BigInteger;
import java.sql.Timestamp;

public class MasterVO {
	
	private String tower,project,won_type,offsite_location,service_line,sub_sp,project_type,brm_name,updt_id;
	private Double rate;
	private BigInteger rec_key, won_number,	probability;
	private Timestamp updt_ts;
	public String getTower() {
		return tower;
	}
	public void setTower(String tower) {
		this.tower = tower;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getWon_type() {
		return won_type;
	}
	public void setWon_type(String won_type) {
		this.won_type = won_type;
	}
	public String getOffsite_location() {
		return offsite_location;
	}
	public void setOffsite_location(String offsite_location) {
		this.offsite_location = offsite_location;
	}
	public String getService_line() {
		return service_line;
	}
	public void setService_line(String service_line) {
		this.service_line = service_line;
	}
	public String getSub_sp() {
		return sub_sp;
	}
	public void setSub_sp(String sub_sp) {
		this.sub_sp = sub_sp;
	}
	public String getProject_type() {
		return project_type;
	}
	public void setProject_type(String project_type) {
		this.project_type = project_type;
	}
	public String getBrm_name() {
		return brm_name;
	}
	public void setBrm_name(String brm_name) {
		this.brm_name = brm_name;
	}
	public String getUpdt_id() {
		return updt_id;
	}
	public void setUpdt_id(String updt_id) {
		this.updt_id = updt_id;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public BigInteger getRec_key() {
		return rec_key;
	}
	public void setRec_key(BigInteger rec_key) {
		this.rec_key = rec_key;
	}
	public BigInteger getWon_number() {
		return won_number;
	}
	public void setWon_number(BigInteger won_number) {
		this.won_number = won_number;
	}
	public BigInteger getProbability() {
		return probability;
	}
	public void setProbability(BigInteger probability) {
		this.probability = probability;
	}
	public Timestamp getUpdt_ts() {
		return updt_ts;
	}
	public void setUpdt_ts(Timestamp updt_ts) {
		this.updt_ts = updt_ts;
	}
	
}
