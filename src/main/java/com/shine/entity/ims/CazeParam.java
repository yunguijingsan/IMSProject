package com.shine.entity.ims;

import java.io.Serializable;

public class CazeParam implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
    private Integer paramDefId;
    private Integer cazeId;
    private String value;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getParamDefId() {
		return paramDefId;
	}
	public void setParamDefId(Integer paramDefId) {
		this.paramDefId = paramDefId;
	}
	public Integer getCazeId() {
		return cazeId;
	}
	public void setCazeId(Integer cazeId) {
		this.cazeId = cazeId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
    
    
}
