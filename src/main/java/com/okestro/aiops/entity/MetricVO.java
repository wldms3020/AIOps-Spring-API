package com.okestro.aiops.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="metric")
public class MetricVO {
	@Id // pk
	private String id;
	
	private String hostname;
	
	private String datetime;
	
	private String resourceType;
	
	private String metricType;
	
	private BigDecimal value;
	
	private String unit;
	
	public MetricVO() {
		// TODO Auto-generated constructor stub
	}

	public MetricVO(String id, String hostname, String datetime, String resourceType, String metricType, BigDecimal value,
			String unit) {
		super();
		this.id = id;
		this.hostname = hostname;
		this.datetime = datetime;
		this.resourceType = resourceType;
		this.metricType = metricType;
		this.value = value;
		this.unit = unit;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getMetricType() {
		return metricType;
	}

	public void setMetricType(String dataType) {
		this.metricType = dataType;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}