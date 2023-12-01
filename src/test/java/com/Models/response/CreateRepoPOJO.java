package com.Models.response;

import java.util.LinkedHashMap;
import java.util.Map;

public class CreateRepoPOJO {
	private String name;
	private String description;
	private String homepage;
	private String _private;
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	public String getName() {
	return name;
	}

	public void setName(String name) {
	this.name = name;
	}

	public String getDescription() {
	return description;
	}

	public void setDescription(String description) {
	this.description = description;
	}

	public String getHomepage() {
	return homepage;
	}

	public void setHomepage(String homepage) {
	this.homepage = homepage;
	}

	public String getPrivate() {
	return _private;
	}

	public void setPrivate(String _private) {
	this._private = _private;
	}

	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
}
