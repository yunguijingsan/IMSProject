package com.shine.view.service.ims.impl;

//import com.shine.view.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
//import com.shine.core.utils.common.CommonUtils;
import org.springframework.stereotype.Service;

import com.shine.condition.ims.UrlCondition;
import com.shine.core.exception.ServiceException;
import com.shine.core.utils.page.Page;
import com.shine.dao.ims.GroupUrlDao;
//import org.apache.log4j.Logger;
import com.shine.dao.ims.UrlDao;
import com.shine.entity.ims.Url;
import com.shine.view.service.ims.UrlService;

@Service
public class UrlServiceImpl implements UrlService {
	// private static Logger logger = Logger.getLogger(UrlServiceImpl.class);

	@Autowired
	private UrlDao urlDao;
	
	@Autowired
	private GroupUrlDao groupUrlDao;

	public void addUrl(Url url) {
		validate(url);
		urlDao.addUrl(url);
		processGroupUrl(url);
	}

	private void processGroupUrl(Url url) {
		if(url.getGroupUrl() != null && url.getGroupUrl().getGroupId() !=null){
			if(url.getGroupUrl().getId() == null){
				url.getGroupUrl().setUrlId(url.getId());
				groupUrlDao.addGroupUrl(url.getGroupUrl());	
			}else{
				groupUrlDao.updateGroupUrl(url.getGroupUrl());
			}
		}
	}

	public Url findUrlById(Integer id) {
		validateId(id);
		Url url;
		url = urlDao.findUrlById(id);
		return url;
	}

	public void updateUrl(Url url) {
		validateId(url.getId());
		validate(url);
		urlDao.updateUrl(url);
		this.processGroupUrl(url);
	}

	public Page<Url> searchUrl(UrlCondition urlCondition) {
		urlCondition.setData(urlDao.searchUrl(urlCondition));
		return urlCondition;
	}

	private void validate(Url url) {
		if (url == null) {
			throw ServiceException.create("URL.IS.NULL");
		}
	}

	private void validateId(Integer id) {
		if (id == null) {
			throw ServiceException.create("URL.ID.IS.NULL");
		}
	}
}