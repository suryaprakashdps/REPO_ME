package com.tcs.Repo.model;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ProjectionVO {
	
	private String tower, project, won_type, month, Year ,updt_user;
	private Double revenue,rate;
	private Integer resource_count;
	private BigInteger rec_key, Holiday_count,won_number ;
	private Timestamp updt_ts;
	private Date startdt , enddt;
	private List projrate;
	public Date getStartdt() {
		return startdt;
	}
	public void setStartdt(Date startdt) {
		this.startdt = startdt;
	}
	public Date getEnddt() {
		return enddt;
	}
	public void setEnddt(Date enddt) {
		this.enddt = enddt;
	}
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
	public BigInteger getWon_number() {
		return won_number;
	}
	public void setWon_number(BigInteger won_number) {
		this.won_number = won_number;
	}
	public String getWon_type() {
		return won_type;
	}
	public void setWon_type(String won_type) {
		this.won_type = won_type;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getUpdt_user() {
		return updt_user;
	}
	public void setUpdt_user(String updt_user) {
		this.updt_user = updt_user;
	}
	public Double getRevenue() {
		return revenue;
	}
	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}
	public BigInteger getRec_key() {
		return rec_key;
	}
	public void setRec_key(BigInteger rec_key) {
		this.rec_key = rec_key;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String string) {
		this.Year = string;
	}
	public Integer getResource_count() {
		return resource_count;
	}
	public void setResource_count(Integer resource_count) {
		this.resource_count = resource_count;
	}
	public BigInteger getHoliday_count() {
		return Holiday_count;
	}
	public void setHoliday_count(BigInteger holiday_count) {
		Holiday_count = holiday_count;
	}
	public Timestamp getUpdt_ts() {
		return updt_ts;
	}
	public void setUpdt_ts(Timestamp updt_ts) {
		this.updt_ts = updt_ts;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public List getProjrate() {
		return projrate;
	}
	public void setProjrate(List projrate) {
		this.projrate = projrate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Holiday_count == null) ? 0 : Holiday_count.hashCode());
		result = prime * result + ((Year == null) ? 0 : Year.hashCode());
		result = prime * result + ((enddt == null) ? 0 : enddt.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((projrate == null) ? 0 : projrate.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		result = prime * result + ((rec_key == null) ? 0 : rec_key.hashCode());
		result = prime * result + ((resource_count == null) ? 0 : resource_count.hashCode());
		result = prime * result + ((revenue == null) ? 0 : revenue.hashCode());
		result = prime * result + ((startdt == null) ? 0 : startdt.hashCode());
		result = prime * result + ((tower == null) ? 0 : tower.hashCode());
		result = prime * result + ((updt_ts == null) ? 0 : updt_ts.hashCode());
		result = prime * result + ((updt_user == null) ? 0 : updt_user.hashCode());
		result = prime * result + ((won_number == null) ? 0 : won_number.hashCode());
		result = prime * result + ((won_type == null) ? 0 : won_type.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectionVO other = (ProjectionVO) obj;
		if (Holiday_count == null) {
			if (other.Holiday_count != null)
				return false;
		} else if (!Holiday_count.equals(other.Holiday_count))
			return false;
		if (Year == null) {
			if (other.Year != null)
				return false;
		} else if (!Year.equals(other.Year))
			return false;
		if (enddt == null) {
			if (other.enddt != null)
				return false;
		} else if (!enddt.equals(other.enddt))
			return false;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (projrate == null) {
			if (other.projrate != null)
				return false;
		} else if (!projrate.equals(other.projrate))
			return false;
		if (rate == null) {
			if (other.rate != null)
				return false;
		} else if (!rate.equals(other.rate))
			return false;
		if (rec_key == null) {
			if (other.rec_key != null)
				return false;
		} else if (!rec_key.equals(other.rec_key))
			return false;
		if (resource_count == null) {
			if (other.resource_count != null)
				return false;
		} else if (!resource_count.equals(other.resource_count))
			return false;
		if (revenue == null) {
			if (other.revenue != null)
				return false;
		} else if (!revenue.equals(other.revenue))
			return false;
		if (startdt == null) {
			if (other.startdt != null)
				return false;
		} else if (!startdt.equals(other.startdt))
			return false;
		if (tower == null) {
			if (other.tower != null)
				return false;
		} else if (!tower.equals(other.tower))
			return false;
		if (updt_ts == null) {
			if (other.updt_ts != null)
				return false;
		} else if (!updt_ts.equals(other.updt_ts))
			return false;
		if (updt_user == null) {
			if (other.updt_user != null)
				return false;
		} else if (!updt_user.equals(other.updt_user))
			return false;
		if (won_number == null) {
			if (other.won_number != null)
				return false;
		} else if (!won_number.equals(other.won_number))
			return false;
		if (won_type == null) {
			if (other.won_type != null)
				return false;
		} else if (!won_type.equals(other.won_type))
			return false;
		return true;
	}
	
	
	
	
}
