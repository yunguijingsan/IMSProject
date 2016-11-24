package com.shine.condition.ims;

import com.shine.core.utils.page.Page;
import com.shine.entity.ims.Caze;

public class CazeCondition extends Page<Caze> {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String expectation;
    private String result;
    private String description;
    private Integer urlId;
    private String params;

	public Integer getUrlId() {
		return urlId;
	}
	public void setUrlId(Integer urlId) {
		this.urlId = urlId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpectation() {
		return expectation;
	}
	public void setExpectation(String expectation) {
		this.expectation = expectation;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
}
