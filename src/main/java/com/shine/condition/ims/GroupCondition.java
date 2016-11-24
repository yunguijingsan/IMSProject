package com.shine.condition.ims;

import com.shine.core.utils.page.Page;
import com.shine.entity.ims.Group;

public class GroupCondition extends Page<Group> {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String description;
    
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
    
    
}
