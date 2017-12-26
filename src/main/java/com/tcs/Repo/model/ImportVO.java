
package com.tcs.Repo.model;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class ImportVO {
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
	@Override
	public String toString() {
		return "ImportVO [tower=" + tower + ", project=" + project + ", won_type=" + won_type + ", offsite_location="
				+ offsite_location + ", service_line=" + service_line + ", sub_sp=" + sub_sp + ", project_type="
				+ project_type + ", brm_name=" + brm_name + ", updt_id=" + updt_id + ", rate=" + rate + ", rec_key="
				+ rec_key + ", won_number=" + won_number + ", probability=" + probability + ", updt_ts=" + updt_ts
				+ "]";
	}

//	private String Tower,Project,Won_type,Offsite_Location,Service_Line,Sub_Sp,Project_Type,Brm_Name,updt_id;
//	private Double Rate;
//	private BigInteger Rec_key, Won_number,	Probability;
//	private Timestamp updt_ts;
//	private String offsite_location;
//
//	
//	@Override
//	public String toString() {
//		return "ImportVO [Tower=" + Tower + ", Project=" + Project + ", Won_type=" + Won_type + ", Offsite_Location="
//				+ Offsite_Location + ", Service_Line=" + Service_Line + ", Sub_Sp=" + Sub_Sp + ", Project_Type="
//				+ Project_Type + ", Brm_Name=" + Brm_Name + ", updt_id=" + updt_id + ", Rate=" + Rate + ", Rec_key="
//				+ Rec_key + ", Won_number=" + Won_number + ", Probability=" + Probability + ", updt_ts=" + updt_ts
//				+ "]";
//	}
//
//
//	public String getTower() {
//		return Tower;
//	}
//	public void setTower(String tower) {
//		Tower = tower;
//	}
//	public String getProject() {
//		return Project;
//	}
//	public void setProject(String project) {
//		Project = project;
//	}
//	public String getWon_type() {
//		return Won_type;
//	}
//	public void setWon_type(String won_type) {
//		Won_type = won_type;
//	}
//	public String getOffsite_Location() {
//		return Offsite_Location;
//	}
//	public void setOffsite_Location(String offsite_Location) {
//		Offsite_Location = offsite_Location;
//	}
//	public String getService_Line() {
//		return Service_Line;
//	}
//	public void setService_Line(String service_Line) {
//		Service_Line = service_Line;
//	}
//	public String getSub_Sp() {
//		return Sub_Sp;
//	}
//	public void setSub_Sp(String sub_Sp) {
//		Sub_Sp = sub_Sp;
//	}
//	public String getProject_Type() {
//		return Project_Type;
//	}
//	public void setProject_Type(String project_Type) {
//		Project_Type = project_Type;
//	}
//	public String getBrm_Name() {
//		return Brm_Name;
//	}
//	public void setBrm_Name(String brm_Name) {
//		Brm_Name = brm_Name;
//	}
//	public String getUpdt_id() {
//		return updt_id;
//	}
//	public void setUpdt_id(String updt_id) {
//		this.updt_id = updt_id;
//	}
//	public Double getRate() {
//		return Rate;
//	}
//	public void setRate(Double rate) {
//		Rate = rate;
//	}
//	public BigInteger getRec_key() {
//		return Rec_key;
//	}
//	public void setRec_key(BigInteger rec_key) {
//		Rec_key = rec_key;
//	}
//	public BigInteger getWon_number() {
//		return Won_number;
//	}
//	public void setWon_number(BigInteger won_number) {
//		Won_number = won_number;
//	}
//	public BigInteger getProbability() {
//		return Probability;
//	}
//	public void setProbability(BigInteger probability) {
//		Probability = probability;
//	}
//	public Timestamp getUpdt_ts() {
//		return updt_ts;
//	}
//	public void setUpdt_ts(Timestamp updt_ts) {
//		this.updt_ts = updt_ts;
//	}
//
//
//	public String getOffsite_location() {
//		return offsite_location;
//	}
//
//
//	public void setOffsite_location(String offsite_location) {
//		this.offsite_location = offsite_location;
//	}
//


	
}
