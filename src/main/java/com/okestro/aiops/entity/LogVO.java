package com.okestro.aiops.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="log")
public class LogVO {
	@Id // pk
	private String id;
	
	private String filePath;
	
	private String message;
	
	private String logDate;
	
	private String instanceName;
	
	private String availabilityZone;
	
	private String machineType;
	
	private String provider;
	
	private String hostId;
	
	private String hostname;
	
	private String agentType;
	
	private String program;
	
	public LogVO() {
		// TODO Auto-generated constructor stub
	}

	public LogVO(String id, String filePath, String message, String logDate, String instanceName,
			String availabilityZone, String machineType, String provider, String hostId, String hostname,
			String agentType, String program) {
		super();
		this.id = id;
		this.filePath = filePath;
		this.message = message;
		this.logDate = logDate;
		this.instanceName = instanceName;
		this.availabilityZone = availabilityZone;
		this.machineType = machineType;
		this.provider = provider;
		this.hostId = hostId;
		this.hostname = hostname;
		this.agentType = agentType;
		this.program = program;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLogDate() {
		return logDate;
	}

	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getAvailabilityZone() {
		return availabilityZone;
	}

	public void setAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
	}

	public String getMachineType() {
		return machineType;
	}

	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getHostId() {
		return hostId;
	}

	public void setHostId(String hostId) {
		this.hostId = hostId;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getAgentType() {
		return agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

}