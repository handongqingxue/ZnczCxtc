package com.znczCxtc.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczCxtc.dao.*;
import com.znczCxtc.service.*;

@Service
public class CheLiangShenHeJiLuServiceImpl implements CheLiangShenHeJiLuService {

	@Autowired
	private CheLiangMapper cheLiangDao;
}
