package com.shine.condition.ims;

import com.shine.core.utils.page.Page;
import com.shine.entity.ims.Application;

public class ApplicationCondition extends Page<Application> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
	private String name;
	private String code;
	private String basePath;
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBasePath() {
		return basePath;
	}
	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
