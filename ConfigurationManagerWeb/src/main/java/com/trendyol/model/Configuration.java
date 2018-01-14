package com.trendyol.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "configs")
public class Configuration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 465532586020871962L;
	@Id
	private Long id;
	private String name;
	private String type;
	private String value;
	private Integer active;
	private String applicationName;

	public Configuration() {

	}

	public Configuration(String name, String type, String value, Integer active, String applicationName) {
		this.name = name;
		this.type = type;
		this.value = value;
		this.active = active;
		this.applicationName = applicationName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer isActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

}
