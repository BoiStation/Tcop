package com.tcop.dao.impl;

import com.tcop.dao.AdDao;
import com.tcop.entity.Ad;
import org.springframework.stereotype.Repository;

@Repository("adDaoImpl")
public class AdDaoImpl extends BaseDaoImpl<Ad, Long> implements AdDao{
	
}