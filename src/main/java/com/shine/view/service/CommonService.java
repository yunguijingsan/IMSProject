package com.shine.view.service;

import java.util.List;

import com.shine.entity.ims.ext.Functions;

public interface CommonService {
	public List<Functions> getRequestMappingInfo(List<String> controllerNames);
}
